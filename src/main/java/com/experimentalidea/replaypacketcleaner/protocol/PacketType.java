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
     * @return The protocol state.
     * */
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
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:resource_pack_push (767 - 773 (1.21.0 - 1.21.10))
         */
        ADD_RESOURCE_PACK,

        /**
         * Clear Dialog
         * <br> Supported Protocols: 771 - 773 (1.21.6 - 1.21.10)
         * <br> Resource: minecraft:clear_dialog
         */
        CLEAR_DIALOG,

        /**
         * Clientbound Keep Alive
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:keep_alive (767 - 773 (1.21.0 - 1.21.10))
         */
        CLIENTBOUND_KEEP_ALIVE,

        /**
         * Clientbound Known Packs
         * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
         * <br> Resource: minecraft:select_known_packs (767 - 773 (1.21.0 - 1.21.10))
         */
        CLIENTBOUND_KNOWN_PACKS,

        /**
         * Clientbound Plugin Message
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:custom_payload (767 - 773 (1.21.0 - 1.21.10))
         */
        CLIENTBOUND_PLUGIN_MESSAGE,

        /**
         * Code Of Conduct
         * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
         * <br> Resource: minecraft:code_of_conduct
         */
        CODE_OF_CONDUCT,

        /**
         * Cookie Request
         * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
         * <br> Resource: minecraft:cookie_request (767 - 773 (1.21.0 - 1.21.10))
         */
        COOKIE_REQUEST,

        /**
         * Custom Report Details
         * <br> Supported Protocols: 767 - 773 (1.21.0 - 1.21.10)
         * <br> Resource: minecraft:custom_report_details
         */
        CUSTOM_REPORT_DETAILS,

        /**
         * Disconnect
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:disconnect (767 - 773 (1.21.0 - 1.21.10))
         */
        DISCONNECT,

        /**
         * Feature Flags
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:update_enabled_features (767 - 773 (1.21.0 - 1.21.10))
         */
        FEATURE_FLAGS,

        /**
         * Finish Configuration
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:finish_configuration (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Switches the protocol state to PLAY in protocol versions 764 (1.20.2) and later.
         * For protocol versions 763 (1.20.1) and earlier, see PacketType.Login.LOGIN_SUCCESS.
         */
        FINISH_CONFIGURATION,

        /**
         * Ping
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:ping (767 - 773 (1.21.0 - 1.21.10))
         */
        PING,

        /**
         * Registry Data
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:registry_data (767 - 773 (1.21.0 - 1.21.10))
         */
        REGISTRY_DATA,

        /**
         * Remove Resource Pack
         * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
         * <br> Resource: minecraft:resource_pack_pop (767 - 773 (1.21.0 - 1.21.10))
         */
        REMOVE_RESOURCE_PACK,

        /**
         * Reset Chat
         * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
         * <br> Resource: minecraft:reset_chat (767 - 773 (1.21.0 - 1.21.10))
         */
        RESET_CHAT,

        /**
         * Server Links
         * <br> Supported Protocols: 767 - 773 (1.21.0 - 1.21.10)
         * <br> Resource: minecraft:server_links
         */
        SERVER_LINKS,

        /**
         * Show Dialog
         * <br> Supported Protocols: 771 - 773 (1.21.6 - 1.21.10)
         * <br> Resource: minecraft:show_dialog
         */
        SHOW_DIALOG,

        /**
         * Store Cookie
         * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
         * <br> Resource: minecraft:store_cookie (767 - 773 (1.21.0 - 1.21.10))
         */
        STORE_COOKIE,

        /**
         * Transfer
         * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
         * <br> Resource: minecraft:transfer (767 - 773 (1.21.0 - 1.21.10))
         */
        TRANSFER,

        /**
         * Update Tags
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:update_tags (767 - 773 (1.21.0 - 1.21.10))
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
         * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
         * <br> Resource: minecraft:cookie_request (767 - 773 (1.21.0 - 1.21.10))
         */
        COOKIE_REQUEST,

        /**
         * Disconnect
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:login_disconnect (767 - 773 (1.21.0 - 1.21.10))
         */
        DISCONNECT,

        /**
         * Encryption Request
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:hello (767 - 773 (1.21.0 - 1.21.10))
         */
        ENCRYPTION_REQUEST,

        /**
         * Login Plugin Request
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:custom_query (767 - 773 (1.21.0 - 1.21.10))
         */
        LOGIN_PLUGIN_REQUEST,

        /**
         * Login Success
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resources: minecraft:game_profile (767 (1.21.0 - 1.21.1)), minecraft:login_finished (768 - 773 (1.21.2 - 1.21.10))
         * <br>
         * <br> Switches the protocol state to PLAY in protocol versions 763 (1.20.1) and earlier.
         * For protocol versions 764+ (1.20.2), see PacketType.Configuration.FINISH_CONFIGURATION.
         */
        LOGIN_SUCCESS,

        /**
         * Set Compression
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:login_compression (767 - 773 (1.21.0 - 1.21.10))
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
         * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
         * <br> Resource: minecraft:block_changed_ack (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Likely exists as a replacement for ACKNOWLEDGE_PLAYER_DIGGING, although the packet structure is completely different.
         */
        ACKNOWLEDGE_BLOCK_CHANGE,

        /**
         * Acknowledge Player Digging
         * <br> Supported Protocols: 755 - 758 (1.17.0 - 1.18.2)
         * <br>
         * <br> Appears ACKNOWLEDGE_BLOCK_CHANGE serves as a replacement for this packet type in newer versions.
         */
        ACKNOWLEDGE_PLAYER_DIGGING,

        /**
         * Add Resource Pack
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:resource_pack_push (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Resource Pack Send" in versions before 1.19 on the Minecraft wiki.
         */
        ADD_RESOURCE_PACK,

        /**
         * Award Statistics
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:award_stats (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Statistics" in versions before 1.19 on the Minecraft wiki.
         */
        AWARD_STATISTICS,

        /**
         * Block Action
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:block_event (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> NOTE: Packet structure changed from 1.13.x to 1.14.x.
         * The position field is encoded as XYZ in 1.13.x and older, while it is encoded as XZY in 1.14.x+
         */
        BLOCK_ACTION,

        /**
         * Block Entity Data
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:block_entity_data (767 - 773 (1.21.0 - 1.21.10))
         */
        BLOCK_ENTITY_DATA,

        /**
         * Block Update
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:block_update (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Block Change" in versions before 1.19 on the Minecraft wiki.
         */
        BLOCK_UPDATE,

        /**
         * Boss Bar
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:boss_event (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> TODO: note for implementing packet: The Enum fields Action, Color, & TypeOfDivision appear to be the same for all protocol versions. (when quickly comparing 1.12 to 1.21.8)
         */
        BOSS_BAR,

        /**
         * Bundle Delimiter
         * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
         * <br> Resource: minecraft:bundle_delimiter (767 - 773 (1.21.0 - 1.21.10))
         */
        BUNDLE_DELIMITER,

        /**
         * Change Difficulty
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:change_difficulty (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Server Difficulty" in versions before 1.19 on the Minecraft wiki.
         */
        CHANGE_DIFFICULTY,

        /**
         * Chat Message
         * <br> Supported Protocols: 755 - 758 (1.17.0 - 1.18.2)
         */
        CHAT_MESSAGE,

        /**
         * Chat Preview
         * <br> Supported Protocols: 759 - 760 (1.19.0 - 1.19.2)
         */
        CHAT_PREVIEW,

        /**
         * Chat Suggestions
         * <br> Supported Protocols: 760 - 773 (1.19.1 - 1.21.10)
         * <br> Resource: minecraft:custom_chat_completions (767 - 773 (1.21.0 - 1.21.10))
         */
        CHAT_SUGGESTIONS,

        /**
         * Chunk Batch Finished
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:chunk_batch_finished (767 - 773 (1.21.0 - 1.21.10))
         */
        CHUNK_BATCH_FINISHED,

        /**
         * Chunk Batch Start
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:chunk_batch_start (767 - 773 (1.21.0 - 1.21.10))
         */
        CHUNK_BATCH_START,

        /**
         * Chunk Biomes
         * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
         * <br> Resource: minecraft:chunks_biomes (767 - 773 (1.21.0 - 1.21.10))
         */
        CHUNK_BIOMES,

        /**
         * Chunk Data
         * <br> Supported Protocols: 755 - 756 (1.17.0 - 1.17.1)
         * <br>
         * <br> Replaced by CHUNK_DATA_AND_UPDATE_LIGHT in newer versions
         */
        CHUNK_DATA,

        /**
         * Chunk Data And Update Light
         * <br> Supported Protocols: 757 - 773 (1.18.0 - 1.21.10)
         * <br> Resource: minecraft:level_chunk_with_light (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> For older versions, see CHUNK_DATA instead.
         */
        CHUNK_DATA_AND_UPDATE_LIGHT,

        /**
         * Clear Dialog
         * <br> Supported Protocols: 771 - 773 (1.21.6 - 1.21.10)
         * <br> Resource: minecraft:clear_dialog
         */
        CLEAR_DIALOG,

        /**
         * Clear Titles
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:clear_titles (767 - 773 (1.21.0 - 1.21.10))
         */
        CLEAR_TITLES,

        /**
         * Clientbound Keep Alive
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:keep_alive (767 - 773 (1.21.0 - 1.21.10))
         */
        CLIENTBOUND_KEEP_ALIVE,

        /**
         * Clientbound Plugin Message
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:custom_payload (767 - 773 (1.21.0 - 1.21.10))
         */
        CLIENTBOUND_PLUGIN_MESSAGE,

        /**
         * Close Container
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:container_close (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Close Window (clientbound)" in versions before 1.19 on the Minecraft wiki.
         */
        CLOSE_CONTAINER,

        /**
         * Combat Death
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:player_combat_kill (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Death Combat Event" in versions before 1.19 on the Minecraft wiki.
         */
        COMBAT_DEATH,

        /**
         * Commands
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:commands (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Declare Commands" in versions before 1.19 on the Minecraft wiki.
         */
        COMMANDS,

        /**
         * Command Suggestions Response
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:command_suggestions (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Tab-Complete (clientbound)" in versions before 1.19 on the Minecraft wiki.
         */
        COMMAND_SUGGESTIONS_RESPONSE,

        /**
         * Cookie Request
         * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
         * <br> Resource: minecraft:cookie_request (767 - 773 (1.21.0 - 1.21.10))
         */
        COOKIE_REQUEST,

        /**
         * Custom Report Details
         * <br> Supported Protocols: 767 - 773 (1.21.0 - 1.21.10)
         * <br> Resource: minecraft:custom_report_details
         */
        CUSTOM_REPORT_DETAILS,

        /**
         * Custom Sound Effect
         * <br> Supported Protocols: 755 - 760 (1.17.0 - 1.19.2)
         * <br>
         * <br> This packet's functionality was merged into SOUND_EFFECT in the next version.
         * lso referred to as "Named Sound Effect" in versions before 1.19 on the Minecraft wiki.
         */
        CUSTOM_SOUND_EFFECT,

        /**
         * Damage Event
         * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
         * <br> Resource: minecraft:damage_event (767 - 773 (1.21.0 - 1.21.10))
         */
        DAMAGE_EVENT,

        /**
         * Debug Block Value
         * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
         * <br> Resource: minecraft:debug/block_value
         */
        DEBUG_BLOCK_VALUE,

        /**
         * Debug Chunk Value
         * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
         * <br> Resource: minecraft:debug/chunk_value
         */
        DEBUG_CHUNK_VALUE,

        /**
         * Debug Entity Value
         * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
         * <br> Resource: minecraft:debug/entity_value
         */
        DEBUG_ENTITY_VALUE,

        /**
         * Debug Event
         * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
         * <br> Resource: minecraft:debug/event
         */
        DEBUG_EVENT,

        /**
         * Debug Sample
         * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
         * <br> Resource: minecraft:debug_sample (767 - 773 (1.21.0 - 1.21.10))
         */
        DEBUG_SAMPLE,

        /**
         * Delete Message
         * <br> Supported Protocols: 760 - 773 (1.19.1 - 1.21.10)
         * <br> Resource: minecraft:delete_chat (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also known by the name "Hide Message" on the Minecraft wiki for 1.19.1/2 and prior.
         */
        DELETE_MESSAGE,

        /**
         * Disconnect
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:disconnect (767 - 773 (1.21.0 - 1.21.10))
         */
        DISCONNECT,

        /**
         * Disguised Chat Message
         * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
         * <br> Resource: minecraft:disguised_chat (767 - 773 (1.21.0 - 1.21.10))
         */
        DISGUISED_CHAT_MESSAGE,

        /**
         * Display Objective
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_display_objective (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Related to the scoreboard.
         * Also referred to as "Display Scoreboard" in versions before 1.19 on the Minecraft wiki.
         */
        DISPLAY_OBJECTIVE,

        /**
         * End Combat
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:player_combat_end (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "End Combat Event" in versions before 1.19 on the Minecraft wiki.
         */
        END_COMBAT,

        /**
         * Enter Combat
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:player_combat_enter (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Enter Combat Event" in versions before 1.19 on the Minecraft wiki.
         */
        ENTER_COMBAT,

        /**
         * Entity Animation
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:animate (767 - 773 (1.21.0 - 1.21.10))
         */
        ENTITY_ANIMATION,

        /**
         * Entity Effect
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:update_mob_effect (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> For all potion/status effects.
         * Seems this is only for the client (player) to display effect durations, removing it has no effect on potion particles.
         * Set Entity Metadata packet might be responsible for those particles.
         */
        ENTITY_EFFECT,

        /**
         * Entity Event
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:entity_event (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Entity Status" in versions before 1.19 on the Minecraft wiki.
         */
        ENTITY_EVENT,

        /**
         * Entity Sound Effect
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:sound_entity (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> NOTE: Packet structure changed in protocol 761+ (1.19.3+) and again in protocol 767+ (1.21.0+)
         */
        ENTITY_SOUND_EFFECT,

        /**
         * Explosion
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:explode (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> NOTE: Packet structure changed in protocol 773+ (1.21.9+).
         */
        EXPLOSION,

        /**
         * Feature Flags
         * <br> Supported Protocols: 761 - 763 (1.19.3 - 1.20.1)
         * <br>
         * <br> Replaced by Configuration.FEATURE_FLAGS in protocol version 764+ (1.20.2+)
         */
        FEATURE_FLAGS,

        /**
         * Game Event
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:game_event (767 - 773 (1.21.0 - 1.21.10))
         */
        GAME_EVENT,

        /**
         * Game Test Highlight Pos
         * <br> Supported Protocol: 773 (1.21.9 - 1.21.10)
         * <br> Resource: minecraft:game_test_highlight_pos
         */
        GAME_TEST_HIGHLIGHT_POS,

        /**
         * Hurt Animation
         * <br> Supported Protocols: 762 - 773 (1.19.4 - 1.21.10)
         * <br> Resource: minecraft:hurt_animation (767 - 773 (1.21.0 - 1.21.10))
         */
        HURT_ANIMATION,

        /**
         * Initialize World Border
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:initialize_border (767 - 773 (1.21.0 - 1.21.10))
         */
        INITIALIZE_WORLD_BORDER,

        /**
         * Link Entities
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_entity_link (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Attach Entity" in versions before 1.19 on the Minecraft wiki.
         */
        LINK_ENTITIES,

        /**
         * Login
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:login (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Join Game" in versions before 1.19 on the Minecraft wiki.
         */
        LOGIN,

        /**
         * Look At
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:player_look_at (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Face" in versions before 1.19 on the Minecraft wiki.
         */
        LOOK_AT,

        /**
         * Map Data
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:map_item_data (767 - 773 (1.21.0 - 1.21.10))
         */
        MAP_DATA,

        /**
         * Merchant Offers
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:merchant_offers (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Trade List" in versions before 1.19 on the Minecraft wiki.
         */
        MERCHANT_OFFERS,

        /**
         * Message Header
         * <br> Supported Protocol: 760 (1.19.1 - 1.19.2)
         */
        MESSAGE_HEADER,

        /**
         * Move Minecart Along Track
         * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
         * <br> Resource: minecraft:move_minecart_along_track
         */
        MOVE_MINECART_ALONG_TRACK,

        /**
         * Move Vehicle
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:move_vehicle (767 - 773 (1.21.0 - 1.21.10))
         */
        MOVE_VEHICLE,

        /**
         * Open Book
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:open_book (767 - 773 (1.21.0 - 1.21.10))
         */
        OPEN_BOOK,

        /**
         * Open Horse Screen
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:horse_screen_open (767 - 773 (1.21.0 - 1.21.10))
         */
        OPEN_HORSE_SCREEN,

        /**
         * Open Screen
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:open_screen (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Open Window" in versions before 1.19 on the Minecraft wiki.
         */
        OPEN_SCREEN,

        /**
         * Open Sign Editor
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:open_sign_editor (767 - 773 (1.21.0 - 1.21.10))
         */
        OPEN_SIGN_EDITOR,

        /**
         * Particle
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:level_particles (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> NOTE: Packet structure changed since protocol 769+ (1.21.4+). New field alwaysVisible.
         * NOTE: Packet structure changed since protocol 767+ (1.21.0+). Particle ID field moved to the end just before the Data field
         */
        PARTICLE,

        /**
         * Pickup Item
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:take_item_entity (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Collect Item" in versions before 1.19 on the Minecraft wiki.
         * This packet is purely for the animation of an item being picked up by an entity.
         */
        PICKUP_ITEM,

        /**
         * Ping
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:ping (767 - 773 (1.21.0 - 1.21.10))
         */
        PING,

        /**
         * Ping Response
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:pong_response (767 - 773 (1.21.0 - 1.21.10))
         */
        PING_RESPONSE,

        /**
         * Place Ghost Recipe
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:place_ghost_recipe (767 - 773 (1.21.0 - 1.21.10))
         */
        PLACE_GHOST_RECIPE,

        /**
         * Player Abilities
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:player_abilities (767 - 773 (1.21.0 - 1.21.10))
         */
        PLAYER_ABILITIES,

        /**
         * Player Chat Message
         * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
         * <br> Resource: minecraft:player_chat (767 - 773 (1.21.0 - 1.21.10))
         */
        PLAYER_CHAT_MESSAGE,

        /**
         * Player Info Remove
         * <br> Supported Protocols: 761 - 773 (1.19.3 - 1.21.10)
         * <br> Resource: minecraft:player_info_remove (767 - 773 (1.21.0 - 1.21.10))
         */
        PLAYER_INFO_REMOVE,

        /**
         * Player Info Update
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:player_info_update (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also known by the name "Player Info" on the Minecraft wiki for 1.19.1/2 and prior.
         */
        PLAYER_INFO_UPDATE,

        /**
         * Player Rotation
         * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
         * <br> Resource: minecraft:player_rotation
         * <br>
         * <br> NOTE: Packet structure changed in protocol 773+ (1.21.9+).
         */
        PLAYER_ROTATION,

        /**
         * Projectile Power
         * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
         * <br> Resource: minecraft:projectile_power (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> NOTE: Packet structure changed since protocol 767+ (1.21.0+). Power XYZ fields reduced to single Power field.
         */
        PROJECTILE_POWER,

        /**
         * Recipe Book Add
         * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
         * <br> Resource: minecraft:recipe_book_add
         */
        RECIPE_BOOK_ADD,

        /**
         * Recipe Book Remove
         * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
         * <br> Resource: minecraft:recipe_book_remove
         */
        RECIPE_BOOK_REMOVE,

        /**
         * Recipe Book Settings
         * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
         * <br> Resource: minecraft:recipe_book_settings
         */
        RECIPE_BOOK_SETTINGS,

        /**
         * Remove Entities
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:remove_entities (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> NOTE: Packet structure changed in protocol 756+ (1.17.1+).
         * Also referred to as "Destroy Entities" in versions 1.17.1 to 1.19 on the Minecraft wiki and "Destroy Entity" for 1.17 and prior.
         */
        REMOVE_ENTITIES,

        /**
         * Remove Entity Effect
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:remove_mob_effect (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> For all potion/status effects. Also see PacketType.Play.ENTITY_EFFECT
         */
        REMOVE_ENTITY_EFFECT,

        /**
         * Remove Resource Pack
         * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
         * <br> Resource: minecraft:resource_pack_pop (767 - 773 (1.21.0 - 1.21.10))
         */
        REMOVE_RESOURCE_PACK,

        /**
         * Reset Score
         * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
         * <br> Resource: minecraft:reset_score (767 - 773 (1.21.0 - 1.21.10))
         */
        RESET_SCORE,

        /**
         * Respawn
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:respawn (767 - 773 (1.21.0 - 1.21.10))
         */
        RESPAWN,

        /**
         * Sculk Vibration Signal
         * <br> Supported Protocols: 755 - 758 (1.17.0 - 1.18.2)
         */
        SCULK_VIBRATION_SIGNAL,

        /**
         * Select Advancements Tab
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:select_advancements_tab (767 - 773 (1.21.0 - 1.21.10))
         */
        SELECT_ADVANCEMENTS_TAB,

        /**
         * Server Data
         * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
         * <br> Resource: minecraft:server_data (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Used for server MOTD & Icon.
         */
        SERVER_DATA,

        /**
         * Server Links
         * <br> Supported Protocols: 767 - 773 (1.21.0 - 1.21.10)
         * <br> Resource: minecraft:server_links
         */
        SERVER_LINKS,

        /**
         * Set Action Bar Text
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_action_bar_text (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Action Bar" in versions before 1.19 on the Minecraft wiki.
         */
        SET_ACTION_BAR_TEXT,

        /**
         * Set Block Destroy Stage
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:block_destruction (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Block Break Animation" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BLOCK_DESTROY_STAGE,

        /**
         * Set Border Center
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_border_center (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "World Border Center" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BORDER_CENTER,

        /**
         * Set Border Lerp Size
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_border_lerp_size (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "World Border Lerp Size" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BORDER_LERP_SIZE,

        /**
         * Set Border Size
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_border_size (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "World Border Size" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BORDER_SIZE,

        /**
         * Set Border Warning Delay
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_border_warning_delay (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "World Border Warning Delay" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BORDER_WARNING_DELAY,

        /**
         * Set Border Warning Distance
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_border_warning_distance (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "World Border Warning Reach" in versions before 1.19 on the Minecraft wiki.
         */
        SET_BORDER_WARNING_DISTANCE,

        /**
         * Set Camera
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_camera (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Camera" in versions before 1.19 on the Minecraft wiki.
         * Packet used for setting the player to spectate an entity.
         */
        SET_CAMERA,

        /**
         * Set Center Chunk
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_chunk_cache_center (767 - 773 (1.21.0 - 1.21.10))
         */
        SET_CENTER_CHUNK,

        /**
         * Set Container Content
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:container_set_content (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Window Items" in versions before 1.19 on the Minecraft wiki.
         */
        SET_CONTAINER_CONTENT,

        /**
         * Set Container Property
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:container_set_data (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Window Property" in versions before 1.19 on the Minecraft wiki.
         */
        SET_CONTAINER_PROPERTY,

        /**
         * Set Container Slot
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:container_set_slot (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Set Slot" in versions before 1.19 on the Minecraft wiki.
         */
        SET_CONTAINER_SLOT,

        /**
         * Set Cooldown
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:cooldown (767 - 773 (1.21.0 - 1.21.10))
         */
        SET_COOLDOWN,

        /**
         * Set Cursor Item
         * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
         * <br> Resource: minecraft:set_cursor_item
         */
        SET_CURSOR_ITEM,

        /**
         * Set Default Spawn Position
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_default_spawn_position (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Spawn Position" in versions before 1.19 on the Minecraft wiki.
         */
        SET_DEFAULT_SPAWN_POSITION,

        /**
         * Set Display Chat Preview
         * <br> Supported Protocols: 759 - 760 (1.19.0 - 1.19.2)
         */
        SET_DISPLAY_CHAT_PREVIEW,

        /**
         * Set Entity Metadata
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_entity_data (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Entity Metadata" in versions before 1.19 on the Minecraft wiki.
         */
        SET_ENTITY_METADATA,

        /**
         * Set Entity Velocity
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_entity_motion (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Entity Velocity" in versions before 1.19 on the Minecraft wiki.NOTE: Packet structure changed in protocol 773+ (1.21.9+).
         */
        SET_ENTITY_VELOCITY,

        /**
         * Set Equipment
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_equipment (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Entity Equipment" in versions before 1.19 on the Minecraft wiki.
         */
        SET_EQUIPMENT,

        /**
         * Set Experience
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_experience (767 - 773 (1.21.0 - 1.21.10))
         */
        SET_EXPERIENCE,

        /**
         * Set Head Rotation
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:rotate_head (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Entity Head Look" in versions before 1.19 on the Minecraft wiki.
         */
        SET_HEAD_ROTATION,

        /**
         * Set Health
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_health (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Update Health" in versions before 1.19 on the Minecraft wiki.
         */
        SET_HEALTH,

        /**
         * Set Held Item
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resources: minecraft:set_carried_item (767 (1.21.0 - 1.21.1)), minecraft:set_held_slot (768 - 773 (1.21.2 - 1.21.10))
         * <br>
         * <br> Also referred to as "Held Item Change (clientbound)" in versions before 1.19 on the Minecraft wiki.
         */
        SET_HELD_ITEM,

        /**
         * Set Passengers
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_passengers (767 - 773 (1.21.0 - 1.21.10))
         */
        SET_PASSENGERS,

        /**
         * Set Player Inventory Slot
         * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
         * <br> Resource: minecraft:set_player_inventory
         */
        SET_PLAYER_INVENTORY_SLOT,

        /**
         * Set Render Distance
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_chunk_cache_radius (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Update View Distance" in versions before 1.19 on the Minecraft wiki.
         */
        SET_RENDER_DISTANCE,

        /**
         * Set Simulation Distance
         * <br> Supported Protocols: 757 - 773 (1.18.0 - 1.21.10)
         * <br> Resource: minecraft:set_simulation_distance (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Update Simulation Distance" in versions before 1.19 on the Minecraft wiki.
         */
        SET_SIMULATION_DISTANCE,

        /**
         * Set Subtitle Text
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_subtitle_text (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Set Title SubTitle" in versions before 1.19 on the Minecraft wiki.
         */
        SET_SUBTITLE_TEXT,

        /**
         * Set Tab List Header And Footer
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:tab_list (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Player List Header And Footer" in versions before 1.19 on the Minecraft wiki.
         */
        SET_TAB_LIST_HEADER_AND_FOOTER,

        /**
         * Set Ticking State
         * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
         * <br> Resource: minecraft:ticking_state (767 - 773 (1.21.0 - 1.21.10))
         */
        SET_TICKING_STATE,

        /**
         * Set Title Animation Times
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_titles_animation (767 - 773 (1.21.0 - 1.21.10))
         */
        SET_TITLE_ANIMATION_TIMES,

        /**
         * Set Title Text
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_title_text (767 - 773 (1.21.0 - 1.21.10))
         */
        SET_TITLE_TEXT,

        /**
         * Show Dialog
         * <br> Supported Protocols: 771 - 773 (1.21.6 - 1.21.10)
         * <br> Resource: minecraft:show_dialog
         */
        SHOW_DIALOG,

        /**
         * Sound Effect
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:sound (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> NOTE: Packet structure changed in protocol 761+ (1.19.3+).
         * NOTE: Packet structure changed in protocol 767+ (1.21.0+).
         */
        SOUND_EFFECT,

        /**
         * Spawn Entity
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:add_entity (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> NOTE: Packet structure changed in protocol 759+ (1.19.0+).
         * NOTE: Packet structure changed in protocol 773+ (1.21.9+).
         */
        SPAWN_ENTITY,

        /**
         * Spawn Experience Orb
         * <br> Supported Protocols: 755 - 769 (1.17.0 - 1.21.4)
         * <br> Resource: minecraft:add_experience_orb (767 - 769 (1.21.0 - 1.21.4))
         */
        SPAWN_EXPERIENCE_ORB,

        /**
         * Spawn Living Entity
         * <br> Supported Protocols: 755 - 758 (1.17.0 - 1.18.2)
         */
        SPAWN_LIVING_ENTITY,

        /**
         * Spawn Painting
         * <br> Supported Protocols: 755 - 758 (1.17.0 - 1.18.2)
         */
        SPAWN_PAINTING,

        /**
         * Spawn Player
         * <br> Supported Protocols: 755 - 763 (1.17.0 - 1.20.1)
         */
        SPAWN_PLAYER,

        /**
         * Start Configuration
         * <br> Supported Protocols: 764 - 773 (1.20.2 - 1.21.10)
         * <br> Resource: minecraft:start_configuration (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Switches the protocol state to Configuration. Unsupported in protocol versions 763 (1.20.0/1) and older.
         */
        START_CONFIGURATION,

        /**
         * Step Tick
         * <br> Supported Protocols: 765 - 773 (1.20.3 - 1.21.10)
         * <br> Resource: minecraft:ticking_step (767 - 773 (1.21.0 - 1.21.10))
         */
        STEP_TICK,

        /**
         * Stop Sound
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:stop_sound (767 - 773 (1.21.0 - 1.21.10))
         */
        STOP_SOUND,

        /**
         * Store Cookie
         * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
         * <br> Resource: minecraft:store_cookie (767 - 773 (1.21.0 - 1.21.10))
         */
        STORE_COOKIE,

        /**
         * Synchronize Player Position
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:player_position (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Player Position And Look (clientbound)" in versions before 1.19 on the Minecraft wiki.
         */
        SYNCHRONIZE_PLAYER_POSITION,

        /**
         * Synchronize Vehicle Position
         * <br> Supported Protocols: 768 - 773 (1.21.2 - 1.21.10)
         * <br> Resource: minecraft:teleport_entity
         */
        SYNCHRONIZE_VEHICLE_POSITION,

        /**
         * System Chat Message
         * <br> Supported Protocols: 759 - 773 (1.19.0 - 1.21.10)
         * <br> Resource: minecraft:system_chat (767 - 773 (1.21.0 - 1.21.10))
         */
        SYSTEM_CHAT_MESSAGE,

        /**
         * Tag Query Response
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:tag_query (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "NBT Query Response" in versions before 1.19 on the Minecraft wiki.
         */
        TAG_QUERY_RESPONSE,

        /**
         * Teleport Entity
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resources: minecraft:teleport_entity (767 (1.21.0 - 1.21.1)), minecraft:entity_position_sync (768 - 773 (1.21.2 - 1.21.10))
         * <br>
         * <br> Also referred to as "Entity Teleport" in versions before 1.19 on the Minecraft wiki.
         * NOTE: Packet structure changed since protocol 768+ (1.21.2+). New fields for velocity and yaw/pitch.
         */
        TELEPORT_ENTITY,

        /**
         * Test Instance Block Status
         * <br> Supported Protocols: 770 - 773 (1.21.5 - 1.21.10)
         * <br> Resource: minecraft:test_instance_block_status
         */
        TEST_INSTANCE_BLOCK_STATUS,

        /**
         * Transfer
         * <br> Supported Protocols: 766 - 773 (1.20.5 - 1.21.10)
         * <br> Resource: minecraft:transfer (767 - 773 (1.21.0 - 1.21.10))
         */
        TRANSFER,

        /**
         * Unload Chunk
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:forget_level_chunk (767 - 773 (1.21.0 - 1.21.10))
         */
        UNLOAD_CHUNK,

        /**
         * Update Advancements
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:update_advancements (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Advancements" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_ADVANCEMENTS,

        /**
         * Update Attributes
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:update_attributes (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Entity Properties" in versions before 1.19 on the Minecraft wiki.
         * NOTE: A data field changed in 766+ (1.20.5).
         */
        UPDATE_ATTRIBUTES,

        /**
         * Update Entity Position
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:move_entity_pos (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Entity Position" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_ENTITY_POSITION,

        /**
         * Update Entity Position And Rotation
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:move_entity_pos_rot (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Entity Position and Rotation" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_ENTITY_POSITION_AND_ROTATION,

        /**
         * Update Entity Rotation
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:move_entity_rot (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Entity Rotation" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_ENTITY_ROTATION,

        /**
         * Update Light
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:light_update (767 - 773 (1.21.0 - 1.21.10))
         */
        UPDATE_LIGHT,

        /**
         * Update Objectives
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_objective (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Related to the scoreboard.
         * Also referred to as "Scoreboard Objective" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_OBJECTIVES,

        /**
         * Update Recipes
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:update_recipes (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Declare Recipes" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_RECIPES,

        /**
         * Update Recipe Book
         * <br> Supported Protocols: 755 - 767 (1.17.0 - 1.21.1)
         * <br> Resource: minecraft:recipe (767 (1.21.0 - 1.21.1))
         * <br>
         * <br> Also referred to as "Unlock Recipes" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_RECIPE_BOOK,

        /**
         * Update Score
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_score (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Related to the scoreboard.
         */
        UPDATE_SCORE,

        /**
         * Update Section Blocks
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:section_blocks_update (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Multi Block Change" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_SECTION_BLOCKS,

        /**
         * Update Tags
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:update_tags (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Tags" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_TAGS,

        /**
         * Update Teams
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_player_team (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Related to the scoreboard.
         * Also referred to as "Teams" in versions before 1.19 on the Minecraft wiki.
         */
        UPDATE_TEAMS,

        /**
         * Update Time
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:set_time (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Time Update" in versions before 1.19 on the Minecraft wiki.
         * NOTE: Packet structure changed since protocol 768+ (1.21.2+). New field timeAdvances (timeOfDayIncreasing)
         */
        UPDATE_TIME,

        /**
         * Waypoint
         * <br> Supported Protocols: 771 - 773 (1.21.6 - 1.21.10)
         * <br> Resource: minecraft:waypoint
         */
        WAYPOINT,

        /**
         * World Event
         * <br> Supported Protocols: 755 - 773 (1.17.0 - 1.21.10)
         * <br> Resource: minecraft:level_event (767 - 773 (1.21.0 - 1.21.10))
         * <br>
         * <br> Also referred to as "Effect" in versions before 1.19 on the Minecraft wiki.
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
