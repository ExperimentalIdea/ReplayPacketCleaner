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

import java.util.Objects;
import java.util.UUID;

public abstract class Job {


    public Job(int jobNumber, UUID uuid, String name) {
        Objects.requireNonNull(uuid, "uuid cannot be null");
        Objects.requireNonNull(name, "name cannot be null");

        this.jobNumber = jobNumber;
        this.uuid = uuid;
        this.name = name;

        this.progress = Job.MIN_PROGRESS_VALUE;
        this.status = Status.PREPARING;
    }

    public Job(int jobNumber, Replay replay) {
        this(jobNumber, replay.getUUID(), replay.getName());
    }


    public static int MIN_PROGRESS_VALUE = 0;
    public static int MAX_PROGRESS_VALUE = 10000;


    private final int jobNumber;
    private final UUID uuid;
    private final String name;

    private volatile int progress;
    private volatile Status status;


    /**
     * The job number id associated with this job.
     * Job numbers are unique for the current running instance of Replay Packet Cleaner only.
     *
     * @return The job number.
     */
    public int getJobNumber() {
        return this.jobNumber;
    }

    /**
     * The job UUID associated with this job.
     * This UUID is used in places where a unique set of text is needed to ensure the program
     * doesn't run into issues if multiple instances of RPC are running simultaneously.
     *
     * @return The job uuid.
     */
    public UUID getUUID() {
        return this.uuid;
    }

    /**
     * A human-readable name of this job. Typically, is just the name of the source replay archive without the .mcpr extension.
     *
     * @return The name of this job. There are no guarantees that this name is unique from any other jobs known at runtime.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns a value between Job.MIN_PROGRESS_VALUE and Job.MAX_PROGRESS_VALUE that represents the percentage completion of the task associated with this progress tracker.
     */
    public int getProgress() {
        return this.progress;
    }

    /**
     * Sets the progress.
     * If the new value provided is less than Job.MIN_PROGRESS_VALUE, then the MIN_PROGRESS_VALUE will be used instead.
     * If the new value provided is greater than Job.MAX_PROGRESS_VALUE, then the MAX_PROGRESS_VALUE will be used instead.
     */
    protected void setProgress(int newValue) {
        if (newValue > Job.MAX_PROGRESS_VALUE) {
            newValue = Job.MAX_PROGRESS_VALUE;
        }
        if (newValue < Job.MIN_PROGRESS_VALUE) {
            newValue = Job.MIN_PROGRESS_VALUE;
        }

        this.progress = newValue;
    }

    /**
     * Set the Status.
     */
    protected void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }


//    /**
//     * Creates and returns a copy of the configuration being used for this job
//     *
//     * @return A copy of this job's configuration. Returned value will never been null.
//     */
//    public abstract Configuration<Option> getConfiguration();

    /**
     * Sets a flag to cancel processing of this job as soon as possible.
     */
    public abstract void cancel();

    /**
     * Check if a flag to cancel processing of this job has been set.
     *
     * @return True if the job has been canceled.
     */
    public abstract boolean isCanceled();


    public enum Status {
        /**
         * This status denotes that the job has been submitted to the queue and is being prepared for execution.
         */
        PREPARING,

        /**
         * This status denotes that the job is ready for execution and is currently waiting for a thread to become available.
         */
        WAITING,

        /**
         * This status denotes that the job is currently in the process of being executed.
         */
        IN_PROGRESS,

        /**
         * This status denotes that the job is fully completed and the replay file has been exported to the desired directory.
         */
        COMPLETED,

        /**
         * This status denotes that the job has been canceled.
         * This will typically occur if the application is signaled to terminate while the job is active, or (in the future once implemented) the user has canceled the job.
         */
        CANCELED,

        /**
         * This status denotes that the job has failed to complete for any reason (except reasons specified for CANCELED).
         * The typical reason would be that a problem had occurred during the preparing phase, or an unexpected error occurred during execution.
         */
        FAILED
    }

}
