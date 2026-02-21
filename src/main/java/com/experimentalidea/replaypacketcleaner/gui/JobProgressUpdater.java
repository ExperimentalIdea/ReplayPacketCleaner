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

import com.experimentalidea.replaypacketcleaner.job.Job;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class JobProgressUpdater implements ActionListener {


    public JobProgressUpdater(ReplayList jobList, Map<UUID, Job> jobTrackerMap, JProgressBar overallProgressBar, JFrame windowFrame) {
        Objects.requireNonNull(jobList, "jobList cannot be null");
        Objects.requireNonNull(jobTrackerMap, "jobTrackerMap cannot be null");
        Objects.requireNonNull(overallProgressBar, "overallProgressBar cannot be null");
        Objects.requireNonNull(windowFrame, "windowFrame cannot be null");

        this.jobList = jobList;
        this.jobTrackerMap = jobTrackerMap;
        this.overallProgressBar = overallProgressBar;
        this.windowFrame = windowFrame;
        this.originalTitle = windowFrame.getTitle();
    }

    private final ReplayList jobList;
    private final Map<UUID, Job> jobTrackerMap;
    private final JProgressBar overallProgressBar;
    private final JFrame windowFrame;
    private final String originalTitle;

    private final DecimalFormat decimalFormat = new DecimalFormat("##0.00");


    // Executes at a regular interval to update the UI
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int numberOfCompletedJobs = 0;
        int numberOfJobs = 0;
        int overallProgress = 0;
        for (int i = 0; i < this.jobList.size(); i++) {
            Job job = this.jobTrackerMap.get(this.jobList.getReplay(i).getUUID());

            if (job != null) {
                switch (job.getStatus()) {
                    case PREPARING:
                        numberOfJobs++;
                        this.jobList.updateLabel(i, "[PREPARING]   " + job.getName());
                        break;

                    case WAITING:
                        numberOfJobs++;
                        this.jobList.updateLabel(i, "[WAITING]   " + job.getName());
                        break;

                    case IN_PROGRESS:
                        numberOfJobs++;
                        overallProgress += job.getProgress();
                        this.jobList.updateLabel(i, "[" + this.decimalFormat.format((job.getProgress() / (double) Job.MAX_PROGRESS_VALUE) * 100.0) + "%]   " + job.getName());
                        break;

                    case COMPLETED:
                        numberOfJobs++;
                        numberOfCompletedJobs++;
                        overallProgress += job.getProgress();
                        this.jobList.updateLabel(i, "[COMPLETED]   " + job.getName());
                        break;

                    case CANCELED:
                        this.jobList.updateLabel(i, "[CANCELED]   " + job.getName());
                        break;

                    case FAILED:
                        this.jobList.updateLabel(i, "[FAILED]   " + job.getName());
                        break;
                }
            }
        }

        if (numberOfJobs == 0) {
            this.overallProgressBar.setValue(0);
            this.overallProgressBar.setString("");

        } else {
            double overallPercentage = (overallProgress / ((double) Job.MAX_PROGRESS_VALUE * numberOfJobs)) * 100.0;
            this.overallProgressBar.setValue((int) overallPercentage);
            this.overallProgressBar.setString(this.decimalFormat.format(overallPercentage) + "% - " + numberOfCompletedJobs + " of " + numberOfJobs);

            if (overallPercentage < 100.0) {
                this.windowFrame.setTitle((int) overallPercentage + "% - " + this.originalTitle);
            } else {
                this.windowFrame.setTitle(this.originalTitle);
            }
        }
    }


}
