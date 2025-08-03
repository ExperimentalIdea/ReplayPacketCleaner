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

import com.experimentalidea.replaypacketcleaner.gui.MainWindow;
import com.experimentalidea.replaypacketcleaner.gui.ReplayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExportButtonListener implements ActionListener {

    public ExportButtonListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    private final MainWindow mainWindow;


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ReplayList importList = this.mainWindow.getImportList();
        if (importList.size() == 0) {
            return;
        }
        JFileChooser fileChooser = new JFileChooser() {
            @Override
            public JDialog createDialog(Component parent) {
                JDialog jDialog = super.createDialog(parent);
                jDialog.setMinimumSize(new Dimension(480, 360));
                return jDialog;
            }
        };

        fileChooser.setPreferredSize(new Dimension(640, 480));
        fileChooser.setFileHidingEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnState = fileChooser.showSaveDialog(this.mainWindow.getMainFrame());

        if (returnState == JFileChooser.APPROVE_OPTION) {
            this.mainWindow.submitAllAvailableJobs(fileChooser.getSelectedFile());
        }

    }

}
