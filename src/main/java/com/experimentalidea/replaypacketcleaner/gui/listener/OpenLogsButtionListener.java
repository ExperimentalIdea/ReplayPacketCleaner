package com.experimentalidea.replaypacketcleaner.gui.listener;

import com.experimentalidea.replaypacketcleaner.ReplayPacketCleaner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OpenLogsButtionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            Desktop.getDesktop().open(ReplayPacketCleaner.APP_LOGS_FOLDER);
        } catch (IOException ignored) {
        }
    }

}
