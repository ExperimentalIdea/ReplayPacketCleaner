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

/// A read-only representation of a Remove Entity Effect Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class RemoveEntityEffectPacket extends Packet {

    public RemoveEntityEffectPacket(long packetIndex, int timestamp, int entityID, int effectID) {
        super(packetIndex, timestamp, PacketType.Play.ENTITY_EFFECT);

        this.entityID = entityID;
        this.effectID = effectID;
    }

    private final int entityID;
    private final int effectID;


    public int getEntityID() {
        return this.entityID;
    }

    public int getEffectID() {
        return this.effectID;
    }

}
