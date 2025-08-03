package com.experimentalidea.replaypacketcleaner.protocol;

/**
 * Used to decode packet id's for different protocol versions.
 * <p>
 * To be replaced with a data driven solution at a later time,
 * as hard coded mappings isn't nicely maintainable long term.
 * For now though, this will be good enough to get started.
 */
public enum Protocol {

    /**
     * The network protocol version used for MC 1.21 & 1.21.1
     */
    V_767(767) {
        public int getStateChangeToPlayPacketID() {
            return 0x03;
        }

        public int getPacketID(PacketType packetType) {
            return switch (packetType) {
                case BLOCK_ACTION -> 0x08;
                case DAMAGE_EVENT -> 0x1A;
                case ENTITY_ANIMATION -> 0x03;
                case ENTITY_EFFECT -> 0x76;
                case ENTITY_EVENT -> 0x1F;
                case ENTITY_SOUND_EFFECT -> 0x67;
                case GAME_EVENT -> 0x22;
                case HURT_ANIMATION -> 0x24;
                case LINK_ENTITIES -> 0x59;
                case MOVE_MINECART_ALONG_TRACK -> -1; // Unsupported packet - Packet type was added in protocol 768+ (1.21.2+)
                case PARTICLE -> 0x29;
                case PICKUP_ITEM -> 0x6F;
                case PROJECTILE_POWER -> 0x79;
                case REMOVE_ENTITIES -> 0x42;
                case REMOVE_ENTITY_EFFECT -> 0x43;
                case SET_ENTITY_METADATA -> 0x58;
                case SET_ENTITY_VELOCITY -> 0x5A;
                case SET_EQUIPMENT -> 0x5B;
                case SET_HEAD_ROTATION -> 0x48;
                case SET_PASSENGERS -> 0x5F;
                case START_CONFIGURATION -> 0x69;
                case SOUND_EFFECT -> 0x68;
                case SPAWN_ENTITY -> 0x01;
                case SPAWN_EXPERIENCE_ORB -> 0x02;
                case SYNCHRONIZE_VEHICLE_POSITION -> -1; // Unsupported packet - Packet type was added in protocol 768+ (1.21.2+)
                case TELEPORT_ENTITY -> 0x70;
                case UPDATE_ATTRIBUTES -> 0x75;
                case UPDATE_ENTITY_POSITION -> 0x2E;
                case UPDATE_ENTITY_POSITION_AND_ROTATION -> 0x2F;
                case UPDATE_ENTITY_ROTATION -> 0x30;
                case UPDATE_TIME -> 0x64;
                case WORLD_EVENT -> 0x28;
                case UNDEFINED -> -1;
            };
        }

        public PacketType getPacketType(int packetID) {
            return switch (packetID) {
                case 0x08 -> PacketType.BLOCK_ACTION;
                case 0x1A -> PacketType.DAMAGE_EVENT;
                case 0x03 -> PacketType.ENTITY_ANIMATION;
                case 0x76 -> PacketType.ENTITY_EFFECT;
                case 0x1F -> PacketType.ENTITY_EVENT;
                case 0x67 -> PacketType.ENTITY_SOUND_EFFECT;
                case 0x22 -> PacketType.GAME_EVENT;
                case 0x59 -> PacketType.LINK_ENTITIES;
                case 0x24 -> PacketType.HURT_ANIMATION;
                // case -1 -> PacketType.MOVE_MINECART_ALONG_TRACK; // Unsupported packet - Packet type was added in protocol 768+ (1.21.2+)
                case 0x29 -> PacketType.PARTICLE;
                case 0x6F -> PacketType.PICKUP_ITEM;
                case 0x79 -> PacketType.PROJECTILE_POWER;
                case 0x42 -> PacketType.REMOVE_ENTITIES;
                case 0x43 -> PacketType.REMOVE_ENTITY_EFFECT;
                case 0x58 -> PacketType.SET_ENTITY_METADATA;
                case 0x5A -> PacketType.SET_ENTITY_VELOCITY;
                case 0x5B -> PacketType.SET_EQUIPMENT;
                case 0x48 -> PacketType.SET_HEAD_ROTATION;
                case 0x5F -> PacketType.SET_PASSENGERS;
                case 0x69 -> PacketType.START_CONFIGURATION;
                case 0x68 -> PacketType.SOUND_EFFECT;
                case 0x01 -> PacketType.SPAWN_ENTITY;
                case 0x02 -> PacketType.SPAWN_EXPERIENCE_ORB;
                // case -1 -> PacketType.SYNCHRONIZE_VEHICLE_POSITION; // Unsupported packet - Packet type was added in protocol 768+ (1.21.2+)
                case 0x70 -> PacketType.TELEPORT_ENTITY;
                case 0x75 -> PacketType.UPDATE_ATTRIBUTES;
                case 0x2E -> PacketType.UPDATE_ENTITY_POSITION;
                case 0x2F -> PacketType.UPDATE_ENTITY_POSITION_AND_ROTATION;
                case 0x30 -> PacketType.UPDATE_ENTITY_ROTATION;
                case 0x64 -> PacketType.UPDATE_TIME;
                case 0x28 -> PacketType.WORLD_EVENT;
                default -> PacketType.UNDEFINED;
            };
        }
    },

    /**
     * The network protocol version used for MC 1.21.2 & 1.21.3
     */
    V_768(768) {
        public int getStateChangeToPlayPacketID() {
            return 0x03;
        }

        public int getPacketID(PacketType packetType) {
            return switch (packetType) {
                case BLOCK_ACTION -> 0x08;
                case DAMAGE_EVENT -> 0x1A;
                case ENTITY_ANIMATION -> 0x03;
                case ENTITY_EFFECT -> 0x76;
                case ENTITY_EVENT -> 0x1F;
                case ENTITY_SOUND_EFFECT -> 0x67;
                case GAME_EVENT -> 0x22;
                case HURT_ANIMATION -> 0x24;
                case LINK_ENTITIES -> 0x59;
                case MOVE_MINECART_ALONG_TRACK -> 0x31;
                case PARTICLE -> 0x29;
                case PICKUP_ITEM -> 0x6F;
                case PROJECTILE_POWER -> 0x79;
                case REMOVE_ENTITIES -> 0x42;
                case REMOVE_ENTITY_EFFECT -> 0x43;
                case SET_ENTITY_METADATA -> 0x58;
                case SET_ENTITY_VELOCITY -> 0x5A;
                case SET_EQUIPMENT -> 0x5B;
                case SET_HEAD_ROTATION -> 0x48;
                case SET_PASSENGERS -> 0x5F;
                case START_CONFIGURATION -> 0x69;
                case SOUND_EFFECT -> 0x68;
                case SPAWN_ENTITY -> 0x01;
                case SPAWN_EXPERIENCE_ORB -> 0x02;
                case SYNCHRONIZE_VEHICLE_POSITION -> 0x77;
                case TELEPORT_ENTITY -> 0x20;
                case UPDATE_ATTRIBUTES -> 0x75;
                case UPDATE_ENTITY_POSITION -> 0x2E;
                case UPDATE_ENTITY_POSITION_AND_ROTATION -> 0x2F;
                case UPDATE_ENTITY_ROTATION -> 0x30;
                case UPDATE_TIME -> 0x6B;
                case WORLD_EVENT -> 0x28;
                case UNDEFINED -> -1;
            };
        }

        public PacketType getPacketType(int packetID) {
            return switch (packetID) {
                case 0x08 -> PacketType.BLOCK_ACTION;
                case 0x1A -> PacketType.DAMAGE_EVENT;
                case 0x03 -> PacketType.ENTITY_ANIMATION;
                case 0x76 -> PacketType.ENTITY_EFFECT;
                case 0x1F -> PacketType.ENTITY_EVENT;
                case 0x67 -> PacketType.ENTITY_SOUND_EFFECT;
                case 0x22 -> PacketType.GAME_EVENT;
                case 0x24 -> PacketType.HURT_ANIMATION;
                case 0x59 -> PacketType.LINK_ENTITIES;
                case 0x31 -> PacketType.MOVE_MINECART_ALONG_TRACK;
                case 0x29 -> PacketType.PARTICLE;
                case 0x6F -> PacketType.PICKUP_ITEM;
                case 0x79 -> PacketType.PROJECTILE_POWER;
                case 0x42 -> PacketType.REMOVE_ENTITIES;
                case 0x43 -> PacketType.REMOVE_ENTITY_EFFECT;
                case 0x58 -> PacketType.SET_ENTITY_METADATA;
                case 0x5A -> PacketType.SET_ENTITY_VELOCITY;
                case 0x5B -> PacketType.SET_EQUIPMENT;
                case 0x48 -> PacketType.SET_HEAD_ROTATION;
                case 0x5F -> PacketType.SET_PASSENGERS;
                case 0x69 -> PacketType.START_CONFIGURATION;
                case 0x68 -> PacketType.SOUND_EFFECT;
                case 0x01 -> PacketType.SPAWN_ENTITY;
                case 0x02 -> PacketType.SPAWN_EXPERIENCE_ORB;
                case 0x77 -> PacketType.SYNCHRONIZE_VEHICLE_POSITION;
                case 0x20 -> PacketType.TELEPORT_ENTITY;
                case 0x75 -> PacketType.UPDATE_ATTRIBUTES;
                case 0x2E -> PacketType.UPDATE_ENTITY_POSITION;
                case 0x2F -> PacketType.UPDATE_ENTITY_POSITION_AND_ROTATION;
                case 0x30 -> PacketType.UPDATE_ENTITY_ROTATION;
                case 0x6B -> PacketType.UPDATE_TIME;
                case 0x28 -> PacketType.WORLD_EVENT;
                default -> PacketType.UNDEFINED;
            };
        }
    },

    /**
     * The network protocol version used for MC 1.21.4
     */
    V_769(769) {
        public int getStateChangeToPlayPacketID() {
            return 0x03;
        }

        public int getPacketID(PacketType packetType) {
            return switch (packetType) {
                case BLOCK_ACTION -> 0x08;
                case DAMAGE_EVENT -> 0x1A;
                case ENTITY_ANIMATION -> 0x03;
                case ENTITY_EFFECT -> 0x7D;
                case ENTITY_EVENT -> 0x1F;
                case ENTITY_SOUND_EFFECT -> 0x6E;
                case GAME_EVENT -> 0x23;
                case HURT_ANIMATION -> 0x25;
                case LINK_ENTITIES -> 0x5E;
                case MOVE_MINECART_ALONG_TRACK -> 0x31;
                case PARTICLE -> 0x2A;
                case PICKUP_ITEM -> 0x76;
                case PROJECTILE_POWER -> 0x80;
                case REMOVE_ENTITIES -> 0x47;
                case REMOVE_ENTITY_EFFECT -> 0x48;
                case SET_ENTITY_METADATA -> 0x5D;
                case SET_ENTITY_VELOCITY -> 0x5F;
                case SET_EQUIPMENT -> 0x60;
                case SET_HEAD_ROTATION -> 0x4D;
                case SET_PASSENGERS -> 0x65;
                case START_CONFIGURATION -> 0x70;
                case SOUND_EFFECT -> 0x6F;
                case SPAWN_ENTITY -> 0x01;
                case SPAWN_EXPERIENCE_ORB -> 0x02;
                case SYNCHRONIZE_VEHICLE_POSITION -> 0x77;
                case TELEPORT_ENTITY -> 0x20;
                case UPDATE_ATTRIBUTES -> 0x7C;
                case UPDATE_ENTITY_POSITION -> 0x2F;
                case UPDATE_ENTITY_POSITION_AND_ROTATION -> 0x30;
                case UPDATE_ENTITY_ROTATION -> 0x32;
                case UPDATE_TIME -> 0x6B;
                case WORLD_EVENT -> 0x29;
                case UNDEFINED -> -1;
            };
        }

        public PacketType getPacketType(int packetID) {
            return switch (packetID) {
                case 0x08 -> PacketType.BLOCK_ACTION;
                case 0x1A -> PacketType.DAMAGE_EVENT;
                case 0x03 -> PacketType.ENTITY_ANIMATION;
                case 0x7D -> PacketType.ENTITY_EFFECT;
                case 0x1F -> PacketType.ENTITY_EVENT;
                case 0x6E -> PacketType.ENTITY_SOUND_EFFECT;
                case 0x23 -> PacketType.GAME_EVENT;
                case 0x25 -> PacketType.HURT_ANIMATION;
                case 0x5E -> PacketType.LINK_ENTITIES;
                case 0x31 -> PacketType.MOVE_MINECART_ALONG_TRACK;
                case 0x2A -> PacketType.PARTICLE;
                case 0x76 -> PacketType.PICKUP_ITEM;
                case 0x80 -> PacketType.PROJECTILE_POWER;
                case 0x47 -> PacketType.REMOVE_ENTITIES;
                case 0x48 -> PacketType.REMOVE_ENTITY_EFFECT;
                case 0x5D -> PacketType.SET_ENTITY_METADATA;
                case 0x5F -> PacketType.SET_ENTITY_VELOCITY;
                case 0x60 -> PacketType.SET_EQUIPMENT;
                case 0x4D -> PacketType.SET_HEAD_ROTATION;
                case 0x65 -> PacketType.SET_PASSENGERS;
                case 0x70 -> PacketType.START_CONFIGURATION;
                case 0x6F -> PacketType.SOUND_EFFECT;
                case 0x01 -> PacketType.SPAWN_ENTITY;
                case 0x02 -> PacketType.SPAWN_EXPERIENCE_ORB;
                case 0x77 -> PacketType.SYNCHRONIZE_VEHICLE_POSITION;
                case 0x20 -> PacketType.TELEPORT_ENTITY;
                case 0x7C -> PacketType.UPDATE_ATTRIBUTES;
                case 0x2F -> PacketType.UPDATE_ENTITY_POSITION;
                case 0x30 -> PacketType.UPDATE_ENTITY_POSITION_AND_ROTATION;
                case 0x32 -> PacketType.UPDATE_ENTITY_ROTATION;
                case 0x6B -> PacketType.UPDATE_TIME;
                case 0x29 -> PacketType.WORLD_EVENT;
                default -> PacketType.UNDEFINED;
            };
        }
    },

    /**
     * The network protocol version used for MC 1.21.5
     */
    V_770(770) {
        public int getStateChangeToPlayPacketID() {
            return 0x03;
        }

        public int getPacketID(PacketType packetType) {
            return switch (packetType) {
                case BLOCK_ACTION -> 0x07;
                case DAMAGE_EVENT -> 0x19;
                case ENTITY_ANIMATION -> 0x02;
                case ENTITY_EFFECT -> 0x7D;
                case ENTITY_EVENT -> 0x1E;
                case ENTITY_SOUND_EFFECT -> 0x6D;
                case GAME_EVENT -> 0x22;
                case HURT_ANIMATION -> 0x24;
                case LINK_ENTITIES -> 0x5D;
                case MOVE_MINECART_ALONG_TRACK -> 0x30;
                case PARTICLE -> 0x29;
                case PICKUP_ITEM -> 0x75;
                case PROJECTILE_POWER -> 0x80;
                case REMOVE_ENTITIES -> 0x46;
                case REMOVE_ENTITY_EFFECT -> 0x47;
                case SET_ENTITY_METADATA -> 0x5C;
                case SET_ENTITY_VELOCITY -> 0x5E;
                case SET_EQUIPMENT -> 0x5F;
                case SET_HEAD_ROTATION -> 0x4C;
                case SET_PASSENGERS -> 0x64;
                case START_CONFIGURATION -> 0x6F;
                case SOUND_EFFECT -> 0x6E;
                case SPAWN_ENTITY -> 0x01;
                case SPAWN_EXPERIENCE_ORB -> -1; // Unsupported packet - Packet type was removed in protocol 770+ (1.21.5+)
                case SYNCHRONIZE_VEHICLE_POSITION -> 0x76;
                case TELEPORT_ENTITY -> 0x1F;
                case UPDATE_ATTRIBUTES -> 0x7C;
                case UPDATE_ENTITY_POSITION -> 0x2E;
                case UPDATE_ENTITY_POSITION_AND_ROTATION -> 0x2F;
                case UPDATE_ENTITY_ROTATION -> 0x31;
                case UPDATE_TIME -> 0x6A;
                case WORLD_EVENT -> 0x28;
                case UNDEFINED -> -1;
            };
        }

        public PacketType getPacketType(int packetID) {
            return switch (packetID) {
                case 0x07 -> PacketType.BLOCK_ACTION;
                case 0x19 -> PacketType.DAMAGE_EVENT;
                case 0x02 -> PacketType.ENTITY_ANIMATION;
                case 0x7D -> PacketType.ENTITY_EFFECT;
                case 0x1E -> PacketType.ENTITY_EVENT;
                case 0x6D -> PacketType.ENTITY_SOUND_EFFECT;
                case 0x22 -> PacketType.GAME_EVENT;
                case 0x24 -> PacketType.HURT_ANIMATION;
                case 0x5D -> PacketType.LINK_ENTITIES;
                case 0x30 -> PacketType.MOVE_MINECART_ALONG_TRACK;
                case 0x29 -> PacketType.PARTICLE;
                case 0x75 -> PacketType.PICKUP_ITEM;
                case 0x80 -> PacketType.PROJECTILE_POWER;
                case 0x46 -> PacketType.REMOVE_ENTITIES;
                case 0x47 -> PacketType.REMOVE_ENTITY_EFFECT;
                case 0x5C -> PacketType.SET_ENTITY_METADATA;
                case 0x5E -> PacketType.SET_ENTITY_VELOCITY;
                case 0x5F -> PacketType.SET_EQUIPMENT;
                case 0x4C -> PacketType.SET_HEAD_ROTATION;
                case 0x64 -> PacketType.SET_PASSENGERS;
                case 0x6F -> PacketType.START_CONFIGURATION;
                case 0x6E -> PacketType.SOUND_EFFECT;
                case 0x01 -> PacketType.SPAWN_ENTITY;
                //case -1; -> PacketType.SPAWN_EXPERIENCE_ORB; // Unsupported packet - Packet type was removed in protocol 770+ (1.21.5+)
                case 0x76 -> PacketType.SYNCHRONIZE_VEHICLE_POSITION;
                case 0x1F -> PacketType.TELEPORT_ENTITY;
                case 0x7C -> PacketType.UPDATE_ATTRIBUTES;
                case 0x2E -> PacketType.UPDATE_ENTITY_POSITION;
                case 0x2F -> PacketType.UPDATE_ENTITY_POSITION_AND_ROTATION;
                case 0x31 -> PacketType.UPDATE_ENTITY_ROTATION;
                case 0x6A -> PacketType.UPDATE_TIME;
                case 0x28 -> PacketType.WORLD_EVENT;
                default -> PacketType.UNDEFINED;
            };
        }
    },

    /**
     * The network protocol version used for MC 1.21.6
     * Appears all packet ids are the same as protocol 770. (except the 3 new packet type ids added in this version)
     */
    V_771(771) {
        public int getStateChangeToPlayPacketID() {
            return 0x03;
        }

        public int getPacketID(PacketType packetType) {
            return switch (packetType) {
                case BLOCK_ACTION -> 0x07;
                case DAMAGE_EVENT -> 0x19;
                case ENTITY_ANIMATION -> 0x02;
                case ENTITY_EFFECT -> 0x7D;
                case ENTITY_EVENT -> 0x1E;
                case ENTITY_SOUND_EFFECT -> 0x6D;
                case GAME_EVENT -> 0x22;
                case HURT_ANIMATION -> 0x24;
                case LINK_ENTITIES -> 0x5D;
                case MOVE_MINECART_ALONG_TRACK -> 0x30;
                case PARTICLE -> 0x29;
                case PICKUP_ITEM -> 0x75;
                case PROJECTILE_POWER -> 0x80;
                case REMOVE_ENTITIES -> 0x46;
                case REMOVE_ENTITY_EFFECT -> 0x47;
                case SET_ENTITY_METADATA -> 0x5C;
                case SET_ENTITY_VELOCITY -> 0x5E;
                case SET_EQUIPMENT -> 0x5F;
                case SET_HEAD_ROTATION -> 0x4C;
                case SET_PASSENGERS -> 0x64;
                case START_CONFIGURATION -> 0x6F;
                case SOUND_EFFECT -> 0x6E;
                case SPAWN_ENTITY -> 0x01;
                case SPAWN_EXPERIENCE_ORB -> -1; // Unsupported packet - Packet type was removed in protocol 770+ (1.21.5+)
                case SYNCHRONIZE_VEHICLE_POSITION -> 0x76;
                case TELEPORT_ENTITY -> 0x1F;
                case UPDATE_ATTRIBUTES -> 0x7C;
                case UPDATE_ENTITY_POSITION -> 0x2E;
                case UPDATE_ENTITY_POSITION_AND_ROTATION -> 0x2F;
                case UPDATE_ENTITY_ROTATION -> 0x31;
                case UPDATE_TIME -> 0x6A;
                case WORLD_EVENT -> 0x28;
                case UNDEFINED -> -1;
            };
        }

        public PacketType getPacketType(int packetID) {
            return switch (packetID) {
                case 0x07 -> PacketType.BLOCK_ACTION;
                case 0x19 -> PacketType.DAMAGE_EVENT;
                case 0x02 -> PacketType.ENTITY_ANIMATION;
                case 0x7D -> PacketType.ENTITY_EFFECT;
                case 0x1E -> PacketType.ENTITY_EVENT;
                case 0x6D -> PacketType.ENTITY_SOUND_EFFECT;
                case 0x22 -> PacketType.GAME_EVENT;
                case 0x24 -> PacketType.HURT_ANIMATION;
                case 0x5D -> PacketType.LINK_ENTITIES;
                case 0x30 -> PacketType.MOVE_MINECART_ALONG_TRACK;
                case 0x29 -> PacketType.PARTICLE;
                case 0x75 -> PacketType.PICKUP_ITEM;
                case 0x80 -> PacketType.PROJECTILE_POWER;
                case 0x46 -> PacketType.REMOVE_ENTITIES;
                case 0x47 -> PacketType.REMOVE_ENTITY_EFFECT;
                case 0x5C -> PacketType.SET_ENTITY_METADATA;
                case 0x5E -> PacketType.SET_ENTITY_VELOCITY;
                case 0x5F -> PacketType.SET_EQUIPMENT;
                case 0x4C -> PacketType.SET_HEAD_ROTATION;
                case 0x64 -> PacketType.SET_PASSENGERS;
                case 0x6F -> PacketType.START_CONFIGURATION;
                case 0x6E -> PacketType.SOUND_EFFECT;
                case 0x01 -> PacketType.SPAWN_ENTITY;
                //case -1; -> PacketType.SPAWN_EXPERIENCE_ORB; // Unsupported packet - Packet type was removed in protocol 770+ (1.21.5+)
                case 0x76 -> PacketType.SYNCHRONIZE_VEHICLE_POSITION;
                case 0x1F -> PacketType.TELEPORT_ENTITY;
                case 0x7C -> PacketType.UPDATE_ATTRIBUTES;
                case 0x2E -> PacketType.UPDATE_ENTITY_POSITION;
                case 0x2F -> PacketType.UPDATE_ENTITY_POSITION_AND_ROTATION;
                case 0x31 -> PacketType.UPDATE_ENTITY_ROTATION;
                case 0x6A -> PacketType.UPDATE_TIME;
                case 0x28 -> PacketType.WORLD_EVENT;
                default -> PacketType.UNDEFINED;
            };
        }
    },

    /**
     * The network protocol version used for MC 1.21.7 & 1.21.8
     * Appears all packet ids are the same as protocol 770. (except the 3 new packet type ids added in version 771)
     * No changes from MC 1.21.6 (protocol 771).
     */
    V_772(772) {
        public int getStateChangeToPlayPacketID() {
            return 0x03;
        }

        public int getPacketID(PacketType packetType) {
            return switch (packetType) {
                case BLOCK_ACTION -> 0x07;
                case DAMAGE_EVENT -> 0x19;
                case ENTITY_ANIMATION -> 0x02;
                case ENTITY_EFFECT -> 0x7D;
                case ENTITY_EVENT -> 0x1E;
                case ENTITY_SOUND_EFFECT -> 0x6D;
                case GAME_EVENT -> 0x22;
                case HURT_ANIMATION -> 0x24;
                case LINK_ENTITIES -> 0x5D;
                case MOVE_MINECART_ALONG_TRACK -> 0x30;
                case PARTICLE -> 0x29;
                case PICKUP_ITEM -> 0x75;
                case PROJECTILE_POWER -> 0x80;
                case REMOVE_ENTITIES -> 0x46;
                case REMOVE_ENTITY_EFFECT -> 0x47;
                case SET_ENTITY_METADATA -> 0x5C;
                case SET_ENTITY_VELOCITY -> 0x5E;
                case SET_EQUIPMENT -> 0x5F;
                case SET_HEAD_ROTATION -> 0x4C;
                case SET_PASSENGERS -> 0x64;
                case START_CONFIGURATION -> 0x6F;
                case SOUND_EFFECT -> 0x6E;
                case SPAWN_ENTITY -> 0x01;
                case SPAWN_EXPERIENCE_ORB -> -1; // Unsupported packet - Packet type was removed in protocol 770+ (1.21.5+)
                case SYNCHRONIZE_VEHICLE_POSITION -> 0x76;
                case TELEPORT_ENTITY -> 0x1F;
                case UPDATE_ATTRIBUTES -> 0x7C;
                case UPDATE_ENTITY_POSITION -> 0x2E;
                case UPDATE_ENTITY_POSITION_AND_ROTATION -> 0x2F;
                case UPDATE_ENTITY_ROTATION -> 0x31;
                case UPDATE_TIME -> 0x6A;
                case WORLD_EVENT -> 0x28;
                case UNDEFINED -> -1;
            };
        }

        public PacketType getPacketType(int packetID) {
            return switch (packetID) {
                case 0x07 -> PacketType.BLOCK_ACTION;
                case 0x19 -> PacketType.DAMAGE_EVENT;
                case 0x02 -> PacketType.ENTITY_ANIMATION;
                case 0x7D -> PacketType.ENTITY_EFFECT;
                case 0x1E -> PacketType.ENTITY_EVENT;
                case 0x6D -> PacketType.ENTITY_SOUND_EFFECT;
                case 0x22 -> PacketType.GAME_EVENT;
                case 0x24 -> PacketType.HURT_ANIMATION;
                case 0x5D -> PacketType.LINK_ENTITIES;
                case 0x30 -> PacketType.MOVE_MINECART_ALONG_TRACK;
                case 0x29 -> PacketType.PARTICLE;
                case 0x75 -> PacketType.PICKUP_ITEM;
                case 0x80 -> PacketType.PROJECTILE_POWER;
                case 0x46 -> PacketType.REMOVE_ENTITIES;
                case 0x47 -> PacketType.REMOVE_ENTITY_EFFECT;
                case 0x5C -> PacketType.SET_ENTITY_METADATA;
                case 0x5E -> PacketType.SET_ENTITY_VELOCITY;
                case 0x5F -> PacketType.SET_EQUIPMENT;
                case 0x4C -> PacketType.SET_HEAD_ROTATION;
                case 0x64 -> PacketType.SET_PASSENGERS;
                case 0x6F -> PacketType.START_CONFIGURATION;
                case 0x6E -> PacketType.SOUND_EFFECT;
                case 0x01 -> PacketType.SPAWN_ENTITY;
                //case -1; -> PacketType.SPAWN_EXPERIENCE_ORB; // Unsupported packet - Packet type was removed in protocol 770+ (1.21.5+)
                case 0x76 -> PacketType.SYNCHRONIZE_VEHICLE_POSITION;
                case 0x1F -> PacketType.TELEPORT_ENTITY;
                case 0x7C -> PacketType.UPDATE_ATTRIBUTES;
                case 0x2E -> PacketType.UPDATE_ENTITY_POSITION;
                case 0x2F -> PacketType.UPDATE_ENTITY_POSITION_AND_ROTATION;
                case 0x31 -> PacketType.UPDATE_ENTITY_ROTATION;
                case 0x6A -> PacketType.UPDATE_TIME;
                case 0x28 -> PacketType.WORLD_EVENT;
                default -> PacketType.UNDEFINED;
            };
        }
    },
    ;

    private final int protocolVersion;


    Protocol(int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public static Protocol getProtocol(int protocolVersion) {
        return switch (protocolVersion) {
            case 767 -> Protocol.V_767;
            case 768 -> Protocol.V_768;
            case 769 -> Protocol.V_769;
            case 770 -> Protocol.V_770;
            case 771 -> Protocol.V_771;
            case 772 -> Protocol.V_772;
            default -> null;
        };
    }

    /**
     * The first set of packets within a replay are not normal "play" packets, but rather are login and/or configuration packets.
     * Parsing these login/configuration packets as "play" packets and manipulating them will likely lead to a replay file that cannot be loaded, and may softlock the client attempting to open it.
     * <p>
     * After this packet appears, the following packets within a replay can finally be read as "play" packets.
     */
    public abstract int getStateChangeToPlayPacketID();

    public abstract int getPacketID(PacketType packetType);

    public abstract PacketType getPacketType(int packetID);

    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getProtocolVersion());
    }


}
