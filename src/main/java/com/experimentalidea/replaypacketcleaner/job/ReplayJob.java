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

import com.experimentalidea.replaypacketcleaner.*;
import com.experimentalidea.replaypacketcleaner.config.Configuration;
import com.experimentalidea.replaypacketcleaner.config.Option;
import com.experimentalidea.replaypacketcleaner.job.listener.*;
import com.experimentalidea.replaypacketcleaner.packet.listener.PacketListener;
import com.experimentalidea.replaypacketcleaner.protocol.ProtocolDirectory;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.*;

public class ReplayJob extends Job implements Runnable, Closeable {


    /**
     * NOTE: if source file is located inside the workingDir, it will be deleted when task is done executing.
     * workingDir should be an uuid, as a collision is effectively impossible.
     * workingDir is deleted when the task completes
     */
    public ReplayJob(int jobNumber, Replay replay, File workingTmpDir, File exportDir, ProtocolDirectory protocolDirectory, boolean asyncReads, boolean asyncWrites) {
        super(jobNumber, replay);

        this.sourceFile = replay.getSourceFile();
        this.exportDir = replay.getExportDirectory();
        Objects.requireNonNull(this.exportDir, "exportDir within Replay object cannot be null");

        this.configuration = replay.getConfiguration();
        Objects.requireNonNull(this.configuration, "configuration within Replay object cannot be null");

        this.workingTmpDir = workingTmpDir;
        this.targetExportFile = new File(this.exportDir, this.sourceFile.getName().replaceAll(ReplayPacketCleaner.DOT_MCPR_EXTENSION, "") + " (RPC)" + ReplayPacketCleaner.DOT_MCPR_EXTENSION);

        this.protocolDirectory = protocolDirectory;
        this.asyncReads = asyncReads;
        this.asyncWrites = asyncWrites;
    }


    private static final Object TARGET_FILE_MOVE_LOCK = new Object();

    private File sourceFile;
    private final File exportDir;
    private final File workingTmpDir;
    private final File targetExportFile;
    private final ProtocolDirectory protocolDirectory;
    private final Configuration<Option> configuration;
    private final boolean asyncReads;
    private final boolean asyncWrites;

    private volatile boolean prepared = false;
    private volatile boolean started = false;
    private final AtomicBoolean cancelFlag = new AtomicBoolean(false);

    private ReplayMetadata metadata = null;
    private ZipFile sourceZipFile = null;
    private long sourceReplaySizeBytes = 0;

    private ZipOutputStream targetZipOutputStream = null;


    public void prepareJob() throws Exception {
        if (this.prepared) {
            throw new RuntimeException("Job has already been prepared for execution.");
        }
        this.prepared = true;

        try {
            // If the job has been canceled already, don't prepare it for execution.
            if (this.isCanceled()) {
                this.setStatus(Status.CANCELED);
                return;
            }

            // Source replay file checks.
            if (!this.sourceFile.exists()) {
                throw new FileNotFoundException("Source replay file does not exist");
            }
            if (!Files.isReadable(this.sourceFile.toPath())) {
                throw new AccessDeniedException(this.sourceFile.toString(), null, "Permission denied - Cannot read source replay file " + this.sourceFile.toString());
            }

            // Export directory checks.
            if (!this.exportDir.exists()) {
                throw new FileNotFoundException("Target export directory " + exportDir.getPath() + " does not exist");
            }
            if (!this.exportDir.isDirectory()) {
                throw new Exception("Target export directory " + exportDir.getPath() + " is not a directory", new NotDirectoryException(this.exportDir.toString()));
            }
            if (!Files.isWritable(this.exportDir.toPath())) {
                throw new AccessDeniedException(this.exportDir.toString(), null, "Permission denied - Cannot write to export directory " + this.exportDir.toString());
            }

            if (!this.workingTmpDir.exists()) {
                this.workingTmpDir.mkdirs();
            }
            // Normally, the job itself will clean up temp files when done.
            // But just in case of some unforeseen issue, we'll mark it for deletion on exit.
            this.workingTmpDir.deleteOnExit();

            File sourceCopy = new File(this.workingTmpDir, this.sourceFile.getName().replaceAll(ReplayPacketCleaner.DOT_MCPR_EXTENSION, "") + " (copy)" + ReplayPacketCleaner.DOT_MCPR_EXTENSION);

            try {
                Files.copy(this.sourceFile.toPath(), sourceCopy.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ioException) {
                throw new IOException("Could not copy source replay to working temp directory", ioException);
            }

            // Same as above with workingTmpDir. Mark for deletion on exit.
            sourceCopy.deleteOnExit();

            this.sourceFile = sourceCopy;

            this.setStatus(Status.WAITING);

        } catch (Exception exception) {
            this.setStatus(Status.FAILED);
            throw exception;
        }
    }

    @Override
    public void run() {
        if (this.started) {
            throw new RuntimeException("Job can only be ran once.");
        } else if (!this.prepared) {
            throw new RuntimeException("Job hasn't been set up and therefor processing cannot begin.");
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

            // Create the ZipOutputStream that will be used to write-out to the target replay archive.
            File targetTmpFile = new File(this.workingTmpDir, this.targetExportFile.getName());
            if (!targetTmpFile.createNewFile()) {
                throw new FileAlreadyExistsException("The file for the target output replay at \"" + targetTmpFile.getPath() + "\" already exists!");
            }
            // Normally, this job will clean up temp files when done.
            // The target temp will be moved to the target output directory upon successful completion.
            // But just in case of some unforeseen issue, we'll mark the temp target file for deletion on exit.
            targetTmpFile.deleteOnExit();
            this.targetZipOutputStream = new ZipOutputStream(new FileOutputStream(targetTmpFile));
            ZipEntry targetRecordingEntry = new ZipEntry(ReplayPacketCleaner.RECORDING_TMCPR_FILE_NAME);
            this.targetZipOutputStream.putNextEntry(targetRecordingEntry);

            // Create the listeners for manipulating replay packets
            List<PacketListener> packetListenerList = new ArrayList<PacketListener>();
            // TODO: Add & configure more packet listeners base on the provided configuration
            if (this.configuration.getBoolean(Option.BLOCK_ANIMATION_REMOVE)) {
                packetListenerList.add(new BlockActionRemover());
            }
            if (this.configuration.getBoolean(Option.ENTITIES_REMOVE_ALL)) {
                packetListenerList.add(new EntityRemover());
            }
            if (this.configuration.getBoolean(Option.PARTICLE_REMOVE_ALL)) {
                packetListenerList.add(new ParticleRemover());
            }
            if (this.configuration.getBoolean(Option.SOUND_REMOVE_ALL)) {
                packetListenerList.add(new SoundRemover());
            }
            if (this.configuration.getBoolean(Option.TIME_OVERRIDE)) {
                packetListenerList.add(new TimeChanger(this.configuration.getLong(Option.TIME_SET)));
            }
            if (this.configuration.getBoolean(Option.WEATHER_OVERRIDE)) {
                packetListenerList.add(new WeatherChanger(this.configuration.getBoolean(Option.WEATHER_IS_RAINING), this.configuration.getFloat(Option.WEATHER_RAIN_LEVEL), this.configuration.getFloat(Option.WEATHER_THUNDER_LEVEL), this.configuration.getBoolean(Option.WEATHER_REMOVE_LIGHTING_STRIKES)));
            }

            // Replay editing stage
            ReplayManipulationTask replayManipulationTask =
                    new ReplayManipulationTask(
                            this,
                            new ReplayReader(this.sourceZipFile.getInputStream(sourceRecordingEntry), this.asyncReads, true),
                            this.sourceReplaySizeBytes,
                            new ReplayWriter(this.targetZipOutputStream, this.asyncWrites, false),
                            this.protocolDirectory.getProtocol(this.metadata.getMetadataJson().getInt(ReplayMetadata.KEY_PROTOCOL)),
                            packetListenerList.toArray(new PacketListener[0]));

            replayManipulationTask.run();

            this.targetZipOutputStream.closeEntry();

            // Check (again) if this job has been canceled. Cleanup this replay job if so.
            if (this.isCanceled()) {
                try {
                    this.close();
                } catch (IOException ignored) {
                }
                ReplayPacketCleaner.deleteFilesRecursively(this.workingTmpDir);
                this.setStatus(Status.CANCELED);
                return;
            }

            // Copy over other replay archive data from the source.
            // Write out the metaData.json file.
            this.targetZipOutputStream.putNextEntry(new ZipEntry(ReplayPacketCleaner.METADATA_FILE_NAME));
            this.targetZipOutputStream.write(this.metadata.getMetadataJson().toString().getBytes());
            this.targetZipOutputStream.closeEntry();

            // Write out the ReplayPackerCleaner profile that represents the settings used for this replay.
            String rpcFileName = ReplayPacketCleaner.ARCHIVE_PROFILE_JSON_FILE_NAME;
            int rpcTries = 0;
            // Ensure that if RPC has been run on the source file before, the new profile is given a unique file name. (as we don't want to go the route of overwriting old profile file(s))
            while (this.sourceZipFile.getEntry(rpcFileName) != null) {
                rpcTries++;
                rpcFileName = ReplayPacketCleaner.ARCHIVE_PROFILE_JSON_FILE_NAME.replaceAll(ReplayPacketCleaner.DOT_JSON_EXTENSION, "") + "(" + rpcTries + ")" + ReplayPacketCleaner.DOT_JSON_EXTENSION;
            }
            this.targetZipOutputStream.putNextEntry(new ZipEntry(rpcFileName));
            this.targetZipOutputStream.write(this.configuration.toJSONObject().toString(2).getBytes());
            this.targetZipOutputStream.closeEntry();

            // Copy over all other data from the source replay
            Enumeration<? extends ZipEntry> entries = this.sourceZipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = entries.nextElement();
                String entryName = zipEntry.getName();
                if (!entryName.equals(ReplayPacketCleaner.RECORDING_TMCPR_FILE_NAME)
                        && !entryName.equals(ReplayPacketCleaner.RECORDING_TMCPR_CRC32_FILE_NAME)
                        && !entryName.equals(ReplayPacketCleaner.METADATA_FILE_NAME)) {

                    this.targetZipOutputStream.putNextEntry(new ZipEntry(zipEntry));
                    InputStream sourceEntryStream = this.sourceZipFile.getInputStream(zipEntry);

                    int readBuffer = sourceEntryStream.read();
                    while (readBuffer != -1) {
                        this.targetZipOutputStream.write(readBuffer);
                        readBuffer = sourceEntryStream.read();
                    }

                    sourceEntryStream.close();
                    this.targetZipOutputStream.closeEntry();
                }
            }


            // Close everything
            this.close();

            // Move the new replay archive out of the working directory.
            // Synchronized on a static object to prevent unexpected conflicts with other replay jobs.
            File finalTargetFile = this.targetExportFile;
            synchronized (ReplayJob.TARGET_FILE_MOVE_LOCK) {
                int targetTries = 0;
                while (finalTargetFile.exists()) {
                    targetTries++;
                    finalTargetFile = new File(this.targetExportFile.getParent(), this.targetExportFile.getName().replaceAll(ReplayPacketCleaner.DOT_MCPR_EXTENSION, "") + " (" + targetTries + ")" + ReplayPacketCleaner.DOT_MCPR_EXTENSION);
                }
                try {
                    Files.move(targetTmpFile.toPath(), finalTargetFile.toPath(), StandardCopyOption.ATOMIC_MOVE);
                } catch (AtomicMoveNotSupportedException exception) {
                    // It's possible an Atomic Move operation may not be supported. Try copying instead.
                    Files.copy(targetTmpFile.toPath(), finalTargetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }

            // Clean up
            ReplayPacketCleaner.deleteFilesRecursively(this.workingTmpDir);

            this.setProgress(Job.MAX_PROGRESS_VALUE);
            this.setStatus(Status.COMPLETED);

            long finishTimeSeconds = (System.currentTimeMillis() - taskStartingMilliseconds) / 1000;
            Log.info("Job #" + this.getJobNumber() + " for \"" + this.getName() + "\" finished in " + (finishTimeSeconds / 60) + " minute(s), " + (finishTimeSeconds % 60) + " second(s). Replay saved to " + finalTargetFile.toString());

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
                Log.severe("A problem occurred during processing of Job #" + this.getJobNumber() + " (" + this.getUUID().toString() + ") for \"" + this.getName() + "\":", exception);
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
            if (this.targetZipOutputStream != null) {
                this.targetZipOutputStream.close();
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


    @Override
    public void cancel() {
        this.cancelFlag.set(true);
    }

    @Override
    public boolean isCanceled() {
        return this.cancelFlag.get();
    }


}
