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
package com.experimentalidea.replaypacketcleaner.gui.listener;

import com.experimentalidea.replaypacketcleaner.ReplayPacketCleaner;
import com.experimentalidea.replaypacketcleaner.gui.MainWindow;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportReplaysButtonListener implements ActionListener {

    public ImportReplaysButtonListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    private final MainWindow mainWindow;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser() {
            @Override
            public JDialog createDialog(Component parent) {
                JDialog jDialog = super.createDialog(parent);
                jDialog.setMinimumSize(new Dimension(480, 360));
                return jDialog;
            }
        };

        fileChooser.setPreferredSize(new Dimension(640, 480));
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new FileNameExtensionFilter(ReplayPacketCleaner.DOT_MCPR_EXTENSION, ReplayPacketCleaner.DOT_MCPR_EXTENSION.replace(".", "")));
        fileChooser.setFileHidingEnabled(false);

        int returnState = fileChooser.showOpenDialog(this.mainWindow.getMainFrame());

        if (returnState == JFileChooser.APPROVE_OPTION) {
            this.mainWindow.AttemptImportOfReplayArchives(fileChooser.getSelectedFiles());
        }
    }

}
