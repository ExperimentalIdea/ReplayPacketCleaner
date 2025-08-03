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
package com.experimentalidea.replaypacketcleaner.packet;

import com.experimentalidea.replaypacketcleaner.protocol.PacketType;

/// A read-only representation of a Teleport Entity Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class TeleportEntityPacket extends Packet {

    /// Create a Teleport Entity Packet and specify if the velocityX/Y/Z fields are present in the source packet data and provided here.
    public TeleportEntityPacket(long packetIndex, int timestamp, int entityID, double x, double y, double z, boolean hasVelocityFields, double velocityX, double velocityY, double velocityZ, float yaw, float pitch, boolean onGround) {
        super(packetIndex, timestamp, PacketType.TELEPORT_ENTITY);
        this.entityID = entityID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.hasVelocityFields = hasVelocityFields;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }

    /// Create a Teleport Entity Packet with the velocity fields (as they are present in versions 1.21.2+ (protocol 768+))
    public TeleportEntityPacket(long packetIndex, int timestamp, int entityID, double x, double y, double z, double velocityX, double velocityY, double velocityZ, float yaw, float pitch, boolean onGround) {
        this(packetIndex, timestamp, entityID, x, y, z, true, velocityX, velocityY, velocityZ, yaw, pitch, onGround);
    }

    /// Create a Teleport Entity Packet without the velocity fields (as they are not present in versions before 1.21.2 (protocol 768))
    public TeleportEntityPacket(long packetIndex, int timestamp, int entityID, double x, double y, double z, float yaw, float pitch, boolean onGround) {
        this(packetIndex, timestamp, entityID, x, y, z, false, 0, 0, 0, yaw, pitch, onGround);
    }

    private final int entityID;
    private final double x, y, z;
    private final boolean hasVelocityFields; // Only present in 1.21.2+ (protocol 768+)
    private final double velocityX, velocityY, velocityZ;
    private final float yaw, pitch;
    private final boolean onGround;


    public int getEntityID() {
        return this.entityID;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    /// The velocityX/Y/Z fields are only present in 1.21.2+ (protocol 768+) packets.
    /// The getVelocity*() methods will throw {@link IllegalStateException} if this returns false.
    public boolean hasVelocityFields() {
        return this.hasVelocityFields;
    }

    /// @throws IllegalStateException if hasVelocityFields() is false
    public double getVelocityX() throws IllegalStateException {
        this.isVelocityFieldsPresent();
        return this.velocityX;
    }

    /// @throws IllegalStateException if hasVelocityFields() is false
    public double getVelocityY() throws IllegalStateException {
        this.isVelocityFieldsPresent();
        return this.velocityY;
    }

    /// @throws IllegalStateException if hasVelocityFields() is false
    public double getVelocityZ() throws IllegalStateException {
        this.isVelocityFieldsPresent();
        return this.velocityZ;
    }

    private void isVelocityFieldsPresent() {
        if (!this.hasVelocityFields) {
            throw new IllegalStateException("This packet does not have the velocityX/Y/Z fields. Can only get the velocity fields if hasSourcePosition() is true.");
        }
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public boolean isOnGround() {
        return this.onGround;
    }

}
