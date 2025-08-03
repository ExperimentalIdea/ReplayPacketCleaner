package com.experimentalidea.replaypacketcleaner.protocol;

public enum PacketType {

    UNDEFINED,

    /// NOTE: Packet structure changed from 1.13.x to 1.14.x. The position is encoded as XYZ in 1.13.x and older, while it is encoded as XZY in 1.14.x+
    BLOCK_ACTION,

    DAMAGE_EVENT,

    ENTITY_ANIMATION,

    /// For all potion/status effects.
    /// Seems this is only for the client (player) to display effect durations, removing it has no effect on potion particles.
    /// I believe the Set Entity Metadata packet may be responsible for those particles.
    ENTITY_EFFECT,

    ENTITY_EVENT,

    ENTITY_SOUND_EFFECT,

    GAME_EVENT,

    HURT_ANIMATION,

    LINK_ENTITIES,

    /// NOTE: Packet is new to protocol 768+ (1.21.2+).
    MOVE_MINECART_ALONG_TRACK,

    /// NOTE: Packet structure changed since protocol 769+ (1.21.4+). New field alwaysVisible.
    PARTICLE,

    /// This packet is purely for the animation of an item being picked up by an entity
    PICKUP_ITEM,

    PROJECTILE_POWER,

    REMOVE_ENTITIES,

    /// For all potion/status effects
    REMOVE_ENTITY_EFFECT,

    // TODO: add Set Block Destroy Stage packet

    SET_ENTITY_METADATA,

    SET_ENTITY_VELOCITY,

    SET_EQUIPMENT,

    SET_HEAD_ROTATION,

    SET_PASSENGERS,

    SOUND_EFFECT,

    SPAWN_ENTITY,

    /// NOTE: This packet type was removed in 770+ (1.21.5+)
    SPAWN_EXPERIENCE_ORB,

    START_CONFIGURATION,

    /// NOTE: Packet is new to protocol 768+ (1.21.2+).
    SYNCHRONIZE_VEHICLE_POSITION,

    /// NOTE: Packet structure changed since protocol 768+ (1.21.2+). New fields for velocity and yaw/pitch.
    TELEPORT_ENTITY,

    UPDATE_ATTRIBUTES,

    UPDATE_ENTITY_POSITION,

    UPDATE_ENTITY_POSITION_AND_ROTATION,

    UPDATE_ENTITY_ROTATION,

    /// NOTE: Packet structure changed since protocol 768+ (1.21.2+). New field timeAdvances (timeOfDayIncreasing)
    UPDATE_TIME,

    /// NOTE: Packet structure changed from 1.13.x to 1.14.x. The position is encoded as XYZ in 1.13.x and older, while it is encoded as XZY in 1.14.x+
    WORLD_EVENT,


}
