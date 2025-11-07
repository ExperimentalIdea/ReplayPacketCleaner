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

public class ProtocolDirectory {

    public ProtocolDirectory() {
        this.records = new ProtocolRecords(0, new Protocol[0], new HashMap<String, Integer>());
    }

    private final Object changeRecordsLock = new Object();

    private volatile ProtocolRecords records;


    public Protocol loadProtocol(InputStream inputStream) throws IOException {
        StringBuilder builder = new StringBuilder(800000); // 800,000 characters - About 9,000 more than the current largest protocol json file. (as of protocol 772 for 1.21.7/8)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }

        return this.loadProtocol(builder.toString());
    }

    public Protocol loadProtocol(String jsonString) {
        return this.loadProtocol(new JSONObject(jsonString));
    }

    public Protocol loadProtocol(JSONObject jsonObject) {
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

    /// Ensures the provided json file conforms to the currently expected format.
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

    /// throws IllegalStateException if two or more protocols claim support for the same MC version.
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


    /// Get the protocol version for a Minecraft version via a version string (such as "1.21.8" for example)
    public int getProtocolVersion(String mcVersion) {
        Integer protocolVersion = this.records.mcVersionToProtocolMap().get(mcVersion);
        if (protocolVersion == null) {
            return -1;
        }
        return protocolVersion;
    }


    public Protocol getProtocol(String mcVersion) {
        return this.getProtocol(this.getProtocolVersion(mcVersion));
    }

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


    public boolean isSupported(int protocolVersion) {
        return this.getProtocol(protocolVersion) != null;
    }


    public boolean isSupported(String mcVersion) {
        return this.getProtocol(mcVersion) != null;
    }

    /// Compiles a list of all supported protocol versions
    public List<Integer> getSupportedProtocolVersions() {
        List<Integer> supportedList = new ArrayList<Integer>();
        for (Protocol protocol : this.records.protocols()) {
            supportedList.add(protocol.getProtocolVersion());
        }
        return supportedList;
    }

    /// Compiles a list of all supported MC versions
    public List<String> getSupportedMCVersions() {
        return new ArrayList<String>(this.records.mcVersionToProtocolMap.keySet());
    }


    private record ProtocolRecords(int offsetIndex, Protocol[] protocols, Map<String, Integer> mcVersionToProtocolMap) {

    }
}
