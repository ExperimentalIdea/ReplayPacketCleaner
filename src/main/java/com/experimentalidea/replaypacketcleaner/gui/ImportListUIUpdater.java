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
import java.util.Objects;

public class ImportListUIUpdater implements UIUpdater {

    public ImportListUIUpdater(ReplayList replayImportList, JButton removeAllButton, JButton removeSelectedButton, JButton exportButton, JMenuItem fileMenuExportItem, JMenuItem fileMenuExportTestItem) {
        Objects.requireNonNull(replayImportList, "replayImportList cannot be null");
        Objects.requireNonNull(removeAllButton, "removeAllButton cannot be null");
        Objects.requireNonNull(removeSelectedButton, "removeSelectedButton cannot be null");
        Objects.requireNonNull(exportButton, "exportButton cannot be null");
        Objects.requireNonNull(fileMenuExportItem, "fileMenuExportItem cannot be null");
        Objects.requireNonNull(fileMenuExportTestItem, "fileMenuExportTestItem cannot be null");

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
