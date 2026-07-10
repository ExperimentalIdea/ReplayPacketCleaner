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

/// A read-only representation of a Spawn Weather Entity Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
/// Pack type removed and was merged into Spawn Entity(?) in protocol version 735+ (1.16+)
public class SpawnWeatherEntityPacket extends Packet {

    public SpawnWeatherEntityPacket(long packetIndex, int timestamp, int entityID, int typeEnumByte, double x, double y, double z) {
        super(packetIndex, timestamp, PacketType.Play.SPAWN_WEATHER_ENTITY);

        this.entityID = entityID;
        this.typeEnumByte = typeEnumByte;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private final int entityID;
    private final int typeEnumByte;
    private final double x, y, z;


    public int getEntityID() {
        return this.entityID;
    }

    public int getTypeEnumByte() {
        return this.typeEnumByte;
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

}
