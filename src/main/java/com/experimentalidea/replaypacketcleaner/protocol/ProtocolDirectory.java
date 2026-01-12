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
package com.experimentalidea.replaypacketcleaner.protocol;

import com.experimentalidea.replaypacketcleaner.ReplayPacketCleaner;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Serves as a directory to load, get, and manage {@link Protocol} objects.
 */
public class ProtocolDirectory {

    /**
     * Create a new Protocol Directory.
     * See loadProtocol(...) methods to load protocol mappings.
     */
    public ProtocolDirectory() {
        this.records = new ProtocolRecords(0, new Protocol[0], new HashMap<String, Integer>());
    }

    /// This object is synchronized on whenever the protocol records are being replaced.
    private final Object changeRecordsLock = new Object();

    /// Holds all currently loaded protocols.
    private volatile ProtocolRecords records;


    /**
     * Load a protocol from an input stream of JSON text.
     *
     * @param inputStream The input stream of JSON text.
     * @return The newly loaded {@link Protocol}. If this protocol version is already loaded, it will be replaced with the new one created from the input stream.
     * @throws IOException              If an I/O error occurs.
     * @throws NullPointerException     If inputStream is null.
     * @throws org.json.JSONException   If there is a syntax error or a duplicated key in the string of JSON text.
     * @throws IllegalArgumentException If the JSON text is not valid as protocol mappings.
     * @throws IllegalStateException    If more than one protocol enum type is linked to the same id for that category or vise versa.
     */
    public Protocol loadProtocol(InputStream inputStream) throws IOException {
        Objects.requireNonNull(inputStream, "inputStream cannot be null");
        StringBuilder builder = new StringBuilder(900000); // 900,000 characters - About 60,000 more than the current largest protocol json file. (as of protocol 773 for 1.21.9/10)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }

        return this.loadProtocol(builder.toString());
    }

    /**
     * Load a protocol from a string of JSON text.
     *
     * @param jsonString The string of JSON text.
     * @return The newly loaded {@link Protocol}. If this protocol version is already loaded, it will be replaced with the new one created from the JSON text.
     * @throws NullPointerException     If jsonString is null.
     * @throws org.json.JSONException   If there is a syntax error or a duplicated key in the string of JSON text.
     * @throws IllegalArgumentException If the JSON text is not valid as protocol mappings.
     * @throws IllegalStateException    If more than one protocol enum type is linked to the same id for that category or vise versa.
     */
    public Protocol loadProtocol(String jsonString) {
        Objects.requireNonNull(jsonString, "jsonString cannot be null");
        return this.loadProtocol(new JSONObject(jsonString));
    }

    /**
     * Load a protocol from a {@link JSONObject}.
     *
     * @param jsonObject The JSON Object containing protocol mappings.
     * @return The newly loaded {@link Protocol}. If this protocol version is already loaded, it will be replaced with the new one created from the JSON text.
     * @throws NullPointerException     If jsonObject is null.
     * @throws IllegalArgumentException If the JSON text is not valid as protocol mappings.
     * @throws IllegalStateException    If more than one protocol enum type is linked to the same id for that category or vise versa.
     */
    public Protocol loadProtocol(JSONObject jsonObject) {
        Objects.requireNonNull(jsonObject, "jsonObject cannot be null");

        this.ensureCurrentFormat(jsonObject);

        Protocol protocol = Protocol.fromJson(jsonObject);
        int protocolVersion = protocol.getProtocolVersion();

        synchronized (this.changeRecordsLock) {
            int offsetIndex = this.records.offsetIndex();
            int targetIndex = protocolVersion - offsetIndex;

            Protocol[] protocolsArray;

            // If the new protocol being loaded would be indexed out of bounds of the array, create a new expanded array for all the protocols...
            if (targetIndex < 0 || targetIndex >= this.records.protocols().length) {

                // Determine the upper & lower range required
                int lowestProtocolVersion = protocolVersion;
                int highestProtocolVersion = protocolVersion;
                for (Protocol existingProtocol : this.records.protocols()) {
                    if (existingProtocol != null) {
                        int existingProtocolVersion = existingProtocol.getProtocolVersion();

                        if (existingProtocolVersion < lowestProtocolVersion) {
                            lowestProtocolVersion = existingProtocolVersion;
                        } else if (existingProtocolVersion > highestProtocolVersion) {
                            highestProtocolVersion = existingProtocolVersion;
                        }
                    }
                }

                // Update the offset and target indexes for the new array
                offsetIndex = lowestProtocolVersion;
                targetIndex = protocolVersion - offsetIndex;

                // Create the new expanded array and copy all currently loaded protocols to it.
                protocolsArray = new Protocol[(highestProtocolVersion - lowestProtocolVersion) + 1];

                for (int i = 0; i < this.records.protocols().length; i++) {
                    if (this.records.protocols()[i] != null) {
                        protocolsArray[this.records.protocols()[i].getProtocolVersion() - offsetIndex] = this.records.protocols()[i];
                    }
                }
            } else {
                // Otherwise, copy the existing array.
                protocolsArray = new Protocol[this.records.protocols().length];
                System.arraycopy(this.records.protocols(), 0, protocolsArray, 0, protocolsArray.length);
            }

            // Add the new protocol.
            protocolsArray[targetIndex] = protocol;

            // Rebuild the mc version to protocol map.
            // (if two or more protocols claim support for the same MC version, an IllegalStateException will be thrown from this method)
            Map<String, Integer> mcVersionToProtocolMap = this.buildMCVersionMap(protocolsArray);

            // Lastly, replace the current records reference with the new one containing our newly loaded protocol.
            this.records = new ProtocolRecords(offsetIndex, protocolsArray, mcVersionToProtocolMap);
        }
        return protocol;
    }

    /**
     * Ensures the provided JSON Object conforms to the currently expected format & layout for protocol mappings and updating it where necessary.
     */
    public void ensureCurrentFormat(JSONObject jsonObject) {
        JSONObject emptyJSON = new JSONObject();

        JSONObject metadataNode = jsonObject.optJSONObject(TypeMetadata.JSON_NODE_METADATA, emptyJSON);
        int fileFormatVersion = jsonObject.optJSONObject(TypeMetadata.JSON_NODE_METADATA, emptyJSON).optInt(TypeMetadata.JSON_NODE_FILE_FORMAT_VERSION, -1);

        if (fileFormatVersion == -1 || fileFormatVersion == ReplayPacketCleaner.APP_PROTOCOL_JSON_VERSION) {
            return;
        }

        switch (fileFormatVersion) {
            case 0: { // Update from version 0 to version 1
                JSONObject blockNode = jsonObject.optJSONObject(TypeMetadata.JSON_NODE_REGISTRIES, emptyJSON).optJSONObject(TypeMetadata.JSON_NODE_BLOCK, emptyJSON);
                JSONObject itemNode = jsonObject.optJSONObject(TypeMetadata.JSON_NODE_REGISTRIES, emptyJSON).optJSONObject(TypeMetadata.JSON_NODE_ITEM, emptyJSON);

                JSONObject chainBlockNode = blockNode.optJSONObject("chain");
                if (chainBlockNode != null) {
                    blockNode.remove("chain");
                    blockNode.put("iron_chain", chainBlockNode);
                }

                JSONObject chainItemNode = itemNode.optJSONObject("chain");
                if (chainBlockNode != null) {
                    itemNode.remove("chain");
                    itemNode.put("iron_chain", chainItemNode);
                }

                metadataNode.put(TypeMetadata.JSON_NODE_FILE_FORMAT_VERSION, 1);

                this.ensureCurrentFormat(jsonObject);
            }

            // case 1: etc...

            // default: return;
        }
    }

    /**
     * Unload a Protocol in this Protocol Directory.
     *
     * @param protocolVersion The version of the protocol to be unloaded.
     * @return True if the protocol was found and removed, false otherwise.
     */
    public boolean unloadProtocol(int protocolVersion) {
        synchronized (this.changeRecordsLock) {

            int targetIndex = protocolVersion - this.records.offsetIndex();
            if (targetIndex < 0 || targetIndex >= this.records.protocols().length) {
                return false;
            }

            Protocol protocol = this.records.protocols()[targetIndex];
            if (protocol == null) {
                return false;
            }

            // Determine the new upper & lower range required for the new array.
            int lowestProtocolVersion = protocolVersion;
            int highestProtocolVersion = protocolVersion;
            for (int i = 0; i < this.records.protocols().length; i++) {
                if (i != targetIndex && this.records.protocols()[i] != null) {
                    int existingProtocolVersion = this.records.protocols()[i].getProtocolVersion();

                    if (existingProtocolVersion < lowestProtocolVersion) {
                        lowestProtocolVersion = existingProtocolVersion;
                    } else if (existingProtocolVersion > highestProtocolVersion) {
                        highestProtocolVersion = existingProtocolVersion;
                    }
                }
            }

            Protocol[] protocolsArray;
            int offsetIndex = lowestProtocolVersion;

            // If the new upper & lower range would allow for a smaller protocol array, create that smaller array.
            if ((lowestProtocolVersion - this.records.offsetIndex()) > 0 || (highestProtocolVersion - this.records.offsetIndex()) < (this.records.protocols().length - 1)) {
                protocolsArray = new Protocol[(highestProtocolVersion - lowestProtocolVersion) + 1];

                for (int i = 0; i < this.records.protocols().length; i++) {
                    Protocol entry = this.records.protocols()[i];
                    if (entry != null && entry != protocol) {
                        protocolsArray[this.records.protocols()[i].getProtocolVersion() - offsetIndex] = this.records.protocols()[i];
                    }
                }

            } else {
                // Otherwise, copy the existing array and remove the target protocol.
                protocolsArray = new Protocol[this.records.protocols().length];
                System.arraycopy(this.records.protocols(), 0, protocolsArray, 0, protocolsArray.length);
                protocolsArray[targetIndex] = null;
            }

            // Rebuild the mc version to protocol map.
            Map<String, Integer> mcVersionToProtocolMap = this.buildMCVersionMap(protocolsArray);

            // Lastly, replace the current records reference with the new.
            this.records = new ProtocolRecords(offsetIndex, protocolsArray, mcVersionToProtocolMap);

            return true;
        }
    }

    /**
     * Build a Minecraft version string to protocol version map.
     *
     * @param protocols The array of protocols to use in creating an Minecraft version to protocol version map.
     * @return A fully populated map of Minecraft version strings to protocol version.
     * @throws IllegalStateException If more than one protocol claims support for the same Minecraft version.
     */
    private Map<String, Integer> buildMCVersionMap(Protocol[] protocols) throws IllegalStateException {
        Map<String, Integer> mcVersionToProtocolMap = new HashMap<String, Integer>(protocols.length);
        for (Protocol protocol : protocols) {
            if (protocol != null) {
                String[] mcVersions = protocol.getMCVersions();
                for (String mcVersion : mcVersions) {
                    if (mcVersionToProtocolMap.containsKey(mcVersion)) {
                        throw new IllegalStateException(
                                "Multiple protocol versions cannot claim support for the same MC version: " +
                                        "Conflicting protocols versions " + mcVersionToProtocolMap.get(mcVersion) + " & " + protocol.getProtocolVersion() +
                                        " for MC version " + mcVersion);
                    }
                    mcVersionToProtocolMap.put(mcVersion, protocol.getProtocolVersion());
                }
            }
        }
        return mcVersionToProtocolMap;
    }


    /**
     * Get the protocol version associated with a Minecraft version string.
     *
     * @param mcVersion The Minecraft version as a string.
     *                  The version string must be 3 numbers separated by periods.
     *                  Providing "1.20" for example would always return null.
     *                  Whereas providing the version formated as "1.20.0" will return
     *                  a Protocol object if that version is supported & loaded.
     * @return The protocol version.
     * Or if the protocol isn't loaded & supported by this Protocol Directory, returns -1.
     */
    public int getProtocolVersion(String mcVersion) {
        Integer protocolVersion = this.records.mcVersionToProtocolMap().get(mcVersion);
        if (protocolVersion == null) {
            return -1;
        }
        return protocolVersion;
    }


    /**
     * Get a loaded {@link Protocol} by a Minecraft version string.
     *
     * @param mcVersion The Minecraft version as a string.
     *                  The version string must be 3 numbers separated by periods.
     *                  Providing "1.20" for example would always return null.
     *                  Whereas providing the version formated as "1.20.0" will return
     *                  a Protocol object if that version is supported & loaded.
     * @return The loaded Protocol.
     * Or if the protocol isn't loaded & supported by this Protocol Directory, returns null.
     */
    public Protocol getProtocol(String mcVersion) {
        return this.getProtocol(this.getProtocolVersion(mcVersion));
    }

    /**
     * Get a loaded {@link Protocol} by protocol version number.
     *
     * @param protocolVersion The networking protocol version.
     * @return The loaded Protocol.
     * Or if the protocol isn't loaded & supported by this Protocol Directory, returns null.
     */
    public Protocol getProtocol(int protocolVersion) {
        // To allow the records to be updated during runtime without thread synchronization,
        // the reference to the protocol records could be replaced with a new ProtocolMapRecords object at any time.
        // This is why we make a local variable to the records.
        ProtocolRecords protocolRecords = this.records;

        int targetIndex = protocolVersion - protocolRecords.offsetIndex();

        if (targetIndex < 0 || targetIndex >= protocolRecords.protocols().length) {
            return null;
        }

        // Note: Just because the targetIndex is within the range of the Protocol[],
        // doesn't mean a Protocol exists for a given protocolVersion.
        // This can return null.
        return protocolRecords.protocols()[targetIndex];
    }


    /**
     * Check if a protocol version is supported.
     *
     * @param protocolVersion The networking protocol version.
     * @return True if supported & loaded by this Protocol Directory instance.
     */
    public boolean isSupported(int protocolVersion) {
        return this.getProtocol(protocolVersion) != null;
    }

    /**
     * Check if a protocol version is supported & loaded by Minecraft version.
     *
     * @param mcVersion The Minecraft version as a string.
     *                  The version string must be 3 numbers separated by periods.
     *                  Providing "1.20" for example would always return false.
     *                  Whereas providing the version formated as "1.20.0" will return
     *                  true or false based on if the protocol is loaded by this Protocol Directory.
     * @return True if supported & loaded by this Protocol Directory instance.
     */
    public boolean isSupported(String mcVersion) {
        return this.getProtocol(mcVersion) != null;
    }


    /**
     * Creates a list of all supports and loaded protocols.
     *
     * @return A list of loaded protocols. Ordered by oldest protocol version to the newest.
     */
    public List<Protocol> getSupportedProtocols() {
        List<Protocol> supportedList = new ArrayList<Protocol>();
        for (Protocol protocol : this.records.protocols()) {
            if (protocol != null) {
                supportedList.add(protocol);
            }
        }
        return supportedList;
    }

    /**
     * Creates a list of all supported and loaded protocol versions.
     *
     * @return A list of loaded protocol versions. Ordered by oldest protocol version to the newest.
     */
    public List<Integer> getSupportedProtocolVersions() {
        List<Integer> supportedList = new ArrayList<Integer>();
        for (Protocol protocol : this.records.protocols()) {
            if (protocol != null) {
                supportedList.add(protocol.getProtocolVersion());
            }
        }
        return supportedList;
    }

    /**
     * Creates a list of all Minecraft versions protocols that are supported and loaded.
     *
     * @return A list of supported Minecraft versions. Ordered by oldest Minecraft version to the newest.
     */
    public List<String> getSupportedMCVersions() {
        List<String> supportedList = new ArrayList<String>(this.records.mcVersionToProtocolMap.keySet());
        Collections.sort(supportedList);
        return supportedList;
    }


    /**
     * Protocol Record is used by the {@link ProtocolDirectory} to hold all currently loaded protocols.
     *
     * @param offsetIndex            The offset used to index into the protocols array. (index = protocolVersion - offset)
     * @param protocols              The array of protocols.
     * @param mcVersionToProtocolMap A map of Minecraft version strings to protocol version numbers.
     */
    private record ProtocolRecords(int offsetIndex, Protocol[] protocols, Map<String, Integer> mcVersionToProtocolMap) {

    }

}
