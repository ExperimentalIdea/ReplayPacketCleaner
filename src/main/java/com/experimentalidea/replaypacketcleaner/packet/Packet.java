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

/// The basis of a protocol agnostic representation of a Packet.
public abstract class Packet {

    public Packet(long packetIndex, int timestamp, PacketType packetType) {
        this.packetIndex = packetIndex;
        this.writeCanceled = false;

        this.timestamp = timestamp;
        this.packetType = packetType;
    }

    private final long packetIndex;
    private boolean writeCanceled;

    private int timestamp;
    private final PacketType packetType;


    public long getPacketIndex() {
        return packetIndex;
    }

    public boolean isWriteCanceled() {
        return this.writeCanceled;
    }

    public void setWriteCanceled(boolean writeCanceled) {
        this.writeCanceled = writeCanceled;
    }


    public int getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }


    public PacketType getpacketType() {
        return this.packetType;
    }


}
