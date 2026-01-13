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

/**
 * Represents all the different block entity types.
 * <br>
 * <br> In cases where a type doesn't exist, BlockEntity.UNDEFINED should be used instead.
 * <br>
 * <br> Documentation for each type created with {@link DocumentationGenerator}.
 * Supported Protocol(s) & Resource(s) documented are only inclusive of the protocol versions Replay Packet Cleaner itself currently supports.
 *
 * @see Protocol
 */
public enum BlockEntity implements ProtocolMetadata {

    /**
     * Used to represent an undefined BlockEntity type.
     */
    UNDEFINED,


    /**
     * Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:banner
     */
    BANNER,

    /**
     * Barrel
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:barrel
     */
    BARREL,

    /**
     * Beacon
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:beacon
     */
    BEACON,

    /**
     * Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bed
     */
    BED,

    /**
     * Beehive
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:beehive
     */
    BEEHIVE,

    /**
     * Bell
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bell
     */
    BELL,

    /**
     * Blast Furnace
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blast_furnace
     */
    BLAST_FURNACE,

    /**
     * Brewing Stand
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brewing_stand
     */
    BREWING_STAND,

    /**
     * Brushable Block
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resources: minecraft:suspicious_sand (762 (1.19.4)), minecraft:brushable_block (763 - 774 (1.20.0 - 1.21.11))
     */
    BRUSHABLE_BLOCK,

    /**
     * Calibrated Sculk Sensor
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:calibrated_sculk_sensor
     */
    CALIBRATED_SCULK_SENSOR,

    /**
     * Campfire
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:campfire
     */
    CAMPFIRE,

    /**
     * Chest
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chest
     */
    CHEST,

    /**
     * Chiseled Bookshelf
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_bookshelf
     */
    CHISELED_BOOKSHELF,

    /**
     * Command Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:command_block
     */
    COMMAND_BLOCK,

    /**
     * Comparator
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:comparator
     */
    COMPARATOR,

    /**
     * Conduit
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:conduit
     */
    CONDUIT,

    /**
     * Copper Golem Statue
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_golem_statue
     */
    COPPER_GOLEM_STATUE,

    /**
     * Crafter
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:crafter
     */
    CRAFTER,

    /**
     * Creaking Heart
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:creaking_heart
     */
    CREAKING_HEART,

    /**
     * Daylight Detector
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:daylight_detector
     */
    DAYLIGHT_DETECTOR,

    /**
     * Decorated Pot
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:decorated_pot
     */
    DECORATED_POT,

    /**
     * Dispenser
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dispenser
     */
    DISPENSER,

    /**
     * Dropper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dropper
     */
    DROPPER,

    /**
     * Enchanting Table
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:enchanting_table
     */
    ENCHANTING_TABLE,

    /**
     * Ender Chest
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ender_chest
     */
    ENDER_CHEST,

    /**
     * End Gateway
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:end_gateway
     */
    END_GATEWAY,

    /**
     * End Portal
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:end_portal
     */
    END_PORTAL,

    /**
     * Furnace
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:furnace
     */
    FURNACE,

    /**
     * Hanging Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:hanging_sign
     */
    HANGING_SIGN,

    /**
     * Hopper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:hopper
     */
    HOPPER,

    /**
     * Jigsaw
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jigsaw
     */
    JIGSAW,

    /**
     * Jukebox
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jukebox
     */
    JUKEBOX,

    /**
     * Lectern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lectern
     */
    LECTERN,

    /**
     * Mob Spawner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mob_spawner
     */
    MOB_SPAWNER,

    /**
     * Piston
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:piston
     */
    PISTON,

    /**
     * Sculk Catalyst
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sculk_catalyst
     */
    SCULK_CATALYST,

    /**
     * Sculk Sensor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sculk_sensor
     */
    SCULK_SENSOR,

    /**
     * Sculk Shrieker
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sculk_shrieker
     */
    SCULK_SHRIEKER,

    /**
     * Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:shelf
     */
    SHELF,

    /**
     * Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:shulker_box
     */
    SHULKER_BOX,

    /**
     * Sign
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sign
     */
    SIGN,

    /**
     * Skull
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:skull
     */
    SKULL,

    /**
     * Smoker
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smoker
     */
    SMOKER,

    /**
     * Structure Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:structure_block
     */
    STRUCTURE_BLOCK,

    /**
     * Test Block
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:test_block
     */
    TEST_BLOCK,

    /**
     * Test Instance Block
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:test_instance_block
     */
    TEST_INSTANCE_BLOCK,

    /**
     * Trapped Chest
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:trapped_chest
     */
    TRAPPED_CHEST,

    /**
     * Trial Spawner
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:trial_spawner
     */
    TRIAL_SPAWNER,

    /**
     * Vault
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:vault
     */
    VAULT;


    BlockEntity() {
        this.metadata = new TypeMetadata<BlockEntity>(this, new String[]{TypeMetadata.JSON_NODE_PROTOCOL, TypeMetadata.JSON_NODE_REGISTRIES, TypeMetadata.JSON_NODE_BLOCK_ENTITY, this.name().toLowerCase()});
    }

    private final TypeMetadata<BlockEntity> metadata;

    @Override
    public TypeMetadata<BlockEntity> getMetadata() {
        return this.metadata;
    }

}
