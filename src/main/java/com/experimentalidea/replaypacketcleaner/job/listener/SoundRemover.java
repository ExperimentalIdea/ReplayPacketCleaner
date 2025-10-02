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

import com.experimentalidea.replaypacketcleaner.packet.*;
import com.experimentalidea.replaypacketcleaner.packet.listener.*;

/// Removes most sound effects
public class SoundRemover implements CustomSoundEffectPacketListener, EntitySoundEffectPacketListener, SoundEffectPacketListener, GameEventPacketListener, WorldEventPacketListener {

    public SoundRemover() {

    }

    @Override
    public void onCustomSoundEffectPacket(CustomSoundEffectPacket customSoundEffectPacket) {
        customSoundEffectPacket.setWriteCanceled(true);
    }

    @Override
    public void onEntitySoundEffectPacket(EntitySoundEffectPacket entitySoundEffectPacket) {
        entitySoundEffectPacket.setWriteCanceled(true);
    }

    @Override
    public void onSoundEffectPacket(SoundEffectPacket soundEffectPacket) {
        soundEffectPacket.setWriteCanceled(true);
    }

    @Override
    public void onGameEventPacket(GameEventPacket gameEventPacket) {
        GameEventPacket.GameEventType eventType = gameEventPacket.getEventType();
        if (eventType == GameEventPacket.GameEventType.PLAY_PUFFERFISH_STING_SOUND || eventType == GameEventPacket.GameEventType.PLAY_ELDER_GUARDIAN_APPEARANCE) {
            gameEventPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onWorldEventPacket(WorldEventPacket worldEventPacket) {
        if (worldEventPacket.getEventID() < 1500) { // Appears values 3000+ may be particle & sound? Will have to look into that later...
            worldEventPacket.setWriteCanceled(true);
        }
    }

}
