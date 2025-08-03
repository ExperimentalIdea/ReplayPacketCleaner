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

/// A read-only representation of a World Event Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class WorldEventPacket extends Packet {

    public WorldEventPacket(long packetIndex, int timestamp, int eventID, int positionX, int positionY, int positionZ, int data, boolean relativeVolumeDisabled) {
        super(packetIndex, timestamp, PacketType.WORLD_EVENT);
        this.eventID = eventID;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.data = data;
        this.disableRelativeVolume = relativeVolumeDisabled;
    }

    private final int eventID;
    private final int positionX, positionY, positionZ;
    private final int data;
    private final boolean disableRelativeVolume;


    /// An EventID less than 1500 is for sounds, greater than or equal to 1500 is for particles.
    /// It appears EventID greater than or equal to 3000 are for both sound and particles? Unsure at this time...
    public int getEventID() {
        return this.eventID;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public int getPositionZ() {
        return this.positionZ;
    }

    /// Data dependent on the type of event
    public int getData() {
        return this.data;
    }

    public boolean isRelativeVolumeDisabled() {
        return this.disableRelativeVolume;
    }

}
