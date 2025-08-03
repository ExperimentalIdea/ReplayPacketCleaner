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
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class InformationWindow {

    public InformationWindow(String htmlText) {

        this.htmlEditorPane.setFocusable(false);
        this.htmlEditorPane.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
        this.htmlEditorPane.setEditable(false);
        this.htmlEditorPane.setText(htmlText);

        this.htmlEditorPane.addHyperlinkListener(hyperlinkEvent -> {
            if (hyperlinkEvent.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(hyperlinkEvent.getURL().toURI());
                    } catch (IOException | URISyntaxException e) {
                        // TODO: log exception
                        throw new RuntimeException(e);
                    }
                } else {
                    // Appears support for .browse(...) on linux can be spotty. Try another method if it's unsupported.
                    if (System.getProperty("os.name").toLowerCase().contains("linux")) {
                        try {
                            Runtime.getRuntime().exec(new String[]{"xdg-open", hyperlinkEvent.getURL().toString()});
                        } catch (IOException ex) {
                            // TODO: log exception
                            throw new RuntimeException(ex);
                        }
                    }

                }
            }
        });
    }

    private JPanel jHelpPanel;
    private JEditorPane htmlEditorPane;
    private JButton closeButton;


    public JPanel getJHelpPanel() {
        return this.jHelpPanel;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

}
