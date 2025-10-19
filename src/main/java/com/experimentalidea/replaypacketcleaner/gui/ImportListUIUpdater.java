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

public class ImportListUIUpdater implements UIUpdater {

    public ImportListUIUpdater(ReplayList replayImportList, JButton removeAllButton, JButton removeSelectedButton, JButton exportButton, JMenuItem fileMenuExportItem, JMenuItem fileMenuExportTestItem) {
        if (replayImportList == null) {
            throw new IllegalArgumentException("replayImportList cannot be null");
        }
        if (removeAllButton == null) {
            throw new IllegalArgumentException("removeAllButton cannot be null");
        }
        if (removeSelectedButton == null) {
            throw new IllegalArgumentException("removeSelectedButton cannot be null");
        }
        if (exportButton == null) {
            throw new IllegalArgumentException("exportButton cannot be null");
        }
        if (fileMenuExportItem == null) {
            throw new IllegalArgumentException("fileMenuExportItem cannot be null");
        }
        if (fileMenuExportTestItem == null) {
            throw new IllegalArgumentException("fileMenuExportTestItem cannot be null");
        }

        this.replayImportList = replayImportList;
        this.removeAllButton = removeAllButton;
        this.removeSelectedButton = removeSelectedButton;
        this.exportButton = exportButton;
        this.fileMenuExportItem = fileMenuExportItem;
        this.fileMenuExportTestItem = fileMenuExportTestItem;
    }


    private final ReplayList replayImportList;
    private final JButton removeAllButton;
    private final JButton removeSelectedButton;
    private final JButton exportButton;
    private final JMenuItem fileMenuExportItem;
    private final JMenuItem fileMenuExportTestItem;


    @Override
    public void updateUI() {
        boolean listHasEntries = this.replayImportList.size() != 0;
        this.removeAllButton.setEnabled(listHasEntries);
        this.removeSelectedButton.setEnabled(this.replayImportList.getSelectedIndices().length != 0);
        this.exportButton.setEnabled(listHasEntries);
        this.fileMenuExportItem.setEnabled(listHasEntries);
        this.fileMenuExportTestItem.setEnabled(listHasEntries);
    }

}
