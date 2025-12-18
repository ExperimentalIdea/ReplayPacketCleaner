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
 * Represents all the different entity types.
 * <br>
 * <br> In cases where a type doesn't exist, EntityType.UNDEFINED should be used instead.
 * <br>
 * <br> Documentation for each type created with {@link DocumentationGenerator}.
 * Supported Protocol(s) & Resource(s) documented are only inclusive of the protocol versions Replay Packet Cleaner itself currently supports.
 * @see Protocol
 * */
public enum EntityType implements ProtocolMetadata {

    /**
     * Used to represent an undefined EntityType type.
     */
    UNDEFINED,


    /**
     * Acacia Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:acacia_boat
     * <br>
     * <br> For older versions, see BOAT instead.
     */
    ACACIA_BOAT,

    /**
     * Acacia Chest Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:acacia_chest_boat
     * <br>
     * <br> For older versions, see CHEST_BOAT instead.
     */
    ACACIA_CHEST_BOAT,

    /**
     * Allay
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:allay
     */
    ALLAY,

    /**
     * Area Effect Cloud
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:area_effect_cloud
     */
    AREA_EFFECT_CLOUD,

    /**
     * Armadillo
     * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
     * <br> Resource: minecraft:armadillo
     */
    ARMADILLO,

    /**
     * Armor Stand
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:armor_stand
     */
    ARMOR_STAND,

    /**
     * Arrow
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:arrow
     */
    ARROW,

    /**
     * Axolotl
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:axolotl
     */
    AXOLOTL,

    /**
     * Bamboo Chest Raft
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:bamboo_chest_raft
     */
    BAMBOO_CHEST_RAFT,

    /**
     * Bamboo Raft
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:bamboo_raft
     */
    BAMBOO_RAFT,

    /**
     * Bat
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bat
     */
    BAT,

    /**
     * Bee
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:bee
     */
    BEE,

    /**
     * Birch Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:birch_boat
     * <br>
     * <br> For older versions, see BOAT instead.
     */
    BIRCH_BOAT,

    /**
     * Birch Chest Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:birch_chest_boat
     * <br>
     * <br> For older versions, see CHEST_BOAT instead.
     */
    BIRCH_CHEST_BOAT,

    /**
     * Blaze
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:blaze
     */
    BLAZE,

    /**
     * Block Display
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:block_display
     */
    BLOCK_DISPLAY,

    /**
     * Boat
     * <br> Supported Protocols: 755 - 767 (1.17.0 - 1.21.1)
     * <br> Resource: minecraft:boat
     * <br>
     * <br> Replaced by ACACIA_BOAT, BIRCH_BOAT, CHERRY_BOAT, DARK_OAK_BOAT, JUNGLE_BOAT, MANGROVE_BOAT, OAK_BOAT, PALE_OAK_BOAT, & SPRUCE_BOAT in newer versions
     */
    BOAT,

    /**
     * Bogged
     * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
     * <br> Resource: minecraft:bogged
     */
    BOGGED,

    /**
     * Breeze
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:breeze
     */
    BREEZE,

    /**
     * Breeze Wind Charge
     * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
     * <br> Resource: minecraft:breeze_wind_charge
     */
    BREEZE_WIND_CHARGE,

    /**
     * Camel
     * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
     * <br> Resource: minecraft:camel
     */
    CAMEL,

    /**
     * Cat
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cat
     */
    CAT,

    /**
     * Cave Spider
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cave_spider
     */
    CAVE_SPIDER,

    /**
     * Cherry Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:cherry_boat
     * <br>
     * <br> For older versions, see BOAT instead.
     */
    CHERRY_BOAT,

    /**
     * Cherry Chest Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:cherry_chest_boat
     * <br>
     * <br> For older versions, see CHEST_BOAT instead.
     */
    CHERRY_CHEST_BOAT,

    /**
     * Chest Boat
     * <br> Supported Protocols: 759 - 767 (1.19.0 - 1.21.1)
     * <br> Resource: minecraft:chest_boat
     * <br>
     * <br> Replaced by ACACIA_CHEST_BOAT, CHERRY_CHEST_BOAT, BIRCH_CHEST_BOAT, DARK_OAK_CHEST_BOAT, JUNGLE_CHEST_BOAT, MANGROVE_CHEST_BOAT, OAK_CHEST_BOAT, PALE_OAK_CHEST_BOAT, & SPRUCE_CHEST_BOAT in newer versions
     */
    CHEST_BOAT,

    /**
     * Chest Minecart
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chest_minecart
     */
    CHEST_MINECART,

    /**
     * Chicken
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:chicken
     */
    CHICKEN,

    /**
     * Cod
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cod
     */
    COD,

    /**
     * Command Block Minecart
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:command_block_minecart
     */
    COMMAND_BLOCK_MINECART,

    /**
     * Copper Golem
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:copper_golem
     */
    COPPER_GOLEM,

    /**
     * Cow
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:cow
     */
    COW,

    /**
     * Creaking
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:creaking
     */
    CREAKING,

    /**
     * Creaking Transient
     * <br> Supported Protocol: 768 (1.21.2 - 1.21.3)
     * <br> Resource: minecraft:creaking_transient
     */
    CREAKING_TRANSIENT,

    /**
     * Creeper
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:creeper
     */
    CREEPER,

    /**
     * Dark Oak Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_boat
     * <br>
     * <br> For older versions, see BOAT instead.
     */
    DARK_OAK_BOAT,

    /**
     * Dark Oak Chest Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:dark_oak_chest_boat
     * <br>
     * <br> For older versions, see CHEST_BOAT instead.
     */
    DARK_OAK_CHEST_BOAT,

    /**
     * Dolphin
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dolphin
     */
    DOLPHIN,

    /**
     * Donkey
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:donkey
     */
    DONKEY,

    /**
     * Dragon Fireball
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:dragon_fireball
     */
    DRAGON_FIREBALL,

    /**
     * Drowned
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:drowned
     */
    DROWNED,

    /**
     * Egg
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:egg
     */
    EGG,

    /**
     * Elder Guardian
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:elder_guardian
     */
    ELDER_GUARDIAN,

    /**
     * Enderman
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:enderman
     */
    ENDERMAN,

    /**
     * Endermite
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:endermite
     */
    ENDERMITE,

    /**
     * Ender Dragon
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:ender_dragon
     */
    ENDER_DRAGON,

    /**
     * Ender Pearl
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:ender_pearl
     */
    ENDER_PEARL,

    /**
     * End Crystal
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:end_crystal
     */
    END_CRYSTAL,

    /**
     * Evoker
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:evoker
     */
    EVOKER,

    /**
     * Evoker Fangs
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:evoker_fangs
     */
    EVOKER_FANGS,

    /**
     * Experience Bottle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:experience_bottle
     */
    EXPERIENCE_BOTTLE,

    /**
     * Experience Orb
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:experience_orb
     */
    EXPERIENCE_ORB,

    /**
     * Eye Of Ender
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:eye_of_ender
     */
    EYE_OF_ENDER,

    /**
     * Falling Block
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:falling_block
     */
    FALLING_BLOCK,

    /**
     * Fireball
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:fireball
     */
    FIREBALL,

    /**
     * Firework Rocket
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:firework_rocket
     */
    FIREWORK_ROCKET,

    /**
     * Fishing Bobber
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:fishing_bobber
     */
    FISHING_BOBBER,

    /**
     * Fox
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:fox
     */
    FOX,

    /**
     * Frog
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:frog
     */
    FROG,

    /**
     * Furnace Minecart
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:furnace_minecart
     */
    FURNACE_MINECART,

    /**
     * Ghast
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:ghast
     */
    GHAST,

    /**
     * Giant
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:giant
     */
    GIANT,

    /**
     * Glow Item Frame
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:glow_item_frame
     */
    GLOW_ITEM_FRAME,

    /**
     * Glow Squid
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:glow_squid
     */
    GLOW_SQUID,

    /**
     * Goat
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:goat
     */
    GOAT,

    /**
     * Guardian
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:guardian
     */
    GUARDIAN,

    /**
     * Happy Ghast
     * <br> Supported Protocols: 771 - 773 (1.21.6 - 1.21.10)
     * <br> Resource: minecraft:happy_ghast
     */
    HAPPY_GHAST,

    /**
     * Hoglin
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:hoglin
     */
    HOGLIN,

    /**
     * Hopper Minecart
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:hopper_minecart
     */
    HOPPER_MINECART,

    /**
     * Horse
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:horse
     */
    HORSE,

    /**
     * Husk
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:husk
     */
    HUSK,

    /**
     * Illusioner
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:illusioner
     */
    ILLUSIONER,

    /**
     * Interaction
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:interaction
     */
    INTERACTION,

    /**
     * Iron Golem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:iron_golem
     */
    IRON_GOLEM,

    /**
     * Item
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:item
     */
    ITEM,

    /**
     * Item Display
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:item_display
     */
    ITEM_DISPLAY,

    /**
     * Item Frame
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:item_frame
     */
    ITEM_FRAME,

    /**
     * Jungle Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:jungle_boat
     * <br>
     * <br> For older versions, see BOAT instead.
     */
    JUNGLE_BOAT,

    /**
     * Jungle Chest Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:jungle_chest_boat
     * <br>
     * <br> For older versions, see CHEST_BOAT instead.
     */
    JUNGLE_CHEST_BOAT,

    /**
     * Leash Knot
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:leash_knot
     */
    LEASH_KNOT,

    /**
     * Lightning Bolt
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:lightning_bolt
     */
    LIGHTNING_BOLT,

    /**
     * Lingering Potion
     * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
     * <br> Resource: minecraft:lingering_potion
     * <br>
     * <br> For older versions, see POTION instead.
     */
    LINGERING_POTION,

    /**
     * Llama
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:llama
     */
    LLAMA,

    /**
     * Llama Spit
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:llama_spit
     */
    LLAMA_SPIT,

    /**
     * Magma Cube
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:magma_cube
     */
    MAGMA_CUBE,

    /**
     * Mangrove Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:mangrove_boat
     * <br>
     * <br> For older versions, see BOAT instead.
     */
    MANGROVE_BOAT,

    /**
     * Mangrove Chest Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:mangrove_chest_boat
     * <br>
     * <br> For older versions, see CHEST_BOAT instead.
     */
    MANGROVE_CHEST_BOAT,

    /**
     * Mannequin
     * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
     * <br> Resource: minecraft:mannequin
     */
    MANNEQUIN,

    /**
     * Marker
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:marker
     */
    MARKER,

    /**
     * Minecart
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:minecart
     */
    MINECART,

    /**
     * Mooshroom
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mooshroom
     */
    MOOSHROOM,

    /**
     * Mule
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:mule
     */
    MULE,

    /**
     * Oak Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:oak_boat
     * <br>
     * <br> For older versions, see BOAT instead.
     */
    OAK_BOAT,

    /**
     * Oak Chest Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:oak_chest_boat
     * <br>
     * <br> For older versions, see CHEST_BOAT instead.
     */
    OAK_CHEST_BOAT,

    /**
     * Ocelot
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:ocelot
     */
    OCELOT,

    /**
     * Ominous Item Spawner
     * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
     * <br> Resource: minecraft:ominous_item_spawner
     */
    OMINOUS_ITEM_SPAWNER,

    /**
     * Painting
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:painting
     */
    PAINTING,

    /**
     * Pale Oak Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_boat
     * <br>
     * <br> For older versions, see BOAT instead.
     */
    PALE_OAK_BOAT,

    /**
     * Pale Oak Chest Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:pale_oak_chest_boat
     * <br>
     * <br> For older versions, see CHEST_BOAT instead.
     */
    PALE_OAK_CHEST_BOAT,

    /**
     * Panda
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:panda
     */
    PANDA,

    /**
     * Parrot
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:parrot
     */
    PARROT,

    /**
     * Phantom
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:phantom
     */
    PHANTOM,

    /**
     * Pig
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pig
     */
    PIG,

    /**
     * Piglin
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:piglin
     */
    PIGLIN,

    /**
     * Piglin Brute
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:piglin_brute
     */
    PIGLIN_BRUTE,

    /**
     * Pillager
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pillager
     */
    PILLAGER,

    /**
     * Player
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:player
     */
    PLAYER,

    /**
     * Polar Bear
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:polar_bear
     */
    POLAR_BEAR,

    /**
     * Potion
     * <br> Supported Protocols: 755 - 769 (1.17.0 - 1.21.4)
     * <br> Resource: minecraft:potion
     * <br>
     * <br> Replaced by LINGERING_POTION & SPLASH_POTION in newer versions
     */
    POTION,

    /**
     * Pufferfish
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:pufferfish
     */
    PUFFERFISH,

    /**
     * Rabbit
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:rabbit
     */
    RABBIT,

    /**
     * Ravager
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:ravager
     */
    RAVAGER,

    /**
     * Salmon
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:salmon
     */
    SALMON,

    /**
     * Sheep
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:sheep
     */
    SHEEP,

    /**
     * Shulker
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:shulker
     */
    SHULKER,

    /**
     * Shulker Bullet
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:shulker_bullet
     */
    SHULKER_BULLET,

    /**
     * Silverfish
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:silverfish
     */
    SILVERFISH,

    /**
     * Skeleton
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:skeleton
     */
    SKELETON,

    /**
     * Skeleton Horse
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:skeleton_horse
     */
    SKELETON_HORSE,

    /**
     * Slime
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:slime
     */
    SLIME,

    /**
     * Small Fireball
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:small_fireball
     */
    SMALL_FIREBALL,

    /**
     * Sniffer
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:sniffer
     */
    SNIFFER,

    /**
     * Snowball
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:snowball
     */
    SNOWBALL,

    /**
     * Snow Golem
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:snow_golem
     */
    SNOW_GOLEM,

    /**
     * Spawner Minecart
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spawner_minecart
     */
    SPAWNER_MINECART,

    /**
     * Spectral Arrow
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spectral_arrow
     */
    SPECTRAL_ARROW,

    /**
     * Spider
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:spider
     */
    SPIDER,

    /**
     * Splash Potion
     * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
     * <br> Resource: minecraft:splash_potion
     * <br>
     * <br> For older versions, see POTION instead.
     */
    SPLASH_POTION,

    /**
     * Spruce Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:spruce_boat
     * <br>
     * <br> For older versions, see BOAT instead.
     */
    SPRUCE_BOAT,

    /**
     * Spruce Chest Boat
     * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
     * <br> Resource: minecraft:spruce_chest_boat
     * <br>
     * <br> For older versions, see CHEST_BOAT instead.
     */
    SPRUCE_CHEST_BOAT,

    /**
     * Squid
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:squid
     */
    SQUID,

    /**
     * Stray
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:stray
     */
    STRAY,

    /**
     * Strider
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:strider
     */
    STRIDER,

    /**
     * Tadpole
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:tadpole
     */
    TADPOLE,

    /**
     * Text Display
     * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
     * <br> Resource: minecraft:text_display
     */
    TEXT_DISPLAY,

    /**
     * Tnt
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tnt
     */
    TNT,

    /**
     * Tnt Minecart
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tnt_minecart
     */
    TNT_MINECART,

    /**
     * Trader Llama
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:trader_llama
     */
    TRADER_LLAMA,

    /**
     * Trident
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:trident
     */
    TRIDENT,

    /**
     * Tropical Fish
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:tropical_fish
     */
    TROPICAL_FISH,

    /**
     * Turtle
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:turtle
     */
    TURTLE,

    /**
     * Vex
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:vex
     */
    VEX,

    /**
     * Villager
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:villager
     */
    VILLAGER,

    /**
     * Vindicator
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:vindicator
     */
    VINDICATOR,

    /**
     * Wandering Trader
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:wandering_trader
     */
    WANDERING_TRADER,

    /**
     * Warden
     * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
     * <br> Resource: minecraft:warden
     */
    WARDEN,

    /**
     * Wind Charge
     * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
     * <br> Resource: minecraft:wind_charge
     */
    WIND_CHARGE,

    /**
     * Witch
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:witch
     */
    WITCH,

    /**
     * Wither
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:wither
     */
    WITHER,

    /**
     * Wither Skeleton
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:wither_skeleton
     */
    WITHER_SKELETON,

    /**
     * Wither Skull
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:wither_skull
     */
    WITHER_SKULL,

    /**
     * Wolf
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:wolf
     */
    WOLF,

    /**
     * Zoglin
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:zoglin
     */
    ZOGLIN,

    /**
     * Zombie
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:zombie
     */
    ZOMBIE,

    /**
     * Zombie Horse
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:zombie_horse
     */
    ZOMBIE_HORSE,

    /**
     * Zombie Villager
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:zombie_villager
     */
    ZOMBIE_VILLAGER,

    /**
     * Zombified Piglin
     * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
     * <br> Resource: minecraft:zombified_piglin
     */
    ZOMBIFIED_PIGLIN;


    EntityType() {
        this.metadata = new TypeMetadata<EntityType>(this, new String[]{TypeMetadata.JSON_NODE_PROTOCOL, TypeMetadata.JSON_NODE_REGISTRIES, TypeMetadata.JSON_NODE_ENTITY_TYPE, this.name().toLowerCase()});
    }

    private final TypeMetadata<EntityType> metadata;

    @Override
    public TypeMetadata<EntityType> getMetadata() {
        return this.metadata;
    }

}
