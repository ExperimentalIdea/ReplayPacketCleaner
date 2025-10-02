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

/**
 * A read-only representation of a Custom Sound Effect Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
 * In protocol version 761, this packet's function was merged into SOUND_EFFECT.
 * @see com.experimentalidea.replaypacketcleaner.packet.SoundEffectPacket
 * TODO: implement packet.
 */
public class CustomSoundEffectPacket extends Packet {

    public CustomSoundEffectPacket(long packetIndex, int timestamp, int[] rawDataBytes) {
        super(packetIndex, timestamp, PacketType.Play.CUSTOM_SOUND_EFFECT);
        this.rawDataBytes = rawDataBytes;
    }

    private final int[] rawDataBytes;

    /// TODO: Remove and implement packet
    @Deprecated
    public int[] getRawDataBytes() {
        return rawDataBytes;
    }


}
