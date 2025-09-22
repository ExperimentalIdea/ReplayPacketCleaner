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

/// A read-only representation of a Synchronize Vehicle Position Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class SynchronizeVehiclePositionPacket extends Packet {

    public SynchronizeVehiclePositionPacket(long packetIndex, int timestamp, int entityID, double x, double y, double z, double velocityX, double velocityY, double velocityZ, float yaw, float pitch, int teleportFlags, boolean onGround) {
        super(packetIndex, timestamp, PacketType.Play.SYNCHRONIZE_VEHICLE_POSITION);
        this.entityID = entityID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.yaw = yaw;
        this.pitch = pitch;
        this.teleportFlags = teleportFlags;
        this.onGround = onGround;
    }

    private final int entityID;
    private final double x, y, z;
    private final double velocityX, velocityY, velocityZ;
    private final float yaw, pitch;
    private final int teleportFlags;
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


    public double getVelocityX() {
        return this.velocityX;
    }

    public double getVelocityY() {
        return this.velocityY;
    }

    public double getVelocityZ() {
        return this.velocityZ;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    /// TODO: Break out flags for easy checking.
    @Deprecated
    public int getTeleportFlags() {
        return this.teleportFlags;
    }

    public boolean isOnGround() {
        return this.onGround;
    }

}
