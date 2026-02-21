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
import com.experimentalidea.replaypacketcleaner.job.Replay;
import com.experimentalidea.replaypacketcleaner.job.ReplayJob;
import com.experimentalidea.replaypacketcleaner.job.ReplayTestJob;
import com.experimentalidea.replaypacketcleaner.protocol.ProtocolDirectory;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.LogRecord;

public class ReplayPacketCleaner {

    private ReplayPacketCleaner() {

    }

    public static final String APP_NAME = "Replay Packet Cleaner";
    public static final String APP_VERSION = "0.2.3-alpha-snapshot";

    /// @see com.experimentalidea.replaypacketcleaner.config.Option
    public static final int APP_PROFILE_JSON_VERSION = 1;
    public static final int APP_PROTOCOL_JSON_VERSION = 1;

    public static final String DOT_MCPR_EXTENSION = ".mcpr";
    public static final String DOT_JSON_EXTENSION = ".json";
    public static final String RECORDING_TMCPR_FILE_NAME = "recording.tmcpr";
    public static final String RECORDING_TMCPR_CRC32_FILE_NAME = RECORDING_TMCPR_FILE_NAME + ".crc32";
    public static final String METADATA_FILE_NAME = "metaData.json";

    /**
     * The file name for the profile json file saved within the replays exported by this application.
     */
    public static final String ARCHIVE_PROFILE_JSON_FILE_NAME = "replay_packet_cleaner_profile" + DOT_JSON_EXTENSION;


    private File tempDirectory = null;

    private MainWindow mainWindow = null;

    private ProtocolDirectory protocolDirectory;

    private LinkedBlockingQueue<ReplayJob> jobPreprocessingQueue = new LinkedBlockingQueue<ReplayJob>();

    private Map<UUID, ReplayJob> jobs = new ConcurrentHashMap<UUID, ReplayJob>(32, 0.75F, 1);

    private final AtomicInteger jobCounter = new AtomicInteger(1);

    private ExecutorService executorService = null;

    private boolean asyncReads = false;
    private boolean asyncWrites = false;

    private volatile boolean processingJobs = false;

    private Thread mainThread = null;


    /**
     * Creates and initialize a new instance
     */
    public static ReplayPacketCleaner createInstance(boolean asyncReplayReads, boolean asyncReplayWrites) {

        ReplayPacketCleaner instance = new ReplayPacketCleaner();

        instance.asyncReads = asyncReplayReads;
        instance.asyncWrites = asyncReplayWrites;

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

        instance.protocolDirectory = new ProtocolDirectory();

        return instance;
    }

    /**
     * Loads all protocol mappings bundled in with the jar file.
     */
    public void loadBuiltinProtocols() {
        Log.info("Loading builtin protocols...");
        long startTime = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass().getResourceAsStream("/resources/protocols/protocol_directory.txt"))))) {
            List<Future<?>> taskList = new ArrayList<Future<?>>(32);
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank() && !line.startsWith("#")) {
                    String finalLine = line;

                    // A bit of a bandaid solution to improve startup performance.
                    // While only one protocol can technically be added to the ProtocolDirectory at a time,
                    // most of the time spent is parsing the json text itself which occurs outside the synchronized portion.
                    // Loading two protocols a combined total of 100 times took 1200ms~ on single thread, while using virtual threads or a thread pool solution took 400ms~.
                    taskList.add(this.executorService.submit(() -> {
                        try {
                            this.protocolDirectory.loadProtocol(this.getClass().getResourceAsStream("/resources/protocols/" + finalLine));
                        } catch (IOException ex) {
                            Log.severe("A problem occurred while trying to load a built-in protocol file: " + finalLine, ex);
                            throw new RuntimeException(ex);
                        }
                    }));
                }
            }
            // Wait for all the executor threads to finish.
            for (Future<?> task : taskList) {
                try {
                    task.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            Log.info("Loaded " + this.protocolDirectory.getSupportedProtocolVersions().size() + " protocols in " + (System.currentTimeMillis() - startTime) + "ms.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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


    public ProtocolDirectory getProtocolDirectory() {
        return this.protocolDirectory;
    }


    public void createMainWindow(LinkedBlockingDeque<LogRecord> logQueue, boolean visible, boolean showHiddenOptions) throws IllegalStateException, InterruptedException, InvocationTargetException {
        Log.info("Initializing GUI...");
        long startTime = System.currentTimeMillis();
        if (this.mainWindow != null) {
            throw new IllegalStateException("MainWindow already exists");
        }
        ReplayPacketCleaner instance = this;
        SwingUtilities.invokeAndWait(() -> {
            mainWindow = new MainWindow(instance, logQueue, showHiddenOptions);
            mainWindow.getMainFrame().setVisible(visible);
            Log.info("GUI initialized in " + (System.currentTimeMillis() - startTime) + "ms.");
        });
    }


    public void processJobsAndAwaitTermination() throws IllegalStateException {
        if (this.processingJobs) {
            throw new IllegalStateException("processJobsAndAwaitTermination() can only be invoked once");
        }
        this.processingJobs = true;

        this.mainThread = Thread.currentThread();

        while (this.mainWindow.getMainFrame().isDisplayable()) {
            ReplayJob job;
            try {
                job = this.jobPreprocessingQueue.take();
            } catch (InterruptedException ignored) {
                continue;
            }

            try {
                job.prepareJob();
            } catch (Exception exception) {
                Log.warning("Job #" + job.getJobNumber() + " for \"" + job.getName() + "\" FAILED: " + exception.getMessage());
            }

            this.executorService.submit(job);
        }

        // GUI Window has been closed at this point. Clean up
        for (ReplayJob job : this.jobs.values()) {
            Job.Status status = job.getStatus();
            if (status == Job.Status.PREPARING || status == Job.Status.WAITING || status == Job.Status.IN_PROGRESS) {
                Log.info("Canceling job #" + job.getJobNumber() + " for " + job.getName() + ".");
                job.cancel();
            }
        }

        this.executorService.shutdown();
        boolean terminationSuccessful = false;
        try {
            terminationSuccessful = this.executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {
            // should never happen...
            Log.warning("Main thread interrupted while awaiting tasks to end.");
        }
        if (!terminationSuccessful) {
            Log.warning("Failed to terminate all active tasks.");
        }

        // Goodbye!

    }


    public MainWindow getMainWindow() {
        return this.mainWindow;
    }


    public Job submitReplayJob(Replay replay) {
        Objects.requireNonNull(replay.getConfiguration(), "Replay object doesn't have a configuration set");
        Objects.requireNonNull(replay.getExportDirectory(), "Replay object doesn't have an Export Directory set");
        if (this.jobs.containsKey(replay.getUUID())) {
            throw new IllegalStateException("Could not submit job " + replay.getUUID() + " for " + replay.getName() + ": Job by this UUID is already submitted.");
        }

        ReplayJob job = new ReplayJob(
                this.jobCounter.getAndIncrement(),
                replay,
                new File(this.tempDirectory, replay.getUUID().toString()),
                replay.getExportDirectory(),
                this.protocolDirectory,
                this.asyncReads,
                this.asyncWrites);

        this.jobs.put(job.getUUID(), job);
        this.jobPreprocessingQueue.add(job);

        Log.info("Job #" + job.getJobNumber() + " for " + job.getName() + " submitted.");

        return job;
    }

    // todo: implement a better way of handling test jobs
    public Job submitReplayTestJob(Replay replay) {
        Objects.requireNonNull(replay.getConfiguration(), "Replay object doesn't have a configuration set");
        Objects.requireNonNull(replay.getExportDirectory(), "Replay object doesn't have an Export Directory set");
        if (this.jobs.containsKey(replay.getUUID())) {
            throw new IllegalStateException("Could not submit job " + replay.getUUID() + " for " + replay.getName() + ": Job by this UUID is already submitted.");
        }

        ReplayJob job = new ReplayTestJob(
                this.jobCounter.getAndIncrement(),
                replay,
                new File(this.tempDirectory, replay.getUUID().toString()),
                replay.getExportDirectory(),
                this.protocolDirectory,
                this.asyncReads,
                this.asyncWrites);

        this.jobs.put(job.getUUID(), job);
        this.jobPreprocessingQueue.add(job);

        Log.info("Test Job #" + job.getJobNumber() + " for " + job.getName() + " submitted.");

        return job;
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
