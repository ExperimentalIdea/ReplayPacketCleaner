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
 * Represents all the different item types.
 * <br>
 * <br> In cases where a type doesn't exist, Item.UNDEFINED should be used instead.
 * <br>
 * <br> Documentation for each type created with {@link DocumentationGenerator}.
 * Supported Protocol(s) & Resource(s) documented are only inclusive of the protocol versions Replay Packet Cleaner itself currently supports.
 *
 * @see Protocol
 */
public enum Item implements ProtocolMetadata {

    /**
     * Used to represent an undefined Item type.
     */
    UNDEFINED,


    /**
     * Acacia Boat
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_boat
     */
    ACACIA_BOAT,

    /**
     * Acacia Button
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_button
     */
    ACACIA_BUTTON,

    /**
     * Acacia Chest Boat
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_chest_boat
     */
    ACACIA_CHEST_BOAT,

    /**
     * Acacia Door
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_door
     */
    ACACIA_DOOR,

    /**
     * Acacia Fence
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_fence
     */
    ACACIA_FENCE,

    /**
     * Acacia Fence Gate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_fence_gate
     */
    ACACIA_FENCE_GATE,

    /**
     * Acacia Hanging Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_hanging_sign
     */
    ACACIA_HANGING_SIGN,

    /**
     * Acacia Leaves
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_leaves
     */
    ACACIA_LEAVES,

    /**
     * Acacia Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_log
     */
    ACACIA_LOG,

    /**
     * Acacia Planks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_planks
     */
    ACACIA_PLANKS,

    /**
     * Acacia Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_pressure_plate
     */
    ACACIA_PRESSURE_PLATE,

    /**
     * Acacia Sapling
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_sapling
     */
    ACACIA_SAPLING,

    /**
     * Acacia Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_shelf
     */
    ACACIA_SHELF,

    /**
     * Acacia Sign
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_sign
     */
    ACACIA_SIGN,

    /**
     * Acacia Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_slab
     */
    ACACIA_SLAB,

    /**
     * Acacia Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_stairs
     */
    ACACIA_STAIRS,

    /**
     * Acacia Trapdoor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_trapdoor
     */
    ACACIA_TRAPDOOR,

    /**
     * Acacia Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_wood
     */
    ACACIA_WOOD,

    /**
     * Activator Rail
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:activator_rail
     */
    ACTIVATOR_RAIL,

    /**
     * Air
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:air
     */
    AIR,

    /**
     * Allay Spawn Egg
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:allay_spawn_egg
     */
    ALLAY_SPAWN_EGG,

    /**
     * Allium
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:allium
     */
    ALLIUM,

    /**
     * Amethyst Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:amethyst_block
     */
    AMETHYST_BLOCK,

    /**
     * Amethyst Cluster
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:amethyst_cluster
     */
    AMETHYST_CLUSTER,

    /**
     * Amethyst Shard
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:amethyst_shard
     */
    AMETHYST_SHARD,

    /**
     * Ancient Debris
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ancient_debris
     */
    ANCIENT_DEBRIS,

    /**
     * Andesite
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:andesite
     */
    ANDESITE,

    /**
     * Andesite Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:andesite_slab
     */
    ANDESITE_SLAB,

    /**
     * Andesite Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:andesite_stairs
     */
    ANDESITE_STAIRS,

    /**
     * Andesite Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:andesite_wall
     */
    ANDESITE_WALL,

    /**
     * Angler Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:angler_pottery_sherd
     */
    ANGLER_POTTERY_SHERD,

    /**
     * Anvil
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:anvil
     */
    ANVIL,

    /**
     * Apple
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:apple
     */
    APPLE,

    /**
     * Archer Pottery Sherd
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resources: minecraft:pottery_shard_archer (762 (1.19.4)), minecraft:archer_pottery_sherd (763 - 774 (1.20.0 - 1.21.11))
     */
    ARCHER_POTTERY_SHERD,

    /**
     * Armadillo Scute
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:armadillo_scute
     */
    ARMADILLO_SCUTE,

    /**
     * Armadillo Spawn Egg
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:armadillo_spawn_egg
     */
    ARMADILLO_SPAWN_EGG,

    /**
     * Armor Stand
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:armor_stand
     */
    ARMOR_STAND,

    /**
     * Arms Up Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:arms_up_pottery_sherd
     */
    ARMS_UP_POTTERY_SHERD,

    /**
     * Arrow
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:arrow
     */
    ARROW,

    /**
     * Axolotl Bucket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:axolotl_bucket
     */
    AXOLOTL_BUCKET,

    /**
     * Axolotl Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:axolotl_spawn_egg
     */
    AXOLOTL_SPAWN_EGG,

    /**
     * Azalea
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:azalea
     */
    AZALEA,

    /**
     * Azalea Leaves
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:azalea_leaves
     */
    AZALEA_LEAVES,

    /**
     * Azure Bluet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:azure_bluet
     */
    AZURE_BLUET,

    /**
     * Baked Potato
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:baked_potato
     */
    BAKED_POTATO,

    /**
     * Bamboo
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo
     */
    BAMBOO,

    /**
     * Bamboo Block
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_block
     */
    BAMBOO_BLOCK,

    /**
     * Bamboo Button
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_button
     */
    BAMBOO_BUTTON,

    /**
     * Bamboo Chest Raft
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_chest_raft
     */
    BAMBOO_CHEST_RAFT,

    /**
     * Bamboo Door
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_door
     */
    BAMBOO_DOOR,

    /**
     * Bamboo Fence
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_fence
     */
    BAMBOO_FENCE,

    /**
     * Bamboo Fence Gate
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_fence_gate
     */
    BAMBOO_FENCE_GATE,

    /**
     * Bamboo Hanging Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_hanging_sign
     */
    BAMBOO_HANGING_SIGN,

    /**
     * Bamboo Mosaic
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_mosaic
     */
    BAMBOO_MOSAIC,

    /**
     * Bamboo Mosaic Slab
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_mosaic_slab
     */
    BAMBOO_MOSAIC_SLAB,

    /**
     * Bamboo Mosaic Stairs
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_mosaic_stairs
     */
    BAMBOO_MOSAIC_STAIRS,

    /**
     * Bamboo Planks
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_planks
     */
    BAMBOO_PLANKS,

    /**
     * Bamboo Pressure Plate
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_pressure_plate
     */
    BAMBOO_PRESSURE_PLATE,

    /**
     * Bamboo Raft
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_raft
     */
    BAMBOO_RAFT,

    /**
     * Bamboo Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_shelf
     */
    BAMBOO_SHELF,

    /**
     * Bamboo Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_sign
     */
    BAMBOO_SIGN,

    /**
     * Bamboo Slab
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_slab
     */
    BAMBOO_SLAB,

    /**
     * Bamboo Stairs
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_stairs
     */
    BAMBOO_STAIRS,

    /**
     * Bamboo Trapdoor
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_trapdoor
     */
    BAMBOO_TRAPDOOR,

    /**
     * Barrel
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:barrel
     */
    BARREL,

    /**
     * Barrier
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:barrier
     */
    BARRIER,

    /**
     * Basalt
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:basalt
     */
    BASALT,

    /**
     * Bat Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bat_spawn_egg
     */
    BAT_SPAWN_EGG,

    /**
     * Beacon
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:beacon
     */
    BEACON,

    /**
     * Bedrock
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bedrock
     */
    BEDROCK,

    /**
     * Beef
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:beef
     */
    BEEF,

    /**
     * Beehive
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:beehive
     */
    BEEHIVE,

    /**
     * Beetroot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:beetroot
     */
    BEETROOT,

    /**
     * Beetroot Seeds
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:beetroot_seeds
     */
    BEETROOT_SEEDS,

    /**
     * Beetroot Soup
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:beetroot_soup
     */
    BEETROOT_SOUP,

    /**
     * Bee Nest
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bee_nest
     */
    BEE_NEST,

    /**
     * Bee Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bee_spawn_egg
     */
    BEE_SPAWN_EGG,

    /**
     * Bell
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bell
     */
    BELL,

    /**
     * Big Dripleaf
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:big_dripleaf
     */
    BIG_DRIPLEAF,

    /**
     * Birch Boat
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_boat
     */
    BIRCH_BOAT,

    /**
     * Birch Button
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_button
     */
    BIRCH_BUTTON,

    /**
     * Birch Chest Boat
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_chest_boat
     */
    BIRCH_CHEST_BOAT,

    /**
     * Birch Door
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_door
     */
    BIRCH_DOOR,

    /**
     * Birch Fence
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_fence
     */
    BIRCH_FENCE,

    /**
     * Birch Fence Gate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_fence_gate
     */
    BIRCH_FENCE_GATE,

    /**
     * Birch Hanging Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_hanging_sign
     */
    BIRCH_HANGING_SIGN,

    /**
     * Birch Leaves
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_leaves
     */
    BIRCH_LEAVES,

    /**
     * Birch Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_log
     */
    BIRCH_LOG,

    /**
     * Birch Planks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_planks
     */
    BIRCH_PLANKS,

    /**
     * Birch Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_pressure_plate
     */
    BIRCH_PRESSURE_PLATE,

    /**
     * Birch Sapling
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_sapling
     */
    BIRCH_SAPLING,

    /**
     * Birch Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_shelf
     */
    BIRCH_SHELF,

    /**
     * Birch Sign
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_sign
     */
    BIRCH_SIGN,

    /**
     * Birch Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_slab
     */
    BIRCH_SLAB,

    /**
     * Birch Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_stairs
     */
    BIRCH_STAIRS,

    /**
     * Birch Trapdoor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_trapdoor
     */
    BIRCH_TRAPDOOR,

    /**
     * Birch Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_wood
     */
    BIRCH_WOOD,

    /**
     * Blackstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blackstone
     */
    BLACKSTONE,

    /**
     * Blackstone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blackstone_slab
     */
    BLACKSTONE_SLAB,

    /**
     * Blackstone Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blackstone_stairs
     */
    BLACKSTONE_STAIRS,

    /**
     * Blackstone Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blackstone_wall
     */
    BLACKSTONE_WALL,

    /**
     * Black Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_banner
     */
    BLACK_BANNER,

    /**
     * Black Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_bed
     */
    BLACK_BED,

    /**
     * Black Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:black_bundle
     */
    BLACK_BUNDLE,

    /**
     * Black Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_candle
     */
    BLACK_CANDLE,

    /**
     * Black Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_carpet
     */
    BLACK_CARPET,

    /**
     * Black Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_concrete
     */
    BLACK_CONCRETE,

    /**
     * Black Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_concrete_powder
     */
    BLACK_CONCRETE_POWDER,

    /**
     * Black Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_dye
     */
    BLACK_DYE,

    /**
     * Black Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_glazed_terracotta
     */
    BLACK_GLAZED_TERRACOTTA,

    /**
     * Black Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:black_harness
     */
    BLACK_HARNESS,

    /**
     * Black Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_shulker_box
     */
    BLACK_SHULKER_BOX,

    /**
     * Black Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_stained_glass
     */
    BLACK_STAINED_GLASS,

    /**
     * Black Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_stained_glass_pane
     */
    BLACK_STAINED_GLASS_PANE,

    /**
     * Black Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_terracotta
     */
    BLACK_TERRACOTTA,

    /**
     * Black Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:black_wool
     */
    BLACK_WOOL,

    /**
     * Blade Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blade_pottery_sherd
     */
    BLADE_POTTERY_SHERD,

    /**
     * Blast Furnace
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blast_furnace
     */
    BLAST_FURNACE,

    /**
     * Blaze Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blaze_powder
     */
    BLAZE_POWDER,

    /**
     * Blaze Rod
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blaze_rod
     */
    BLAZE_ROD,

    /**
     * Blaze Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blaze_spawn_egg
     */
    BLAZE_SPAWN_EGG,

    /**
     * Blue Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_banner
     */
    BLUE_BANNER,

    /**
     * Blue Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_bed
     */
    BLUE_BED,

    /**
     * Blue Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_bundle
     */
    BLUE_BUNDLE,

    /**
     * Blue Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_candle
     */
    BLUE_CANDLE,

    /**
     * Blue Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_carpet
     */
    BLUE_CARPET,

    /**
     * Blue Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_concrete
     */
    BLUE_CONCRETE,

    /**
     * Blue Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_concrete_powder
     */
    BLUE_CONCRETE_POWDER,

    /**
     * Blue Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_dye
     */
    BLUE_DYE,

    /**
     * Blue Egg
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_egg
     */
    BLUE_EGG,

    /**
     * Blue Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_glazed_terracotta
     */
    BLUE_GLAZED_TERRACOTTA,

    /**
     * Blue Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_harness
     */
    BLUE_HARNESS,

    /**
     * Blue Ice
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_ice
     */
    BLUE_ICE,

    /**
     * Blue Orchid
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_orchid
     */
    BLUE_ORCHID,

    /**
     * Blue Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_shulker_box
     */
    BLUE_SHULKER_BOX,

    /**
     * Blue Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_stained_glass
     */
    BLUE_STAINED_GLASS,

    /**
     * Blue Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_stained_glass_pane
     */
    BLUE_STAINED_GLASS_PANE,

    /**
     * Blue Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_terracotta
     */
    BLUE_TERRACOTTA,

    /**
     * Blue Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blue_wool
     */
    BLUE_WOOL,

    /**
     * Bogged Spawn Egg
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:bogged_spawn_egg
     */
    BOGGED_SPAWN_EGG,

    /**
     * Bolt Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:bolt_armor_trim_smithing_template
     */
    BOLT_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Bone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bone
     */
    BONE,

    /**
     * Bone Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bone_block
     */
    BONE_BLOCK,

    /**
     * Bone Meal
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bone_meal
     */
    BONE_MEAL,

    /**
     * Book
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:book
     */
    BOOK,

    /**
     * Bookshelf
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bookshelf
     */
    BOOKSHELF,

    /**
     * Bordure Indented Banner Pattern
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:bordure_indented_banner_pattern
     */
    BORDURE_INDENTED_BANNER_PATTERN,

    /**
     * Bow
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bow
     */
    BOW,

    /**
     * Bowl
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bowl
     */
    BOWL,

    /**
     * Brain Coral
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brain_coral
     */
    BRAIN_CORAL,

    /**
     * Brain Coral Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brain_coral_block
     */
    BRAIN_CORAL_BLOCK,

    /**
     * Brain Coral Fan
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brain_coral_fan
     */
    BRAIN_CORAL_FAN,

    /**
     * Bread
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bread
     */
    BREAD,

    /**
     * Breeze Rod
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:breeze_rod
     */
    BREEZE_ROD,

    /**
     * Breeze Spawn Egg
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:breeze_spawn_egg
     */
    BREEZE_SPAWN_EGG,

    /**
     * Brewer Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brewer_pottery_sherd
     */
    BREWER_POTTERY_SHERD,

    /**
     * Brewing Stand
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brewing_stand
     */
    BREWING_STAND,

    /**
     * Brick
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brick
     */
    BRICK,

    /**
     * Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bricks
     */
    BRICKS,

    /**
     * Brick Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brick_slab
     */
    BRICK_SLAB,

    /**
     * Brick Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brick_stairs
     */
    BRICK_STAIRS,

    /**
     * Brick Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brick_wall
     */
    BRICK_WALL,

    /**
     * Brown Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_banner
     */
    BROWN_BANNER,

    /**
     * Brown Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_bed
     */
    BROWN_BED,

    /**
     * Brown Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_bundle
     */
    BROWN_BUNDLE,

    /**
     * Brown Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_candle
     */
    BROWN_CANDLE,

    /**
     * Brown Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_carpet
     */
    BROWN_CARPET,

    /**
     * Brown Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_concrete
     */
    BROWN_CONCRETE,

    /**
     * Brown Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_concrete_powder
     */
    BROWN_CONCRETE_POWDER,

    /**
     * Brown Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_dye
     */
    BROWN_DYE,

    /**
     * Brown Egg
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_egg
     */
    BROWN_EGG,

    /**
     * Brown Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_glazed_terracotta
     */
    BROWN_GLAZED_TERRACOTTA,

    /**
     * Brown Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_harness
     */
    BROWN_HARNESS,

    /**
     * Brown Mushroom
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_mushroom
     */
    BROWN_MUSHROOM,

    /**
     * Brown Mushroom Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_mushroom_block
     */
    BROWN_MUSHROOM_BLOCK,

    /**
     * Brown Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_shulker_box
     */
    BROWN_SHULKER_BOX,

    /**
     * Brown Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_stained_glass
     */
    BROWN_STAINED_GLASS,

    /**
     * Brown Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_stained_glass_pane
     */
    BROWN_STAINED_GLASS_PANE,

    /**
     * Brown Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_terracotta
     */
    BROWN_TERRACOTTA,

    /**
     * Brown Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:brown_wool
     */
    BROWN_WOOL,

    /**
     * Brush
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:brush
     */
    BRUSH,

    /**
     * Bubble Coral
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bubble_coral
     */
    BUBBLE_CORAL,

    /**
     * Bubble Coral Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bubble_coral_block
     */
    BUBBLE_CORAL_BLOCK,

    /**
     * Bubble Coral Fan
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bubble_coral_fan
     */
    BUBBLE_CORAL_FAN,

    /**
     * Bucket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bucket
     */
    BUCKET,

    /**
     * Budding Amethyst
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:budding_amethyst
     */
    BUDDING_AMETHYST,

    /**
     * Bundle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bundle
     */
    BUNDLE,

    /**
     * Burn Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:burn_pottery_sherd
     */
    BURN_POTTERY_SHERD,

    /**
     * Bush
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:bush
     */
    BUSH,

    /**
     * Cactus
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cactus
     */
    CACTUS,

    /**
     * Cactus Flower
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:cactus_flower
     */
    CACTUS_FLOWER,

    /**
     * Cake
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cake
     */
    CAKE,

    /**
     * Calcite
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:calcite
     */
    CALCITE,

    /**
     * Calibrated Sculk Sensor
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:calibrated_sculk_sensor
     */
    CALIBRATED_SCULK_SENSOR,

    /**
     * Camel Husk Spawn Egg
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:camel_husk_spawn_egg
     */
    CAMEL_HUSK_SPAWN_EGG,

    /**
     * Camel Spawn Egg
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:camel_spawn_egg
     */
    CAMEL_SPAWN_EGG,

    /**
     * Campfire
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:campfire
     */
    CAMPFIRE,

    /**
     * Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:candle
     */
    CANDLE,

    /**
     * Carrot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:carrot
     */
    CARROT,

    /**
     * Carrot On A Stick
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:carrot_on_a_stick
     */
    CARROT_ON_A_STICK,

    /**
     * Cartography Table
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cartography_table
     */
    CARTOGRAPHY_TABLE,

    /**
     * Carved Pumpkin
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:carved_pumpkin
     */
    CARVED_PUMPKIN,

    /**
     * Cat Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cat_spawn_egg
     */
    CAT_SPAWN_EGG,

    /**
     * Cauldron
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cauldron
     */
    CAULDRON,

    /**
     * Cave Spider Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cave_spider_spawn_egg
     */
    CAVE_SPIDER_SPAWN_EGG,

    /**
     * Chainmail Boots
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chainmail_boots
     */
    CHAINMAIL_BOOTS,

    /**
     * Chainmail Chestplate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chainmail_chestplate
     */
    CHAINMAIL_CHESTPLATE,

    /**
     * Chainmail Helmet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chainmail_helmet
     */
    CHAINMAIL_HELMET,

    /**
     * Chainmail Leggings
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chainmail_leggings
     */
    CHAINMAIL_LEGGINGS,

    /**
     * Chain Command Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chain_command_block
     */
    CHAIN_COMMAND_BLOCK,

    /**
     * Charcoal
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:charcoal
     */
    CHARCOAL,

    /**
     * Cherry Boat
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_boat
     */
    CHERRY_BOAT,

    /**
     * Cherry Button
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_button
     */
    CHERRY_BUTTON,

    /**
     * Cherry Chest Boat
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_chest_boat
     */
    CHERRY_CHEST_BOAT,

    /**
     * Cherry Door
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_door
     */
    CHERRY_DOOR,

    /**
     * Cherry Fence
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_fence
     */
    CHERRY_FENCE,

    /**
     * Cherry Fence Gate
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_fence_gate
     */
    CHERRY_FENCE_GATE,

    /**
     * Cherry Hanging Sign
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_hanging_sign
     */
    CHERRY_HANGING_SIGN,

    /**
     * Cherry Leaves
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_leaves
     */
    CHERRY_LEAVES,

    /**
     * Cherry Log
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_log
     */
    CHERRY_LOG,

    /**
     * Cherry Planks
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_planks
     */
    CHERRY_PLANKS,

    /**
     * Cherry Pressure Plate
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_pressure_plate
     */
    CHERRY_PRESSURE_PLATE,

    /**
     * Cherry Sapling
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_sapling
     */
    CHERRY_SAPLING,

    /**
     * Cherry Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_shelf
     */
    CHERRY_SHELF,

    /**
     * Cherry Sign
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_sign
     */
    CHERRY_SIGN,

    /**
     * Cherry Slab
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_slab
     */
    CHERRY_SLAB,

    /**
     * Cherry Stairs
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_stairs
     */
    CHERRY_STAIRS,

    /**
     * Cherry Trapdoor
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_trapdoor
     */
    CHERRY_TRAPDOOR,

    /**
     * Cherry Wood
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_wood
     */
    CHERRY_WOOD,

    /**
     * Chest
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chest
     */
    CHEST,

    /**
     * Chest Minecart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chest_minecart
     */
    CHEST_MINECART,

    /**
     * Chicken
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chicken
     */
    CHICKEN,

    /**
     * Chicken Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chicken_spawn_egg
     */
    CHICKEN_SPAWN_EGG,

    /**
     * Chipped Anvil
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chipped_anvil
     */
    CHIPPED_ANVIL,

    /**
     * Chiseled Bookshelf
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_bookshelf
     */
    CHISELED_BOOKSHELF,

    /**
     * Chiseled Copper
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_copper
     */
    CHISELED_COPPER,

    /**
     * Chiseled Deepslate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_deepslate
     */
    CHISELED_DEEPSLATE,

    /**
     * Chiseled Nether Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_nether_bricks
     */
    CHISELED_NETHER_BRICKS,

    /**
     * Chiseled Polished Blackstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_polished_blackstone
     */
    CHISELED_POLISHED_BLACKSTONE,

    /**
     * Chiseled Quartz Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_quartz_block
     */
    CHISELED_QUARTZ_BLOCK,

    /**
     * Chiseled Red Sandstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_red_sandstone
     */
    CHISELED_RED_SANDSTONE,

    /**
     * Chiseled Resin Bricks
     * <p>
     * Supported Protocols: 769 - 774 (1.21.4 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_resin_bricks
     */
    CHISELED_RESIN_BRICKS,

    /**
     * Chiseled Sandstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_sandstone
     */
    CHISELED_SANDSTONE,

    /**
     * Chiseled Stone Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_stone_bricks
     */
    CHISELED_STONE_BRICKS,

    /**
     * Chiseled Tuff
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_tuff
     */
    CHISELED_TUFF,

    /**
     * Chiseled Tuff Bricks
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:chiseled_tuff_bricks
     */
    CHISELED_TUFF_BRICKS,

    /**
     * Chorus Flower
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chorus_flower
     */
    CHORUS_FLOWER,

    /**
     * Chorus Fruit
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chorus_fruit
     */
    CHORUS_FRUIT,

    /**
     * Chorus Plant
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:chorus_plant
     */
    CHORUS_PLANT,

    /**
     * Clay
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:clay
     */
    CLAY,

    /**
     * Clay Ball
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:clay_ball
     */
    CLAY_BALL,

    /**
     * Clock
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:clock
     */
    CLOCK,

    /**
     * Closed Eyeblossom
     * <p>
     * Supported Protocols: 769 - 774 (1.21.4 - 1.21.11)
     * <br>
     * Resource: minecraft:closed_eyeblossom
     */
    CLOSED_EYEBLOSSOM,

    /**
     * Coal
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:coal
     */
    COAL,

    /**
     * Coal Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:coal_block
     */
    COAL_BLOCK,

    /**
     * Coal Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:coal_ore
     */
    COAL_ORE,

    /**
     * Coarse Dirt
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:coarse_dirt
     */
    COARSE_DIRT,

    /**
     * Coast Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:coast_armor_trim_smithing_template
     */
    COAST_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Cobbled Deepslate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cobbled_deepslate
     */
    COBBLED_DEEPSLATE,

    /**
     * Cobbled Deepslate Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cobbled_deepslate_slab
     */
    COBBLED_DEEPSLATE_SLAB,

    /**
     * Cobbled Deepslate Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cobbled_deepslate_stairs
     */
    COBBLED_DEEPSLATE_STAIRS,

    /**
     * Cobbled Deepslate Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cobbled_deepslate_wall
     */
    COBBLED_DEEPSLATE_WALL,

    /**
     * Cobblestone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cobblestone
     */
    COBBLESTONE,

    /**
     * Cobblestone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cobblestone_slab
     */
    COBBLESTONE_SLAB,

    /**
     * Cobblestone Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cobblestone_stairs
     */
    COBBLESTONE_STAIRS,

    /**
     * Cobblestone Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cobblestone_wall
     */
    COBBLESTONE_WALL,

    /**
     * Cobweb
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cobweb
     */
    COBWEB,

    /**
     * Cocoa Beans
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cocoa_beans
     */
    COCOA_BEANS,

    /**
     * Cod
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cod
     */
    COD,

    /**
     * Cod Bucket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cod_bucket
     */
    COD_BUCKET,

    /**
     * Cod Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cod_spawn_egg
     */
    COD_SPAWN_EGG,

    /**
     * Command Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:command_block
     */
    COMMAND_BLOCK,

    /**
     * Command Block Minecart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:command_block_minecart
     */
    COMMAND_BLOCK_MINECART,

    /**
     * Comparator
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:comparator
     */
    COMPARATOR,

    /**
     * Compass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:compass
     */
    COMPASS,

    /**
     * Composter
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:composter
     */
    COMPOSTER,

    /**
     * Conduit
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:conduit
     */
    CONDUIT,

    /**
     * Cooked Beef
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cooked_beef
     */
    COOKED_BEEF,

    /**
     * Cooked Chicken
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cooked_chicken
     */
    COOKED_CHICKEN,

    /**
     * Cooked Cod
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cooked_cod
     */
    COOKED_COD,

    /**
     * Cooked Mutton
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cooked_mutton
     */
    COOKED_MUTTON,

    /**
     * Cooked Porkchop
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cooked_porkchop
     */
    COOKED_PORKCHOP,

    /**
     * Cooked Rabbit
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cooked_rabbit
     */
    COOKED_RABBIT,

    /**
     * Cooked Salmon
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cooked_salmon
     */
    COOKED_SALMON,

    /**
     * Cookie
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cookie
     */
    COOKIE,

    /**
     * Copper Axe
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_axe
     */
    COPPER_AXE,

    /**
     * Copper Bars
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_bars
     */
    COPPER_BARS,

    /**
     * Copper Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_block
     */
    COPPER_BLOCK,

    /**
     * Copper Boots
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_boots
     */
    COPPER_BOOTS,

    /**
     * Copper Bulb
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_bulb
     */
    COPPER_BULB,

    /**
     * Copper Chain
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_chain
     */
    COPPER_CHAIN,

    /**
     * Copper Chest
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_chest
     */
    COPPER_CHEST,

    /**
     * Copper Chestplate
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_chestplate
     */
    COPPER_CHESTPLATE,

    /**
     * Copper Door
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_door
     */
    COPPER_DOOR,

    /**
     * Copper Golem Spawn Egg
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_golem_spawn_egg
     */
    COPPER_GOLEM_SPAWN_EGG,

    /**
     * Copper Golem Statue
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_golem_statue
     */
    COPPER_GOLEM_STATUE,

    /**
     * Copper Grate
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_grate
     */
    COPPER_GRATE,

    /**
     * Copper Helmet
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_helmet
     */
    COPPER_HELMET,

    /**
     * Copper Hoe
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_hoe
     */
    COPPER_HOE,

    /**
     * Copper Horse Armor
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_horse_armor
     */
    COPPER_HORSE_ARMOR,

    /**
     * Copper Ingot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_ingot
     */
    COPPER_INGOT,

    /**
     * Copper Lantern
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_lantern
     */
    COPPER_LANTERN,

    /**
     * Copper Leggings
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_leggings
     */
    COPPER_LEGGINGS,

    /**
     * Copper Nautilus Armor
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:copper_nautilus_armor
     */
    COPPER_NAUTILUS_ARMOR,

    /**
     * Copper Nugget
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_nugget
     */
    COPPER_NUGGET,

    /**
     * Copper Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_ore
     */
    COPPER_ORE,

    /**
     * Copper Pickaxe
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_pickaxe
     */
    COPPER_PICKAXE,

    /**
     * Copper Shovel
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_shovel
     */
    COPPER_SHOVEL,

    /**
     * Copper Spear
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:copper_spear
     */
    COPPER_SPEAR,

    /**
     * Copper Sword
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_sword
     */
    COPPER_SWORD,

    /**
     * Copper Torch
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_torch
     */
    COPPER_TORCH,

    /**
     * Copper Trapdoor
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_trapdoor
     */
    COPPER_TRAPDOOR,

    /**
     * Cornflower
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cornflower
     */
    CORNFLOWER,

    /**
     * Cow Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cow_spawn_egg
     */
    COW_SPAWN_EGG,

    /**
     * Cracked Deepslate Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cracked_deepslate_bricks
     */
    CRACKED_DEEPSLATE_BRICKS,

    /**
     * Cracked Deepslate Tiles
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cracked_deepslate_tiles
     */
    CRACKED_DEEPSLATE_TILES,

    /**
     * Cracked Nether Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cracked_nether_bricks
     */
    CRACKED_NETHER_BRICKS,

    /**
     * Cracked Polished Blackstone Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cracked_polished_blackstone_bricks
     */
    CRACKED_POLISHED_BLACKSTONE_BRICKS,

    /**
     * Cracked Stone Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cracked_stone_bricks
     */
    CRACKED_STONE_BRICKS,

    /**
     * Crafter
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:crafter
     */
    CRAFTER,

    /**
     * Crafting Table
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crafting_table
     */
    CRAFTING_TABLE,

    /**
     * Creaking Heart
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:creaking_heart
     */
    CREAKING_HEART,

    /**
     * Creaking Spawn Egg
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:creaking_spawn_egg
     */
    CREAKING_SPAWN_EGG,

    /**
     * Creeper Banner Pattern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:creeper_banner_pattern
     */
    CREEPER_BANNER_PATTERN,

    /**
     * Creeper Head
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:creeper_head
     */
    CREEPER_HEAD,

    /**
     * Creeper Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:creeper_spawn_egg
     */
    CREEPER_SPAWN_EGG,

    /**
     * Crimson Button
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_button
     */
    CRIMSON_BUTTON,

    /**
     * Crimson Door
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_door
     */
    CRIMSON_DOOR,

    /**
     * Crimson Fence
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_fence
     */
    CRIMSON_FENCE,

    /**
     * Crimson Fence Gate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_fence_gate
     */
    CRIMSON_FENCE_GATE,

    /**
     * Crimson Fungus
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_fungus
     */
    CRIMSON_FUNGUS,

    /**
     * Crimson Hanging Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_hanging_sign
     */
    CRIMSON_HANGING_SIGN,

    /**
     * Crimson Hyphae
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_hyphae
     */
    CRIMSON_HYPHAE,

    /**
     * Crimson Nylium
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_nylium
     */
    CRIMSON_NYLIUM,

    /**
     * Crimson Planks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_planks
     */
    CRIMSON_PLANKS,

    /**
     * Crimson Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_pressure_plate
     */
    CRIMSON_PRESSURE_PLATE,

    /**
     * Crimson Roots
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_roots
     */
    CRIMSON_ROOTS,

    /**
     * Crimson Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_shelf
     */
    CRIMSON_SHELF,

    /**
     * Crimson Sign
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_sign
     */
    CRIMSON_SIGN,

    /**
     * Crimson Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_slab
     */
    CRIMSON_SLAB,

    /**
     * Crimson Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_stairs
     */
    CRIMSON_STAIRS,

    /**
     * Crimson Stem
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_stem
     */
    CRIMSON_STEM,

    /**
     * Crimson Trapdoor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crimson_trapdoor
     */
    CRIMSON_TRAPDOOR,

    /**
     * Crossbow
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crossbow
     */
    CROSSBOW,

    /**
     * Crying Obsidian
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:crying_obsidian
     */
    CRYING_OBSIDIAN,

    /**
     * Cut Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cut_copper
     */
    CUT_COPPER,

    /**
     * Cut Copper Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cut_copper_slab
     */
    CUT_COPPER_SLAB,

    /**
     * Cut Copper Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cut_copper_stairs
     */
    CUT_COPPER_STAIRS,

    /**
     * Cut Red Sandstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cut_red_sandstone
     */
    CUT_RED_SANDSTONE,

    /**
     * Cut Red Sandstone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cut_red_sandstone_slab
     */
    CUT_RED_SANDSTONE_SLAB,

    /**
     * Cut Sandstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cut_sandstone
     */
    CUT_SANDSTONE,

    /**
     * Cut Sandstone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cut_sandstone_slab
     */
    CUT_SANDSTONE_SLAB,

    /**
     * Cyan Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_banner
     */
    CYAN_BANNER,

    /**
     * Cyan Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_bed
     */
    CYAN_BED,

    /**
     * Cyan Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_bundle
     */
    CYAN_BUNDLE,

    /**
     * Cyan Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_candle
     */
    CYAN_CANDLE,

    /**
     * Cyan Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_carpet
     */
    CYAN_CARPET,

    /**
     * Cyan Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_concrete
     */
    CYAN_CONCRETE,

    /**
     * Cyan Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_concrete_powder
     */
    CYAN_CONCRETE_POWDER,

    /**
     * Cyan Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_dye
     */
    CYAN_DYE,

    /**
     * Cyan Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_glazed_terracotta
     */
    CYAN_GLAZED_TERRACOTTA,

    /**
     * Cyan Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_harness
     */
    CYAN_HARNESS,

    /**
     * Cyan Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_shulker_box
     */
    CYAN_SHULKER_BOX,

    /**
     * Cyan Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_stained_glass
     */
    CYAN_STAINED_GLASS,

    /**
     * Cyan Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_stained_glass_pane
     */
    CYAN_STAINED_GLASS_PANE,

    /**
     * Cyan Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_terracotta
     */
    CYAN_TERRACOTTA,

    /**
     * Cyan Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cyan_wool
     */
    CYAN_WOOL,

    /**
     * Damaged Anvil
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:damaged_anvil
     */
    DAMAGED_ANVIL,

    /**
     * Dandelion
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dandelion
     */
    DANDELION,

    /**
     * Danger Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:danger_pottery_sherd
     */
    DANGER_POTTERY_SHERD,

    /**
     * Dark Oak Boat
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_boat
     */
    DARK_OAK_BOAT,

    /**
     * Dark Oak Button
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_button
     */
    DARK_OAK_BUTTON,

    /**
     * Dark Oak Chest Boat
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_chest_boat
     */
    DARK_OAK_CHEST_BOAT,

    /**
     * Dark Oak Door
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_door
     */
    DARK_OAK_DOOR,

    /**
     * Dark Oak Fence
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_fence
     */
    DARK_OAK_FENCE,

    /**
     * Dark Oak Fence Gate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_fence_gate
     */
    DARK_OAK_FENCE_GATE,

    /**
     * Dark Oak Hanging Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_hanging_sign
     */
    DARK_OAK_HANGING_SIGN,

    /**
     * Dark Oak Leaves
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_leaves
     */
    DARK_OAK_LEAVES,

    /**
     * Dark Oak Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_log
     */
    DARK_OAK_LOG,

    /**
     * Dark Oak Planks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_planks
     */
    DARK_OAK_PLANKS,

    /**
     * Dark Oak Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_pressure_plate
     */
    DARK_OAK_PRESSURE_PLATE,

    /**
     * Dark Oak Sapling
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_sapling
     */
    DARK_OAK_SAPLING,

    /**
     * Dark Oak Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_shelf
     */
    DARK_OAK_SHELF,

    /**
     * Dark Oak Sign
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_sign
     */
    DARK_OAK_SIGN,

    /**
     * Dark Oak Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_slab
     */
    DARK_OAK_SLAB,

    /**
     * Dark Oak Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_stairs
     */
    DARK_OAK_STAIRS,

    /**
     * Dark Oak Trapdoor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_trapdoor
     */
    DARK_OAK_TRAPDOOR,

    /**
     * Dark Oak Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_wood
     */
    DARK_OAK_WOOD,

    /**
     * Dark Prismarine
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_prismarine
     */
    DARK_PRISMARINE,

    /**
     * Dark Prismarine Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_prismarine_slab
     */
    DARK_PRISMARINE_SLAB,

    /**
     * Dark Prismarine Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_prismarine_stairs
     */
    DARK_PRISMARINE_STAIRS,

    /**
     * Daylight Detector
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:daylight_detector
     */
    DAYLIGHT_DETECTOR,

    /**
     * Dead Brain Coral
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_brain_coral
     */
    DEAD_BRAIN_CORAL,

    /**
     * Dead Brain Coral Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_brain_coral_block
     */
    DEAD_BRAIN_CORAL_BLOCK,

    /**
     * Dead Brain Coral Fan
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_brain_coral_fan
     */
    DEAD_BRAIN_CORAL_FAN,

    /**
     * Dead Bubble Coral
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_bubble_coral
     */
    DEAD_BUBBLE_CORAL,

    /**
     * Dead Bubble Coral Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_bubble_coral_block
     */
    DEAD_BUBBLE_CORAL_BLOCK,

    /**
     * Dead Bubble Coral Fan
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_bubble_coral_fan
     */
    DEAD_BUBBLE_CORAL_FAN,

    /**
     * Dead Bush
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_bush
     */
    DEAD_BUSH,

    /**
     * Dead Fire Coral
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_fire_coral
     */
    DEAD_FIRE_CORAL,

    /**
     * Dead Fire Coral Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_fire_coral_block
     */
    DEAD_FIRE_CORAL_BLOCK,

    /**
     * Dead Fire Coral Fan
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_fire_coral_fan
     */
    DEAD_FIRE_CORAL_FAN,

    /**
     * Dead Horn Coral
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_horn_coral
     */
    DEAD_HORN_CORAL,

    /**
     * Dead Horn Coral Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_horn_coral_block
     */
    DEAD_HORN_CORAL_BLOCK,

    /**
     * Dead Horn Coral Fan
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_horn_coral_fan
     */
    DEAD_HORN_CORAL_FAN,

    /**
     * Dead Tube Coral
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_tube_coral
     */
    DEAD_TUBE_CORAL,

    /**
     * Dead Tube Coral Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_tube_coral_block
     */
    DEAD_TUBE_CORAL_BLOCK,

    /**
     * Dead Tube Coral Fan
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dead_tube_coral_fan
     */
    DEAD_TUBE_CORAL_FAN,

    /**
     * Debug Stick
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:debug_stick
     */
    DEBUG_STICK,

    /**
     * Decorated Pot
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:decorated_pot
     */
    DECORATED_POT,

    /**
     * Deepslate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate
     */
    DEEPSLATE,

    /**
     * Deepslate Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_bricks
     */
    DEEPSLATE_BRICKS,

    /**
     * Deepslate Brick Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_brick_slab
     */
    DEEPSLATE_BRICK_SLAB,

    /**
     * Deepslate Brick Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_brick_stairs
     */
    DEEPSLATE_BRICK_STAIRS,

    /**
     * Deepslate Brick Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_brick_wall
     */
    DEEPSLATE_BRICK_WALL,

    /**
     * Deepslate Coal Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_coal_ore
     */
    DEEPSLATE_COAL_ORE,

    /**
     * Deepslate Copper Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_copper_ore
     */
    DEEPSLATE_COPPER_ORE,

    /**
     * Deepslate Diamond Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_diamond_ore
     */
    DEEPSLATE_DIAMOND_ORE,

    /**
     * Deepslate Emerald Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_emerald_ore
     */
    DEEPSLATE_EMERALD_ORE,

    /**
     * Deepslate Gold Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_gold_ore
     */
    DEEPSLATE_GOLD_ORE,

    /**
     * Deepslate Iron Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_iron_ore
     */
    DEEPSLATE_IRON_ORE,

    /**
     * Deepslate Lapis Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_lapis_ore
     */
    DEEPSLATE_LAPIS_ORE,

    /**
     * Deepslate Redstone Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_redstone_ore
     */
    DEEPSLATE_REDSTONE_ORE,

    /**
     * Deepslate Tiles
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_tiles
     */
    DEEPSLATE_TILES,

    /**
     * Deepslate Tile Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_tile_slab
     */
    DEEPSLATE_TILE_SLAB,

    /**
     * Deepslate Tile Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_tile_stairs
     */
    DEEPSLATE_TILE_STAIRS,

    /**
     * Deepslate Tile Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:deepslate_tile_wall
     */
    DEEPSLATE_TILE_WALL,

    /**
     * Detector Rail
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:detector_rail
     */
    DETECTOR_RAIL,

    /**
     * Diamond
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond
     */
    DIAMOND,

    /**
     * Diamond Axe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_axe
     */
    DIAMOND_AXE,

    /**
     * Diamond Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_block
     */
    DIAMOND_BLOCK,

    /**
     * Diamond Boots
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_boots
     */
    DIAMOND_BOOTS,

    /**
     * Diamond Chestplate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_chestplate
     */
    DIAMOND_CHESTPLATE,

    /**
     * Diamond Helmet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_helmet
     */
    DIAMOND_HELMET,

    /**
     * Diamond Hoe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_hoe
     */
    DIAMOND_HOE,

    /**
     * Diamond Horse Armor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_horse_armor
     */
    DIAMOND_HORSE_ARMOR,

    /**
     * Diamond Leggings
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_leggings
     */
    DIAMOND_LEGGINGS,

    /**
     * Diamond Nautilus Armor
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:diamond_nautilus_armor
     */
    DIAMOND_NAUTILUS_ARMOR,

    /**
     * Diamond Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_ore
     */
    DIAMOND_ORE,

    /**
     * Diamond Pickaxe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_pickaxe
     */
    DIAMOND_PICKAXE,

    /**
     * Diamond Shovel
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_shovel
     */
    DIAMOND_SHOVEL,

    /**
     * Diamond Spear
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:diamond_spear
     */
    DIAMOND_SPEAR,

    /**
     * Diamond Sword
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diamond_sword
     */
    DIAMOND_SWORD,

    /**
     * Diorite
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diorite
     */
    DIORITE,

    /**
     * Diorite Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diorite_slab
     */
    DIORITE_SLAB,

    /**
     * Diorite Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diorite_stairs
     */
    DIORITE_STAIRS,

    /**
     * Diorite Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:diorite_wall
     */
    DIORITE_WALL,

    /**
     * Dirt
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dirt
     */
    DIRT,

    /**
     * Dirt Path
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dirt_path
     */
    DIRT_PATH,

    /**
     * Disc Fragment 5
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:disc_fragment_5
     */
    DISC_FRAGMENT_5,

    /**
     * Dispenser
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dispenser
     */
    DISPENSER,

    /**
     * Dolphin Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dolphin_spawn_egg
     */
    DOLPHIN_SPAWN_EGG,

    /**
     * Donkey Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:donkey_spawn_egg
     */
    DONKEY_SPAWN_EGG,

    /**
     * Dragon Breath
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dragon_breath
     */
    DRAGON_BREATH,

    /**
     * Dragon Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dragon_egg
     */
    DRAGON_EGG,

    /**
     * Dragon Head
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dragon_head
     */
    DRAGON_HEAD,

    /**
     * Dried Ghast
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:dried_ghast
     */
    DRIED_GHAST,

    /**
     * Dried Kelp
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dried_kelp
     */
    DRIED_KELP,

    /**
     * Dried Kelp Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dried_kelp_block
     */
    DRIED_KELP_BLOCK,

    /**
     * Dripstone Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dripstone_block
     */
    DRIPSTONE_BLOCK,

    /**
     * Dropper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dropper
     */
    DROPPER,

    /**
     * Drowned Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:drowned_spawn_egg
     */
    DROWNED_SPAWN_EGG,

    /**
     * Dune Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:dune_armor_trim_smithing_template
     */
    DUNE_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Echo Shard
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:echo_shard
     */
    ECHO_SHARD,

    /**
     * Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:egg
     */
    EGG,

    /**
     * Elder Guardian Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:elder_guardian_spawn_egg
     */
    ELDER_GUARDIAN_SPAWN_EGG,

    /**
     * Elytra
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:elytra
     */
    ELYTRA,

    /**
     * Emerald
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:emerald
     */
    EMERALD,

    /**
     * Emerald Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:emerald_block
     */
    EMERALD_BLOCK,

    /**
     * Emerald Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:emerald_ore
     */
    EMERALD_ORE,

    /**
     * Enchanted Book
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:enchanted_book
     */
    ENCHANTED_BOOK,

    /**
     * Enchanted Golden Apple
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:enchanted_golden_apple
     */
    ENCHANTED_GOLDEN_APPLE,

    /**
     * Enchanting Table
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:enchanting_table
     */
    ENCHANTING_TABLE,

    /**
     * Enderman Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:enderman_spawn_egg
     */
    ENDERMAN_SPAWN_EGG,

    /**
     * Endermite Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:endermite_spawn_egg
     */
    ENDERMITE_SPAWN_EGG,

    /**
     * Ender Chest
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ender_chest
     */
    ENDER_CHEST,

    /**
     * Ender Dragon Spawn Egg
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:ender_dragon_spawn_egg
     */
    ENDER_DRAGON_SPAWN_EGG,

    /**
     * Ender Eye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ender_eye
     */
    ENDER_EYE,

    /**
     * Ender Pearl
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ender_pearl
     */
    ENDER_PEARL,

    /**
     * End Crystal
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:end_crystal
     */
    END_CRYSTAL,

    /**
     * End Portal Frame
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:end_portal_frame
     */
    END_PORTAL_FRAME,

    /**
     * End Rod
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:end_rod
     */
    END_ROD,

    /**
     * End Stone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:end_stone
     */
    END_STONE,

    /**
     * End Stone Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:end_stone_bricks
     */
    END_STONE_BRICKS,

    /**
     * End Stone Brick Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:end_stone_brick_slab
     */
    END_STONE_BRICK_SLAB,

    /**
     * End Stone Brick Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:end_stone_brick_stairs
     */
    END_STONE_BRICK_STAIRS,

    /**
     * End Stone Brick Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:end_stone_brick_wall
     */
    END_STONE_BRICK_WALL,

    /**
     * Evoker Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:evoker_spawn_egg
     */
    EVOKER_SPAWN_EGG,

    /**
     * Experience Bottle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:experience_bottle
     */
    EXPERIENCE_BOTTLE,

    /**
     * Explorer Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:explorer_pottery_sherd
     */
    EXPLORER_POTTERY_SHERD,

    /**
     * Exposed Chiseled Copper
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_chiseled_copper
     */
    EXPOSED_CHISELED_COPPER,

    /**
     * Exposed Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_copper
     */
    EXPOSED_COPPER,

    /**
     * Exposed Copper Bars
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_copper_bars
     */
    EXPOSED_COPPER_BARS,

    /**
     * Exposed Copper Bulb
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_copper_bulb
     */
    EXPOSED_COPPER_BULB,

    /**
     * Exposed Copper Chain
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_copper_chain
     */
    EXPOSED_COPPER_CHAIN,

    /**
     * Exposed Copper Chest
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_copper_chest
     */
    EXPOSED_COPPER_CHEST,

    /**
     * Exposed Copper Door
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_copper_door
     */
    EXPOSED_COPPER_DOOR,

    /**
     * Exposed Copper Golem Statue
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_copper_golem_statue
     */
    EXPOSED_COPPER_GOLEM_STATUE,

    /**
     * Exposed Copper Grate
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_copper_grate
     */
    EXPOSED_COPPER_GRATE,

    /**
     * Exposed Copper Lantern
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_copper_lantern
     */
    EXPOSED_COPPER_LANTERN,

    /**
     * Exposed Copper Trapdoor
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_copper_trapdoor
     */
    EXPOSED_COPPER_TRAPDOOR,

    /**
     * Exposed Cut Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_cut_copper
     */
    EXPOSED_CUT_COPPER,

    /**
     * Exposed Cut Copper Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_cut_copper_slab
     */
    EXPOSED_CUT_COPPER_SLAB,

    /**
     * Exposed Cut Copper Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_cut_copper_stairs
     */
    EXPOSED_CUT_COPPER_STAIRS,

    /**
     * Exposed Lightning Rod
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:exposed_lightning_rod
     */
    EXPOSED_LIGHTNING_ROD,

    /**
     * Eye Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:eye_armor_trim_smithing_template
     */
    EYE_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Farmland
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:farmland
     */
    FARMLAND,

    /**
     * Feather
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:feather
     */
    FEATHER,

    /**
     * Fermented Spider Eye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fermented_spider_eye
     */
    FERMENTED_SPIDER_EYE,

    /**
     * Fern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fern
     */
    FERN,

    /**
     * Field Masoned Banner Pattern
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:field_masoned_banner_pattern
     */
    FIELD_MASONED_BANNER_PATTERN,

    /**
     * Filled Map
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:filled_map
     */
    FILLED_MAP,

    /**
     * Firefly Bush
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:firefly_bush
     */
    FIREFLY_BUSH,

    /**
     * Firework Rocket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:firework_rocket
     */
    FIREWORK_ROCKET,

    /**
     * Firework Star
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:firework_star
     */
    FIREWORK_STAR,

    /**
     * Fire Charge
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fire_charge
     */
    FIRE_CHARGE,

    /**
     * Fire Coral
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fire_coral
     */
    FIRE_CORAL,

    /**
     * Fire Coral Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fire_coral_block
     */
    FIRE_CORAL_BLOCK,

    /**
     * Fire Coral Fan
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fire_coral_fan
     */
    FIRE_CORAL_FAN,

    /**
     * Fishing Rod
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fishing_rod
     */
    FISHING_ROD,

    /**
     * Fletching Table
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fletching_table
     */
    FLETCHING_TABLE,

    /**
     * Flint
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:flint
     */
    FLINT,

    /**
     * Flint And Steel
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:flint_and_steel
     */
    FLINT_AND_STEEL,

    /**
     * Flowering Azalea
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:flowering_azalea
     */
    FLOWERING_AZALEA,

    /**
     * Flowering Azalea Leaves
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:flowering_azalea_leaves
     */
    FLOWERING_AZALEA_LEAVES,

    /**
     * Flower Banner Pattern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:flower_banner_pattern
     */
    FLOWER_BANNER_PATTERN,

    /**
     * Flower Pot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:flower_pot
     */
    FLOWER_POT,

    /**
     * Flow Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:flow_armor_trim_smithing_template
     */
    FLOW_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Flow Banner Pattern
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:flow_banner_pattern
     */
    FLOW_BANNER_PATTERN,

    /**
     * Flow Pottery Sherd
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:flow_pottery_sherd
     */
    FLOW_POTTERY_SHERD,

    /**
     * Fox Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fox_spawn_egg
     */
    FOX_SPAWN_EGG,

    /**
     * Friend Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:friend_pottery_sherd
     */
    FRIEND_POTTERY_SHERD,

    /**
     * Frogspawn
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:frogspawn
     */
    FROGSPAWN,

    /**
     * Frog Spawn Egg
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:frog_spawn_egg
     */
    FROG_SPAWN_EGG,

    /**
     * Furnace
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:furnace
     */
    FURNACE,

    /**
     * Furnace Minecart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:furnace_minecart
     */
    FURNACE_MINECART,

    /**
     * Ghast Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ghast_spawn_egg
     */
    GHAST_SPAWN_EGG,

    /**
     * Ghast Tear
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ghast_tear
     */
    GHAST_TEAR,

    /**
     * Gilded Blackstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gilded_blackstone
     */
    GILDED_BLACKSTONE,

    /**
     * Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glass
     */
    GLASS,

    /**
     * Glass Bottle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glass_bottle
     */
    GLASS_BOTTLE,

    /**
     * Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glass_pane
     */
    GLASS_PANE,

    /**
     * Glistering Melon Slice
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glistering_melon_slice
     */
    GLISTERING_MELON_SLICE,

    /**
     * Globe Banner Pattern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:globe_banner_pattern
     */
    GLOBE_BANNER_PATTERN,

    /**
     * Glowstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glowstone
     */
    GLOWSTONE,

    /**
     * Glowstone Dust
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glowstone_dust
     */
    GLOWSTONE_DUST,

    /**
     * Glow Berries
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glow_berries
     */
    GLOW_BERRIES,

    /**
     * Glow Ink Sac
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glow_ink_sac
     */
    GLOW_INK_SAC,

    /**
     * Glow Item Frame
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glow_item_frame
     */
    GLOW_ITEM_FRAME,

    /**
     * Glow Lichen
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glow_lichen
     */
    GLOW_LICHEN,

    /**
     * Glow Squid Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glow_squid_spawn_egg
     */
    GLOW_SQUID_SPAWN_EGG,

    /**
     * Goat Horn
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:goat_horn
     */
    GOAT_HORN,

    /**
     * Goat Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:goat_spawn_egg
     */
    GOAT_SPAWN_EGG,

    /**
     * Golden Apple
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_apple
     */
    GOLDEN_APPLE,

    /**
     * Golden Axe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_axe
     */
    GOLDEN_AXE,

    /**
     * Golden Boots
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_boots
     */
    GOLDEN_BOOTS,

    /**
     * Golden Carrot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_carrot
     */
    GOLDEN_CARROT,

    /**
     * Golden Chestplate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_chestplate
     */
    GOLDEN_CHESTPLATE,

    /**
     * Golden Helmet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_helmet
     */
    GOLDEN_HELMET,

    /**
     * Golden Hoe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_hoe
     */
    GOLDEN_HOE,

    /**
     * Golden Horse Armor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_horse_armor
     */
    GOLDEN_HORSE_ARMOR,

    /**
     * Golden Leggings
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_leggings
     */
    GOLDEN_LEGGINGS,

    /**
     * Golden Nautilus Armor
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:golden_nautilus_armor
     */
    GOLDEN_NAUTILUS_ARMOR,

    /**
     * Golden Pickaxe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_pickaxe
     */
    GOLDEN_PICKAXE,

    /**
     * Golden Shovel
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_shovel
     */
    GOLDEN_SHOVEL,

    /**
     * Golden Spear
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:golden_spear
     */
    GOLDEN_SPEAR,

    /**
     * Golden Sword
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:golden_sword
     */
    GOLDEN_SWORD,

    /**
     * Gold Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gold_block
     */
    GOLD_BLOCK,

    /**
     * Gold Ingot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gold_ingot
     */
    GOLD_INGOT,

    /**
     * Gold Nugget
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gold_nugget
     */
    GOLD_NUGGET,

    /**
     * Gold Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gold_ore
     */
    GOLD_ORE,

    /**
     * Granite
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:granite
     */
    GRANITE,

    /**
     * Granite Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:granite_slab
     */
    GRANITE_SLAB,

    /**
     * Granite Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:granite_stairs
     */
    GRANITE_STAIRS,

    /**
     * Granite Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:granite_wall
     */
    GRANITE_WALL,

    /**
     * Grass Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:grass_block
     */
    GRASS_BLOCK,

    /**
     * Gravel
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gravel
     */
    GRAVEL,

    /**
     * Gray Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_banner
     */
    GRAY_BANNER,

    /**
     * Gray Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_bed
     */
    GRAY_BED,

    /**
     * Gray Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_bundle
     */
    GRAY_BUNDLE,

    /**
     * Gray Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_candle
     */
    GRAY_CANDLE,

    /**
     * Gray Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_carpet
     */
    GRAY_CARPET,

    /**
     * Gray Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_concrete
     */
    GRAY_CONCRETE,

    /**
     * Gray Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_concrete_powder
     */
    GRAY_CONCRETE_POWDER,

    /**
     * Gray Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_dye
     */
    GRAY_DYE,

    /**
     * Gray Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_glazed_terracotta
     */
    GRAY_GLAZED_TERRACOTTA,

    /**
     * Gray Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_harness
     */
    GRAY_HARNESS,

    /**
     * Gray Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_shulker_box
     */
    GRAY_SHULKER_BOX,

    /**
     * Gray Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_stained_glass
     */
    GRAY_STAINED_GLASS,

    /**
     * Gray Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_stained_glass_pane
     */
    GRAY_STAINED_GLASS_PANE,

    /**
     * Gray Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_terracotta
     */
    GRAY_TERRACOTTA,

    /**
     * Gray Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gray_wool
     */
    GRAY_WOOL,

    /**
     * Green Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_banner
     */
    GREEN_BANNER,

    /**
     * Green Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_bed
     */
    GREEN_BED,

    /**
     * Green Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:green_bundle
     */
    GREEN_BUNDLE,

    /**
     * Green Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_candle
     */
    GREEN_CANDLE,

    /**
     * Green Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_carpet
     */
    GREEN_CARPET,

    /**
     * Green Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_concrete
     */
    GREEN_CONCRETE,

    /**
     * Green Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_concrete_powder
     */
    GREEN_CONCRETE_POWDER,

    /**
     * Green Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_dye
     */
    GREEN_DYE,

    /**
     * Green Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_glazed_terracotta
     */
    GREEN_GLAZED_TERRACOTTA,

    /**
     * Green Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:green_harness
     */
    GREEN_HARNESS,

    /**
     * Green Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_shulker_box
     */
    GREEN_SHULKER_BOX,

    /**
     * Green Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_stained_glass
     */
    GREEN_STAINED_GLASS,

    /**
     * Green Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_stained_glass_pane
     */
    GREEN_STAINED_GLASS_PANE,

    /**
     * Green Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_terracotta
     */
    GREEN_TERRACOTTA,

    /**
     * Green Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:green_wool
     */
    GREEN_WOOL,

    /**
     * Grindstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:grindstone
     */
    GRINDSTONE,

    /**
     * Guardian Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:guardian_spawn_egg
     */
    GUARDIAN_SPAWN_EGG,

    /**
     * Gunpowder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:gunpowder
     */
    GUNPOWDER,

    /**
     * Guster Banner Pattern
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:guster_banner_pattern
     */
    GUSTER_BANNER_PATTERN,

    /**
     * Guster Pottery Sherd
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:guster_pottery_sherd
     */
    GUSTER_POTTERY_SHERD,

    /**
     * Hanging Roots
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:hanging_roots
     */
    HANGING_ROOTS,

    /**
     * Happy Ghast Spawn Egg
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:happy_ghast_spawn_egg
     */
    HAPPY_GHAST_SPAWN_EGG,

    /**
     * Hay Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:hay_block
     */
    HAY_BLOCK,

    /**
     * Heartbreak Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:heartbreak_pottery_sherd
     */
    HEARTBREAK_POTTERY_SHERD,

    /**
     * Heart Of The Sea
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:heart_of_the_sea
     */
    HEART_OF_THE_SEA,

    /**
     * Heart Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:heart_pottery_sherd
     */
    HEART_POTTERY_SHERD,

    /**
     * Heavy Core
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:heavy_core
     */
    HEAVY_CORE,

    /**
     * Heavy Weighted Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:heavy_weighted_pressure_plate
     */
    HEAVY_WEIGHTED_PRESSURE_PLATE,

    /**
     * Hoglin Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:hoglin_spawn_egg
     */
    HOGLIN_SPAWN_EGG,

    /**
     * Honeycomb
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:honeycomb
     */
    HONEYCOMB,

    /**
     * Honeycomb Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:honeycomb_block
     */
    HONEYCOMB_BLOCK,

    /**
     * Honey Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:honey_block
     */
    HONEY_BLOCK,

    /**
     * Honey Bottle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:honey_bottle
     */
    HONEY_BOTTLE,

    /**
     * Hopper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:hopper
     */
    HOPPER,

    /**
     * Hopper Minecart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:hopper_minecart
     */
    HOPPER_MINECART,

    /**
     * Horn Coral
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:horn_coral
     */
    HORN_CORAL,

    /**
     * Horn Coral Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:horn_coral_block
     */
    HORN_CORAL_BLOCK,

    /**
     * Horn Coral Fan
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:horn_coral_fan
     */
    HORN_CORAL_FAN,

    /**
     * Horse Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:horse_spawn_egg
     */
    HORSE_SPAWN_EGG,

    /**
     * Host Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:host_armor_trim_smithing_template
     */
    HOST_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Howl Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:howl_pottery_sherd
     */
    HOWL_POTTERY_SHERD,

    /**
     * Husk Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:husk_spawn_egg
     */
    HUSK_SPAWN_EGG,

    /**
     * Ice
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ice
     */
    ICE,

    /**
     * Infested Chiseled Stone Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:infested_chiseled_stone_bricks
     */
    INFESTED_CHISELED_STONE_BRICKS,

    /**
     * Infested Cobblestone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:infested_cobblestone
     */
    INFESTED_COBBLESTONE,

    /**
     * Infested Cracked Stone Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:infested_cracked_stone_bricks
     */
    INFESTED_CRACKED_STONE_BRICKS,

    /**
     * Infested Deepslate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:infested_deepslate
     */
    INFESTED_DEEPSLATE,

    /**
     * Infested Mossy Stone Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:infested_mossy_stone_bricks
     */
    INFESTED_MOSSY_STONE_BRICKS,

    /**
     * Infested Stone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:infested_stone
     */
    INFESTED_STONE,

    /**
     * Infested Stone Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:infested_stone_bricks
     */
    INFESTED_STONE_BRICKS,

    /**
     * Ink Sac
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ink_sac
     */
    INK_SAC,

    /**
     * Iron Axe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_axe
     */
    IRON_AXE,

    /**
     * Iron Bars
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_bars
     */
    IRON_BARS,

    /**
     * Iron Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_block
     */
    IRON_BLOCK,

    /**
     * Iron Boots
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_boots
     */
    IRON_BOOTS,

    /**
     * Iron Chain
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resources: minecraft:chain (755 - 772 (1.17.0 - 1.21.8)), minecraft:iron_chain (773 - 774 (1.21.9 - 1.21.11))
     */
    IRON_CHAIN,

    /**
     * Iron Chestplate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_chestplate
     */
    IRON_CHESTPLATE,

    /**
     * Iron Door
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_door
     */
    IRON_DOOR,

    /**
     * Iron Golem Spawn Egg
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_golem_spawn_egg
     */
    IRON_GOLEM_SPAWN_EGG,

    /**
     * Iron Helmet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_helmet
     */
    IRON_HELMET,

    /**
     * Iron Hoe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_hoe
     */
    IRON_HOE,

    /**
     * Iron Horse Armor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_horse_armor
     */
    IRON_HORSE_ARMOR,

    /**
     * Iron Ingot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_ingot
     */
    IRON_INGOT,

    /**
     * Iron Leggings
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_leggings
     */
    IRON_LEGGINGS,

    /**
     * Iron Nautilus Armor
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:iron_nautilus_armor
     */
    IRON_NAUTILUS_ARMOR,

    /**
     * Iron Nugget
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_nugget
     */
    IRON_NUGGET,

    /**
     * Iron Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_ore
     */
    IRON_ORE,

    /**
     * Iron Pickaxe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_pickaxe
     */
    IRON_PICKAXE,

    /**
     * Iron Shovel
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_shovel
     */
    IRON_SHOVEL,

    /**
     * Iron Spear
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:iron_spear
     */
    IRON_SPEAR,

    /**
     * Iron Sword
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_sword
     */
    IRON_SWORD,

    /**
     * Iron Trapdoor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_trapdoor
     */
    IRON_TRAPDOOR,

    /**
     * Item Frame
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:item_frame
     */
    ITEM_FRAME,

    /**
     * Jack O Lantern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jack_o_lantern
     */
    JACK_O_LANTERN,

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
     * Jungle Boat
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_boat
     */
    JUNGLE_BOAT,

    /**
     * Jungle Button
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_button
     */
    JUNGLE_BUTTON,

    /**
     * Jungle Chest Boat
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_chest_boat
     */
    JUNGLE_CHEST_BOAT,

    /**
     * Jungle Door
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_door
     */
    JUNGLE_DOOR,

    /**
     * Jungle Fence
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_fence
     */
    JUNGLE_FENCE,

    /**
     * Jungle Fence Gate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_fence_gate
     */
    JUNGLE_FENCE_GATE,

    /**
     * Jungle Hanging Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_hanging_sign
     */
    JUNGLE_HANGING_SIGN,

    /**
     * Jungle Leaves
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_leaves
     */
    JUNGLE_LEAVES,

    /**
     * Jungle Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_log
     */
    JUNGLE_LOG,

    /**
     * Jungle Planks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_planks
     */
    JUNGLE_PLANKS,

    /**
     * Jungle Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_pressure_plate
     */
    JUNGLE_PRESSURE_PLATE,

    /**
     * Jungle Sapling
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_sapling
     */
    JUNGLE_SAPLING,

    /**
     * Jungle Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_shelf
     */
    JUNGLE_SHELF,

    /**
     * Jungle Sign
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_sign
     */
    JUNGLE_SIGN,

    /**
     * Jungle Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_slab
     */
    JUNGLE_SLAB,

    /**
     * Jungle Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_stairs
     */
    JUNGLE_STAIRS,

    /**
     * Jungle Trapdoor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_trapdoor
     */
    JUNGLE_TRAPDOOR,

    /**
     * Jungle Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_wood
     */
    JUNGLE_WOOD,

    /**
     * Kelp
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:kelp
     */
    KELP,

    /**
     * Knowledge Book
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:knowledge_book
     */
    KNOWLEDGE_BOOK,

    /**
     * Ladder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ladder
     */
    LADDER,

    /**
     * Lantern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lantern
     */
    LANTERN,

    /**
     * Lapis Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lapis_block
     */
    LAPIS_BLOCK,

    /**
     * Lapis Lazuli
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lapis_lazuli
     */
    LAPIS_LAZULI,

    /**
     * Lapis Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lapis_ore
     */
    LAPIS_ORE,

    /**
     * Large Amethyst Bud
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:large_amethyst_bud
     */
    LARGE_AMETHYST_BUD,

    /**
     * Large Fern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:large_fern
     */
    LARGE_FERN,

    /**
     * Lava Bucket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lava_bucket
     */
    LAVA_BUCKET,

    /**
     * Lead
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lead
     */
    LEAD,

    /**
     * Leaf Litter
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:leaf_litter
     */
    LEAF_LITTER,

    /**
     * Leather
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:leather
     */
    LEATHER,

    /**
     * Leather Boots
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:leather_boots
     */
    LEATHER_BOOTS,

    /**
     * Leather Chestplate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:leather_chestplate
     */
    LEATHER_CHESTPLATE,

    /**
     * Leather Helmet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:leather_helmet
     */
    LEATHER_HELMET,

    /**
     * Leather Horse Armor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:leather_horse_armor
     */
    LEATHER_HORSE_ARMOR,

    /**
     * Leather Leggings
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:leather_leggings
     */
    LEATHER_LEGGINGS,

    /**
     * Lectern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lectern
     */
    LECTERN,

    /**
     * Lever
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lever
     */
    LEVER,

    /**
     * Light
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light
     */
    LIGHT,

    /**
     * Lightning Rod
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lightning_rod
     */
    LIGHTNING_ROD,

    /**
     * Light Blue Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_banner
     */
    LIGHT_BLUE_BANNER,

    /**
     * Light Blue Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_bed
     */
    LIGHT_BLUE_BED,

    /**
     * Light Blue Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_bundle
     */
    LIGHT_BLUE_BUNDLE,

    /**
     * Light Blue Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_candle
     */
    LIGHT_BLUE_CANDLE,

    /**
     * Light Blue Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_carpet
     */
    LIGHT_BLUE_CARPET,

    /**
     * Light Blue Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_concrete
     */
    LIGHT_BLUE_CONCRETE,

    /**
     * Light Blue Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_concrete_powder
     */
    LIGHT_BLUE_CONCRETE_POWDER,

    /**
     * Light Blue Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_dye
     */
    LIGHT_BLUE_DYE,

    /**
     * Light Blue Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_glazed_terracotta
     */
    LIGHT_BLUE_GLAZED_TERRACOTTA,

    /**
     * Light Blue Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_harness
     */
    LIGHT_BLUE_HARNESS,

    /**
     * Light Blue Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_shulker_box
     */
    LIGHT_BLUE_SHULKER_BOX,

    /**
     * Light Blue Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_stained_glass
     */
    LIGHT_BLUE_STAINED_GLASS,

    /**
     * Light Blue Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_stained_glass_pane
     */
    LIGHT_BLUE_STAINED_GLASS_PANE,

    /**
     * Light Blue Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_terracotta
     */
    LIGHT_BLUE_TERRACOTTA,

    /**
     * Light Blue Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_blue_wool
     */
    LIGHT_BLUE_WOOL,

    /**
     * Light Gray Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_banner
     */
    LIGHT_GRAY_BANNER,

    /**
     * Light Gray Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_bed
     */
    LIGHT_GRAY_BED,

    /**
     * Light Gray Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_bundle
     */
    LIGHT_GRAY_BUNDLE,

    /**
     * Light Gray Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_candle
     */
    LIGHT_GRAY_CANDLE,

    /**
     * Light Gray Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_carpet
     */
    LIGHT_GRAY_CARPET,

    /**
     * Light Gray Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_concrete
     */
    LIGHT_GRAY_CONCRETE,

    /**
     * Light Gray Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_concrete_powder
     */
    LIGHT_GRAY_CONCRETE_POWDER,

    /**
     * Light Gray Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_dye
     */
    LIGHT_GRAY_DYE,

    /**
     * Light Gray Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_glazed_terracotta
     */
    LIGHT_GRAY_GLAZED_TERRACOTTA,

    /**
     * Light Gray Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_harness
     */
    LIGHT_GRAY_HARNESS,

    /**
     * Light Gray Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_shulker_box
     */
    LIGHT_GRAY_SHULKER_BOX,

    /**
     * Light Gray Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_stained_glass
     */
    LIGHT_GRAY_STAINED_GLASS,

    /**
     * Light Gray Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_stained_glass_pane
     */
    LIGHT_GRAY_STAINED_GLASS_PANE,

    /**
     * Light Gray Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_terracotta
     */
    LIGHT_GRAY_TERRACOTTA,

    /**
     * Light Gray Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_gray_wool
     */
    LIGHT_GRAY_WOOL,

    /**
     * Light Weighted Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:light_weighted_pressure_plate
     */
    LIGHT_WEIGHTED_PRESSURE_PLATE,

    /**
     * Lilac
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lilac
     */
    LILAC,

    /**
     * Lily Of The Valley
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lily_of_the_valley
     */
    LILY_OF_THE_VALLEY,

    /**
     * Lily Pad
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lily_pad
     */
    LILY_PAD,

    /**
     * Lime Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_banner
     */
    LIME_BANNER,

    /**
     * Lime Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_bed
     */
    LIME_BED,

    /**
     * Lime Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_bundle
     */
    LIME_BUNDLE,

    /**
     * Lime Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_candle
     */
    LIME_CANDLE,

    /**
     * Lime Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_carpet
     */
    LIME_CARPET,

    /**
     * Lime Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_concrete
     */
    LIME_CONCRETE,

    /**
     * Lime Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_concrete_powder
     */
    LIME_CONCRETE_POWDER,

    /**
     * Lime Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_dye
     */
    LIME_DYE,

    /**
     * Lime Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_glazed_terracotta
     */
    LIME_GLAZED_TERRACOTTA,

    /**
     * Lime Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_harness
     */
    LIME_HARNESS,

    /**
     * Lime Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_shulker_box
     */
    LIME_SHULKER_BOX,

    /**
     * Lime Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_stained_glass
     */
    LIME_STAINED_GLASS,

    /**
     * Lime Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_stained_glass_pane
     */
    LIME_STAINED_GLASS_PANE,

    /**
     * Lime Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_terracotta
     */
    LIME_TERRACOTTA,

    /**
     * Lime Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lime_wool
     */
    LIME_WOOL,

    /**
     * Lingering Potion
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lingering_potion
     */
    LINGERING_POTION,

    /**
     * Llama Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:llama_spawn_egg
     */
    LLAMA_SPAWN_EGG,

    /**
     * Lodestone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lodestone
     */
    LODESTONE,

    /**
     * Loom
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:loom
     */
    LOOM,

    /**
     * Mace
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:mace
     */
    MACE,

    /**
     * Magenta Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_banner
     */
    MAGENTA_BANNER,

    /**
     * Magenta Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_bed
     */
    MAGENTA_BED,

    /**
     * Magenta Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_bundle
     */
    MAGENTA_BUNDLE,

    /**
     * Magenta Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_candle
     */
    MAGENTA_CANDLE,

    /**
     * Magenta Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_carpet
     */
    MAGENTA_CARPET,

    /**
     * Magenta Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_concrete
     */
    MAGENTA_CONCRETE,

    /**
     * Magenta Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_concrete_powder
     */
    MAGENTA_CONCRETE_POWDER,

    /**
     * Magenta Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_dye
     */
    MAGENTA_DYE,

    /**
     * Magenta Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_glazed_terracotta
     */
    MAGENTA_GLAZED_TERRACOTTA,

    /**
     * Magenta Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_harness
     */
    MAGENTA_HARNESS,

    /**
     * Magenta Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_shulker_box
     */
    MAGENTA_SHULKER_BOX,

    /**
     * Magenta Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_stained_glass
     */
    MAGENTA_STAINED_GLASS,

    /**
     * Magenta Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_stained_glass_pane
     */
    MAGENTA_STAINED_GLASS_PANE,

    /**
     * Magenta Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_terracotta
     */
    MAGENTA_TERRACOTTA,

    /**
     * Magenta Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magenta_wool
     */
    MAGENTA_WOOL,

    /**
     * Magma Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magma_block
     */
    MAGMA_BLOCK,

    /**
     * Magma Cream
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magma_cream
     */
    MAGMA_CREAM,

    /**
     * Magma Cube Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magma_cube_spawn_egg
     */
    MAGMA_CUBE_SPAWN_EGG,

    /**
     * Mangrove Boat
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_boat
     */
    MANGROVE_BOAT,

    /**
     * Mangrove Button
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_button
     */
    MANGROVE_BUTTON,

    /**
     * Mangrove Chest Boat
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_chest_boat
     */
    MANGROVE_CHEST_BOAT,

    /**
     * Mangrove Door
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_door
     */
    MANGROVE_DOOR,

    /**
     * Mangrove Fence
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_fence
     */
    MANGROVE_FENCE,

    /**
     * Mangrove Fence Gate
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_fence_gate
     */
    MANGROVE_FENCE_GATE,

    /**
     * Mangrove Hanging Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_hanging_sign
     */
    MANGROVE_HANGING_SIGN,

    /**
     * Mangrove Leaves
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_leaves
     */
    MANGROVE_LEAVES,

    /**
     * Mangrove Log
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_log
     */
    MANGROVE_LOG,

    /**
     * Mangrove Planks
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_planks
     */
    MANGROVE_PLANKS,

    /**
     * Mangrove Pressure Plate
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_pressure_plate
     */
    MANGROVE_PRESSURE_PLATE,

    /**
     * Mangrove Propagule
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_propagule
     */
    MANGROVE_PROPAGULE,

    /**
     * Mangrove Roots
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_roots
     */
    MANGROVE_ROOTS,

    /**
     * Mangrove Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_shelf
     */
    MANGROVE_SHELF,

    /**
     * Mangrove Sign
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_sign
     */
    MANGROVE_SIGN,

    /**
     * Mangrove Slab
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_slab
     */
    MANGROVE_SLAB,

    /**
     * Mangrove Stairs
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_stairs
     */
    MANGROVE_STAIRS,

    /**
     * Mangrove Trapdoor
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_trapdoor
     */
    MANGROVE_TRAPDOOR,

    /**
     * Mangrove Wood
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_wood
     */
    MANGROVE_WOOD,

    /**
     * Map
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:map
     */
    MAP,

    /**
     * Medium Amethyst Bud
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:medium_amethyst_bud
     */
    MEDIUM_AMETHYST_BUD,

    /**
     * Melon
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:melon
     */
    MELON,

    /**
     * Melon Seeds
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:melon_seeds
     */
    MELON_SEEDS,

    /**
     * Melon Slice
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:melon_slice
     */
    MELON_SLICE,

    /**
     * Milk Bucket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:milk_bucket
     */
    MILK_BUCKET,

    /**
     * Minecart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:minecart
     */
    MINECART,

    /**
     * Miner Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:miner_pottery_sherd
     */
    MINER_POTTERY_SHERD,

    /**
     * Mojang Banner Pattern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mojang_banner_pattern
     */
    MOJANG_BANNER_PATTERN,

    /**
     * Mooshroom Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mooshroom_spawn_egg
     */
    MOOSHROOM_SPAWN_EGG,

    /**
     * Mossy Cobblestone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mossy_cobblestone
     */
    MOSSY_COBBLESTONE,

    /**
     * Mossy Cobblestone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mossy_cobblestone_slab
     */
    MOSSY_COBBLESTONE_SLAB,

    /**
     * Mossy Cobblestone Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mossy_cobblestone_stairs
     */
    MOSSY_COBBLESTONE_STAIRS,

    /**
     * Mossy Cobblestone Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mossy_cobblestone_wall
     */
    MOSSY_COBBLESTONE_WALL,

    /**
     * Mossy Stone Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mossy_stone_bricks
     */
    MOSSY_STONE_BRICKS,

    /**
     * Mossy Stone Brick Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mossy_stone_brick_slab
     */
    MOSSY_STONE_BRICK_SLAB,

    /**
     * Mossy Stone Brick Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mossy_stone_brick_stairs
     */
    MOSSY_STONE_BRICK_STAIRS,

    /**
     * Mossy Stone Brick Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mossy_stone_brick_wall
     */
    MOSSY_STONE_BRICK_WALL,

    /**
     * Moss Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:moss_block
     */
    MOSS_BLOCK,

    /**
     * Moss Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:moss_carpet
     */
    MOSS_CARPET,

    /**
     * Mourner Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mourner_pottery_sherd
     */
    MOURNER_POTTERY_SHERD,

    /**
     * Mud
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mud
     */
    MUD,

    /**
     * Muddy Mangrove Roots
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:muddy_mangrove_roots
     */
    MUDDY_MANGROVE_ROOTS,

    /**
     * Mud Bricks
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mud_bricks
     */
    MUD_BRICKS,

    /**
     * Mud Brick Slab
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mud_brick_slab
     */
    MUD_BRICK_SLAB,

    /**
     * Mud Brick Stairs
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mud_brick_stairs
     */
    MUD_BRICK_STAIRS,

    /**
     * Mud Brick Wall
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mud_brick_wall
     */
    MUD_BRICK_WALL,

    /**
     * Mule Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mule_spawn_egg
     */
    MULE_SPAWN_EGG,

    /**
     * Mushroom Stem
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mushroom_stem
     */
    MUSHROOM_STEM,

    /**
     * Mushroom Stew
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mushroom_stew
     */
    MUSHROOM_STEW,

    /**
     * Music Disc 11
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_11
     */
    MUSIC_DISC_11,

    /**
     * Music Disc 13
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_13
     */
    MUSIC_DISC_13,

    /**
     * Music Disc 5
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_5
     */
    MUSIC_DISC_5,

    /**
     * Music Disc Blocks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_blocks
     */
    MUSIC_DISC_BLOCKS,

    /**
     * Music Disc Cat
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_cat
     */
    MUSIC_DISC_CAT,

    /**
     * Music Disc Chirp
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_chirp
     */
    MUSIC_DISC_CHIRP,

    /**
     * Music Disc Creator
     * <p>
     * Supported Protocols: 767 - 774 (1.21.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_creator
     */
    MUSIC_DISC_CREATOR,

    /**
     * Music Disc Creator Music Box
     * <p>
     * Supported Protocols: 767 - 774 (1.21.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_creator_music_box
     */
    MUSIC_DISC_CREATOR_MUSIC_BOX,

    /**
     * Music Disc Far
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_far
     */
    MUSIC_DISC_FAR,

    /**
     * Music Disc Lava Chicken
     * <p>
     * Supported Protocols: 772 - 774 (1.21.7 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_lava_chicken
     */
    MUSIC_DISC_LAVA_CHICKEN,

    /**
     * Music Disc Mall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_mall
     */
    MUSIC_DISC_MALL,

    /**
     * Music Disc Mellohi
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_mellohi
     */
    MUSIC_DISC_MELLOHI,

    /**
     * Music Disc Otherside
     * <p>
     * Supported Protocols: 757 - 774 (1.18.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_otherside
     */
    MUSIC_DISC_OTHERSIDE,

    /**
     * Music Disc Pigstep
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_pigstep
     */
    MUSIC_DISC_PIGSTEP,

    /**
     * Music Disc Precipice
     * <p>
     * Supported Protocols: 767 - 774 (1.21.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_precipice
     */
    MUSIC_DISC_PRECIPICE,

    /**
     * Music Disc Relic
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_relic
     */
    MUSIC_DISC_RELIC,

    /**
     * Music Disc Stal
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_stal
     */
    MUSIC_DISC_STAL,

    /**
     * Music Disc Strad
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_strad
     */
    MUSIC_DISC_STRAD,

    /**
     * Music Disc Tears
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_tears
     */
    MUSIC_DISC_TEARS,

    /**
     * Music Disc Wait
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_wait
     */
    MUSIC_DISC_WAIT,

    /**
     * Music Disc Ward
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:music_disc_ward
     */
    MUSIC_DISC_WARD,

    /**
     * Mutton
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mutton
     */
    MUTTON,

    /**
     * Mycelium
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mycelium
     */
    MYCELIUM,

    /**
     * Name Tag
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:name_tag
     */
    NAME_TAG,

    /**
     * Nautilus Shell
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nautilus_shell
     */
    NAUTILUS_SHELL,

    /**
     * Nautilus Spawn Egg
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:nautilus_spawn_egg
     */
    NAUTILUS_SPAWN_EGG,

    /**
     * Netherite Axe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_axe
     */
    NETHERITE_AXE,

    /**
     * Netherite Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_block
     */
    NETHERITE_BLOCK,

    /**
     * Netherite Boots
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_boots
     */
    NETHERITE_BOOTS,

    /**
     * Netherite Chestplate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_chestplate
     */
    NETHERITE_CHESTPLATE,

    /**
     * Netherite Helmet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_helmet
     */
    NETHERITE_HELMET,

    /**
     * Netherite Hoe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_hoe
     */
    NETHERITE_HOE,

    /**
     * Netherite Horse Armor
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:netherite_horse_armor
     */
    NETHERITE_HORSE_ARMOR,

    /**
     * Netherite Ingot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_ingot
     */
    NETHERITE_INGOT,

    /**
     * Netherite Leggings
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_leggings
     */
    NETHERITE_LEGGINGS,

    /**
     * Netherite Nautilus Armor
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:netherite_nautilus_armor
     */
    NETHERITE_NAUTILUS_ARMOR,

    /**
     * Netherite Pickaxe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_pickaxe
     */
    NETHERITE_PICKAXE,

    /**
     * Netherite Scrap
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_scrap
     */
    NETHERITE_SCRAP,

    /**
     * Netherite Shovel
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_shovel
     */
    NETHERITE_SHOVEL,

    /**
     * Netherite Spear
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:netherite_spear
     */
    NETHERITE_SPEAR,

    /**
     * Netherite Sword
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_sword
     */
    NETHERITE_SWORD,

    /**
     * Netherite Upgrade Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:netherite_upgrade_smithing_template
     */
    NETHERITE_UPGRADE_SMITHING_TEMPLATE,

    /**
     * Netherrack
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:netherrack
     */
    NETHERRACK,

    /**
     * Nether Brick
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_brick
     */
    NETHER_BRICK,

    /**
     * Nether Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_bricks
     */
    NETHER_BRICKS,

    /**
     * Nether Brick Fence
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_brick_fence
     */
    NETHER_BRICK_FENCE,

    /**
     * Nether Brick Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_brick_slab
     */
    NETHER_BRICK_SLAB,

    /**
     * Nether Brick Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_brick_stairs
     */
    NETHER_BRICK_STAIRS,

    /**
     * Nether Brick Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_brick_wall
     */
    NETHER_BRICK_WALL,

    /**
     * Nether Gold Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_gold_ore
     */
    NETHER_GOLD_ORE,

    /**
     * Nether Quartz Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_quartz_ore
     */
    NETHER_QUARTZ_ORE,

    /**
     * Nether Sprouts
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_sprouts
     */
    NETHER_SPROUTS,

    /**
     * Nether Star
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_star
     */
    NETHER_STAR,

    /**
     * Nether Wart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_wart
     */
    NETHER_WART,

    /**
     * Nether Wart Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:nether_wart_block
     */
    NETHER_WART_BLOCK,

    /**
     * Note Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:note_block
     */
    NOTE_BLOCK,

    /**
     * Oak Boat
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_boat
     */
    OAK_BOAT,

    /**
     * Oak Button
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_button
     */
    OAK_BUTTON,

    /**
     * Oak Chest Boat
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_chest_boat
     */
    OAK_CHEST_BOAT,

    /**
     * Oak Door
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_door
     */
    OAK_DOOR,

    /**
     * Oak Fence
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_fence
     */
    OAK_FENCE,

    /**
     * Oak Fence Gate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_fence_gate
     */
    OAK_FENCE_GATE,

    /**
     * Oak Hanging Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_hanging_sign
     */
    OAK_HANGING_SIGN,

    /**
     * Oak Leaves
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_leaves
     */
    OAK_LEAVES,

    /**
     * Oak Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_log
     */
    OAK_LOG,

    /**
     * Oak Planks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_planks
     */
    OAK_PLANKS,

    /**
     * Oak Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_pressure_plate
     */
    OAK_PRESSURE_PLATE,

    /**
     * Oak Sapling
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_sapling
     */
    OAK_SAPLING,

    /**
     * Oak Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_shelf
     */
    OAK_SHELF,

    /**
     * Oak Sign
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_sign
     */
    OAK_SIGN,

    /**
     * Oak Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_slab
     */
    OAK_SLAB,

    /**
     * Oak Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_stairs
     */
    OAK_STAIRS,

    /**
     * Oak Trapdoor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_trapdoor
     */
    OAK_TRAPDOOR,

    /**
     * Oak Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_wood
     */
    OAK_WOOD,

    /**
     * Observer
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:observer
     */
    OBSERVER,

    /**
     * Obsidian
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:obsidian
     */
    OBSIDIAN,

    /**
     * Ocelot Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ocelot_spawn_egg
     */
    OCELOT_SPAWN_EGG,

    /**
     * Ochre Froglight
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ochre_froglight
     */
    OCHRE_FROGLIGHT,

    /**
     * Ominous Bottle
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:ominous_bottle
     */
    OMINOUS_BOTTLE,

    /**
     * Ominous Trial Key
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:ominous_trial_key
     */
    OMINOUS_TRIAL_KEY,

    /**
     * Open Eyeblossom
     * <p>
     * Supported Protocols: 769 - 774 (1.21.4 - 1.21.11)
     * <br>
     * Resource: minecraft:open_eyeblossom
     */
    OPEN_EYEBLOSSOM,

    /**
     * Orange Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_banner
     */
    ORANGE_BANNER,

    /**
     * Orange Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_bed
     */
    ORANGE_BED,

    /**
     * Orange Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_bundle
     */
    ORANGE_BUNDLE,

    /**
     * Orange Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_candle
     */
    ORANGE_CANDLE,

    /**
     * Orange Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_carpet
     */
    ORANGE_CARPET,

    /**
     * Orange Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_concrete
     */
    ORANGE_CONCRETE,

    /**
     * Orange Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_concrete_powder
     */
    ORANGE_CONCRETE_POWDER,

    /**
     * Orange Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_dye
     */
    ORANGE_DYE,

    /**
     * Orange Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_glazed_terracotta
     */
    ORANGE_GLAZED_TERRACOTTA,

    /**
     * Orange Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_harness
     */
    ORANGE_HARNESS,

    /**
     * Orange Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_shulker_box
     */
    ORANGE_SHULKER_BOX,

    /**
     * Orange Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_stained_glass
     */
    ORANGE_STAINED_GLASS,

    /**
     * Orange Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_stained_glass_pane
     */
    ORANGE_STAINED_GLASS_PANE,

    /**
     * Orange Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_terracotta
     */
    ORANGE_TERRACOTTA,

    /**
     * Orange Tulip
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_tulip
     */
    ORANGE_TULIP,

    /**
     * Orange Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:orange_wool
     */
    ORANGE_WOOL,

    /**
     * Oxeye Daisy
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oxeye_daisy
     */
    OXEYE_DAISY,

    /**
     * Oxidized Chiseled Copper
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_chiseled_copper
     */
    OXIDIZED_CHISELED_COPPER,

    /**
     * Oxidized Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_copper
     */
    OXIDIZED_COPPER,

    /**
     * Oxidized Copper Bars
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_copper_bars
     */
    OXIDIZED_COPPER_BARS,

    /**
     * Oxidized Copper Bulb
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_copper_bulb
     */
    OXIDIZED_COPPER_BULB,

    /**
     * Oxidized Copper Chain
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_copper_chain
     */
    OXIDIZED_COPPER_CHAIN,

    /**
     * Oxidized Copper Chest
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_copper_chest
     */
    OXIDIZED_COPPER_CHEST,

    /**
     * Oxidized Copper Door
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_copper_door
     */
    OXIDIZED_COPPER_DOOR,

    /**
     * Oxidized Copper Golem Statue
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_copper_golem_statue
     */
    OXIDIZED_COPPER_GOLEM_STATUE,

    /**
     * Oxidized Copper Grate
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_copper_grate
     */
    OXIDIZED_COPPER_GRATE,

    /**
     * Oxidized Copper Lantern
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_copper_lantern
     */
    OXIDIZED_COPPER_LANTERN,

    /**
     * Oxidized Copper Trapdoor
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_copper_trapdoor
     */
    OXIDIZED_COPPER_TRAPDOOR,

    /**
     * Oxidized Cut Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_cut_copper
     */
    OXIDIZED_CUT_COPPER,

    /**
     * Oxidized Cut Copper Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_cut_copper_slab
     */
    OXIDIZED_CUT_COPPER_SLAB,

    /**
     * Oxidized Cut Copper Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_cut_copper_stairs
     */
    OXIDIZED_CUT_COPPER_STAIRS,

    /**
     * Oxidized Lightning Rod
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:oxidized_lightning_rod
     */
    OXIDIZED_LIGHTNING_ROD,

    /**
     * Packed Ice
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:packed_ice
     */
    PACKED_ICE,

    /**
     * Packed Mud
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:packed_mud
     */
    PACKED_MUD,

    /**
     * Painting
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:painting
     */
    PAINTING,

    /**
     * Pale Hanging Moss
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_hanging_moss
     */
    PALE_HANGING_MOSS,

    /**
     * Pale Moss Block
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_moss_block
     */
    PALE_MOSS_BLOCK,

    /**
     * Pale Moss Carpet
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_moss_carpet
     */
    PALE_MOSS_CARPET,

    /**
     * Pale Oak Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_boat
     */
    PALE_OAK_BOAT,

    /**
     * Pale Oak Button
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_button
     */
    PALE_OAK_BUTTON,

    /**
     * Pale Oak Chest Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_chest_boat
     */
    PALE_OAK_CHEST_BOAT,

    /**
     * Pale Oak Door
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_door
     */
    PALE_OAK_DOOR,

    /**
     * Pale Oak Fence
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_fence
     */
    PALE_OAK_FENCE,

    /**
     * Pale Oak Fence Gate
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_fence_gate
     */
    PALE_OAK_FENCE_GATE,

    /**
     * Pale Oak Hanging Sign
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_hanging_sign
     */
    PALE_OAK_HANGING_SIGN,

    /**
     * Pale Oak Leaves
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_leaves
     */
    PALE_OAK_LEAVES,

    /**
     * Pale Oak Log
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_log
     */
    PALE_OAK_LOG,

    /**
     * Pale Oak Planks
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_planks
     */
    PALE_OAK_PLANKS,

    /**
     * Pale Oak Pressure Plate
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_pressure_plate
     */
    PALE_OAK_PRESSURE_PLATE,

    /**
     * Pale Oak Sapling
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_sapling
     */
    PALE_OAK_SAPLING,

    /**
     * Pale Oak Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_shelf
     */
    PALE_OAK_SHELF,

    /**
     * Pale Oak Sign
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_sign
     */
    PALE_OAK_SIGN,

    /**
     * Pale Oak Slab
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_slab
     */
    PALE_OAK_SLAB,

    /**
     * Pale Oak Stairs
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_stairs
     */
    PALE_OAK_STAIRS,

    /**
     * Pale Oak Trapdoor
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_trapdoor
     */
    PALE_OAK_TRAPDOOR,

    /**
     * Pale Oak Wood
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_wood
     */
    PALE_OAK_WOOD,

    /**
     * Panda Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:panda_spawn_egg
     */
    PANDA_SPAWN_EGG,

    /**
     * Paper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:paper
     */
    PAPER,

    /**
     * Parched Spawn Egg
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:parched_spawn_egg
     */
    PARCHED_SPAWN_EGG,

    /**
     * Parrot Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:parrot_spawn_egg
     */
    PARROT_SPAWN_EGG,

    /**
     * Pearlescent Froglight
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pearlescent_froglight
     */
    PEARLESCENT_FROGLIGHT,

    /**
     * Peony
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:peony
     */
    PEONY,

    /**
     * Petrified Oak Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:petrified_oak_slab
     */
    PETRIFIED_OAK_SLAB,

    /**
     * Phantom Membrane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:phantom_membrane
     */
    PHANTOM_MEMBRANE,

    /**
     * Phantom Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:phantom_spawn_egg
     */
    PHANTOM_SPAWN_EGG,

    /**
     * Piglin Banner Pattern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:piglin_banner_pattern
     */
    PIGLIN_BANNER_PATTERN,

    /**
     * Piglin Brute Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:piglin_brute_spawn_egg
     */
    PIGLIN_BRUTE_SPAWN_EGG,

    /**
     * Piglin Head
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:piglin_head
     */
    PIGLIN_HEAD,

    /**
     * Piglin Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:piglin_spawn_egg
     */
    PIGLIN_SPAWN_EGG,

    /**
     * Pig Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pig_spawn_egg
     */
    PIG_SPAWN_EGG,

    /**
     * Pillager Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pillager_spawn_egg
     */
    PILLAGER_SPAWN_EGG,

    /**
     * Pink Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_banner
     */
    PINK_BANNER,

    /**
     * Pink Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_bed
     */
    PINK_BED,

    /**
     * Pink Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_bundle
     */
    PINK_BUNDLE,

    /**
     * Pink Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_candle
     */
    PINK_CANDLE,

    /**
     * Pink Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_carpet
     */
    PINK_CARPET,

    /**
     * Pink Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_concrete
     */
    PINK_CONCRETE,

    /**
     * Pink Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_concrete_powder
     */
    PINK_CONCRETE_POWDER,

    /**
     * Pink Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_dye
     */
    PINK_DYE,

    /**
     * Pink Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_glazed_terracotta
     */
    PINK_GLAZED_TERRACOTTA,

    /**
     * Pink Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_harness
     */
    PINK_HARNESS,

    /**
     * Pink Petals
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_petals
     */
    PINK_PETALS,

    /**
     * Pink Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_shulker_box
     */
    PINK_SHULKER_BOX,

    /**
     * Pink Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_stained_glass
     */
    PINK_STAINED_GLASS,

    /**
     * Pink Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_stained_glass_pane
     */
    PINK_STAINED_GLASS_PANE,

    /**
     * Pink Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_terracotta
     */
    PINK_TERRACOTTA,

    /**
     * Pink Tulip
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_tulip
     */
    PINK_TULIP,

    /**
     * Pink Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pink_wool
     */
    PINK_WOOL,

    /**
     * Piston
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:piston
     */
    PISTON,

    /**
     * Pitcher Plant
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pitcher_plant
     */
    PITCHER_PLANT,

    /**
     * Pitcher Pod
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pitcher_pod
     */
    PITCHER_POD,

    /**
     * Player Head
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:player_head
     */
    PLAYER_HEAD,

    /**
     * Plenty Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:plenty_pottery_sherd
     */
    PLENTY_POTTERY_SHERD,

    /**
     * Podzol
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:podzol
     */
    PODZOL,

    /**
     * Pointed Dripstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pointed_dripstone
     */
    POINTED_DRIPSTONE,

    /**
     * Poisonous Potato
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:poisonous_potato
     */
    POISONOUS_POTATO,

    /**
     * Polar Bear Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polar_bear_spawn_egg
     */
    POLAR_BEAR_SPAWN_EGG,

    /**
     * Polished Andesite
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_andesite
     */
    POLISHED_ANDESITE,

    /**
     * Polished Andesite Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_andesite_slab
     */
    POLISHED_ANDESITE_SLAB,

    /**
     * Polished Andesite Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_andesite_stairs
     */
    POLISHED_ANDESITE_STAIRS,

    /**
     * Polished Basalt
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_basalt
     */
    POLISHED_BASALT,

    /**
     * Polished Blackstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_blackstone
     */
    POLISHED_BLACKSTONE,

    /**
     * Polished Blackstone Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_blackstone_bricks
     */
    POLISHED_BLACKSTONE_BRICKS,

    /**
     * Polished Blackstone Brick Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_blackstone_brick_slab
     */
    POLISHED_BLACKSTONE_BRICK_SLAB,

    /**
     * Polished Blackstone Brick Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_blackstone_brick_stairs
     */
    POLISHED_BLACKSTONE_BRICK_STAIRS,

    /**
     * Polished Blackstone Brick Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_blackstone_brick_wall
     */
    POLISHED_BLACKSTONE_BRICK_WALL,

    /**
     * Polished Blackstone Button
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_blackstone_button
     */
    POLISHED_BLACKSTONE_BUTTON,

    /**
     * Polished Blackstone Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_blackstone_pressure_plate
     */
    POLISHED_BLACKSTONE_PRESSURE_PLATE,

    /**
     * Polished Blackstone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_blackstone_slab
     */
    POLISHED_BLACKSTONE_SLAB,

    /**
     * Polished Blackstone Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_blackstone_stairs
     */
    POLISHED_BLACKSTONE_STAIRS,

    /**
     * Polished Blackstone Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_blackstone_wall
     */
    POLISHED_BLACKSTONE_WALL,

    /**
     * Polished Deepslate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_deepslate
     */
    POLISHED_DEEPSLATE,

    /**
     * Polished Deepslate Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_deepslate_slab
     */
    POLISHED_DEEPSLATE_SLAB,

    /**
     * Polished Deepslate Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_deepslate_stairs
     */
    POLISHED_DEEPSLATE_STAIRS,

    /**
     * Polished Deepslate Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_deepslate_wall
     */
    POLISHED_DEEPSLATE_WALL,

    /**
     * Polished Diorite
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_diorite
     */
    POLISHED_DIORITE,

    /**
     * Polished Diorite Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_diorite_slab
     */
    POLISHED_DIORITE_SLAB,

    /**
     * Polished Diorite Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_diorite_stairs
     */
    POLISHED_DIORITE_STAIRS,

    /**
     * Polished Granite
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_granite
     */
    POLISHED_GRANITE,

    /**
     * Polished Granite Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_granite_slab
     */
    POLISHED_GRANITE_SLAB,

    /**
     * Polished Granite Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_granite_stairs
     */
    POLISHED_GRANITE_STAIRS,

    /**
     * Polished Tuff
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_tuff
     */
    POLISHED_TUFF,

    /**
     * Polished Tuff Slab
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_tuff_slab
     */
    POLISHED_TUFF_SLAB,

    /**
     * Polished Tuff Stairs
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_tuff_stairs
     */
    POLISHED_TUFF_STAIRS,

    /**
     * Polished Tuff Wall
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:polished_tuff_wall
     */
    POLISHED_TUFF_WALL,

    /**
     * Popped Chorus Fruit
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:popped_chorus_fruit
     */
    POPPED_CHORUS_FRUIT,

    /**
     * Poppy
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:poppy
     */
    POPPY,

    /**
     * Porkchop
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:porkchop
     */
    PORKCHOP,

    /**
     * Potato
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:potato
     */
    POTATO,

    /**
     * Potion
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:potion
     */
    POTION,

    /**
     * Powder Snow Bucket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:powder_snow_bucket
     */
    POWDER_SNOW_BUCKET,

    /**
     * Powered Rail
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:powered_rail
     */
    POWERED_RAIL,

    /**
     * Prismarine
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:prismarine
     */
    PRISMARINE,

    /**
     * Prismarine Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:prismarine_bricks
     */
    PRISMARINE_BRICKS,

    /**
     * Prismarine Brick Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:prismarine_brick_slab
     */
    PRISMARINE_BRICK_SLAB,

    /**
     * Prismarine Brick Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:prismarine_brick_stairs
     */
    PRISMARINE_BRICK_STAIRS,

    /**
     * Prismarine Crystals
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:prismarine_crystals
     */
    PRISMARINE_CRYSTALS,

    /**
     * Prismarine Shard
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:prismarine_shard
     */
    PRISMARINE_SHARD,

    /**
     * Prismarine Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:prismarine_slab
     */
    PRISMARINE_SLAB,

    /**
     * Prismarine Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:prismarine_stairs
     */
    PRISMARINE_STAIRS,

    /**
     * Prismarine Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:prismarine_wall
     */
    PRISMARINE_WALL,

    /**
     * Prize Pottery Sherd
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resources: minecraft:pottery_shard_prize (762 (1.19.4)), minecraft:prize_pottery_sherd (763 - 774 (1.20.0 - 1.21.11))
     */
    PRIZE_POTTERY_SHERD,

    /**
     * Pufferfish
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pufferfish
     */
    PUFFERFISH,

    /**
     * Pufferfish Bucket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pufferfish_bucket
     */
    PUFFERFISH_BUCKET,

    /**
     * Pufferfish Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pufferfish_spawn_egg
     */
    PUFFERFISH_SPAWN_EGG,

    /**
     * Pumpkin
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pumpkin
     */
    PUMPKIN,

    /**
     * Pumpkin Pie
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pumpkin_pie
     */
    PUMPKIN_PIE,

    /**
     * Pumpkin Seeds
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pumpkin_seeds
     */
    PUMPKIN_SEEDS,

    /**
     * Purple Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_banner
     */
    PURPLE_BANNER,

    /**
     * Purple Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_bed
     */
    PURPLE_BED,

    /**
     * Purple Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_bundle
     */
    PURPLE_BUNDLE,

    /**
     * Purple Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_candle
     */
    PURPLE_CANDLE,

    /**
     * Purple Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_carpet
     */
    PURPLE_CARPET,

    /**
     * Purple Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_concrete
     */
    PURPLE_CONCRETE,

    /**
     * Purple Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_concrete_powder
     */
    PURPLE_CONCRETE_POWDER,

    /**
     * Purple Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_dye
     */
    PURPLE_DYE,

    /**
     * Purple Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_glazed_terracotta
     */
    PURPLE_GLAZED_TERRACOTTA,

    /**
     * Purple Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_harness
     */
    PURPLE_HARNESS,

    /**
     * Purple Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_shulker_box
     */
    PURPLE_SHULKER_BOX,

    /**
     * Purple Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_stained_glass
     */
    PURPLE_STAINED_GLASS,

    /**
     * Purple Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_stained_glass_pane
     */
    PURPLE_STAINED_GLASS_PANE,

    /**
     * Purple Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_terracotta
     */
    PURPLE_TERRACOTTA,

    /**
     * Purple Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purple_wool
     */
    PURPLE_WOOL,

    /**
     * Purpur Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purpur_block
     */
    PURPUR_BLOCK,

    /**
     * Purpur Pillar
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purpur_pillar
     */
    PURPUR_PILLAR,

    /**
     * Purpur Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purpur_slab
     */
    PURPUR_SLAB,

    /**
     * Purpur Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:purpur_stairs
     */
    PURPUR_STAIRS,

    /**
     * Quartz
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:quartz
     */
    QUARTZ,

    /**
     * Quartz Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:quartz_block
     */
    QUARTZ_BLOCK,

    /**
     * Quartz Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:quartz_bricks
     */
    QUARTZ_BRICKS,

    /**
     * Quartz Pillar
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:quartz_pillar
     */
    QUARTZ_PILLAR,

    /**
     * Quartz Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:quartz_slab
     */
    QUARTZ_SLAB,

    /**
     * Quartz Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:quartz_stairs
     */
    QUARTZ_STAIRS,

    /**
     * Rabbit
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:rabbit
     */
    RABBIT,

    /**
     * Rabbit Foot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:rabbit_foot
     */
    RABBIT_FOOT,

    /**
     * Rabbit Hide
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:rabbit_hide
     */
    RABBIT_HIDE,

    /**
     * Rabbit Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:rabbit_spawn_egg
     */
    RABBIT_SPAWN_EGG,

    /**
     * Rabbit Stew
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:rabbit_stew
     */
    RABBIT_STEW,

    /**
     * Rail
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:rail
     */
    RAIL,

    /**
     * Raiser Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:raiser_armor_trim_smithing_template
     */
    RAISER_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Ravager Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ravager_spawn_egg
     */
    RAVAGER_SPAWN_EGG,

    /**
     * Raw Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:raw_copper
     */
    RAW_COPPER,

    /**
     * Raw Copper Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:raw_copper_block
     */
    RAW_COPPER_BLOCK,

    /**
     * Raw Gold
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:raw_gold
     */
    RAW_GOLD,

    /**
     * Raw Gold Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:raw_gold_block
     */
    RAW_GOLD_BLOCK,

    /**
     * Raw Iron
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:raw_iron
     */
    RAW_IRON,

    /**
     * Raw Iron Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:raw_iron_block
     */
    RAW_IRON_BLOCK,

    /**
     * Recovery Compass
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:recovery_compass
     */
    RECOVERY_COMPASS,

    /**
     * Redstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:redstone
     */
    REDSTONE,

    /**
     * Redstone Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:redstone_block
     */
    REDSTONE_BLOCK,

    /**
     * Redstone Lamp
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:redstone_lamp
     */
    REDSTONE_LAMP,

    /**
     * Redstone Ore
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:redstone_ore
     */
    REDSTONE_ORE,

    /**
     * Redstone Torch
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:redstone_torch
     */
    REDSTONE_TORCH,

    /**
     * Red Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_banner
     */
    RED_BANNER,

    /**
     * Red Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_bed
     */
    RED_BED,

    /**
     * Red Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:red_bundle
     */
    RED_BUNDLE,

    /**
     * Red Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_candle
     */
    RED_CANDLE,

    /**
     * Red Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_carpet
     */
    RED_CARPET,

    /**
     * Red Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_concrete
     */
    RED_CONCRETE,

    /**
     * Red Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_concrete_powder
     */
    RED_CONCRETE_POWDER,

    /**
     * Red Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_dye
     */
    RED_DYE,

    /**
     * Red Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_glazed_terracotta
     */
    RED_GLAZED_TERRACOTTA,

    /**
     * Red Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:red_harness
     */
    RED_HARNESS,

    /**
     * Red Mushroom
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_mushroom
     */
    RED_MUSHROOM,

    /**
     * Red Mushroom Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_mushroom_block
     */
    RED_MUSHROOM_BLOCK,

    /**
     * Red Nether Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_nether_bricks
     */
    RED_NETHER_BRICKS,

    /**
     * Red Nether Brick Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_nether_brick_slab
     */
    RED_NETHER_BRICK_SLAB,

    /**
     * Red Nether Brick Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_nether_brick_stairs
     */
    RED_NETHER_BRICK_STAIRS,

    /**
     * Red Nether Brick Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_nether_brick_wall
     */
    RED_NETHER_BRICK_WALL,

    /**
     * Red Sand
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_sand
     */
    RED_SAND,

    /**
     * Red Sandstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_sandstone
     */
    RED_SANDSTONE,

    /**
     * Red Sandstone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_sandstone_slab
     */
    RED_SANDSTONE_SLAB,

    /**
     * Red Sandstone Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_sandstone_stairs
     */
    RED_SANDSTONE_STAIRS,

    /**
     * Red Sandstone Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_sandstone_wall
     */
    RED_SANDSTONE_WALL,

    /**
     * Red Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_shulker_box
     */
    RED_SHULKER_BOX,

    /**
     * Red Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_stained_glass
     */
    RED_STAINED_GLASS,

    /**
     * Red Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_stained_glass_pane
     */
    RED_STAINED_GLASS_PANE,

    /**
     * Red Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_terracotta
     */
    RED_TERRACOTTA,

    /**
     * Red Tulip
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_tulip
     */
    RED_TULIP,

    /**
     * Red Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:red_wool
     */
    RED_WOOL,

    /**
     * Reinforced Deepslate
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:reinforced_deepslate
     */
    REINFORCED_DEEPSLATE,

    /**
     * Repeater
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:repeater
     */
    REPEATER,

    /**
     * Repeating Command Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:repeating_command_block
     */
    REPEATING_COMMAND_BLOCK,

    /**
     * Resin Block
     * <p>
     * Supported Protocols: 769 - 774 (1.21.4 - 1.21.11)
     * <br>
     * Resource: minecraft:resin_block
     */
    RESIN_BLOCK,

    /**
     * Resin Brick
     * <p>
     * Supported Protocols: 769 - 774 (1.21.4 - 1.21.11)
     * <br>
     * Resource: minecraft:resin_brick
     */
    RESIN_BRICK,

    /**
     * Resin Bricks
     * <p>
     * Supported Protocols: 769 - 774 (1.21.4 - 1.21.11)
     * <br>
     * Resource: minecraft:resin_bricks
     */
    RESIN_BRICKS,

    /**
     * Resin Brick Slab
     * <p>
     * Supported Protocols: 769 - 774 (1.21.4 - 1.21.11)
     * <br>
     * Resource: minecraft:resin_brick_slab
     */
    RESIN_BRICK_SLAB,

    /**
     * Resin Brick Stairs
     * <p>
     * Supported Protocols: 769 - 774 (1.21.4 - 1.21.11)
     * <br>
     * Resource: minecraft:resin_brick_stairs
     */
    RESIN_BRICK_STAIRS,

    /**
     * Resin Brick Wall
     * <p>
     * Supported Protocols: 769 - 774 (1.21.4 - 1.21.11)
     * <br>
     * Resource: minecraft:resin_brick_wall
     */
    RESIN_BRICK_WALL,

    /**
     * Resin Clump
     * <p>
     * Supported Protocols: 769 - 774 (1.21.4 - 1.21.11)
     * <br>
     * Resource: minecraft:resin_clump
     */
    RESIN_CLUMP,

    /**
     * Respawn Anchor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:respawn_anchor
     */
    RESPAWN_ANCHOR,

    /**
     * Rib Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:rib_armor_trim_smithing_template
     */
    RIB_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Rooted Dirt
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:rooted_dirt
     */
    ROOTED_DIRT,

    /**
     * Rose Bush
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:rose_bush
     */
    ROSE_BUSH,

    /**
     * Rotten Flesh
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:rotten_flesh
     */
    ROTTEN_FLESH,

    /**
     * Saddle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:saddle
     */
    SADDLE,

    /**
     * Salmon
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:salmon
     */
    SALMON,

    /**
     * Salmon Bucket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:salmon_bucket
     */
    SALMON_BUCKET,

    /**
     * Salmon Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:salmon_spawn_egg
     */
    SALMON_SPAWN_EGG,

    /**
     * Sand
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sand
     */
    SAND,

    /**
     * Sandstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sandstone
     */
    SANDSTONE,

    /**
     * Sandstone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sandstone_slab
     */
    SANDSTONE_SLAB,

    /**
     * Sandstone Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sandstone_stairs
     */
    SANDSTONE_STAIRS,

    /**
     * Sandstone Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sandstone_wall
     */
    SANDSTONE_WALL,

    /**
     * Scaffolding
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:scaffolding
     */
    SCAFFOLDING,

    /**
     * Scrape Pottery Sherd
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:scrape_pottery_sherd
     */
    SCRAPE_POTTERY_SHERD,

    /**
     * Sculk
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sculk
     */
    SCULK,

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
     * Sculk Vein
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sculk_vein
     */
    SCULK_VEIN,

    /**
     * Seagrass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:seagrass
     */
    SEAGRASS,

    /**
     * Sea Lantern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sea_lantern
     */
    SEA_LANTERN,

    /**
     * Sea Pickle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sea_pickle
     */
    SEA_PICKLE,

    /**
     * Sentry Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:sentry_armor_trim_smithing_template
     */
    SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Shaper Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:shaper_armor_trim_smithing_template
     */
    SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Sheaf Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sheaf_pottery_sherd
     */
    SHEAF_POTTERY_SHERD,

    /**
     * Shears
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:shears
     */
    SHEARS,

    /**
     * Sheep Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sheep_spawn_egg
     */
    SHEEP_SPAWN_EGG,

    /**
     * Shelter Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:shelter_pottery_sherd
     */
    SHELTER_POTTERY_SHERD,

    /**
     * Shield
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:shield
     */
    SHIELD,

    /**
     * Short Dry Grass
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:short_dry_grass
     */
    SHORT_DRY_GRASS,

    /**
     * Short Grass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resources: minecraft:grass (755 - 764 (1.17.0 - 1.20.2)), minecraft:short_grass (765 - 774 (1.20.3 - 1.21.11))
     */
    SHORT_GRASS,

    /**
     * Shroomlight
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:shroomlight
     */
    SHROOMLIGHT,

    /**
     * Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:shulker_box
     */
    SHULKER_BOX,

    /**
     * Shulker Shell
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:shulker_shell
     */
    SHULKER_SHELL,

    /**
     * Shulker Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:shulker_spawn_egg
     */
    SHULKER_SPAWN_EGG,

    /**
     * Silence Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:silence_armor_trim_smithing_template
     */
    SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Silverfish Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:silverfish_spawn_egg
     */
    SILVERFISH_SPAWN_EGG,

    /**
     * Skeleton Horse Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:skeleton_horse_spawn_egg
     */
    SKELETON_HORSE_SPAWN_EGG,

    /**
     * Skeleton Skull
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:skeleton_skull
     */
    SKELETON_SKULL,

    /**
     * Skeleton Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:skeleton_spawn_egg
     */
    SKELETON_SPAWN_EGG,

    /**
     * Skull Banner Pattern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:skull_banner_pattern
     */
    SKULL_BANNER_PATTERN,

    /**
     * Skull Pottery Sherd
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resources: minecraft:pottery_shard_skull (762 (1.19.4)), minecraft:skull_pottery_sherd (763 - 774 (1.20.0 - 1.21.11))
     */
    SKULL_POTTERY_SHERD,

    /**
     * Slime Ball
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:slime_ball
     */
    SLIME_BALL,

    /**
     * Slime Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:slime_block
     */
    SLIME_BLOCK,

    /**
     * Slime Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:slime_spawn_egg
     */
    SLIME_SPAWN_EGG,

    /**
     * Small Amethyst Bud
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:small_amethyst_bud
     */
    SMALL_AMETHYST_BUD,

    /**
     * Small Dripleaf
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:small_dripleaf
     */
    SMALL_DRIPLEAF,

    /**
     * Smithing Table
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smithing_table
     */
    SMITHING_TABLE,

    /**
     * Smoker
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smoker
     */
    SMOKER,

    /**
     * Smooth Basalt
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_basalt
     */
    SMOOTH_BASALT,

    /**
     * Smooth Quartz
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_quartz
     */
    SMOOTH_QUARTZ,

    /**
     * Smooth Quartz Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_quartz_slab
     */
    SMOOTH_QUARTZ_SLAB,

    /**
     * Smooth Quartz Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_quartz_stairs
     */
    SMOOTH_QUARTZ_STAIRS,

    /**
     * Smooth Red Sandstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_red_sandstone
     */
    SMOOTH_RED_SANDSTONE,

    /**
     * Smooth Red Sandstone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_red_sandstone_slab
     */
    SMOOTH_RED_SANDSTONE_SLAB,

    /**
     * Smooth Red Sandstone Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_red_sandstone_stairs
     */
    SMOOTH_RED_SANDSTONE_STAIRS,

    /**
     * Smooth Sandstone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_sandstone
     */
    SMOOTH_SANDSTONE,

    /**
     * Smooth Sandstone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_sandstone_slab
     */
    SMOOTH_SANDSTONE_SLAB,

    /**
     * Smooth Sandstone Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_sandstone_stairs
     */
    SMOOTH_SANDSTONE_STAIRS,

    /**
     * Smooth Stone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_stone
     */
    SMOOTH_STONE,

    /**
     * Smooth Stone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:smooth_stone_slab
     */
    SMOOTH_STONE_SLAB,

    /**
     * Sniffer Egg
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sniffer_egg
     */
    SNIFFER_EGG,

    /**
     * Sniffer Spawn Egg
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:sniffer_spawn_egg
     */
    SNIFFER_SPAWN_EGG,

    /**
     * Snort Pottery Sherd
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:snort_pottery_sherd
     */
    SNORT_POTTERY_SHERD,

    /**
     * Snout Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:snout_armor_trim_smithing_template
     */
    SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Snow
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:snow
     */
    SNOW,

    /**
     * Snowball
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:snowball
     */
    SNOWBALL,

    /**
     * Snow Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:snow_block
     */
    SNOW_BLOCK,

    /**
     * Snow Golem Spawn Egg
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:snow_golem_spawn_egg
     */
    SNOW_GOLEM_SPAWN_EGG,

    /**
     * Soul Campfire
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:soul_campfire
     */
    SOUL_CAMPFIRE,

    /**
     * Soul Lantern
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:soul_lantern
     */
    SOUL_LANTERN,

    /**
     * Soul Sand
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:soul_sand
     */
    SOUL_SAND,

    /**
     * Soul Soil
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:soul_soil
     */
    SOUL_SOIL,

    /**
     * Soul Torch
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:soul_torch
     */
    SOUL_TORCH,

    /**
     * Spawner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spawner
     */
    SPAWNER,

    /**
     * Spectral Arrow
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spectral_arrow
     */
    SPECTRAL_ARROW,

    /**
     * Spider Eye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spider_eye
     */
    SPIDER_EYE,

    /**
     * Spider Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spider_spawn_egg
     */
    SPIDER_SPAWN_EGG,

    /**
     * Spire Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:spire_armor_trim_smithing_template
     */
    SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Splash Potion
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:splash_potion
     */
    SPLASH_POTION,

    /**
     * Sponge
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sponge
     */
    SPONGE,

    /**
     * Spore Blossom
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spore_blossom
     */
    SPORE_BLOSSOM,

    /**
     * Spruce Boat
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_boat
     */
    SPRUCE_BOAT,

    /**
     * Spruce Button
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_button
     */
    SPRUCE_BUTTON,

    /**
     * Spruce Chest Boat
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_chest_boat
     */
    SPRUCE_CHEST_BOAT,

    /**
     * Spruce Door
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_door
     */
    SPRUCE_DOOR,

    /**
     * Spruce Fence
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_fence
     */
    SPRUCE_FENCE,

    /**
     * Spruce Fence Gate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_fence_gate
     */
    SPRUCE_FENCE_GATE,

    /**
     * Spruce Hanging Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_hanging_sign
     */
    SPRUCE_HANGING_SIGN,

    /**
     * Spruce Leaves
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_leaves
     */
    SPRUCE_LEAVES,

    /**
     * Spruce Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_log
     */
    SPRUCE_LOG,

    /**
     * Spruce Planks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_planks
     */
    SPRUCE_PLANKS,

    /**
     * Spruce Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_pressure_plate
     */
    SPRUCE_PRESSURE_PLATE,

    /**
     * Spruce Sapling
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_sapling
     */
    SPRUCE_SAPLING,

    /**
     * Spruce Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_shelf
     */
    SPRUCE_SHELF,

    /**
     * Spruce Sign
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_sign
     */
    SPRUCE_SIGN,

    /**
     * Spruce Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_slab
     */
    SPRUCE_SLAB,

    /**
     * Spruce Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_stairs
     */
    SPRUCE_STAIRS,

    /**
     * Spruce Trapdoor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_trapdoor
     */
    SPRUCE_TRAPDOOR,

    /**
     * Spruce Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_wood
     */
    SPRUCE_WOOD,

    /**
     * Spyglass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spyglass
     */
    SPYGLASS,

    /**
     * Squid Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:squid_spawn_egg
     */
    SQUID_SPAWN_EGG,

    /**
     * Stick
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stick
     */
    STICK,

    /**
     * Sticky Piston
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sticky_piston
     */
    STICKY_PISTON,

    /**
     * Stone
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone
     */
    STONE,

    /**
     * Stonecutter
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stonecutter
     */
    STONECUTTER,

    /**
     * Stone Axe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_axe
     */
    STONE_AXE,

    /**
     * Stone Bricks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_bricks
     */
    STONE_BRICKS,

    /**
     * Stone Brick Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_brick_slab
     */
    STONE_BRICK_SLAB,

    /**
     * Stone Brick Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_brick_stairs
     */
    STONE_BRICK_STAIRS,

    /**
     * Stone Brick Wall
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_brick_wall
     */
    STONE_BRICK_WALL,

    /**
     * Stone Button
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_button
     */
    STONE_BUTTON,

    /**
     * Stone Hoe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_hoe
     */
    STONE_HOE,

    /**
     * Stone Pickaxe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_pickaxe
     */
    STONE_PICKAXE,

    /**
     * Stone Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_pressure_plate
     */
    STONE_PRESSURE_PLATE,

    /**
     * Stone Shovel
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_shovel
     */
    STONE_SHOVEL,

    /**
     * Stone Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_slab
     */
    STONE_SLAB,

    /**
     * Stone Spear
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:stone_spear
     */
    STONE_SPEAR,

    /**
     * Stone Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_stairs
     */
    STONE_STAIRS,

    /**
     * Stone Sword
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stone_sword
     */
    STONE_SWORD,

    /**
     * Stray Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stray_spawn_egg
     */
    STRAY_SPAWN_EGG,

    /**
     * Strider Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:strider_spawn_egg
     */
    STRIDER_SPAWN_EGG,

    /**
     * String
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:string
     */
    STRING,

    /**
     * Stripped Acacia Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_acacia_log
     */
    STRIPPED_ACACIA_LOG,

    /**
     * Stripped Acacia Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_acacia_wood
     */
    STRIPPED_ACACIA_WOOD,

    /**
     * Stripped Bamboo Block
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_bamboo_block
     */
    STRIPPED_BAMBOO_BLOCK,

    /**
     * Stripped Birch Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_birch_log
     */
    STRIPPED_BIRCH_LOG,

    /**
     * Stripped Birch Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_birch_wood
     */
    STRIPPED_BIRCH_WOOD,

    /**
     * Stripped Cherry Log
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_cherry_log
     */
    STRIPPED_CHERRY_LOG,

    /**
     * Stripped Cherry Wood
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_cherry_wood
     */
    STRIPPED_CHERRY_WOOD,

    /**
     * Stripped Crimson Hyphae
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_crimson_hyphae
     */
    STRIPPED_CRIMSON_HYPHAE,

    /**
     * Stripped Crimson Stem
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_crimson_stem
     */
    STRIPPED_CRIMSON_STEM,

    /**
     * Stripped Dark Oak Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_dark_oak_log
     */
    STRIPPED_DARK_OAK_LOG,

    /**
     * Stripped Dark Oak Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_dark_oak_wood
     */
    STRIPPED_DARK_OAK_WOOD,

    /**
     * Stripped Jungle Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_jungle_log
     */
    STRIPPED_JUNGLE_LOG,

    /**
     * Stripped Jungle Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_jungle_wood
     */
    STRIPPED_JUNGLE_WOOD,

    /**
     * Stripped Mangrove Log
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_mangrove_log
     */
    STRIPPED_MANGROVE_LOG,

    /**
     * Stripped Mangrove Wood
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_mangrove_wood
     */
    STRIPPED_MANGROVE_WOOD,

    /**
     * Stripped Oak Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_oak_log
     */
    STRIPPED_OAK_LOG,

    /**
     * Stripped Oak Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_oak_wood
     */
    STRIPPED_OAK_WOOD,

    /**
     * Stripped Pale Oak Log
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_pale_oak_log
     */
    STRIPPED_PALE_OAK_LOG,

    /**
     * Stripped Pale Oak Wood
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_pale_oak_wood
     */
    STRIPPED_PALE_OAK_WOOD,

    /**
     * Stripped Spruce Log
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_spruce_log
     */
    STRIPPED_SPRUCE_LOG,

    /**
     * Stripped Spruce Wood
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_spruce_wood
     */
    STRIPPED_SPRUCE_WOOD,

    /**
     * Stripped Warped Hyphae
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_warped_hyphae
     */
    STRIPPED_WARPED_HYPHAE,

    /**
     * Stripped Warped Stem
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stripped_warped_stem
     */
    STRIPPED_WARPED_STEM,

    /**
     * Structure Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:structure_block
     */
    STRUCTURE_BLOCK,

    /**
     * Structure Void
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:structure_void
     */
    STRUCTURE_VOID,

    /**
     * Sugar
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sugar
     */
    SUGAR,

    /**
     * Sugar Cane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sugar_cane
     */
    SUGAR_CANE,

    /**
     * Sunflower
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sunflower
     */
    SUNFLOWER,

    /**
     * Suspicious Gravel
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:suspicious_gravel
     */
    SUSPICIOUS_GRAVEL,

    /**
     * Suspicious Sand
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:suspicious_sand
     */
    SUSPICIOUS_SAND,

    /**
     * Suspicious Stew
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:suspicious_stew
     */
    SUSPICIOUS_STEW,

    /**
     * Sweet Berries
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sweet_berries
     */
    SWEET_BERRIES,

    /**
     * Tadpole Bucket
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tadpole_bucket
     */
    TADPOLE_BUCKET,

    /**
     * Tadpole Spawn Egg
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tadpole_spawn_egg
     */
    TADPOLE_SPAWN_EGG,

    /**
     * Tall Dry Grass
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:tall_dry_grass
     */
    TALL_DRY_GRASS,

    /**
     * Tall Grass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tall_grass
     */
    TALL_GRASS,

    /**
     * Target
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:target
     */
    TARGET,

    /**
     * Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:terracotta
     */
    TERRACOTTA,

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
     * Tide Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:tide_armor_trim_smithing_template
     */
    TIDE_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Tinted Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tinted_glass
     */
    TINTED_GLASS,

    /**
     * Tipped Arrow
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tipped_arrow
     */
    TIPPED_ARROW,

    /**
     * Tnt
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tnt
     */
    TNT,

    /**
     * Tnt Minecart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tnt_minecart
     */
    TNT_MINECART,

    /**
     * Torch
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:torch
     */
    TORCH,

    /**
     * Torchflower
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:torchflower
     */
    TORCHFLOWER,

    /**
     * Torchflower Seeds
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:torchflower_seeds
     */
    TORCHFLOWER_SEEDS,

    /**
     * Totem Of Undying
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:totem_of_undying
     */
    TOTEM_OF_UNDYING,

    /**
     * Trader Llama Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:trader_llama_spawn_egg
     */
    TRADER_LLAMA_SPAWN_EGG,

    /**
     * Trapped Chest
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:trapped_chest
     */
    TRAPPED_CHEST,

    /**
     * Trial Key
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:trial_key
     */
    TRIAL_KEY,

    /**
     * Trial Spawner
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:trial_spawner
     */
    TRIAL_SPAWNER,

    /**
     * Trident
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:trident
     */
    TRIDENT,

    /**
     * Tripwire Hook
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tripwire_hook
     */
    TRIPWIRE_HOOK,

    /**
     * Tropical Fish
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tropical_fish
     */
    TROPICAL_FISH,

    /**
     * Tropical Fish Bucket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tropical_fish_bucket
     */
    TROPICAL_FISH_BUCKET,

    /**
     * Tropical Fish Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tropical_fish_spawn_egg
     */
    TROPICAL_FISH_SPAWN_EGG,

    /**
     * Tube Coral
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tube_coral
     */
    TUBE_CORAL,

    /**
     * Tube Coral Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tube_coral_block
     */
    TUBE_CORAL_BLOCK,

    /**
     * Tube Coral Fan
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tube_coral_fan
     */
    TUBE_CORAL_FAN,

    /**
     * Tuff
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tuff
     */
    TUFF,

    /**
     * Tuff Bricks
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:tuff_bricks
     */
    TUFF_BRICKS,

    /**
     * Tuff Brick Slab
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:tuff_brick_slab
     */
    TUFF_BRICK_SLAB,

    /**
     * Tuff Brick Stairs
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:tuff_brick_stairs
     */
    TUFF_BRICK_STAIRS,

    /**
     * Tuff Brick Wall
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:tuff_brick_wall
     */
    TUFF_BRICK_WALL,

    /**
     * Tuff Slab
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:tuff_slab
     */
    TUFF_SLAB,

    /**
     * Tuff Stairs
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:tuff_stairs
     */
    TUFF_STAIRS,

    /**
     * Tuff Wall
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:tuff_wall
     */
    TUFF_WALL,

    /**
     * Turtle Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:turtle_egg
     */
    TURTLE_EGG,

    /**
     * Turtle Helmet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:turtle_helmet
     */
    TURTLE_HELMET,

    /**
     * Turtle Scute
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resources: minecraft:scute (755 - 765 (1.17.0 - 1.20.4)), minecraft:turtle_scute (766 - 774 (1.20.5 - 1.21.11))
     */
    TURTLE_SCUTE,

    /**
     * Turtle Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:turtle_spawn_egg
     */
    TURTLE_SPAWN_EGG,

    /**
     * Twisting Vines
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:twisting_vines
     */
    TWISTING_VINES,

    /**
     * Vault
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:vault
     */
    VAULT,

    /**
     * Verdant Froglight
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:verdant_froglight
     */
    VERDANT_FROGLIGHT,

    /**
     * Vex Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:vex_armor_trim_smithing_template
     */
    VEX_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Vex Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:vex_spawn_egg
     */
    VEX_SPAWN_EGG,

    /**
     * Villager Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:villager_spawn_egg
     */
    VILLAGER_SPAWN_EGG,

    /**
     * Vindicator Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:vindicator_spawn_egg
     */
    VINDICATOR_SPAWN_EGG,

    /**
     * Vine
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:vine
     */
    VINE,

    /**
     * Wandering Trader Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wandering_trader_spawn_egg
     */
    WANDERING_TRADER_SPAWN_EGG,

    /**
     * Warden Spawn Egg
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warden_spawn_egg
     */
    WARDEN_SPAWN_EGG,

    /**
     * Ward Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:ward_armor_trim_smithing_template
     */
    WARD_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Warped Button
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_button
     */
    WARPED_BUTTON,

    /**
     * Warped Door
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_door
     */
    WARPED_DOOR,

    /**
     * Warped Fence
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_fence
     */
    WARPED_FENCE,

    /**
     * Warped Fence Gate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_fence_gate
     */
    WARPED_FENCE_GATE,

    /**
     * Warped Fungus
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_fungus
     */
    WARPED_FUNGUS,

    /**
     * Warped Fungus On A Stick
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_fungus_on_a_stick
     */
    WARPED_FUNGUS_ON_A_STICK,

    /**
     * Warped Hanging Sign
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_hanging_sign
     */
    WARPED_HANGING_SIGN,

    /**
     * Warped Hyphae
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_hyphae
     */
    WARPED_HYPHAE,

    /**
     * Warped Nylium
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_nylium
     */
    WARPED_NYLIUM,

    /**
     * Warped Planks
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_planks
     */
    WARPED_PLANKS,

    /**
     * Warped Pressure Plate
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_pressure_plate
     */
    WARPED_PRESSURE_PLATE,

    /**
     * Warped Roots
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_roots
     */
    WARPED_ROOTS,

    /**
     * Warped Shelf
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_shelf
     */
    WARPED_SHELF,

    /**
     * Warped Sign
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_sign
     */
    WARPED_SIGN,

    /**
     * Warped Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_slab
     */
    WARPED_SLAB,

    /**
     * Warped Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_stairs
     */
    WARPED_STAIRS,

    /**
     * Warped Stem
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_stem
     */
    WARPED_STEM,

    /**
     * Warped Trapdoor
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_trapdoor
     */
    WARPED_TRAPDOOR,

    /**
     * Warped Wart Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warped_wart_block
     */
    WARPED_WART_BLOCK,

    /**
     * Water Bucket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:water_bucket
     */
    WATER_BUCKET,

    /**
     * Waxed Chiseled Copper
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_chiseled_copper
     */
    WAXED_CHISELED_COPPER,

    /**
     * Waxed Copper Bars
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_copper_bars
     */
    WAXED_COPPER_BARS,

    /**
     * Waxed Copper Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_copper_block
     */
    WAXED_COPPER_BLOCK,

    /**
     * Waxed Copper Bulb
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_copper_bulb
     */
    WAXED_COPPER_BULB,

    /**
     * Waxed Copper Chain
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_copper_chain
     */
    WAXED_COPPER_CHAIN,

    /**
     * Waxed Copper Chest
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_copper_chest
     */
    WAXED_COPPER_CHEST,

    /**
     * Waxed Copper Door
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_copper_door
     */
    WAXED_COPPER_DOOR,

    /**
     * Waxed Copper Golem Statue
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_copper_golem_statue
     */
    WAXED_COPPER_GOLEM_STATUE,

    /**
     * Waxed Copper Grate
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_copper_grate
     */
    WAXED_COPPER_GRATE,

    /**
     * Waxed Copper Lantern
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_copper_lantern
     */
    WAXED_COPPER_LANTERN,

    /**
     * Waxed Copper Trapdoor
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_copper_trapdoor
     */
    WAXED_COPPER_TRAPDOOR,

    /**
     * Waxed Cut Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_cut_copper
     */
    WAXED_CUT_COPPER,

    /**
     * Waxed Cut Copper Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_cut_copper_slab
     */
    WAXED_CUT_COPPER_SLAB,

    /**
     * Waxed Cut Copper Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_cut_copper_stairs
     */
    WAXED_CUT_COPPER_STAIRS,

    /**
     * Waxed Exposed Chiseled Copper
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_chiseled_copper
     */
    WAXED_EXPOSED_CHISELED_COPPER,

    /**
     * Waxed Exposed Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_copper
     */
    WAXED_EXPOSED_COPPER,

    /**
     * Waxed Exposed Copper Bars
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_copper_bars
     */
    WAXED_EXPOSED_COPPER_BARS,

    /**
     * Waxed Exposed Copper Bulb
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_copper_bulb
     */
    WAXED_EXPOSED_COPPER_BULB,

    /**
     * Waxed Exposed Copper Chain
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_copper_chain
     */
    WAXED_EXPOSED_COPPER_CHAIN,

    /**
     * Waxed Exposed Copper Chest
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_copper_chest
     */
    WAXED_EXPOSED_COPPER_CHEST,

    /**
     * Waxed Exposed Copper Door
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_copper_door
     */
    WAXED_EXPOSED_COPPER_DOOR,

    /**
     * Waxed Exposed Copper Golem Statue
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_copper_golem_statue
     */
    WAXED_EXPOSED_COPPER_GOLEM_STATUE,

    /**
     * Waxed Exposed Copper Grate
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_copper_grate
     */
    WAXED_EXPOSED_COPPER_GRATE,

    /**
     * Waxed Exposed Copper Lantern
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_copper_lantern
     */
    WAXED_EXPOSED_COPPER_LANTERN,

    /**
     * Waxed Exposed Copper Trapdoor
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_copper_trapdoor
     */
    WAXED_EXPOSED_COPPER_TRAPDOOR,

    /**
     * Waxed Exposed Cut Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_cut_copper
     */
    WAXED_EXPOSED_CUT_COPPER,

    /**
     * Waxed Exposed Cut Copper Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_cut_copper_slab
     */
    WAXED_EXPOSED_CUT_COPPER_SLAB,

    /**
     * Waxed Exposed Cut Copper Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_cut_copper_stairs
     */
    WAXED_EXPOSED_CUT_COPPER_STAIRS,

    /**
     * Waxed Exposed Lightning Rod
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_exposed_lightning_rod
     */
    WAXED_EXPOSED_LIGHTNING_ROD,

    /**
     * Waxed Lightning Rod
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_lightning_rod
     */
    WAXED_LIGHTNING_ROD,

    /**
     * Waxed Oxidized Chiseled Copper
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_chiseled_copper
     */
    WAXED_OXIDIZED_CHISELED_COPPER,

    /**
     * Waxed Oxidized Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_copper
     */
    WAXED_OXIDIZED_COPPER,

    /**
     * Waxed Oxidized Copper Bars
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_copper_bars
     */
    WAXED_OXIDIZED_COPPER_BARS,

    /**
     * Waxed Oxidized Copper Bulb
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_copper_bulb
     */
    WAXED_OXIDIZED_COPPER_BULB,

    /**
     * Waxed Oxidized Copper Chain
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_copper_chain
     */
    WAXED_OXIDIZED_COPPER_CHAIN,

    /**
     * Waxed Oxidized Copper Chest
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_copper_chest
     */
    WAXED_OXIDIZED_COPPER_CHEST,

    /**
     * Waxed Oxidized Copper Door
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_copper_door
     */
    WAXED_OXIDIZED_COPPER_DOOR,

    /**
     * Waxed Oxidized Copper Golem Statue
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_copper_golem_statue
     */
    WAXED_OXIDIZED_COPPER_GOLEM_STATUE,

    /**
     * Waxed Oxidized Copper Grate
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_copper_grate
     */
    WAXED_OXIDIZED_COPPER_GRATE,

    /**
     * Waxed Oxidized Copper Lantern
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_copper_lantern
     */
    WAXED_OXIDIZED_COPPER_LANTERN,

    /**
     * Waxed Oxidized Copper Trapdoor
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_copper_trapdoor
     */
    WAXED_OXIDIZED_COPPER_TRAPDOOR,

    /**
     * Waxed Oxidized Cut Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_cut_copper
     */
    WAXED_OXIDIZED_CUT_COPPER,

    /**
     * Waxed Oxidized Cut Copper Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_cut_copper_slab
     */
    WAXED_OXIDIZED_CUT_COPPER_SLAB,

    /**
     * Waxed Oxidized Cut Copper Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_cut_copper_stairs
     */
    WAXED_OXIDIZED_CUT_COPPER_STAIRS,

    /**
     * Waxed Oxidized Lightning Rod
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_oxidized_lightning_rod
     */
    WAXED_OXIDIZED_LIGHTNING_ROD,

    /**
     * Waxed Weathered Chiseled Copper
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_chiseled_copper
     */
    WAXED_WEATHERED_CHISELED_COPPER,

    /**
     * Waxed Weathered Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_copper
     */
    WAXED_WEATHERED_COPPER,

    /**
     * Waxed Weathered Copper Bars
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_copper_bars
     */
    WAXED_WEATHERED_COPPER_BARS,

    /**
     * Waxed Weathered Copper Bulb
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_copper_bulb
     */
    WAXED_WEATHERED_COPPER_BULB,

    /**
     * Waxed Weathered Copper Chain
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_copper_chain
     */
    WAXED_WEATHERED_COPPER_CHAIN,

    /**
     * Waxed Weathered Copper Chest
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_copper_chest
     */
    WAXED_WEATHERED_COPPER_CHEST,

    /**
     * Waxed Weathered Copper Door
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_copper_door
     */
    WAXED_WEATHERED_COPPER_DOOR,

    /**
     * Waxed Weathered Copper Golem Statue
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_copper_golem_statue
     */
    WAXED_WEATHERED_COPPER_GOLEM_STATUE,

    /**
     * Waxed Weathered Copper Grate
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_copper_grate
     */
    WAXED_WEATHERED_COPPER_GRATE,

    /**
     * Waxed Weathered Copper Lantern
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_copper_lantern
     */
    WAXED_WEATHERED_COPPER_LANTERN,

    /**
     * Waxed Weathered Copper Trapdoor
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_copper_trapdoor
     */
    WAXED_WEATHERED_COPPER_TRAPDOOR,

    /**
     * Waxed Weathered Cut Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_cut_copper
     */
    WAXED_WEATHERED_CUT_COPPER,

    /**
     * Waxed Weathered Cut Copper Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_cut_copper_slab
     */
    WAXED_WEATHERED_CUT_COPPER_SLAB,

    /**
     * Waxed Weathered Cut Copper Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_cut_copper_stairs
     */
    WAXED_WEATHERED_CUT_COPPER_STAIRS,

    /**
     * Waxed Weathered Lightning Rod
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:waxed_weathered_lightning_rod
     */
    WAXED_WEATHERED_LIGHTNING_ROD,

    /**
     * Wayfinder Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 763 - 774 (1.20.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wayfinder_armor_trim_smithing_template
     */
    WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Weathered Chiseled Copper
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_chiseled_copper
     */
    WEATHERED_CHISELED_COPPER,

    /**
     * Weathered Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_copper
     */
    WEATHERED_COPPER,

    /**
     * Weathered Copper Bars
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_copper_bars
     */
    WEATHERED_COPPER_BARS,

    /**
     * Weathered Copper Bulb
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_copper_bulb
     */
    WEATHERED_COPPER_BULB,

    /**
     * Weathered Copper Chain
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_copper_chain
     */
    WEATHERED_COPPER_CHAIN,

    /**
     * Weathered Copper Chest
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_copper_chest
     */
    WEATHERED_COPPER_CHEST,

    /**
     * Weathered Copper Door
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_copper_door
     */
    WEATHERED_COPPER_DOOR,

    /**
     * Weathered Copper Golem Statue
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_copper_golem_statue
     */
    WEATHERED_COPPER_GOLEM_STATUE,

    /**
     * Weathered Copper Grate
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_copper_grate
     */
    WEATHERED_COPPER_GRATE,

    /**
     * Weathered Copper Lantern
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_copper_lantern
     */
    WEATHERED_COPPER_LANTERN,

    /**
     * Weathered Copper Trapdoor
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_copper_trapdoor
     */
    WEATHERED_COPPER_TRAPDOOR,

    /**
     * Weathered Cut Copper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_cut_copper
     */
    WEATHERED_CUT_COPPER,

    /**
     * Weathered Cut Copper Slab
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_cut_copper_slab
     */
    WEATHERED_CUT_COPPER_SLAB,

    /**
     * Weathered Cut Copper Stairs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_cut_copper_stairs
     */
    WEATHERED_CUT_COPPER_STAIRS,

    /**
     * Weathered Lightning Rod
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:weathered_lightning_rod
     */
    WEATHERED_LIGHTNING_ROD,

    /**
     * Weeping Vines
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:weeping_vines
     */
    WEEPING_VINES,

    /**
     * Wet Sponge
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wet_sponge
     */
    WET_SPONGE,

    /**
     * Wheat
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wheat
     */
    WHEAT,

    /**
     * Wheat Seeds
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wheat_seeds
     */
    WHEAT_SEEDS,

    /**
     * White Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_banner
     */
    WHITE_BANNER,

    /**
     * White Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_bed
     */
    WHITE_BED,

    /**
     * White Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:white_bundle
     */
    WHITE_BUNDLE,

    /**
     * White Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_candle
     */
    WHITE_CANDLE,

    /**
     * White Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_carpet
     */
    WHITE_CARPET,

    /**
     * White Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_concrete
     */
    WHITE_CONCRETE,

    /**
     * White Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_concrete_powder
     */
    WHITE_CONCRETE_POWDER,

    /**
     * White Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_dye
     */
    WHITE_DYE,

    /**
     * White Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_glazed_terracotta
     */
    WHITE_GLAZED_TERRACOTTA,

    /**
     * White Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:white_harness
     */
    WHITE_HARNESS,

    /**
     * White Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_shulker_box
     */
    WHITE_SHULKER_BOX,

    /**
     * White Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_stained_glass
     */
    WHITE_STAINED_GLASS,

    /**
     * White Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_stained_glass_pane
     */
    WHITE_STAINED_GLASS_PANE,

    /**
     * White Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_terracotta
     */
    WHITE_TERRACOTTA,

    /**
     * White Tulip
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_tulip
     */
    WHITE_TULIP,

    /**
     * White Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:white_wool
     */
    WHITE_WOOL,

    /**
     * Wildflowers
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:wildflowers
     */
    WILDFLOWERS,

    /**
     * Wild Armor Trim Smithing Template
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:wild_armor_trim_smithing_template
     */
    WILD_ARMOR_TRIM_SMITHING_TEMPLATE,

    /**
     * Wind Charge
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:wind_charge
     */
    WIND_CHARGE,

    /**
     * Witch Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:witch_spawn_egg
     */
    WITCH_SPAWN_EGG,

    /**
     * Wither Rose
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wither_rose
     */
    WITHER_ROSE,

    /**
     * Wither Skeleton Skull
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wither_skeleton_skull
     */
    WITHER_SKELETON_SKULL,

    /**
     * Wither Skeleton Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wither_skeleton_spawn_egg
     */
    WITHER_SKELETON_SPAWN_EGG,

    /**
     * Wither Spawn Egg
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:wither_spawn_egg
     */
    WITHER_SPAWN_EGG,

    /**
     * Wolf Armor
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:wolf_armor
     */
    WOLF_ARMOR,

    /**
     * Wolf Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wolf_spawn_egg
     */
    WOLF_SPAWN_EGG,

    /**
     * Wooden Axe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wooden_axe
     */
    WOODEN_AXE,

    /**
     * Wooden Hoe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wooden_hoe
     */
    WOODEN_HOE,

    /**
     * Wooden Pickaxe
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wooden_pickaxe
     */
    WOODEN_PICKAXE,

    /**
     * Wooden Shovel
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wooden_shovel
     */
    WOODEN_SHOVEL,

    /**
     * Wooden Spear
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:wooden_spear
     */
    WOODEN_SPEAR,

    /**
     * Wooden Sword
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wooden_sword
     */
    WOODEN_SWORD,

    /**
     * Writable Book
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:writable_book
     */
    WRITABLE_BOOK,

    /**
     * Written Book
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:written_book
     */
    WRITTEN_BOOK,

    /**
     * Yellow Banner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_banner
     */
    YELLOW_BANNER,

    /**
     * Yellow Bed
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_bed
     */
    YELLOW_BED,

    /**
     * Yellow Bundle
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_bundle
     */
    YELLOW_BUNDLE,

    /**
     * Yellow Candle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_candle
     */
    YELLOW_CANDLE,

    /**
     * Yellow Carpet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_carpet
     */
    YELLOW_CARPET,

    /**
     * Yellow Concrete
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_concrete
     */
    YELLOW_CONCRETE,

    /**
     * Yellow Concrete Powder
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_concrete_powder
     */
    YELLOW_CONCRETE_POWDER,

    /**
     * Yellow Dye
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_dye
     */
    YELLOW_DYE,

    /**
     * Yellow Glazed Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_glazed_terracotta
     */
    YELLOW_GLAZED_TERRACOTTA,

    /**
     * Yellow Harness
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_harness
     */
    YELLOW_HARNESS,

    /**
     * Yellow Shulker Box
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_shulker_box
     */
    YELLOW_SHULKER_BOX,

    /**
     * Yellow Stained Glass
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_stained_glass
     */
    YELLOW_STAINED_GLASS,

    /**
     * Yellow Stained Glass Pane
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_stained_glass_pane
     */
    YELLOW_STAINED_GLASS_PANE,

    /**
     * Yellow Terracotta
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_terracotta
     */
    YELLOW_TERRACOTTA,

    /**
     * Yellow Wool
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:yellow_wool
     */
    YELLOW_WOOL,

    /**
     * Zoglin Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:zoglin_spawn_egg
     */
    ZOGLIN_SPAWN_EGG,

    /**
     * Zombie Head
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:zombie_head
     */
    ZOMBIE_HEAD,

    /**
     * Zombie Horse Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:zombie_horse_spawn_egg
     */
    ZOMBIE_HORSE_SPAWN_EGG,

    /**
     * Zombie Nautilus Spawn Egg
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:zombie_nautilus_spawn_egg
     */
    ZOMBIE_NAUTILUS_SPAWN_EGG,

    /**
     * Zombie Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:zombie_spawn_egg
     */
    ZOMBIE_SPAWN_EGG,

    /**
     * Zombie Villager Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:zombie_villager_spawn_egg
     */
    ZOMBIE_VILLAGER_SPAWN_EGG,

    /**
     * Zombified Piglin Spawn Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:zombified_piglin_spawn_egg
     */
    ZOMBIFIED_PIGLIN_SPAWN_EGG;


    Item() {
        this.metadata = new TypeMetadata<Item>(this, new String[]{TypeMetadata.JSON_NODE_PROTOCOL, TypeMetadata.JSON_NODE_REGISTRIES, TypeMetadata.JSON_NODE_ITEM, this.name().toLowerCase()});
    }

    private final TypeMetadata<Item> metadata;

    @Override
    public TypeMetadata<Item> getMetadata() {
        return this.metadata;
    }

}
