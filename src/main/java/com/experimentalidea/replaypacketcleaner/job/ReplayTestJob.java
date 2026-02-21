/*
 * Copyright 2025 ExperimentalIdea
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * */
package com.experimentalidea.replaypacketcleaner.job;

import com.experimentalidea.replaypacketcleaner.Log;
import com.experimentalidea.replaypacketcleaner.ReplayPacketCleaner;
import com.experimentalidea.replaypacketcleaner.config.Configuration;
import com.experimentalidea.replaypacketcleaner.config.Option;
import com.experimentalidea.replaypacketcleaner.job.listener.*;
import com.experimentalidea.replaypacketcleaner.packet.listener.PacketListener;
import com.experimentalidea.replaypacketcleaner.protocol.PacketType;
import com.experimentalidea.replaypacketcleaner.protocol.Protocol;
import com.experimentalidea.replaypacketcleaner.protocol.ProtocolDirectory;
import com.experimentalidea.replaypacketcleaner.protocol.Version;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/// For testing that rpc is parsing replay data correctly.
/// TODO: Cleanup or replace with something else. Contains a lot of copy/pasted code from elsewhere in rpc. Probably a better way to do this... Just wanted to get something working for now.
public class ReplayTestJob extends ReplayJob {


    /**
     * NOTE: if source file is located inside the workingDir, it will be deleted when task is done executing.
     * workingDir should be an uuid, as a collision is effectively impossible.
     * workingDir is deleted when the task completes
     */
    public ReplayTestJob(int jobNumber, Replay replay, File workingTmpDir, File exportDir, ProtocolDirectory protocolDirectory, boolean asyncReads, boolean asyncWrites) {
        super(jobNumber, replay, workingTmpDir, exportDir, protocolDirectory, asyncReads, asyncWrites);

        this.sourceFile = replay.getSourceFile();
        this.exportDir = replay.getExportDirectory();
        Objects.requireNonNull(this.exportDir, "exportDir within Replay object cannot be null");

        this.configuration = replay.getConfiguration();
        Objects.requireNonNull(this.configuration, "configuration within Replay object cannot be null");

        this.workingTmpDir = workingTmpDir;
        this.targetExportFile = new File(this.workingTmpDir, this.sourceFile.getName().replaceAll(ReplayPacketCleaner.DOT_MCPR_EXTENSION, "") + " (RPC)" + ReplayPacketCleaner.DOT_MCPR_EXTENSION);

        this.protocolDirectory = protocolDirectory;
        this.asyncReads = asyncReads;
        this.asyncWrites = asyncWrites;
    }


    private File sourceFile;
    private final File exportDir;
    private final File workingTmpDir;
    private final File targetExportFile;
    private final ProtocolDirectory protocolDirectory;
    private final Configuration<Option> configuration;
    private final boolean asyncReads;
    private final boolean asyncWrites;

    private volatile boolean started = false;
    private final AtomicBoolean cancelFlag = new AtomicBoolean(false);

    private ReplayMetadata metadata = null;
    private ZipFile sourceZipFile = null;
    private long sourceReplaySizeBytes = 0;

    private OutputStream targetOutputStream = null;


    @Override
    public void run() {
        if (this.started) {
            throw new RuntimeException("Job can only be ran once.");
        }
        this.started = true;

        // The entire task is contained within a try-catch for handing cleanup & closing of io streams in the event of any unhandled exception occurring.
        try {
            // Check if this job has been canceled. Cleanup this replay job if so.
            if (this.isCanceled()) {
                ReplayPacketCleaner.deleteFilesRecursively(this.workingTmpDir);
                this.setStatus(Status.CANCELED);
                return;
            }

            long taskStartingMilliseconds = System.currentTimeMillis();

            this.setStatus(Status.IN_PROGRESS);
            this.setProgress(Job.MIN_PROGRESS_VALUE + 1);

            // Task Initialization

            this.sourceZipFile = new ZipFile(this.sourceFile);

            // Load the metaData.json file
            ZipEntry sourceMetadataEntry = sourceZipFile.getEntry(ReplayPacketCleaner.METADATA_FILE_NAME);
            if (sourceMetadataEntry == null) {
                throw new RuntimeException(new FileNotFoundException("The entry \"" + ReplayPacketCleaner.METADATA_FILE_NAME + "\" was not found within the provided archive at \"" + this.sourceFile + "\""));
            }
            this.metadata = ReplayMetadata.fromInputSteam(sourceZipFile.getInputStream(sourceMetadataEntry));

            // Get the replay size and set up the ReplayReader.
            ZipEntry sourceRecordingEntry = sourceZipFile.getEntry(ReplayPacketCleaner.RECORDING_TMCPR_FILE_NAME);
            if (sourceRecordingEntry == null) {
                throw new RuntimeException(new FileNotFoundException("The entry \"" + ReplayPacketCleaner.RECORDING_TMCPR_FILE_NAME + "\" was not found within the provided archive at \"" + this.sourceFile + "\""));
            }
            this.sourceReplaySizeBytes = sourceRecordingEntry.getSize();
            if (this.sourceReplaySizeBytes == -1) {
                throw new RuntimeException("Cannot determine the uncompressed size of \"" + ReplayPacketCleaner.RECORDING_TMCPR_FILE_NAME + "\" with the archive at \"" + this.sourceFile.getPath() + "\": -1");
            }

            // Create the OutputStream that will be used to write-out to the target replay archive.
            File targetTmpFile = new File(this.workingTmpDir.getPath() + File.separator + ReplayPacketCleaner.RECORDING_TMCPR_FILE_NAME);
            if (!targetTmpFile.createNewFile()) {
                throw new FileAlreadyExistsException("The file for the target output replay at \"" + targetTmpFile.getPath() + "\" already exists!");
            }
            // Normally, this job will clean up temp files when done.
            // The target temp will be moved to the target output directory upon successful completion.
            // But just in case of some unforeseen issue, we'll mark the temp target file for deletion on exit.
            targetTmpFile.deleteOnExit();
            this.targetOutputStream = new FileOutputStream(targetTmpFile);

            // Create the listeners for manipulating replay packets
            List<PacketListener> packetListenerList = new ArrayList<PacketListener>();
            packetListenerList.add(new TestListener());

            // Replay editing stage
            ReplayManipulationTask replayManipulationTask =
                    new ReplayManipulationTask(
                            this,
                            new ReplayReader(this.sourceZipFile.getInputStream(sourceRecordingEntry), this.asyncReads, true),
                            this.sourceReplaySizeBytes,
                            new ReplayWriter(this.targetOutputStream, this.asyncWrites, true),
                            this.protocolDirectory.getProtocol(this.metadata.getMetadataJson().getInt(ReplayMetadata.KEY_PROTOCOL)),
                            packetListenerList.toArray(new PacketListener[0]));

            replayManipulationTask.run();

            // Start comparing the contents of the source vs the passthrough output. Verify they are both the same.
            boolean failed = false;
            try (ReplayReader sourceReader = new ReplayReader(this.sourceZipFile.getInputStream(sourceRecordingEntry), this.asyncReads, true);
                 ReplayReader targetReader = new ReplayReader(new FileInputStream(targetTmpFile), this.asyncReads, true)) {

                Protocol protocol = this.protocolDirectory.getProtocol(this.metadata.getMetadataJson().getInt(ReplayMetadata.KEY_PROTOCOL));

                // replay file header
                sourceReader.readInt();
                int length = sourceReader.readInt();
                sourceReader.readByteArray(length);

                targetReader.readInt();
                length = targetReader.readInt();
                targetReader.readByteArray(length);
                // end header

                // The login/configuration phase.
                if (protocol.getProtocolVersion() > Version.MC_1_20_1) {
                    this.skipConfigurationPackets(sourceReader, protocol);
                    this.skipConfigurationPackets(targetReader, protocol);
                } else {
                    this.skipLoginPackets(sourceReader, protocol);
                    this.skipLoginPackets(targetReader, protocol);
                }

                long packetIndex = -1; // May use useful for something if I need to target a specific packet within the sequence.
                while ((this.sourceReplaySizeBytes - sourceReader.bytesRead()) != 0 && !this.cancelFlag.get()) {
                    packetIndex++;

                    // Update the task progress tracker every X number of packets.
                    if (packetIndex % 512 == 0) {
                        this.setProgress((int) ((sourceReader.bytesRead() * Job.MAX_PROGRESS_VALUE) / this.sourceReplaySizeBytes));
                    }

                    // It's possible that if a replay recording crashed and was recovered, that the last packet may not be fully written.
                    // In such case, the incomplete packet data from the source replay should be disregarded.
                    if ((this.sourceReplaySizeBytes - sourceReader.bytesRead()) < 9) {
                        Log.warning("Job #" + this.getJobNumber() + ": Last packet is missing data. Expected at least another 9 bytes, only " + (this.sourceReplaySizeBytes - sourceReader.bytesRead()) + " bytes remaining. Disregarding the last packet.");
                        break;
                    }

                    // ReplayMod timestamp (in milliseconds since the beginning of this replay)
                    int sourceTimeStamp = sourceReader.readInt();

                    // Size of currentPacketID plus the packet data in bytes. Not a varInt!!! ReplayMod saves the size as a normal integer.
                    int sourcePacketSize = sourceReader.readInt();

                    // Checking again - See above for explanation.
                    if ((this.sourceReplaySizeBytes - sourceReader.bytesRead()) < sourcePacketSize) {
                        Log.warning("Job #" + this.getJobNumber() + ": Last packet is missing data. Expected another " + sourcePacketSize + " bytes, only " + (this.sourceReplaySizeBytes - sourceReader.bytesRead()) + " bytes remaining. Disregarding the last packet.");
                        break;
                    }

                    long sourceStartingBytesRead = sourceReader.bytesRead();  // current - starting = total read so far for this packet after reading the packet size.

                    int sourcePacketID = sourceReader.readVarInt();
                    PacketType.Play sourcePacketType = protocol.getPlayPacketType(sourcePacketID);
                    int[] sourceBytesData = sourceReader.readByteArray((int) (sourcePacketSize - (sourceReader.bytesRead() - sourceStartingBytesRead)));

                    int targetTimeStamp = targetReader.readInt();
                    int targetPacketSize = targetReader.readInt();
                    long targetStartingBytesRead = targetReader.bytesRead();  // current - starting = total read so far for this packet after reading the packet size.
                    int targetPacketID = targetReader.readVarInt();
                    PacketType.Play targetPacketType = protocol.getPlayPacketType(sourcePacketID);
                    int[] targetBytesData = targetReader.readByteArray((int) (targetPacketSize - (targetReader.bytesRead() - targetStartingBytesRead)));

                    if (sourceTimeStamp == targetTimeStamp) {
                        if (sourcePacketSize == targetPacketSize) {
                            if (sourcePacketID == targetPacketID) {
                                if (Arrays.equals(sourceBytesData, targetBytesData)) {
                                    continue;
                                }
                            }
                        }
                    }

                    Log.severe("Value not equal at packet index #" + packetIndex + " for Test Job #" + this.getJobNumber() + " (" + this.getUUID().toString() + ") for " + this.sourceFile.getName() + ":");
                    Log.severe("  Source: sourceTimeStamp=" + sourceTimeStamp + ", sourcePacketSize=" + sourcePacketSize + ", sourcePacketID=" + sourcePacketID + " (" + sourcePacketType.name() + "), sourceBytesData=" + Arrays.toString(sourceBytesData));
                    Log.severe("  Target: targetTimeStamp=" + targetTimeStamp + ", targetPacketSize=" + targetPacketSize + ", targetPacketID=" + targetPacketID + " (" + targetPacketType.name() + "), targetBytesData=" + Arrays.toString(targetBytesData));
                    failed = true;
                    break;
                }
            } catch (Exception ignored) {
            }

            // Close everything
            this.close();

            // Clean up
            ReplayPacketCleaner.deleteFilesRecursively(this.workingTmpDir);

            if (!failed) {
                this.setProgress(Job.MAX_PROGRESS_VALUE);
                this.setStatus(Status.COMPLETED);

                long finishTimeSeconds = (System.currentTimeMillis() - taskStartingMilliseconds) / 1000;
                Log.info("Test Job #" + this.getJobNumber() + " for \"" + this.getName() + "\" finished in " + (finishTimeSeconds / 60) + " minute(s), " + (finishTimeSeconds % 60) + " second(s).");
            } else {
                Log.info("Test Job #" + this.getJobNumber() + " for \"" + this.getName() + "\" failed.");
            }
        } catch (Exception exception) {
            try {
                this.close();
            } catch (IOException ioException) {
                exception.addSuppressed(ioException);
            }

            try {
                ReplayPacketCleaner.deleteFilesRecursively(this.workingTmpDir);
            } catch (IOException ioException) {
                exception.addSuppressed(ioException);
            }

            if (this.isCanceled()) {
                this.setStatus(Status.CANCELED);
            } else {
                this.setStatus(Status.FAILED);
                Log.severe("A problem occurred during processing of Test Job #" + this.getJobNumber() + " (" + this.getUUID().toString() + ") for \"" + this.getName() + "\":", exception);
            }
        }
    }


    @Override
    public void close() throws IOException {
        IOException exception = null;
        try {
            if (this.sourceZipFile != null) {
                this.sourceZipFile.close();
            }
        } catch (IOException ioException) {
            exception = ioException;
        }

        try {
            if (this.targetOutputStream != null) {
                this.targetOutputStream.close();
            }
        } catch (IOException ioException) {
            if (exception == null) {
                exception = ioException;
            } else {
                exception.addSuppressed(ioException);
            }
        }

        if (exception != null) {
            throw exception;
        }
    }


    /**
     * Skip through all the "configuration" phase packets.
     * Stops and returns upon hitting the packet that changes the state to "play".
     */
    private void skipConfigurationPackets(ReplayReader reader, Protocol protocol) throws IOException {
        // The configuration phase.
        while (true) {
            int timeStamp = reader.readInt();
            int packetSize = reader.readInt();
            int packetID = reader.readVarInt();
            int[] data = reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID));

            if (packetID == protocol.getConfigurationPacketID(PacketType.Configuration.FINISH_CONFIGURATION)) {
                // Now at the "play" state.
                break;
            }
        }
    }

    /**
     * Skip through all the "login" phase packets.
     * Stops and returns upon hitting the packet that changes the state to "play".
     */
    private void skipLoginPackets(ReplayReader reader, Protocol protocol) throws IOException {
        // The login  phase.
        while (true) {
            int timeStamp = reader.readInt();
            int packetSize = reader.readInt();
            int packetID = reader.readVarInt();
            int[] data = reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID));

            if (packetID == protocol.getLoginPacketID(PacketType.Login.LOGIN_SUCCESS)) {
                // Now at the "play" state.
                break;
            }
        }
    }

}
