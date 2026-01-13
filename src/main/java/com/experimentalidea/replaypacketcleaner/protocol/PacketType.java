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
 * Contains enum classes for representing all clientbound packet types for the Login, Configuration, and Play connection states.
 * <p>
 * The <a href=https://minecraft.wiki/w/Java_Edition_protocol/Packets">Minecraft Wiki Java Edition protocol/Packets</a> page
 * is a key resource in the ongoing development of Replay Packet Cleaner.
 * Names of the enum packet types are typically the same names used on the Minecraft Wiki.
 * <p>
 * When an enum packet type doesn't exist to represent a packet, the UNDEFINED type for that connection state should be (and is) used instead of null in all cases.
 * <p>
 * Documentation for each type created with {@link DocumentationGenerator}.
 * Supported Protocol(s) & Resource(s) documented are only inclusive of the protocol versions Replay Packet Cleaner itself currently supports.
 *
 * @see Protocol
 * @see Login
 * @see Configuration
 * @see Play
 */
public interface PacketType {

    /**
     * Get the protocol state the packet type is associated with.
     *
     * @return The protocol state.
     */
    public ProtocolState getProtocolState();


    /**
     * Representation of all clientbound Configuration phase packet types.
     * <p>
     * Replays recorded in protocol version 764 (1.20.2) and newer begin in this protocol state.
     * After hitting PacketType.Configuration.FINISH_CONFIGURATION, the protocol switches the state to PLAY.
     * <p>
     * Protocol version 763 (1.20.1) and older do not support the Configuration connection state.
     *
     * @see Login
     * @see Play
     */
    public static enum Configuration implements ProtocolMetadata, PacketType {

        /**
         * Used to represent an undefined Configuration type.
         */
        UNDEFINED,


        /**
         * Add Resource Pack
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:resource_pack_push (767 - 774 (1.21.0 - 1.21.11))
         */
        ADD_RESOURCE_PACK,

        /**
         * Clear Dialog
         * <p>
         * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
         * <br>
         * Resource: minecraft:clear_dialog
         */
        CLEAR_DIALOG,

        /**
         * Clientbound Keep Alive
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:keep_alive (767 - 774 (1.21.0 - 1.21.11))
         */
        CLIENTBOUND_KEEP_ALIVE,

        /**
         * Clientbound Known Packs
         * <p>
         * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
         * <br>
         * Resource: minecraft:select_known_packs (767 - 774 (1.21.0 - 1.21.11))
         */
        CLIENTBOUND_KNOWN_PACKS,

        /**
         * Clientbound Plugin Message
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:custom_payload (767 - 774 (1.21.0 - 1.21.11))
         */
        CLIENTBOUND_PLUGIN_MESSAGE,

        /**
         * Code Of Conduct
         * <p>
         * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
         * <br>
         * Resource: minecraft:code_of_conduct
         */
        CODE_OF_CONDUCT,

        /**
         * Cookie Request
         * <p>
         * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
         * <br>
         * Resource: minecraft:cookie_request (767 - 774 (1.21.0 - 1.21.11))
         */
        COOKIE_REQUEST,

        /**
         * Custom Report Details
         * <p>
         * Supported Protocols: 767 - 774 (1.21.0 - 1.21.11)
         * <br>
         * Resource: minecraft:custom_report_details
         */
        CUSTOM_REPORT_DETAILS,

        /**
         * Disconnect
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:disconnect (767 - 774 (1.21.0 - 1.21.11))
         */
        DISCONNECT,

        /**
         * Feature Flags
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:update_enabled_features (767 - 774 (1.21.0 - 1.21.11))
         */
        FEATURE_FLAGS,

        /**
         * Finish Configuration
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:finish_configuration (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Switches the protocol state to PLAY in protocol versions 764 (1.20.2) and later.
         * For protocol versions 763 (1.20.1) and earlier, see PacketType.Login.LOGIN_SUCCESS.
         */
        FINISH_CONFIGURATION,

        /**
         * Ping
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:ping (767 - 774 (1.21.0 - 1.21.11))
         */
        PING,

        /**
         * Registry Data
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:registry_data (767 - 774 (1.21.0 - 1.21.11))
         */
        REGISTRY_DATA,

        /**
         * Remove Resource Pack
         * <p>
         * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
         * <br>
         * Resource: minecraft:resource_pack_pop (767 - 774 (1.21.0 - 1.21.11))
         */
        REMOVE_RESOURCE_PACK,

        /**
         * Reset Chat
         * <p>
         * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
         * <br>
         * Resource: minecraft:reset_chat (767 - 774 (1.21.0 - 1.21.11))
         */
        RESET_CHAT,

        /**
         * Server Links
         * <p>
         * Supported Protocols: 767 - 774 (1.21.0 - 1.21.11)
         * <br>
         * Resource: minecraft:server_links
         */
        SERVER_LINKS,

        /**
         * Show Dialog
         * <p>
         * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
         * <br>
         * Resource: minecraft:show_dialog
         */
        SHOW_DIALOG,

        /**
         * Store Cookie
         * <p>
         * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
         * <br>
         * Resource: minecraft:store_cookie (767 - 774 (1.21.0 - 1.21.11))
         */
        STORE_COOKIE,

        /**
         * Transfer
         * <p>
         * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
         * <br>
         * Resource: minecraft:transfer (767 - 774 (1.21.0 - 1.21.11))
         */
        TRANSFER,

        /**
         * Update Tags
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:update_tags (767 - 774 (1.21.0 - 1.21.11))
         */
        UPDATE_TAGS;


        Configuration() {
            this.metadata = new TypeMetadata<Configuration>(this, new String[]{TypeMetadata.JSON_NODE_PROTOCOL, TypeMetadata.JSON_NODE_PACKETS, TypeMetadata.JSON_NODE_STATE_CONFIGURATION, this.name().toLowerCase()});
        }


        private final TypeMetadata<Configuration> metadata;

        @Override
        public ProtocolState getProtocolState() {
            return ProtocolState.CONFIGURATION;
        }

        @Override
        public TypeMetadata<Configuration> getMetadata() {
            return this.metadata;
        }

    }


    /**
     * Representation of all clientbound Login phase packet types.
     * <p>
     * Replays recorded in protocol version 763 (1.20.1) and older begin in this protocol state.
     * After PacketType.Login.LOGIN_SUCCESS, the protocol switches the state to PLAY.
     *
     * @see Configuration
     * @see Play
     */
    public static enum Login implements ProtocolMetadata, PacketType {

        /**
         * Used to represent an undefined Login type.
         */
        UNDEFINED,


        /**
         * Cookie Request
         * <p>
         * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
         * <br>
         * Resource: minecraft:cookie_request (767 - 774 (1.21.0 - 1.21.11))
         */
        COOKIE_REQUEST,

        /**
         * Disconnect
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:login_disconnect (767 - 774 (1.21.0 - 1.21.11))
         */
        DISCONNECT,

        /**
         * Encryption Request
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:hello (767 - 774 (1.21.0 - 1.21.11))
         */
        ENCRYPTION_REQUEST,

        /**
         * Login Plugin Request
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:custom_query (767 - 774 (1.21.0 - 1.21.11))
         */
        LOGIN_PLUGIN_REQUEST,

        /**
         * Login Success
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resources: minecraft:game_profile (767 (1.21.0 - 1.21.1)), minecraft:login_finished (768 - 774 (1.21.2 - 1.21.11))
         * <p>
         * Switches the protocol state to PLAY in protocol versions 763 (1.20.1) and earlier.
         * For protocol versions 764+ (1.20.2), see PacketType.Configuration.FINISH_CONFIGURATION.
         */
        LOGIN_SUCCESS,

        /**
         * Set Compression
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:login_compression (767 - 774 (1.21.0 - 1.21.11))
         */
        SET_COMPRESSION;


        Login() {
            this.metadata = new TypeMetadata<Login>(this, new String[]{TypeMetadata.JSON_NODE_PROTOCOL, TypeMetadata.JSON_NODE_PACKETS, TypeMetadata.JSON_NODE_STATE_LOGIN, this.name().toLowerCase()});
        }


        private final TypeMetadata<Login> metadata;

        @Override
        public ProtocolState getProtocolState() {
            return ProtocolState.LOGIN;
        }

        @Override
        public TypeMetadata<Login> getMetadata() {
            return this.metadata;
        }

    }


    /**
     * Representation of all clientbound Play phase packet types.
     * <p>
     * This is the phase where RPC will monitor, alter, and delete packets from a replay.
     * <p>
     * Replays recorded in protocol versions 764 (1.20.2) and newer can switch the protocol state
     * from PLAY to CONFIGURATION upon hitting PacketType.Play.START_CONFIGURATION.
     *
     * @see Login
     * @see Configuration
     */
    public static enum Play implements ProtocolMetadata, PacketType {

        /**
         * Used to represent an undefined Play type.
         */
        UNDEFINED,


        /**
         * Acknowledge Block Change
         * <p>
         * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
         * <br>
         * Resource: minecraft:block_changed_ack (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Likely exists as a replacement for ACKNOWLEDGE_PLAYER_DIGGING, although the packet structure is completely different.
         */
        ACKNOWLEDGE_BLOCK_CHANGE,

        /**
         * Acknowledge Player Digging
         * <p>
         * Supported Protocols: 755 - 758 (1.17.0 - 1.18.2)
         * <p>
         * Appears ACKNOWLEDGE_BLOCK_CHANGE serves as a replacement for this packet type in newer versions.
         */
        ACKNOWLEDGE_PLAYER_DIGGING,

        /**
         * Add Resource Pack
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:resource_pack_push (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Resource Pack Send" in versions before 1.19 on the Minecraft wiki.
         */
        ADD_RESOURCE_PACK,

        /**
         * Award Statistics
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:award_stats (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Statistics" in versions before 1.19 on the Minecraft wiki.
         */
        AWARD_STATISTICS,

        /**
         * Block Action
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:block_event (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * NOTE: Packet structure changed from 1.13.x to 1.14.x.
         * The position field is encoded as XYZ in 1.13.x and older, while it is encoded as XZY in 1.14.x+
         */
        BLOCK_ACTION,

        /**
         * Block Entity Data
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:block_entity_data (767 - 774 (1.21.0 - 1.21.11))
         */
        BLOCK_ENTITY_DATA,

        /**
         * Block Update
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:block_update (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Block Change" in versions before 1.19 on the Minecraft wiki.
         */
        BLOCK_UPDATE,

        /**
         * Boss Bar
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:boss_event (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * TODO: note for implementing packet: The Enum fields Action, Color, & TypeOfDivision appear to be the same for all protocol versions. (when quickly comparing 1.12 to 1.21.8)
         */
        BOSS_BAR,

        /**
         * Bundle Delimiter
         * <p>
         * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
         * <br>
         * Resource: minecraft:bundle_delimiter (767 - 774 (1.21.0 - 1.21.11))
         */
        BUNDLE_DELIMITER,

        /**
         * Change Difficulty
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:change_difficulty (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Server Difficulty" in versions before 1.19 on the Minecraft wiki.
         */
        CHANGE_DIFFICULTY,

        /**
         * Chat Message
         * <p>
         * Supported Protocols: 755 - 758 (1.17.0 - 1.18.2)
         */
        CHAT_MESSAGE,

        /**
         * Chat Preview
         * <p>
         * Supported Protocols: 759 - 760 (1.19.0 - 1.19.2)
         */
        CHAT_PREVIEW,

        /**
         * Chat Suggestions
         * <p>
         * Supported Protocols: 760 - 774 (1.19.1 - 1.21.11)
         * <br>
         * Resource: minecraft:custom_chat_completions (767 - 774 (1.21.0 - 1.21.11))
         */
        CHAT_SUGGESTIONS,

        /**
         * Chunk Batch Finished
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:chunk_batch_finished (767 - 774 (1.21.0 - 1.21.11))
         */
        CHUNK_BATCH_FINISHED,

        /**
         * Chunk Batch Start
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:chunk_batch_start (767 - 774 (1.21.0 - 1.21.11))
         */
        CHUNK_BATCH_START,

        /**
         * Chunk Biomes
         * <p>
         * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
         * <br>
         * Resource: minecraft:chunks_biomes (767 - 774 (1.21.0 - 1.21.11))
         */
        CHUNK_BIOMES,

        /**
         * Chunk Data
         * <p>
         * Supported Protocols: 755 - 756 (1.17.0 - 1.17.1)
         * <p>
         * Replaced by CHUNK_DATA_AND_UPDATE_LIGHT in newer versions
         */
        CHUNK_DATA,

        /**
         * Chunk Data And Update Light
         * <p>
         * Supported Protocols: 757 - 774 (1.18.0 - 1.21.11)
         * <br>
         * Resource: minecraft:level_chunk_with_light (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * For older versions, see CHUNK_DATA instead.
         */
        CHUNK_DATA_AND_UPDATE_LIGHT,

        /**
         * Clear Dialog
         * <p>
         * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
         * <br>
         * Resource: minecraft:clear_dialog
         */
        CLEAR_DIALOG,

        /**
         * Clear Titles
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:clear_titles (767 - 774 (1.21.0 - 1.21.11))
         */
        CLEAR_TITLES,

        /**
         * Clientbound Keep Alive
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:keep_alive (767 - 774 (1.21.0 - 1.21.11))
         */
        CLIENTBOUND_KEEP_ALIVE,

        /**
         * Clientbound Plugin Message
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:custom_payload (767 - 774 (1.21.0 - 1.21.11))
         */
        CLIENTBOUND_PLUGIN_MESSAGE,

        /**
         * Close Container
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:container_close (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Close Window (clientbound)" in versions before 1.19 on the Minecraft wiki.
         */
        CLOSE_CONTAINER,

        /**
         * Combat Death
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:player_combat_kill (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Death Combat Event" in versions before 1.19 on the Minecraft wiki.
         */
        COMBAT_DEATH,

        /**
         * Commands
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:commands (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Declare Commands" in versions before 1.19 on the Minecraft wiki.
         */
        COMMANDS,

        /**
         * Command Suggestions Response
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:command_suggestions (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Tab-Complete (clientbound)" in versions before 1.19 on the Minecraft wiki.
         */
        COMMAND_SUGGESTIONS_RESPONSE,

        /**
         * Cookie Request
         * <p>
         * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
         * <br>
         * Resource: minecraft:cookie_request (767 - 774 (1.21.0 - 1.21.11))
         */
        COOKIE_REQUEST,

        /**
         * Custom Report Details
         * <p>
         * Supported Protocols: 767 - 774 (1.21.0 - 1.21.11)
         * <br>
         * Resource: minecraft:custom_report_details
         */
        CUSTOM_REPORT_DETAILS,

        /**
         * Custom Sound Effect
         * <p>
         * Supported Protocols: 755 - 760 (1.17.0 - 1.19.2)
         * <p>
         * This packet's functionality was merged into SOUND_EFFECT in the next version.
         * lso referred to as "Named Sound Effect" in versions before 1.19 on the Minecraft wiki.
         */
        CUSTOM_SOUND_EFFECT,

        /**
         * Damage Event
         * <p>
         * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
         * <br>
         * Resource: minecraft:damage_event (767 - 774 (1.21.0 - 1.21.11))
         */
        DAMAGE_EVENT,

        /**
         * Debug Block Value
         * <p>
         * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
         * <br>
         * Resource: minecraft:debug/block_value
         */
        DEBUG_BLOCK_VALUE,

        /**
         * Debug Chunk Value
         * <p>
         * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
         * <br>
         * Resource: minecraft:debug/chunk_value
         */
        DEBUG_CHUNK_VALUE,

        /**
         * Debug Entity Value
         * <p>
         * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
         * <br>
         * Resource: minecraft:debug/entity_value
         */
        DEBUG_ENTITY_VALUE,

        /**
         * Debug Event
         * <p>
         * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
         * <br>
         * Resource: minecraft:debug/event
         */
        DEBUG_EVENT,

        /**
         * Debug Sample
         * <p>
         * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
         * <br>
         * Resource: minecraft:debug_sample (767 - 774 (1.21.0 - 1.21.11))
         */
        DEBUG_SAMPLE,

        /**
         * Delete Message
         * <p>
         * Supported Protocols: 760 - 774 (1.19.1 - 1.21.11)
         * <br>
         * Resource: minecraft:delete_chat (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also known by the name "Hide Message" on the Minecraft wiki for 1.19.1/2 and prior.
         */
        DELETE_MESSAGE,

        /**
         * Disconnect
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:disconnect (767 - 774 (1.21.0 - 1.21.11))
         */
        DISCONNECT,

        /**
         * Disguised Chat Message
         * <p>
         * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
         * <br>
         * Resource: minecraft:disguised_chat (767 - 774 (1.21.0 - 1.21.11))
         */
        DISGUISED_CHAT_MESSAGE,

        /**
         * Display Objective
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_display_objective (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Related to the scoreboard.
         * Also referred to as "Display Scoreboard" in versions before 1.19 on the Minecraft wiki.
         */
        DISPLAY_OBJECTIVE,

        /**
         * End Combat
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:player_combat_end (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "End Combat Event" in versions before 1.19 on the Minecraft wiki.
         */
        END_COMBAT,

        /**
         * Enter Combat
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:player_combat_enter (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Enter Combat Event" in versions before 1.19 on the Minecraft wiki.
         */
        ENTER_COMBAT,

        /**
         * Entity Animation
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:animate (767 - 774 (1.21.0 - 1.21.11))
         */
        ENTITY_ANIMATION,

        /**
         * Entity Effect
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:update_mob_effect (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * For all potion/status effects.
         * Seems this is only for the client (player) to display effect durations, removing it has no effect on potion particles.
         * Set Entity Metadata packet might be responsible for those particles.
         */
        ENTITY_EFFECT,

        /**
         * Entity Event
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:entity_event (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Entity Status" in versions before 1.19 on the Minecraft wiki.
         */
        ENTITY_EVENT,

        /**
         * Entity Sound Effect
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:sound_entity (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * NOTE: Packet structure changed in protocol 761+ (1.19.3+) and again in protocol 767+ (1.21.0+)
         */
        ENTITY_SOUND_EFFECT,

        /**
         * Explosion
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:explode (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * NOTE: Packet structure changed in protocol 773+ (1.21.9+).
         */
        EXPLOSION,

        /**
         * Feature Flags
         * <p>
         * Supported Protocols: 761 - 763 (1.19.3 - 1.20.1)
         * <p>
         * Replaced by Configuration.FEATURE_FLAGS in protocol version 764+ (1.20.2+)
         */
        FEATURE_FLAGS,

        /**
         * Game Event
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:game_event (767 - 774 (1.21.0 - 1.21.11))
         */
        GAME_EVENT,

        /**
         * Game Test Highlight Pos
         * <p>
         * Supported Protocols: 773 - 774 (1.21.9 - 1.21.11)
         * <br>
         * Resource: minecraft:game_test_highlight_pos
         */
        GAME_TEST_HIGHLIGHT_POS,

        /**
         * Hurt Animation
         * <p>
         * Supported Protocols: 762 - 774 (1.19.4 - 1.21.11)
         * <br>
         * Resource: minecraft:hurt_animation (767 - 774 (1.21.0 - 1.21.11))
         */
        HURT_ANIMATION,

        /**
         * Initialize World Border
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:initialize_border (767 - 774 (1.21.0 - 1.21.11))
         */
        INITIALIZE_WORLD_BORDER,

        /**
         * Link Entities
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_entity_link (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Attach Entity" in versions before 1.19 on the Minecraft wiki.
         */
        LINK_ENTITIES,

        /**
         * Login
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:login (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Join Game" in versions before 1.19 on the Minecraft wiki.
         */
        LOGIN,

        /**
         * Look At
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:player_look_at (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Face" in versions before 1.19 on the Minecraft wiki.
         */
        LOOK_AT,

        /**
         * Map Data
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:map_item_data (767 - 774 (1.21.0 - 1.21.11))
         */
        MAP_DATA,

        /**
         * Merchant Offers
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:merchant_offers (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Trade List" in versions before 1.19 on the Minecraft wiki.
         */
        MERCHANT_OFFERS,

        /**
         * Message Header
         * <p>
         * Supported Protocol: 760 (1.19.1 - 1.19.2)
         */
        MESSAGE_HEADER,

        /**
         * Move Minecart Along Track
         * <p>
         * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
         * <br>
         * Resource: minecraft:move_minecart_along_track
         */
        MOVE_MINECART_ALONG_TRACK,

        /**
         * Move Vehicle
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:move_vehicle (767 - 774 (1.21.0 - 1.21.11))
         */
        MOVE_VEHICLE,

        /**
         * Open Book
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:open_book (767 - 774 (1.21.0 - 1.21.11))
         */
        OPEN_BOOK,

        /**
         * Open Horse Screen
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resources: minecraft:horse_screen_open (767 - 773 (1.21.0 - 1.21.10)), minecraft:mount_screen_open (774 (1.21.11))
         */
        OPEN_HORSE_SCREEN,

        /**
         * Open Screen
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:open_screen (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Open Window" in versions before 1.19 on the Minecraft wiki.
         */
        OPEN_SCREEN,

        /**
         * Open Sign Editor
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:open_sign_editor (767 - 774 (1.21.0 - 1.21.11))
         */
        OPEN_SIGN_EDITOR,

        /**
         * Particle
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:level_particles (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * NOTE: Packet structure changed since protocol 769+ (1.21.4+). New field alwaysVisible.
         * NOTE: Packet structure changed since protocol 767+ (1.21.0+). Particle ID field moved to the end just before the Data field
         */
        PARTICLE,

        /**
         * Pickup Item
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:take_item_entity (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Collect Item" in versions before 1.19 on the Minecraft wiki.
         * This packet is purely for the animation of an item being picked up by an entity.
         */
        PICKUP_ITEM,

        /**
         * Ping
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:ping (767 - 774 (1.21.0 - 1.21.11))
         */
        PING,

        /**
         * Ping Response
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:pong_response (767 - 774 (1.21.0 - 1.21.11))
         */
        PING_RESPONSE,

        /**
         * Place Ghost Recipe
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:place_ghost_recipe (767 - 774 (1.21.0 - 1.21.11))
         */
        PLACE_GHOST_RECIPE,

        /**
         * Player Abilities
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:player_abilities (767 - 774 (1.21.0 - 1.21.11))
         */
        PLAYER_ABILITIES,

        /**
         * Player Chat Message
         * <p>
         * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
         * <br>
         * Resource: minecraft:player_chat (767 - 774 (1.21.0 - 1.21.11))
         */
        PLAYER_CHAT_MESSAGE,

        /**
         * Player Info Remove
         * <p>
         * Supported Protocols: 761 - 774 (1.19.3 - 1.21.11)
         * <br>
         * Resource: minecraft:player_info_remove (767 - 774 (1.21.0 - 1.21.11))
         */
        PLAYER_INFO_REMOVE,

        /**
         * Player Info Update
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:player_info_update (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also known by the name "Player Info" on the Minecraft wiki for 1.19.1/2 and prior.
         */
        PLAYER_INFO_UPDATE,

        /**
         * Player Rotation
         * <p>
         * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
         * <br>
         * Resource: minecraft:player_rotation
         * <p>
         * NOTE: Packet structure changed in protocol 773+ (1.21.9+).
         */
        PLAYER_ROTATION,

        /**
         * Projectile Power
         * <p>
         * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
         * <br>
         * Resource: minecraft:projectile_power (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * NOTE: Packet structure changed since protocol 767+ (1.21.0+). Power XYZ fields reduced to single Power field.
         */
        PROJECTILE_POWER,

        /**
         * Recipe Book Add
         * <p>
         * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
         * <br>
         * Resource: minecraft:recipe_book_add
         */
        RECIPE_BOOK_ADD,

        /**
         * Recipe Book Remove
         * <p>
         * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
         * <br>
         * Resource: minecraft:recipe_book_remove
         */
        RECIPE_BOOK_REMOVE,

        /**
         * Recipe Book Settings
         * <p>
         * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
         * <br>
         * Resource: minecraft:recipe_book_settings
         */
        RECIPE_BOOK_SETTINGS,

        /**
         * Remove Entities
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:remove_entities (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * NOTE: Packet structure changed in protocol 756+ (1.17.1+).
         * Also referred to as "Destroy Entities" in versions 1.17.1 to 1.19 on the Minecraft wiki and "Destroy Entity" for 1.17 and prior.
         */
        REMOVE_ENTITIES,

        /**
         * Remove Entity Effect
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:remove_mob_effect (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * For all potion/status effects. Also see PacketType.Play.ENTITY_EFFECT
         */
        REMOVE_ENTITY_EFFECT,

        /**
         * Remove Resource Pack
         * <p>
         * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
         * <br>
         * Resource: minecraft:resource_pack_pop (767 - 774 (1.21.0 - 1.21.11))
         */
        REMOVE_RESOURCE_PACK,

        /**
         * Reset Score
         * <p>
         * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
         * <br>
         * Resource: minecraft:reset_score (767 - 774 (1.21.0 - 1.21.11))
         */
        RESET_SCORE,

        /**
         * Respawn
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:respawn (767 - 774 (1.21.0 - 1.21.11))
         */
        RESPAWN,

        /**
         * Sculk Vibration Signal
         * <p>
         * Supported Protocols: 755 - 758 (1.17.0 - 1.18.2)
         */
        SCULK_VIBRATION_SIGNAL,

        /**
         * Select Advancements Tab
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:select_advancements_tab (767 - 774 (1.21.0 - 1.21.11))
         */
        SELECT_ADVANCEMENTS_TAB,

        /**
         * Server Data
         * <p>
         * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
         * <br>
         * Resource: minecraft:server_data (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Used for server MOTD & Icon.
         */
        SERVER_DATA,

        /**
         * Server Links
         * <p>
         * Supported Protocols: 767 - 774 (1.21.0 - 1.21.11)
         * <br>
         * Resource: minecraft:server_links
         */
        SERVER_LINKS,

        /**
         * Set Action Bar Text
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_action_bar_text (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Action Bar" in versions before 1.19 on the Minecraft wiki.
         */
        SET_ACTION_BAR_TEXT,

        /**
         * Set Block Destroy Stage
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:block_destruction (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Block Break Animation" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BLOCK_DESTROY_STAGE,

        /**
         * Set Border Center
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_border_center (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "World Border Center" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BORDER_CENTER,

        /**
         * Set Border Lerp Size
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_border_lerp_size (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "World Border Lerp Size" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BORDER_LERP_SIZE,

        /**
         * Set Border Size
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_border_size (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "World Border Size" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BORDER_SIZE,

        /**
         * Set Border Warning Delay
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_border_warning_delay (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "World Border Warning Delay" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BORDER_WARNING_DELAY,

        /**
         * Set Border Warning Distance
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_border_warning_distance (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "World Border Warning Reach" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BORDER_WARNING_DISTANCE,

        /**
         * Set Camera
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_camera (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Camera" in versions before 1.19 on the Minecraft wiki.
         * Packet used for setting the player to spectate an entity.
         */
        SET_CAMERA,

        /**
         * Set Center Chunk
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_chunk_cache_center (767 - 774 (1.21.0 - 1.21.11))
         */
        SET_CENTER_CHUNK,

        /**
         * Set Container Content
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:container_set_content (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Window Items" in versions before 1.19 on the Minecraft wiki.
         */
        SET_CONTAINER_CONTENT,

        /**
         * Set Container Property
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:container_set_data (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Window Property" in versions before 1.19 on the Minecraft wiki.
         */
        SET_CONTAINER_PROPERTY,

        /**
         * Set Container Slot
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:container_set_slot (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Set Slot" in versions before 1.19 on the Minecraft wiki.
         */
        SET_CONTAINER_SLOT,

        /**
         * Set Cooldown
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:cooldown (767 - 774 (1.21.0 - 1.21.11))
         */
        SET_COOLDOWN,

        /**
         * Set Cursor Item
         * <p>
         * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
         * <br>
         * Resource: minecraft:set_cursor_item
         */
        SET_CURSOR_ITEM,

        /**
         * Set Default Spawn Position
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_default_spawn_position (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Spawn Position" in versions before 1.19 on the Minecraft wiki.
         */
        SET_DEFAULT_SPAWN_POSITION,

        /**
         * Set Display Chat Preview
         * <p>
         * Supported Protocols: 759 - 760 (1.19.0 - 1.19.2)
         */
        SET_DISPLAY_CHAT_PREVIEW,

        /**
         * Set Entity Metadata
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_entity_data (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Entity Metadata" in versions before 1.19 on the Minecraft wiki.
         */
        SET_ENTITY_METADATA,

        /**
         * Set Entity Velocity
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_entity_motion (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Entity Velocity" in versions before 1.19 on the Minecraft wiki.NOTE: Packet structure changed in protocol 773+ (1.21.9+).
         */
        SET_ENTITY_VELOCITY,

        /**
         * Set Equipment
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_equipment (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Entity Equipment" in versions before 1.19 on the Minecraft wiki.
         */
        SET_EQUIPMENT,

        /**
         * Set Experience
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_experience (767 - 774 (1.21.0 - 1.21.11))
         */
        SET_EXPERIENCE,

        /**
         * Set Head Rotation
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:rotate_head (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Entity Head Look" in versions before 1.19 on the Minecraft wiki.
         */
        SET_HEAD_ROTATION,

        /**
         * Set Health
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_health (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Update Health" in versions before 1.19 on the Minecraft wiki.
         */
        SET_HEALTH,

        /**
         * Set Held Item
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resources: minecraft:set_carried_item (767 (1.21.0 - 1.21.1)), minecraft:set_held_slot (768 - 774 (1.21.2 - 1.21.11))
         * <p>
         * Also referred to as "Held Item Change (clientbound)" in versions before 1.19 on the Minecraft wiki.
         */
        SET_HELD_ITEM,

        /**
         * Set Passengers
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_passengers (767 - 774 (1.21.0 - 1.21.11))
         */
        SET_PASSENGERS,

        /**
         * Set Player Inventory Slot
         * <p>
         * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
         * <br>
         * Resource: minecraft:set_player_inventory
         */
        SET_PLAYER_INVENTORY_SLOT,

        /**
         * Set Render Distance
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_chunk_cache_radius (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Update View Distance" in versions before 1.19 on the Minecraft wiki.
         */
        SET_RENDER_DISTANCE,

        /**
         * Set Simulation Distance
         * <p>
         * Supported Protocols: 757 - 774 (1.18.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_simulation_distance (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Update Simulation Distance" in versions before 1.19 on the Minecraft wiki.
         */
        SET_SIMULATION_DISTANCE,

        /**
         * Set Subtitle Text
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_subtitle_text (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Set Title SubTitle" in versions before 1.19 on the Minecraft wiki.
         */
        SET_SUBTITLE_TEXT,

        /**
         * Set Tab List Header And Footer
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:tab_list (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Player List Header And Footer" in versions before 1.19 on the Minecraft wiki.
         */
        SET_TAB_LIST_HEADER_AND_FOOTER,

        /**
         * Set Ticking State
         * <p>
         * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
         * <br>
         * Resource: minecraft:ticking_state (767 - 774 (1.21.0 - 1.21.11))
         */
        SET_TICKING_STATE,

        /**
         * Set Title Animation Times
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_titles_animation (767 - 774 (1.21.0 - 1.21.11))
         */
        SET_TITLE_ANIMATION_TIMES,

        /**
         * Set Title Text
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_title_text (767 - 774 (1.21.0 - 1.21.11))
         */
        SET_TITLE_TEXT,

        /**
         * Show Dialog
         * <p>
         * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
         * <br>
         * Resource: minecraft:show_dialog
         */
        SHOW_DIALOG,

        /**
         * Sound Effect
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:sound (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * NOTE: Packet structure changed in protocol 761+ (1.19.3+).
         * NOTE: Packet structure changed in protocol 767+ (1.21.0+).
         */
        SOUND_EFFECT,

        /**
         * Spawn Entity
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:add_entity (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * NOTE: Packet structure changed in protocol 759+ (1.19.0+).
         * NOTE: Packet structure changed in protocol 773+ (1.21.9+).
         */
        SPAWN_ENTITY,

        /**
         * Spawn Experience Orb
         * <p>
         * Supported Protocols: 755 - 769 (1.17.0 - 1.21.4)
         * <br>
         * Resource: minecraft:add_experience_orb (767 - 769 (1.21.0 - 1.21.4))
         */
        SPAWN_EXPERIENCE_ORB,

        /**
         * Spawn Living Entity
         * <p>
         * Supported Protocols: 755 - 758 (1.17.0 - 1.18.2)
         */
        SPAWN_LIVING_ENTITY,

        /**
         * Spawn Painting
         * <p>
         * Supported Protocols: 755 - 758 (1.17.0 - 1.18.2)
         */
        SPAWN_PAINTING,

        /**
         * Spawn Player
         * <p>
         * Supported Protocols: 755 - 763 (1.17.0 - 1.20.1)
         */
        SPAWN_PLAYER,

        /**
         * Start Configuration
         * <p>
         * Supported Protocols: 764 - 774 (1.20.2 - 1.21.11)
         * <br>
         * Resource: minecraft:start_configuration (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Switches the protocol state to Configuration. Unsupported in protocol versions 763 (1.20.0/1) and older.
         */
        START_CONFIGURATION,

        /**
         * Step Tick
         * <p>
         * Supported Protocols: 765 - 774 (1.20.3 - 1.21.11)
         * <br>
         * Resource: minecraft:ticking_step (767 - 774 (1.21.0 - 1.21.11))
         */
        STEP_TICK,

        /**
         * Stop Sound
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:stop_sound (767 - 774 (1.21.0 - 1.21.11))
         */
        STOP_SOUND,

        /**
         * Store Cookie
         * <p>
         * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
         * <br>
         * Resource: minecraft:store_cookie (767 - 774 (1.21.0 - 1.21.11))
         */
        STORE_COOKIE,

        /**
         * Synchronize Player Position
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:player_position (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Player Position And Look (clientbound)" in versions before 1.19 on the Minecraft wiki.
         */
        SYNCHRONIZE_PLAYER_POSITION,

        /**
         * Synchronize Vehicle Position
         * <p>
         * Supported Protocols: 768 - 774 (1.21.2 - 1.21.11)
         * <br>
         * Resource: minecraft:teleport_entity
         */
        SYNCHRONIZE_VEHICLE_POSITION,

        /**
         * System Chat Message
         * <p>
         * Supported Protocols: 759 - 774 (1.19.0 - 1.21.11)
         * <br>
         * Resource: minecraft:system_chat (767 - 774 (1.21.0 - 1.21.11))
         */
        SYSTEM_CHAT_MESSAGE,

        /**
         * Tag Query Response
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:tag_query (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "NBT Query Response" in versions before 1.19 on the Minecraft wiki.
         */
        TAG_QUERY_RESPONSE,

        /**
         * Teleport Entity
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resources: minecraft:teleport_entity (767 (1.21.0 - 1.21.1)), minecraft:entity_position_sync (768 - 774 (1.21.2 - 1.21.11))
         * <p>
         * Also referred to as "Entity Teleport" in versions before 1.19 on the Minecraft wiki.
         * NOTE: Packet structure changed since protocol 768+ (1.21.2+). New fields for velocity and yaw/pitch.
         */
        TELEPORT_ENTITY,

        /**
         * Test Instance Block Status
         * <p>
         * Supported Protocols: 770 - 774 (1.21.5 - 1.21.11)
         * <br>
         * Resource: minecraft:test_instance_block_status
         */
        TEST_INSTANCE_BLOCK_STATUS,

        /**
         * Transfer
         * <p>
         * Supported Protocols: 766 - 774 (1.20.5 - 1.21.11)
         * <br>
         * Resource: minecraft:transfer (767 - 774 (1.21.0 - 1.21.11))
         */
        TRANSFER,

        /**
         * Unload Chunk
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:forget_level_chunk (767 - 774 (1.21.0 - 1.21.11))
         */
        UNLOAD_CHUNK,

        /**
         * Update Advancements
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:update_advancements (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Advancements" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_ADVANCEMENTS,

        /**
         * Update Attributes
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:update_attributes (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Entity Properties" in versions before 1.19 on the Minecraft wiki.
         * NOTE: A data field changed in 766+ (1.20.5).
         */
        UPDATE_ATTRIBUTES,

        /**
         * Update Entity Position
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:move_entity_pos (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Entity Position" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_ENTITY_POSITION,

        /**
         * Update Entity Position And Rotation
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:move_entity_pos_rot (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Entity Position and Rotation" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_ENTITY_POSITION_AND_ROTATION,

        /**
         * Update Entity Rotation
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:move_entity_rot (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Entity Rotation" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_ENTITY_ROTATION,

        /**
         * Update Light
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:light_update (767 - 774 (1.21.0 - 1.21.11))
         */
        UPDATE_LIGHT,

        /**
         * Update Objectives
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_objective (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Related to the scoreboard.
         * Also referred to as "Scoreboard Objective" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_OBJECTIVES,

        /**
         * Update Recipes
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:update_recipes (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Declare Recipes" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_RECIPES,

        /**
         * Update Recipe Book
         * <p>
         * Supported Protocols: 755 - 767 (1.17.0 - 1.21.1)
         * <br>
         * Resource: minecraft:recipe (767 (1.21.0 - 1.21.1))
         * <p>
         * Also referred to as "Unlock Recipes" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_RECIPE_BOOK,

        /**
         * Update Score
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_score (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Related to the scoreboard.
         */
        UPDATE_SCORE,

        /**
         * Update Section Blocks
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:section_blocks_update (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Multi Block Change" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_SECTION_BLOCKS,

        /**
         * Update Tags
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:update_tags (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Tags" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_TAGS,

        /**
         * Update Teams
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_player_team (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Related to the scoreboard.
         * Also referred to as "Teams" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_TEAMS,

        /**
         * Update Time
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:set_time (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Time Update" in versions before 1.19 on the Minecraft wiki.
         * NOTE: Packet structure changed since protocol 768+ (1.21.2+). New field timeAdvances (timeOfDayIncreasing)
         */
        UPDATE_TIME,

        /**
         * Waypoint
         * <p>
         * Supported Protocols: 771 - 774 (1.21.6 - 1.21.11)
         * <br>
         * Resource: minecraft:waypoint
         */
        WAYPOINT,

        /**
         * World Event
         * <p>
         * Supported Protocols: 755 - 774 (1.17.0 - 1.21.11)
         * <br>
         * Resource: minecraft:level_event (767 - 774 (1.21.0 - 1.21.11))
         * <p>
         * Also referred to as "Effect" in versions before 1.19 on the Minecraft wiki.
         * NOTE: Packet structure changed from 1.13.x to 1.14.x.
         * The position field is encoded as XYZ in 1.13.x and older, while it is encoded as XZY in 1.14.x+
         */
        WORLD_EVENT;


        Play() {
            this.metadata = new TypeMetadata<Play>(this, new String[]{TypeMetadata.JSON_NODE_PROTOCOL, TypeMetadata.JSON_NODE_PACKETS, TypeMetadata.JSON_NODE_STATE_PLAY, this.name().toLowerCase()});
        }

        private final TypeMetadata<Play> metadata;

        @Override
        public ProtocolState getProtocolState() {
            return ProtocolState.PLAY;
        }

        @Override
        public TypeMetadata<Play> getMetadata() {
            return this.metadata;
        }

    }


}
