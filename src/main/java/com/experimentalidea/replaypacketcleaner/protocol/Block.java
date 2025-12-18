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
 * Represents all the different block types.
 * <br>
 * <br> In cases where a type doesn't exist, Block.UNDEFINED should be used instead.
 * <br>
 * <br> Documentation for each type created with {@link DocumentationGenerator}.
 * Supported Protocol(s) & Resource(s) documented are only inclusive of the protocol versions Replay Packet Cleaner itself currently supports.
 *
 * @see Protocol
 */
public enum Block implements ProtocolMetadata {

    /**
     * Used to represent an undefined Block type.
     */
    UNDEFINED,


    /**
     * Acacia Button
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_button
     */
    ACACIA_BUTTON,

    /**
     * Acacia Door
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_door
     */
    ACACIA_DOOR,

    /**
     * Acacia Fence
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_fence
     */
    ACACIA_FENCE,

    /**
     * Acacia Fence Gate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_fence_gate
     */
    ACACIA_FENCE_GATE,

    /**
     * Acacia Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:acacia_hanging_sign
     */
    ACACIA_HANGING_SIGN,

    /**
     * Acacia Leaves
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_leaves
     */
    ACACIA_LEAVES,

    /**
     * Acacia Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_log
     */
    ACACIA_LOG,

    /**
     * Acacia Planks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_planks
     */
    ACACIA_PLANKS,

    /**
     * Acacia Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_pressure_plate
     */
    ACACIA_PRESSURE_PLATE,

    /**
     * Acacia Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_sapling
     */
    ACACIA_SAPLING,

    /**
     * Acacia Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:acacia_shelf
     */
    ACACIA_SHELF,

    /**
     * Acacia Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_sign
     */
    ACACIA_SIGN,

    /**
     * Acacia Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_slab
     */
    ACACIA_SLAB,

    /**
     * Acacia Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_stairs
     */
    ACACIA_STAIRS,

    /**
     * Acacia Trapdoor
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_trapdoor
     */
    ACACIA_TRAPDOOR,

    /**
     * Acacia Wall Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:acacia_wall_hanging_sign
     */
    ACACIA_WALL_HANGING_SIGN,

    /**
     * Acacia Wall Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_wall_sign
     */
    ACACIA_WALL_SIGN,

    /**
     * Acacia Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:acacia_wood
     */
    ACACIA_WOOD,

    /**
     * Activator Rail
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:activator_rail
     */
    ACTIVATOR_RAIL,

    /**
     * Air
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:air
     */
    AIR,

    /**
     * Allium
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:allium
     */
    ALLIUM,

    /**
     * Amethyst Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:amethyst_block
     */
    AMETHYST_BLOCK,

    /**
     * Amethyst Cluster
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:amethyst_cluster
     */
    AMETHYST_CLUSTER,

    /**
     * Ancient Debris
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:ancient_debris
     */
    ANCIENT_DEBRIS,

    /**
     * Andesite
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:andesite
     */
    ANDESITE,

    /**
     * Andesite Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:andesite_slab
     */
    ANDESITE_SLAB,

    /**
     * Andesite Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:andesite_stairs
     */
    ANDESITE_STAIRS,

    /**
     * Andesite Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:andesite_wall
     */
    ANDESITE_WALL,

    /**
     * Anvil
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:anvil
     */
    ANVIL,

    /**
     * Attached Melon Stem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:attached_melon_stem
     */
    ATTACHED_MELON_STEM,

    /**
     * Attached Pumpkin Stem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:attached_pumpkin_stem
     */
    ATTACHED_PUMPKIN_STEM,

    /**
     * Azalea
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:azalea
     */
    AZALEA,

    /**
     * Azalea Leaves
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:azalea_leaves
     */
    AZALEA_LEAVES,

    /**
     * Azure Bluet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:azure_bluet
     */
    AZURE_BLUET,

    /**
     * Bamboo
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bamboo
     */
    BAMBOO,

    /**
     * Bamboo Block
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_block
     */
    BAMBOO_BLOCK,

    /**
     * Bamboo Button
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_button
     */
    BAMBOO_BUTTON,

    /**
     * Bamboo Door
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_door
     */
    BAMBOO_DOOR,

    /**
     * Bamboo Fence
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_fence
     */
    BAMBOO_FENCE,

    /**
     * Bamboo Fence Gate
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_fence_gate
     */
    BAMBOO_FENCE_GATE,

    /**
     * Bamboo Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_hanging_sign
     */
    BAMBOO_HANGING_SIGN,

    /**
     * Bamboo Mosaic
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_mosaic
     */
    BAMBOO_MOSAIC,

    /**
     * Bamboo Mosaic Slab
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_mosaic_slab
     */
    BAMBOO_MOSAIC_SLAB,

    /**
     * Bamboo Mosaic Stairs
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_mosaic_stairs
     */
    BAMBOO_MOSAIC_STAIRS,

    /**
     * Bamboo Planks
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_planks
     */
    BAMBOO_PLANKS,

    /**
     * Bamboo Pressure Plate
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_pressure_plate
     */
    BAMBOO_PRESSURE_PLATE,

    /**
     * Bamboo Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bamboo_sapling
     */
    BAMBOO_SAPLING,

    /**
     * Bamboo Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:bamboo_shelf
     */
    BAMBOO_SHELF,

    /**
     * Bamboo Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_sign
     */
    BAMBOO_SIGN,

    /**
     * Bamboo Slab
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_slab
     */
    BAMBOO_SLAB,

    /**
     * Bamboo Stairs
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_stairs
     */
    BAMBOO_STAIRS,

    /**
     * Bamboo Trapdoor
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_trapdoor
     */
    BAMBOO_TRAPDOOR,

    /**
     * Bamboo Wall Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_wall_hanging_sign
     */
    BAMBOO_WALL_HANGING_SIGN,

    /**
     * Bamboo Wall Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:bamboo_wall_sign
     */
    BAMBOO_WALL_SIGN,

    /**
     * Barrel
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:barrel
     */
    BARREL,

    /**
     * Barrier
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:barrier
     */
    BARRIER,

    /**
     * Basalt
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:basalt
     */
    BASALT,

    /**
     * Beacon
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:beacon
     */
    BEACON,

    /**
     * Bedrock
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bedrock
     */
    BEDROCK,

    /**
     * Beehive
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:beehive
     */
    BEEHIVE,

    /**
     * Beetroots
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:beetroots
     */
    BEETROOTS,

    /**
     * Bee Nest
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bee_nest
     */
    BEE_NEST,

    /**
     * Bell
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bell
     */
    BELL,

    /**
     * Big Dripleaf
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:big_dripleaf
     */
    BIG_DRIPLEAF,

    /**
     * Big Dripleaf Stem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:big_dripleaf_stem
     */
    BIG_DRIPLEAF_STEM,

    /**
     * Birch Button
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_button
     */
    BIRCH_BUTTON,

    /**
     * Birch Door
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_door
     */
    BIRCH_DOOR,

    /**
     * Birch Fence
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_fence
     */
    BIRCH_FENCE,

    /**
     * Birch Fence Gate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_fence_gate
     */
    BIRCH_FENCE_GATE,

    /**
     * Birch Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:birch_hanging_sign
     */
    BIRCH_HANGING_SIGN,

    /**
     * Birch Leaves
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_leaves
     */
    BIRCH_LEAVES,

    /**
     * Birch Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_log
     */
    BIRCH_LOG,

    /**
     * Birch Planks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_planks
     */
    BIRCH_PLANKS,

    /**
     * Birch Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_pressure_plate
     */
    BIRCH_PRESSURE_PLATE,

    /**
     * Birch Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_sapling
     */
    BIRCH_SAPLING,

    /**
     * Birch Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:birch_shelf
     */
    BIRCH_SHELF,

    /**
     * Birch Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_sign
     */
    BIRCH_SIGN,

    /**
     * Birch Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_slab
     */
    BIRCH_SLAB,

    /**
     * Birch Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_stairs
     */
    BIRCH_STAIRS,

    /**
     * Birch Trapdoor
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_trapdoor
     */
    BIRCH_TRAPDOOR,

    /**
     * Birch Wall Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:birch_wall_hanging_sign
     */
    BIRCH_WALL_HANGING_SIGN,

    /**
     * Birch Wall Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_wall_sign
     */
    BIRCH_WALL_SIGN,

    /**
     * Birch Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:birch_wood
     */
    BIRCH_WOOD,

    /**
     * Blackstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blackstone
     */
    BLACKSTONE,

    /**
     * Blackstone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blackstone_slab
     */
    BLACKSTONE_SLAB,

    /**
     * Blackstone Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blackstone_stairs
     */
    BLACKSTONE_STAIRS,

    /**
     * Blackstone Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blackstone_wall
     */
    BLACKSTONE_WALL,

    /**
     * Black Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_banner
     */
    BLACK_BANNER,

    /**
     * Black Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_bed
     */
    BLACK_BED,

    /**
     * Black Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_candle
     */
    BLACK_CANDLE,

    /**
     * Black Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_candle_cake
     */
    BLACK_CANDLE_CAKE,

    /**
     * Black Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_carpet
     */
    BLACK_CARPET,

    /**
     * Black Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_concrete
     */
    BLACK_CONCRETE,

    /**
     * Black Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_concrete_powder
     */
    BLACK_CONCRETE_POWDER,

    /**
     * Black Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_glazed_terracotta
     */
    BLACK_GLAZED_TERRACOTTA,

    /**
     * Black Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_shulker_box
     */
    BLACK_SHULKER_BOX,

    /**
     * Black Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_stained_glass
     */
    BLACK_STAINED_GLASS,

    /**
     * Black Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_stained_glass_pane
     */
    BLACK_STAINED_GLASS_PANE,

    /**
     * Black Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_terracotta
     */
    BLACK_TERRACOTTA,

    /**
     * Black Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_wall_banner
     */
    BLACK_WALL_BANNER,

    /**
     * Black Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:black_wool
     */
    BLACK_WOOL,

    /**
     * Blast Furnace
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blast_furnace
     */
    BLAST_FURNACE,

    /**
     * Blue Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_banner
     */
    BLUE_BANNER,

    /**
     * Blue Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_bed
     */
    BLUE_BED,

    /**
     * Blue Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_candle
     */
    BLUE_CANDLE,

    /**
     * Blue Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_candle_cake
     */
    BLUE_CANDLE_CAKE,

    /**
     * Blue Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_carpet
     */
    BLUE_CARPET,

    /**
     * Blue Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_concrete
     */
    BLUE_CONCRETE,

    /**
     * Blue Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_concrete_powder
     */
    BLUE_CONCRETE_POWDER,

    /**
     * Blue Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_glazed_terracotta
     */
    BLUE_GLAZED_TERRACOTTA,

    /**
     * Blue Ice
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_ice
     */
    BLUE_ICE,

    /**
     * Blue Orchid
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_orchid
     */
    BLUE_ORCHID,

    /**
     * Blue Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_shulker_box
     */
    BLUE_SHULKER_BOX,

    /**
     * Blue Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_stained_glass
     */
    BLUE_STAINED_GLASS,

    /**
     * Blue Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_stained_glass_pane
     */
    BLUE_STAINED_GLASS_PANE,

    /**
     * Blue Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_terracotta
     */
    BLUE_TERRACOTTA,

    /**
     * Blue Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_wall_banner
     */
    BLUE_WALL_BANNER,

    /**
     * Blue Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blue_wool
     */
    BLUE_WOOL,

    /**
     * Bone Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bone_block
     */
    BONE_BLOCK,

    /**
     * Bookshelf
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bookshelf
     */
    BOOKSHELF,

    /**
     * Brain Coral
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brain_coral
     */
    BRAIN_CORAL,

    /**
     * Brain Coral Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brain_coral_block
     */
    BRAIN_CORAL_BLOCK,

    /**
     * Brain Coral Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brain_coral_fan
     */
    BRAIN_CORAL_FAN,

    /**
     * Brain Coral Wall Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brain_coral_wall_fan
     */
    BRAIN_CORAL_WALL_FAN,

    /**
     * Brewing Stand
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brewing_stand
     */
    BREWING_STAND,

    /**
     * Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bricks
     */
    BRICKS,

    /**
     * Brick Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brick_slab
     */
    BRICK_SLAB,

    /**
     * Brick Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brick_stairs
     */
    BRICK_STAIRS,

    /**
     * Brick Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brick_wall
     */
    BRICK_WALL,

    /**
     * Brown Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_banner
     */
    BROWN_BANNER,

    /**
     * Brown Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_bed
     */
    BROWN_BED,

    /**
     * Brown Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_candle
     */
    BROWN_CANDLE,

    /**
     * Brown Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_candle_cake
     */
    BROWN_CANDLE_CAKE,

    /**
     * Brown Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_carpet
     */
    BROWN_CARPET,

    /**
     * Brown Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_concrete
     */
    BROWN_CONCRETE,

    /**
     * Brown Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_concrete_powder
     */
    BROWN_CONCRETE_POWDER,

    /**
     * Brown Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_glazed_terracotta
     */
    BROWN_GLAZED_TERRACOTTA,

    /**
     * Brown Mushroom
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_mushroom
     */
    BROWN_MUSHROOM,

    /**
     * Brown Mushroom Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_mushroom_block
     */
    BROWN_MUSHROOM_BLOCK,

    /**
     * Brown Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_shulker_box
     */
    BROWN_SHULKER_BOX,

    /**
     * Brown Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_stained_glass
     */
    BROWN_STAINED_GLASS,

    /**
     * Brown Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_stained_glass_pane
     */
    BROWN_STAINED_GLASS_PANE,

    /**
     * Brown Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_terracotta
     */
    BROWN_TERRACOTTA,

    /**
     * Brown Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_wall_banner
     */
    BROWN_WALL_BANNER,

    /**
     * Brown Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:brown_wool
     */
    BROWN_WOOL,

    /**
     * Bubble Column
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bubble_column
     */
    BUBBLE_COLUMN,

    /**
     * Bubble Coral
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bubble_coral
     */
    BUBBLE_CORAL,

    /**
     * Bubble Coral Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bubble_coral_block
     */
    BUBBLE_CORAL_BLOCK,

    /**
     * Bubble Coral Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bubble_coral_fan
     */
    BUBBLE_CORAL_FAN,

    /**
     * Bubble Coral Wall Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bubble_coral_wall_fan
     */
    BUBBLE_CORAL_WALL_FAN,

    /**
     * Budding Amethyst
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:budding_amethyst
     */
    BUDDING_AMETHYST,

    /**
     * Bush
     * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
     * <br> Resource: minecraft:bush
     */
    BUSH,

    /**
     * Cactus
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cactus
     */
    CACTUS,

    /**
     * Cactus Flower
     * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
     * <br> Resource: minecraft:cactus_flower
     */
    CACTUS_FLOWER,

    /**
     * Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cake
     */
    CAKE,

    /**
     * Calcite
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:calcite
     */
    CALCITE,

    /**
     * Calibrated Sculk Sensor
     * <br> Supported Protocols: 763 - 773 (1.20.0 - 1.21.10)
     * <br> Resource: minecraft:calibrated_sculk_sensor
     */
    CALIBRATED_SCULK_SENSOR,

    /**
     * Campfire
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:campfire
     */
    CAMPFIRE,

    /**
     * Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:candle
     */
    CANDLE,

    /**
     * Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:candle_cake
     */
    CANDLE_CAKE,

    /**
     * Carrots
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:carrots
     */
    CARROTS,

    /**
     * Cartography Table
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cartography_table
     */
    CARTOGRAPHY_TABLE,

    /**
     * Carved Pumpkin
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:carved_pumpkin
     */
    CARVED_PUMPKIN,

    /**
     * Cauldron
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cauldron
     */
    CAULDRON,

    /**
     * Cave Air
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cave_air
     */
    CAVE_AIR,

    /**
     * Cave Vines
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cave_vines
     */
    CAVE_VINES,

    /**
     * Cave Vines Plant
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cave_vines_plant
     */
    CAVE_VINES_PLANT,

    /**
     * Chain Command Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chain_command_block
     */
    CHAIN_COMMAND_BLOCK,

    /**
     * Cherry Button
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_button
     */
    CHERRY_BUTTON,

    /**
     * Cherry Door
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_door
     */
    CHERRY_DOOR,

    /**
     * Cherry Fence
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_fence
     */
    CHERRY_FENCE,

    /**
     * Cherry Fence Gate
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_fence_gate
     */
    CHERRY_FENCE_GATE,

    /**
     * Cherry Hanging Sign
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_hanging_sign
     */
    CHERRY_HANGING_SIGN,

    /**
     * Cherry Leaves
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_leaves
     */
    CHERRY_LEAVES,

    /**
     * Cherry Log
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_log
     */
    CHERRY_LOG,

    /**
     * Cherry Planks
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_planks
     */
    CHERRY_PLANKS,

    /**
     * Cherry Pressure Plate
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_pressure_plate
     */
    CHERRY_PRESSURE_PLATE,

    /**
     * Cherry Sapling
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_sapling
     */
    CHERRY_SAPLING,

    /**
     * Cherry Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:cherry_shelf
     */
    CHERRY_SHELF,

    /**
     * Cherry Sign
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_sign
     */
    CHERRY_SIGN,

    /**
     * Cherry Slab
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_slab
     */
    CHERRY_SLAB,

    /**
     * Cherry Stairs
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_stairs
     */
    CHERRY_STAIRS,

    /**
     * Cherry Trapdoor
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_trapdoor
     */
    CHERRY_TRAPDOOR,

    /**
     * Cherry Wall Hanging Sign
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_wall_hanging_sign
     */
    CHERRY_WALL_HANGING_SIGN,

    /**
     * Cherry Wall Sign
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_wall_sign
     */
    CHERRY_WALL_SIGN,

    /**
     * Cherry Wood
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:cherry_wood
     */
    CHERRY_WOOD,

    /**
     * Chest
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chest
     */
    CHEST,

    /**
     * Chipped Anvil
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chipped_anvil
     */
    CHIPPED_ANVIL,

    /**
     * Chiseled Bookshelf
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:chiseled_bookshelf
     */
    CHISELED_BOOKSHELF,

    /**
     * Chiseled Copper
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:chiseled_copper
     */
    CHISELED_COPPER,

    /**
     * Chiseled Deepslate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chiseled_deepslate
     */
    CHISELED_DEEPSLATE,

    /**
     * Chiseled Nether Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chiseled_nether_bricks
     */
    CHISELED_NETHER_BRICKS,

    /**
     * Chiseled Polished Blackstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chiseled_polished_blackstone
     */
    CHISELED_POLISHED_BLACKSTONE,

    /**
     * Chiseled Quartz Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chiseled_quartz_block
     */
    CHISELED_QUARTZ_BLOCK,

    /**
     * Chiseled Red Sandstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chiseled_red_sandstone
     */
    CHISELED_RED_SANDSTONE,

    /**
     * Chiseled Resin Bricks
     * <br> Supported Protocols: 769 - 773 (1.21.4 - 1.21.10)
     * <br> Resource: minecraft:chiseled_resin_bricks
     */
    CHISELED_RESIN_BRICKS,

    /**
     * Chiseled Sandstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chiseled_sandstone
     */
    CHISELED_SANDSTONE,

    /**
     * Chiseled Stone Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chiseled_stone_bricks
     */
    CHISELED_STONE_BRICKS,

    /**
     * Chiseled Tuff
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:chiseled_tuff
     */
    CHISELED_TUFF,

    /**
     * Chiseled Tuff Bricks
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:chiseled_tuff_bricks
     */
    CHISELED_TUFF_BRICKS,

    /**
     * Chorus Flower
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chorus_flower
     */
    CHORUS_FLOWER,

    /**
     * Chorus Plant
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chorus_plant
     */
    CHORUS_PLANT,

    /**
     * Clay
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:clay
     */
    CLAY,

    /**
     * Closed Eyeblossom
     * <br> Supported Protocols: 769 - 773 (1.21.4 - 1.21.10)
     * <br> Resource: minecraft:closed_eyeblossom
     */
    CLOSED_EYEBLOSSOM,

    /**
     * Coal Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:coal_block
     */
    COAL_BLOCK,

    /**
     * Coal Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:coal_ore
     */
    COAL_ORE,

    /**
     * Coarse Dirt
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:coarse_dirt
     */
    COARSE_DIRT,

    /**
     * Cobbled Deepslate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cobbled_deepslate
     */
    COBBLED_DEEPSLATE,

    /**
     * Cobbled Deepslate Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cobbled_deepslate_slab
     */
    COBBLED_DEEPSLATE_SLAB,

    /**
     * Cobbled Deepslate Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cobbled_deepslate_stairs
     */
    COBBLED_DEEPSLATE_STAIRS,

    /**
     * Cobbled Deepslate Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cobbled_deepslate_wall
     */
    COBBLED_DEEPSLATE_WALL,

    /**
     * Cobblestone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cobblestone
     */
    COBBLESTONE,

    /**
     * Cobblestone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cobblestone_slab
     */
    COBBLESTONE_SLAB,

    /**
     * Cobblestone Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cobblestone_stairs
     */
    COBBLESTONE_STAIRS,

    /**
     * Cobblestone Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cobblestone_wall
     */
    COBBLESTONE_WALL,

    /**
     * Cobweb
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cobweb
     */
    COBWEB,

    /**
     * Cocoa
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cocoa
     */
    COCOA,

    /**
     * Command Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:command_block
     */
    COMMAND_BLOCK,

    /**
     * Comparator
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:comparator
     */
    COMPARATOR,

    /**
     * Composter
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:composter
     */
    COMPOSTER,

    /**
     * Conduit
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:conduit
     */
    CONDUIT,

    /**
     * Copper Bars
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:copper_bars
     */
    COPPER_BARS,

    /**
     * Copper Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:copper_block
     */
    COPPER_BLOCK,

    /**
     * Copper Bulb
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:copper_bulb
     */
    COPPER_BULB,

    /**
     * Copper Chain
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:copper_chain
     */
    COPPER_CHAIN,

    /**
     * Copper Chest
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:copper_chest
     */
    COPPER_CHEST,

    /**
     * Copper Door
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:copper_door
     */
    COPPER_DOOR,

    /**
     * Copper Golem Statue
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:copper_golem_statue
     */
    COPPER_GOLEM_STATUE,

    /**
     * Copper Grate
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:copper_grate
     */
    COPPER_GRATE,

    /**
     * Copper Lantern
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:copper_lantern
     */
    COPPER_LANTERN,

    /**
     * Copper Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:copper_ore
     */
    COPPER_ORE,

    /**
     * Copper Torch
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:copper_torch
     */
    COPPER_TORCH,

    /**
     * Copper Trapdoor
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:copper_trapdoor
     */
    COPPER_TRAPDOOR,

    /**
     * Copper Wall Torch
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:copper_wall_torch
     */
    COPPER_WALL_TORCH,

    /**
     * Cornflower
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cornflower
     */
    CORNFLOWER,

    /**
     * Cracked Deepslate Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cracked_deepslate_bricks
     */
    CRACKED_DEEPSLATE_BRICKS,

    /**
     * Cracked Deepslate Tiles
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cracked_deepslate_tiles
     */
    CRACKED_DEEPSLATE_TILES,

    /**
     * Cracked Nether Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cracked_nether_bricks
     */
    CRACKED_NETHER_BRICKS,

    /**
     * Cracked Polished Blackstone Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cracked_polished_blackstone_bricks
     */
    CRACKED_POLISHED_BLACKSTONE_BRICKS,

    /**
     * Cracked Stone Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cracked_stone_bricks
     */
    CRACKED_STONE_BRICKS,

    /**
     * Crafter
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:crafter
     */
    CRAFTER,

    /**
     * Crafting Table
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crafting_table
     */
    CRAFTING_TABLE,

    /**
     * Creaking Heart
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:creaking_heart
     */
    CREAKING_HEART,

    /**
     * Creeper Head
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:creeper_head
     */
    CREEPER_HEAD,

    /**
     * Creeper Wall Head
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:creeper_wall_head
     */
    CREEPER_WALL_HEAD,

    /**
     * Crimson Button
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_button
     */
    CRIMSON_BUTTON,

    /**
     * Crimson Door
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_door
     */
    CRIMSON_DOOR,

    /**
     * Crimson Fence
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_fence
     */
    CRIMSON_FENCE,

    /**
     * Crimson Fence Gate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_fence_gate
     */
    CRIMSON_FENCE_GATE,

    /**
     * Crimson Fungus
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_fungus
     */
    CRIMSON_FUNGUS,

    /**
     * Crimson Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:crimson_hanging_sign
     */
    CRIMSON_HANGING_SIGN,

    /**
     * Crimson Hyphae
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_hyphae
     */
    CRIMSON_HYPHAE,

    /**
     * Crimson Nylium
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_nylium
     */
    CRIMSON_NYLIUM,

    /**
     * Crimson Planks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_planks
     */
    CRIMSON_PLANKS,

    /**
     * Crimson Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_pressure_plate
     */
    CRIMSON_PRESSURE_PLATE,

    /**
     * Crimson Roots
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_roots
     */
    CRIMSON_ROOTS,

    /**
     * Crimson Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:crimson_shelf
     */
    CRIMSON_SHELF,

    /**
     * Crimson Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_sign
     */
    CRIMSON_SIGN,

    /**
     * Crimson Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_slab
     */
    CRIMSON_SLAB,

    /**
     * Crimson Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_stairs
     */
    CRIMSON_STAIRS,

    /**
     * Crimson Stem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_stem
     */
    CRIMSON_STEM,

    /**
     * Crimson Trapdoor
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_trapdoor
     */
    CRIMSON_TRAPDOOR,

    /**
     * Crimson Wall Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:crimson_wall_hanging_sign
     */
    CRIMSON_WALL_HANGING_SIGN,

    /**
     * Crimson Wall Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crimson_wall_sign
     */
    CRIMSON_WALL_SIGN,

    /**
     * Crying Obsidian
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:crying_obsidian
     */
    CRYING_OBSIDIAN,

    /**
     * Cut Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cut_copper
     */
    CUT_COPPER,

    /**
     * Cut Copper Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cut_copper_slab
     */
    CUT_COPPER_SLAB,

    /**
     * Cut Copper Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cut_copper_stairs
     */
    CUT_COPPER_STAIRS,

    /**
     * Cut Red Sandstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cut_red_sandstone
     */
    CUT_RED_SANDSTONE,

    /**
     * Cut Red Sandstone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cut_red_sandstone_slab
     */
    CUT_RED_SANDSTONE_SLAB,

    /**
     * Cut Sandstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cut_sandstone
     */
    CUT_SANDSTONE,

    /**
     * Cut Sandstone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cut_sandstone_slab
     */
    CUT_SANDSTONE_SLAB,

    /**
     * Cyan Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_banner
     */
    CYAN_BANNER,

    /**
     * Cyan Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_bed
     */
    CYAN_BED,

    /**
     * Cyan Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_candle
     */
    CYAN_CANDLE,

    /**
     * Cyan Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_candle_cake
     */
    CYAN_CANDLE_CAKE,

    /**
     * Cyan Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_carpet
     */
    CYAN_CARPET,

    /**
     * Cyan Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_concrete
     */
    CYAN_CONCRETE,

    /**
     * Cyan Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_concrete_powder
     */
    CYAN_CONCRETE_POWDER,

    /**
     * Cyan Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_glazed_terracotta
     */
    CYAN_GLAZED_TERRACOTTA,

    /**
     * Cyan Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_shulker_box
     */
    CYAN_SHULKER_BOX,

    /**
     * Cyan Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_stained_glass
     */
    CYAN_STAINED_GLASS,

    /**
     * Cyan Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_stained_glass_pane
     */
    CYAN_STAINED_GLASS_PANE,

    /**
     * Cyan Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_terracotta
     */
    CYAN_TERRACOTTA,

    /**
     * Cyan Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_wall_banner
     */
    CYAN_WALL_BANNER,

    /**
     * Cyan Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cyan_wool
     */
    CYAN_WOOL,

    /**
     * Damaged Anvil
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:damaged_anvil
     */
    DAMAGED_ANVIL,

    /**
     * Dandelion
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dandelion
     */
    DANDELION,

    /**
     * Dark Oak Button
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_button
     */
    DARK_OAK_BUTTON,

    /**
     * Dark Oak Door
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_door
     */
    DARK_OAK_DOOR,

    /**
     * Dark Oak Fence
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_fence
     */
    DARK_OAK_FENCE,

    /**
     * Dark Oak Fence Gate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_fence_gate
     */
    DARK_OAK_FENCE_GATE,

    /**
     * Dark Oak Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_hanging_sign
     */
    DARK_OAK_HANGING_SIGN,

    /**
     * Dark Oak Leaves
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_leaves
     */
    DARK_OAK_LEAVES,

    /**
     * Dark Oak Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_log
     */
    DARK_OAK_LOG,

    /**
     * Dark Oak Planks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_planks
     */
    DARK_OAK_PLANKS,

    /**
     * Dark Oak Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_pressure_plate
     */
    DARK_OAK_PRESSURE_PLATE,

    /**
     * Dark Oak Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_sapling
     */
    DARK_OAK_SAPLING,

    /**
     * Dark Oak Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_shelf
     */
    DARK_OAK_SHELF,

    /**
     * Dark Oak Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_sign
     */
    DARK_OAK_SIGN,

    /**
     * Dark Oak Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_slab
     */
    DARK_OAK_SLAB,

    /**
     * Dark Oak Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_stairs
     */
    DARK_OAK_STAIRS,

    /**
     * Dark Oak Trapdoor
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_trapdoor
     */
    DARK_OAK_TRAPDOOR,

    /**
     * Dark Oak Wall Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_wall_hanging_sign
     */
    DARK_OAK_WALL_HANGING_SIGN,

    /**
     * Dark Oak Wall Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_wall_sign
     */
    DARK_OAK_WALL_SIGN,

    /**
     * Dark Oak Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_wood
     */
    DARK_OAK_WOOD,

    /**
     * Dark Prismarine
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_prismarine
     */
    DARK_PRISMARINE,

    /**
     * Dark Prismarine Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_prismarine_slab
     */
    DARK_PRISMARINE_SLAB,

    /**
     * Dark Prismarine Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dark_prismarine_stairs
     */
    DARK_PRISMARINE_STAIRS,

    /**
     * Daylight Detector
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:daylight_detector
     */
    DAYLIGHT_DETECTOR,

    /**
     * Dead Brain Coral
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_brain_coral
     */
    DEAD_BRAIN_CORAL,

    /**
     * Dead Brain Coral Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_brain_coral_block
     */
    DEAD_BRAIN_CORAL_BLOCK,

    /**
     * Dead Brain Coral Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_brain_coral_fan
     */
    DEAD_BRAIN_CORAL_FAN,

    /**
     * Dead Brain Coral Wall Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_brain_coral_wall_fan
     */
    DEAD_BRAIN_CORAL_WALL_FAN,

    /**
     * Dead Bubble Coral
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_bubble_coral
     */
    DEAD_BUBBLE_CORAL,

    /**
     * Dead Bubble Coral Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_bubble_coral_block
     */
    DEAD_BUBBLE_CORAL_BLOCK,

    /**
     * Dead Bubble Coral Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_bubble_coral_fan
     */
    DEAD_BUBBLE_CORAL_FAN,

    /**
     * Dead Bubble Coral Wall Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_bubble_coral_wall_fan
     */
    DEAD_BUBBLE_CORAL_WALL_FAN,

    /**
     * Dead Bush
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_bush
     */
    DEAD_BUSH,

    /**
     * Dead Fire Coral
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_fire_coral
     */
    DEAD_FIRE_CORAL,

    /**
     * Dead Fire Coral Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_fire_coral_block
     */
    DEAD_FIRE_CORAL_BLOCK,

    /**
     * Dead Fire Coral Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_fire_coral_fan
     */
    DEAD_FIRE_CORAL_FAN,

    /**
     * Dead Fire Coral Wall Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_fire_coral_wall_fan
     */
    DEAD_FIRE_CORAL_WALL_FAN,

    /**
     * Dead Horn Coral
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_horn_coral
     */
    DEAD_HORN_CORAL,

    /**
     * Dead Horn Coral Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_horn_coral_block
     */
    DEAD_HORN_CORAL_BLOCK,

    /**
     * Dead Horn Coral Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_horn_coral_fan
     */
    DEAD_HORN_CORAL_FAN,

    /**
     * Dead Horn Coral Wall Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_horn_coral_wall_fan
     */
    DEAD_HORN_CORAL_WALL_FAN,

    /**
     * Dead Tube Coral
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_tube_coral
     */
    DEAD_TUBE_CORAL,

    /**
     * Dead Tube Coral Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_tube_coral_block
     */
    DEAD_TUBE_CORAL_BLOCK,

    /**
     * Dead Tube Coral Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_tube_coral_fan
     */
    DEAD_TUBE_CORAL_FAN,

    /**
     * Dead Tube Coral Wall Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dead_tube_coral_wall_fan
     */
    DEAD_TUBE_CORAL_WALL_FAN,

    /**
     * Decorated Pot
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:decorated_pot
     */
    DECORATED_POT,

    /**
     * Deepslate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate
     */
    DEEPSLATE,

    /**
     * Deepslate Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_bricks
     */
    DEEPSLATE_BRICKS,

    /**
     * Deepslate Brick Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_brick_slab
     */
    DEEPSLATE_BRICK_SLAB,

    /**
     * Deepslate Brick Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_brick_stairs
     */
    DEEPSLATE_BRICK_STAIRS,

    /**
     * Deepslate Brick Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_brick_wall
     */
    DEEPSLATE_BRICK_WALL,

    /**
     * Deepslate Coal Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_coal_ore
     */
    DEEPSLATE_COAL_ORE,

    /**
     * Deepslate Copper Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_copper_ore
     */
    DEEPSLATE_COPPER_ORE,

    /**
     * Deepslate Diamond Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_diamond_ore
     */
    DEEPSLATE_DIAMOND_ORE,

    /**
     * Deepslate Emerald Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_emerald_ore
     */
    DEEPSLATE_EMERALD_ORE,

    /**
     * Deepslate Gold Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_gold_ore
     */
    DEEPSLATE_GOLD_ORE,

    /**
     * Deepslate Iron Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_iron_ore
     */
    DEEPSLATE_IRON_ORE,

    /**
     * Deepslate Lapis Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_lapis_ore
     */
    DEEPSLATE_LAPIS_ORE,

    /**
     * Deepslate Redstone Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_redstone_ore
     */
    DEEPSLATE_REDSTONE_ORE,

    /**
     * Deepslate Tiles
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_tiles
     */
    DEEPSLATE_TILES,

    /**
     * Deepslate Tile Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_tile_slab
     */
    DEEPSLATE_TILE_SLAB,

    /**
     * Deepslate Tile Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_tile_stairs
     */
    DEEPSLATE_TILE_STAIRS,

    /**
     * Deepslate Tile Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:deepslate_tile_wall
     */
    DEEPSLATE_TILE_WALL,

    /**
     * Detector Rail
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:detector_rail
     */
    DETECTOR_RAIL,

    /**
     * Diamond Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:diamond_block
     */
    DIAMOND_BLOCK,

    /**
     * Diamond Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:diamond_ore
     */
    DIAMOND_ORE,

    /**
     * Diorite
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:diorite
     */
    DIORITE,

    /**
     * Diorite Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:diorite_slab
     */
    DIORITE_SLAB,

    /**
     * Diorite Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:diorite_stairs
     */
    DIORITE_STAIRS,

    /**
     * Diorite Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:diorite_wall
     */
    DIORITE_WALL,

    /**
     * Dirt
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dirt
     */
    DIRT,

    /**
     * Dirt Path
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dirt_path
     */
    DIRT_PATH,

    /**
     * Dispenser
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dispenser
     */
    DISPENSER,

    /**
     * Dragon Egg
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dragon_egg
     */
    DRAGON_EGG,

    /**
     * Dragon Head
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dragon_head
     */
    DRAGON_HEAD,

    /**
     * Dragon Wall Head
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dragon_wall_head
     */
    DRAGON_WALL_HEAD,

    /**
     * Dried Ghast
     * <br> Supported Protocols: 771 - 773 (1.21.6 - 1.21.10)
     * <br> Resource: minecraft:dried_ghast
     */
    DRIED_GHAST,

    /**
     * Dried Kelp Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dried_kelp_block
     */
    DRIED_KELP_BLOCK,

    /**
     * Dripstone Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dripstone_block
     */
    DRIPSTONE_BLOCK,

    /**
     * Dropper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dropper
     */
    DROPPER,

    /**
     * Emerald Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:emerald_block
     */
    EMERALD_BLOCK,

    /**
     * Emerald Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:emerald_ore
     */
    EMERALD_ORE,

    /**
     * Enchanting Table
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:enchanting_table
     */
    ENCHANTING_TABLE,

    /**
     * Ender Chest
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:ender_chest
     */
    ENDER_CHEST,

    /**
     * End Gateway
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:end_gateway
     */
    END_GATEWAY,

    /**
     * End Portal
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:end_portal
     */
    END_PORTAL,

    /**
     * End Portal Frame
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:end_portal_frame
     */
    END_PORTAL_FRAME,

    /**
     * End Rod
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:end_rod
     */
    END_ROD,

    /**
     * End Stone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:end_stone
     */
    END_STONE,

    /**
     * End Stone Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:end_stone_bricks
     */
    END_STONE_BRICKS,

    /**
     * End Stone Brick Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:end_stone_brick_slab
     */
    END_STONE_BRICK_SLAB,

    /**
     * End Stone Brick Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:end_stone_brick_stairs
     */
    END_STONE_BRICK_STAIRS,

    /**
     * End Stone Brick Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:end_stone_brick_wall
     */
    END_STONE_BRICK_WALL,

    /**
     * Exposed Chiseled Copper
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:exposed_chiseled_copper
     */
    EXPOSED_CHISELED_COPPER,

    /**
     * Exposed Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:exposed_copper
     */
    EXPOSED_COPPER,

    /**
     * Exposed Copper Bars
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:exposed_copper_bars
     */
    EXPOSED_COPPER_BARS,

    /**
     * Exposed Copper Bulb
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:exposed_copper_bulb
     */
    EXPOSED_COPPER_BULB,

    /**
     * Exposed Copper Chain
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:exposed_copper_chain
     */
    EXPOSED_COPPER_CHAIN,

    /**
     * Exposed Copper Chest
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:exposed_copper_chest
     */
    EXPOSED_COPPER_CHEST,

    /**
     * Exposed Copper Door
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:exposed_copper_door
     */
    EXPOSED_COPPER_DOOR,

    /**
     * Exposed Copper Golem Statue
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:exposed_copper_golem_statue
     */
    EXPOSED_COPPER_GOLEM_STATUE,

    /**
     * Exposed Copper Grate
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:exposed_copper_grate
     */
    EXPOSED_COPPER_GRATE,

    /**
     * Exposed Copper Lantern
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:exposed_copper_lantern
     */
    EXPOSED_COPPER_LANTERN,

    /**
     * Exposed Copper Trapdoor
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:exposed_copper_trapdoor
     */
    EXPOSED_COPPER_TRAPDOOR,

    /**
     * Exposed Cut Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:exposed_cut_copper
     */
    EXPOSED_CUT_COPPER,

    /**
     * Exposed Cut Copper Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:exposed_cut_copper_slab
     */
    EXPOSED_CUT_COPPER_SLAB,

    /**
     * Exposed Cut Copper Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:exposed_cut_copper_stairs
     */
    EXPOSED_CUT_COPPER_STAIRS,

    /**
     * Exposed Lightning Rod
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:exposed_lightning_rod
     */
    EXPOSED_LIGHTNING_ROD,

    /**
     * Farmland
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:farmland
     */
    FARMLAND,

    /**
     * Fern
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:fern
     */
    FERN,

    /**
     * Fire
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:fire
     */
    FIRE,

    /**
     * Firefly Bush
     * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
     * <br> Resource: minecraft:firefly_bush
     */
    FIREFLY_BUSH,

    /**
     * Fire Coral
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:fire_coral
     */
    FIRE_CORAL,

    /**
     * Fire Coral Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:fire_coral_block
     */
    FIRE_CORAL_BLOCK,

    /**
     * Fire Coral Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:fire_coral_fan
     */
    FIRE_CORAL_FAN,

    /**
     * Fire Coral Wall Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:fire_coral_wall_fan
     */
    FIRE_CORAL_WALL_FAN,

    /**
     * Fletching Table
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:fletching_table
     */
    FLETCHING_TABLE,

    /**
     * Flowering Azalea
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:flowering_azalea
     */
    FLOWERING_AZALEA,

    /**
     * Flowering Azalea Leaves
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:flowering_azalea_leaves
     */
    FLOWERING_AZALEA_LEAVES,

    /**
     * Flower Pot
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:flower_pot
     */
    FLOWER_POT,

    /**
     * Frogspawn
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:frogspawn
     */
    FROGSPAWN,

    /**
     * Frosted Ice
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:frosted_ice
     */
    FROSTED_ICE,

    /**
     * Furnace
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:furnace
     */
    FURNACE,

    /**
     * Gilded Blackstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gilded_blackstone
     */
    GILDED_BLACKSTONE,

    /**
     * Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:glass
     */
    GLASS,

    /**
     * Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:glass_pane
     */
    GLASS_PANE,

    /**
     * Glowstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:glowstone
     */
    GLOWSTONE,

    /**
     * Glow Lichen
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:glow_lichen
     */
    GLOW_LICHEN,

    /**
     * Gold Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gold_block
     */
    GOLD_BLOCK,

    /**
     * Gold Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gold_ore
     */
    GOLD_ORE,

    /**
     * Granite
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:granite
     */
    GRANITE,

    /**
     * Granite Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:granite_slab
     */
    GRANITE_SLAB,

    /**
     * Granite Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:granite_stairs
     */
    GRANITE_STAIRS,

    /**
     * Granite Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:granite_wall
     */
    GRANITE_WALL,

    /**
     * Grass Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:grass_block
     */
    GRASS_BLOCK,

    /**
     * Gravel
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gravel
     */
    GRAVEL,

    /**
     * Gray Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_banner
     */
    GRAY_BANNER,

    /**
     * Gray Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_bed
     */
    GRAY_BED,

    /**
     * Gray Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_candle
     */
    GRAY_CANDLE,

    /**
     * Gray Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_candle_cake
     */
    GRAY_CANDLE_CAKE,

    /**
     * Gray Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_carpet
     */
    GRAY_CARPET,

    /**
     * Gray Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_concrete
     */
    GRAY_CONCRETE,

    /**
     * Gray Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_concrete_powder
     */
    GRAY_CONCRETE_POWDER,

    /**
     * Gray Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_glazed_terracotta
     */
    GRAY_GLAZED_TERRACOTTA,

    /**
     * Gray Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_shulker_box
     */
    GRAY_SHULKER_BOX,

    /**
     * Gray Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_stained_glass
     */
    GRAY_STAINED_GLASS,

    /**
     * Gray Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_stained_glass_pane
     */
    GRAY_STAINED_GLASS_PANE,

    /**
     * Gray Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_terracotta
     */
    GRAY_TERRACOTTA,

    /**
     * Gray Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_wall_banner
     */
    GRAY_WALL_BANNER,

    /**
     * Gray Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:gray_wool
     */
    GRAY_WOOL,

    /**
     * Green Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_banner
     */
    GREEN_BANNER,

    /**
     * Green Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_bed
     */
    GREEN_BED,

    /**
     * Green Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_candle
     */
    GREEN_CANDLE,

    /**
     * Green Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_candle_cake
     */
    GREEN_CANDLE_CAKE,

    /**
     * Green Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_carpet
     */
    GREEN_CARPET,

    /**
     * Green Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_concrete
     */
    GREEN_CONCRETE,

    /**
     * Green Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_concrete_powder
     */
    GREEN_CONCRETE_POWDER,

    /**
     * Green Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_glazed_terracotta
     */
    GREEN_GLAZED_TERRACOTTA,

    /**
     * Green Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_shulker_box
     */
    GREEN_SHULKER_BOX,

    /**
     * Green Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_stained_glass
     */
    GREEN_STAINED_GLASS,

    /**
     * Green Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_stained_glass_pane
     */
    GREEN_STAINED_GLASS_PANE,

    /**
     * Green Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_terracotta
     */
    GREEN_TERRACOTTA,

    /**
     * Green Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_wall_banner
     */
    GREEN_WALL_BANNER,

    /**
     * Green Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:green_wool
     */
    GREEN_WOOL,

    /**
     * Grindstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:grindstone
     */
    GRINDSTONE,

    /**
     * Hanging Roots
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:hanging_roots
     */
    HANGING_ROOTS,

    /**
     * Hay Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:hay_block
     */
    HAY_BLOCK,

    /**
     * Heavy Core
     * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
     * <br> Resource: minecraft:heavy_core
     */
    HEAVY_CORE,

    /**
     * Heavy Weighted Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:heavy_weighted_pressure_plate
     */
    HEAVY_WEIGHTED_PRESSURE_PLATE,

    /**
     * Honeycomb Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:honeycomb_block
     */
    HONEYCOMB_BLOCK,

    /**
     * Honey Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:honey_block
     */
    HONEY_BLOCK,

    /**
     * Hopper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:hopper
     */
    HOPPER,

    /**
     * Horn Coral
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:horn_coral
     */
    HORN_CORAL,

    /**
     * Horn Coral Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:horn_coral_block
     */
    HORN_CORAL_BLOCK,

    /**
     * Horn Coral Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:horn_coral_fan
     */
    HORN_CORAL_FAN,

    /**
     * Horn Coral Wall Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:horn_coral_wall_fan
     */
    HORN_CORAL_WALL_FAN,

    /**
     * Ice
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:ice
     */
    ICE,

    /**
     * Infested Chiseled Stone Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:infested_chiseled_stone_bricks
     */
    INFESTED_CHISELED_STONE_BRICKS,

    /**
     * Infested Cobblestone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:infested_cobblestone
     */
    INFESTED_COBBLESTONE,

    /**
     * Infested Cracked Stone Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:infested_cracked_stone_bricks
     */
    INFESTED_CRACKED_STONE_BRICKS,

    /**
     * Infested Deepslate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:infested_deepslate
     */
    INFESTED_DEEPSLATE,

    /**
     * Infested Mossy Stone Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:infested_mossy_stone_bricks
     */
    INFESTED_MOSSY_STONE_BRICKS,

    /**
     * Infested Stone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:infested_stone
     */
    INFESTED_STONE,

    /**
     * Infested Stone Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:infested_stone_bricks
     */
    INFESTED_STONE_BRICKS,

    /**
     * Iron Bars
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:iron_bars
     */
    IRON_BARS,

    /**
     * Iron Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:iron_block
     */
    IRON_BLOCK,

    /**
     * Iron Chain
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resources: minecraft:chain (755 - 772 (1.17.0 - 1.21.8)), minecraft:iron_chain (773 (1.21.9 - 1.21.10))
     */
    IRON_CHAIN,

    /**
     * Iron Door
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:iron_door
     */
    IRON_DOOR,

    /**
     * Iron Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:iron_ore
     */
    IRON_ORE,

    /**
     * Iron Trapdoor
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:iron_trapdoor
     */
    IRON_TRAPDOOR,

    /**
     * Jack O Lantern
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jack_o_lantern
     */
    JACK_O_LANTERN,

    /**
     * Jigsaw
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jigsaw
     */
    JIGSAW,

    /**
     * Jukebox
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jukebox
     */
    JUKEBOX,

    /**
     * Jungle Button
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_button
     */
    JUNGLE_BUTTON,

    /**
     * Jungle Door
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_door
     */
    JUNGLE_DOOR,

    /**
     * Jungle Fence
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_fence
     */
    JUNGLE_FENCE,

    /**
     * Jungle Fence Gate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_fence_gate
     */
    JUNGLE_FENCE_GATE,

    /**
     * Jungle Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:jungle_hanging_sign
     */
    JUNGLE_HANGING_SIGN,

    /**
     * Jungle Leaves
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_leaves
     */
    JUNGLE_LEAVES,

    /**
     * Jungle Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_log
     */
    JUNGLE_LOG,

    /**
     * Jungle Planks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_planks
     */
    JUNGLE_PLANKS,

    /**
     * Jungle Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_pressure_plate
     */
    JUNGLE_PRESSURE_PLATE,

    /**
     * Jungle Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_sapling
     */
    JUNGLE_SAPLING,

    /**
     * Jungle Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:jungle_shelf
     */
    JUNGLE_SHELF,

    /**
     * Jungle Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_sign
     */
    JUNGLE_SIGN,

    /**
     * Jungle Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_slab
     */
    JUNGLE_SLAB,

    /**
     * Jungle Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_stairs
     */
    JUNGLE_STAIRS,

    /**
     * Jungle Trapdoor
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_trapdoor
     */
    JUNGLE_TRAPDOOR,

    /**
     * Jungle Wall Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:jungle_wall_hanging_sign
     */
    JUNGLE_WALL_HANGING_SIGN,

    /**
     * Jungle Wall Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_wall_sign
     */
    JUNGLE_WALL_SIGN,

    /**
     * Jungle Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:jungle_wood
     */
    JUNGLE_WOOD,

    /**
     * Kelp
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:kelp
     */
    KELP,

    /**
     * Kelp Plant
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:kelp_plant
     */
    KELP_PLANT,

    /**
     * Ladder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:ladder
     */
    LADDER,

    /**
     * Lantern
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lantern
     */
    LANTERN,

    /**
     * Lapis Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lapis_block
     */
    LAPIS_BLOCK,

    /**
     * Lapis Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lapis_ore
     */
    LAPIS_ORE,

    /**
     * Large Amethyst Bud
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:large_amethyst_bud
     */
    LARGE_AMETHYST_BUD,

    /**
     * Large Fern
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:large_fern
     */
    LARGE_FERN,

    /**
     * Lava
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lava
     */
    LAVA,

    /**
     * Lava Cauldron
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lava_cauldron
     */
    LAVA_CAULDRON,

    /**
     * Leaf Litter
     * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
     * <br> Resource: minecraft:leaf_litter
     */
    LEAF_LITTER,

    /**
     * Lectern
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lectern
     */
    LECTERN,

    /**
     * Lever
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lever
     */
    LEVER,

    /**
     * Light
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light
     */
    LIGHT,

    /**
     * Lightning Rod
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lightning_rod
     */
    LIGHTNING_ROD,

    /**
     * Light Blue Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_banner
     */
    LIGHT_BLUE_BANNER,

    /**
     * Light Blue Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_bed
     */
    LIGHT_BLUE_BED,

    /**
     * Light Blue Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_candle
     */
    LIGHT_BLUE_CANDLE,

    /**
     * Light Blue Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_candle_cake
     */
    LIGHT_BLUE_CANDLE_CAKE,

    /**
     * Light Blue Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_carpet
     */
    LIGHT_BLUE_CARPET,

    /**
     * Light Blue Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_concrete
     */
    LIGHT_BLUE_CONCRETE,

    /**
     * Light Blue Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_concrete_powder
     */
    LIGHT_BLUE_CONCRETE_POWDER,

    /**
     * Light Blue Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_glazed_terracotta
     */
    LIGHT_BLUE_GLAZED_TERRACOTTA,

    /**
     * Light Blue Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_shulker_box
     */
    LIGHT_BLUE_SHULKER_BOX,

    /**
     * Light Blue Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_stained_glass
     */
    LIGHT_BLUE_STAINED_GLASS,

    /**
     * Light Blue Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_stained_glass_pane
     */
    LIGHT_BLUE_STAINED_GLASS_PANE,

    /**
     * Light Blue Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_terracotta
     */
    LIGHT_BLUE_TERRACOTTA,

    /**
     * Light Blue Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_wall_banner
     */
    LIGHT_BLUE_WALL_BANNER,

    /**
     * Light Blue Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_blue_wool
     */
    LIGHT_BLUE_WOOL,

    /**
     * Light Gray Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_banner
     */
    LIGHT_GRAY_BANNER,

    /**
     * Light Gray Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_bed
     */
    LIGHT_GRAY_BED,

    /**
     * Light Gray Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_candle
     */
    LIGHT_GRAY_CANDLE,

    /**
     * Light Gray Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_candle_cake
     */
    LIGHT_GRAY_CANDLE_CAKE,

    /**
     * Light Gray Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_carpet
     */
    LIGHT_GRAY_CARPET,

    /**
     * Light Gray Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_concrete
     */
    LIGHT_GRAY_CONCRETE,

    /**
     * Light Gray Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_concrete_powder
     */
    LIGHT_GRAY_CONCRETE_POWDER,

    /**
     * Light Gray Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_glazed_terracotta
     */
    LIGHT_GRAY_GLAZED_TERRACOTTA,

    /**
     * Light Gray Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_shulker_box
     */
    LIGHT_GRAY_SHULKER_BOX,

    /**
     * Light Gray Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_stained_glass
     */
    LIGHT_GRAY_STAINED_GLASS,

    /**
     * Light Gray Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_stained_glass_pane
     */
    LIGHT_GRAY_STAINED_GLASS_PANE,

    /**
     * Light Gray Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_terracotta
     */
    LIGHT_GRAY_TERRACOTTA,

    /**
     * Light Gray Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_wall_banner
     */
    LIGHT_GRAY_WALL_BANNER,

    /**
     * Light Gray Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_gray_wool
     */
    LIGHT_GRAY_WOOL,

    /**
     * Light Weighted Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:light_weighted_pressure_plate
     */
    LIGHT_WEIGHTED_PRESSURE_PLATE,

    /**
     * Lilac
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lilac
     */
    LILAC,

    /**
     * Lily Of The Valley
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lily_of_the_valley
     */
    LILY_OF_THE_VALLEY,

    /**
     * Lily Pad
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lily_pad
     */
    LILY_PAD,

    /**
     * Lime Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_banner
     */
    LIME_BANNER,

    /**
     * Lime Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_bed
     */
    LIME_BED,

    /**
     * Lime Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_candle
     */
    LIME_CANDLE,

    /**
     * Lime Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_candle_cake
     */
    LIME_CANDLE_CAKE,

    /**
     * Lime Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_carpet
     */
    LIME_CARPET,

    /**
     * Lime Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_concrete
     */
    LIME_CONCRETE,

    /**
     * Lime Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_concrete_powder
     */
    LIME_CONCRETE_POWDER,

    /**
     * Lime Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_glazed_terracotta
     */
    LIME_GLAZED_TERRACOTTA,

    /**
     * Lime Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_shulker_box
     */
    LIME_SHULKER_BOX,

    /**
     * Lime Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_stained_glass
     */
    LIME_STAINED_GLASS,

    /**
     * Lime Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_stained_glass_pane
     */
    LIME_STAINED_GLASS_PANE,

    /**
     * Lime Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_terracotta
     */
    LIME_TERRACOTTA,

    /**
     * Lime Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_wall_banner
     */
    LIME_WALL_BANNER,

    /**
     * Lime Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lime_wool
     */
    LIME_WOOL,

    /**
     * Lodestone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lodestone
     */
    LODESTONE,

    /**
     * Loom
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:loom
     */
    LOOM,

    /**
     * Magenta Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_banner
     */
    MAGENTA_BANNER,

    /**
     * Magenta Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_bed
     */
    MAGENTA_BED,

    /**
     * Magenta Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_candle
     */
    MAGENTA_CANDLE,

    /**
     * Magenta Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_candle_cake
     */
    MAGENTA_CANDLE_CAKE,

    /**
     * Magenta Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_carpet
     */
    MAGENTA_CARPET,

    /**
     * Magenta Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_concrete
     */
    MAGENTA_CONCRETE,

    /**
     * Magenta Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_concrete_powder
     */
    MAGENTA_CONCRETE_POWDER,

    /**
     * Magenta Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_glazed_terracotta
     */
    MAGENTA_GLAZED_TERRACOTTA,

    /**
     * Magenta Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_shulker_box
     */
    MAGENTA_SHULKER_BOX,

    /**
     * Magenta Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_stained_glass
     */
    MAGENTA_STAINED_GLASS,

    /**
     * Magenta Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_stained_glass_pane
     */
    MAGENTA_STAINED_GLASS_PANE,

    /**
     * Magenta Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_terracotta
     */
    MAGENTA_TERRACOTTA,

    /**
     * Magenta Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_wall_banner
     */
    MAGENTA_WALL_BANNER,

    /**
     * Magenta Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magenta_wool
     */
    MAGENTA_WOOL,

    /**
     * Magma Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magma_block
     */
    MAGMA_BLOCK,

    /**
     * Mangrove Button
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_button
     */
    MANGROVE_BUTTON,

    /**
     * Mangrove Door
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_door
     */
    MANGROVE_DOOR,

    /**
     * Mangrove Fence
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_fence
     */
    MANGROVE_FENCE,

    /**
     * Mangrove Fence Gate
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_fence_gate
     */
    MANGROVE_FENCE_GATE,

    /**
     * Mangrove Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:mangrove_hanging_sign
     */
    MANGROVE_HANGING_SIGN,

    /**
     * Mangrove Leaves
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_leaves
     */
    MANGROVE_LEAVES,

    /**
     * Mangrove Log
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_log
     */
    MANGROVE_LOG,

    /**
     * Mangrove Planks
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_planks
     */
    MANGROVE_PLANKS,

    /**
     * Mangrove Pressure Plate
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_pressure_plate
     */
    MANGROVE_PRESSURE_PLATE,

    /**
     * Mangrove Propagule
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_propagule
     */
    MANGROVE_PROPAGULE,

    /**
     * Mangrove Roots
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_roots
     */
    MANGROVE_ROOTS,

    /**
     * Mangrove Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:mangrove_shelf
     */
    MANGROVE_SHELF,

    /**
     * Mangrove Sign
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_sign
     */
    MANGROVE_SIGN,

    /**
     * Mangrove Slab
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_slab
     */
    MANGROVE_SLAB,

    /**
     * Mangrove Stairs
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_stairs
     */
    MANGROVE_STAIRS,

    /**
     * Mangrove Trapdoor
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_trapdoor
     */
    MANGROVE_TRAPDOOR,

    /**
     * Mangrove Wall Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:mangrove_wall_hanging_sign
     */
    MANGROVE_WALL_HANGING_SIGN,

    /**
     * Mangrove Wall Sign
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_wall_sign
     */
    MANGROVE_WALL_SIGN,

    /**
     * Mangrove Wood
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mangrove_wood
     */
    MANGROVE_WOOD,

    /**
     * Medium Amethyst Bud
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:medium_amethyst_bud
     */
    MEDIUM_AMETHYST_BUD,

    /**
     * Melon
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:melon
     */
    MELON,

    /**
     * Melon Stem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:melon_stem
     */
    MELON_STEM,

    /**
     * Mossy Cobblestone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mossy_cobblestone
     */
    MOSSY_COBBLESTONE,

    /**
     * Mossy Cobblestone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mossy_cobblestone_slab
     */
    MOSSY_COBBLESTONE_SLAB,

    /**
     * Mossy Cobblestone Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mossy_cobblestone_stairs
     */
    MOSSY_COBBLESTONE_STAIRS,

    /**
     * Mossy Cobblestone Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mossy_cobblestone_wall
     */
    MOSSY_COBBLESTONE_WALL,

    /**
     * Mossy Stone Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mossy_stone_bricks
     */
    MOSSY_STONE_BRICKS,

    /**
     * Mossy Stone Brick Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mossy_stone_brick_slab
     */
    MOSSY_STONE_BRICK_SLAB,

    /**
     * Mossy Stone Brick Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mossy_stone_brick_stairs
     */
    MOSSY_STONE_BRICK_STAIRS,

    /**
     * Mossy Stone Brick Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mossy_stone_brick_wall
     */
    MOSSY_STONE_BRICK_WALL,

    /**
     * Moss Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:moss_block
     */
    MOSS_BLOCK,

    /**
     * Moss Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:moss_carpet
     */
    MOSS_CARPET,

    /**
     * Moving Piston
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:moving_piston
     */
    MOVING_PISTON,

    /**
     * Mud
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mud
     */
    MUD,

    /**
     * Muddy Mangrove Roots
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:muddy_mangrove_roots
     */
    MUDDY_MANGROVE_ROOTS,

    /**
     * Mud Bricks
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mud_bricks
     */
    MUD_BRICKS,

    /**
     * Mud Brick Slab
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mud_brick_slab
     */
    MUD_BRICK_SLAB,

    /**
     * Mud Brick Stairs
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mud_brick_stairs
     */
    MUD_BRICK_STAIRS,

    /**
     * Mud Brick Wall
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:mud_brick_wall
     */
    MUD_BRICK_WALL,

    /**
     * Mushroom Stem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mushroom_stem
     */
    MUSHROOM_STEM,

    /**
     * Mycelium
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mycelium
     */
    MYCELIUM,

    /**
     * Netherite Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:netherite_block
     */
    NETHERITE_BLOCK,

    /**
     * Netherrack
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:netherrack
     */
    NETHERRACK,

    /**
     * Nether Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:nether_bricks
     */
    NETHER_BRICKS,

    /**
     * Nether Brick Fence
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:nether_brick_fence
     */
    NETHER_BRICK_FENCE,

    /**
     * Nether Brick Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:nether_brick_slab
     */
    NETHER_BRICK_SLAB,

    /**
     * Nether Brick Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:nether_brick_stairs
     */
    NETHER_BRICK_STAIRS,

    /**
     * Nether Brick Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:nether_brick_wall
     */
    NETHER_BRICK_WALL,

    /**
     * Nether Gold Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:nether_gold_ore
     */
    NETHER_GOLD_ORE,

    /**
     * Nether Portal
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:nether_portal
     */
    NETHER_PORTAL,

    /**
     * Nether Quartz Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:nether_quartz_ore
     */
    NETHER_QUARTZ_ORE,

    /**
     * Nether Sprouts
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:nether_sprouts
     */
    NETHER_SPROUTS,

    /**
     * Nether Wart
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:nether_wart
     */
    NETHER_WART,

    /**
     * Nether Wart Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:nether_wart_block
     */
    NETHER_WART_BLOCK,

    /**
     * Note Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:note_block
     */
    NOTE_BLOCK,

    /**
     * Oak Button
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_button
     */
    OAK_BUTTON,

    /**
     * Oak Door
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_door
     */
    OAK_DOOR,

    /**
     * Oak Fence
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_fence
     */
    OAK_FENCE,

    /**
     * Oak Fence Gate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_fence_gate
     */
    OAK_FENCE_GATE,

    /**
     * Oak Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:oak_hanging_sign
     */
    OAK_HANGING_SIGN,

    /**
     * Oak Leaves
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_leaves
     */
    OAK_LEAVES,

    /**
     * Oak Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_log
     */
    OAK_LOG,

    /**
     * Oak Planks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_planks
     */
    OAK_PLANKS,

    /**
     * Oak Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_pressure_plate
     */
    OAK_PRESSURE_PLATE,

    /**
     * Oak Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_sapling
     */
    OAK_SAPLING,

    /**
     * Oak Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:oak_shelf
     */
    OAK_SHELF,

    /**
     * Oak Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_sign
     */
    OAK_SIGN,

    /**
     * Oak Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_slab
     */
    OAK_SLAB,

    /**
     * Oak Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_stairs
     */
    OAK_STAIRS,

    /**
     * Oak Trapdoor
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_trapdoor
     */
    OAK_TRAPDOOR,

    /**
     * Oak Wall Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:oak_wall_hanging_sign
     */
    OAK_WALL_HANGING_SIGN,

    /**
     * Oak Wall Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_wall_sign
     */
    OAK_WALL_SIGN,

    /**
     * Oak Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oak_wood
     */
    OAK_WOOD,

    /**
     * Observer
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:observer
     */
    OBSERVER,

    /**
     * Obsidian
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:obsidian
     */
    OBSIDIAN,

    /**
     * Ochre Froglight
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:ochre_froglight
     */
    OCHRE_FROGLIGHT,

    /**
     * Open Eyeblossom
     * <br> Supported Protocols: 769 - 773 (1.21.4 - 1.21.10)
     * <br> Resource: minecraft:open_eyeblossom
     */
    OPEN_EYEBLOSSOM,

    /**
     * Orange Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_banner
     */
    ORANGE_BANNER,

    /**
     * Orange Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_bed
     */
    ORANGE_BED,

    /**
     * Orange Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_candle
     */
    ORANGE_CANDLE,

    /**
     * Orange Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_candle_cake
     */
    ORANGE_CANDLE_CAKE,

    /**
     * Orange Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_carpet
     */
    ORANGE_CARPET,

    /**
     * Orange Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_concrete
     */
    ORANGE_CONCRETE,

    /**
     * Orange Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_concrete_powder
     */
    ORANGE_CONCRETE_POWDER,

    /**
     * Orange Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_glazed_terracotta
     */
    ORANGE_GLAZED_TERRACOTTA,

    /**
     * Orange Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_shulker_box
     */
    ORANGE_SHULKER_BOX,

    /**
     * Orange Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_stained_glass
     */
    ORANGE_STAINED_GLASS,

    /**
     * Orange Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_stained_glass_pane
     */
    ORANGE_STAINED_GLASS_PANE,

    /**
     * Orange Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_terracotta
     */
    ORANGE_TERRACOTTA,

    /**
     * Orange Tulip
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_tulip
     */
    ORANGE_TULIP,

    /**
     * Orange Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_wall_banner
     */
    ORANGE_WALL_BANNER,

    /**
     * Orange Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:orange_wool
     */
    ORANGE_WOOL,

    /**
     * Oxeye Daisy
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oxeye_daisy
     */
    OXEYE_DAISY,

    /**
     * Oxidized Chiseled Copper
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:oxidized_chiseled_copper
     */
    OXIDIZED_CHISELED_COPPER,

    /**
     * Oxidized Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oxidized_copper
     */
    OXIDIZED_COPPER,

    /**
     * Oxidized Copper Bars
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:oxidized_copper_bars
     */
    OXIDIZED_COPPER_BARS,

    /**
     * Oxidized Copper Bulb
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:oxidized_copper_bulb
     */
    OXIDIZED_COPPER_BULB,

    /**
     * Oxidized Copper Chain
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:oxidized_copper_chain
     */
    OXIDIZED_COPPER_CHAIN,

    /**
     * Oxidized Copper Chest
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:oxidized_copper_chest
     */
    OXIDIZED_COPPER_CHEST,

    /**
     * Oxidized Copper Door
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:oxidized_copper_door
     */
    OXIDIZED_COPPER_DOOR,

    /**
     * Oxidized Copper Golem Statue
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:oxidized_copper_golem_statue
     */
    OXIDIZED_COPPER_GOLEM_STATUE,

    /**
     * Oxidized Copper Grate
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:oxidized_copper_grate
     */
    OXIDIZED_COPPER_GRATE,

    /**
     * Oxidized Copper Lantern
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:oxidized_copper_lantern
     */
    OXIDIZED_COPPER_LANTERN,

    /**
     * Oxidized Copper Trapdoor
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:oxidized_copper_trapdoor
     */
    OXIDIZED_COPPER_TRAPDOOR,

    /**
     * Oxidized Cut Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oxidized_cut_copper
     */
    OXIDIZED_CUT_COPPER,

    /**
     * Oxidized Cut Copper Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oxidized_cut_copper_slab
     */
    OXIDIZED_CUT_COPPER_SLAB,

    /**
     * Oxidized Cut Copper Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:oxidized_cut_copper_stairs
     */
    OXIDIZED_CUT_COPPER_STAIRS,

    /**
     * Oxidized Lightning Rod
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:oxidized_lightning_rod
     */
    OXIDIZED_LIGHTNING_ROD,

    /**
     * Packed Ice
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:packed_ice
     */
    PACKED_ICE,

    /**
     * Packed Mud
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:packed_mud
     */
    PACKED_MUD,

    /**
     * Pale Hanging Moss
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_hanging_moss
     */
    PALE_HANGING_MOSS,

    /**
     * Pale Moss Block
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_moss_block
     */
    PALE_MOSS_BLOCK,

    /**
     * Pale Moss Carpet
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_moss_carpet
     */
    PALE_MOSS_CARPET,

    /**
     * Pale Oak Button
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_button
     */
    PALE_OAK_BUTTON,

    /**
     * Pale Oak Door
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_door
     */
    PALE_OAK_DOOR,

    /**
     * Pale Oak Fence
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_fence
     */
    PALE_OAK_FENCE,

    /**
     * Pale Oak Fence Gate
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_fence_gate
     */
    PALE_OAK_FENCE_GATE,

    /**
     * Pale Oak Hanging Sign
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_hanging_sign
     */
    PALE_OAK_HANGING_SIGN,

    /**
     * Pale Oak Leaves
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_leaves
     */
    PALE_OAK_LEAVES,

    /**
     * Pale Oak Log
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_log
     */
    PALE_OAK_LOG,

    /**
     * Pale Oak Planks
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_planks
     */
    PALE_OAK_PLANKS,

    /**
     * Pale Oak Pressure Plate
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_pressure_plate
     */
    PALE_OAK_PRESSURE_PLATE,

    /**
     * Pale Oak Sapling
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_sapling
     */
    PALE_OAK_SAPLING,

    /**
     * Pale Oak Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_shelf
     */
    PALE_OAK_SHELF,

    /**
     * Pale Oak Sign
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_sign
     */
    PALE_OAK_SIGN,

    /**
     * Pale Oak Slab
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_slab
     */
    PALE_OAK_SLAB,

    /**
     * Pale Oak Stairs
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_stairs
     */
    PALE_OAK_STAIRS,

    /**
     * Pale Oak Trapdoor
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_trapdoor
     */
    PALE_OAK_TRAPDOOR,

    /**
     * Pale Oak Wall Hanging Sign
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_wall_hanging_sign
     */
    PALE_OAK_WALL_HANGING_SIGN,

    /**
     * Pale Oak Wall Sign
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_wall_sign
     */
    PALE_OAK_WALL_SIGN,

    /**
     * Pale Oak Wood
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_wood
     */
    PALE_OAK_WOOD,

    /**
     * Pearlescent Froglight
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:pearlescent_froglight
     */
    PEARLESCENT_FROGLIGHT,

    /**
     * Peony
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:peony
     */
    PEONY,

    /**
     * Petrified Oak Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:petrified_oak_slab
     */
    PETRIFIED_OAK_SLAB,

    /**
     * Piglin Head
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:piglin_head
     */
    PIGLIN_HEAD,

    /**
     * Piglin Wall Head
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:piglin_wall_head
     */
    PIGLIN_WALL_HEAD,

    /**
     * Pink Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_banner
     */
    PINK_BANNER,

    /**
     * Pink Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_bed
     */
    PINK_BED,

    /**
     * Pink Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_candle
     */
    PINK_CANDLE,

    /**
     * Pink Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_candle_cake
     */
    PINK_CANDLE_CAKE,

    /**
     * Pink Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_carpet
     */
    PINK_CARPET,

    /**
     * Pink Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_concrete
     */
    PINK_CONCRETE,

    /**
     * Pink Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_concrete_powder
     */
    PINK_CONCRETE_POWDER,

    /**
     * Pink Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_glazed_terracotta
     */
    PINK_GLAZED_TERRACOTTA,

    /**
     * Pink Petals
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:pink_petals
     */
    PINK_PETALS,

    /**
     * Pink Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_shulker_box
     */
    PINK_SHULKER_BOX,

    /**
     * Pink Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_stained_glass
     */
    PINK_STAINED_GLASS,

    /**
     * Pink Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_stained_glass_pane
     */
    PINK_STAINED_GLASS_PANE,

    /**
     * Pink Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_terracotta
     */
    PINK_TERRACOTTA,

    /**
     * Pink Tulip
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_tulip
     */
    PINK_TULIP,

    /**
     * Pink Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_wall_banner
     */
    PINK_WALL_BANNER,

    /**
     * Pink Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pink_wool
     */
    PINK_WOOL,

    /**
     * Piston
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:piston
     */
    PISTON,

    /**
     * Piston Head
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:piston_head
     */
    PISTON_HEAD,

    /**
     * Pitcher Crop
     * <br> Supported Protocols: 763 - 773 (1.20.0 - 1.21.10)
     * <br> Resource: minecraft:pitcher_crop
     */
    PITCHER_CROP,

    /**
     * Pitcher Plant
     * <br> Supported Protocols: 763 - 773 (1.20.0 - 1.21.10)
     * <br> Resource: minecraft:pitcher_plant
     */
    PITCHER_PLANT,

    /**
     * Player Head
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:player_head
     */
    PLAYER_HEAD,

    /**
     * Player Wall Head
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:player_wall_head
     */
    PLAYER_WALL_HEAD,

    /**
     * Podzol
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:podzol
     */
    PODZOL,

    /**
     * Pointed Dripstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pointed_dripstone
     */
    POINTED_DRIPSTONE,

    /**
     * Polished Andesite
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_andesite
     */
    POLISHED_ANDESITE,

    /**
     * Polished Andesite Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_andesite_slab
     */
    POLISHED_ANDESITE_SLAB,

    /**
     * Polished Andesite Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_andesite_stairs
     */
    POLISHED_ANDESITE_STAIRS,

    /**
     * Polished Basalt
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_basalt
     */
    POLISHED_BASALT,

    /**
     * Polished Blackstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_blackstone
     */
    POLISHED_BLACKSTONE,

    /**
     * Polished Blackstone Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_blackstone_bricks
     */
    POLISHED_BLACKSTONE_BRICKS,

    /**
     * Polished Blackstone Brick Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_blackstone_brick_slab
     */
    POLISHED_BLACKSTONE_BRICK_SLAB,

    /**
     * Polished Blackstone Brick Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_blackstone_brick_stairs
     */
    POLISHED_BLACKSTONE_BRICK_STAIRS,

    /**
     * Polished Blackstone Brick Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_blackstone_brick_wall
     */
    POLISHED_BLACKSTONE_BRICK_WALL,

    /**
     * Polished Blackstone Button
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_blackstone_button
     */
    POLISHED_BLACKSTONE_BUTTON,

    /**
     * Polished Blackstone Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_blackstone_pressure_plate
     */
    POLISHED_BLACKSTONE_PRESSURE_PLATE,

    /**
     * Polished Blackstone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_blackstone_slab
     */
    POLISHED_BLACKSTONE_SLAB,

    /**
     * Polished Blackstone Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_blackstone_stairs
     */
    POLISHED_BLACKSTONE_STAIRS,

    /**
     * Polished Blackstone Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_blackstone_wall
     */
    POLISHED_BLACKSTONE_WALL,

    /**
     * Polished Deepslate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_deepslate
     */
    POLISHED_DEEPSLATE,

    /**
     * Polished Deepslate Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_deepslate_slab
     */
    POLISHED_DEEPSLATE_SLAB,

    /**
     * Polished Deepslate Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_deepslate_stairs
     */
    POLISHED_DEEPSLATE_STAIRS,

    /**
     * Polished Deepslate Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_deepslate_wall
     */
    POLISHED_DEEPSLATE_WALL,

    /**
     * Polished Diorite
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_diorite
     */
    POLISHED_DIORITE,

    /**
     * Polished Diorite Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_diorite_slab
     */
    POLISHED_DIORITE_SLAB,

    /**
     * Polished Diorite Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_diorite_stairs
     */
    POLISHED_DIORITE_STAIRS,

    /**
     * Polished Granite
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_granite
     */
    POLISHED_GRANITE,

    /**
     * Polished Granite Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_granite_slab
     */
    POLISHED_GRANITE_SLAB,

    /**
     * Polished Granite Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polished_granite_stairs
     */
    POLISHED_GRANITE_STAIRS,

    /**
     * Polished Tuff
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:polished_tuff
     */
    POLISHED_TUFF,

    /**
     * Polished Tuff Slab
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:polished_tuff_slab
     */
    POLISHED_TUFF_SLAB,

    /**
     * Polished Tuff Stairs
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:polished_tuff_stairs
     */
    POLISHED_TUFF_STAIRS,

    /**
     * Polished Tuff Wall
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:polished_tuff_wall
     */
    POLISHED_TUFF_WALL,

    /**
     * Poppy
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:poppy
     */
    POPPY,

    /**
     * Potatoes
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potatoes
     */
    POTATOES,

    /**
     * Potted Acacia Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_acacia_sapling
     */
    POTTED_ACACIA_SAPLING,

    /**
     * Potted Allium
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_allium
     */
    POTTED_ALLIUM,

    /**
     * Potted Azalea Bush
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_azalea_bush
     */
    POTTED_AZALEA_BUSH,

    /**
     * Potted Azure Bluet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_azure_bluet
     */
    POTTED_AZURE_BLUET,

    /**
     * Potted Bamboo
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_bamboo
     */
    POTTED_BAMBOO,

    /**
     * Potted Birch Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_birch_sapling
     */
    POTTED_BIRCH_SAPLING,

    /**
     * Potted Blue Orchid
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_blue_orchid
     */
    POTTED_BLUE_ORCHID,

    /**
     * Potted Brown Mushroom
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_brown_mushroom
     */
    POTTED_BROWN_MUSHROOM,

    /**
     * Potted Cactus
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_cactus
     */
    POTTED_CACTUS,

    /**
     * Potted Cherry Sapling
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:potted_cherry_sapling
     */
    POTTED_CHERRY_SAPLING,

    /**
     * Potted Closed Eyeblossom
     * <br> Supported Protocols: 769 - 773 (1.21.4 - 1.21.10)
     * <br> Resource: minecraft:potted_closed_eyeblossom
     */
    POTTED_CLOSED_EYEBLOSSOM,

    /**
     * Potted Cornflower
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_cornflower
     */
    POTTED_CORNFLOWER,

    /**
     * Potted Crimson Fungus
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_crimson_fungus
     */
    POTTED_CRIMSON_FUNGUS,

    /**
     * Potted Crimson Roots
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_crimson_roots
     */
    POTTED_CRIMSON_ROOTS,

    /**
     * Potted Dandelion
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_dandelion
     */
    POTTED_DANDELION,

    /**
     * Potted Dark Oak Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_dark_oak_sapling
     */
    POTTED_DARK_OAK_SAPLING,

    /**
     * Potted Dead Bush
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_dead_bush
     */
    POTTED_DEAD_BUSH,

    /**
     * Potted Fern
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_fern
     */
    POTTED_FERN,

    /**
     * Potted Flowering Azalea Bush
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_flowering_azalea_bush
     */
    POTTED_FLOWERING_AZALEA_BUSH,

    /**
     * Potted Jungle Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_jungle_sapling
     */
    POTTED_JUNGLE_SAPLING,

    /**
     * Potted Lily Of The Valley
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_lily_of_the_valley
     */
    POTTED_LILY_OF_THE_VALLEY,

    /**
     * Potted Mangrove Propagule
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:potted_mangrove_propagule
     */
    POTTED_MANGROVE_PROPAGULE,

    /**
     * Potted Oak Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_oak_sapling
     */
    POTTED_OAK_SAPLING,

    /**
     * Potted Open Eyeblossom
     * <br> Supported Protocols: 769 - 773 (1.21.4 - 1.21.10)
     * <br> Resource: minecraft:potted_open_eyeblossom
     */
    POTTED_OPEN_EYEBLOSSOM,

    /**
     * Potted Orange Tulip
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_orange_tulip
     */
    POTTED_ORANGE_TULIP,

    /**
     * Potted Oxeye Daisy
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_oxeye_daisy
     */
    POTTED_OXEYE_DAISY,

    /**
     * Potted Pale Oak Sapling
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:potted_pale_oak_sapling
     */
    POTTED_PALE_OAK_SAPLING,

    /**
     * Potted Pink Tulip
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_pink_tulip
     */
    POTTED_PINK_TULIP,

    /**
     * Potted Poppy
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_poppy
     */
    POTTED_POPPY,

    /**
     * Potted Red Mushroom
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_red_mushroom
     */
    POTTED_RED_MUSHROOM,

    /**
     * Potted Red Tulip
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_red_tulip
     */
    POTTED_RED_TULIP,

    /**
     * Potted Spruce Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_spruce_sapling
     */
    POTTED_SPRUCE_SAPLING,

    /**
     * Potted Torchflower
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:potted_torchflower
     */
    POTTED_TORCHFLOWER,

    /**
     * Potted Warped Fungus
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_warped_fungus
     */
    POTTED_WARPED_FUNGUS,

    /**
     * Potted Warped Roots
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_warped_roots
     */
    POTTED_WARPED_ROOTS,

    /**
     * Potted White Tulip
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_white_tulip
     */
    POTTED_WHITE_TULIP,

    /**
     * Potted Wither Rose
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:potted_wither_rose
     */
    POTTED_WITHER_ROSE,

    /**
     * Powder Snow
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:powder_snow
     */
    POWDER_SNOW,

    /**
     * Powder Snow Cauldron
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:powder_snow_cauldron
     */
    POWDER_SNOW_CAULDRON,

    /**
     * Powered Rail
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:powered_rail
     */
    POWERED_RAIL,

    /**
     * Prismarine
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:prismarine
     */
    PRISMARINE,

    /**
     * Prismarine Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:prismarine_bricks
     */
    PRISMARINE_BRICKS,

    /**
     * Prismarine Brick Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:prismarine_brick_slab
     */
    PRISMARINE_BRICK_SLAB,

    /**
     * Prismarine Brick Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:prismarine_brick_stairs
     */
    PRISMARINE_BRICK_STAIRS,

    /**
     * Prismarine Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:prismarine_slab
     */
    PRISMARINE_SLAB,

    /**
     * Prismarine Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:prismarine_stairs
     */
    PRISMARINE_STAIRS,

    /**
     * Prismarine Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:prismarine_wall
     */
    PRISMARINE_WALL,

    /**
     * Pumpkin
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pumpkin
     */
    PUMPKIN,

    /**
     * Pumpkin Stem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pumpkin_stem
     */
    PUMPKIN_STEM,

    /**
     * Purple Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_banner
     */
    PURPLE_BANNER,

    /**
     * Purple Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_bed
     */
    PURPLE_BED,

    /**
     * Purple Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_candle
     */
    PURPLE_CANDLE,

    /**
     * Purple Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_candle_cake
     */
    PURPLE_CANDLE_CAKE,

    /**
     * Purple Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_carpet
     */
    PURPLE_CARPET,

    /**
     * Purple Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_concrete
     */
    PURPLE_CONCRETE,

    /**
     * Purple Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_concrete_powder
     */
    PURPLE_CONCRETE_POWDER,

    /**
     * Purple Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_glazed_terracotta
     */
    PURPLE_GLAZED_TERRACOTTA,

    /**
     * Purple Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_shulker_box
     */
    PURPLE_SHULKER_BOX,

    /**
     * Purple Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_stained_glass
     */
    PURPLE_STAINED_GLASS,

    /**
     * Purple Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_stained_glass_pane
     */
    PURPLE_STAINED_GLASS_PANE,

    /**
     * Purple Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_terracotta
     */
    PURPLE_TERRACOTTA,

    /**
     * Purple Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_wall_banner
     */
    PURPLE_WALL_BANNER,

    /**
     * Purple Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purple_wool
     */
    PURPLE_WOOL,

    /**
     * Purpur Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purpur_block
     */
    PURPUR_BLOCK,

    /**
     * Purpur Pillar
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purpur_pillar
     */
    PURPUR_PILLAR,

    /**
     * Purpur Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purpur_slab
     */
    PURPUR_SLAB,

    /**
     * Purpur Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:purpur_stairs
     */
    PURPUR_STAIRS,

    /**
     * Quartz Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:quartz_block
     */
    QUARTZ_BLOCK,

    /**
     * Quartz Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:quartz_bricks
     */
    QUARTZ_BRICKS,

    /**
     * Quartz Pillar
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:quartz_pillar
     */
    QUARTZ_PILLAR,

    /**
     * Quartz Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:quartz_slab
     */
    QUARTZ_SLAB,

    /**
     * Quartz Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:quartz_stairs
     */
    QUARTZ_STAIRS,

    /**
     * Rail
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:rail
     */
    RAIL,

    /**
     * Raw Copper Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:raw_copper_block
     */
    RAW_COPPER_BLOCK,

    /**
     * Raw Gold Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:raw_gold_block
     */
    RAW_GOLD_BLOCK,

    /**
     * Raw Iron Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:raw_iron_block
     */
    RAW_IRON_BLOCK,

    /**
     * Redstone Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:redstone_block
     */
    REDSTONE_BLOCK,

    /**
     * Redstone Lamp
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:redstone_lamp
     */
    REDSTONE_LAMP,

    /**
     * Redstone Ore
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:redstone_ore
     */
    REDSTONE_ORE,

    /**
     * Redstone Torch
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:redstone_torch
     */
    REDSTONE_TORCH,

    /**
     * Redstone Wall Torch
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:redstone_wall_torch
     */
    REDSTONE_WALL_TORCH,

    /**
     * Redstone Wire
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:redstone_wire
     */
    REDSTONE_WIRE,

    /**
     * Red Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_banner
     */
    RED_BANNER,

    /**
     * Red Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_bed
     */
    RED_BED,

    /**
     * Red Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_candle
     */
    RED_CANDLE,

    /**
     * Red Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_candle_cake
     */
    RED_CANDLE_CAKE,

    /**
     * Red Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_carpet
     */
    RED_CARPET,

    /**
     * Red Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_concrete
     */
    RED_CONCRETE,

    /**
     * Red Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_concrete_powder
     */
    RED_CONCRETE_POWDER,

    /**
     * Red Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_glazed_terracotta
     */
    RED_GLAZED_TERRACOTTA,

    /**
     * Red Mushroom
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_mushroom
     */
    RED_MUSHROOM,

    /**
     * Red Mushroom Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_mushroom_block
     */
    RED_MUSHROOM_BLOCK,

    /**
     * Red Nether Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_nether_bricks
     */
    RED_NETHER_BRICKS,

    /**
     * Red Nether Brick Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_nether_brick_slab
     */
    RED_NETHER_BRICK_SLAB,

    /**
     * Red Nether Brick Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_nether_brick_stairs
     */
    RED_NETHER_BRICK_STAIRS,

    /**
     * Red Nether Brick Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_nether_brick_wall
     */
    RED_NETHER_BRICK_WALL,

    /**
     * Red Sand
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_sand
     */
    RED_SAND,

    /**
     * Red Sandstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_sandstone
     */
    RED_SANDSTONE,

    /**
     * Red Sandstone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_sandstone_slab
     */
    RED_SANDSTONE_SLAB,

    /**
     * Red Sandstone Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_sandstone_stairs
     */
    RED_SANDSTONE_STAIRS,

    /**
     * Red Sandstone Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_sandstone_wall
     */
    RED_SANDSTONE_WALL,

    /**
     * Red Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_shulker_box
     */
    RED_SHULKER_BOX,

    /**
     * Red Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_stained_glass
     */
    RED_STAINED_GLASS,

    /**
     * Red Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_stained_glass_pane
     */
    RED_STAINED_GLASS_PANE,

    /**
     * Red Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_terracotta
     */
    RED_TERRACOTTA,

    /**
     * Red Tulip
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_tulip
     */
    RED_TULIP,

    /**
     * Red Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_wall_banner
     */
    RED_WALL_BANNER,

    /**
     * Red Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:red_wool
     */
    RED_WOOL,

    /**
     * Reinforced Deepslate
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:reinforced_deepslate
     */
    REINFORCED_DEEPSLATE,

    /**
     * Repeater
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:repeater
     */
    REPEATER,

    /**
     * Repeating Command Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:repeating_command_block
     */
    REPEATING_COMMAND_BLOCK,

    /**
     * Resin Block
     * <br> Supported Protocols: 769 - 773 (1.21.4 - 1.21.10)
     * <br> Resource: minecraft:resin_block
     */
    RESIN_BLOCK,

    /**
     * Resin Bricks
     * <br> Supported Protocols: 769 - 773 (1.21.4 - 1.21.10)
     * <br> Resource: minecraft:resin_bricks
     */
    RESIN_BRICKS,

    /**
     * Resin Brick Slab
     * <br> Supported Protocols: 769 - 773 (1.21.4 - 1.21.10)
     * <br> Resource: minecraft:resin_brick_slab
     */
    RESIN_BRICK_SLAB,

    /**
     * Resin Brick Stairs
     * <br> Supported Protocols: 769 - 773 (1.21.4 - 1.21.10)
     * <br> Resource: minecraft:resin_brick_stairs
     */
    RESIN_BRICK_STAIRS,

    /**
     * Resin Brick Wall
     * <br> Supported Protocols: 769 - 773 (1.21.4 - 1.21.10)
     * <br> Resource: minecraft:resin_brick_wall
     */
    RESIN_BRICK_WALL,

    /**
     * Resin Clump
     * <br> Supported Protocols: 769 - 773 (1.21.4 - 1.21.10)
     * <br> Resource: minecraft:resin_clump
     */
    RESIN_CLUMP,

    /**
     * Respawn Anchor
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:respawn_anchor
     */
    RESPAWN_ANCHOR,

    /**
     * Rooted Dirt
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:rooted_dirt
     */
    ROOTED_DIRT,

    /**
     * Rose Bush
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:rose_bush
     */
    ROSE_BUSH,

    /**
     * Sand
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sand
     */
    SAND,

    /**
     * Sandstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sandstone
     */
    SANDSTONE,

    /**
     * Sandstone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sandstone_slab
     */
    SANDSTONE_SLAB,

    /**
     * Sandstone Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sandstone_stairs
     */
    SANDSTONE_STAIRS,

    /**
     * Sandstone Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sandstone_wall
     */
    SANDSTONE_WALL,

    /**
     * Scaffolding
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:scaffolding
     */
    SCAFFOLDING,

    /**
     * Sculk
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:sculk
     */
    SCULK,

    /**
     * Sculk Catalyst
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:sculk_catalyst
     */
    SCULK_CATALYST,

    /**
     * Sculk Sensor
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sculk_sensor
     */
    SCULK_SENSOR,

    /**
     * Sculk Shrieker
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:sculk_shrieker
     */
    SCULK_SHRIEKER,

    /**
     * Sculk Vein
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:sculk_vein
     */
    SCULK_VEIN,

    /**
     * Seagrass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:seagrass
     */
    SEAGRASS,

    /**
     * Sea Lantern
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sea_lantern
     */
    SEA_LANTERN,

    /**
     * Sea Pickle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sea_pickle
     */
    SEA_PICKLE,

    /**
     * Short Dry Grass
     * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
     * <br> Resource: minecraft:short_dry_grass
     */
    SHORT_DRY_GRASS,

    /**
     * Short Grass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resources: minecraft:grass (755 - 764 (1.17.0 - 1.20.2)), minecraft:short_grass (765 - 773 (1.20.3 - 1.21.10))
     */
    SHORT_GRASS,

    /**
     * Shroomlight
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:shroomlight
     */
    SHROOMLIGHT,

    /**
     * Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:shulker_box
     */
    SHULKER_BOX,

    /**
     * Skeleton Skull
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:skeleton_skull
     */
    SKELETON_SKULL,

    /**
     * Skeleton Wall Skull
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:skeleton_wall_skull
     */
    SKELETON_WALL_SKULL,

    /**
     * Slime Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:slime_block
     */
    SLIME_BLOCK,

    /**
     * Small Amethyst Bud
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:small_amethyst_bud
     */
    SMALL_AMETHYST_BUD,

    /**
     * Small Dripleaf
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:small_dripleaf
     */
    SMALL_DRIPLEAF,

    /**
     * Smithing Table
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smithing_table
     */
    SMITHING_TABLE,

    /**
     * Smoker
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smoker
     */
    SMOKER,

    /**
     * Smooth Basalt
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_basalt
     */
    SMOOTH_BASALT,

    /**
     * Smooth Quartz
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_quartz
     */
    SMOOTH_QUARTZ,

    /**
     * Smooth Quartz Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_quartz_slab
     */
    SMOOTH_QUARTZ_SLAB,

    /**
     * Smooth Quartz Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_quartz_stairs
     */
    SMOOTH_QUARTZ_STAIRS,

    /**
     * Smooth Red Sandstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_red_sandstone
     */
    SMOOTH_RED_SANDSTONE,

    /**
     * Smooth Red Sandstone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_red_sandstone_slab
     */
    SMOOTH_RED_SANDSTONE_SLAB,

    /**
     * Smooth Red Sandstone Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_red_sandstone_stairs
     */
    SMOOTH_RED_SANDSTONE_STAIRS,

    /**
     * Smooth Sandstone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_sandstone
     */
    SMOOTH_SANDSTONE,

    /**
     * Smooth Sandstone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_sandstone_slab
     */
    SMOOTH_SANDSTONE_SLAB,

    /**
     * Smooth Sandstone Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_sandstone_stairs
     */
    SMOOTH_SANDSTONE_STAIRS,

    /**
     * Smooth Stone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_stone
     */
    SMOOTH_STONE,

    /**
     * Smooth Stone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:smooth_stone_slab
     */
    SMOOTH_STONE_SLAB,

    /**
     * Sniffer Egg
     * <br> Supported Protocols: 763 - 773 (1.20.0 - 1.21.10)
     * <br> Resource: minecraft:sniffer_egg
     */
    SNIFFER_EGG,

    /**
     * Snow
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:snow
     */
    SNOW,

    /**
     * Snow Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:snow_block
     */
    SNOW_BLOCK,

    /**
     * Soul Campfire
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:soul_campfire
     */
    SOUL_CAMPFIRE,

    /**
     * Soul Fire
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:soul_fire
     */
    SOUL_FIRE,

    /**
     * Soul Lantern
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:soul_lantern
     */
    SOUL_LANTERN,

    /**
     * Soul Sand
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:soul_sand
     */
    SOUL_SAND,

    /**
     * Soul Soil
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:soul_soil
     */
    SOUL_SOIL,

    /**
     * Soul Torch
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:soul_torch
     */
    SOUL_TORCH,

    /**
     * Soul Wall Torch
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:soul_wall_torch
     */
    SOUL_WALL_TORCH,

    /**
     * Spawner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spawner
     */
    SPAWNER,

    /**
     * Sponge
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sponge
     */
    SPONGE,

    /**
     * Spore Blossom
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spore_blossom
     */
    SPORE_BLOSSOM,

    /**
     * Spruce Button
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_button
     */
    SPRUCE_BUTTON,

    /**
     * Spruce Door
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_door
     */
    SPRUCE_DOOR,

    /**
     * Spruce Fence
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_fence
     */
    SPRUCE_FENCE,

    /**
     * Spruce Fence Gate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_fence_gate
     */
    SPRUCE_FENCE_GATE,

    /**
     * Spruce Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:spruce_hanging_sign
     */
    SPRUCE_HANGING_SIGN,

    /**
     * Spruce Leaves
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_leaves
     */
    SPRUCE_LEAVES,

    /**
     * Spruce Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_log
     */
    SPRUCE_LOG,

    /**
     * Spruce Planks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_planks
     */
    SPRUCE_PLANKS,

    /**
     * Spruce Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_pressure_plate
     */
    SPRUCE_PRESSURE_PLATE,

    /**
     * Spruce Sapling
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_sapling
     */
    SPRUCE_SAPLING,

    /**
     * Spruce Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:spruce_shelf
     */
    SPRUCE_SHELF,

    /**
     * Spruce Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_sign
     */
    SPRUCE_SIGN,

    /**
     * Spruce Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_slab
     */
    SPRUCE_SLAB,

    /**
     * Spruce Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_stairs
     */
    SPRUCE_STAIRS,

    /**
     * Spruce Trapdoor
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_trapdoor
     */
    SPRUCE_TRAPDOOR,

    /**
     * Spruce Wall Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:spruce_wall_hanging_sign
     */
    SPRUCE_WALL_HANGING_SIGN,

    /**
     * Spruce Wall Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_wall_sign
     */
    SPRUCE_WALL_SIGN,

    /**
     * Spruce Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spruce_wood
     */
    SPRUCE_WOOD,

    /**
     * Sticky Piston
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sticky_piston
     */
    STICKY_PISTON,

    /**
     * Stone
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stone
     */
    STONE,

    /**
     * Stonecutter
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stonecutter
     */
    STONECUTTER,

    /**
     * Stone Bricks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stone_bricks
     */
    STONE_BRICKS,

    /**
     * Stone Brick Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stone_brick_slab
     */
    STONE_BRICK_SLAB,

    /**
     * Stone Brick Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stone_brick_stairs
     */
    STONE_BRICK_STAIRS,

    /**
     * Stone Brick Wall
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stone_brick_wall
     */
    STONE_BRICK_WALL,

    /**
     * Stone Button
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stone_button
     */
    STONE_BUTTON,

    /**
     * Stone Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stone_pressure_plate
     */
    STONE_PRESSURE_PLATE,

    /**
     * Stone Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stone_slab
     */
    STONE_SLAB,

    /**
     * Stone Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stone_stairs
     */
    STONE_STAIRS,

    /**
     * Stripped Acacia Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_acacia_log
     */
    STRIPPED_ACACIA_LOG,

    /**
     * Stripped Acacia Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_acacia_wood
     */
    STRIPPED_ACACIA_WOOD,

    /**
     * Stripped Bamboo Block
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:stripped_bamboo_block
     */
    STRIPPED_BAMBOO_BLOCK,

    /**
     * Stripped Birch Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_birch_log
     */
    STRIPPED_BIRCH_LOG,

    /**
     * Stripped Birch Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_birch_wood
     */
    STRIPPED_BIRCH_WOOD,

    /**
     * Stripped Cherry Log
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:stripped_cherry_log
     */
    STRIPPED_CHERRY_LOG,

    /**
     * Stripped Cherry Wood
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:stripped_cherry_wood
     */
    STRIPPED_CHERRY_WOOD,

    /**
     * Stripped Crimson Hyphae
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_crimson_hyphae
     */
    STRIPPED_CRIMSON_HYPHAE,

    /**
     * Stripped Crimson Stem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_crimson_stem
     */
    STRIPPED_CRIMSON_STEM,

    /**
     * Stripped Dark Oak Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_dark_oak_log
     */
    STRIPPED_DARK_OAK_LOG,

    /**
     * Stripped Dark Oak Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_dark_oak_wood
     */
    STRIPPED_DARK_OAK_WOOD,

    /**
     * Stripped Jungle Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_jungle_log
     */
    STRIPPED_JUNGLE_LOG,

    /**
     * Stripped Jungle Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_jungle_wood
     */
    STRIPPED_JUNGLE_WOOD,

    /**
     * Stripped Mangrove Log
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_mangrove_log
     */
    STRIPPED_MANGROVE_LOG,

    /**
     * Stripped Mangrove Wood
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_mangrove_wood
     */
    STRIPPED_MANGROVE_WOOD,

    /**
     * Stripped Oak Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_oak_log
     */
    STRIPPED_OAK_LOG,

    /**
     * Stripped Oak Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_oak_wood
     */
    STRIPPED_OAK_WOOD,

    /**
     * Stripped Pale Oak Log
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:stripped_pale_oak_log
     */
    STRIPPED_PALE_OAK_LOG,

    /**
     * Stripped Pale Oak Wood
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:stripped_pale_oak_wood
     */
    STRIPPED_PALE_OAK_WOOD,

    /**
     * Stripped Spruce Log
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_spruce_log
     */
    STRIPPED_SPRUCE_LOG,

    /**
     * Stripped Spruce Wood
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_spruce_wood
     */
    STRIPPED_SPRUCE_WOOD,

    /**
     * Stripped Warped Hyphae
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_warped_hyphae
     */
    STRIPPED_WARPED_HYPHAE,

    /**
     * Stripped Warped Stem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stripped_warped_stem
     */
    STRIPPED_WARPED_STEM,

    /**
     * Structure Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:structure_block
     */
    STRUCTURE_BLOCK,

    /**
     * Structure Void
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:structure_void
     */
    STRUCTURE_VOID,

    /**
     * Sugar Cane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sugar_cane
     */
    SUGAR_CANE,

    /**
     * Sunflower
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sunflower
     */
    SUNFLOWER,

    /**
     * Suspicious Gravel
     * <br> Supported Protocols: 763 - 773 (1.20.0 - 1.21.10)
     * <br> Resource: minecraft:suspicious_gravel
     */
    SUSPICIOUS_GRAVEL,

    /**
     * Suspicious Sand
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:suspicious_sand
     */
    SUSPICIOUS_SAND,

    /**
     * Sweet Berry Bush
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sweet_berry_bush
     */
    SWEET_BERRY_BUSH,

    /**
     * Tall Dry Grass
     * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
     * <br> Resource: minecraft:tall_dry_grass
     */
    TALL_DRY_GRASS,

    /**
     * Tall Grass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tall_grass
     */
    TALL_GRASS,

    /**
     * Tall Seagrass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tall_seagrass
     */
    TALL_SEAGRASS,

    /**
     * Target
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:target
     */
    TARGET,

    /**
     * Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:terracotta
     */
    TERRACOTTA,

    /**
     * Test Block
     * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
     * <br> Resource: minecraft:test_block
     */
    TEST_BLOCK,

    /**
     * Test Instance Block
     * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
     * <br> Resource: minecraft:test_instance_block
     */
    TEST_INSTANCE_BLOCK,

    /**
     * Tinted Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tinted_glass
     */
    TINTED_GLASS,

    /**
     * Tnt
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tnt
     */
    TNT,

    /**
     * Torch
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:torch
     */
    TORCH,

    /**
     * Torchflower
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:torchflower
     */
    TORCHFLOWER,

    /**
     * Torchflower Crop
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:torchflower_crop
     */
    TORCHFLOWER_CROP,

    /**
     * Trapped Chest
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:trapped_chest
     */
    TRAPPED_CHEST,

    /**
     * Trial Spawner
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:trial_spawner
     */
    TRIAL_SPAWNER,

    /**
     * Tripwire
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tripwire
     */
    TRIPWIRE,

    /**
     * Tripwire Hook
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tripwire_hook
     */
    TRIPWIRE_HOOK,

    /**
     * Tube Coral
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tube_coral
     */
    TUBE_CORAL,

    /**
     * Tube Coral Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tube_coral_block
     */
    TUBE_CORAL_BLOCK,

    /**
     * Tube Coral Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tube_coral_fan
     */
    TUBE_CORAL_FAN,

    /**
     * Tube Coral Wall Fan
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tube_coral_wall_fan
     */
    TUBE_CORAL_WALL_FAN,

    /**
     * Tuff
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tuff
     */
    TUFF,

    /**
     * Tuff Bricks
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:tuff_bricks
     */
    TUFF_BRICKS,

    /**
     * Tuff Brick Slab
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:tuff_brick_slab
     */
    TUFF_BRICK_SLAB,

    /**
     * Tuff Brick Stairs
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:tuff_brick_stairs
     */
    TUFF_BRICK_STAIRS,

    /**
     * Tuff Brick Wall
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:tuff_brick_wall
     */
    TUFF_BRICK_WALL,

    /**
     * Tuff Slab
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:tuff_slab
     */
    TUFF_SLAB,

    /**
     * Tuff Stairs
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:tuff_stairs
     */
    TUFF_STAIRS,

    /**
     * Tuff Wall
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:tuff_wall
     */
    TUFF_WALL,

    /**
     * Turtle Egg
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:turtle_egg
     */
    TURTLE_EGG,

    /**
     * Twisting Vines
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:twisting_vines
     */
    TWISTING_VINES,

    /**
     * Twisting Vines Plant
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:twisting_vines_plant
     */
    TWISTING_VINES_PLANT,

    /**
     * Vault
     * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
     * <br> Resource: minecraft:vault
     */
    VAULT,

    /**
     * Verdant Froglight
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:verdant_froglight
     */
    VERDANT_FROGLIGHT,

    /**
     * Vine
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:vine
     */
    VINE,

    /**
     * Void Air
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:void_air
     */
    VOID_AIR,

    /**
     * Wall Torch
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:wall_torch
     */
    WALL_TORCH,

    /**
     * Warped Button
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_button
     */
    WARPED_BUTTON,

    /**
     * Warped Door
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_door
     */
    WARPED_DOOR,

    /**
     * Warped Fence
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_fence
     */
    WARPED_FENCE,

    /**
     * Warped Fence Gate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_fence_gate
     */
    WARPED_FENCE_GATE,

    /**
     * Warped Fungus
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_fungus
     */
    WARPED_FUNGUS,

    /**
     * Warped Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:warped_hanging_sign
     */
    WARPED_HANGING_SIGN,

    /**
     * Warped Hyphae
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_hyphae
     */
    WARPED_HYPHAE,

    /**
     * Warped Nylium
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_nylium
     */
    WARPED_NYLIUM,

    /**
     * Warped Planks
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_planks
     */
    WARPED_PLANKS,

    /**
     * Warped Pressure Plate
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_pressure_plate
     */
    WARPED_PRESSURE_PLATE,

    /**
     * Warped Roots
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_roots
     */
    WARPED_ROOTS,

    /**
     * Warped Shelf
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:warped_shelf
     */
    WARPED_SHELF,

    /**
     * Warped Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_sign
     */
    WARPED_SIGN,

    /**
     * Warped Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_slab
     */
    WARPED_SLAB,

    /**
     * Warped Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_stairs
     */
    WARPED_STAIRS,

    /**
     * Warped Stem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_stem
     */
    WARPED_STEM,

    /**
     * Warped Trapdoor
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_trapdoor
     */
    WARPED_TRAPDOOR,

    /**
     * Warped Wall Hanging Sign
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:warped_wall_hanging_sign
     */
    WARPED_WALL_HANGING_SIGN,

    /**
     * Warped Wall Sign
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_wall_sign
     */
    WARPED_WALL_SIGN,

    /**
     * Warped Wart Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:warped_wart_block
     */
    WARPED_WART_BLOCK,

    /**
     * Water
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:water
     */
    WATER,

    /**
     * Water Cauldron
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:water_cauldron
     */
    WATER_CAULDRON,

    /**
     * Waxed Chiseled Copper
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_chiseled_copper
     */
    WAXED_CHISELED_COPPER,

    /**
     * Waxed Copper Bars
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_copper_bars
     */
    WAXED_COPPER_BARS,

    /**
     * Waxed Copper Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_copper_block
     */
    WAXED_COPPER_BLOCK,

    /**
     * Waxed Copper Bulb
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_copper_bulb
     */
    WAXED_COPPER_BULB,

    /**
     * Waxed Copper Chain
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_copper_chain
     */
    WAXED_COPPER_CHAIN,

    /**
     * Waxed Copper Chest
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_copper_chest
     */
    WAXED_COPPER_CHEST,

    /**
     * Waxed Copper Door
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_copper_door
     */
    WAXED_COPPER_DOOR,

    /**
     * Waxed Copper Golem Statue
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_copper_golem_statue
     */
    WAXED_COPPER_GOLEM_STATUE,

    /**
     * Waxed Copper Grate
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_copper_grate
     */
    WAXED_COPPER_GRATE,

    /**
     * Waxed Copper Lantern
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_copper_lantern
     */
    WAXED_COPPER_LANTERN,

    /**
     * Waxed Copper Trapdoor
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_copper_trapdoor
     */
    WAXED_COPPER_TRAPDOOR,

    /**
     * Waxed Cut Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_cut_copper
     */
    WAXED_CUT_COPPER,

    /**
     * Waxed Cut Copper Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_cut_copper_slab
     */
    WAXED_CUT_COPPER_SLAB,

    /**
     * Waxed Cut Copper Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_cut_copper_stairs
     */
    WAXED_CUT_COPPER_STAIRS,

    /**
     * Waxed Exposed Chiseled Copper
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_chiseled_copper
     */
    WAXED_EXPOSED_CHISELED_COPPER,

    /**
     * Waxed Exposed Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_copper
     */
    WAXED_EXPOSED_COPPER,

    /**
     * Waxed Exposed Copper Bars
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_copper_bars
     */
    WAXED_EXPOSED_COPPER_BARS,

    /**
     * Waxed Exposed Copper Bulb
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_copper_bulb
     */
    WAXED_EXPOSED_COPPER_BULB,

    /**
     * Waxed Exposed Copper Chain
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_copper_chain
     */
    WAXED_EXPOSED_COPPER_CHAIN,

    /**
     * Waxed Exposed Copper Chest
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_copper_chest
     */
    WAXED_EXPOSED_COPPER_CHEST,

    /**
     * Waxed Exposed Copper Door
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_copper_door
     */
    WAXED_EXPOSED_COPPER_DOOR,

    /**
     * Waxed Exposed Copper Golem Statue
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_copper_golem_statue
     */
    WAXED_EXPOSED_COPPER_GOLEM_STATUE,

    /**
     * Waxed Exposed Copper Grate
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_copper_grate
     */
    WAXED_EXPOSED_COPPER_GRATE,

    /**
     * Waxed Exposed Copper Lantern
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_copper_lantern
     */
    WAXED_EXPOSED_COPPER_LANTERN,

    /**
     * Waxed Exposed Copper Trapdoor
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_copper_trapdoor
     */
    WAXED_EXPOSED_COPPER_TRAPDOOR,

    /**
     * Waxed Exposed Cut Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_cut_copper
     */
    WAXED_EXPOSED_CUT_COPPER,

    /**
     * Waxed Exposed Cut Copper Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_cut_copper_slab
     */
    WAXED_EXPOSED_CUT_COPPER_SLAB,

    /**
     * Waxed Exposed Cut Copper Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_cut_copper_stairs
     */
    WAXED_EXPOSED_CUT_COPPER_STAIRS,

    /**
     * Waxed Exposed Lightning Rod
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_exposed_lightning_rod
     */
    WAXED_EXPOSED_LIGHTNING_ROD,

    /**
     * Waxed Lightning Rod
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_lightning_rod
     */
    WAXED_LIGHTNING_ROD,

    /**
     * Waxed Oxidized Chiseled Copper
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_chiseled_copper
     */
    WAXED_OXIDIZED_CHISELED_COPPER,

    /**
     * Waxed Oxidized Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_copper
     */
    WAXED_OXIDIZED_COPPER,

    /**
     * Waxed Oxidized Copper Bars
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_copper_bars
     */
    WAXED_OXIDIZED_COPPER_BARS,

    /**
     * Waxed Oxidized Copper Bulb
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_copper_bulb
     */
    WAXED_OXIDIZED_COPPER_BULB,

    /**
     * Waxed Oxidized Copper Chain
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_copper_chain
     */
    WAXED_OXIDIZED_COPPER_CHAIN,

    /**
     * Waxed Oxidized Copper Chest
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_copper_chest
     */
    WAXED_OXIDIZED_COPPER_CHEST,

    /**
     * Waxed Oxidized Copper Door
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_copper_door
     */
    WAXED_OXIDIZED_COPPER_DOOR,

    /**
     * Waxed Oxidized Copper Golem Statue
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_copper_golem_statue
     */
    WAXED_OXIDIZED_COPPER_GOLEM_STATUE,

    /**
     * Waxed Oxidized Copper Grate
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_copper_grate
     */
    WAXED_OXIDIZED_COPPER_GRATE,

    /**
     * Waxed Oxidized Copper Lantern
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_copper_lantern
     */
    WAXED_OXIDIZED_COPPER_LANTERN,

    /**
     * Waxed Oxidized Copper Trapdoor
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_copper_trapdoor
     */
    WAXED_OXIDIZED_COPPER_TRAPDOOR,

    /**
     * Waxed Oxidized Cut Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_cut_copper
     */
    WAXED_OXIDIZED_CUT_COPPER,

    /**
     * Waxed Oxidized Cut Copper Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_cut_copper_slab
     */
    WAXED_OXIDIZED_CUT_COPPER_SLAB,

    /**
     * Waxed Oxidized Cut Copper Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_cut_copper_stairs
     */
    WAXED_OXIDIZED_CUT_COPPER_STAIRS,

    /**
     * Waxed Oxidized Lightning Rod
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_oxidized_lightning_rod
     */
    WAXED_OXIDIZED_LIGHTNING_ROD,

    /**
     * Waxed Weathered Chiseled Copper
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_chiseled_copper
     */
    WAXED_WEATHERED_CHISELED_COPPER,

    /**
     * Waxed Weathered Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_copper
     */
    WAXED_WEATHERED_COPPER,

    /**
     * Waxed Weathered Copper Bars
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_copper_bars
     */
    WAXED_WEATHERED_COPPER_BARS,

    /**
     * Waxed Weathered Copper Bulb
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_copper_bulb
     */
    WAXED_WEATHERED_COPPER_BULB,

    /**
     * Waxed Weathered Copper Chain
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_copper_chain
     */
    WAXED_WEATHERED_COPPER_CHAIN,

    /**
     * Waxed Weathered Copper Chest
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_copper_chest
     */
    WAXED_WEATHERED_COPPER_CHEST,

    /**
     * Waxed Weathered Copper Door
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_copper_door
     */
    WAXED_WEATHERED_COPPER_DOOR,

    /**
     * Waxed Weathered Copper Golem Statue
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_copper_golem_statue
     */
    WAXED_WEATHERED_COPPER_GOLEM_STATUE,

    /**
     * Waxed Weathered Copper Grate
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_copper_grate
     */
    WAXED_WEATHERED_COPPER_GRATE,

    /**
     * Waxed Weathered Copper Lantern
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_copper_lantern
     */
    WAXED_WEATHERED_COPPER_LANTERN,

    /**
     * Waxed Weathered Copper Trapdoor
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_copper_trapdoor
     */
    WAXED_WEATHERED_COPPER_TRAPDOOR,

    /**
     * Waxed Weathered Cut Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_cut_copper
     */
    WAXED_WEATHERED_CUT_COPPER,

    /**
     * Waxed Weathered Cut Copper Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_cut_copper_slab
     */
    WAXED_WEATHERED_CUT_COPPER_SLAB,

    /**
     * Waxed Weathered Cut Copper Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_cut_copper_stairs
     */
    WAXED_WEATHERED_CUT_COPPER_STAIRS,

    /**
     * Waxed Weathered Lightning Rod
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:waxed_weathered_lightning_rod
     */
    WAXED_WEATHERED_LIGHTNING_ROD,

    /**
     * Weathered Chiseled Copper
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:weathered_chiseled_copper
     */
    WEATHERED_CHISELED_COPPER,

    /**
     * Weathered Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:weathered_copper
     */
    WEATHERED_COPPER,

    /**
     * Weathered Copper Bars
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:weathered_copper_bars
     */
    WEATHERED_COPPER_BARS,

    /**
     * Weathered Copper Bulb
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:weathered_copper_bulb
     */
    WEATHERED_COPPER_BULB,

    /**
     * Weathered Copper Chain
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:weathered_copper_chain
     */
    WEATHERED_COPPER_CHAIN,

    /**
     * Weathered Copper Chest
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:weathered_copper_chest
     */
    WEATHERED_COPPER_CHEST,

    /**
     * Weathered Copper Door
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:weathered_copper_door
     */
    WEATHERED_COPPER_DOOR,

    /**
     * Weathered Copper Golem Statue
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:weathered_copper_golem_statue
     */
    WEATHERED_COPPER_GOLEM_STATUE,

    /**
     * Weathered Copper Grate
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:weathered_copper_grate
     */
    WEATHERED_COPPER_GRATE,

    /**
     * Weathered Copper Lantern
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:weathered_copper_lantern
     */
    WEATHERED_COPPER_LANTERN,

    /**
     * Weathered Copper Trapdoor
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:weathered_copper_trapdoor
     */
    WEATHERED_COPPER_TRAPDOOR,

    /**
     * Weathered Cut Copper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:weathered_cut_copper
     */
    WEATHERED_CUT_COPPER,

    /**
     * Weathered Cut Copper Slab
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:weathered_cut_copper_slab
     */
    WEATHERED_CUT_COPPER_SLAB,

    /**
     * Weathered Cut Copper Stairs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:weathered_cut_copper_stairs
     */
    WEATHERED_CUT_COPPER_STAIRS,

    /**
     * Weathered Lightning Rod
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:weathered_lightning_rod
     */
    WEATHERED_LIGHTNING_ROD,

    /**
     * Weeping Vines
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:weeping_vines
     */
    WEEPING_VINES,

    /**
     * Weeping Vines Plant
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:weeping_vines_plant
     */
    WEEPING_VINES_PLANT,

    /**
     * Wet Sponge
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:wet_sponge
     */
    WET_SPONGE,

    /**
     * Wheat
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:wheat
     */
    WHEAT,

    /**
     * White Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_banner
     */
    WHITE_BANNER,

    /**
     * White Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_bed
     */
    WHITE_BED,

    /**
     * White Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_candle
     */
    WHITE_CANDLE,

    /**
     * White Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_candle_cake
     */
    WHITE_CANDLE_CAKE,

    /**
     * White Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_carpet
     */
    WHITE_CARPET,

    /**
     * White Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_concrete
     */
    WHITE_CONCRETE,

    /**
     * White Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_concrete_powder
     */
    WHITE_CONCRETE_POWDER,

    /**
     * White Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_glazed_terracotta
     */
    WHITE_GLAZED_TERRACOTTA,

    /**
     * White Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_shulker_box
     */
    WHITE_SHULKER_BOX,

    /**
     * White Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_stained_glass
     */
    WHITE_STAINED_GLASS,

    /**
     * White Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_stained_glass_pane
     */
    WHITE_STAINED_GLASS_PANE,

    /**
     * White Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_terracotta
     */
    WHITE_TERRACOTTA,

    /**
     * White Tulip
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_tulip
     */
    WHITE_TULIP,

    /**
     * White Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_wall_banner
     */
    WHITE_WALL_BANNER,

    /**
     * White Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:white_wool
     */
    WHITE_WOOL,

    /**
     * Wildflowers
     * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
     * <br> Resource: minecraft:wildflowers
     */
    WILDFLOWERS,

    /**
     * Wither Rose
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:wither_rose
     */
    WITHER_ROSE,

    /**
     * Wither Skeleton Skull
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:wither_skeleton_skull
     */
    WITHER_SKELETON_SKULL,

    /**
     * Wither Skeleton Wall Skull
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:wither_skeleton_wall_skull
     */
    WITHER_SKELETON_WALL_SKULL,

    /**
     * Yellow Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_banner
     */
    YELLOW_BANNER,

    /**
     * Yellow Bed
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_bed
     */
    YELLOW_BED,

    /**
     * Yellow Candle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_candle
     */
    YELLOW_CANDLE,

    /**
     * Yellow Candle Cake
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_candle_cake
     */
    YELLOW_CANDLE_CAKE,

    /**
     * Yellow Carpet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_carpet
     */
    YELLOW_CARPET,

    /**
     * Yellow Concrete
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_concrete
     */
    YELLOW_CONCRETE,

    /**
     * Yellow Concrete Powder
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_concrete_powder
     */
    YELLOW_CONCRETE_POWDER,

    /**
     * Yellow Glazed Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_glazed_terracotta
     */
    YELLOW_GLAZED_TERRACOTTA,

    /**
     * Yellow Shulker Box
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_shulker_box
     */
    YELLOW_SHULKER_BOX,

    /**
     * Yellow Stained Glass
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_stained_glass
     */
    YELLOW_STAINED_GLASS,

    /**
     * Yellow Stained Glass Pane
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_stained_glass_pane
     */
    YELLOW_STAINED_GLASS_PANE,

    /**
     * Yellow Terracotta
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_terracotta
     */
    YELLOW_TERRACOTTA,

    /**
     * Yellow Wall Banner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_wall_banner
     */
    YELLOW_WALL_BANNER,

    /**
     * Yellow Wool
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:yellow_wool
     */
    YELLOW_WOOL,

    /**
     * Zombie Head
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:zombie_head
     */
    ZOMBIE_HEAD,

    /**
     * Zombie Wall Head
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:zombie_wall_head
     */
    ZOMBIE_WALL_HEAD;


    Block() {
        this.metadata = new TypeMetadata<Block>(this, new String[]{TypeMetadata.JSON_NODE_PROTOCOL, TypeMetadata.JSON_NODE_REGISTRIES, TypeMetadata.JSON_NODE_BLOCK, this.name().toLowerCase()});
    }

    private final TypeMetadata<Block> metadata;

    @Override
    public TypeMetadata<Block> getMetadata() {
        return this.metadata;
    }

}
