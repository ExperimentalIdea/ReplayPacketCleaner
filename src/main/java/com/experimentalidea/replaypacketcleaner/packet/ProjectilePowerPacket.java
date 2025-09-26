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

/// A read-only representation of a Projectile Power Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class ProjectilePowerPacket extends Packet {

    /// Create a read-only Projectile Power packet representative of this packet type in protocols 767 or newer.
    public ProjectilePowerPacket(long packetIndex, int timestamp, int entityID, double power) {
        this(packetIndex, timestamp, entityID, true, power, 0.0, 0.0, 0.0);
    }

    /// Create a read-only Projectile Power packet representative of this packet type in protocols 766 or older.
    public ProjectilePowerPacket(long packetIndex, int timestamp, int entityID, double powerX, double powerY, double powerZ) {
        this(packetIndex, timestamp, entityID, false, 0.0, powerX, powerY, powerZ);
    }

    /// Create a read-only Projectile Power packet representative of this packet type in protocols before 767 or 767 and onward. (isPowerFieldSupported=true for 767+)
    public ProjectilePowerPacket(long packetIndex, int timestamp, int entityID, boolean isPowerFieldSupported, double power, double powerX, double powerY, double powerZ) {
        super(packetIndex, timestamp, PacketType.Play.PROJECTILE_POWER);
        this.entityID = entityID;
        this.isPowerFieldSupported = isPowerFieldSupported;
        this.power = power;
        this.powerX = powerX;
        this.powerY = powerY;
        this.powerZ = powerZ;
    }

    private final int entityID;

    private final boolean isPowerFieldSupported;
    private final double power;
    private final double powerX, powerY, powerZ;


    public int getEntityID() {
        return this.entityID;
    }

    public boolean isPowerFieldSupported() {
        return isPowerFieldSupported;
    }

    /// @throws IllegalStateException if isPowerFieldSupported() is false.
    public double getPower() throws IllegalStateException {
        if (!this.isPowerFieldSupported) {
            throw new IllegalStateException("getPower() is unsupported by this ProjectilePowerPacket instance");
        }
        return this.power;
    }

    /// @throws IllegalStateException if isPowerFieldSupported() is true.
    public double getPowerX() throws IllegalStateException {
        if (this.isPowerFieldSupported) {
            throw new IllegalStateException("getPowerX() is unsupported by this ProjectilePowerPacket instance");
        }
        return powerX;
    }

    /// @throws IllegalStateException if isPowerFieldSupported() is true.
    public double getPowerY() throws IllegalStateException {
        if (this.isPowerFieldSupported) {
            throw new IllegalStateException("getPowerY() is unsupported by this ProjectilePowerPacket instance");
        }
        return powerY;
    }

    /// @throws IllegalStateException if isPowerFieldSupported() is true.
    public double getPowerZ() throws IllegalStateException {
        if (this.isPowerFieldSupported) {
            throw new IllegalStateException("getPowerZ() is unsupported by this ProjectilePowerPacket instance");
        }
        return powerZ;
    }

}
