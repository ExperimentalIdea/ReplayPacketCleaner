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

import com.experimentalidea.replaypacketcleaner.ReplayPacketCleaner;
import com.experimentalidea.replaypacketcleaner.protocol.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;
import java.util.List;

/**
 * This window is used for assisting in adding new protocol version support to Replay Packet Cleaner.
 * It's intended as an internal tool to aid in adding version support and isn't something normal users are expected to interact with.
 * <p>
 * This window is only accessible via the File menu when --showHiddenOptions flag is detected on startup.
 * <p>
 * The code written here isn't up to the standard I'd like it to be at and is pretty much in an unmaintainable condition.
 * A code rewrite plus adding documentation for the protocol generation assistant is something that should probably be done before RPC hits a full 1.0 release.
 */
public class ProtocolGenerationWindow {

    public ProtocolGenerationWindow(ProtocolDirectory protocolDirectory) {
        this.protocolDirectory = protocolDirectory;

        List<Integer> supportedProtocols = protocolDirectory.getSupportedProtocolVersions();
        this.referenceProtocolDropdownVersions = new int[supportedProtocols.size()];
        for (int i = 0; i < supportedProtocols.size(); i++) {
            this.referenceProtocolDropdown.addItem(supportedProtocols.get(i) + "  " + Arrays.toString(protocolDirectory.getProtocol(supportedProtocols.get(i)).getMCVersions()));
            this.referenceProtocolDropdownVersions[i] = supportedProtocols.get(i);
        }

        this.importButton.addActionListener(new ActionListener() {
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

                int returnState = fileChooser.showOpenDialog(protocolGenerationJPanel);

                if (returnState == JFileChooser.APPROVE_OPTION) {
                    for (File file : fileChooser.getSelectedFiles()) {
                        String fileName = file.getName();
                        if (fileName.equalsIgnoreCase("packets.json")) {
                            packetsJSONFile = file;
                            packetsJSONStatus.setSelected(true);
                        } else if (fileName.equalsIgnoreCase("registries.json")) {
                            registriesJSONFile = file;
                            registriesJSONStatus.setSelected(true);
                        } else if (fileName.equalsIgnoreCase("blocks.json")) {
                            blocksJSONFile = file;
                            blocksJSONStatus.setSelected(true);
                        }
                    }

                    updateGenerateJSONFileButton();
                }
            }
        });

        this.packetInstructionsRefImportButton.addActionListener(new ActionListener() {
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
                fileChooser.setMultiSelectionEnabled(false);
                fileChooser.setFileFilter(new FileNameExtensionFilter(".json", "json"));
                fileChooser.setFileHidingEnabled(false);

                int returnState = fileChooser.showOpenDialog(protocolGenerationJPanel);

                if (returnState == JFileChooser.APPROVE_OPTION) {
                    packetsInstructionsRefJSONFile = fileChooser.getSelectedFile();
                    packetInstructionsRefStatus.setSelected(packetsInstructionsRefJSONFile != null);
                    packetInstructionsRefStatus.setText(packetsInstructionsRefJSONFile.getName());
                }
            }
        });

        this.packetInstructionsGenImportButton.addActionListener(new ActionListener() {
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
                fileChooser.setMultiSelectionEnabled(false);
                fileChooser.setFileFilter(new FileNameExtensionFilter(".json", "json"));
                fileChooser.setFileHidingEnabled(false);

                int returnState = fileChooser.showOpenDialog(protocolGenerationJPanel);

                if (returnState == JFileChooser.APPROVE_OPTION) {
                    packetsInstructionsGenJSONFile = fileChooser.getSelectedFile();
                    packetInstructionsGenStatus.setSelected(packetsInstructionsGenJSONFile != null);
                    packetInstructionsGenStatus.setText(packetsInstructionsGenJSONFile.getName());
                }
            }
        });

        this.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                packetsJSONFile = null;
                packetsJSONStatus.setSelected(false);
                registriesJSONFile = null;
                registriesJSONStatus.setSelected(false);
                blocksJSONFile = null;
                blocksJSONStatus.setSelected(false);

                packetsInstructionsRefJSONFile = null;
                packetInstructionsRefStatus.setSelected(false);
                packetInstructionsRefStatus.setText("");
                packetsInstructionsGenJSONFile = null;
                packetInstructionsGenStatus.setSelected(false);
                packetInstructionsGenStatus.setText("");

                generatedProtocolVersion.setText("");
                generationLogs.setText("");

                updateGenerateJSONFileButton();
            }
        });

        ActionListener actionListener = actionEvent -> {
            updateGenerateJSONFileButton();
        };
        this.generatedProtocolVersion.addActionListener(actionListener);
        this.mcVersionSupport.addActionListener(actionListener);

        this.generateJSONFileButton.addActionListener(new ActionListener() {
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
                fileChooser.setFileHidingEnabled(false);
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int returnState = fileChooser.showSaveDialog(protocolGenerationJPanel);

                if (returnState == JFileChooser.APPROVE_OPTION) {
                    generationLogs.setText("");
                    StringBuilder log = new StringBuilder();
                    long startTime = System.currentTimeMillis();

                    try {
                        Protocol referenceProtocol = protocolDirectory.getProtocol(referenceProtocolDropdownVersions[referenceProtocolDropdown.getSelectedIndex()]);
                        int referenceProtocolVersion = referenceProtocol.getProtocolVersion();
                        log.append("Reference Protocol Version: ").append(referenceProtocolVersion).append("\n");

                        int protocolVersion = Integer.parseInt(generatedProtocolVersion.getText());
                        log.append("Generated Protocol Version: ").append(protocolVersion).append("\n");

                        String[] supportedMCVersions = mcVersionSupport.getText().split(",");
                        log.append("Generated Supported MC Version: ").append(Arrays.toString(supportedMCVersions)).append("\n");

                        JSONObject packetsJSON = null;
                        if (packetsJSONFile != null) {
                            packetsJSON = loadJSON(packetsJSONFile);
                        }
                        JSONObject registriesJSON = loadJSON(registriesJSONFile);
                        JSONObject blocksJSON = loadJSON(blocksJSONFile);

                        JSONObject packetInstructionsRefJSON = null;
                        JSONObject packetInstructionsGenJSON = null;
                        boolean hasBurgerPacketInstructions = false;
                        if (packetsInstructionsRefJSONFile != null && packetsInstructionsGenJSONFile != null && packetsJSONFile == null) {
                            packetInstructionsRefJSON = loadJSON(packetsInstructionsRefJSONFile);
                            packetInstructionsRefJSON = packetInstructionsRefJSON.getJSONObject("packets").getJSONObject("packet");
                            packetInstructionsGenJSON = loadJSON(packetsInstructionsGenJSONFile);
                            packetInstructionsGenJSON = packetInstructionsGenJSON.getJSONObject("packets").getJSONObject("packet");
                            hasBurgerPacketInstructions = true;
                            if (isEqual(packetInstructionsRefJSON, packetInstructionsGenJSON)) {
                                log.append("\nNOTICE:\nAppears both the selected Burger packetInstructions files have the exact same content.\nEnsure the provided files are correct for the the reference and generated protocol!\n");
                            }
                        }

                        JSONObject rootProtocolJSON = new JSONObject();

                        JSONObject protocolNode = new JSONObject();
                        rootProtocolJSON.put(TypeMetadata.JSON_NODE_PROTOCOL, protocolNode);

                        // metadata
                        JSONObject metadataNode = new JSONObject();
                        protocolNode.put(TypeMetadata.JSON_NODE_METADATA, metadataNode);

                        metadataNode.put(TypeMetadata.JSON_NODE_FILE_FORMAT_VERSION, ReplayPacketCleaner.APP_PROTOCOL_JSON_VERSION);
                        metadataNode.put(TypeMetadata.JSON_NODE_PROTOCOL_VERSION, protocolVersion);
                        metadataNode.put(TypeMetadata.JSON_NODE_MC_VERSIONS, new JSONArray(supportedMCVersions));

                        JSONObject undefinedProtocolResourcesJSON = new JSONObject(rootProtocolJSON.toString());

                        Map<ProtocolMetadata, String> referenceResources = new HashMap<ProtocolMetadata, String>();
                        List<ProtocolMetadata> referenceUnsupportedTypes = new ArrayList<ProtocolMetadata>();
                        Map<ProtocolMetadata, Integer> referenceIds = new HashMap<ProtocolMetadata, Integer>();

                        // packets (configuration)
                        // Only supported in protocol versions 764+ (1.20.2+)
                        if (protocolVersion > Version.MC_1_20_1) {
                            log.append("========\nClientbound Configuration Packets:\n");
                            for (PacketType.Configuration type : PacketType.Configuration.values()) {
                                referenceResources.put(type, referenceProtocol.getConfigurationResourceName(type));
                                if (referenceProtocol.getConfigurationPacketID(type) == -1) {
                                    referenceUnsupportedTypes.add(type);
                                }
                                referenceIds.put(type, referenceProtocol.getConfigurationPacketID(type));
                            }
                        }
                        if (packetsJSON != null) {
                            try {
                                populateJSON(rootProtocolJSON, undefinedProtocolResourcesJSON, packetsJSON, referenceResources, referenceUnsupportedTypes, PacketType.Configuration.values(), log, "configuration", "clientbound");
                            } catch (RuntimeException e) {
                                log.append(e.getMessage()).append("\nAssuming the configuration phase is unsupported by this protocol version.\n");
                            }
                        } else if (hasBurgerPacketInstructions) {
                            populateProtocolJSONViaBurger(rootProtocolJSON, packetInstructionsRefJSON, packetInstructionsGenJSON, referenceIds, PacketType.Configuration.values(), log, "CONFIGURATION_CLIENTBOUND_");
                        } else {
                            log.append("\npackets.json not provided. Generating fields with default id value of -1 for all fields preset in reference.");
                            populateBlankProtocolJSON(rootProtocolJSON, referenceUnsupportedTypes, PacketType.Configuration.values(), log);
                        }
                        referenceResources.clear();
                        referenceUnsupportedTypes.clear();
                        referenceIds.clear();

                        // packets (login)
                        log.append("========\nClientbound Login Packets:\n");
                        for (PacketType.Login type : PacketType.Login.values()) {
                            referenceResources.put(type, referenceProtocol.getLoginResourceName(type));
                            if (referenceProtocol.getLoginPacketID(type) == -1) {
                                referenceUnsupportedTypes.add(type);
                            }
                            referenceIds.put(type, referenceProtocol.getLoginPacketID(type));
                        }
                        if (packetsJSON != null) {
                            populateJSON(rootProtocolJSON, undefinedProtocolResourcesJSON, packetsJSON, referenceResources, referenceUnsupportedTypes, PacketType.Login.values(), log, "login", "clientbound");
                        } else if (hasBurgerPacketInstructions) {
                            populateProtocolJSONViaBurger(rootProtocolJSON, packetInstructionsRefJSON, packetInstructionsGenJSON, referenceIds, PacketType.Login.values(), log, "LOGIN_CLIENTBOUND_");
                        } else {
                            log.append("\npackets.json not provided. Generating fields with default id value of -1 for all fields preset in reference.");
                            populateBlankProtocolJSON(rootProtocolJSON, referenceUnsupportedTypes, PacketType.Login.values(), log);
                        }
                        referenceResources.clear();
                        referenceUnsupportedTypes.clear();
                        referenceIds.clear();

                        // packets (play)
                        log.append("========\nClientbound Play Packets:\n");
                        for (PacketType.Play type : PacketType.Play.values()) {
                            referenceResources.put(type, referenceProtocol.getPlayResourceName(type));
                            if (referenceProtocol.getPlayPacketID(type) == -1) {
                                referenceUnsupportedTypes.add(type);
                            }
                            referenceIds.put(type, referenceProtocol.getPlayPacketID(type));
                        }
                        if (packetsJSON != null) {
                            populateJSON(rootProtocolJSON, undefinedProtocolResourcesJSON, packetsJSON, referenceResources, referenceUnsupportedTypes, PacketType.Play.values(), log, "play", "clientbound");
                        } else if (hasBurgerPacketInstructions) {
                            populateProtocolJSONViaBurger(rootProtocolJSON, packetInstructionsRefJSON, packetInstructionsGenJSON, referenceIds, PacketType.Play.values(), log, "PLAY_CLIENTBOUND_");
                        } else {
                            log.append("\npackets.json not provided. Generating fields with default id value of -1 for all fields preset in reference.");
                            populateBlankProtocolJSON(rootProtocolJSON, referenceUnsupportedTypes, PacketType.Play.values(), log);
                        }
                        referenceResources.clear();
                        referenceUnsupportedTypes.clear();
                        referenceIds.clear();

                        // registries - entity type
                        log.append("========\nRegistries Entity Types:\n");
                        for (EntityType type : EntityType.values()) {
                            referenceResources.put(type, referenceProtocol.getEntityTypeResourceName(type));
                            if (referenceProtocol.getEntityTypeID(type) == -1) {
                                referenceUnsupportedTypes.add(type);
                            }
                        }
                        populateJSON(rootProtocolJSON, undefinedProtocolResourcesJSON, registriesJSON, referenceResources, referenceUnsupportedTypes, EntityType.values(), log, "minecraft:entity_type", "entries");
                        referenceResources.clear();
                        referenceUnsupportedTypes.clear();

                        // registries - block
                        log.append("========\nRegistries Blocks:\n");
                        for (Block type : Block.values()) {
                            referenceResources.put(type, referenceProtocol.getBlockResourceName(type));
                            if (referenceProtocol.getBlockID(type) == -1) {
                                referenceUnsupportedTypes.add(type);
                            }
                        }
                        populateJSONBlocks(rootProtocolJSON, undefinedProtocolResourcesJSON, registriesJSON, blocksJSON, referenceResources, referenceUnsupportedTypes, log);
                        referenceResources.clear();
                        referenceUnsupportedTypes.clear();

                        // registries - block entity type
                        log.append("========\nRegistries Block Entity Types:\n");
                        for (BlockEntity type : BlockEntity.values()) {
                            referenceResources.put(type, referenceProtocol.getBlockEntityResourceName(type));
                            if (referenceProtocol.getBlockEntityID(type) == -1) {
                                referenceUnsupportedTypes.add(type);
                            }
                        }
                        populateJSON(rootProtocolJSON, undefinedProtocolResourcesJSON, registriesJSON, referenceResources, referenceUnsupportedTypes, BlockEntity.values(), log, "minecraft:block_entity_type", "entries");
                        referenceResources.clear();
                        referenceUnsupportedTypes.clear();

                        // registries - item
                        log.append("========\nRegistries Items:\n");
                        for (Item type : Item.values()) {
                            referenceResources.put(type, referenceProtocol.getItemResourceName(type));
                            if (referenceProtocol.getItemID(type) == -1) {
                                referenceUnsupportedTypes.add(type);
                            }
                        }
                        populateJSON(rootProtocolJSON, undefinedProtocolResourcesJSON, registriesJSON, referenceResources, referenceUnsupportedTypes, Item.values(), log, "minecraft:item", "entries");
                        referenceResources.clear();
                        referenceUnsupportedTypes.clear();


                        // At the end. output the file and show the log.
                        saveJSON(rootProtocolJSON, new File(fileChooser.getSelectedFile(), "protocol_" + protocolVersion + ".json"));
                        saveJSON(undefinedProtocolResourcesJSON, new File(fileChooser.getSelectedFile(), "protocol_" + protocolVersion + "_unknown_resource_mappings.json"));
                        log.append("========\nGenerated protocol file in ").append(System.currentTimeMillis() - startTime).append("ms.\n");
                        generationLogs.setText(log.toString());

                    } catch (Exception exception) {
                        generationLogs.setText("An exception has occurred: " + exception.getMessage());
                        exception.printStackTrace();
                    }
                }
            }
        });
    }

    private final ProtocolDirectory protocolDirectory;

    private File packetsJSONFile = null;
    private File registriesJSONFile = null;
    private File blocksJSONFile = null;

    private File packetsInstructionsRefJSONFile = null;
    private File packetsInstructionsGenJSONFile = null;

    private int[] referenceProtocolDropdownVersions;

    private JPanel protocolGenerationJPanel;

    private JButton importButton;
    private JTextArea generationLogs;
    private JComboBox<String> referenceProtocolDropdown;
    private JTextField generatedProtocolVersion;
    private JTextField mcVersionSupport;
    private JButton generateJSONFileButton;
    private JButton resetButton;
    private JCheckBox packetsJSONStatus;
    private JCheckBox registriesJSONStatus;
    private JCheckBox blocksJSONStatus;
    private JCheckBox packetInstructionsRefStatus;
    private JButton packetInstructionsRefImportButton;
    private JCheckBox packetInstructionsGenStatus;
    private JButton packetInstructionsGenImportButton;


    public ProtocolDirectory getProtocolDirectory() {
        return protocolDirectory;
    }

    public JPanel getProtocolGenerationJPanel() {
        return protocolGenerationJPanel;
    }

    private void updateGenerateJSONFileButton() {
        this.generateJSONFileButton.setEnabled(this.registriesJSONFile != null && this.blocksJSONFile != null && !this.generatedProtocolVersion.getText().isBlank() && !this.mcVersionSupport.getText().isBlank());
    }

    private static JSONObject loadJSON(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName() + " does not exist");
        }
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            throw new IOException(e);
        }

        // Burger json output start with and ends with '[' & ']'. Remove this characters.
        char[] firstChar = new char[1];
        builder.getChars(0, 1, firstChar, 0);
        if (firstChar[0] == '[') {
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(0);
        }

        return new JSONObject(builder.toString());
    }

    private static void saveJSON(JSONObject jsonObject, File file) throws IOException {
        if (file.exists()) {
            throw new FileAlreadyExistsException(file.getName() + " already exist");
        }

        try (BufferedWriter writter = new BufferedWriter(new FileWriter(file))) {
            writter.write(jsonObject.toString(2));
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    /// Below 1.21, data generators don't provide a packets.json.
    /// Just populate all the packet fields that are present within the reference with id's set to -1 for unsupported.
    /// For the moment, packet ids will have to be mapped by hand until another solution can be figured out.
    private static void populateBlankProtocolJSON(JSONObject rootProtocolJSON, List<ProtocolMetadata> referenceUnsupportedTypes, ProtocolMetadata[] types, StringBuilder log) {

        for (ProtocolMetadata type : types) {
            TypeMetadata<?> metadata = type.getMetadata();

            if (referenceUnsupportedTypes.contains(type)) {
                continue;
            }

            // Get the set of keys required to traverse the json object to the point where the ID & ResourceName should be.
            String[] jsonNodePaths = type.getMetadata().getJSONNodePaths();

            JSONObject currentNode = rootProtocolJSON;
            for (int i = 0; i < jsonNodePaths.length; i++) {
                // Traverse the jsonObject to the next node.
                JSONObject nextNode = currentNode.optJSONObject(jsonNodePaths[i]);
                if (nextNode == null) {
                    nextNode = new JSONObject();
                    currentNode.put(jsonNodePaths[i], nextNode);
                }
                currentNode = nextNode;
            }

            currentNode.put(TypeMetadata.JSON_NODE_ID, -1);
            // there is no resource available. Skip adding a resource field to the json object.
        }

        log.append("\nGenerated ").append(types.length).append(" types with default id field of -1.\n");
    }

    private static void populateJSON(JSONObject rootProtocolJSON, JSONObject undefinedProtocolResourcesJSON, JSONObject resourceJSON, Map<ProtocolMetadata, String> referenceResources, List<ProtocolMetadata> referenceUnsupportedTypes, ProtocolMetadata[] types, StringBuilder log, String resourceNode, String resourceEntriesNode) {
        if (resourceJSON.optJSONObject(resourceNode) != null) {
            JSONObject entriesNode = resourceJSON.getJSONObject(resourceNode).getJSONObject(resourceEntriesNode);

            List<String> jsonKeys = new ArrayList<String>(entriesNode.keySet());
            List<ProtocolMetadata> typesNotFound = new ArrayList<ProtocolMetadata>();

            for (ProtocolMetadata type : types) {
                TypeMetadata<?> metadata = type.getMetadata();
                String resource = referenceResources.get(type);
                int keyIndex = jsonKeys.indexOf(resource);

                // For tracking unmapped types
                if (keyIndex == -1) {
                    typesNotFound.add(type);
                    continue;
                }
                jsonKeys.remove(keyIndex);

                // At this point, it is confirmed that the resourceJSON contains an ID for this type.

                // Get the set of keys required to traverse the json object to the point where the ID & ResourceName should be.
                String[] jsonNodePaths = type.getMetadata().getJSONNodePaths();

                JSONObject currentNode = rootProtocolJSON;
                for (int i = 0; i < jsonNodePaths.length; i++) {
                    // Traverse the jsonObject to the next node.
                    JSONObject nextNode = currentNode.optJSONObject(jsonNodePaths[i]);
                    if (nextNode == null) {
                        nextNode = new JSONObject();
                        currentNode.put(jsonNodePaths[i], nextNode);
                    }
                    currentNode = nextNode;
                }

                currentNode.put(TypeMetadata.JSON_NODE_ID, entriesNode.getJSONObject(resource).getInt("protocol_id"));
                currentNode.put(TypeMetadata.JSON_NODE_RESOURCE, resource);
            }

            log.append("\n").append(typesNotFound.size()).append(" type(s) total could not be found.\n");
            for (ProtocolMetadata type : typesNotFound) {
                log.append(type.name()).append(",\n");
            }
            for (ProtocolMetadata refType : referenceUnsupportedTypes) {
                typesNotFound.remove(refType);
            }
            log.append("\n").append(typesNotFound.size()).append(" type(s) could not be found that were present in the reference.\n");
            for (ProtocolMetadata type : typesNotFound) {
                log.append(type.name()).append(",\n");
            }
            log.append("\n").append(jsonKeys.size()).append(" resources could not be mapped.\n");
            Collections.sort(jsonKeys);

            String[] jsonNodePaths = types[0].getMetadata().getJSONNodePaths(); // ignore the last entry - only need a path to the json object containing all mappings for these types.
            for (String unknownResourceKey : jsonKeys) {
                JSONObject currentNode = undefinedProtocolResourcesJSON;
                for (int i = 0; i < (jsonNodePaths.length - 1); i++) {
                    // Traverse the jsonObject to the next node.
                    JSONObject nextNode = currentNode.optJSONObject(jsonNodePaths[i]);
                    if (nextNode == null) {
                        nextNode = new JSONObject();
                        currentNode.put(jsonNodePaths[i], nextNode);
                    }
                    currentNode = nextNode;
                }
                JSONObject entrySource = entriesNode.getJSONObject(unknownResourceKey);
                JSONObject entryTarget = new JSONObject();
                entryTarget.put(TypeMetadata.JSON_NODE_ID, entrySource.getInt("protocol_id"));
                entryTarget.put(TypeMetadata.JSON_NODE_RESOURCE, unknownResourceKey);

                currentNode.put("*" + unknownResourceKey.replaceAll("minecraft:", ""), entryTarget);


                log.append(unknownResourceKey).append(" = ").append(entriesNode.getJSONObject(unknownResourceKey).getInt("protocol_id")).append("\n");
            }
            if (!jsonKeys.isEmpty()) {
                log.append("\nSuggest adding these types to their respective enum?\n");
                for (String unknownResourceKey : jsonKeys) {
                    log.append(unknownResourceKey.replaceAll("minecraft:", "").toUpperCase()).append(",\n");
                }
            }
        } else {
            throw new RuntimeException("No \"" + resourceNode + "\" field found within the provided resource file");
        }
    }

    private static void populateProtocolJSONViaBurger(JSONObject rootProtocolJSON, JSONObject packetInstructionsRefJSON, JSONObject packetInstructionsGenJSON, Map<ProtocolMetadata, Integer> referenceIds, ProtocolMetadata[] types, StringBuilder log, String nodesPrefix) {
        Set<String> packetInstructionsRefKeys = packetInstructionsRefJSON.keySet();

        List<String> jsonGenKeys = new ArrayList<String>();
        for (String genKey : packetInstructionsGenJSON.keySet()) {
            if (genKey.startsWith(nodesPrefix)) {
                jsonGenKeys.add(genKey);
            }
        }
        List<String> jsonGenKeysFound = new ArrayList<String>();
        Map<String, Integer> genKeyIDs = new HashMap<String, Integer>();

        List<ProtocolMetadata> jsonKeysConflictTypes = new ArrayList<ProtocolMetadata>();
        List<ProtocolMetadata> typesNotFound = new ArrayList<ProtocolMetadata>();

        for (ProtocolMetadata type : types) {
            int packetID = -1;

            int refPacketID = referenceIds.get(type);
            if (refPacketID == -1) {
                typesNotFound.add(type);
                continue;
            }

            JSONArray refInstructions = null;

            // Find the "instructions" JSONArray field and the "id" int matching our refPacketID from the reference protocol.
            boolean refFound = false;
            for (String refKey : packetInstructionsRefKeys) {
                if (refKey.startsWith(nodesPrefix)) {
                    JSONObject refNode = packetInstructionsRefJSON.getJSONObject(refKey);
                    if (refNode.getInt("id") == refPacketID) {
                        if (refFound) {
                            throw new RuntimeException("There are multiple nodes prefixed \"" + nodesPrefix + "\" with the id of " + refPacketID + " (for packetType " + type.name() + ") in the reference Burger json file");
                        }
                        refInstructions = refNode.optJSONArray("instructions");
                        if (refInstructions != null && refInstructions.isEmpty()) {
                            refInstructions = null;
                        }
                        refFound = true;
                    }
                }
            }

            if (refInstructions != null) {
                // Ensure if there aren't multiple matching refInstructions.
                // This is to handle an edge case where the ref has two packet types with matching instructions, but the gen doesn't.
                for (String refKey : packetInstructionsRefKeys) {
                    if (refKey.startsWith(nodesPrefix)) {
                        JSONObject refNode = packetInstructionsRefJSON.getJSONObject(refKey);
                        if (refPacketID != refNode.getInt("id")) {
                            JSONArray compareInstructions = refNode.optJSONArray("instructions");
                            if (compareInstructions != null && isEqual(refInstructions, compareInstructions)) {
                                // There are multiple matching refInstructions. dereference to prevent mapping the conflicting
                                refInstructions = null;
                                jsonKeysConflictTypes.add(type);
                                break;
                            }
                        }
                    }
                }
            }

            if (refInstructions != null) {

                // Find a node that contains an "instructions" node that is equal to the refInstructions.
                for (String genkey : jsonGenKeys) {
                    JSONObject genNode = packetInstructionsGenJSON.getJSONObject(genkey);
                    JSONArray genInstructions = genNode.optJSONArray("instructions");
                    if (genInstructions != null) {
                        if (isEqual(refInstructions, genInstructions)) {
                            // If the packet id has been found already, then there is a conflict! Avoid mapping a packet id to this type.
                            if (packetID != -1) {
                                packetID = -2;
                                jsonGenKeysFound.removeLast();
                                break;
                            }
                            jsonGenKeysFound.add(genkey);
                            packetID = genNode.getInt("id");
                        }
                    }
                }
            }

            if (packetID == -2) {
                jsonKeysConflictTypes.add(type);
                packetID = -1;
            }

            if (packetID == -1) {
                typesNotFound.add(type);
            }

            // Get the set of keys required to traverse the json object to the point where the ID & ResourceName should be.
            String[] jsonNodePaths = type.getMetadata().getJSONNodePaths();

            JSONObject currentNode = rootProtocolJSON;
            for (int i = 0; i < jsonNodePaths.length; i++) {
                // Traverse the jsonObject to the next node.
                JSONObject nextNode = currentNode.optJSONObject(jsonNodePaths[i]);
                if (nextNode == null) {
                    nextNode = new JSONObject();
                    currentNode.put(jsonNodePaths[i], nextNode);
                }
                currentNode = nextNode;
            }

            currentNode.put(TypeMetadata.JSON_NODE_ID, packetID);
        }

        log.append("\n").append(typesNotFound.size()).append(" type(s) total could not be found.\n");
        for (ProtocolMetadata type : typesNotFound) {
            log.append(type.name()).append(",\n");
        }
        for (ProtocolMetadata type : types) {
            if (referenceIds.get(type) == -1) {
                typesNotFound.remove(type);
            }
        }
        log.append("\n").append(typesNotFound.size()).append(" type(s) could not be found that were present in the reference.\n");
        for (ProtocolMetadata type : typesNotFound) {
            log.append(type.name()).append(",\n");
        }
        log.append("\n").append(jsonKeysConflictTypes.size()).append(" types had more than one packetID candidate and were not assigned.\n");
        for (ProtocolMetadata conflict : jsonKeysConflictTypes) {
            log.append(conflict).append(",\n");
        }
        Collections.sort(jsonGenKeys);
        log.append("\n").append(jsonGenKeys.size() - jsonGenKeysFound.size()).append(" Burger resources could not be mapped. Suggest adding these types to their respective enum?\n");
        for (String genKey : jsonGenKeys) {
            if (!jsonGenKeysFound.contains(genKey)) {
                log.append(genKey).append(" = ").append(packetInstructionsGenJSON.getJSONObject(genKey).getInt("id")).append("\n");
            }
        }
    }

    /// Compare two JSONArray objects.
    /// Appears the org.json library doesn't override .equals() for JSONArray or JSONObject, so we have to compare manually.
    /// Note: If the two json arrays contain the same contents, but in a different order between them, this will return false.
    /// Also note: Does not consider the possibility of a JSONArray within a JSONArray. Will always return false in that scenario.
    private static boolean isEqual(JSONArray jsonArray1, JSONArray jsonArray2) {
        if (jsonArray1.length() != jsonArray2.length()) {
            return false;
        }

        // Try to prove both json arrays are not equal to each other.
        for (int i = 0; i < jsonArray1.length(); i++) {
            Object entry1 = jsonArray1.get(i);
            Object entry2 = jsonArray2.opt(i);

            if (entry1 instanceof JSONObject && entry2 instanceof JSONObject) {
                if (!isEqual((JSONObject) entry1, (JSONObject) entry2)) {
                    return false;
                }
                continue;
            }

            // At this point, we know that we should be dealing with Numbers or Strings.
            if (!entry1.equals(entry2)) {
                return false;
            }
        }

        // At this point, the two json arrays are proven equal to each other.
        return true;
    }

    /// Compare two JSONObject's.
    /// Appears the org.json library doesn't override .equals() for JSONArray or JSONObject, so we have to compare manually.
    private static boolean isEqual(JSONObject jsonObject1, JSONObject jsonObject2) {
        if (jsonObject1.length() != jsonObject2.length()) {
            return false;
        }

        // Try to prove both json objects are not equal to each other.
        for (String key : jsonObject1.keySet()) {
            Object entry1 = jsonObject1.get(key);
            Object entry2 = jsonObject2.opt(key);

            if (entry2 == null) {
                return false;
            }

            if (entry1 instanceof JSONObject && entry2 instanceof JSONObject) {
                if (!isEqual((JSONObject) entry1, (JSONObject) entry2)) {
                    return false;
                }
                continue;
            }

            if (entry1 instanceof JSONArray && entry2 instanceof JSONArray) {
                if (!isEqual((JSONArray) entry1, (JSONArray) entry2)) {
                    return false;
                }
                continue;
            }

            // At this point, we know that we should be dealing with Numbers or Strings.
            if (!entry1.equals(entry2)) {
                return false;
            }
        }

        // At this point, the two json objects are proven equal to each other.
        return true;
    }

    private static void populateJSONBlocks(JSONObject rootProtocolJSON, JSONObject undefinedProtocolResourcesJSON, JSONObject registriesJSON, JSONObject blocksJSON, Map<ProtocolMetadata, String> referenceResources, List<ProtocolMetadata> referenceUnsupportedTypes, StringBuilder log) {
        if (registriesJSON.optJSONObject("minecraft:block") != null) {
            JSONObject entriesNode = registriesJSON.getJSONObject("minecraft:block").getJSONObject("entries");

            List<String> jsonKeys = new ArrayList<String>(entriesNode.keySet());
            Collections.sort(jsonKeys);

            // find all the block states and make it line up with the jsonKeys list
            List<int[]> blockStates = new ArrayList<int[]>(1024);
            for (String resourceName : jsonKeys) {
                JSONArray jsonArray = blocksJSON.getJSONObject(resourceName).getJSONArray("states");
                int[] states = new int[jsonArray.length()];
                for (int i = 0; i < states.length; i++) {
                    states[i] = jsonArray.getJSONObject(i).getInt("id");
                }
                blockStates.add(states);
            }

            List<ProtocolMetadata> typesNotFound = new ArrayList<ProtocolMetadata>();

            for (ProtocolMetadata type : Block.values()) {
                TypeMetadata<?> metadata = type.getMetadata();
                String resource = referenceResources.get(type);
                int keyIndex = jsonKeys.indexOf(resource);

                // For tracking unmapped types
                if (keyIndex == -1) {
                    typesNotFound.add(type);
                    continue;
                }
                jsonKeys.remove(keyIndex);
                int[] states = blockStates.get(keyIndex);
                blockStates.remove(keyIndex); // keep the blockStates list in sync with the jsonKeys list.

                // At this point, it is confirmed that the resourceJSON contains an ID for this type.

                // Get the set of keys required to traverse the json object to the point where the ID & ResourceName should be.
                String[] jsonNodePaths = type.getMetadata().getJSONNodePaths();

                JSONObject currentNode = rootProtocolJSON;
                for (int i = 0; i < jsonNodePaths.length; i++) {
                    // Traverse the jsonObject to the next node.
                    JSONObject nextNode = currentNode.optJSONObject(jsonNodePaths[i]);
                    if (nextNode == null) {
                        nextNode = new JSONObject();
                        currentNode.put(jsonNodePaths[i], nextNode);
                    }
                    currentNode = nextNode;
                }

                currentNode.put(TypeMetadata.JSON_NODE_ID, entriesNode.getJSONObject(resource).getInt("protocol_id"));
                currentNode.put(TypeMetadata.JSON_NODE_RESOURCE, resource);
                currentNode.put(TypeMetadata.JSON_NODE_BLOCKSTATES, new JSONArray(states));
            }

            log.append("\n").append(typesNotFound.size()).append(" type(s) total could not be found.\n");
            for (ProtocolMetadata type : typesNotFound) {
                log.append(type.name()).append(",\n");
            }
            for (ProtocolMetadata refType : referenceUnsupportedTypes) {
                typesNotFound.remove(refType);
            }
            log.append("\n").append(typesNotFound.size()).append(" type(s) could not be found that were present in the reference.\n");
            for (ProtocolMetadata type : typesNotFound) {
                log.append(type.name()).append(",\n");
            }
            log.append("\n").append(jsonKeys.size()).append(" resources could not be mapped.\n");

            String[] jsonNodePaths = Block.UNDEFINED.getMetadata().getJSONNodePaths(); // ignore the last entry - only need a path to the json object containing all mappings for these types.
            for (int i = 0; i < jsonKeys.size(); i++) {
                JSONObject currentNode = undefinedProtocolResourcesJSON;
                for (int n = 0; n < (jsonNodePaths.length - 1); n++) {
                    // Traverse the jsonObject to the next node.
                    JSONObject nextNode = currentNode.optJSONObject(jsonNodePaths[n]);
                    if (nextNode == null) {
                        nextNode = new JSONObject();
                        currentNode.put(jsonNodePaths[n], nextNode);
                    }
                    currentNode = nextNode;
                }
                String unknownResourceKey = jsonKeys.get(i);

                JSONObject entrySource = entriesNode.getJSONObject(unknownResourceKey);
                JSONObject entryTarget = new JSONObject();
                entryTarget.put(TypeMetadata.JSON_NODE_ID, entrySource.getInt("protocol_id"));
                entryTarget.put(TypeMetadata.JSON_NODE_RESOURCE, entrySource.getString("resource"));
                entryTarget.put(TypeMetadata.JSON_NODE_BLOCKSTATES, blockStates.get(i));

                currentNode.put("*" + jsonKeys.get(i).toUpperCase(), entryTarget);


                log.append(unknownResourceKey).append(" = ").append(entriesNode.getJSONObject(unknownResourceKey).getInt("protocol_id")).append("\n    blockstates: ").append(Arrays.toString(blockStates.get(i))).append("\n");
            }
            if (!jsonKeys.isEmpty()) {
                log.append("\nSuggest adding these types to their respective enum?\n");
                for (String unknownResourceKey : jsonKeys) {
                    log.append(unknownResourceKey.replaceAll("minecraft:", "").toUpperCase()).append(",\n");
                }
            }
        } else {
            throw new RuntimeException("No \"" + "minecraft:block" + "\" field found within the provided resource file");
        }
    }


}
