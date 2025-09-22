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
 * Not intended for use by normal users.
 * <p>
 * This window is only accessible via the File menu when --showHiddenOptions flag is detected on startup.
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

        this.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                packetsJSONFile = null;
                packetsJSONStatus.setSelected(false);
                registriesJSONFile = null;
                registriesJSONStatus.setSelected(false);
                blocksJSONFile = null;
                blocksJSONStatus.setSelected(false);
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

                        JSONObject packetsJSON = loadJSON(packetsJSONFile);
                        JSONObject registriesJSON = loadJSON(registriesJSONFile);
                        JSONObject blocksJSON = loadJSON(blocksJSONFile);

                        JSONObject rootProtocolJSON = new JSONObject();

                        JSONObject protocolNode = new JSONObject();
                        rootProtocolJSON.put(TypeMetadata.JSON_NODE_PROTOCOL, protocolNode);

                        // metadata
                        JSONObject metadataNode = new JSONObject();
                        protocolNode.put(TypeMetadata.JSON_NODE_METADATA, metadataNode);

                        metadataNode.put(TypeMetadata.JSON_NODE_FILE_FORMAT_VERSION, 0);
                        metadataNode.put(TypeMetadata.JSON_NODE_PROTOCOL_VERSION, protocolVersion);
                        metadataNode.put(TypeMetadata.JSON_NODE_MC_VERSIONS, new JSONArray(supportedMCVersions));

                        Map<ProtocolMetadata, String> referenceResources = new HashMap<ProtocolMetadata, String>();
                        List<ProtocolMetadata> referenceUnsupportedTypes = new ArrayList<ProtocolMetadata>();

                        // packets (configuration)
                        log.append("========\nClientbound Configuration Packets:\n");
                        for (PacketType.Configuration type : PacketType.Configuration.values()) {
                            referenceResources.put(type, referenceProtocol.getConfigurationResourceName(type));
                            if (referenceProtocol.getConfigurationPacketID(type) == -1) {
                                referenceUnsupportedTypes.add(type);
                            }
                        }
                        try {
                            populateJSON(rootProtocolJSON, packetsJSON, referenceResources, referenceUnsupportedTypes, PacketType.Configuration.values(), log, "configuration", "clientbound");
                        } catch (RuntimeException e) {
                            log.append(e.getMessage()).append("\nAssuming the configuration phase is unsupported by this protocol version.\n");
                        }
                        referenceResources.clear();
                        referenceUnsupportedTypes.clear();

                        // packets (login)
                        log.append("========\nClientbound Login Packets:\n");
                        for (PacketType.Login type : PacketType.Login.values()) {
                            referenceResources.put(type, referenceProtocol.getLoginResourceName(type));
                            if (referenceProtocol.getLoginPacketID(type) == -1) {
                                referenceUnsupportedTypes.add(type);
                            }
                        }
                        populateJSON(rootProtocolJSON, packetsJSON, referenceResources, referenceUnsupportedTypes, PacketType.Login.values(), log, "login", "clientbound");
                        referenceResources.clear();
                        referenceUnsupportedTypes.clear();

                        // packets (play)
                        log.append("========\nClientbound Play Packets:\n");
                        for (PacketType.Play type : PacketType.Play.values()) {
                            referenceResources.put(type, referenceProtocol.getPlayResourceName(type));
                            if (referenceProtocol.getPlayPacketID(type) == -1) {
                                referenceUnsupportedTypes.add(type);
                            }
                        }
                        populateJSON(rootProtocolJSON, packetsJSON, referenceResources, referenceUnsupportedTypes, PacketType.Play.values(), log, "play", "clientbound");
                        referenceResources.clear();
                        referenceUnsupportedTypes.clear();

                        // registries - entity type
                        log.append("========\nRegistries Entity Types:\n");
                        for (EntityType type : EntityType.values()) {
                            referenceResources.put(type, referenceProtocol.getEntityTypeResourceName(type));
                            if (referenceProtocol.getEntityTypeID(type) == -1) {
                                referenceUnsupportedTypes.add(type);
                            }
                        }
                        populateJSON(rootProtocolJSON, registriesJSON, referenceResources, referenceUnsupportedTypes, EntityType.values(), log, "minecraft:entity_type", "entries");
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
                        populateJSONBlocks(rootProtocolJSON, registriesJSON, blocksJSON, referenceResources, referenceUnsupportedTypes, log);
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
                        populateJSON(rootProtocolJSON, registriesJSON, referenceResources, referenceUnsupportedTypes, BlockEntity.values(), log, "minecraft:block_entity_type", "entries");
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
                        populateJSON(rootProtocolJSON, registriesJSON, referenceResources, referenceUnsupportedTypes, Item.values(), log, "minecraft:item", "entries");
                        referenceResources.clear();
                        referenceUnsupportedTypes.clear();


                        // At the end. output the file and show the log.
                        saveJSON(rootProtocolJSON, new File(fileChooser.getSelectedFile(), "protocol_" + protocolVersion + ".json"));
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


    public ProtocolDirectory getProtocolDirectory() {
        return protocolDirectory;
    }

    public JPanel getProtocolGenerationJPanel() {
        return protocolGenerationJPanel;
    }

    private void updateGenerateJSONFileButton() {
        this.generateJSONFileButton.setEnabled(this.packetsJSONFile != null && this.registriesJSONFile != null && this.blocksJSONFile != null && !this.generatedProtocolVersion.getText().isBlank() && !this.mcVersionSupport.getText().isBlank());
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

    private static void populateJSON(JSONObject rootProtocolJSON, JSONObject resourceJSON, Map<ProtocolMetadata, String> referenceResources, List<ProtocolMetadata> referenceUnsupportedTypes, ProtocolMetadata[] types, StringBuilder log, String resourceNode, String resourceEntriesNode) {
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
            for (String unknownResourceKey : jsonKeys) {
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

    private static void populateJSONBlocks(JSONObject rootProtocolJSON, JSONObject registriesJSON, JSONObject blocksJSON, Map<ProtocolMetadata, String> referenceResources, List<ProtocolMetadata> referenceUnsupportedTypes, StringBuilder log) {
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
            for (int i = 0; i < jsonKeys.size(); i++) {
                String unknownResourceKey = jsonKeys.get(i);
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
