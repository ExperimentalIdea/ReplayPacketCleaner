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
package com.experimentalidea.replaypacketcleaner;

import com.experimentalidea.replaypacketcleaner.gui.MainWindow;
import com.experimentalidea.replaypacketcleaner.job.Job;
import com.experimentalidea.replaypacketcleaner.job.ReplayJob;
import com.experimentalidea.replaypacketcleaner.job.TaskTracker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

public class ReplayPacketCleaner {

    private ReplayPacketCleaner() {

    }

    public static final String APP_NAME = "Replay Packet Cleaner";
    public static final String APP_VERSION = "0.1.0-alpha";
    public static final int APP_PROFILE_JSON_VERSION = 0;

    public static final String DOT_MCPR_EXTENSION = ".mcpr";
    public static final String DOT_JSON_EXTENSION = ".json";
    public static final String RECORDING_TMCPR_FILE_NAME = "recording.tmcpr";
    public static final String RECORDING_TMCPR_CRC32_FILE_NAME = RECORDING_TMCPR_FILE_NAME + ".crc32";
    public static final String METADATA_FILE_NAME = "metaData.json";

    /**
     * The file name for the profile json file saved within the replays exported by this application.
     */
    public static final String ARCHIVE_PROFILE_JSON_FILE_NAME = "replayPacketCleanerProfile" + DOT_JSON_EXTENSION;


    private File tempDirectory = null;

    private MainWindow mainWindow = null;

    // A job uuid to task progress map. The UI thread reads this, while the main thread adds new entries as needed.
    private Map<UUID, TaskTracker> taskTrackerMap = new ConcurrentHashMap<UUID, TaskTracker>(32, 0.75F, 1);

    private LinkedBlockingQueue<Job> jobQueue = new LinkedBlockingQueue<Job>();

    private Map<UUID, ReplayJob> submittedJobs = new HashMap<UUID, ReplayJob>(32);

    private ExecutorService executorService = null;

    private volatile boolean processingJobs = false;

    private Thread mainThread = null;


    /**
     * Creates and initialize a new instance
     */
    public static ReplayPacketCleaner createInstance() {

        ReplayPacketCleaner instance = new ReplayPacketCleaner();

        try {
            instance.tempDirectory = Files.createTempDirectory(instance.getClass().getName()).toFile();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create a temp directory");
        }
        instance.tempDirectory.deleteOnExit();

        int threads = Runtime.getRuntime().availableProcessors() - 1;
        if (threads < 1) {
            threads = 1;
        }
        instance.executorService = Executors.newFixedThreadPool(threads);

        return instance;
    }

    /**
     * Delete a file or a folder along with all of its contents.
     * Typically, this method is used to clean up the temporary working directory for a replay job.
     */
    public static void deleteFilesRecursively(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                // Not a directory. Delete!
                file.delete();
            } else {
                // Is a directory. Get the list of files and delete them.
                File[] fileArray = file.listFiles();
                assert fileArray != null;
                for (File f : fileArray) {
                    ReplayPacketCleaner.deleteFilesRecursively(f);
                }
                // Finally, delete the directory
                file.delete();
            }
        }
    }


    public void createMainWindow(boolean visible) throws IllegalStateException {
        if (mainWindow != null) {
            throw new IllegalStateException("MainWindow already exists");
        }
        this.mainWindow = new MainWindow(this);
        this.mainWindow.getMainFrame().setVisible(visible);
    }


    public void processJobsAndAwaitTermination() throws IllegalStateException {
        if (this.processingJobs) {
            throw new IllegalStateException("processJobsAndAwaitTermination() can only be invoked once");
        }
        this.processingJobs = true;

        this.mainThread = Thread.currentThread();

        while (this.mainWindow.getMainFrame().isDisplayable()) {
            Job job;
            try {
                job = this.jobQueue.take();
            } catch (InterruptedException ignored) {
                continue;
            }

            UUID jobUUID = job.getUUID();

            if (this.submittedJobs.containsKey(jobUUID)) {
                this.taskTrackerMap.get(jobUUID).setStatus(TaskTracker.TaskStatus.FAILED);
                // TODO: update logging
                System.out.println("Job " + jobUUID.toString() + " for " + job.getSourceFile().getPath() + " FAILED: Job already submitted");
                continue;
            }

            File sourceFile = job.getSourceFile();

            if (!sourceFile.exists()) {
                this.taskTrackerMap.get(jobUUID).setStatus(TaskTracker.TaskStatus.FAILED);
                // TODO: update logging
                System.out.println("Job " + jobUUID.toString() + " for " + job.getSourceFile().getPath() + " FAILED: Source replay file does not exist");
                continue;
            }

            if (!Files.isReadable(sourceFile.toPath())) {
                this.taskTrackerMap.get(jobUUID).setStatus(TaskTracker.TaskStatus.FAILED);
                // TODO: update logging
                System.out.println("Job " + jobUUID.toString() + " for " + job.getSourceFile().getPath() + " FAILED: Permission denied - Cannot read source replay file");
                continue;
            }

            File exportDirectory = job.getTargetDirectory();

            if (!exportDirectory.exists()) {
                this.taskTrackerMap.get(jobUUID).setStatus(TaskTracker.TaskStatus.FAILED);
                // TODO: update logging
                System.out.println("Job " + jobUUID.toString() + " for " + job.getSourceFile().getPath() + " FAILED: Target output directory " + exportDirectory.getPath() + " does not exist");
                continue;
            }
            if (!exportDirectory.isDirectory()) {
                this.taskTrackerMap.get(jobUUID).setStatus(TaskTracker.TaskStatus.FAILED);
                // TODO: update logging
                System.out.println("Job " + jobUUID.toString() + " for " + job.getSourceFile().getPath() + " FAILED: Target output directory " + exportDirectory.getPath() + " is not a directory");
                continue;
            }
            if (!Files.isWritable(exportDirectory.toPath())) {
                this.taskTrackerMap.get(jobUUID).setStatus(TaskTracker.TaskStatus.FAILED);
                // TODO: update logging
                System.out.println("Job " + jobUUID.toString() + " for " + job.getSourceFile().getPath() + " FAILED: Permission denied - Cannot write to " + exportDirectory.getPath());
                continue;
            }

            File workingDirectory = new File(this.tempDirectory, jobUUID.toString());
            if (!workingDirectory.exists()) {
                workingDirectory.mkdirs();
            }
            // Normally, the job itself will clean up temp files when done.
            // But just in case of some unforeseen issue, we'll mark it for deletion on exit.
            workingDirectory.deleteOnExit();

            File sourceCopy = new File(workingDirectory.getPath() + File.separator + sourceFile.getName().replaceAll(ReplayPacketCleaner.DOT_MCPR_EXTENSION, "") + " (copy)" + ReplayPacketCleaner.DOT_MCPR_EXTENSION);

            try {
                Files.copy(sourceFile.toPath(), sourceCopy.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ioException) {
                this.taskTrackerMap.get(jobUUID).setStatus(TaskTracker.TaskStatus.FAILED);
                // TODO: update logging
                System.out.println("Job " + jobUUID.toString() + " for " + job.getSourceFile().getPath() + " FAILED: Could not copy source replay to working directory - IOException: " + ioException.getMessage());
                continue;
            }
            // Same as above with workingDirectory. Mark for deletion on exit.
            sourceCopy.deleteOnExit();

            ReplayJob replayJob;
            try {
                replayJob = new ReplayJob(
                        sourceCopy,
                        workingDirectory,
                        new File(exportDirectory.getPath() + File.separator + sourceFile.getName().replaceAll(ReplayPacketCleaner.DOT_MCPR_EXTENSION, "") + " (RPC)" + ReplayPacketCleaner.DOT_MCPR_EXTENSION),
                        job.getProfile(),
                        this.taskTrackerMap.get(jobUUID));
            } catch (Exception exception) {
                this.taskTrackerMap.get(jobUUID).setStatus(TaskTracker.TaskStatus.FAILED);
                // TODO: update logging
                System.out.println("Job " + jobUUID.toString() + " for " + job.getSourceFile().getPath() + " FAILED: Could not create job - Exception: " + exception.getMessage());
                continue;
            }

            this.taskTrackerMap.get(jobUUID).setStatus(TaskTracker.TaskStatus.WAITING);
            this.submittedJobs.put(jobUUID, replayJob);
            this.executorService.submit(replayJob);

        }

        // GUI Window has been closed at this point. Clean up
        for (TaskTracker taskTracker : this.taskTrackerMap.values()) {
            TaskTracker.TaskStatus status = taskTracker.getStatus();
            if (status == TaskTracker.TaskStatus.WAITING || status == TaskTracker.TaskStatus.IN_PROGRESS) {
                ReplayJob replayJob = this.submittedJobs.get(taskTracker.getUUID());
                if (replayJob != null) {
                    System.out.println("Canceling job " + taskTracker.getUUID().toString() + ".");
                    replayJob.cancelJob();
                }
            }
        }

        this.executorService.shutdown();
        boolean terminationSuccessful = false;
        try {
            terminationSuccessful = this.executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {
            // should never happen...
            System.out.println("Main thread interrupted while awaiting tasks to end.");
        }
        if (!terminationSuccessful) {
            System.out.println("Failed to terminate all active tasks.");
        }

        // Goodbye!

    }


    public MainWindow getMainWindow() {
        return this.mainWindow;
    }


    public TaskTracker submitReplayJob(Job job) {
        if (job == null) {
            throw new IllegalArgumentException("job cannot be null");
        }
        UUID jobUUID = job.getUUID();
        TaskTracker taskTracker = new TaskTracker(jobUUID);
        this.taskTrackerMap.put(jobUUID, taskTracker);
        this.jobQueue.add(job);

        System.out.println("Job " + jobUUID.toString() + " for " + job.getSourceFile().getName() + " submitted.");

        return taskTracker;
    }


    /**
     * Causes the thread responsible for preparing submitted jobs to be interrupted.
     * This method is called when the GUI window is closed.
     * If this isn't called, the application won't terminate.
     * Calling this while the application window is still open will effectively do noting.
     */
    public void interruptMainThread() {
        if (this.mainThread != null) {
            this.mainThread.interrupt();
        }
    }

}
