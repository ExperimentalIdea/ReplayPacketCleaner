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

/// A representation of a Set Passengers Packet.
public class SetPassengersPacket extends Packet {

    public SetPassengersPacket(long packetIndex, int timestamp, int entityID, int[] passengerEntityIDs) {
        super(packetIndex, timestamp, PacketType.Play.SET_PASSENGERS);
        this.entityID = entityID;
        this.passengerEntityIDs = passengerEntityIDs;
    }

    private int entityID;
    private int[] passengerEntityIDs;


    public int getEntityID() {
        return this.entityID;
    }

    public void setEntityID(int entityID) {
        this.entityID = entityID;
    }

    ///  Returns the underlying int[] of entity ids
    public int[] getPassengerEntityIDs() {
        return this.passengerEntityIDs;
    }

    ///  Replace the underlying int[] of passenger entity ids with a new one. Provided int[] must not be null.
    public void setPassengerIDs(int[] passengerEntityIDs) {
        if (passengerEntityIDs == null) {
            throw new IllegalArgumentException("array passengerEntityIDs cannot be null");
        }
        this.passengerEntityIDs = passengerEntityIDs;
    }

}
