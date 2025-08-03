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

/// A read-only representation of a Projectile Power Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class ProjectilePowerPacket extends Packet {

    public ProjectilePowerPacket(long packetIndex, int timestamp, int entityID, double power) {
        super(packetIndex, timestamp, PacketType.PROJECTILE_POWER);
        this.entityID = entityID;
        this.power = power;
    }

    private final int entityID;
    private final double power;


    public int getEntityID() {
        return this.entityID;
    }

    public double getPower() {
        return this.power;
    }

}
