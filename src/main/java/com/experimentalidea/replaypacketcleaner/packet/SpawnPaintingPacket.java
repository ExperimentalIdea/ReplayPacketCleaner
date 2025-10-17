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

/// A read-only representation of a Spawn Painting Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
/// Pack type removed and was merged into Spawn Entity in protocol version 759+ (1.19+)
public class SpawnPaintingPacket extends Packet {

    public SpawnPaintingPacket(long packetIndex, int timestamp, int entityID, UUID uuid, int motive, long x, long y, long z, byte direction) {
        super(packetIndex, timestamp, PacketType.Play.SPAWN_PAINTING);
        if (uuid == null) {
            throw new IllegalArgumentException("uuid cannot be null");
        }

        this.entityID = entityID;
        this.uuid = uuid;
        this.motive = motive;
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }

    private final int entityID;
    private final UUID uuid;
    private final int motive;
    private final long x, y, z;
    private final byte direction;


    public int getEntityID() {
        return this.entityID;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public int getMotive() {
        return motive;
    }

    public long getX() {
        return this.x;
    }

    public long getY() {
        return this.y;
    }

    public long getZ() {
        return this.z;
    }

    public byte getDirection() {
        return direction;
    }

}
