package com.experimentalidea.replaypacketcleaner.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class LogsUpdater implements ActionListener {

    public LogsUpdater(JTabbedPane tabbedReplayPane, JTextArea logsTabTextArea, LinkedBlockingDeque<LogRecord> logQueue) {
        this.tabbedReplayPane = tabbedReplayPane;
        this.logsTabTextArea = logsTabTextArea;
        this.logQueue = logQueue;
    }

    private final JTabbedPane tabbedReplayPane;
    private final JTextArea logsTabTextArea;
    private final LinkedBlockingDeque<LogRecord> logQueue;

    private final SimpleFormatter formatter = new SimpleFormatter();
    private final LinkedList<String> logEntries = new LinkedList<>();
    private int severeCount = 0;

    private static final int MAX_LOG_ENTRIES = 512;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean dirty = false;
        while (true) {
            LogRecord logRecord = this.logQueue.poll();
            if (logRecord == null) {
                break;
            }

            if (this.logEntries.size() > MAX_LOG_ENTRIES) {
                this.logEntries.removeFirst();
            }
            this.logEntries.add(this.formatter.format(logRecord));

            if (logRecord.getLevel() == Level.SEVERE) {
                this.severeCount++;
            }

            dirty = true;
        }

        if (dirty) {
            StringBuilder builder = new StringBuilder(1024);
            this.logEntries.forEach(builder::append);
            this.logsTabTextArea.setText(builder.toString());
            if (this.severeCount > 0) {
                this.tabbedReplayPane.setTitleAt(MainWindow.REPLAYS_TAB_LOGS,"Logs (" + severeCount + ")");
            }
        }
    }
}
