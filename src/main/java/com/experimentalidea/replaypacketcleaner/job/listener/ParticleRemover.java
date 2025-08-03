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
package com.experimentalidea.replaypacketcleaner.job.listener;

import com.experimentalidea.replaypacketcleaner.packet.listener.ParticlePacketListener;
import com.experimentalidea.replaypacketcleaner.packet.listener.WorldEventPacketListener;
import com.experimentalidea.replaypacketcleaner.packet.ParticlePacket;
import com.experimentalidea.replaypacketcleaner.packet.WorldEventPacket;

/// Removes most particle effects
public class ParticleRemover implements ParticlePacketListener, WorldEventPacketListener {

    public ParticleRemover() {

    }


    @Override
    public void onParticlePacket(ParticlePacket particlePacket) {
        particlePacket.setWriteCanceled(true);
    }

    @Override
    public void onWorldEventPacket(WorldEventPacket worldEventPacket) {
        if (worldEventPacket.getEventID() >= 1500) { // Appears values 3000+ may be particle & sound? Will have to look into that later...
            worldEventPacket.setWriteCanceled(true);
        }
    }

    /*
    EntityEffectPacket & RemoveEntityEffectPacket don't seem to effect the potion particles around an entity. They only seem to play for the player entity.
    Guessing those packets are intended for updating the hud/inventory screen with the current player status.
    As far as for replays, the EntityEffectPacket & RemoveEntityEffectPacket appear to be effectively useless.
     */

}
