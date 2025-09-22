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

/// A read-only representation of a Damage Event Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class DamageEventPacket extends Packet {

    public DamageEventPacket(long packetIndex, int timestamp, int entityID, int sourceTypeID, int sourceCauseID, int sourceDirectID, boolean hasSourcePosition, double sourcePositionX, double sourcePositionY, double sourcePositionZ) {
        super(packetIndex, timestamp, PacketType.Play.DAMAGE_EVENT);
        this.entityID = entityID;
        this.sourceTypeID = sourceTypeID;
        this.sourceCauseID = sourceCauseID;
        this.sourceDirectID = sourceDirectID;
        this.hasSourcePosition = hasSourcePosition;
        this.sourcePositionX = sourcePositionX;
        this.sourcePositionY = sourcePositionY;
        this.sourcePositionZ = sourcePositionZ;
    }

    private final int entityID;
    private final int sourceTypeID;
    private final int sourceCauseID;
    private final int sourceDirectID;
    private final boolean hasSourcePosition;
    private final double sourcePositionX;
    private final double sourcePositionY;
    private final double sourcePositionZ;


    public int getEntityID() {
        return this.entityID;
    }

    public int getSourceTypeID() {
        return this.sourceTypeID;
    }

    public int getSourceCauseID() {
        return this.sourceCauseID;
    }

    public int getSourceDirectID() {
        return this.sourceDirectID;
    }

    public boolean hasSourcePosition() {
        return this.hasSourcePosition;
    }

    /// @throws IllegalStateException if hasSourcePosition() is false
    public double getSourcePositionX() throws IllegalStateException {
        this.isSourcePositionPresent();
        return this.sourcePositionX;
    }

    /// @throws IllegalStateException if hasSourcePosition() is false
    public double getSourcePositionY() throws IllegalStateException {
        this.isSourcePositionPresent();
        return this.sourcePositionY;
    }

    /// @throws IllegalStateException if hasSourcePosition() is false
    public double getSourcePositionZ() throws IllegalStateException {
        this.isSourcePositionPresent();
        return this.sourcePositionZ;
    }

    /// Returns if source position is present, otherwise throws {@link IllegalStateException}.
    private void isSourcePositionPresent() throws IllegalStateException {
        if (!this.hasSourcePosition) {
            throw new IllegalStateException("This packet does not have a source position. Can only get the source position if hasSourcePosition() is true.");
        }
    }

}
