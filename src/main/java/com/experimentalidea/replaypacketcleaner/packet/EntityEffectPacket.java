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

/// A read-only representation of an Entity Effect Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class EntityEffectPacket extends Packet {

    public EntityEffectPacket(long packetIndex, int timestamp, int entityID, int effectID, int amplifier, int duration, boolean isAmbient, boolean showParticles, boolean showIcon, boolean blend) {
        super(packetIndex, timestamp, PacketType.ENTITY_EFFECT);

        this.entityID = entityID;
        this.effectID = effectID;
        this.amplifier = amplifier;
        this.duration = duration;
        this.isAmbient = isAmbient;
        this.showParticles = showParticles;
        this.showIcon = showIcon;
        this.blend = blend;
    }

    private final int entityID;
    private final int effectID;
    private final int amplifier;
    private final int duration;
    private final boolean isAmbient, showParticles, showIcon, blend;


    public int getEntityID() {
        return this.entityID;
    }

    public int getEffectID() {
        return this.effectID;
    }

    public int getAmplifier() {
        return this.amplifier;
    }

    ///  Returns duration in ticks. -1 for infinity
    public int getDuration() {
        return this.duration;
    }

    /// Flag isAmbient
    public boolean isAmbient() {
        return this.isAmbient;
    }

    /// Flag showParticles
    public boolean showParticles() {
        return this.showParticles;
    }

    /// Flag showIcon
    public boolean showIcon() {
        return this.showIcon;
    }

    /// Flag blend
    public boolean shouldBlend() {
        return this.blend;
    }

}
