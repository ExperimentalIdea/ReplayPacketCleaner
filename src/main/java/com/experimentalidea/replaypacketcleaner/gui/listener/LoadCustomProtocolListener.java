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
import com.experimentalidea.replaypacketcleaner.protocol.Protocol;
import com.experimentalidea.replaypacketcleaner.protocol.ProtocolDirectory;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

public class LoadCustomProtocolListener implements ActionListener {

    public LoadCustomProtocolListener(MainWindow mainWindow, ProtocolDirectory protocolDirectory) {
        this.mainWindow = mainWindow;
        this.protocolDirectory = protocolDirectory;
    }


    private final MainWindow mainWindow;
    private final ProtocolDirectory protocolDirectory;


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
        fileChooser.setFileFilter(new FileNameExtensionFilter(".json", "json"));
        fileChooser.setFileHidingEnabled(false);

        int returnState = fileChooser.showOpenDialog(this.mainWindow.getMainFrame());

        if (returnState == JFileChooser.APPROVE_OPTION) {
            StringBuilder log = new StringBuilder();
            File[] selectedFiles = fileChooser.getSelectedFiles();
            for (File file : selectedFiles) {
                try {
                    Protocol protocol = this.protocolDirectory.loadProtocol(new FileInputStream(file));

                    log.append("Successfully loaded custom protocol \"").append(file.getName()).append("\" for protocol version: ").append(protocol.getProtocolVersion()).append(" ").append(Arrays.toString(protocol.getMCVersions())).append("\n");

                } catch (Exception exception) {
                    log.append("Failed to load \"").append(file.getName()).append("\" as custom protocol: ").append(exception.getMessage()).append("\n");
                    System.out.println("Failed to load \"" + file.getName() + "\" as custom protocol: " + exception.getMessage());
                    exception.printStackTrace();
                }
                log.append("\n");
            }
            JOptionPane.showMessageDialog(this.mainWindow.getMainFrame(), log.toString());
        }
    }

}
