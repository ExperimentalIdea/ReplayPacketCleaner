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

/// A read-only representation of a Set Entity Velocity Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class SetEntityVelocityPacket extends Packet {

    public SetEntityVelocityPacket(long packetIndex, int timestamp, int entityID, short velocityX, short velocityY, short velocityZ) {
        super(packetIndex, timestamp, PacketType.Play.SET_ENTITY_VELOCITY);
        this.entityID = entityID;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
    }

    private final int entityID;
    private final short velocityX, velocityY, velocityZ;


    public int getEntityID() {
        return this.entityID;
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
