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
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.*;

public class ReplayJob implements Runnable, Closeable {


    /**
     * NOTE: if source file is located inside the workingDir, it will be deleted when task is done executing.
     * workingDir should be an uuid, as a collision is effectively impossible.
     * workingDir is deleted when the task completes
     */
    public ReplayJob(File sourceFile, File workingDir, File targetFile, ProtocolDirectory protocolDirectory, Configuration<Option> configuration, TaskTracker taskTracker, boolean asyncWrites) throws FileNotFoundException, NotDirectoryException {
        if (sourceFile == null) {
            throw new IllegalArgumentException("sourceFile cannot be null");
        }
        if (!sourceFile.exists()) {
            throw new FileNotFoundException("The file at \"" + sourceFile.getPath() + "\" does not exist");
        }
        if (workingDir == null) {
            throw new IllegalArgumentException("workingDir cannot be null");
        }
        if (!workingDir.isDirectory()) {
            throw new NotDirectoryException("The path at \"" + sourceFile.getPath() + "\" is not a directory");
        }
        if (targetFile == null) {
            throw new IllegalArgumentException("sourceFile cannot be null");
        }
        if (protocolDirectory == null) {
            throw new IllegalArgumentException("protocolDirectory cannot be null");
        }
        if (sourceFile.equals(targetFile)) {
            throw new IllegalArgumentException("sourceFile path cannot be equal to targetFile path");
        }
        if (sourceFile.getName().equals(targetFile.getName())) {
            throw new IllegalArgumentException("sourceFile name cannot be equal to targetFile name");
        }
        if (configuration == null) {
            throw new IllegalArgumentException("taskProgress cannot be null");
        }
        if (taskTracker == null) {
            throw new IllegalArgumentException("taskProgress cannot be null");
        }

        this.sourceFile = sourceFile;
        this.workingDir = workingDir;
        this.targetFile = targetFile;
        this.protocolDirectory = protocolDirectory;
        this.configuration = configuration;
        this.taskTracker = taskTracker;
        this.asyncWrites = asyncWrites;
    }

    private static final Object TARGET_MOVE_LOCK = new Object();

    private final File sourceFile;
    private final File workingDir;
    private final File targetFile;
    private final ProtocolDirectory protocolDirectory;
    private final Configuration<Option> configuration;
    private final TaskTracker taskTracker;
    private final boolean asyncWrites;

    private volatile boolean started = false;
    private final AtomicBoolean cancelFlag = new AtomicBoolean(false);

    private ReplayMetadata metadata = null;
    private ZipFile sourceZipFile = null;
    private long sourceReplaySizeBytes = 0;

    private ZipOutputStream targetZipOutputStream = null;


    @Override
    public void run() {
        if (this.started) {
            throw new RuntimeException("Job can only be ran once.");
        }
        this.started = true;

        // The entire task is contained within a try-catch for handing cleanup & closing of io streams in the event of any unhandled exception occurring.
        try {
            // Check if this job has been canceled. Cleanup this replay job if so.
            if (this.cancelFlag.get()) {
                ReplayPacketCleaner.deleteFilesRecursively(this.workingDir);
                this.taskTracker.setStatus(TaskTracker.TaskStatus.CANCELED);
                return;
            }

            // TODO: Remove later. Used for performance benchmarking.
            long taskStartingMilliseconds = System.currentTimeMillis();

            this.taskTracker.setStatus(TaskTracker.TaskStatus.IN_PROGRESS);
            this.taskTracker.setProgress(TaskTracker.MIN_VALUE + 1);

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
            File targetTempFile = new File(this.workingDir.getPath() + File.separator + targetFile.getName());
            if (!targetTempFile.createNewFile()) {
                throw new FileAlreadyExistsException("The file for the target output replay at \"" + targetTempFile.getPath() + "\" already exists!");
            }
            // Normally, this job will clean up temp files when done.
            // The target temp will be moved to the target output directory upon successful completion.
            // But just in case of some unforeseen issue, we'll mark the temp target file for deletion on exit.
            targetTempFile.deleteOnExit();
            this.targetZipOutputStream = new ZipOutputStream(new FileOutputStream(targetTempFile));
            ZipEntry targetRecordingEntry = new ZipEntry(ReplayPacketCleaner.RECORDING_TMCPR_FILE_NAME);
            this.targetZipOutputStream.putNextEntry(targetRecordingEntry);

            // Create the listeners for manipulating replay packets
            List<PacketListener> packetListenerList = new ArrayList<PacketListener>();
            // TODO: Add & configure more packet listeners base on the provided configuration
            if (this.configuration.getBoolean(Option.BLOCK_ACTION_REMOVE)) {
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
                packetListenerList.add(new WeatherChanger(this.configuration.getBoolean(Option.WEATHER_IS_RAINING), this.configuration.getFloat(Option.WEATHER_RAIN_LEVEL), this.configuration.getFloat(Option.WEATHER_THUNDER_LEVEL)));
            }

            // Replay editing stage
            ReplayManipulationTask replayManipulationTask =
                    new ReplayManipulationTask(
                            new ReplayReader(this.sourceZipFile.getInputStream(sourceRecordingEntry)),
                            this.sourceReplaySizeBytes,
                            new ReplayWriter(this.targetZipOutputStream, this.asyncWrites, false),
                            this.protocolDirectory.getProtocol(this.metadata.getMetadataJson().getInt(ReplayMetadata.KEY_PROTOCOL)),
                            this.taskTracker,
                            this.cancelFlag,
                            packetListenerList.toArray(new PacketListener[0]));

            replayManipulationTask.run();

            this.targetZipOutputStream.closeEntry();

            // Check (again) if this job has been canceled. Cleanup this replay job if so.
            if (this.cancelFlag.get()) {
                try {
                    this.close();
                } catch (IOException ignored) {
                }
                ReplayPacketCleaner.deleteFilesRecursively(this.workingDir);
                this.taskTracker.setStatus(TaskTracker.TaskStatus.CANCELED);
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
            synchronized (ReplayJob.TARGET_MOVE_LOCK) {
                File finalTargetFile = this.targetFile;
                int targetTries = 0;
                while (finalTargetFile.exists()) {
                    targetTries++;
                    finalTargetFile = new File(this.targetFile.getParent() + File.separator + this.targetFile.getName().replaceAll(ReplayPacketCleaner.DOT_MCPR_EXTENSION, "") + " (" + targetTries + ")" + ReplayPacketCleaner.DOT_MCPR_EXTENSION);
                }
                try {
                    Files.move(targetTempFile.toPath(), finalTargetFile.toPath(), StandardCopyOption.ATOMIC_MOVE);
                } catch (AtomicMoveNotSupportedException exception) {
                    // It's possible an Atomic Move operation may not be supported. Try copying instead.
                    Files.copy(targetTempFile.toPath(), finalTargetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }

            // Clean up
            ReplayPacketCleaner.deleteFilesRecursively(this.workingDir);

            this.taskTracker.setProgress(TaskTracker.MAX_VALUE);
            this.taskTracker.setStatus(TaskTracker.TaskStatus.COMPLETED);

            // TODO: Remove later. Used for performance benchmarking.
            long finishTimeSeconds = (System.currentTimeMillis() - taskStartingMilliseconds) / 1000;
            System.out.println("Job " + this.taskTracker.getUUID().toString() + " for " + this.targetFile.getName() + " finished in " + (finishTimeSeconds / 60) + " minute(s), " + (finishTimeSeconds % 60) + " second(s).");

        } catch (Exception exception) {
            try {
                this.close();
            } catch (IOException ioException) {
                exception.addSuppressed(ioException);
            }

            try {
                ReplayPacketCleaner.deleteFilesRecursively(this.workingDir);
            } catch (IOException ioException) {
                exception.addSuppressed(ioException);
            }

            if (this.cancelFlag.get()) {
                this.taskTracker.setStatus(TaskTracker.TaskStatus.CANCELED);
            } else {
                this.taskTracker.setStatus(TaskTracker.TaskStatus.FAILED);
                // TODO: Log and handle differently. Throwing a new exception here doesn't really serve any purpose.
                exception.printStackTrace();
                throw new RuntimeException(exception);
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

    /**
     * Sets a flag to cancel this job at the earliest opportunity. (should typically be within 1000 milliseconds)
     */
    public void cancelJob() {
        this.cancelFlag.set(true);
    }


    public boolean flaggedAsCanceled() {
        return this.cancelFlag.get();
    }


}
