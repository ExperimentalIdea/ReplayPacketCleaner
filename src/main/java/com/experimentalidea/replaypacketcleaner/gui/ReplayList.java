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

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Maintains internal lists of replay job details and updates the enclosed JList.
 */
public class ReplayList {

    public ReplayList(JList<String> jList) {
        if (jList == null) {
            throw new IllegalArgumentException("jList cannot be null");
        }

        this.uuidList = new ArrayList<UUID>();

        this.fileList = new ArrayList<File>();

        this.jList = jList;
        this.jListModel = new DefaultListModel<String>();
        this.jList.setModel(this.jListModel);

    }

    // All three lists are kept consistent with each other.
    // i.e. uuidList.get(index) corresponds with fileList.get(index) & jListModel.get(index)
    private final List<UUID> uuidList;
    private final List<File> fileList;
    private final JList<String> jList;
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
    public void add(UUID uuid, File file, String label) {
        if (uuid == null) {
            throw new IllegalArgumentException("uuid cannot be null");
        }
        if (file == null) {
            throw new IllegalArgumentException("file cannot be null");
        }
        if (label == null) {
            throw new IllegalArgumentException("label cannot be null");
        }
        if (this.uuidList.contains(uuid)) {
            throw new IllegalArgumentException("uuid already exists");
        }

        this.uuidList.add(uuid);
        this.fileList.add(file);
        this.jListModel.addElement(label);

        this.uiUpdater.updateUI();
    }

    /**
     * Generates a new UUID on add and returns that uuid.
     */
    public UUID add(File file, String label) {
        UUID uuid = UUID.randomUUID();
        this.add(uuid, file, label);
        return uuid;
    }

    /**
     * Generates a new UUID on add and returns that uuid. The label is derived from the result of file.getName().
     */
    public UUID add(File file) {
        return this.add(file, file.getName());
    }


    public int indexOf(Object object) {
        int index = this.indexOfUUID(object);
        if (index == -1) {
            index = this.indexOfFile(object);
            if (index == -1) {
                index = this.indexOfFileNamed(object);
                if (index == -1) {
                    index = this.indexOfLabel(object);
                }
            }
        }
        return index;
    }

    public int indexOfUUID(Object object) {
        for (int i = 0; i < this.uuidList.size(); i++) {
            if (this.uuidList.get(i).equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfFile(Object object) {
        for (int i = 0; i < this.fileList.size(); i++) {
            if (this.fileList.get(i).equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfFileNamed(Object object) {
        for (int i = 0; i < this.fileList.size(); i++) {
            if (this.fileList.get(i).equals(object)) {
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
     * Get the currently selected UUIDs of the entries within the jList
     */
    public UUID[] getSelectedUUIDs() {
        int[] selectedIndices = this.getSelectedIndices();
        UUID[] selectedUUIDs = new UUID[selectedIndices.length];
        for (int i = 0; i < selectedIndices.length; i++) {
            selectedUUIDs[i] = this.uuidList.get(selectedIndices[i]);
        }
        return selectedUUIDs;
    }

    /**
     * Get the currently selected Files of the entries within the jList
     */
    public File[] getSelectedFiles() {
        int[] selectedIndices = this.getSelectedIndices();
        File[] selectedFiles = new File[selectedIndices.length];
        for (int i = 0; i < selectedIndices.length; i++) {
            selectedFiles[i] = this.fileList.get(selectedIndices[i]);
        }
        return selectedFiles;
    }

    /**
     * Get the currently selected File Names of the entries within the jList
     */
    public String[] getSelectedFileNames() {
        int[] selectedIndices = this.getSelectedIndices();
        String[] selectedFileNames = new String[selectedIndices.length];
        for (int i = 0; i < selectedIndices.length; i++) {
            selectedFileNames[i] = this.fileList.get(selectedIndices[i]).getName();
        }
        return selectedFileNames;
    }

    /**
     * Get the currently selected File Names of the entries within the jList
     */
    public String[] getSelectedLabels() {
        int[] selectedIndices = this.getSelectedIndices();
        String[] selectedFileNames = new String[selectedIndices.length];
        for (int i = 0; i < selectedIndices.length; i++) {
            selectedFileNames[i] = this.fileList.get(selectedIndices[i]).getName();
        }
        return selectedFileNames;
    }


    public UUID getUUID(int index) {
        return this.uuidList.get(index);
    }

    public File getFile(int index) {
        return this.fileList.get(index);
    }

    public String getLabel(int index) {
        return this.jListModel.get(index);
    }


    public void updateLabel(int index, String label) {
        this.jListModel.set(index, label);

        this.uiUpdater.updateUI();
    }

    public void updateLabel(UUID uuid, String label) {
        this.jListModel.set(this.indexOfUUID(uuid), label);

        this.uiUpdater.updateUI();
    }


    public UUID remove(int index) {
        UUID removedUUID = this.uuidList.remove(index);
        this.fileList.remove(index);
        this.jListModel.remove(index);

        this.uiUpdater.updateUI();

        return removedUUID;
    }

    public UUID[] removeAll(int[] indices) {
        UUID[] removedUUIDs = new UUID[indices.length];
        for (int i = indices.length - 1; i >= 0; i--) {
            removedUUIDs[i] = this.remove(indices[i]);
        }
        return removedUUIDs;
    }

    public void clear() {
        this.uuidList.clear();
        this.fileList.clear();
        this.jListModel.clear();

        this.uiUpdater.updateUI();
    }


    public boolean containsUUID(UUID uuid) {
        return this.uuidList.contains(uuid);
    }

    public boolean containsFile(File file) {
        return this.fileList.contains(file);
    }

    public boolean containsFileNamed(String fileName) {
        for (File file : this.fileList) {
            if (file.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsLabel(String label) {
        return this.jListModel.contains(label);
    }


    public int size() {
        return this.uuidList.size();
    }


}
