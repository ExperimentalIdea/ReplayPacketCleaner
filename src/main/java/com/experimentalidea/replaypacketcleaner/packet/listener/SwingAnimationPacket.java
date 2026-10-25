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
package com.experimentalidea.replaypacketcleaner.packet.listener;

import com.experimentalidea.replaypacketcleaner.packet.Packet;
import com.experimentalidea.replaypacketcleaner.protocol.PacketType;

/// A read-only representation of a Swing Animation Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class SwingAnimationPacket extends Packet {

    public SwingAnimationPacket(long packetIndex, int timestamp, int entityID, Hand hand, AnimationType animationType, int duration) {
        super(packetIndex, timestamp, PacketType.Play.ENTITY_ANIMATION);
        this.entityID = entityID;
        this.hand = hand;
        this.animationType = animationType;
        this.duration = duration;
    }

    private final int entityID;
    private final Hand hand;
    private final AnimationType animationType;
    private final int duration;

    public int getEntityID() {
        return this.entityID;
    }

    public Hand getHand() {
        return hand;
    }

    public AnimationType getAnimationType() {
        return this.animationType;
    }

    public int getDuration() {
        return duration;
    }


    public static enum Hand {

        UNDEFINED,

        MAIN_HAND,

        OFF_HAND
    }

    public static enum AnimationType {

        UNDEFINED,

        NONE,

        WHACK,

        STAB
    }

}
