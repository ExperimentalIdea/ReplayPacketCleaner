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

/// A read-only representation of a Particle Packet. Currently, I don't see a need to do anything with this packet outside deleting it.
public class ParticlePacket extends Packet {


    public ParticlePacket(long packetIndex, int timestamp, boolean longDistance, boolean alwaysVisible, double x, double y, double z, float offsetX, float offsetY, float offsetZ, float maxSpeed, int particleCount, int particleID, int[] particleDataRawBytes) {
        super(packetIndex, timestamp, PacketType.Play.PARTICLE);
        if (particleDataRawBytes == null) {
            throw new IllegalArgumentException("particleDataRawBytes cannot be null");
        }

        this.longDistance = longDistance;
        this.alwaysVisible = alwaysVisible;
        this.x = x;
        this.y = y;
        this.z = z;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.maxSpeed = maxSpeed;
        this.particleCount = particleCount;
        this.particleID = particleID;
        this.particleDataRawBytes = particleDataRawBytes;
    }


    private final boolean longDistance, alwaysVisible;
    private final double x, y, z;
    private final float offsetX, offsetY, offsetZ;
    private final float maxSpeed;
    private final int particleCount;
    private final int particleID;

    private final int[] particleDataRawBytes;


    public boolean isLongDistance() {
        return this.longDistance;
    }

    public boolean isAlwaysVisible() {
        return this.alwaysVisible;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public float getOffsetX() {
        return this.offsetX;
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    public float getOffsetZ() {
        return this.offsetZ;
    }

    public float getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getParticleCount() {
        return this.particleCount;
    }

    public int getParticleID() {
        return this.particleID;
    }

    /// If there is data and what type of is dependent on the ParticleType
    @Deprecated
    public int[] getParticleDataRawBytes() {
        return this.particleDataRawBytes;
    }

    /* all 1.12.5 particle types
    public static enum ParticleType {
        /// Unknown Particle Type
        _UNDEFINED,

        ANGRY_VILLAGER,
        BLOCK,
        BLOCK_MARKER,
        BUBBLE,
        CLOUD,
        CRIT,
        DAMAGE_INDICATOR,
        DRAGON_BREATH,
        DRIPPING_LAVA,
        FALLING_LAVA,
        LANDING_LAVA,
        DRIPPING_WATER,
        FAILING_WATER,
        DUST,
        DUST_COLOR_TRANSITION,
        EFFECT,
        ELDER_GUARDIAN,
        ENCHANTED_HIT,
        ENCHANT,
        END_ROD,
        ENTITY_EFFECT,
        EXPLOSION_EMITTER,
        EXPLOSION,
        GUST,
        SMALL_GUST,
        GUST_EMITTER_LARGE,
        GUST_EMITTER_SMALL,
        SONIC_BOOM,
        FALLING_DUST,
        FIREWORK,
        FISHING,
        FLAME,
        INFESTED,
        CHERRY_LEAVES,
        PALE_OAK_LEAVES,
        TINTED_LEAVES,
        SCULK_SOUL,
        SCULK_CHARGE,
        SCULK_CHARGE_POP,
        SOUL_FIRE_FLAME,
        SOUL,
        FLASH,
        HAPPY_VILLAGER,
        COMPOSTER,
        HEART,
        INSTANT_EFFECT,
        ITEM,
        VIBRATION,
        TRAIL,
        ITEM_SLIME,
        ITEM_COBWEB,
        ITEM_SNOWBALL,
        LARGE_SMOKE,
        LAVA,
        MYCELIUM,
        NOTE,
        POOF,
        PORTAL,
        RAIN,
        SMOKE,
        WHITE_SMOKE,
        SNEEZE,
        SPIT,
        SQUID_INK,
        SWEEP_ATTACK,
        TOTEM_OF_UNDYING,
        UNDERWATER,
        SPLASH,
        WITCH,
        BUBBLE_POP,
        CURRENT_DOWN,
        BUBBLE_COLUMN_UP,
        NAUTILUS,
        DOLPHIN,
        CAMPFIRE_COSY_SMOKE,
        CAMPFIRE_SIGNAL_SMOKE,
        DRIPPING_HONEY,
        FALLING_HONEY,
        LANDING_HONEY,
        FALLING_NECTAR,
        FALLING_SPORE_BLOSSOM,
        ASH,
        CRIMSON_SPORE,
        WARPED_SPORE,
        SPORE_BLOSSOM_AIR,
        DRIPPING_OBSIDIAN_TEAR,
        FALLING_OBSIDIAN_TEAR,
        LANDING_OBSIDIAN_TEAR,
        REVERSE_PORTAL,
        WHITE_ASH,
        SMALL_FLAME,
        SNOWFLAKE,
        DRIPPING_DRIPSTONE_LAVA,
        FALLING_DRIPSTONE_LAVA,
        DRIPPING_DRIPSTONE_WATER,
        FALLING_DRIPSTONE_WATER,
        GLOW_SQUID_INK,
        GLOW,
        WAX_ON,
        WAX_OFF,
        ELECTRIC_SPARK,
        SCRAPE,
        SHRIEK,
        EGG_CRACK,
        DUST_PLUME,
        TRIAL_SPAWNER_DETECTION,
        TRIAL_SPAWNER_DETECTION_OMINOUS,
        VAULT_CONNECTION,
        DUST_PILLAR,
        OMINOUS_SPAWNING,
        RAID_OMEN,
        TRIAL_OMEN,
        BLOCK_CRUMBLE,
        FIREFLY

    }*/

}
