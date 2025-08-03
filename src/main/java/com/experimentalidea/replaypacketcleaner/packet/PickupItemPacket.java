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

/// A read-only representation of a Pickup Item Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class PickupItemPacket extends Packet {

    public PickupItemPacket(long packetIndex, int timestamp, int collectedEntityID, int collectorEntityID, int pickupItemCount) {
        super(packetIndex, timestamp, PacketType.PICKUP_ITEM);
        this.collectedEntityID = collectedEntityID;
        this.collectorEntityID = collectorEntityID;
        this.pickupItemCount = pickupItemCount;
    }

    private final int collectedEntityID;
    private final int collectorEntityID;
    private final int pickupItemCount;


    /// Get the id of the entity being collected.
    public int getCollectedEntityID() {
        return this.collectedEntityID;
    }

    /// Get the id of the entity collecting the item.
    public int getCollectorEntityID() {
        return this.collectorEntityID;
    }

    /// Get the number of items in the stack.
    public int getPickupItemCount() {
        return pickupItemCount;
    }

}
