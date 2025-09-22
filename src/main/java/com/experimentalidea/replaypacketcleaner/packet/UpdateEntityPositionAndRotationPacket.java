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

/// A read-only representation of an Update Entity Position And Rotation Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class UpdateEntityPositionAndRotationPacket extends Packet {

    public UpdateEntityPositionAndRotationPacket(long packetIndex, int timestamp, int entityID, short deltaX, short deltaY, short deltaZ, int yawByte, int pitchByte, boolean onGround) {
        super(packetIndex, timestamp, PacketType.Play.UPDATE_ENTITY_POSITION_AND_ROTATION);
        this.entityID = entityID;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.deltaZ = deltaZ;
        this.yawByte = yawByte;
        this.pitchByte = pitchByte;
        this.onGround = onGround;
    }

    private final int entityID;
    private final short deltaX, deltaY, deltaZ;
    private final int yawByte, pitchByte;
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

    public int getYawByte() {
        return this.yawByte;
    }

    public int getPitchByte() {
        return this.pitchByte;
    }

    public boolean isOnGround() {
        return this.onGround;
    }

}
