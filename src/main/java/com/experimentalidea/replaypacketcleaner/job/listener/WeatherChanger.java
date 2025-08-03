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

import com.experimentalidea.replaypacketcleaner.packet.listener.GameEventPacketListener;
import com.experimentalidea.replaypacketcleaner.packet.listener.StartOfReplayPacketInserter;
import com.experimentalidea.replaypacketcleaner.packet.GameEventPacket;
import com.experimentalidea.replaypacketcleaner.packet.Packet;

public class WeatherChanger implements GameEventPacketListener, StartOfReplayPacketInserter {

    /**
     * Creates {@link GameEventPacketListener} / {@link StartOfReplayPacketInserter} that fixes the weather to a set state.
     * TODO: Need to implement feature to remove lighting strikes.
     *
     * @param isRaining    Set if it should or should not be raining.
     * @param rainLevel    The rain level. A value ranging from 0.0 to 1.0. Ignored if isRaining is false.
     * @param thunderLevel The thunder level. A value ranging from 0.0 to 1.0. Ignored if isRaining is false.
     */
    public WeatherChanger(boolean isRaining, float rainLevel, float thunderLevel) {
        if (rainLevel < 0.0F) {
            rainLevel = 0.0F;
        }
        if (rainLevel > 1.0F) {
            rainLevel = 1.0F;
        }
        if (thunderLevel < 0.0F) {
            thunderLevel = 0.0F;
        }
        if (thunderLevel > 1.0F) {
            thunderLevel = 1.0F;
        }

        this.isRaining = isRaining;
        this.rainLevel = rainLevel;
        this.thunderLevel = thunderLevel;
    }

    private final boolean isRaining;
    private final float rainLevel;
    private final float thunderLevel;


    // Set the weather state at the start of the replay.
    @Override
    public Packet[] insertPackets() {
        if (this.isRaining) {
            GameEventPacket beginRaining = new GameEventPacket(0, 0, GameEventPacket.GameEventType.BEGIN_RAINING, 0.0F);
            GameEventPacket rainLevelChange = new GameEventPacket(0, 0, GameEventPacket.GameEventType.RAIN_LEVEL_CHANGE, this.rainLevel);
            GameEventPacket thunderLevelChange = new GameEventPacket(0, 0, GameEventPacket.GameEventType.THUNDER_LEVEL_CHANGE, this.thunderLevel);
            return new Packet[]{beginRaining, rainLevelChange, thunderLevelChange};
        }
        return null;
    }

    // Delete all weather related game event packets
    @Override
    public void onGameEventPacket(GameEventPacket gameEventPacket) {
        GameEventPacket.GameEventType event = gameEventPacket.getEventType();
        switch (event) {
            case BEGIN_RAINING, THUNDER_LEVEL_CHANGE, END_RAINING, RAIN_LEVEL_CHANGE ->
                    gameEventPacket.setWriteCanceled(true);

            default -> {
                // Do nothing.
            }
        }
    }

}
