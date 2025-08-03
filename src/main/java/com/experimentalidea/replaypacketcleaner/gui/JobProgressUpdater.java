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
package com.experimentalidea.replaypacketcleaner.gui;

import com.experimentalidea.replaypacketcleaner.job.TaskTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.UUID;

public class JobProgressUpdater implements ActionListener {


    public JobProgressUpdater(ReplayList jobList, Map<UUID, TaskTracker> taskTrackerMap, JProgressBar overallProgressBar) {
        if (jobList == null) {
            throw new IllegalArgumentException("jobList cannot be null");
        }
        if (taskTrackerMap == null) {
            throw new IllegalArgumentException("taskTrackerMap cannot be null");
        }
        if (overallProgressBar == null) {
            throw new IllegalArgumentException("overallProgressBar cannot be null");
        }

        this.jobList = jobList;
        this.taskTrackerMap = taskTrackerMap;
        this.overallProgressBar = overallProgressBar;
    }

    private final ReplayList jobList;
    private final Map<UUID, TaskTracker> taskTrackerMap;
    private final JProgressBar overallProgressBar;

    private  final DecimalFormat decimalFormat = new DecimalFormat("##0.00");


    // Executes at a regular interval to update the UI
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int numberOfCompletedJobs = 0;
        int numberOfJobs = 0;
        int overallProgress = 0;
        for (int i = 0; i < this.jobList.size(); i++) {
            UUID jobUUID = this.jobList.getUUID(i);
            TaskTracker taskTracker = this.taskTrackerMap.get(jobUUID);

            if (taskTracker != null) {
                switch (taskTracker.getStatus()) {
                    case PREPARING:
                        numberOfJobs++;
                        this.jobList.updateLabel(i, "[PREPARING]   " + this.jobList.getFile(i).getName());
                        break;

                    case WAITING:
                        numberOfJobs++;
                        this.jobList.updateLabel(i, "[WAITING]   " + this.jobList.getFile(i).getName());
                        break;

                    case IN_PROGRESS:
                        numberOfJobs++;
                        overallProgress += taskTracker.getProgress();
                        this.jobList.updateLabel(i, "[" + this.decimalFormat.format((taskTracker.getProgress() / (double) TaskTracker.MAX_VALUE) * 100.0) + "%]   " + this.jobList.getFile(i).getName());
                        break;

                    case COMPLETED:
                        numberOfJobs++;
                        numberOfCompletedJobs++;
                        overallProgress += taskTracker.getProgress();
                        this.jobList.updateLabel(i, "[COMPLETED]   " + this.jobList.getFile(i).getName());
                        break;

                    case CANCELED:
                        this.jobList.updateLabel(i, "[CANCELED]   " + this.jobList.getFile(i).getName());
                        break;

                    case FAILED:
                        this.jobList.updateLabel(i, "[FAILED]   " + this.jobList.getFile(i).getName());
                        break;
                }
            }
        }

        if (numberOfJobs == 0) {
            this.overallProgressBar.setValue(0);
            this.overallProgressBar.setString("");
        } else {
            double overallPercentage = (overallProgress / ((double) TaskTracker.MAX_VALUE * numberOfJobs)) * 100.0;
            this.overallProgressBar.setValue((int) overallPercentage);
            this.overallProgressBar.setString(this.decimalFormat.format(overallPercentage) + "% - " + numberOfCompletedJobs + " of " + numberOfJobs);
        }
    }


}
