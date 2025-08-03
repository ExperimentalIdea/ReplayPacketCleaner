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

/// A representation of a Link Entity Packet.
public class LinkEntitiesPacket extends Packet {

    public LinkEntitiesPacket(long packetIndex, int timestamp, int attachedEntityID, int holdingEntityID) {
        super(packetIndex, timestamp, PacketType.LINK_ENTITIES);
        this.attachedEntityID = attachedEntityID;
        this.holdingEntityID = holdingEntityID;
    }

    private int attachedEntityID;
    private int holdingEntityID;


    /// Get the id of the entity holding the lead.
    public int getAttachedEntityID() {
        return this.attachedEntityID;
    }

    /// Set the id of the entity holding the lead.
    public void setAttachedEntityID(int attachedEntityID) {
        this.attachedEntityID = attachedEntityID;
    }

    /// Get the id of the entity being leashed by the attached entity. A value of -1 is for detaching a previously leashed holding entity.
    public int getHoldingEntityID() {
        return this.holdingEntityID;
    }

    /// Set the id of the entity being leashed by the attached entity. A value of -1 is for detaching a previously leashed holding entity.
    public void setHoldingEntityID(int holdingEntityID) {
        this.holdingEntityID = holdingEntityID;
    }
}
