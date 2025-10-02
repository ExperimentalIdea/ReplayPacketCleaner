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

/// A read-only representation of a Spawn Player Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
/// Note: This packet type was removed in protocol version 764+ (1.20.2+)
public class SpawnPlayerPacket extends Packet {

    public SpawnPlayerPacket(long packetIndex, int timestamp, int entityID, UUID uuid, double x, double y, double z, int yawByte, int pitchByte) {
        super(packetIndex, timestamp, PacketType.Play.SPAWN_PLAYER);
        if (uuid == null) {
            throw new IllegalArgumentException("uuid cannot be null");
        }

        this.entityID = entityID;
        this.uuid = uuid;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yawByte = yawByte;
        this.pitchByte = pitchByte;

    }

    private final int entityID;
    private final UUID uuid;
    private final double x, y, z;
    private final int yawByte, pitchByte;


    public int getEntityID() {
        return this.entityID;
    }

    public UUID getUuid() {
        return this.uuid;
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

    public int getYawByte() {
        return this.yawByte;
    }

    public int getPitchByte() {
        return this.pitchByte;
    }

}
