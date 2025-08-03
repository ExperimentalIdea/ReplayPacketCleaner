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

/// A read-only representation of a Block Action Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class BlockActionPacket extends Packet {


    public BlockActionPacket(long packetIndex, int timestamp, int positionX, int positionY, int positionZ, int actionIDByte, int actionParameterByte, int blockType) {
        super(packetIndex, timestamp, PacketType.BLOCK_ACTION);
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;

        this.actionIDByte = actionIDByte;
        this.actionParameterByte = actionParameterByte;

        this.blockType = blockType;
    }

    private final int positionX, positionY, positionZ;
    private final int actionIDByte;
    private final int actionParameterByte;
    private final int blockType;


    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public int getPositionZ() {
        return this.positionZ;
    }


    public int getActionIDByte() {
        return this.actionIDByte;
    }

    public int getActionParameterByte() {
        return this.actionParameterByte;
    }


    public int getBlockType() {
        return this.blockType;
    }

}
