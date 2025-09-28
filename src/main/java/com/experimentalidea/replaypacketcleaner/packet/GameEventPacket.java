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

/// A representation of a Game Event Packet.
public class GameEventPacket extends Packet {


    public GameEventPacket(long packetIndex, int timestamp, GameEventType eventType, float value) {
        super(packetIndex, timestamp, PacketType.Play.GAME_EVENT);
        this.eventType = eventType;
        this.value = value;
    }

    private GameEventType eventType;
    private float value;


    public GameEventType getEventType() {
        return eventType;
    }

    public void setEventType(GameEventType eventType) {
        // todo: prevent setting unsupported event type in unsupported protocols? For now the packet just won't be written out if an invalid event type is set.
        this.eventType = eventType;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }


    public static enum GameEventType {

        /// Displays bed missing or obstructed message. Float value is ignored.
        NO_RESPAWN_BLOCK_AVAILABLE,

        /// Float value is ignored
        BEGIN_RAINING,

        /// Float value is ignored
        END_RAINING,

        /**
         * <p> 0: Survival,
         * <p> 1: Creative,
         * <p> 2: Adventure,
         * <p> 3: Spectator.
         */
        CHANGE_GAME_MODE,


        /**
         * <p> 0: Respawn player,
         * <p> 1: Roll credits and respawn player
         */
        WIN_GAME,

        /**
         * <p> 0: Display welcome to demo screen,
         * <p> 101: Display movement controls,
         * <p> 102: Display jump control,
         * <p> 103: Display inventory control,
         * <p> 104: Display demo has ended
         */
        DEMO_EVENT,

        /// A player is hit by an arrow. Float value is ignored
        ARROW_HIT_PLAYER,

        /// Float value range from 0 to 1
        RAIN_LEVEL_CHANGE,

        /// Float value from 0 to 1
        THUNDER_LEVEL_CHANGE,

        /// Float value is ignored
        PLAY_PUFFERFISH_STING_SOUND,

        /// Jump scare the player! Float value is ignored
        PLAY_ELDER_GUARDIAN_APPEARANCE,

        /**
         * <p> 0: Enable respawn screen,
         * <p> 1: Immediately respawn
         */
        ENABLE_RESPAWN_SCREEN,

        /**
         * <p> 0: Disable limited crafting,
         * <p> 1: Enable limited crafting
         * <p> Note: This is unsupported in protocol versions 763 (1.20.0/1) and older.
         */
        LIMITED_CRAFTING,

        /// Float value is ignored
        /// Note: This is unsupported in protocol versions 764 (1.20.2) and older.
        START_WAIT_FOR_LEVEL_CHUNKS;

    }

}
