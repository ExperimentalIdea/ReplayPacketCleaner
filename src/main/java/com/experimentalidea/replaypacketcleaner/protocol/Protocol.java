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
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * A Protocol object wraps multiple instances of {@link ProtocolMapper}, providing methods for translating protocol ids to and from their respective enum types.
 * <p>
 * Instances of this object can be created via JSON string or {@link JSONObject} - See Protocol.fromJson(...)
 *
 * @see ProtocolDirectory
 * @see PacketType.Login
 * @see PacketType.Configuration
 * @see PacketType.Play
 * @see EntityType
 * @see Block
 * @see BlockEntity
 * @see Item
 */
public class Protocol {


    private Protocol(int protocolVersion,
                     String[] mcVersions,
                     ProtocolMapper<PacketType.Configuration> configurationMapper,
                     ProtocolMapper<PacketType.Login> loginMapper,
                     ProtocolMapper<PacketType.Play> playMapper,
                     ProtocolMapper<EntityType> entityTypeMapper,
                     ProtocolBlockMapper blockMapper,
                     ProtocolMapper<BlockEntity> blockEntityTypeMapper,
                     ProtocolMapper<Item> itemMapper) {

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


    /**
     * Create an instance of Protocol from a JSON string.
     *
     * @param jsonProtocolMappingsString A string of valid JSON text containing protocol mappings.
     * @return A fully initialize Protocol object.
     * @throws NullPointerException     If the provided string is null.
     * @throws org.json.JSONException   If there is a syntax error or a duplicated key in the provided string.
     * @throws IllegalArgumentException If the provided JSON string is not valid as protocol mappings.
     */
    public static Protocol fromJson(String jsonProtocolMappingsString) throws IllegalArgumentException {
        Objects.requireNonNull(jsonProtocolMappingsString, "jsonProtocolMappingsString cannot be null");
        return Protocol.fromJson(new JSONObject(jsonProtocolMappingsString));
    }

    /**
     * Create an instance of Protocol from a {@link JSONObject}.
     *
     * @param jsonProtocolMappings A {@link JSONObject} containing protocol mappings.
     * @return A fully initialize Protocol object.
     * @throws NullPointerException     If the provided JSON object is null.
     * @throws IllegalArgumentException If the provided JSON object is not valid as protocol mappings.
     */
    public static Protocol fromJson(JSONObject jsonProtocolMappings) throws IllegalArgumentException {
        // Protocol mappings JSON structure:
        // protocol > metadata > protocol_version : <int>
        // protocol > metadata > file_format_version : <int>
        // protocol > metadata > mc_versions : <String[]>
        // protocol > packets > <State> > <PacketType> > resource : <String> (not present for versions older than 1.21.0)
        // protocol > packets > <State> > <PacketType> > id : <int> (-1 == unsupported)
        // protocol > registries > <entity_type/block/block_entity/item> > resourceName : <String> (not present for versions older than 1.13)
        // protocol > registries > <entity_type/block/block_entity/item> > id : <int> (-1 == unsupported, if not present also considered unsupported)
        // protocol > registries > block > states : <int[]> (mapping block states to blocks, not so for the reverse)

        Objects.requireNonNull(jsonProtocolMappings, "jsonProtocolMappings cannot be null");

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
            configurationMapper = new ProtocolMapper<PacketType.Configuration>(PacketType.Configuration.UNDEFINED, jsonProtocolMappings);
        } else {
            configurationMapper = null;
        }
        ProtocolMapper<PacketType.Login> loginMapper = new ProtocolMapper<PacketType.Login>(PacketType.Login.UNDEFINED, jsonProtocolMappings);
        ProtocolMapper<PacketType.Play> playMapper = new ProtocolMapper<PacketType.Play>(PacketType.Play.UNDEFINED, jsonProtocolMappings);

        ProtocolMapper<EntityType> entityTypeMapper = new ProtocolMapper<EntityType>(EntityType.UNDEFINED, jsonProtocolMappings);
        ProtocolBlockMapper blockMapper = new ProtocolBlockMapper(jsonProtocolMappings);
        ProtocolMapper<BlockEntity> blockEntityTypeMapper = new ProtocolMapper<BlockEntity>(BlockEntity.UNDEFINED, jsonProtocolMappings);
        ProtocolMapper<Item> itemMapper = new ProtocolMapper<Item>(Item.UNDEFINED, jsonProtocolMappings);

        return new Protocol(protocolVersion, mcVersions, configurationMapper, loginMapper, playMapper, entityTypeMapper, blockMapper, blockEntityTypeMapper, itemMapper);
    }


    /**
     * Get the protocol version this Protocol represents.
     *
     * @return The protocol version number.
     */
    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    /**
     * Get the array of Minecraft versions supported by this Protocol.
     * The array is guaranteed to have at minimum one entry.
     * Each entry in the array will always match the regex "^\\d+\\.\\d+\\.\\d+$" (example: "1.20.0", or "26.1.0")
     *
     * @return The supported Minecraft versions. Ordered from oldest to newest.
     */
    public String[] getMCVersions() {
        String[] copy = new String[this.mcVersions.length];
        System.arraycopy(this.mcVersions, 0, copy, 0, this.mcVersions.length);
        return copy;
    }

    /**
     * Check if a protocol connection state is supported by this Protocol.
     *
     * @param state The protocol state.
     * @return True if supported, false otherwise.
     * @see ProtocolState
     */
    public boolean isSupported(ProtocolState state) {
        if (state == ProtocolState.CONFIGURATION) {
            return this.configurationMapper != null;
        }
        return state != null;
    }


    /**
     * Get a Configuration packet type by the id.
     *
     * @param id The id of the Configuration packet.
     * @return The Configuration type associated with the provided id.
     * Or if the id is not recognized, PacketType.Configuration.UNDEFINED will be returned instead.
     * @throws IllegalStateException If the Configuration protocol state is unsupported by this protocol.
     *                               (protocol versions 763 (1.20.0/1) and older)
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Configuration
     */
    public PacketType.Configuration getConfigurationPacketType(int id) {
        if (this.configurationMapper == null) {
            throw new IllegalStateException("This protocol version does not support the Configuration connection state.");
        }
        return this.configurationMapper.getType(id);
    }

    /**
     * Get a Configuration packet id by the type.
     *
     * @param packetType The Configuration packet type.
     * @return The id associated with the provided Configuration type. If the type is not supported by this protocol,
     * or the type is PacketType.Configuration.UNDEFINED, ProtocolMapper.UNDEFINED_ID (-1) will be returned instead.
     * @throws IllegalStateException If the Configuration protocol state is unsupported by this protocol.
     *                               (protocol versions 763 (1.20.0/1) and older)
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Configuration
     */
    public int getConfigurationPacketID(PacketType.Configuration packetType) {
        if (this.configurationMapper == null) {
            throw new IllegalStateException("This protocol version does not support the Configuration connection state.");
        }
        return this.configurationMapper.getID(packetType);
    }

    /**
     * Get a Configuration packet resource name by the type.
     *
     * @param packetType The Configuration packetType.
     * @return The resource associated with the provided Configuration type. If the type is not supported by this protocol,
     * or the type is PacketType.Configuration.UNDEFINED, or the type doesn't have a resource associated with it,
     * ProtocolMapper.UNDEFINED_RESOURCE_NAME (empty string) will be returned instead.
     * @throws IllegalStateException If the Configuration protocol state is unsupported by this protocol.
     *                               (protocol versions 763 (1.20.0/1) and older)
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Configuration
     */
    public String getConfigurationResourceName(PacketType.Configuration packetType) {
        if (this.configurationMapper == null) {
            throw new IllegalStateException("This protocol version does not support the Configuration connection state.");
        }
        return this.configurationMapper.getResourceName(packetType);
    }

    /**
     * Get a Configuration packet type by the resource name.
     *
     * @param resourceName The resource name of the Configuration packet.
     * @return The Configuration type associated with the provided resource.
     * Or if the resource is not recognized, PacketType.Configuration.UNDEFINED will be returned instead.
     * @throws IllegalStateException If the Configuration protocol state is unsupported by this protocol.
     *                               (protocol versions 763 (1.20.0/1) and older)
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Configuration
     */
    public PacketType.Configuration getConfigurationPacketType(String resourceName) {
        if (this.configurationMapper == null) {
            throw new IllegalStateException("This protocol version does not support the Configuration connection state.");
        }
        return this.configurationMapper.getType(resourceName);
    }


    /**
     * Get a Login packet type by the id.
     *
     * @param id The id of the Login packet.
     * @return The Login type associated with the provided id.
     * Or if the id is not recognized, PacketType.Login.UNDEFINED will be returned instead.
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Login
     */
    public PacketType.Login getLoginPacketType(int id) {
        return this.loginMapper.getType(id);
    }

    /**
     * Get a Login packet id by the type.
     *
     * @param packetType The Login packet type.
     * @return The id associated with the provided Login type. If the type is not supported by this protocol,
     * or the type is PacketType.Login.UNDEFINED, ProtocolMapper.UNDEFINED_ID (-1) will be returned instead.
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Login
     */
    public int getLoginPacketID(PacketType.Login packetType) {
        return this.loginMapper.getID(packetType);
    }

    /**
     * Get a Login packet resource name by the type.
     *
     * @param packetType The Login packetType.
     * @return The resource associated with the provided Login type. If the type is not supported by this protocol,
     * or the type is PacketType.Login.UNDEFINED, or the type doesn't have a resource associated with it,
     * ProtocolMapper.UNDEFINED_RESOURCE_NAME (empty string) will be returned instead.
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Login
     */
    public String getLoginResourceName(PacketType.Login packetType) {
        return this.loginMapper.getResourceName(packetType);
    }

    /**
     * Get a Login packet type by the resource name.
     *
     * @param resourceName The resource name of the Configuration packet.
     * @return The Login type associated with the provided resource.
     * Or if the resource is not recognized, PacketType.Login.UNDEFINED will be returned instead.
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Login
     */
    public PacketType.Login getLoginPacketType(String resourceName) {
        return this.loginMapper.getType(resourceName);
    }


    /**
     * Get a Play packet type by the id.
     *
     * @param id The id of the Login packet.
     * @return The Play type associated with the provided id.
     * Or if the id is not recognized, PacketType.Play.UNDEFINED will be returned instead.
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Play
     */
    public PacketType.Play getPlayPacketType(int id) {
        return this.playMapper.getType(id);
    }

    /**
     * Get a Play packet id by the type.
     *
     * @param packetType The Play packet type.
     * @return The id associated with the provided Play type. If the type is not supported by this protocol,
     * or the type is PacketType.Play.UNDEFINED, ProtocolMapper.UNDEFINED_ID (-1) will be returned instead.
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Play
     */
    public int getPlayPacketID(PacketType.Play packetType) {
        return this.playMapper.getID(packetType);
    }

    /**
     * Get a Play packet resource name by the type.
     *
     * @param packetType The Play packet type.
     * @return The resource associated with the provided Play type. If the type is not supported by this protocol,
     * or the type is PacketType.Play.UNDEFINED, or the type doesn't have a resource associated with it,
     * ProtocolMapper.UNDEFINED_RESOURCE_NAME (empty string) will be returned instead.
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Play
     */
    public String getPlayResourceName(PacketType.Play packetType) {
        return this.playMapper.getResourceName(packetType);
    }

    /**
     * Get a Play packet type by the resource name.
     *
     * @param resourceName The resource name of the Configuration packet.
     * @return The Play type associated with the provided resource.
     * Or if the resource is not recognized, PacketType.Play.UNDEFINED will be returned instead.
     * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Play
     */
    public PacketType.Play getPlayPacketType(String resourceName) {
        return this.playMapper.getType(resourceName);
    }


    /**
     * Get the entity type by the id.
     *
     * @param id The id of the entity type.
     * @return The entity type associated with the provided id.
     * Or if the id is not recognized, EntityType.UNDEFINED will be returned instead.
     * @see EntityType
     */
    public EntityType getEntityType(int id) {
        return this.entityTypeMapper.getType(id);
    }

    /**
     * Get the id of an entity type.
     *
     * @param entityType The entity type.
     * @return The id associated with the provided entity type. If the entity type is not supported by this protocol,
     * or the entity type is EntityType.UNDEFINED, ProtocolMapper.UNDEFINED_ID (-1) will be returned instead.
     * @see EntityType
     */
    public int getEntityTypeID(EntityType entityType) {
        return this.entityTypeMapper.getID(entityType);
    }

    /**
     * Get the resource name of an entity type.
     *
     * @param entityType The entity type.
     * @return The resource associated with the provided entity type. If the entity type is not supported by this protocol,
     * or the entity type is EntityType.UNDEFINED, or the entity type doesn't have a resource associated with it,
     * ProtocolMapper.UNDEFINED_RESOURCE_NAME (empty string) will be returned instead.
     * @see EntityType
     */
    public String getEntityTypeResourceName(EntityType entityType) {
        return this.entityTypeMapper.getResourceName(entityType);
    }

    /**
     * Get the entity type by the resource name.
     *
     * @param resourceName The resource name of the entity type.
     * @return The entity type associated with the provided resource.
     * Or if the resource is not recognized, EntityType.UNDEFINED will be returned instead.
     * @see EntityType
     */
    public EntityType getEntityType(String resourceName) {
        return this.entityTypeMapper.getType(resourceName);
    }


    /**
     * Get the block by the id.
     *
     * @param id The id of the block.
     * @return The block associated with the provided id.
     * Or if the id is not recognized, Block.UNDEFINED will be returned instead.
     * @see Block
     */
    public Block getBlock(int id) {
        return this.blockMapper.getType(id);
    }

    /**
     * Get the block by the state.
     *
     * @param state The state number of the block.
     * @return The id associated with the provided state number. If the state number is not supported by this protocol,
     * Or if the state number is not recognized, Block.UNDEFINED will be returned instead.
     * @see Block
     */
    public Block getBlockByState(int state) {
        return this.blockMapper.getBlockByState(state);
    }

    /**
     * Get the id of a block.
     *
     * @param block The block.
     * @return The id associated with the provided block. If the block is not supported by this protocol,
     * or the block is Block.UNDEFINED, ProtocolMapper.UNDEFINED_ID (-1) will be returned instead.
     * @see Block
     */
    public int getBlockID(Block block) {
        return this.blockMapper.getID(block);
    }

    /**
     * Get the resource name of a block.
     *
     * @param block The block.
     * @return The resource associated with the provided block. If the block is not supported by this protocol,
     * or the block is Block.UNDEFINED, or the block doesn't have a resource associated with it,
     * ProtocolMapper.UNDEFINED_RESOURCE_NAME (empty string) will be returned instead.
     * @see Block
     */
    public String getBlockResourceName(Block block) {
        return this.blockMapper.getResourceName(block);
    }

    /**
     * Get the block by the resource name.
     *
     * @param resourceName The resource name of the block.
     * @return The block associated with the provided resource.
     * Or if the resource is not recognized, Block.UNDEFINED will be returned instead.
     * @see Block
     */
    public Block getBlock(String resourceName) {
        return this.blockMapper.getType(resourceName);
    }


    /**
     * Get the block entity by the id.
     *
     * @param id The id of the block entity.
     * @return The block entity associated with the provided id.
     * Or if the id is not recognized, BlockEntity.UNDEFINED will be returned instead.
     * @see BlockEntity
     */
    public BlockEntity getBlockEntity(int id) {
        return this.blockEntityTypeMapper.getType(id);
    }

    /**
     * Get the id of a block entity.
     *
     * @param blockEntity The block entity.
     * @return The id associated with the provided block entity. If the block entity is not supported by this protocol,
     * or the block entity is BlockEntity.UNDEFINED, ProtocolMapper.UNDEFINED_ID (-1) will be returned instead.
     * @see BlockEntity
     */
    public int getBlockEntityID(BlockEntity blockEntity) {
        return this.blockEntityTypeMapper.getID(blockEntity);
    }

    /**
     * Get the resource name of a block entity.
     *
     * @param blockEntity The block entity.
     * @return The resource associated with the provided block entity. If the block entity is not supported by this protocol,
     * or the block entity is BlockEntity.UNDEFINED, or the block entity doesn't have a resource associated with it,
     * ProtocolMapper.UNDEFINED_RESOURCE_NAME (empty string) will be returned instead.
     * @see BlockEntity
     */
    public String getBlockEntityResourceName(BlockEntity blockEntity) {
        return this.blockEntityTypeMapper.getResourceName(blockEntity);
    }

    /**
     * Get the block entity by the resource name.
     *
     * @param resourceName The resource name of the block entity.
     * @return The block entity associated with the provided resource.
     * Or if the resource is not recognized, BlockEntity.UNDEFINED will be returned instead.
     * @see BlockEntity
     */
    public BlockEntity getBlockEntity(String resourceName) {
        return this.blockEntityTypeMapper.getType(resourceName);
    }


    /**
     * Get the item by the id.
     *
     * @param id The id of the item.
     * @return The item associated with the provided id.
     * Or if the id is not recognized, Item.UNDEFINED will be returned instead.
     * @see Item
     */
    public Item getItem(int id) {
        return this.itemMapper.getType(id);
    }

    /**
     * Get the id of an item.
     *
     * @param item The item.
     * @return The id associated with the provided item. If the item is not supported by this protocol,
     * or the item is Item.UNDEFINED, ProtocolMapper.UNDEFINED_ID (-1) will be returned instead.
     * @see Item
     */
    public int getItemID(Item item) {
        return this.itemMapper.getID(item);
    }

    /**
     * Get the resource name of an item.
     *
     * @param item The item.
     * @return The resource associated with the provided item. If the item is not supported by this protocol,
     * or the item is Item.UNDEFINED, or the item doesn't have a resource associated with it,
     * ProtocolMapper.UNDEFINED_RESOURCE_NAME (empty string) will be returned instead.
     * @see Item
     */
    public String getItemResourceName(Item item) {
        return this.itemMapper.getResourceName(item);
    }

    /**
     * Get the item by the resource name.
     *
     * @param resourceName The resource name of the item.
     * @return The item associated with the provided resource.
     * Or if the resource is not recognized, Item.UNDEFINED will be returned instead.
     * @see Item
     */
    public Item getItem(String resourceName) {
        return this.itemMapper.getType(resourceName);
    }


}
