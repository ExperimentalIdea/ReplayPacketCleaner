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

/// A read-only representation of an Update Entity Position Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class UpdateEntityPositionPacket extends Packet {

    public UpdateEntityPositionPacket(long packetIndex, int timestamp, int entityID, short deltaX, short deltaY, short deltaZ, boolean onGround) {
        super(packetIndex, timestamp, PacketType.UPDATE_ENTITY_POSITION);
        this.entityID = entityID;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.deltaZ = deltaZ;
        this.onGround = onGround;
    }

    private final int entityID;
    private final short deltaX, deltaY, deltaZ;
    private final boolean onGround;


    public int getEntityID() {
        return this.entityID;
    }

    public short getDeltaX() {
        return this.deltaX;
    }

    public short getDeltaY() {
        return this.deltaY;
    }

    public short getDeltaZ() {
        return this.deltaZ;
    }

    public boolean isOnGround() {
        return this.onGround;
    }

}
