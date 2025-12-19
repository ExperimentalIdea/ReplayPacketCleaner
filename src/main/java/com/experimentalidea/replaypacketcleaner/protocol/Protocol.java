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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Protocol {


    private Protocol(int protocolVersion,
                     String[] mcVersions,
                     ProtocolMapper<PacketType.Configuration> configurationMapper,
                     ProtocolMapper<PacketType.Login> loginMapper,
                     ProtocolMapper<PacketType.Play> playMapper,
                     ProtocolMapper<EntityType> entityTypeMapper,
                     ProtocolBlockMapper blockMapper,
                     ProtocolMapper<BlockEntity> blockEntityTypeMapper,
                     ProtocolMapper<Item> itemMapper)
            throws IllegalArgumentException, IllegalStateException {

        this.protocolVersion = protocolVersion;
        this.mcVersions = mcVersions;

        this.configurationMapper = configurationMapper;
        this.loginMapper = loginMapper;
        this.playMapper = playMapper;

        this.entityTypeMapper = entityTypeMapper;
        this.blockMapper = blockMapper;
        this.blockEntityTypeMapper = blockEntityTypeMapper;
        this.itemMapper = itemMapper;
    }


    private final int protocolVersion;
    private final String[] mcVersions;

    private final ProtocolMapper<PacketType.Configuration> configurationMapper;
    private final ProtocolMapper<PacketType.Login> loginMapper;
    private final ProtocolMapper<PacketType.Play> playMapper;

    private final ProtocolMapper<EntityType> entityTypeMapper;
    private final ProtocolBlockMapper blockMapper;
    private final ProtocolMapper<BlockEntity> blockEntityTypeMapper;
    private final ProtocolMapper<Item> itemMapper;


    public static Protocol fromJson(String jsonProtocolMappingsString) {
        return Protocol.fromJson(new JSONObject(jsonProtocolMappingsString));
    }

    public static Protocol fromJson(JSONObject jsonProtocolMappings) {
        if (jsonProtocolMappings == null) {
            throw new IllegalArgumentException("jsonProtocolMappings cannot be null");
        }
        JSONObject metadataNode = jsonProtocolMappings.optJSONObject(TypeMetadata.JSON_NODE_PROTOCOL, new JSONObject()).optJSONObject(TypeMetadata.JSON_NODE_METADATA, new JSONObject());
        if (!metadataNode.has(TypeMetadata.JSON_NODE_PROTOCOL_VERSION) || !metadataNode.has(TypeMetadata.JSON_NODE_FILE_FORMAT_VERSION) || !metadataNode.has(TypeMetadata.JSON_NODE_MC_VERSIONS)) {
            throw new IllegalArgumentException("The provided json is not valid protocol mappings. Missing metadata " + TypeMetadata.JSON_NODE_PROTOCOL + ", " + TypeMetadata.JSON_NODE_FILE_FORMAT_VERSION + ", and/or " + TypeMetadata.JSON_NODE_MC_VERSIONS);
        }

        int fileFormatVersion = metadataNode.optInt(TypeMetadata.JSON_NODE_FILE_FORMAT_VERSION, -1);
        if (fileFormatVersion == -1) {
            throw new IllegalArgumentException("The provided json is not valid protocol mappings. Missing metadata for " + TypeMetadata.JSON_NODE_FILE_FORMAT_VERSION);
        }

        int protocolVersion = metadataNode.optInt(TypeMetadata.JSON_NODE_PROTOCOL_VERSION, -1);
        if (protocolVersion == -1) {
            throw new IllegalArgumentException("The provided json is not valid protocol mappings. Missing metadata for " + TypeMetadata.JSON_NODE_PROTOCOL_VERSION);
        }

        JSONArray jsonArray = metadataNode.optJSONArray(TypeMetadata.JSON_NODE_MC_VERSIONS);
        if (jsonArray == null || jsonArray.isEmpty()) {
            throw new IllegalArgumentException("The provided json is not valid protocol mappings. Missing metadata for " + TypeMetadata.JSON_NODE_MC_VERSIONS);
        }

        String[] mcVersions = new String[jsonArray.length()];
        for (int i = 0; i < mcVersions.length; i++) {
            mcVersions[i] = jsonArray.get(i).toString();

            // Check that the version string matches the expected pattern (such as "1.21.8" for example)
            if (!mcVersions[i].matches("^\\d+\\.\\d+\\.\\d+$")) {
                throw new IllegalArgumentException("The provided json contains an invalid " + TypeMetadata.JSON_NODE_MC_VERSIONS + " entry: " + mcVersions[i]);
            }
        }

        // Ensure the Array of supported mc versions is order from oldest to newest version.
        Arrays.sort(mcVersions, (str1, str2) -> {
            StringTokenizer tokenizer1 = new StringTokenizer(str1, "."); // Should always be 3 tokens
            int majorVersion1 = Integer.parseInt(tokenizer1.nextToken());
            int minorVersion1 = Integer.parseInt(tokenizer1.nextToken());
            int patchVersion1 = Integer.parseInt(tokenizer1.nextToken());

            StringTokenizer tokenizer2 = new StringTokenizer(str2, "."); // Should always be 3 tokens
            int majorVersion2 = Integer.parseInt(tokenizer2.nextToken());
            int minorVersion2 = Integer.parseInt(tokenizer2.nextToken());
            int patchVersion2 = Integer.parseInt(tokenizer2.nextToken());

            if (majorVersion1 < majorVersion2) {
                return -1;
            }
            if (majorVersion1 > majorVersion2) {
                return 1;
            }

            if (minorVersion1 < minorVersion2) {
                return -1;
            }
            if (minorVersion1 > minorVersion2) {
                return 1;
            }

            return Integer.compare(patchVersion1, patchVersion2);
        });

        // Only load Configuration packet mappings if they are supported by the protocol.
        ProtocolMapper<PacketType.Configuration> configurationMapper;
        if (protocolVersion > Version.MC_1_20_1) {
            configurationMapper = new ProtocolMapper<PacketType.Configuration>(PacketType.Configuration.UNDEFINED, protocolVersion, jsonProtocolMappings);
        } else {
            configurationMapper = null;
        }
        ProtocolMapper<PacketType.Login> loginMapper = new ProtocolMapper<PacketType.Login>(PacketType.Login.UNDEFINED, protocolVersion, jsonProtocolMappings);
        ProtocolMapper<PacketType.Play> playMapper = new ProtocolMapper<PacketType.Play>(PacketType.Play.UNDEFINED, protocolVersion, jsonProtocolMappings);

        ProtocolMapper<EntityType> entityTypeMapper = new ProtocolMapper<EntityType>(EntityType.UNDEFINED, protocolVersion, jsonProtocolMappings);
        ProtocolBlockMapper blockMapper = new ProtocolBlockMapper(protocolVersion, jsonProtocolMappings);
        ProtocolMapper<BlockEntity> blockEntityTypeMapper = new ProtocolMapper<BlockEntity>(BlockEntity.UNDEFINED, protocolVersion, jsonProtocolMappings);
        ProtocolMapper<Item> itemMapper = new ProtocolMapper<Item>(Item.UNDEFINED, protocolVersion, jsonProtocolMappings);

        return new Protocol(protocolVersion, mcVersions, configurationMapper, loginMapper, playMapper, entityTypeMapper, blockMapper, blockEntityTypeMapper, itemMapper);
    }


    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    public String[] getMCVersions() {
        String[] copy = new String[this.mcVersions.length];
        System.arraycopy(this.mcVersions, 0, copy, 0, this.mcVersions.length);
        return copy;
    }


    public boolean isSupported(ProtocolState state) {
        if (state == ProtocolState.CONFIGURATION) {
            return this.configurationMapper == null;
        }
        return state != null;
    }


    /// Get the packet type by id. An unsupported id will return the undefined type.
    /// The Configuration phase is unsupported in protocol versions 763 (1.20.0/1) and older.
    public PacketType.Configuration getConfigurationPacketType(int id) {
        if (this.configurationMapper == null) {
            throw new IllegalStateException("This protocol version does not have a Configuration phase."); // todo add more info
        }
        return this.configurationMapper.getType(id);
    }

    /// returns -1 if packetType is null or unsupported by the protocol.
    /// The Configuration phase is unsupported in protocol versions 763 (1.20.0/1) and older.
    public int getConfigurationPacketID(PacketType.Configuration packetType) {
        if (this.configurationMapper == null) {
            throw new IllegalStateException("This protocol version does not have a Configuration phase."); // todo add more info
        }
        return this.configurationMapper.getID(packetType);
    }

    /// Returns and empty string if the resource cannot be found or if a resource name doesn't exist.
    /// The Configuration phase is unsupported in protocol versions 763 (1.20.0/1) and older.
    public String getConfigurationResourceName(PacketType.Configuration packetType) {
        if (this.configurationMapper == null) {
            throw new IllegalStateException("This protocol version does not have a Configuration phase."); // todo add more info
        }
        return this.configurationMapper.getResourceName(packetType);
    }

    /// Get packet type by resource name. Returns the undefined type if the provided resource is unknown.
    /// The Configuration phase is unsupported in protocol versions 763 (1.20.0/1) and older.
    public PacketType.Configuration getConfigurationPacketType(String resourceName) {
        if (this.configurationMapper == null) {
            throw new IllegalStateException("This protocol version does not have a Configuration phase."); // todo add more info
        }
        return this.configurationMapper.getType(resourceName);
    }


    /// Get the packet type by id. An unsupported id will return the undefined type.
    public PacketType.Login getLoginPacketType(int id) {
        return this.loginMapper.getType(id);
    }

    /// returns -1 if packetType is null or unsupported by the protocol.
    public int getLoginPacketID(PacketType.Login packetType) {
        return this.loginMapper.getID(packetType);
    }

    /// Returns and empty string if the resource cannot be found or if a resource name doesn't exist.
    public String getLoginResourceName(PacketType.Login packetType) {
        return this.loginMapper.getResourceName(packetType);
    }

    /// Get packet type by resource name. Returns the undefined type if the provided resource is unknown.
    public PacketType.Login getLoginPacketType(String resourceName) {
        return this.loginMapper.getType(resourceName);
    }


    /// Get the packet type by id. An unsupported id will return the undefined type.
    public PacketType.Play getPlayPacketType(int id) {
        return this.playMapper.getType(id);
    }

    /// returns -1 if packetType is null or unsupported by the protocol.
    public int getPlayPacketID(PacketType.Play packetType) {
        return this.playMapper.getID(packetType);
    }

    /// Returns and empty string if the resource cannot be found or if a resource name doesn't exist.
    public String getPlayResourceName(PacketType.Play packetType) {
        return this.playMapper.getResourceName(packetType);
    }

    /// Get packet type by resource name. Returns the undefined type if the provided resource is unknown.
    public PacketType.Play getPlayPacketType(String resourceName) {
        return this.playMapper.getType(resourceName);
    }


    public EntityType getEntityType(int id) {
        return this.entityTypeMapper.getType(id);
    }

    public int getEntityTypeID(EntityType entityType) {
        return this.entityTypeMapper.getID(entityType);
    }

    public String getEntityTypeResourceName(EntityType entityType) {
        return this.entityTypeMapper.getResourceName(entityType);
    }

    public EntityType getEntityType(String resourceName) {
        return this.entityTypeMapper.getType(resourceName);
    }


    public Block getBlock(int id) {
        return this.blockMapper.getType(id);
    }

    public Block getBlockByState(int state) {
        return this.blockMapper.getBlockByState(state);
    }

    public int getBlockID(Block block) {
        return this.blockMapper.getID(block);
    }

    public String getBlockResourceName(Block block) {
        return this.blockMapper.getResourceName(block);
    }

    public Block getBlock(String resourceName) {
        return this.blockMapper.getType(resourceName);
    }


    public BlockEntity getBlockEntity(int id) {
        return this.blockEntityTypeMapper.getType(id);
    }

    public int getBlockEntityID(BlockEntity blockEntity) {
        return this.blockEntityTypeMapper.getID(blockEntity);
    }

    public String getBlockEntityResourceName(BlockEntity blockEntity) {
        return this.blockEntityTypeMapper.getResourceName(blockEntity);
    }

    public BlockEntity getBlockEntity(String resourceName) {
        return this.blockEntityTypeMapper.getType(resourceName);
    }


    public Item getItem(int id) {
        return this.itemMapper.getType(id);
    }

    public int getItemID(Item item) {
        return this.itemMapper.getID(item);
    }

    public String getItemResourceName(Item item) {
        return this.itemMapper.getResourceName(item);
    }

    public Item getItem(String resourceName) {
        return this.itemMapper.getType(resourceName);
    }


    // JSON structure
    // protocol > metadata > protocolVersion : <int>
    // protocol > metadata > fileFormatVersion : <int>
    // protocol > metadata > mcVersions : <String[]>
    // protocol > packets > <state> > PacketType > resourceName : <String> (not present if for versions older than 1.13)
    // protocol > packets > <state> > PacketType > id : <int> (-1 == unsupported)
    // protocol > registries > block > <Block> > resourceName : <String> (not present if for versions older than 1.13)
    // protocol > registries > block > <Block> > id : <int> (-1 == unsupported)
    // protocol > registries > block > <Block> > states : <int[]> (mapping block states to blocks, not for reverse)
    // etc.

    // Need to map:
    // - PacketID
    // - EntityType
    // - Block (include block state to block id mapping? (but not the reverse))
    // - BlockEntityType ??? (used for Block Entity Data packet - Very short reg., so it'd be easy to add)
    // - BlockState ??? (used for Block Update packet - not the same as block id, but rather is an id for each unique block state for each block (see blocks.json resource)- probably won't ever implement)
    // - Item


}
