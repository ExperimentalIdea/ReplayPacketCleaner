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

import com.experimentalidea.replaypacketcleaner.protocol.EntityType;
import com.experimentalidea.replaypacketcleaner.protocol.PacketType;

import java.util.UUID;

/// A read-only representation of a Spawn Entity Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class SpawnEntityPacket extends Packet {

    public SpawnEntityPacket(long packetIndex, int timestamp, int entityID, UUID uuid, EntityType entityType, double x, double y, double z, int pitchByte, int yawByte, int headYawByte, int data, short velocityX, short velocityY, short velocityZ) {
        super(packetIndex, timestamp, PacketType.Play.SPAWN_ENTITY);
        if (uuid == null) {
            throw new IllegalArgumentException("uuid cannot be null");
        }
        if (entityType == null) {
            throw new IllegalArgumentException("entityType cannot be null");
        }

        this.entityID = entityID;
        this.uuid = uuid;
        this.entityType = entityType;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitchByte = pitchByte;
        this.yawByte = yawByte;
        this.headYawByte = headYawByte;
        this.data = data;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
    }

    private final int entityID;
    private final UUID uuid;
    private final EntityType entityType;
    private final double x, y, z;
    private final int pitchByte, yawByte, headYawByte;
    private final int data;
    private final short velocityX, velocityY, velocityZ;


    public int getEntityID() {
        return this.entityID;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public EntityType getEntityType() {
        return this.entityType;
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

    public int getPitchByte() {
        return this.pitchByte;
    }

    public int getYawByte() {
        return this.yawByte;
    }

    public int getHeadYawByte() {
        return this.headYawByte;
    }

    public int getData() {
        return this.data;
    }

    public short getVelocityX() {
        return this.velocityX;
    }

    public short getVelocityY() {
        return this.velocityY;
    }

    public short getVelocityZ() {
        return this.velocityZ;
    }

}
