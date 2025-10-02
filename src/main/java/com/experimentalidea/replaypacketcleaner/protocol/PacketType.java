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

public interface PacketType {

    public ProtocolState getProtocolState();


    /// The Configuration phase is unsupported in protocol versions 763 (1.20.0/1) and older.
    public static enum Configuration implements ProtocolMetadata, PacketType {

        UNDEFINED,


        /// Add Resource Pack (configuration). Also see REMOVE_RESOURCE_PACK
        ADD_RESOURCE_PACK,

        /// Clear Dialog (configuration) <br> Supported in protocol versions 771+ (1.21.6+)
        CLEAR_DIALOG,

        /// Clientbound Keep Alive (configuration)
        CLIENTBOUND_KEEP_ALIVE,

        CLIENTBOUND_KNOWN_PACKS,

        /// Clientbound Plugin Message (configuration)
        CLIENTBOUND_PLUGIN_MESSAGE,

        /// Cookie Request (configuration)
        COOKIE_REQUEST,

        /// Custom Report Details (configuration)
        CUSTOM_REPORT_DETAILS,

        /// Disconnect (configuration)
        DISCONNECT,

        FEATURE_FLAGS,

        /// Switches the protocol state to play.
        FINISH_CONFIGURATION,

        /// Ping (configuration)
        PING,

        REGISTRY_DATA,

        /// Remove Resource Pack (configuration). Also see ADD_RESOURCE_PACK
        REMOVE_RESOURCE_PACK,

        RESET_CHAT,

        /// Server Links (configuration)
        SERVER_LINKS,

        /// Show Dialog (configuration) <br> Supported in protocol versions 771+ (1.21.6+)
        SHOW_DIALOG,

        /// Store Cookie (configuration)
        STORE_COOKIE,

        /// Transfer (configuration) - Tells the client to transfer to another server. (should never see this packet within replays)
        TRANSFER,

        /// Update Tags (configuration)
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


    public static enum Login implements ProtocolMetadata, PacketType {

        UNDEFINED,


        /// Cookie Request (login)
        COOKIE_REQUEST,

        /// Disconnect (login)
        DISCONNECT,

        ENCRYPTION_REQUEST,

        LOGIN_PLUGIN_REQUEST,

        /// Switches the protocol state to play on older protocol versions. (TODO: Note which version changed this)
        LOGIN_SUCCESS,

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


    public static enum Play implements ProtocolMetadata, PacketType {

        UNDEFINED,


        ACKNOWLEDGE_BLOCK_CHANGE,

        /// Add Resource Pack (play). Also see REMOVE_RESOURCE_PACK
        ADD_RESOURCE_PACK,

        AWARD_STATISTICS,

        /// NOTE: Packet structure changed from 1.13.x to 1.14.x. The position is encoded as XYZ in 1.13.x and older, while it is encoded as XZY in 1.14.x+
        BLOCK_ACTION,

        BLOCK_ENTITY_DATA,

        /// TODO: note for implementing packet: The Enum fields Action, Color, & TypeOfDivision appear to be the same for all protocol versions. (when quickly comparing 1.12 to 1.21.8)
        BOSS_BAR,

        BUNDLE_DELIMITER,

        BLOCK_UPDATE,

        CHANGE_DIFFICULTY,

        /// Only supported in protocol versions 760 (1.19.1/2) and older.
        CHAT_PREVIEW,

        CHAT_SUGGESTIONS,

        /// Unsupported in protocol versions 763 (1.20.0/1) and older.
        CHUNK_BATCH_FINISHED,

        CHUNK_BATCH_START,

        CHUNK_BIOMES,

        CHUNK_DATA_AND_UPDATE_LIGHT,

        /// Clientbound Keep Alive (play)
        CLIENTBOUND_KEEP_ALIVE,

        /// Clientbound Plugin Message (play)
        CLIENTBOUND_PLUGIN_MESSAGE,

        /// Clear Dialog (play) <br> Supported in protocol versions 771+ (1.21.6+)
        CLEAR_DIALOG,

        CLEAR_TITLES,

        CLOSE_CONTAINER,

        COMBAT_DEATH,

        COMMANDS,

        COMMAND_SUGGESTIONS_RESPONSE,

        ///  Cookie Request (play)
        COOKIE_REQUEST,

        /// Custom Report Details (play)
        CUSTOM_REPORT_DETAILS,

        /// Only supported in protocol versions 760 (1.19.1/2) and older. In 761, this packet's function was merged into SOUND_EFFECT.
        CUSTOM_SOUND_EFFECT,

        DAMAGE_EVENT,

        DEBUG_SAMPLE,

        /// Also known by the name "Hide Message" on the Minecraft wiki for protocol versions 760 (1.19.1/2) and prior.
        DELETE_MESSAGE,

        /// Disconnect (play)
        DISCONNECT,

        /// Note: Packet is new to protocol 761+ (1.19.3+)
        DISGUISED_CHAT_MESSAGE,

        /// Related to the scoreboard
        DISPLAY_OBJECTIVE,

        END_COMBAT,

        ENTER_COMBAT,

        ENTITY_ANIMATION,

        /// For all potion/status effects.
        /// Seems this is only for the client (player) to display effect durations, removing it has no effect on potion particles.
        /// I believe the Set Entity Metadata packet may be responsible for those particles.
        /// Note: Packet structure changed in protocol 766+ (1.20.5+)
        ENTITY_EFFECT,

        ENTITY_EVENT,

        /// Note: Packet structure changed in protocol 767+ (1.21.0+)
        /// Note: Packet structure changed in protocol 761+ (1.19.3+)
        ENTITY_SOUND_EFFECT,

        EXPLOSION,

        /// Unsupported in protocol versions 764+ (1.20.0+). Replaced by Configuration.FEATURE_FLAGS in protocol version 764+ (1.20.2+)
        /// Note: Packet is new to protocol 761+ (1.19.3+)
        FEATURE_FLAGS,

        GAME_EVENT,

        HURT_ANIMATION,

        INITIALIZE_WORLD_BORDER,

        LINK_ENTITIES,

        LOOK_AT,

        ///  Login (play)
        LOGIN,

        MAP_DATA,

        MERCHANT_OFFERS,

        /// Only supported in protocol versions 760 (1.19.1/2) and older.
        MESSAGE_HEADER,

        /// NOTE: Packet is new to protocol 768+ (1.21.2+).
        MOVE_MINECART_ALONG_TRACK,

        MOVE_VEHICLE,

        OPEN_BOOK,

        OPEN_HORSE_SCREEN,

        OPEN_SIGN_EDITOR,

        OPEN_SCREEN,

        /// NOTE: Packet structure changed since protocol 769+ (1.21.4+). New field alwaysVisible.
        /// Note: Packet structure changed since protocol 767+ (1.21.0+). Particle ID field moved to the end just before the Data field
        PARTICLE,

        /// This packet is purely for the animation of an item being picked up by an entity
        PICKUP_ITEM,

        /// Ping (play)
        PING,

        /// Ping Response (play)
        /// Unsupported in protocol versions 763 (1.20.0/1) and older.
        PING_RESPONSE,

        PLACE_GHOST_RECIPE,

        /// Player Abilities (clientbound)
        PLAYER_ABILITIES,

        PLAYER_CHAT_MESSAGE,

        /// Note: Packet is new to protocol 761+ (1.19.3+)
        PLAYER_INFO_REMOVE,

        /// Also known by the name "Player Info" on the Minecraft wiki for protocol versions 760 (1.19.1/2) and prior.
        PLAYER_INFO_UPDATE,

        PLAYER_ROTATION,

        /// Note: Packet structure changed since protocol 767+ (1.21.0+). Power XYZ fields reduced to single Power field.
        /// Note: Packet is new to protocol 766+ (1.20.5+)
        PROJECTILE_POWER,

        RECIPE_BOOK_ADD,

        RECIPE_BOOK_REMOVE,

        RECIPE_BOOK_SETTINGS,

        REMOVE_ENTITIES,

        /// For all potion/status effects
        REMOVE_ENTITY_EFFECT,

        /// Remove Resource Pack (play). Also see ADD_RESOURCE_PACK
        REMOVE_RESOURCE_PACK,

        /// Related to the scoreboard
        RESET_SCORE,

        RESPAWN,

        SELECT_ADVANCEMENTS_TAB,

        /// Server MOTD & Icon.
        SERVER_DATA,

        /// Server Links (play)
        SERVER_LINKS,

        SET_ACTION_BAR_TEXT,

        SET_BLOCK_DESTROY_STAGE,

        SET_BORDER_CENTER,

        SET_BORDER_LERP_SIZE,

        SET_BORDER_SIZE,

        SET_BORDER_WARNING_DELAY,

        SET_BORDER_WARNING_DISTANCE,

        /// Packet for setting the player to spectate an entity
        SET_CAMERA,

        SET_CENTER_CHUNK,

        SET_CONTAINER_CONTENT,

        SET_CONTAINER_PROPERTY,

        SET_CONTAINER_SLOT,

        SET_COOLDOWN,

        SET_CURSOR_ITEM,

        SET_DEFAULT_SPAWN_POSITION,

        /// Only supported in protocol versions 760 (1.19.1/2) and older.
        SET_DISPLAY_CHAT_PREVIEW,

        SET_ENTITY_METADATA,

        SET_ENTITY_VELOCITY,

        SET_EQUIPMENT,

        SET_EXPERIENCE,

        SET_HEAD_ROTATION,

        SET_HEALTH,

        /// Set Held Item (clientbound)
        SET_HELD_ITEM,

        SET_PASSENGERS,

        SET_PLAYER_INVENTORY_SLOT,

        SET_RENDER_DISTANCE,

        SET_SIMULATION_DISTANCE,

        SET_SUBTITLE_TEXT,

        SET_TAB_LIST_HEADER_AND_FOOTER,

        SET_TICKING_STATE,

        SET_TITLE_ANIMATION_TIMES,

        SET_TITLE_TEXT,

        /// Show Dialog (play) <br> Supported in protocol versions 771+ (1.21.6+)
        SHOW_DIALOG,

        /// Note: Packet structure changed in protocol 767+ (1.21.0+)
        /// Note: Packet structure changed in protocol 761+ (1.19.3+)
        SOUND_EFFECT,

        SPAWN_ENTITY,

        /// Unsupported in protocol versions 770+ (1.21.5+)
        SPAWN_EXPERIENCE_ORB,

        /// Unsupported in protocol versions 764+ (1.20.2+)
        SPAWN_PLAYER,

        /// Switches the protocol state to Configuration
        /// Unsupported in protocol versions 763 (1.20.0/1) and older.
        START_CONFIGURATION,

        STEP_TICK,

        STOP_SOUND,

        /// Store Cookie (play)
        STORE_COOKIE,

        SYNCHRONIZE_PLAYER_POSITION,

        /// NOTE: Packet is new to protocol 768+ (1.21.2+).
        SYNCHRONIZE_VEHICLE_POSITION,

        SYSTEM_CHAT_MESSAGE,

        TAG_QUERY_RESPONSE,

        /// NOTE: Packet structure changed since protocol 768+ (1.21.2+). New fields for velocity and yaw/pitch.
        TELEPORT_ENTITY,

        /// Supported in protocol versions 770+ (1.21.5+)
        TEST_INSTANCE_BLOCK_STATUS,

        /// Transfer (play) - Tells the client to transfer to another server. (should never see this packet within replays)
        TRANSFER,

        UNLOAD_CHUNK,

        UPDATE_ADVANCEMENTS,

        /// Note: A data field changed in 766+ (1.20.5)
        UPDATE_ATTRIBUTES,

        UPDATE_ENTITY_POSITION,

        UPDATE_ENTITY_POSITION_AND_ROTATION,

        UPDATE_ENTITY_ROTATION,

        UPDATE_LIGHT,

        /// Related to the scoreboard
        UPDATE_OBJECTIVES,

        UPDATE_RECIPE_BOOK,

        UPDATE_RECIPES,

        UPDATE_SECTION_BLOCKS,

        /// Related to the scoreboard
        UPDATE_SCORE,

        /// Update Tags (play)
        UPDATE_TAGS,

        /// Related to the scoreboard (I think...)
        UPDATE_TEAMS,

        /// NOTE: Packet structure changed since protocol 768+ (1.21.2+). New field timeAdvances (timeOfDayIncreasing)
        UPDATE_TIME,

        /// Supported in protocol versions 771+
        WAYPOINT,

        /// NOTE: Packet structure changed from 1.13.x to 1.14.x. The position is encoded as XYZ in 1.13.x and older, while it is encoded as XZY in 1.14.x+
        /// ALSO NOTE: Packet referred to as simply "Effect" for older protocols on the wiki. (around 1.19 & before)
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
