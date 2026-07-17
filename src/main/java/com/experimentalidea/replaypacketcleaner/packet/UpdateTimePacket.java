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

/// A representation of an Update Time Packet.  TODO: Consider adding safety checks to prevent null entries for clocks.
public class UpdateTimePacket extends Packet {


    public UpdateTimePacket(long packetIndex, int timestamp, long worldAge, Clock[] clocks) {
        super(packetIndex, timestamp, PacketType.Play.UPDATE_TIME);
        this.worldAge = worldAge;
        this.clocks = clocks;
    }

    private long worldAge;
    private Clock[] clocks;


    public long getWorldAge() {
        return this.worldAge;
    }

    public void setWorldAge(long worldAge) {
        this.worldAge = worldAge;
    }


    public Clock[] getClocks() {
        return this.clocks;
    }

    void setClocks(Clock[] clocks) {
        this.clocks = clocks;
    }


    public static class Clock {

        public Clock(int id, long time, float fractionalTime, float advancementRate) {
            this.id = id;
            this.time = time;
            this.fractionalTime = fractionalTime;
            this.advancementRate = advancementRate;
        }

        public static final int DEFAULT_CLOCK_ID = -1;
        public static final float DEFAULT_FRACTIONAL_TIME = 0.0F;
        public static final float DEFAULT_ADVANCEMENT_RATE = 1.0F;

        private int id;
        private long time;
        private float fractionalTime;
        private float advancementRate;


        public int getID() {
            return this.id;
        }

        void setID(int id) {
            this.id = id;
        }


        public long getTime() {
            return this.time;
        }

        public void setTime(long time) {
            this.time = time;
        }


        public float getFractionalTime() {
            return this.fractionalTime;
        }

        public void setFractionalTime(float fractionalTime) {
            this.fractionalTime = fractionalTime;
        }


        public float getTimeAdvancementRate() {
            return this.advancementRate;
        }

        public void setTimeAdvancementRate(float advancementRate) {
            this.advancementRate = advancementRate;
        }
    }

}
