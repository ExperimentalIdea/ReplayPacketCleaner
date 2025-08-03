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

/// A representation of a Remove Entities Packet.
public class RemoveEntitiesPacket extends Packet {

    public RemoveEntitiesPacket(long packetIndex, int timestamp, int[] entityIDs) {
        super(packetIndex, timestamp, PacketType.REMOVE_ENTITIES);
        this.entityIDs = entityIDs;
    }

    private int[] entityIDs;


    ///  Returns the underlying int[] of entity ids
    public int[] getEntityIDs() {
        return this.entityIDs;
    }

    ///  Replace the underlying int[] of entity ids with a new one. Provided int[] must not be null.
    public void setEntityIDs(int[] entityIDs) {
        if (entityIDs == null) {
            throw new IllegalArgumentException("array entityIDs cannot be null");
        }
        this.entityIDs = entityIDs;
    }

}
