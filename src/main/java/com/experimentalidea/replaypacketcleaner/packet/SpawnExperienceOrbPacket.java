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

/// A read-only representation of a Spawn Experience Orb Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
/// NOTE: This packet type was removed in protocol 770+ (1.21.5+)
public class SpawnExperienceOrbPacket extends Packet {

    public SpawnExperienceOrbPacket(long packetIndex, int timestamp, int entityID, double x, double y, double z, short count) {
        super(packetIndex, timestamp, PacketType.Play.SPAWN_EXPERIENCE_ORB);

        this.entityID = entityID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
    }

    private final int entityID;
    private final double x, y, z;
    private final short count;


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

    public short getCount() {
        return count;
    }

}
