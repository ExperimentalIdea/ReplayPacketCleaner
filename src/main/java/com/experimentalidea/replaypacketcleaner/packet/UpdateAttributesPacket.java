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

/// A read-only representation of a Set Update Attributes Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class UpdateAttributesPacket extends Packet {

    public UpdateAttributesPacket(long packetIndex, int timestamp, int entityID, int[] rawDataArrayBytes) {
        super(packetIndex, timestamp, PacketType.UPDATE_ATTRIBUTES);
        this.entityID = entityID;
        this.rawDataArrayBytes = rawDataArrayBytes;
    }

    private final int entityID;
    private final int[] rawDataArrayBytes;


    public int getEntityID() {
        return this.entityID;
    }

    /// TODO: Remove and replace in the future.
    @Deprecated
    public int[] getRawDataArrayBytes() {
        return this.rawDataArrayBytes;
    }

}
