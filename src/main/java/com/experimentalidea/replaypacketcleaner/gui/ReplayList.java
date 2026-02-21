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

import com.experimentalidea.replaypacketcleaner.job.Replay;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Maintains internal lists of replay job details and updates the enclosed JList.
 */
public class ReplayList {

    public ReplayList(JList<String> jList) {
        Objects.requireNonNull(jList, "jList cannot be null");

        this.replayList = new ArrayList<Replay>();

        this.jList = jList;
        this.jListModel = new DefaultListModel<String>();
        this.jList.setModel(this.jListModel);

    }


    private final JList<String> jList;

    // These two lists are kept consistent with each other.
    // i.e. replayList.get(index) corresponds with jListModel.get(index)
    private final List<Replay> replayList;
    private final DefaultListModel<String> jListModel;

    private UIUpdater uiUpdater = new DefaultUIUpdater();


    public void setUIUpdater(UIUpdater uiUpdater) {
        this.uiUpdater = uiUpdater;
        if (this.uiUpdater == null) {
            this.uiUpdater = new DefaultUIUpdater();
        }
    }

    public UIUpdater getUIUpdater() {
        return this.uiUpdater;
    }


    /**
     * Add an entry to the job list
     */
    public void add(Replay replay) {
        Objects.requireNonNull(replay, "Replay object cannot be null");

        for (Replay entry : this.replayList) {
            if (entry.getUUID().equals(replay.getUUID())) {
                throw new IllegalStateException("UUID " + replay.getUUID() + " already exists");
            }
        }

        this.replayList.add(replay);
        this.jListModel.addElement(replay.getName());

        this.uiUpdater.updateUI();
    }


    public int indexOf(Object object) {
        int index = this.indexOfByUUID(object);
        if (index == -1) {
            index = this.indexOfByFile(object);
            if (index == -1) {
                index = this.indexOfByFileNamed(object);
                if (index == -1) {
                    index = this.indexOfLabel(object);
                }
            }
        }
        return index;
    }

    public int indexOfByUUID(Object object) {
        for (int i = 0; i < this.replayList.size(); i++) {
            if (this.replayList.get(i).getUUID().equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfByFile(Object object) {
        for (int i = 0; i < this.replayList.size(); i++) {
            if (this.replayList.get(i).getSourceFile().equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfByFileNamed(Object object) {
        for (int i = 0; i < this.replayList.size(); i++) {
            if (this.replayList.get(i).getSourceFile().getName().equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfLabel(Object object) {
        for (int i = 0; i < this.jListModel.size(); i++) {
            if (this.jListModel.get(i).equals(object)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Get the currently selected Indices of the entries within the jList
     */
    public int[] getSelectedIndices() {
        return this.jList.getSelectedIndices();
    }

    /**
     * Get the currently selected Replays of the entries within the jList
     */
    public Replay[] getSelectedReplays() {
        int[] selectedIndices = this.getSelectedIndices();
        Replay[] selectedReplays = new Replay[selectedIndices.length];
        for (int i = 0; i < selectedIndices.length; i++) {
            selectedReplays[i] = this.replayList.get(selectedIndices[i]);
        }
        return selectedReplays;
    }


    public Replay getReplay(int index) {
        return this.replayList.get(index);
    }

    public String getLabel(int index) {
        return this.jListModel.get(index);
    }


    public void updateLabel(int index, String label) {
        this.jListModel.set(index, label);

        this.uiUpdater.updateUI();
    }

    public void updateLabel(UUID uuid, String label) {
        this.jListModel.set(this.indexOfByUUID(uuid), label);

        this.uiUpdater.updateUI();
    }


    public Replay remove(int index) {
        Replay removedReplay = this.replayList.remove(index);
        this.jListModel.remove(index);

        this.uiUpdater.updateUI();

        return removedReplay;
    }

    public Replay[] removeAll(int[] indices) {
        Replay[] removedReplays = new Replay[indices.length];
        for (int i = indices.length - 1; i >= 0; i--) {
            removedReplays[i] = this.remove(indices[i]);
        }
        return removedReplays;
    }

    public void clear() {
        this.replayList.clear();
        this.jListModel.clear();

        this.uiUpdater.updateUI();
    }


    public boolean containsUUID(UUID uuid) {
        for (Replay replay : this.replayList) {
            if (replay.getUUID().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsFile(File file) {
        for (Replay replay : this.replayList) {
            if (replay.getSourceFile().equals(file)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsFileNamed(String fileName) {
        for (Replay replay : this.replayList) {
            if (replay.getSourceFile().getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsLabel(String label) {
        return this.jListModel.contains(label);
    }


    public int size() {
        return this.replayList.size();
    }


}
