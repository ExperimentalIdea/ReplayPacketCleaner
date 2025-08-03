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

import java.util.UUID;

public class TaskTracker {

    /**
     * Creates a new TaskStatus object with progress set to TaskProgress.MIN_VALUE and status set to TaskStatus.WAITING.
     */
    public TaskTracker(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("provided uuid cannot be null");
        }
        this.uuid = uuid;
        this.progress = TaskTracker.MIN_VALUE;
        this.status = TaskStatus.PREPARING;
    }


    public static int MIN_VALUE = 0;
    public static int MAX_VALUE = 10000;

    private final UUID uuid;

    private volatile int progress;
    private volatile TaskStatus status;


    public UUID getUUID() {
        return this.uuid;
    }

    /**
     * Returns a value between TaskProgress.MIN_VALUE and TaskProgress.MAX_VALUE that represents the percentage completion of the task associated with this progress tracker.
     */
    public int getProgress() {
        return this.progress;
    }

    /**
     * Sets the progress.
     * If the new value provided is less than TaskProgress.MIN_VALUE, then the MIN_VALUE will be used instead.
     * If the new value provided is greater than TaskProgress.MAX_VALUE, then the MAX_VALUE will be used instead.
     */
    protected void setProgress(int newValue) {
        if (newValue > TaskTracker.MAX_VALUE) {
            newValue = TaskTracker.MAX_VALUE;
        }
        if (newValue < TaskTracker.MIN_VALUE) {
            newValue = TaskTracker.MIN_VALUE;
        }

        this.progress = newValue;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    /**
     * Set the Status.
     */
    public void setStatus(TaskStatus status) {
        this.status = status;
    }


    public enum TaskStatus {
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
