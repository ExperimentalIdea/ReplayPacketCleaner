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

/// A read-only representation of an Entity Animation Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class EntityAnimationPacket extends Packet {

    public EntityAnimationPacket(long packetIndex, int timestamp, int entityID, AnimationType animationType) {
        super(packetIndex, timestamp, PacketType.ENTITY_ANIMATION);
        this.entityID = entityID;
        this.animationType = animationType;
    }

    private final int entityID;
    private final AnimationType animationType;

    public int getEntityID() {
        return this.entityID;
    }

    public AnimationType getAnimationType() {
        return this.animationType;
    }


    public static enum AnimationType {

        UNDEFINED,

        SWING_MAIN_HAND,

        /// NOTE: This type was removed in 1.20.2+ (protocol 764+)
        TAKE_DAMAGE,

        LEAVE_BED,

        SWING_OFF_HAND,

        CRITICAL_EFFECT,

        MAGIC_CRITICAL_EFFECT

    }

}
