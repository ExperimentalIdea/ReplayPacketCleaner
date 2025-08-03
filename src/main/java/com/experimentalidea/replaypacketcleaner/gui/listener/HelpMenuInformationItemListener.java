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

import com.experimentalidea.replaypacketcleaner.gui.InformationWindow;
import com.experimentalidea.replaypacketcleaner.gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpMenuInformationItemListener implements ActionListener {

    public HelpMenuInformationItemListener(MainWindow mainWindow, String title, String htmlText) {
        this.mainWindow = mainWindow;
        this.title = title;
        this.htmlText = htmlText;
    }

    private final MainWindow mainWindow;
    private final String title;
    private final String htmlText;


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JDialog helpFrame = new JDialog(this.mainWindow.getMainFrame(), this.title, true);

        InformationWindow helpWindow = new InformationWindow(this.htmlText);

        helpWindow.getCloseButton().addActionListener(actionEvent1 -> helpFrame.dispose());

        helpFrame.setContentPane(helpWindow.getJHelpPanel());

        helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        helpFrame.pack();
        helpFrame.setLocationRelativeTo(this.mainWindow.getMainFrame());
        helpFrame.setMinimumSize(new Dimension(480, 520));
        helpFrame.setVisible(true);
    }

}
