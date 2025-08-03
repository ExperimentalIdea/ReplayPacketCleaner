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

/// A read-only representation of a Set Head Rotation Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class SetHeadRotationPacket extends Packet {

    public SetHeadRotationPacket(long packetIndex, int timestamp, int entityID, int headYawByte) {
        super(packetIndex, timestamp, PacketType.SET_HEAD_ROTATION);
        this.entityID = entityID;
        this.headYawByte = headYawByte;
    }

    private final int entityID;
    private final int headYawByte;


    public int getEntityID() {
        return this.entityID;
    }

    public int getHeadYawByte() {
        return this.headYawByte;
    }

}
