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

import com.experimentalidea.replaypacketcleaner.*;
import com.experimentalidea.replaypacketcleaner.config.Configuration;
import com.experimentalidea.replaypacketcleaner.config.Option;
import com.experimentalidea.replaypacketcleaner.gui.listener.*;
import com.experimentalidea.replaypacketcleaner.job.Job;
import com.experimentalidea.replaypacketcleaner.job.ReplayMetadata;
import com.experimentalidea.replaypacketcleaner.job.TaskTracker;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MainWindow {


    public MainWindow(ReplayPacketCleaner instance, boolean showHiddenOptions) {
        this.replayPacketCleanerInstance = instance;

        this.profile = new Configuration<Option>(Option.class);

        this.mainFrame = new JFrame(ReplayPacketCleaner.APP_NAME + " v" + ReplayPacketCleaner.APP_VERSION);
        this.mainFrame.setContentPane(this.mainPanel);
        this.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        java.util.List<Image> icons = new ArrayList<Image>(2);
        icons.add(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/resources/icon32.png"))).getImage());
        icons.add(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/resources/icon64.png"))).getImage());
        this.mainFrame.setIconImages(icons);

        // menu bar initialization
        this.menuBar = new JMenuBar();

        this.fileMenu = new JMenu("File");
        this.fileMenuImportItem = new JMenuItem("Import");
        this.fileMenuExportItem = new JMenuItem("Export");
        this.fileMenuExportTestItem = new JMenuItem("Export Test Run");
        this.fileMenuCustomProtocolItem = new JMenuItem("Load Custom Protocol");
        this.fileMenuGenerateProtocolItem = new JMenuItem("Protocol Generation Assistant");

        this.fileMenuImportItem.addActionListener(new ImportReplaysButtonListener(this));
        this.fileMenuExportItem.addActionListener(new ExportButtonListener(this));
        this.fileMenuExportTestItem.addActionListener(new ExportButtonListener(this, true));
        this.fileMenuCustomProtocolItem.addActionListener(new LoadCustomProtocolListener(this, this.replayPacketCleanerInstance.getProtocolDirectory()));
        this.fileMenuGenerateProtocolItem.addActionListener(new OpenProtocolGenerationListener(this, this.replayPacketCleanerInstance.getProtocolDirectory()));

        this.fileMenuExportItem.setEnabled(false);
        this.fileMenuExportTestItem.setEnabled(false);

        this.fileMenu.add(this.fileMenuImportItem);
        this.fileMenu.add(this.fileMenuExportItem);
        if (showHiddenOptions) {
            this.fileMenu.add(this.fileMenuExportTestItem);
            this.fileMenu.add(this.fileMenuCustomProtocolItem);
            this.fileMenu.add(this.fileMenuGenerateProtocolItem);
        }

        this.menuBar.add(this.fileMenu);

        this.helpMenu = new JMenu("Help");
        this.helpMenuAboutItem = new JMenuItem("About");

        this.helpMenuAboutItem.addActionListener(new HelpMenuInformationItemListener(this, "About",
                "<p style=\"text-align: center;\"><b>" + ReplayPacketCleaner.APP_NAME + " v" + ReplayPacketCleaner.APP_VERSION + "</b>" +
                        "<br>" +
                        "<br>Copyright © 2025 ExperimentalIdea" +
                        "<br>" +
                        "<br>This software is licensed under the Apache License Version 2.0" +
                        "<br>You can obtain a copy of this license here" +
                        "<br><a href=\"http://www.apache.org/licenses/LICENSE-2.0\">http://www.apache.org/licenses/LICENSE-2.0</a>\n" +
                        "<br>" +
                        "<br>The source code for this project can be found on GitHub <a href=\"https://github.com/ExperimentalIdea/ReplayPacketCleaner\">here</a>." +
                        "<br>" +
                        "<br>Report an issue, request a feature, or ask for help" +
                        "<br><a href=\"https://github.com/ExperimentalIdea/ReplayPacketCleaner/issues\">GitHub Issue Tracker</a>" +
                        "<br><a href=\"https://discord.gg/dh3YyXpd2w\">ExperimentalIdea Discord Server</a>" +
                        "<br>" +
                        "<br>" +
                        "<br><b>DISCLAIMER</b>" +
                        "<br>This project is not affiliated with ReplayMod in any way. " +
                        "This tool may produce garbage replay files that fail to work properly or at all with ReplayMod. DO NOT EVER DELETE YOUR ORIGINAL REPLAY FILES! " +
                        "Any issues arising from using this tool should be reported on this project’s GitHub Issue Tracker or the ExperimentalIdea Discord Server.</p>"));

        this.helpMenu.add(this.helpMenuAboutItem);
        this.menuBar.add(this.helpMenu);

        this.mainFrame.setJMenuBar(this.menuBar);
        // end menu bar initialization


        this.mainFrame.setDropTarget(new ReplayFileDropTarget(this));


        this.importList = new ReplayList(this.importJList);
        this.importList.setUIUpdater(new ImportListUIUpdater(this.importList, this.removeAllButton, this.removeSelectedButton, this.exportButton, this.fileMenuExportItem, this.fileMenuExportTestItem));
        this.importJList.addListSelectionListener(new ImportListSelectionListener(this.importList));
        this.removeAllButton.addActionListener(new ImportListRemoveAllButtonListener(this.importList));
        this.removeSelectedButton.addActionListener(new ImportListRemoveSelectionListener(this.importList));

        this.importJList.setSelectionModel(new ListSelectionModelFix());

        this.importErrorTextField.setForeground(Color.RED);

        this.importButton.addActionListener(new ImportReplaysButtonListener(this));

        this.tabbedReplayPane.setEnabledAt(MainWindow.REPLAYS_TAB_JOBS, false);
        this.tabbedReplayPane.setEnabledAt(MainWindow.REPLAYS_TAB_LOGS, false);

        this.jobList = new ReplayList(this.jobJList);
        this.jobJList.setSelectionModel(new ListSelectionModelFix());

        this.jobTrackerMap = new HashMap<UUID, TaskTracker>();

        this.jobListUpdateTimer = new Timer(50, new JobProgressUpdater(this.jobList, this.jobTrackerMap, this.jobProgressBar, this.mainFrame));
        this.jobListUpdateTimer.setRepeats(true);
        this.jobListUpdateTimer.start();

        this.jobErrorTextField.setForeground(Color.RED);

        this.exportButton.addActionListener(new ExportButtonListener(this));

        // Option Panel Items
        TimeOverrideListener timeOverrideListener = new TimeOverrideListener(this.profile, this.overrideTimeCheckbox, this.setTimeTextField, this.setTimeTipText);
        this.overrideTimeCheckbox.addActionListener(timeOverrideListener);
        this.setTimeTextField.addActionListener(timeOverrideListener);
        this.setTimeTextField.addFocusListener(timeOverrideListener);
        this.setTimeTextField.getDocument().addDocumentListener(timeOverrideListener);
        ((AbstractDocument) this.setTimeTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            final Pattern regEx = Pattern.compile("\\d*");

            @Override
            public void replace(FilterBypass filterBypass, int offset, int length, String text, AttributeSet attributeSet) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if (!matcher.matches()) {
                    return;
                }
                super.replace(filterBypass, offset, length, text, attributeSet);
            }
        });

        WeatherOverrideListener weatherOverrideListener = new WeatherOverrideListener(this.profile, this.overrideWeatherDropdown, this.removeLightingStrikesCheckbox,
                this.rainLevelSlider, this.rainLevelSliderLabel, this.rainLevelSliderValueDisplay,
                this.thunderLevelSlider, this.thunderLevelSliderLabel, this.thunderLevelSliderValueDisplay);
        this.overrideWeatherDropdown.addActionListener(weatherOverrideListener);
        this.removeLightingStrikesCheckbox.addActionListener(weatherOverrideListener);
        this.rainLevelSlider.addChangeListener(weatherOverrideListener);
        this.thunderLevelSlider.addChangeListener(weatherOverrideListener);

        this.removeBlockAnimationCheckbox.addActionListener(new CheckboxListener(this.profile, Option.BLOCK_ANIMATION_REMOVE, this.removeBlockAnimationCheckbox));
        this.removeEntitiesCheckbox.addActionListener(new CheckboxListener(this.profile, Option.ENTITIES_REMOVE_ALL, this.removeEntitiesCheckbox));
        this.removeParticlesCheckbox.addActionListener(new CheckboxListener(this.profile, Option.PARTICLE_REMOVE_ALL, this.removeParticlesCheckbox));
        this.removeSoundCheckbox.addActionListener(new CheckboxListener(this.profile, Option.SOUND_REMOVE_ALL, this.removeSoundCheckbox));

        ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE); // Move this elsewhere?

        // finally (prepare to) display TODO: move elsewhere?
        this.mainFrame.setMinimumSize(new Dimension(900, 480));

        this.mainFrame.pack();
        this.mainFrame.setLocationRelativeTo(null); // center the window
        //this.mainFrame.setVisible(true);


        // Add this listener to ensure the application will terminate when the window is closed.
        this.mainFrame.addWindowListener(new CloseApplicationWindowListener(this.replayPacketCleanerInstance, this.jobListUpdateTimer));

    }


    public static final int REPLAYS_TAB_REPLAY = 0;
    public static final int REPLAYS_TAB_JOBS = 1;
    public static final int REPLAYS_TAB_LOGS = 2;

    public static final int OPTIONS_TAB_TIME_AND_WEATHER = 0;
    public static final int OPTIONS_TAB_MISCELLANEOUS = 1;


    private final ReplayPacketCleaner replayPacketCleanerInstance;

    private final Configuration<Option> profile;

    private final JFrame mainFrame;

    private JPanel mainPanel;

    private JButton importButton;

    private JToolBar toolBar;

    private JButton exportButton;
    private JTabbedPane tabbedReplayPane;
    private JTextArea thisIsATestTextArea;

    /// The importJList should NEVER be used directly.
    private JList<String> importJList;
    /// Quarries should only go through this importList.
    private final ReplayList importList;

    private JTextArea importErrorTextField;

    private JButton removeAllButton;
    private JButton removeSelectedButton;

    /// The jobJList should NEVER be used directly.
    private JList<String> jobJList;
    /// Quarries should only go through this jobList.
    private final ReplayList jobList;
    /// Map of job uuids to task trackers
    private final Map<UUID, TaskTracker> jobTrackerMap;

    private final Timer jobListUpdateTimer;

    private JProgressBar jobProgressBar;

    private JTextArea jobErrorTextField;

    // TODO: Implement job cancel function later
    private JButton cancelAllButton;
    private JButton cancelSelectedButton;

    private JTabbedPane tabbedOptionPane;
    private JPanel timeAndWeatherTab;
    private JCheckBox overrideTimeCheckbox;
    private JTextField setTimeTextField;
    private JLabel setTimeTipText;
    private JComboBox overrideWeatherDropdown;
    private JCheckBox removeLightingStrikesCheckbox;
    private JSlider rainLevelSlider;
    private JLabel rainLevelSliderLabel;
    private JLabel rainLevelSliderValueDisplay;
    private JSlider thunderLevelSlider;
    private JLabel thunderLevelSliderLabel;
    private JLabel thunderLevelSliderValueDisplay;

    private JPanel miscellaneousTab;
    private JCheckBox removeBlockAnimationCheckbox;
    private JCheckBox removeEntitiesCheckbox;
    private JCheckBox removeParticlesCheckbox;
    private JCheckBox removeSoundCheckbox;


    // Everything with the menu bar
    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenuItem fileMenuImportItem;
    private JMenuItem fileMenuExportItem;
    private JMenuItem fileMenuExportTestItem;
    private JMenuItem fileMenuCustomProtocolItem;
    private JMenuItem fileMenuGenerateProtocolItem;

    private JMenu helpMenu;
    private JMenuItem helpMenuAboutItem;


    public JFrame getMainFrame() {
        return this.mainFrame;
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    public ReplayList getImportList() {
        return this.importList;
    }

    /**
     * Attempts to import replay archive files. If the file is not valid, or the protocol is not supported, an error will be displayed & logged to the UI.
     *
     * @see ImportReplaysButtonListener
     * @see ReplayFileDropTarget
     */
    public void AttemptImportOfReplayArchives(File... files) {
        // Set the replay tab as selected.
        this.tabbedReplayPane.setSelectedIndex(MainWindow.REPLAYS_TAB_REPLAY);

        StringBuilder errorText = new StringBuilder("Could not import one or more files:");
        boolean errorOccurred = false;

        for (File file : files) {
            String fileName = file.getName();

            // Ensure the file is a .mcpr replay archive file.
            if (!file.isFile() || !fileName.toLowerCase().endsWith(ReplayPacketCleaner.DOT_MCPR_EXTENSION)) {
                errorText.append("\n  ").append(fileName).append(":  Not a replay");
                errorOccurred = true;
                continue;
            }

            try (ZipFile zipFile = new ZipFile(file)) {

                // Ensure the replay has the metaData.json file
                ZipEntry zipEntry = zipFile.getEntry(ReplayMetadata.METADATA_FILE_NAME);
                if (zipEntry == null) {
                    errorText.append("\n  ").append(fileName).append(":  ").append(ReplayMetadata.METADATA_FILE_NAME).append(" missing");
                    errorOccurred = true;
                    continue;
                }

                // Ensure the protocol the replay was recording in is supported
                ReplayMetadata replayMetadata = ReplayMetadata.fromInputSteam(zipFile.getInputStream(zipEntry));
                int protocolVersion = replayMetadata.getMetadataJson().getInt(ReplayMetadata.KEY_PROTOCOL);
                if (this.replayPacketCleanerInstance.getProtocolDirectory().getProtocol(protocolVersion) == null) {
                    errorText.append("\n  ").append(fileName).append(":  Unsupported protocol ").append(protocolVersion).append(" for ").append(replayMetadata.getMetadataJson().getString(ReplayMetadata.KEY_MC_VERSION));
                    errorOccurred = true;
                    continue;
                }

            } catch (Exception exception) {
                // If any error occurs
                errorText.append("\n  ").append(fileName).append(":  Exception Occurred - ").append(exception.getMessage());
                errorOccurred = true;
                continue;
            }

            // File is a valid replay. Ensure file isn't already imported
            if (this.importList.containsFileNamed(fileName)) {
                errorText.append("\n  ").append(fileName).append(":  Replay already imported");
                errorOccurred = true;
                continue;
            }

            // Verified valid replay file
            this.importList.add(file);
        }

        if (errorOccurred) {
            this.displayImportError(errorText.toString());
        }
    }

    private void displayImportError(String text) {
        this.importErrorTextField.setText(text);
        this.importErrorTextField.setVisible(true);
        // TODO: Log to log tab
        System.out.println(text);

        // After 15 seconds, hide the import error text field.
        Timer timer = new Timer(15000, actionEvent -> {
            if (importErrorTextField.getText().equals(text)) {
                importErrorTextField.setVisible(false);
                importErrorTextField.setText("");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }


    public ReplayList getJobList() {
        return this.jobList;
    }

    public void submitAllAvailableJobs(File exportDirectory, boolean testFlag) {
        // Set the job tab as selected.
        this.tabbedReplayPane.setSelectedIndex(MainWindow.REPLAYS_TAB_JOBS);
        this.tabbedReplayPane.setEnabledAt(MainWindow.REPLAYS_TAB_JOBS, true);

        StringBuilder errorText = new StringBuilder("Could not submit job(s):");
        boolean errorOccurred = false;

        if (!exportDirectory.exists()) {
            this.displayJobError(errorText.append("\n  ").append(exportDirectory.getPath()).append(":\n    Directory does not exist").toString());
            return;
        }

        if (!exportDirectory.isDirectory()) {
            this.displayJobError(errorText.append("\n  ").append(exportDirectory.getPath()).append(":\n    Not a directory").toString());
            return;
        }
        if (!Files.isReadable(exportDirectory.toPath()) || !Files.isWritable(exportDirectory.toPath())) {
            this.displayJobError(errorText.append("\n  ").append(exportDirectory.getPath()).append(":\n    No read/write access to directory").toString());
            return;
        }

        Configuration<Option> profileCopy = this.profile.copy();

        if (!profileCopy.equals(new Configuration<Option>(Option.class))) { // TODO: Compare vs currently active saved profile
            profileCopy.set(Option.PROFILE_METADATA_PROFILE_NAME, profileCopy.getString(Option.PROFILE_METADATA_PROFILE_NAME) + "*");
            profileCopy.set(Option.PROFILE_METADATA_GEN_DATE, System.currentTimeMillis());
        }

        // Submit replay jobs
        for (int i = 0; i < this.importList.size(); i++) {
            UUID jobUUID = this.importList.getUUID(i);
            File sourceFile = this.importList.getFile(i);

            if (!sourceFile.exists()) {
                errorText.append("\n  ").append(sourceFile.getPath()).append(":\n    Replay archive file does not exist");
                errorOccurred = true;
                continue;
            }

            TaskTracker taskTracker;

            try {
                taskTracker = this.replayPacketCleanerInstance.submitReplayJob(new Job(jobUUID, profileCopy, sourceFile, exportDirectory, testFlag));
            } catch (Exception exception) {
                // TODO: Log
                errorText.append("\n  ").append(sourceFile.getPath()).append(":\n    Exception: ").append(exception.getMessage());
                errorOccurred = true;
                continue;
            }

            this.jobTrackerMap.put(jobUUID, taskTracker);

            this.jobList.add(jobUUID, sourceFile, this.importList.getLabel(i));

        }

        this.importList.clear();

        if (errorOccurred) {
            this.displayImportError(errorText.toString());
        }

    }

    private void displayJobError(String text) {
        this.jobErrorTextField.setText(text);
        this.jobErrorTextField.setVisible(true);
        // TODO: Log to log tab
        System.out.println(text);

        // After 15 seconds, hide the export error text field.
        Timer timer = new Timer(15000, actionEvent -> {
            if (jobErrorTextField.getText().equals(text)) {
                jobErrorTextField.setVisible(false);
                jobErrorTextField.setText("");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

}
