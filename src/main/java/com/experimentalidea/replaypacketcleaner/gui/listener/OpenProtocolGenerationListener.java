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
import com.experimentalidea.replaypacketcleaner.gui.ProtocolGenerationWindow;
import com.experimentalidea.replaypacketcleaner.protocol.ProtocolDirectory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/// @see ProtocolGenerationWindow
public class OpenProtocolGenerationListener implements ActionListener {

    public OpenProtocolGenerationListener(MainWindow mainWindow, ProtocolDirectory protocolDirectory) {
        this.mainWindow = mainWindow;
        this.protocolDirectory = protocolDirectory;
    }


    private final MainWindow mainWindow;
    private final ProtocolDirectory protocolDirectory;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JDialog protocolGenerationFrame = new JDialog(this.mainWindow.getMainFrame(), "Protocol Generation Assistant", true);

        ProtocolGenerationWindow protocolGenerationWindow = new ProtocolGenerationWindow(this.protocolDirectory);

        protocolGenerationFrame.setContentPane(protocolGenerationWindow.getProtocolGenerationJPanel());

        protocolGenerationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        protocolGenerationFrame.pack();
        protocolGenerationFrame.setLocationRelativeTo(this.mainWindow.getMainFrame());
        protocolGenerationFrame.setMinimumSize(new Dimension(900, 640));
        protocolGenerationFrame.setVisible(true);
    }

}
