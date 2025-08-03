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

/// A representation of an Update Time Packet.
public class UpdateTimePacket extends Packet {


    public UpdateTimePacket(long packetIndex, int timestamp, long worldAge, long timeOfDay, boolean timeAdvances) {
        super(packetIndex, timestamp, PacketType.UPDATE_TIME);
        this.worldAge = worldAge;
        this.timeOfDay = timeOfDay;
        this.timeAdvances = timeAdvances;
    }

    private long worldAge;
    private long timeOfDay;
    private boolean timeAdvances;


    public long getWorldAge() {
        return this.worldAge;
    }

    public void setWorldAge(long worldAge) {
        this.worldAge = worldAge;
    }


    public long getTimeOfDay() {
        return this.timeOfDay;
    }

    public void setTimeOfDay(long timeOfDay) {
        this.timeOfDay = timeOfDay;
    }


    public boolean doesTimeAdvance() {
        return this.timeAdvances;
    }

    public void setTimeAdvance(boolean timeAdvances) {
        this.timeAdvances = timeAdvances;
    }


}
