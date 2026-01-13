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
 *
 * @see Protocol
 */
public enum EntityType implements ProtocolMetadata {

    /**
     * Used to represent an undefined EntityType type.
     */
    UNDEFINED,


    /**
     * Acacia Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_boat
     * <p>
     * For older versions, see BOAT instead.
     */
    ACACIA_BOAT,

    /**
     * Acacia Chest Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:acacia_chest_boat
     * <p>
     * For older versions, see CHEST_BOAT instead.
     */
    ACACIA_CHEST_BOAT,

    /**
     * Allay
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:allay
     */
    ALLAY,

    /**
     * Area Effect Cloud
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:area_effect_cloud
     */
    AREA_EFFECT_CLOUD,

    /**
     * Armadillo
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:armadillo
     */
    ARMADILLO,

    /**
     * Armor Stand
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:armor_stand
     */
    ARMOR_STAND,

    /**
     * Arrow
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:arrow
     */
    ARROW,

    /**
     * Axolotl
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:axolotl
     */
    AXOLOTL,

    /**
     * Bamboo Chest Raft
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_chest_raft
     */
    BAMBOO_CHEST_RAFT,

    /**
     * Bamboo Raft
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:bamboo_raft
     */
    BAMBOO_RAFT,

    /**
     * Bat
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bat
     */
    BAT,

    /**
     * Bee
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:bee
     */
    BEE,

    /**
     * Birch Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_boat
     * <p>
     * For older versions, see BOAT instead.
     */
    BIRCH_BOAT,

    /**
     * Birch Chest Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:birch_chest_boat
     * <p>
     * For older versions, see CHEST_BOAT instead.
     */
    BIRCH_CHEST_BOAT,

    /**
     * Blaze
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:blaze
     */
    BLAZE,

    /**
     * Block Display
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:block_display
     */
    BLOCK_DISPLAY,

    /**
     * Boat
     * <p>
     * Supported Protocols: 755 - 767 (1.17.0 - 1.21.1)
     * <br>
     * Resource: minecraft:boat
     * <p>
     * Replaced by ACACIA_BOAT, BIRCH_BOAT, CHERRY_BOAT, DARK_OAK_BOAT, JUNGLE_BOAT, MANGROVE_BOAT, OAK_BOAT, PALE_OAK_BOAT, & SPRUCE_BOAT in newer versions
     */
    BOAT,

    /**
     * Bogged
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:bogged
     */
    BOGGED,

    /**
     * Breeze
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:breeze
     */
    BREEZE,

    /**
     * Breeze Wind Charge
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:breeze_wind_charge
     */
    BREEZE_WIND_CHARGE,

    /**
     * Camel
     * <p>
     * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
     * <br>
     * Resource: minecraft:camel
     */
    CAMEL,

    /**
     * Camel Husk
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:camel_husk
     */
    CAMEL_HUSK,

    /**
     * Cat
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cat
     */
    CAT,

    /**
     * Cave Spider
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cave_spider
     */
    CAVE_SPIDER,

    /**
     * Cherry Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_boat
     * <p>
     * For older versions, see BOAT instead.
     */
    CHERRY_BOAT,

    /**
     * Cherry Chest Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:cherry_chest_boat
     * <p>
     * For older versions, see CHEST_BOAT instead.
     */
    CHERRY_CHEST_BOAT,

    /**
     * Chest Boat
     * <p>
     * Supported Protocols: 759 - 767 (1.19.0 - 1.21.1)
     * <br>
     * Resource: minecraft:chest_boat
     * <p>
     * Replaced by ACACIA_CHEST_BOAT, CHERRY_CHEST_BOAT, BIRCH_CHEST_BOAT, DARK_OAK_CHEST_BOAT, JUNGLE_CHEST_BOAT, MANGROVE_CHEST_BOAT, OAK_CHEST_BOAT, PALE_OAK_CHEST_BOAT, & SPRUCE_CHEST_BOAT in newer versions
     */
    CHEST_BOAT,

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
     * Cod
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cod
     */
    COD,

    /**
     * Command Block Minecart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:command_block_minecart
     */
    COMMAND_BLOCK_MINECART,

    /**
     * Copper Golem
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:copper_golem
     */
    COPPER_GOLEM,

    /**
     * Cow
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:cow
     */
    COW,

    /**
     * Creaking
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:creaking
     */
    CREAKING,

    /**
     * Creaking Transient
     * <p>
     * Supported Protocol: 768 (1.21.2 - 1.21.3)
     * <br>
     * Resource: minecraft:creaking_transient
     */
    CREAKING_TRANSIENT,

    /**
     * Creeper
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:creeper
     */
    CREEPER,

    /**
     * Dark Oak Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_boat
     * <p>
     * For older versions, see BOAT instead.
     */
    DARK_OAK_BOAT,

    /**
     * Dark Oak Chest Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:dark_oak_chest_boat
     * <p>
     * For older versions, see CHEST_BOAT instead.
     */
    DARK_OAK_CHEST_BOAT,

    /**
     * Dolphin
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dolphin
     */
    DOLPHIN,

    /**
     * Donkey
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:donkey
     */
    DONKEY,

    /**
     * Dragon Fireball
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:dragon_fireball
     */
    DRAGON_FIREBALL,

    /**
     * Drowned
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:drowned
     */
    DROWNED,

    /**
     * Egg
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:egg
     */
    EGG,

    /**
     * Elder Guardian
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:elder_guardian
     */
    ELDER_GUARDIAN,

    /**
     * Enderman
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:enderman
     */
    ENDERMAN,

    /**
     * Endermite
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:endermite
     */
    ENDERMITE,

    /**
     * Ender Dragon
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ender_dragon
     */
    ENDER_DRAGON,

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
     * Evoker
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:evoker
     */
    EVOKER,

    /**
     * Evoker Fangs
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:evoker_fangs
     */
    EVOKER_FANGS,

    /**
     * Experience Bottle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:experience_bottle
     */
    EXPERIENCE_BOTTLE,

    /**
     * Experience Orb
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:experience_orb
     */
    EXPERIENCE_ORB,

    /**
     * Eye Of Ender
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:eye_of_ender
     */
    EYE_OF_ENDER,

    /**
     * Falling Block
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:falling_block
     */
    FALLING_BLOCK,

    /**
     * Fireball
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fireball
     */
    FIREBALL,

    /**
     * Firework Rocket
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:firework_rocket
     */
    FIREWORK_ROCKET,

    /**
     * Fishing Bobber
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fishing_bobber
     */
    FISHING_BOBBER,

    /**
     * Fox
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:fox
     */
    FOX,

    /**
     * Frog
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:frog
     */
    FROG,

    /**
     * Furnace Minecart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:furnace_minecart
     */
    FURNACE_MINECART,

    /**
     * Ghast
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ghast
     */
    GHAST,

    /**
     * Giant
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:giant
     */
    GIANT,

    /**
     * Glow Item Frame
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glow_item_frame
     */
    GLOW_ITEM_FRAME,

    /**
     * Glow Squid
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:glow_squid
     */
    GLOW_SQUID,

    /**
     * Goat
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:goat
     */
    GOAT,

    /**
     * Guardian
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:guardian
     */
    GUARDIAN,

    /**
     * Happy Ghast
     * <p>
     * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
     * <br>
     * Resource: minecraft:happy_ghast
     */
    HAPPY_GHAST,

    /**
     * Hoglin
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:hoglin
     */
    HOGLIN,

    /**
     * Hopper Minecart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:hopper_minecart
     */
    HOPPER_MINECART,

    /**
     * Horse
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:horse
     */
    HORSE,

    /**
     * Husk
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:husk
     */
    HUSK,

    /**
     * Illusioner
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:illusioner
     */
    ILLUSIONER,

    /**
     * Interaction
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:interaction
     */
    INTERACTION,

    /**
     * Iron Golem
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:iron_golem
     */
    IRON_GOLEM,

    /**
     * Item
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:item
     */
    ITEM,

    /**
     * Item Display
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:item_display
     */
    ITEM_DISPLAY,

    /**
     * Item Frame
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:item_frame
     */
    ITEM_FRAME,

    /**
     * Jungle Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_boat
     * <p>
     * For older versions, see BOAT instead.
     */
    JUNGLE_BOAT,

    /**
     * Jungle Chest Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:jungle_chest_boat
     * <p>
     * For older versions, see CHEST_BOAT instead.
     */
    JUNGLE_CHEST_BOAT,

    /**
     * Leash Knot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:leash_knot
     */
    LEASH_KNOT,

    /**
     * Lightning Bolt
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:lightning_bolt
     */
    LIGHTNING_BOLT,

    /**
     * Lingering Potion
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:lingering_potion
     * <p>
     * For older versions, see POTION instead.
     */
    LINGERING_POTION,

    /**
     * Llama
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:llama
     */
    LLAMA,

    /**
     * Llama Spit
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:llama_spit
     */
    LLAMA_SPIT,

    /**
     * Magma Cube
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:magma_cube
     */
    MAGMA_CUBE,

    /**
     * Mangrove Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_boat
     * <p>
     * For older versions, see BOAT instead.
     */
    MANGROVE_BOAT,

    /**
     * Mangrove Chest Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:mangrove_chest_boat
     * <p>
     * For older versions, see CHEST_BOAT instead.
     */
    MANGROVE_CHEST_BOAT,

    /**
     * Mannequin
     * <p>
     * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
     * <br>
     * Resource: minecraft:mannequin
     */
    MANNEQUIN,

    /**
     * Marker
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:marker
     */
    MARKER,

    /**
     * Minecart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:minecart
     */
    MINECART,

    /**
     * Mooshroom
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mooshroom
     */
    MOOSHROOM,

    /**
     * Mule
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:mule
     */
    MULE,

    /**
     * Nautilus
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:nautilus
     */
    NAUTILUS,

    /**
     * Oak Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_boat
     * <p>
     * For older versions, see BOAT instead.
     */
    OAK_BOAT,

    /**
     * Oak Chest Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:oak_chest_boat
     * <p>
     * For older versions, see CHEST_BOAT instead.
     */
    OAK_CHEST_BOAT,

    /**
     * Ocelot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ocelot
     */
    OCELOT,

    /**
     * Ominous Item Spawner
     * <p>
     * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
     * <br>
     * Resource: minecraft:ominous_item_spawner
     */
    OMINOUS_ITEM_SPAWNER,

    /**
     * Painting
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:painting
     */
    PAINTING,

    /**
     * Pale Oak Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_boat
     * <p>
     * For older versions, see BOAT instead.
     */
    PALE_OAK_BOAT,

    /**
     * Pale Oak Chest Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:pale_oak_chest_boat
     * <p>
     * For older versions, see CHEST_BOAT instead.
     */
    PALE_OAK_CHEST_BOAT,

    /**
     * Panda
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:panda
     */
    PANDA,

    /**
     * Parched
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:parched
     */
    PARCHED,

    /**
     * Parrot
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:parrot
     */
    PARROT,

    /**
     * Phantom
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:phantom
     */
    PHANTOM,

    /**
     * Pig
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pig
     */
    PIG,

    /**
     * Piglin
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:piglin
     */
    PIGLIN,

    /**
     * Piglin Brute
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:piglin_brute
     */
    PIGLIN_BRUTE,

    /**
     * Pillager
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pillager
     */
    PILLAGER,

    /**
     * Player
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:player
     */
    PLAYER,

    /**
     * Polar Bear
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:polar_bear
     */
    POLAR_BEAR,

    /**
     * Potion
     * <p>
     * Supported Protocols: 755 - 769 (1.17.0 - 1.21.4)
     * <br>
     * Resource: minecraft:potion
     * <p>
     * Replaced by LINGERING_POTION & SPLASH_POTION in newer versions
     */
    POTION,

    /**
     * Pufferfish
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:pufferfish
     */
    PUFFERFISH,

    /**
     * Rabbit
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:rabbit
     */
    RABBIT,

    /**
     * Ravager
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:ravager
     */
    RAVAGER,

    /**
     * Salmon
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:salmon
     */
    SALMON,

    /**
     * Sheep
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:sheep
     */
    SHEEP,

    /**
     * Shulker
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:shulker
     */
    SHULKER,

    /**
     * Shulker Bullet
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:shulker_bullet
     */
    SHULKER_BULLET,

    /**
     * Silverfish
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:silverfish
     */
    SILVERFISH,

    /**
     * Skeleton
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:skeleton
     */
    SKELETON,

    /**
     * Skeleton Horse
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:skeleton_horse
     */
    SKELETON_HORSE,

    /**
     * Slime
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:slime
     */
    SLIME,

    /**
     * Small Fireball
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:small_fireball
     */
    SMALL_FIREBALL,

    /**
     * Sniffer
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:sniffer
     */
    SNIFFER,

    /**
     * Snowball
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:snowball
     */
    SNOWBALL,

    /**
     * Snow Golem
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:snow_golem
     */
    SNOW_GOLEM,

    /**
     * Spawner Minecart
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spawner_minecart
     */
    SPAWNER_MINECART,

    /**
     * Spectral Arrow
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spectral_arrow
     */
    SPECTRAL_ARROW,

    /**
     * Spider
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:spider
     */
    SPIDER,

    /**
     * Splash Potion
     * <p>
     * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
     * <br>
     * Resource: minecraft:splash_potion
     * <p>
     * For older versions, see POTION instead.
     */
    SPLASH_POTION,

    /**
     * Spruce Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_boat
     * <p>
     * For older versions, see BOAT instead.
     */
    SPRUCE_BOAT,

    /**
     * Spruce Chest Boat
     * <p>
     * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
     * <br>
     * Resource: minecraft:spruce_chest_boat
     * <p>
     * For older versions, see CHEST_BOAT instead.
     */
    SPRUCE_CHEST_BOAT,

    /**
     * Squid
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:squid
     */
    SQUID,

    /**
     * Stray
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:stray
     */
    STRAY,

    /**
     * Strider
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:strider
     */
    STRIDER,

    /**
     * Tadpole
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tadpole
     */
    TADPOLE,

    /**
     * Text Display
     * <p>
     * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
     * <br>
     * Resource: minecraft:text_display
     */
    TEXT_DISPLAY,

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
     * Trader Llama
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:trader_llama
     */
    TRADER_LLAMA,

    /**
     * Trident
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:trident
     */
    TRIDENT,

    /**
     * Tropical Fish
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:tropical_fish
     */
    TROPICAL_FISH,

    /**
     * Turtle
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:turtle
     */
    TURTLE,

    /**
     * Vex
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:vex
     */
    VEX,

    /**
     * Villager
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:villager
     */
    VILLAGER,

    /**
     * Vindicator
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:vindicator
     */
    VINDICATOR,

    /**
     * Wandering Trader
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wandering_trader
     */
    WANDERING_TRADER,

    /**
     * Warden
     * <p>
     * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
     * <br>
     * Resource: minecraft:warden
     */
    WARDEN,

    /**
     * Wind Charge
     * <p>
     * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
     * <br>
     * Resource: minecraft:wind_charge
     */
    WIND_CHARGE,

    /**
     * Witch
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:witch
     */
    WITCH,

    /**
     * Wither
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wither
     */
    WITHER,

    /**
     * Wither Skeleton
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wither_skeleton
     */
    WITHER_SKELETON,

    /**
     * Wither Skull
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wither_skull
     */
    WITHER_SKULL,

    /**
     * Wolf
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:wolf
     */
    WOLF,

    /**
     * Zoglin
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:zoglin
     */
    ZOGLIN,

    /**
     * Zombie
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:zombie
     */
    ZOMBIE,

    /**
     * Zombie Horse
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:zombie_horse
     */
    ZOMBIE_HORSE,

    /**
     * Zombie Nautilus
     * <p>
     * Supported Protocol: 774 (1.21.11)
     * <br>
     * Resource: minecraft:zombie_nautilus
     */
    ZOMBIE_NAUTILUS,

    /**
     * Zombie Villager
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:zombie_villager
     */
    ZOMBIE_VILLAGER,

    /**
     * Zombified Piglin
     * <p>
     * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
     * <br>
     * Resource: minecraft:zombified_piglin
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
