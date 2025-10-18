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
package com.experimentalidea.replaypacketcleaner.job;

import com.experimentalidea.replaypacketcleaner.packet.*;
import com.experimentalidea.replaypacketcleaner.packet.listener.*;
import com.experimentalidea.replaypacketcleaner.protocol.EntityType;
import com.experimentalidea.replaypacketcleaner.protocol.PacketType;
import com.experimentalidea.replaypacketcleaner.protocol.Protocol;
import com.experimentalidea.replaypacketcleaner.protocol.Version;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReplayManipulationTask implements Runnable {


    public ReplayManipulationTask(ReplayReader replayReader, long sourceReplaySizeBytes, ReplayWriter replayWriter, Protocol protocol, TaskTracker taskTracker, AtomicBoolean cancelFlag, PacketListener... packetListeners) {
        if (replayReader == null) {
            throw new IllegalArgumentException("replayReader cannot be null");
        }
        if (replayWriter == null) {
            throw new IllegalArgumentException("replayWriter cannot be null");
        }
        if (protocol == null) {
            throw new IllegalArgumentException("protocol cannot be null");
        }
        if (taskTracker == null) {
            throw new IllegalArgumentException("taskProgress cannot be null");
        }
        if (cancelFlag == null) {
            throw new IllegalArgumentException("cancelFlag cannot be null");
        }
        if (packetListeners == null) {
            throw new IllegalArgumentException("The PacketListener[] cannot be null");
        }

        this.reader = replayReader;
        this.sourceReplaySizeBytes = sourceReplaySizeBytes;
        this.writer = replayWriter;
        this.protocol = protocol;
        this.protocolVersion = this.protocol.getProtocolVersion();
        this.taskTracker = taskTracker;
        this.cancelFlag = cancelFlag;

        List<StartOfReplayPacketInserter> startOfReplayPacketInserterList = new ArrayList<StartOfReplayPacketInserter>(packetListeners.length);
        List<BlockActionPacketListener> blockActionPacketListenerList = new ArrayList<BlockActionPacketListener>(packetListeners.length);
        List<CustomSoundEffectPacketListener> customSoundEffectPacketListenerList = new ArrayList<CustomSoundEffectPacketListener>(packetListeners.length);
        List<DamageEventPacketListener> damageEventPacketListenerList = new ArrayList<DamageEventPacketListener>(packetListeners.length);
        List<EntityAnimationPacketListener> entityAnimationPacketListenerList = new ArrayList<EntityAnimationPacketListener>(packetListeners.length);
        List<EntityEffectPacketListener> entityEffectPacketListenerList = new ArrayList<EntityEffectPacketListener>(packetListeners.length);
        List<EntityEventPacketListener> entityEventPacketListenerList = new ArrayList<EntityEventPacketListener>(packetListeners.length);
        List<EntitySoundEffectPacketListener> entitySoundEffectPacketListenerList = new ArrayList<EntitySoundEffectPacketListener>(packetListeners.length);
        List<GameEventPacketListener> gameEventPacketListenerList = new ArrayList<GameEventPacketListener>(packetListeners.length);
        List<HurtAnimationPacketListener> hurtAnimationPacketListenerList = new ArrayList<HurtAnimationPacketListener>(packetListeners.length);
        List<LinkEntitiesPacketListener> linkEntitiesPacketListenerList = new ArrayList<LinkEntitiesPacketListener>(packetListeners.length);
        List<MoveMinecartAlongTrackPacketListener> moveMinecartAlongTrackPacketListenerList = new ArrayList<MoveMinecartAlongTrackPacketListener>(packetListeners.length);
        List<ParticlePacketListener> particlePacketListenerList = new ArrayList<ParticlePacketListener>(packetListeners.length);
        List<PickupItemPacketListener> pickupItemPacketListenerList = new ArrayList<PickupItemPacketListener>(packetListeners.length);
        List<ProjectilePowerPacketListener> projectilePowerPacketListenerList = new ArrayList<ProjectilePowerPacketListener>(packetListeners.length);
        List<RemoveEntitiesPacketListener> removeEntitiesPacketListenerList = new ArrayList<RemoveEntitiesPacketListener>(packetListeners.length);
        List<RemoveEntityEffectPacketListener> removeEntityEffectPacketListenerList = new ArrayList<RemoveEntityEffectPacketListener>(packetListeners.length);
        List<SetEntityMetadataPacketListener> setEntityMetadataPacketListenerList = new ArrayList<SetEntityMetadataPacketListener>(packetListeners.length);
        List<SetEntityVelocityPacketListener> setEntityVelocityPacketListenerList = new ArrayList<SetEntityVelocityPacketListener>(packetListeners.length);
        List<SetEquipmentPacketListener> setEquipmentPacketListenerList = new ArrayList<SetEquipmentPacketListener>(packetListeners.length);
        List<SetHeadRotationPacketListener> setHeadRotationPacketListenerList = new ArrayList<SetHeadRotationPacketListener>(packetListeners.length);
        List<SetPassengersPacketListener> setPassengersPacketListenerList = new ArrayList<SetPassengersPacketListener>(packetListeners.length);
        List<SoundEffectPacketListener> soundEffectPacketListenerList = new ArrayList<SoundEffectPacketListener>(packetListeners.length);
        List<SpawnEntityPacketListener> spawnEntityPacketListenerList = new ArrayList<SpawnEntityPacketListener>(packetListeners.length);
        List<SpawnExperienceOrbPacketListener> spawnExperienceOrbPacketListenerList = new ArrayList<SpawnExperienceOrbPacketListener>(packetListeners.length);
        List<SpawnLivingEntityPacketListener> spawnLivingEntityPacketListenerList = new ArrayList<SpawnLivingEntityPacketListener>(packetListeners.length);
        List<SpawnPaintingPacketListener> spawnPaintingPacketListenerList = new ArrayList<SpawnPaintingPacketListener>(packetListeners.length);
        List<SpawnPlayerPacketListener> spawnPlayerPacketListenerList = new ArrayList<SpawnPlayerPacketListener>(packetListeners.length);
        List<SynchronizeVehiclePositionPacketListener> synchronizeVehiclePositionPacketListenerList = new ArrayList<SynchronizeVehiclePositionPacketListener>(packetListeners.length);
        List<TeleportEntityPacketListener> teleportEntityPacketListenerList = new ArrayList<TeleportEntityPacketListener>(packetListeners.length);
        List<UpdateAttributesPacketListener> updateAttributesPacketListenerList = new ArrayList<UpdateAttributesPacketListener>(packetListeners.length);
        List<UpdateEntityPositionPacketListener> updateEntityPositionPacketListenerList = new ArrayList<UpdateEntityPositionPacketListener>(packetListeners.length);
        List<UpdateEntityPositionAndRotationPacketListener> updateEntityPositionAndRotationPacketListenerList = new ArrayList<UpdateEntityPositionAndRotationPacketListener>(packetListeners.length);
        List<UpdateEntityRotationPacketListener> updateEntityRotationPacketListenerList = new ArrayList<UpdateEntityRotationPacketListener>(packetListeners.length);
        List<UpdateTimePacketListener> updateTimePacketListenerList = new ArrayList<UpdateTimePacketListener>(packetListeners.length);
        List<WorldEventPacketListener> worldEventPacketListenerList = new ArrayList<WorldEventPacketListener>(packetListeners.length);

        for (PacketListener listener : packetListeners) {
            if (listener instanceof StartOfReplayPacketInserter) {
                startOfReplayPacketInserterList.add((StartOfReplayPacketInserter) listener);
            }
            if (listener instanceof BlockActionPacketListener) {
                blockActionPacketListenerList.add((BlockActionPacketListener) listener);
            }
            if (listener instanceof CustomSoundEffectPacketListener) {
                customSoundEffectPacketListenerList.add((CustomSoundEffectPacketListener) listener);
            }
            if (listener instanceof DamageEventPacketListener) {
                damageEventPacketListenerList.add((DamageEventPacketListener) listener);
            }
            if (listener instanceof EntityAnimationPacketListener) {
                entityAnimationPacketListenerList.add((EntityAnimationPacketListener) listener);
            }
            if (listener instanceof EntityEffectPacketListener) {
                entityEffectPacketListenerList.add((EntityEffectPacketListener) listener);
            }
            if (listener instanceof EntityEventPacketListener) {
                entityEventPacketListenerList.add((EntityEventPacketListener) listener);
            }
            if (listener instanceof EntitySoundEffectPacket) {
                entitySoundEffectPacketListenerList.add((EntitySoundEffectPacketListener) listener);
            }
            if (listener instanceof GameEventPacketListener) {
                gameEventPacketListenerList.add((GameEventPacketListener) listener);
            }
            if (listener instanceof HurtAnimationPacketListener) {
                hurtAnimationPacketListenerList.add((HurtAnimationPacketListener) listener);
            }
            if (listener instanceof LinkEntitiesPacketListener) {
                linkEntitiesPacketListenerList.add((LinkEntitiesPacketListener) listener);
            }
            if (listener instanceof MoveMinecartAlongTrackPacketListener) {
                moveMinecartAlongTrackPacketListenerList.add((MoveMinecartAlongTrackPacketListener) listener);
            }
            if (listener instanceof ParticlePacketListener) {
                particlePacketListenerList.add((ParticlePacketListener) listener);
            }
            if (listener instanceof PickupItemPacketListener) {
                pickupItemPacketListenerList.add((PickupItemPacketListener) listener);
            }
            if (listener instanceof ProjectilePowerPacketListener) {
                projectilePowerPacketListenerList.add((ProjectilePowerPacketListener) listener);
            }
            if (listener instanceof RemoveEntitiesPacketListener) {
                removeEntitiesPacketListenerList.add((RemoveEntitiesPacketListener) listener);
            }
            if (listener instanceof RemoveEntityEffectPacketListener) {
                removeEntityEffectPacketListenerList.add((RemoveEntityEffectPacketListener) listener);
            }
            if (listener instanceof SetEntityMetadataPacketListener) {
                setEntityMetadataPacketListenerList.add((SetEntityMetadataPacketListener) listener);
            }
            if (listener instanceof SetEntityVelocityPacketListener) {
                setEntityVelocityPacketListenerList.add((SetEntityVelocityPacketListener) listener);
            }
            if (listener instanceof SetEquipmentPacketListener) {
                setEquipmentPacketListenerList.add((SetEquipmentPacketListener) listener);
            }
            if (listener instanceof SetHeadRotationPacketListener) {
                setHeadRotationPacketListenerList.add((SetHeadRotationPacketListener) listener);
            }
            if (listener instanceof SetPassengersPacketListener) {
                setPassengersPacketListenerList.add((SetPassengersPacketListener) listener);
            }
            if (listener instanceof SoundEffectPacketListener) {
                soundEffectPacketListenerList.add((SoundEffectPacketListener) listener);
            }
            if (listener instanceof SpawnEntityPacketListener) {
                spawnEntityPacketListenerList.add((SpawnEntityPacketListener) listener);
            }
            if (listener instanceof SpawnExperienceOrbPacketListener) {
                spawnExperienceOrbPacketListenerList.add((SpawnExperienceOrbPacketListener) listener);
            }
            if (listener instanceof SpawnLivingEntityPacketListener) {
                spawnLivingEntityPacketListenerList.add((SpawnLivingEntityPacketListener) listener);
            }
            if (listener instanceof SpawnPaintingPacketListener) {
                spawnPaintingPacketListenerList.add((SpawnPaintingPacketListener) listener);
            }
            if (listener instanceof SpawnPlayerPacketListener) {
                spawnPlayerPacketListenerList.add((SpawnPlayerPacketListener) listener);
            }
            if (listener instanceof SynchronizeVehiclePositionPacketListener) {
                synchronizeVehiclePositionPacketListenerList.add((SynchronizeVehiclePositionPacketListener) listener);
            }
            if (listener instanceof TeleportEntityPacketListener) {
                teleportEntityPacketListenerList.add((TeleportEntityPacketListener) listener);
            }
            if (listener instanceof UpdateAttributesPacketListener) {
                updateAttributesPacketListenerList.add((UpdateAttributesPacketListener) listener);
            }
            if (listener instanceof UpdateEntityPositionPacketListener) {
                updateEntityPositionPacketListenerList.add((UpdateEntityPositionPacketListener) listener);
            }
            if (listener instanceof UpdateEntityPositionAndRotationPacketListener) {
                updateEntityPositionAndRotationPacketListenerList.add((UpdateEntityPositionAndRotationPacketListener) listener);
            }
            if (listener instanceof UpdateEntityRotationPacketListener) {
                updateEntityRotationPacketListenerList.add((UpdateEntityRotationPacketListener) listener);
            }
            if (listener instanceof UpdateTimePacketListener) {
                updateTimePacketListenerList.add((UpdateTimePacketListener) listener);
            }
            if (listener instanceof WorldEventPacketListener) {
                worldEventPacketListenerList.add((WorldEventPacketListener) listener);
            }
        }

        this.startOfReplayPacketInserters = startOfReplayPacketInserterList.toArray(new StartOfReplayPacketInserter[0]);
        this.blockActionPacketListeners = blockActionPacketListenerList.toArray(new BlockActionPacketListener[0]);
        this.customSoundEffectPacketListeners = customSoundEffectPacketListenerList.toArray(new CustomSoundEffectPacketListener[0]);
        this.damageEventPacketListeners = damageEventPacketListenerList.toArray(new DamageEventPacketListener[0]);
        this.entityAnimationPacketListeners = entityAnimationPacketListenerList.toArray(new EntityAnimationPacketListener[0]);
        this.entityEffectPacketListeners = entityEffectPacketListenerList.toArray(new EntityEffectPacketListener[0]);
        this.entityEventPacketListeners = entityEventPacketListenerList.toArray(new EntityEventPacketListener[0]);
        this.entitySoundEffectPacketListeners = entitySoundEffectPacketListenerList.toArray(new EntitySoundEffectPacketListener[0]);
        this.gameEventPacketListeners = gameEventPacketListenerList.toArray(new GameEventPacketListener[0]);
        this.hurtAnimationPacketListeners = hurtAnimationPacketListenerList.toArray(new HurtAnimationPacketListener[0]);
        this.linkEntitiesPacketListeners = linkEntitiesPacketListenerList.toArray(new LinkEntitiesPacketListener[0]);
        this.moveMinecartAlongTrackPacketListeners = moveMinecartAlongTrackPacketListenerList.toArray(new MoveMinecartAlongTrackPacketListener[0]);
        this.particlePacketListeners = particlePacketListenerList.toArray(new ParticlePacketListener[0]);
        this.pickupItemPacketListeners = pickupItemPacketListenerList.toArray(new PickupItemPacketListener[0]);
        this.projectilePowerPacketListeners = projectilePowerPacketListenerList.toArray(new ProjectilePowerPacketListener[0]);
        this.removeEntitiesPacketListeners = removeEntitiesPacketListenerList.toArray(new RemoveEntitiesPacketListener[0]);
        this.removeEntityEffectPacketListeners = removeEntityEffectPacketListenerList.toArray(new RemoveEntityEffectPacketListener[0]);
        this.setEntityMetadataPacketListeners = setEntityMetadataPacketListenerList.toArray(new SetEntityMetadataPacketListener[0]);
        this.setEntityVelocityPacketListeners = setEntityVelocityPacketListenerList.toArray(new SetEntityVelocityPacketListener[0]);
        this.setEquipmentPacketListeners = setEquipmentPacketListenerList.toArray(new SetEquipmentPacketListener[0]);
        this.setHeadRotationPacketListeners = setHeadRotationPacketListenerList.toArray(new SetHeadRotationPacketListener[0]);
        this.setPassengersPacketListeners = setPassengersPacketListenerList.toArray(new SetPassengersPacketListener[0]);
        this.soundEffectPacketListeners = soundEffectPacketListenerList.toArray(new SoundEffectPacketListener[0]);
        this.spawnEntityPacketListeners = spawnEntityPacketListenerList.toArray(new SpawnEntityPacketListener[0]);
        this.spawnExperienceOrbPacketListeners = spawnExperienceOrbPacketListenerList.toArray(new SpawnExperienceOrbPacketListener[0]);
        this.spawnLivingEntityPacketListeners = spawnLivingEntityPacketListenerList.toArray(new SpawnLivingEntityPacketListener[0]);
        this.spawnPaintingPacketListeners = spawnPaintingPacketListenerList.toArray(new SpawnPaintingPacketListener[0]);
        this.spawnPlayerPacketListeners = spawnPlayerPacketListenerList.toArray(new SpawnPlayerPacketListener[0]);
        this.synchronizeVehiclePositionPacketListeners = synchronizeVehiclePositionPacketListenerList.toArray(new SynchronizeVehiclePositionPacketListener[0]);
        this.teleportEntityPacketListeners = teleportEntityPacketListenerList.toArray(new TeleportEntityPacketListener[0]);
        this.updateAttributesPacketListeners = updateAttributesPacketListenerList.toArray(new UpdateAttributesPacketListener[0]);
        this.updateEntityPositionPacketListeners = updateEntityPositionPacketListenerList.toArray(new UpdateEntityPositionPacketListener[0]);
        this.updateEntityPositionAndRotationPacketListeners = updateEntityPositionAndRotationPacketListenerList.toArray(new UpdateEntityPositionAndRotationPacketListener[0]);
        this.updateEntityRotationPacketListeners = updateEntityRotationPacketListenerList.toArray(new UpdateEntityRotationPacketListener[0]);
        this.updateTimePacketListeners = updateTimePacketListenerList.toArray(new UpdateTimePacketListener[0]);
        this.worldEventPacketListeners = worldEventPacketListenerList.toArray(new WorldEventPacketListener[0]);
    }


    private final long sourceReplaySizeBytes;
    private final Protocol protocol;
    private final int protocolVersion;

    private final ReplayReader reader;
    private final ReplayWriter writer;

    private final TaskTracker taskTracker;

    private final StartOfReplayPacketInserter[] startOfReplayPacketInserters;
    private final BlockActionPacketListener[] blockActionPacketListeners;
    private final CustomSoundEffectPacketListener[] customSoundEffectPacketListeners;
    private final DamageEventPacketListener[] damageEventPacketListeners;
    private final EntityAnimationPacketListener[] entityAnimationPacketListeners;
    private final EntityEffectPacketListener[] entityEffectPacketListeners;
    private final EntityEventPacketListener[] entityEventPacketListeners;
    private final EntitySoundEffectPacketListener[] entitySoundEffectPacketListeners;
    private final GameEventPacketListener[] gameEventPacketListeners;
    private final HurtAnimationPacketListener[] hurtAnimationPacketListeners;
    private final LinkEntitiesPacketListener[] linkEntitiesPacketListeners;
    private final MoveMinecartAlongTrackPacketListener[] moveMinecartAlongTrackPacketListeners;
    private final ParticlePacketListener[] particlePacketListeners;
    private final PickupItemPacketListener[] pickupItemPacketListeners;
    private final ProjectilePowerPacketListener[] projectilePowerPacketListeners;
    private final RemoveEntitiesPacketListener[] removeEntitiesPacketListeners;
    private final RemoveEntityEffectPacketListener[] removeEntityEffectPacketListeners;
    private final SetEntityMetadataPacketListener[] setEntityMetadataPacketListeners;
    private final SetEntityVelocityPacketListener[] setEntityVelocityPacketListeners;
    private final SetEquipmentPacketListener[] setEquipmentPacketListeners;
    private final SetHeadRotationPacketListener[] setHeadRotationPacketListeners;
    private final SetPassengersPacketListener[] setPassengersPacketListeners;
    private final SoundEffectPacketListener[] soundEffectPacketListeners;
    private final SpawnEntityPacketListener[] spawnEntityPacketListeners;
    private final SpawnExperienceOrbPacketListener[] spawnExperienceOrbPacketListeners;
    private final SpawnLivingEntityPacketListener[] spawnLivingEntityPacketListeners;
    private final SpawnPaintingPacketListener[] spawnPaintingPacketListeners;
    private final SpawnPlayerPacketListener[] spawnPlayerPacketListeners;
    private final SynchronizeVehiclePositionPacketListener[] synchronizeVehiclePositionPacketListeners;
    private final TeleportEntityPacketListener[] teleportEntityPacketListeners;
    private final UpdateAttributesPacketListener[] updateAttributesPacketListeners;
    private final UpdateEntityPositionPacketListener[] updateEntityPositionPacketListeners;
    private final UpdateEntityPositionAndRotationPacketListener[] updateEntityPositionAndRotationPacketListeners;
    private final UpdateEntityRotationPacketListener[] updateEntityRotationPacketListeners;
    private final UpdateTimePacketListener[] updateTimePacketListeners;
    private final WorldEventPacketListener[] worldEventPacketListeners;

    private volatile boolean started = false;
    private final AtomicBoolean cancelFlag;

    private int totalSizeOfLastPacketWritten = 0; // For some basic error checking

    /**
     * Every X number of packets, the TaskProgress will be updated.
     */
    private static final int taskProgressUpdateFrequency = 512;


    @Override
    public void run() {
        if (started) {
            throw new RuntimeException("Task can only be ran once.");
        }
        started = true;

        try {
            // replay file header
            this.writer.writeInt(this.reader.readInt());
            int length = this.reader.readInt();
            this.writer.writeInt(length);
            this.writer.writeByteArray(this.reader.readByteArray(length));
            // end header

            // The login/configuration phase.
            if (this.protocolVersion > Version.MC_1_20_1) {
                this.passthroughConfigurationPackets();
            } else {
                this.passthroughLoginPackets();
            }

            // Passthrough the login (play) packet.
            // It (should) always be the first packet after the end of the login/configuration phase. (I think...  have to confirm that as new protocols are added)
            int startingReplayTimeStamp = this.reader.readInt();
            this.writer.writeInt(startingReplayTimeStamp); // timeStamp
            int loginPacketSize = this.reader.readInt();
            this.writer.writeInt(loginPacketSize); // packetSize
            this.writer.writeByteArray(this.reader.readByteArray(loginPacketSize)); // packetID + data

            // Insert custom packets at the head of the replay if needed.
            for (StartOfReplayPacketInserter packetInserter : this.startOfReplayPacketInserters) {
                this.insertPackets(startingReplayTimeStamp, packetInserter.insertPackets());
            }

            long packetIndex = 0; // May use useful for something if I need to target a specific packet within the sequence.

            // Only continue reading so long as data is available and this job isn't canceled.
            while ((this.sourceReplaySizeBytes - this.reader.bytesRead()) != 0 && !this.cancelFlag.get()) {
                packetIndex++;

                // Used for some basic error checking.
                long lastBytesWrittenTotal = this.writer.bytesWritten();

                // Update the task progress tracker every X number of packets.
                if (packetIndex % ReplayManipulationTask.taskProgressUpdateFrequency == 0) {
                    // For some reason, using ((double)this.reader.bytesRead() / this.sourceReplaySizeBytes) can yield unexpected values during the first few cycles.
                    // Like "610860.0 / 4086648608L = 1.4947700636756093E-4" instead of "0.000149477" for example.
                    // Not sure why at this time. Maybe some sort of precision or overflow issue?
                    // Anyways, going for this below as it doesn't require conversion of value types back and forth.
                    this.taskTracker.setProgress((int) ((this.reader.bytesRead() * TaskTracker.MAX_VALUE) / this.sourceReplaySizeBytes));
                }

                // It's possible that if a replay recording crashed and was recovered, that the last packet may not be fully written.
                // In such case, the incomplete packet data from the source replay should be disregarded.
                if ((this.sourceReplaySizeBytes - this.reader.bytesRead()) < 9) {
                    // TODO: Update Logging this event to console.
                    System.out.println("Job " + this.taskTracker.getUUID().toString() + ": Last packet is missing data. Expected at least another 9 bytes, only " + (this.sourceReplaySizeBytes - this.reader.bytesRead()) + " bytes remain. Disregarding the last packet.");
                    break;
                }

                // ReplayMod timestamp (in milliseconds since the beginning of this replay)
                int timeStamp = this.reader.readInt();

                // Size of currentPacketID plus the packet data in bytes. Not a varInt!!! ReplayMod saves the size as a normal integer.
                int packetSize = this.reader.readInt();

                // Checking again - See above for explanation.
                if ((this.sourceReplaySizeBytes - this.reader.bytesRead()) < packetSize) {
                    // TODO: Update Logging this event to console.
                    System.out.println("Job " + this.taskTracker.getUUID().toString() + ": Last packet is missing data. Expected another " + packetSize + " bytes, only " + (this.sourceReplaySizeBytes - this.reader.bytesRead()) + " bytes remain. Disregarding the last packet.");
                    break;
                }

                long startingBytesRead = reader.bytesRead();  // current - starting = total read so far for this packet after reading the packet size.

                int packetID = this.reader.readVarInt();
                PacketType.Play packetType = this.protocol.getPlayPacketType(packetID);

                switch (packetType) {

                    case START_CONFIGURATION -> {
                        // Not sure if this packet would ever occur during a replay.
                        // Just in case, we'll handle this case if it occurs.
                        System.out.println(this.taskTracker.getUUID() + ": Hit a Start Configuration packet during \"play\" phase."); // TODO: Remove this log sometime later.
                        this.writePacketHeader(timeStamp, packetSize, packetID); // There is no data with this packet.
                        this.passthroughConfigurationPackets(); // passthrough all the "configuration" phase packets to the writer.
                    }

                    case BLOCK_ACTION -> this.handleBlockActionPacket(packetIndex, timeStamp, packetSize, packetID);

                    case CUSTOM_SOUND_EFFECT -> this.handleCustomSoundEffectPacket(packetIndex, timeStamp, packetSize, packetID);

                    case DAMAGE_EVENT -> this.handleDamageEventPacket(packetIndex, timeStamp, packetSize, packetID);

                    case ENTITY_ANIMATION -> this.handleEntityAnimationPacket(packetIndex, timeStamp, packetSize, packetID);

                    case ENTITY_EFFECT -> this.handleEntityEffectPacket(packetIndex, timeStamp, packetSize, packetID);

                    case ENTITY_EVENT -> this.handleEntityEventPacket(packetIndex, timeStamp, packetSize, packetID);

                    case ENTITY_SOUND_EFFECT -> this.handleEntitySoundEffectPacket(packetIndex, timeStamp, packetSize, packetID);

                    case GAME_EVENT -> this.handleGameEventPacket(packetIndex, timeStamp, packetSize, packetID);

                    case HURT_ANIMATION -> this.handleHurtAnimationPacket(packetIndex, timeStamp, packetSize, packetID);

                    case LINK_ENTITIES -> this.handleLinkEntitiesPacket(packetIndex, timeStamp, packetSize, packetID);

                    case MOVE_MINECART_ALONG_TRACK -> this.handleMoveMinecartAlongTrackPacket(packetIndex, timeStamp, packetSize, packetID);

                    case PARTICLE -> this.handleParticlePacket(packetIndex, timeStamp, packetSize, packetID);

                    case PICKUP_ITEM -> this.handlePickupItemPacket(packetIndex, timeStamp, packetSize, packetID);

                    case PROJECTILE_POWER -> this.handleProjectilePowerPacket(packetIndex, timeStamp, packetSize, packetID);

                    case REMOVE_ENTITIES -> this.handleRemoveEntitiesPacket(packetIndex, timeStamp, packetSize, packetID);

                    case REMOVE_ENTITY_EFFECT -> this.handleRemoveEntityEffectPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SET_ENTITY_METADATA -> this.handleSetEntityMetadataPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SET_ENTITY_VELOCITY -> this.handleSetEntityVelocityPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SET_EQUIPMENT -> this.handleSetEquipmentPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SET_HEAD_ROTATION -> this.handleSetHeadRotationPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SET_PASSENGERS -> this.handleSetPassengersPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SOUND_EFFECT -> this.handleSoundEffectPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SPAWN_ENTITY -> this.handleSpawnEntityPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SPAWN_EXPERIENCE_ORB -> this.handleSpawnExperienceOrbPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SPAWN_LIVING_ENTITY -> this.handleSpawnLivingEntityPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SPAWN_PAINTING -> this.handleSpawnPaintingPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SPAWN_PLAYER -> this.handleSpawnPlayerPacket(packetIndex, timeStamp, packetSize, packetID);

                    case SYNCHRONIZE_VEHICLE_POSITION -> this.handleSynchronizeVehiclePositionPacket(packetIndex, timeStamp, packetSize, packetID);

                    case TELEPORT_ENTITY -> this.handleTeleportEntityPacket(packetIndex, timeStamp, packetSize, packetID);

                    case UPDATE_ATTRIBUTES -> this.handleUpdateAttributesPacket(packetIndex, timeStamp, packetSize, packetID);

                    case UPDATE_ENTITY_POSITION -> this.handleUpdateEntityPositionPacket(packetIndex, timeStamp, packetSize, packetID);

                    case UPDATE_ENTITY_POSITION_AND_ROTATION -> this.handleUpdateEntityPositionAndRotationPacket(packetIndex, timeStamp, packetSize, packetID);

                    case UPDATE_ENTITY_ROTATION -> this.handleUpdateEntityRotationPacket(packetIndex, timeStamp, packetSize, packetID);

                    case UPDATE_TIME -> this.handleUpdateTimePacket(packetIndex, timeStamp, packetSize, packetID);

                    case WORLD_EVENT -> this.handleWorldEventPacket(packetIndex, timeStamp, packetSize, packetID);

                    default -> this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray((int) (packetSize - (reader.bytesRead() - startingBytesRead))));

                }

                // Do some basic error checking. Verify the correct number of bytes has been written out for the given packet size.
                long bytesWrittenThisPacket = this.writer.bytesWritten() - lastBytesWrittenTotal;
                // Check if anything has been written out this cycle.
                if (bytesWrittenThisPacket != 0) {
                    if (this.totalSizeOfLastPacketWritten != bytesWrittenThisPacket) {
                        throw new RuntimeException("Unexpected number of bytes written for packet '" + packetType.name() + "' Expected " + this.totalSizeOfLastPacketWritten + " bytes, Actual " + bytesWrittenThisPacket + " bytes.");
                    }
                }

            }

            // Close the replay writer & reader (in that order)
            this.writer.close();
            this.reader.close();

            if (!this.cancelFlag.get()) {
                this.taskTracker.setProgress(TaskTracker.MAX_VALUE - 1);
            }

        } catch (Exception exception) {
            try {
                // Close the replay writer & reader (in that order)
                this.writer.close();
                this.reader.close();
            } catch (IOException ioException) {
                exception.addSuppressed(ioException);
            }
            throw new RuntimeException(exception);
        }
    }


    /**
     * Write out a packet header in one line instead of three.
     * This method must be used for writing the packet header, or the replay job will likely throw an error.
     *
     * @param timeStamp  Integer value.
     * @param packetSize Integer value. The written size (in bytes) for the packetID plus packet data.
     * @param packetID   Variable Integer value. (uses 1-2 bytes typically)
     */
    private void writePacketHeader(int timeStamp, int packetSize, int packetID) throws IOException {
        this.writer.writeInt(timeStamp);
        this.writer.writeInt(packetSize);
        this.totalSizeOfLastPacketWritten = 8 + packetSize; // Total number of bytes the full packet should be. - this is used for some basic error checking.
        this.writer.writeVarInt(packetID);

    }

    /**
     * Write out a full packet in one line instead of four.
     *
     * @param timeStamp    Integer value.
     * @param packetSize   Integer value. The written size (in bytes) for the packetID plus packet data.
     * @param packetID     Variable Integer value. (uses 1-2 bytes typically)
     * @param arrayOfBytes Array of bytes representing the packet data.
     */
    private void writePacketFull(int timeStamp, int packetSize, int packetID, int[] arrayOfBytes) throws IOException {
        this.writePacketHeader(timeStamp, packetSize, packetID);
        this.writer.writeByteArray(arrayOfBytes);
    }


    /**
     * Passes through all the "configuration" phase packets from the writer to the reader.
     * Stops and returns upon hitting the packet that changes the state to "play".
     */
    private void passthroughConfigurationPackets() throws IOException {
        // The configuration phase.
        while (true) {
            int timeStamp = this.reader.readInt();
            int packetSize = this.reader.readInt();
            int packetID = this.reader.readVarInt();
            int[] data = this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID));

            this.writer.writeInt(timeStamp);
            this.writer.writeInt(packetSize);
            this.writer.writeVarInt(packetID);
            this.writer.writeByteArray(data);

            if (packetID == this.protocol.getConfigurationPacketID(PacketType.Configuration.FINISH_CONFIGURATION)) {
                // Now at the "play" state.
                break;
            }
        }
    }

    /**
     * Passes through all the "login" phase packets from the writer to the reader.
     * Stops and returns upon hitting the packet that changes the state to "play".
     */
    private void passthroughLoginPackets() throws IOException {
        // The login  phase.
        while (true) {
            int timeStamp = this.reader.readInt();
            int packetSize = this.reader.readInt();
            int packetID = this.reader.readVarInt();
            int[] data = this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID));

            this.writer.writeInt(timeStamp);
            this.writer.writeInt(packetSize);
            this.writer.writeVarInt(packetID);
            this.writer.writeByteArray(data);

            if (packetID == this.protocol.getLoginPacketID(PacketType.Login.LOGIN_SUCCESS)) {
                // Now at the "play" state.
                break;
            }
        }
    }


    /// TODO: Clean up duplicate code and refactor.
    /// Note: Have not implemented for all types of packets - Only GAME_EVENT & UPDATE_TIME
    private void insertPackets(int timeStamp, Packet... packets) throws IOException {
        if (packets != null) {
            for (Packet packet : packets) {
                switch (packet.getPacketType()) {

                    case GAME_EVENT -> {
                        int packetID = this.protocol.getPlayPacketID(PacketType.Play.GAME_EVENT);
                        this.writePacketHeader(timeStamp, ReplayWriter.sizeOfVarInt(packetID) + 5, packetID);

                        // write out the event.
                        switch (((GameEventPacket) packet).getEventType()) {
                            case GameEventPacket.GameEventType.NO_RESPAWN_BLOCK_AVAILABLE -> this.writer.writeByte(0);
                            case GameEventPacket.GameEventType.BEGIN_RAINING -> this.writer.writeByte(1);
                            case GameEventPacket.GameEventType.END_RAINING -> this.writer.writeByte(2);
                            case GameEventPacket.GameEventType.CHANGE_GAME_MODE -> this.writer.writeByte(3);
                            case GameEventPacket.GameEventType.WIN_GAME -> this.writer.writeByte(4);
                            case GameEventPacket.GameEventType.DEMO_EVENT -> this.writer.writeByte(5);
                            case GameEventPacket.GameEventType.ARROW_HIT_PLAYER -> this.writer.writeByte(6);
                            case GameEventPacket.GameEventType.RAIN_LEVEL_CHANGE -> this.writer.writeByte(7);
                            case GameEventPacket.GameEventType.THUNDER_LEVEL_CHANGE -> this.writer.writeByte(8);
                            case GameEventPacket.GameEventType.PLAY_PUFFERFISH_STING_SOUND -> this.writer.writeByte(9);
                            case GameEventPacket.GameEventType.PLAY_ELDER_GUARDIAN_APPEARANCE -> this.writer.writeByte(10);
                            case GameEventPacket.GameEventType.ENABLE_RESPAWN_SCREEN -> this.writer.writeByte(11);
                            case GameEventPacket.GameEventType.LIMITED_CRAFTING -> {
                                if (this.protocolVersion < Version.MC_1_20_2) { // Limited crafting is unsupported in protocol versions 763 (1.20.0/1) and older.
                                    throw new UnsupportedOperationException("GameEventPacket.GameEventType.LIMITED_CRAFTING is unsupported for this protocol version");
                                }
                                this.writer.writeByte(12);
                            }
                            case GameEventPacket.GameEventType.START_WAIT_FOR_LEVEL_CHUNKS -> {
                                if (this.protocolVersion < Version.MC_1_20_3) { // Start wait for level chunks is unsupported in protocol versions 764 (1.20.2) and older.
                                    throw new UnsupportedOperationException("GameEventPacket.GameEventType.START_WAIT_FOR_LEVEL_CHUNKS is unsupported for this protocol version");
                                }
                                this.writer.writeByte(13);
                            }
                        }

                        // write out value
                        this.writer.writeFloat(((GameEventPacket) packet).getValue());
                    }

                    case UPDATE_TIME -> {
                        int packetID = this.protocol.getPlayPacketID(PacketType.Play.UPDATE_TIME);
                        int packetSize = ReplayWriter.sizeOfVarInt(packetID) + 16;
                        if (this.protocolVersion >= Version.MC_1_21_2) {
                            packetSize += 1;
                        }

                        this.writePacketHeader(timeStamp, packetSize, packetID);

                        this.writer.writeLong(((UpdateTimePacket) packet).getWorldAge());

                        long timeOfDay = ((UpdateTimePacket) packet).getTimeOfDay();
                        if (protocolVersion >= Version.MC_1_21_2) {
                            this.writer.writeLong(timeOfDay);
                            this.writer.writeBoolean(((UpdateTimePacket) packet).doesTimeAdvance());
                        } else {
                            if (!((UpdateTimePacket) packet).doesTimeAdvance()) {
                                timeOfDay *= -1;
                            }
                            this.writer.writeLong(timeOfDay);
                        }
                    }

                    default -> {
                        // do nothing.
                    }
                }
            }
        }
    }


    private void handleBlockActionPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.blockActionPacketListeners.length > 0) {
            // Read.
            // Note: The position encoding has changed from 1.13 to 1.14. TODO: handle this difference when adding pre 1.14 protocol support.
            long position = this.reader.readLong();
            long x = position >> 38;
            long y = position << 52 >> 52;
            long z = position << 26 >> 38;

            int actionIDByte = this.reader.readByte();
            int actionParameterByte = this.reader.readByte();
            int blockType = this.reader.readVarInt();

            BlockActionPacket blockActionPacket = new BlockActionPacket(packetIndex, timeStamp, (int) x, (int) y, (int) z, actionIDByte, actionParameterByte, blockType);

            // Let listener(s) cancel this packet.
            for (BlockActionPacketListener listener : this.blockActionPacketListeners) {
                listener.onBlockActionPacket(blockActionPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!blockActionPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);

                //    x = blockActionPacket.getPositionX();
                //    y = blockActionPacket.getPositionY();
                //    z = blockActionPacket.getPositionZ();
                //    position = ((x & 0x3FFFFFF) << 38) | ((z & 0x3FFFFFF) << 12) | (y & 0xFFF); // TODO: Test decoding and encoding position
                this.writer.writeLong(position);

                this.writer.writeByte(actionIDByte);
                this.writer.writeByte(actionParameterByte);
                this.writer.writeVarInt(blockType);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleCustomSoundEffectPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.customSoundEffectPacketListeners.length > 0) {
            // Read packet data
            int[] rawDataBytes = this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID));

            CustomSoundEffectPacket customSoundEffectPacket = new CustomSoundEffectPacket(packetIndex, timeStamp, rawDataBytes);

            // Let listener(s) manipulate this packet. TODO: fully implement packet object
            for (CustomSoundEffectPacketListener listener : this.customSoundEffectPacketListeners) {
                listener.onCustomSoundEffectPacket(customSoundEffectPacket);
            }
            // Write out the full packet (if the packet should be written out)
            if (!customSoundEffectPacket.isWriteCanceled()) {
                this.writePacketFull(timeStamp, packetSize, packetID, rawDataBytes);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleDamageEventPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.damageEventPacketListeners.length > 0) {
            // Read.
            int entityID = this.reader.readVarInt();
            int sourceTypeID = this.reader.readVarInt();
            int sourceCauseID = this.reader.readVarInt();
            int sourceDirectID = this.reader.readVarInt();

            boolean hasSourcePosition = this.reader.readBoolean();
            double sourcePositionX = Double.NaN, sourcePositionY = Double.NaN, sourcePositionZ = Double.NaN;
            if (hasSourcePosition) {
                sourcePositionX = this.reader.readDouble();
                sourcePositionY = this.reader.readDouble();
                sourcePositionZ = this.reader.readDouble();
            }

            DamageEventPacket damageEventPacket = new DamageEventPacket(packetIndex, timeStamp, entityID, sourceTypeID, sourceCauseID, sourceDirectID, hasSourcePosition, sourcePositionX, sourcePositionY, sourcePositionZ);

            // Let listener(s) cancel this packet.
            for (DamageEventPacketListener listener : this.damageEventPacketListeners) {
                listener.onDamageEventPacket(damageEventPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!damageEventPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeVarInt(sourceTypeID);
                this.writer.writeVarInt(sourceCauseID);
                this.writer.writeVarInt(sourceDirectID);

                this.writer.writeBoolean(hasSourcePosition);
                if (hasSourcePosition) {
                    this.writer.writeDouble(sourcePositionX);
                    this.writer.writeDouble(sourcePositionY);
                    this.writer.writeDouble(sourcePositionZ);
                }
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleEntityAnimationPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.entityAnimationPacketListeners.length > 0) {
            // Read.
            int entityID = this.reader.readVarInt();
            int animationByte = this.reader.readByte();

            EntityAnimationPacket.AnimationType animationType = EntityAnimationPacket.AnimationType.UNDEFINED;
            switch (animationByte) {
                case 0 -> animationType = EntityAnimationPacket.AnimationType.SWING_MAIN_HAND;
                case 1 ->
                        animationType = EntityAnimationPacket.AnimationType.TAKE_DAMAGE; // Note: This type was removed in 1.20.2+ (protocol 764+). Going forward the value of 1 is unused.
                case 2 -> animationType = EntityAnimationPacket.AnimationType.LEAVE_BED;
                case 3 -> animationType = EntityAnimationPacket.AnimationType.SWING_OFF_HAND;
                case 4 -> animationType = EntityAnimationPacket.AnimationType.CRITICAL_EFFECT;
                case 5 -> animationType = EntityAnimationPacket.AnimationType.MAGIC_CRITICAL_EFFECT;
            }

            EntityAnimationPacket entityAnimationPacket = new EntityAnimationPacket(packetIndex, timeStamp, entityID, animationType);

            // Let listener(s) cancel this packet.
            for (EntityAnimationPacketListener listener : this.entityAnimationPacketListeners) {
                listener.onEntityAnimationPacket(entityAnimationPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!entityAnimationPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeByte(animationByte);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleEntityEffectPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.entityEffectPacketListeners.length > 0) {
            long startingBytesRead = this.reader.bytesRead() - ReplayWriter.sizeOfVarInt(packetID);

            // Read packet data
            int entityID = this.reader.readVarInt();

            // In protocol versions before 758 (1.18.2) the effectID field is a byte instead of a VarInt.
            int effectID;
            if (this.protocolVersion > Version.MC_1_18_1) {
                effectID = this.reader.readVarInt();
            } else {
                effectID = this.reader.readByte();
            }
            int amplifier = this.reader.readVarInt();
            int duration = this.reader.readVarInt();
            int flagsByte = this.reader.readByte();

            boolean isAmbient = (flagsByte & 0x01) != 0;
            boolean showParticles = (flagsByte & 0x02) != 0;
            boolean showIcon = (flagsByte & 0x04) != 0;
            boolean blend = (flagsByte & 0x08) != 0; // blend flag is not present in protocol versions older than 766 (1.20.5)

            // Fields present in protocol versions after 758 (1.18.2) and before 766 (1.20.5)
            boolean hasFactorData = false;
            int[] factorCodecNBTRawBytes = null;
            if (this.protocolVersion > Version.MC_1_18_2 && this.protocolVersion < Version.MC_1_20_5) {
                hasFactorData = this.reader.readBoolean();
                factorCodecNBTRawBytes = this.reader.readByteArray((int) (packetSize - (this.reader.bytesRead() - startingBytesRead)));
            }

            EntityEffectPacket entityEffectPacket = new EntityEffectPacket(packetIndex, timeStamp, entityID, effectID, amplifier, duration, isAmbient, showParticles, showIcon, blend, hasFactorData, factorCodecNBTRawBytes);

            // Let listener(s) cancel this packet.
            for (EntityEffectPacketListener listener : this.entityEffectPacketListeners) {
                listener.onEntityEffectPacket(entityEffectPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!entityEffectPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                if (this.protocolVersion > Version.MC_1_18_1) {
                    this.writer.writeVarInt(effectID);
                } else {
                    this.writer.writeByte(effectID);
                }
                this.writer.writeVarInt(amplifier);
                this.writer.writeVarInt(duration);
                this.writer.writeByte(flagsByte);
                if (this.protocolVersion > Version.MC_1_18_2 && this.protocolVersion < Version.MC_1_20_5) {
                    this.writer.writeBoolean(hasFactorData);
                    this.writer.writeByteArray(factorCodecNBTRawBytes);
                }
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleEntityEventPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.entityEventPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readInt(); // For this packet, the entity id is a normal int. Not a var int.
            int entityStatusByte = this.reader.readByte();

            EntityEventPacket entityEventPacket = new EntityEventPacket(packetIndex, timeStamp, entityID, entityStatusByte);

            // Let listener(s) cancel this packet.
            for (EntityEventPacketListener listener : this.entityEventPacketListeners) {
                listener.onEntityEvent(entityEventPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!entityEventPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeInt(entityID);
                this.writer.writeByte(entityStatusByte);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleEntitySoundEffectPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.entitySoundEffectPacketListeners.length > 0) {
            // Read packet data
            int[] rawDataBytes = this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID));

            EntitySoundEffectPacket entitySoundEffectPacket = new EntitySoundEffectPacket(packetIndex, timeStamp, rawDataBytes);

            // Let listener(s) manipulate this packet. TODO: fully implement packet object
            for (EntitySoundEffectPacketListener listener : this.entitySoundEffectPacketListeners) {
                listener.onEntitySoundEffectPacket(entitySoundEffectPacket);
            }
            // Write out the full packet (if the packet should be written out)
            if (!entitySoundEffectPacket.isWriteCanceled()) {
                this.writePacketFull(timeStamp, packetSize, packetID, rawDataBytes);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleGameEventPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws
            IOException {
        if (this.gameEventPacketListeners.length > 0) {

            // Read packet data
            int event = this.reader.readByte();
            float value = this.reader.readFloat();

            // Determine the event type
            GameEventPacket.GameEventType eventType;
            switch (event) {
                case 0 -> eventType = GameEventPacket.GameEventType.NO_RESPAWN_BLOCK_AVAILABLE;
                case 1 -> eventType = GameEventPacket.GameEventType.BEGIN_RAINING;
                case 2 -> eventType = GameEventPacket.GameEventType.END_RAINING;
                case 3 -> eventType = GameEventPacket.GameEventType.CHANGE_GAME_MODE;
                case 4 -> eventType = GameEventPacket.GameEventType.WIN_GAME;
                case 5 -> eventType = GameEventPacket.GameEventType.DEMO_EVENT;
                case 6 -> eventType = GameEventPacket.GameEventType.ARROW_HIT_PLAYER;
                case 7 -> eventType = GameEventPacket.GameEventType.RAIN_LEVEL_CHANGE;
                case 8 -> eventType = GameEventPacket.GameEventType.THUNDER_LEVEL_CHANGE;
                case 9 -> eventType = GameEventPacket.GameEventType.PLAY_PUFFERFISH_STING_SOUND;
                case 10 -> eventType = GameEventPacket.GameEventType.PLAY_ELDER_GUARDIAN_APPEARANCE;
                case 11 -> eventType = GameEventPacket.GameEventType.ENABLE_RESPAWN_SCREEN;
                case 12 -> eventType = GameEventPacket.GameEventType.LIMITED_CRAFTING;
                case 13 -> eventType = GameEventPacket.GameEventType.START_WAIT_FOR_LEVEL_CHUNKS;
                default -> throw new IllegalStateException("Game Event Packet unexpected event value: " + event);
            }
            GameEventPacket gameEventPacket = new GameEventPacket(packetIndex, timeStamp, eventType, value);

            // Let listener(s) manipulate this packet.
            for (GameEventPacketListener listener : this.gameEventPacketListeners) {
                listener.onGameEventPacket(gameEventPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!gameEventPacket.isWriteCanceled()) {
                eventType = gameEventPacket.getEventType();

                // Start wait for level chunks is unsupported in protocol versions 764 (1.20.2) and older.
                // If that scenario occurs, don't write out this packet.
                if (!(this.protocolVersion < Version.MC_1_20_3 && eventType == GameEventPacket.GameEventType.START_WAIT_FOR_LEVEL_CHUNKS)) {
                    // Limited crafting is unsupported in protocol versions 763 (1.20.0/1) and older.
                    if (!(this.protocolVersion < Version.MC_1_20_2 && eventType == GameEventPacket.GameEventType.LIMITED_CRAFTING)) {

                        this.writePacketHeader(timeStamp, packetSize, packetID);

                        // write out the event.
                        switch (eventType) {
                            case GameEventPacket.GameEventType.NO_RESPAWN_BLOCK_AVAILABLE -> this.writer.writeByte(0);
                            case GameEventPacket.GameEventType.BEGIN_RAINING -> this.writer.writeByte(1);
                            case GameEventPacket.GameEventType.END_RAINING -> this.writer.writeByte(2);
                            case GameEventPacket.GameEventType.CHANGE_GAME_MODE -> this.writer.writeByte(3);
                            case GameEventPacket.GameEventType.WIN_GAME -> this.writer.writeByte(4);
                            case GameEventPacket.GameEventType.DEMO_EVENT -> this.writer.writeByte(5);
                            case GameEventPacket.GameEventType.ARROW_HIT_PLAYER -> this.writer.writeByte(6);
                            case GameEventPacket.GameEventType.RAIN_LEVEL_CHANGE -> this.writer.writeByte(7);
                            case GameEventPacket.GameEventType.THUNDER_LEVEL_CHANGE -> this.writer.writeByte(8);
                            case GameEventPacket.GameEventType.PLAY_PUFFERFISH_STING_SOUND -> this.writer.writeByte(9);
                            case GameEventPacket.GameEventType.PLAY_ELDER_GUARDIAN_APPEARANCE -> this.writer.writeByte(10);
                            case GameEventPacket.GameEventType.ENABLE_RESPAWN_SCREEN -> this.writer.writeByte(11);
                            case GameEventPacket.GameEventType.LIMITED_CRAFTING -> this.writer.writeByte(12);
                            case GameEventPacket.GameEventType.START_WAIT_FOR_LEVEL_CHUNKS -> this.writer.writeByte(13);
                        }

                        // write out value
                        this.writer.writeFloat(gameEventPacket.getValue());
                    }
                }
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleHurtAnimationPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws
            IOException {
        if (this.hurtAnimationPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            float yaw = this.reader.readFloat();

            HurtAnimationPacket hurtAnimationPacket = new HurtAnimationPacket(packetIndex, timeStamp, entityID, yaw);

            // Let listener(s) cancel this packet.
            for (HurtAnimationPacketListener listener : this.hurtAnimationPacketListeners) {
                listener.onHurtAnimationPacket(hurtAnimationPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!hurtAnimationPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeFloat(yaw);
            }

        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleLinkEntitiesPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws
            IOException {
        if (this.linkEntitiesPacketListeners.length > 0) {
            // Read packet data
            int attachedEntityID = this.reader.readInt();
            int holdingEntityID = this.reader.readInt();

            LinkEntitiesPacket linkEntitiesPacket = new LinkEntitiesPacket(packetIndex, timeStamp, attachedEntityID, holdingEntityID);

            // Let listener(s) manipulate this packet.
            for (LinkEntitiesPacketListener listener : this.linkEntitiesPacketListeners) {
                listener.onLinkEntitiesPacket(linkEntitiesPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!linkEntitiesPacket.isWriteCanceled()) {
                attachedEntityID = linkEntitiesPacket.getAttachedEntityID();
                holdingEntityID = linkEntitiesPacket.getHoldingEntityID();

                this.writePacketHeader(timeStamp, ReplayWriter.sizeOfVarInt(packetID) + ReplayWriter.sizeOfVarInt(attachedEntityID) + ReplayWriter.sizeOfVarInt(holdingEntityID), packetID);
                this.writer.writeInt(attachedEntityID);
                this.writer.writeInt(holdingEntityID);
            }

        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleMoveMinecartAlongTrackPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws
            IOException {
        if (this.moveMinecartAlongTrackPacketListeners.length > 0) {
            // Read packet data
            long startingBytesRead = this.reader.bytesRead() - ReplayWriter.sizeOfVarInt(packetID);

            int entityID = this.reader.readVarInt();
            int[] prefixedArrayRawBytes = this.reader.readByteArray((int) (packetSize - (this.reader.bytesRead() - startingBytesRead)));

            MoveMinecartAlongTrackPacket moveMinecartAlongTrackPacket = new MoveMinecartAlongTrackPacket(packetIndex, timeStamp, entityID, prefixedArrayRawBytes);

            // Let listener(s) cancel this packet.
            for (MoveMinecartAlongTrackPacketListener listener : this.moveMinecartAlongTrackPacketListeners) {
                listener.onMoveMinecartAlongTrackPacket(moveMinecartAlongTrackPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!moveMinecartAlongTrackPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeByteArray(prefixedArrayRawBytes);
            }

        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleParticlePacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.particlePacketListeners.length > 0) {
            // Read packet data
            long startingBytesRead = this.reader.bytesRead() - ReplayWriter.sizeOfVarInt(packetID);

            // Particle ID field is at the start of the packet for protocol versions 766 (1.20.5/6) and older.
            // In protocol version 767+ (1.21.0+) this field is the 2nd to last field in this packet.
            int particleID = 0;
            if (this.protocolVersion < Version.MC_1_21_0) {
                // Particle ID field is a normal int (not a VarInt) in versions prior to protocol version 759 (1.19).
                if (this.protocolVersion > Version.MC_1_18_2) {
                    particleID = this.reader.readVarInt();
                } else {
                    particleID = this.reader.readInt();
                }
            }
            boolean longDistance = this.reader.readBoolean();
            boolean alwaysVisible = false;
            // Versions 768+ (1.21.4+) and onward have a new alwaysVisible field.
            if (this.protocolVersion > Version.MC_1_21_3) {
                this.reader.readBoolean();
            }
            double x = this.reader.readDouble();
            double y = this.reader.readDouble();
            double z = this.reader.readDouble();
            float offsetX = this.reader.readFloat();
            float offsetY = this.reader.readFloat();
            float offsetZ = this.reader.readFloat();

            // In protocol versions 758 and prior, this field is referred to as "Particle Data" (still a float value).
            // TODO: Look into this. It might just be the case that older wiki page was just vague and this is indeed used the same as in 1.19+.
            float maxSpeed = this.reader.readFloat();

            int particleCount = this.reader.readInt();
            if (this.protocolVersion > Version.MC_1_20_6) {
                particleID = this.reader.readVarInt();
            }
            int[] particleDataRawBytes = this.reader.readByteArray((int) (packetSize - (this.reader.bytesRead() - startingBytesRead)));

            ParticlePacket particlePacket = new ParticlePacket(packetIndex, timeStamp, longDistance, alwaysVisible, x, y, z, offsetX, offsetY, offsetZ, maxSpeed, particleCount, particleID, particleDataRawBytes);

            // Let listener(s) cancel this packet.
            for (ParticlePacketListener listener : this.particlePacketListeners) {
                listener.onParticlePacket(particlePacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!particlePacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                if (this.protocolVersion < Version.MC_1_21_0) {
                    if (this.protocolVersion > Version.MC_1_18_2) {
                        this.writer.writeVarInt(particleID);
                    } else {
                        this.writer.writeInt(particleID);
                    }
                }
                this.writer.writeBoolean(longDistance);
                if (this.protocolVersion > Version.MC_1_21_4) {
                    this.writer.writeBoolean(alwaysVisible);
                }
                this.writer.writeDouble(x);
                this.writer.writeDouble(y);
                this.writer.writeDouble(z);
                this.writer.writeFloat(offsetX);
                this.writer.writeFloat(offsetY);
                this.writer.writeFloat(offsetZ);
                this.writer.writeFloat(maxSpeed);
                this.writer.writeInt(particleCount);
                if (this.protocolVersion > Version.MC_1_20_6) {
                    this.writer.writeVarInt(particleID);
                }
                this.writer.writeByteArray(particleDataRawBytes);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handlePickupItemPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.pickupItemPacketListeners.length > 0) {
            // Read packet data
            int collectedEntityID = this.reader.readVarInt();
            int collectorEntityID = this.reader.readVarInt();
            int pickupItemCount = this.reader.readVarInt();

            PickupItemPacket pickupItemPacket = new PickupItemPacket(packetIndex, timeStamp, collectedEntityID, collectorEntityID, pickupItemCount);

            // Let listener(s) cancel this packet.
            for (PickupItemPacketListener listener : this.pickupItemPacketListeners) {
                listener.onPickupItemPacket(pickupItemPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!pickupItemPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(collectedEntityID);
                this.writer.writeVarInt(collectorEntityID);
                this.writer.writeVarInt(pickupItemCount);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleProjectilePowerPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.projectilePowerPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            double power = 0.0;
            double powerX = 0.0;
            double powerY = 0.0;
            double powerZ = 0.0;
            if (this.protocolVersion > Version.MC_1_20_6) {
                power = this.reader.readDouble();
            } else {
                powerX = this.reader.readDouble();
                powerY = this.reader.readDouble();
                powerZ = this.reader.readDouble();
            }

            ProjectilePowerPacket projectilePowerPacket = new ProjectilePowerPacket(packetIndex, timeStamp, entityID, (this.protocolVersion > Version.MC_1_20_6), power, powerX, powerY, powerZ);

            // Let listener(s) cancel this packet.
            for (ProjectilePowerPacketListener listener : this.projectilePowerPacketListeners) {
                listener.onProjectilePowerPacket(projectilePowerPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!projectilePowerPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                if (this.protocolVersion > Version.MC_1_20_6) {
                    this.writer.writeDouble(power);
                } else {
                    this.writer.writeDouble(powerX);
                    this.writer.writeDouble(powerY);
                    this.writer.writeDouble(powerZ);
                }
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleRemoveEntitiesPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.removeEntitiesPacketListeners.length > 0) {
            // Read packet data
            int length;
            int[] entityIDs;

            // In protocol versions prior to 756 (1.17.1), this packet contains only a single field for removing one entity.
            // Unlike in 1.17.1 onward, where the first field is a VarInt of the length of a VarInt array of entity ID's to be remove.
            if (this.protocolVersion > Version.MC_1_17_0) {
                length = this.reader.readVarInt();
                entityIDs = new int[length];
                for (int i = 0; i < entityIDs.length; i++) {
                    entityIDs[i] = this.reader.readVarInt();
                }
            } else {
                length = 0;
                entityIDs = new int[]{this.reader.readVarInt()};
            }

            RemoveEntitiesPacket removeEntitiesPacket = new RemoveEntitiesPacket(packetIndex, timeStamp, entityIDs);

            // Let listener(s) manipulate this packet.
            for (RemoveEntitiesPacketListener listener : this.removeEntitiesPacketListeners) {
                listener.onRemoveEntitiesPacket(removeEntitiesPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!removeEntitiesPacket.isWriteCanceled()) {
                entityIDs = removeEntitiesPacket.getEntityIDs();
                if (entityIDs.length != 0) { // If the array of entities to be remove is zero, there is no point in writing out this packet.

                    if (this.protocolVersion > Version.MC_1_17_0) {
                        // Determine the new size of this packet in bytes before writing out.
                        int updatedPacketSize = ReplayWriter.sizeOfVarInt(packetID) + ReplayWriter.sizeOfVarInt(entityIDs.length);
                        for (int id : entityIDs) {
                            updatedPacketSize += ReplayWriter.sizeOfVarInt(id);
                        }

                        this.writePacketHeader(timeStamp, updatedPacketSize, packetID);
                        this.writer.writeVarInt(entityIDs.length);
                        for (int id : entityIDs) {
                            this.writer.writeVarInt(id);
                        }
                    } else {
                        // In addition to the difference in protocol versions prior to 756 (1.17.1),
                        // there may be instances where a listener has added more entries of entities to be removed where only 1 at a time is supported.
                        // In such case, write out a packet for each instance of an entity id on the array.
                        for (int id : entityIDs) {
                            // Determine the new size of this packet in bytes before writing out.
                            int updatedPacketSize = ReplayWriter.sizeOfVarInt(packetID) + ReplayWriter.sizeOfVarInt(id);

                            this.writePacketHeader(timeStamp, updatedPacketSize, packetID);
                            this.writer.writeVarInt(id);
                        }
                    }
                }
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleRemoveEntityEffectPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.removeEntityEffectPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();

            // This protocol versions before 758 (1.18.2) the effectID field is a byte instead of a VarInt.
            int effectID;
            if (this.protocolVersion > Version.MC_1_18_1) {
                effectID = this.reader.readVarInt();
            } else {
                effectID = this.reader.readByte();
            }

            RemoveEntityEffectPacket removeEntityEffectPacket = new RemoveEntityEffectPacket(packetIndex, timeStamp, entityID, effectID);

            // Let listener(s) cancel this packet.
            for (RemoveEntityEffectPacketListener listener : this.removeEntityEffectPacketListeners) {
                listener.onRemoveEntityEffectPacket(removeEntityEffectPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!removeEntityEffectPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                if (this.protocolVersion > Version.MC_1_18_1) {
                    this.writer.writeVarInt(effectID);
                } else {
                    this.writer.writeByte(effectID);
                }
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleSetEntityMetadataPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.setEntityMetadataPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            int[] rawMetadataBytes = this.reader.readByteArray((packetSize - ReplayWriter.sizeOfVarInt(packetID)) - ReplayWriter.sizeOfVarInt(entityID));

            SetEntityMetadataPacket setEntityMetadataPacket = new SetEntityMetadataPacket(packetIndex, timeStamp, entityID, rawMetadataBytes);

            // Let listener(s) cancel this packet.
            for (SetEntityMetadataPacketListener listener : this.setEntityMetadataPacketListeners) {
                listener.onSetEntityMetadataPacket(setEntityMetadataPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!setEntityMetadataPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeByteArray(rawMetadataBytes);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleSetEntityVelocityPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.setEntityVelocityPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            short velocityX = this.reader.readShort();
            short velocityY = this.reader.readShort();
            short velocityZ = this.reader.readShort();

            SetEntityVelocityPacket setEntityVelocityPacket = new SetEntityVelocityPacket(packetIndex, timeStamp, entityID, velocityX, velocityY, velocityZ);

            // Let listener(s) cancel this packet.
            for (SetEntityVelocityPacketListener listener : this.setEntityVelocityPacketListeners) {
                listener.onSetEntityVelocityPacket(setEntityVelocityPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!setEntityVelocityPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeShort(velocityX);
                this.writer.writeShort(velocityY);
                this.writer.writeShort(velocityZ);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleSetEquipmentPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.setEquipmentPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            int[] rawDataArrayBytes = this.reader.readByteArray((packetSize - ReplayWriter.sizeOfVarInt(packetID)) - ReplayWriter.sizeOfVarInt(entityID));

            SetEquipmentPacket setEquipmentPacket = new SetEquipmentPacket(packetIndex, timeStamp, entityID, rawDataArrayBytes);

            // Let listener(s) cancel this packet.
            for (SetEquipmentPacketListener listener : this.setEquipmentPacketListeners) {
                listener.onSetEquipmentPacket(setEquipmentPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!setEquipmentPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeByteArray(rawDataArrayBytes);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleSetHeadRotationPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.setHeadRotationPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            int headYawByte = this.reader.readByte();

            SetHeadRotationPacket setHeadRotationPacket = new SetHeadRotationPacket(packetIndex, timeStamp, entityID, headYawByte);

            // Let listener(s) cancel this packet.
            for (SetHeadRotationPacketListener listener : this.setHeadRotationPacketListeners) {
                listener.onSetHeadRotationPacket(setHeadRotationPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!setHeadRotationPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeByte(headYawByte);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleSetPassengersPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.setPassengersPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            int length = this.reader.readVarInt();
            int[] passengerEntityIDs = new int[length];
            for (int i = 0; i < passengerEntityIDs.length; i++) {
                passengerEntityIDs[i] = this.reader.readVarInt();
            }

            SetPassengersPacket setPassengersPacket = new SetPassengersPacket(packetIndex, timeStamp, entityID, passengerEntityIDs);

            // Let listener(s) manipulate this packet.
            for (SetPassengersPacketListener listener : this.setPassengersPacketListeners) {
                listener.onSetPassengersPacket(setPassengersPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!setPassengersPacket.isWriteCanceled()) {
                // Determine the new size of this packet in bytes before writing out.
                int updatedPacketSize = ReplayWriter.sizeOfVarInt(packetID) + ReplayWriter.sizeOfVarInt(passengerEntityIDs.length);
                for (int id : passengerEntityIDs) {
                    updatedPacketSize += ReplayWriter.sizeOfVarInt(id);
                }

                this.writePacketHeader(timeStamp, updatedPacketSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeVarInt(passengerEntityIDs.length);
                for (int id : passengerEntityIDs) {
                    this.writer.writeVarInt(id);
                }
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleSoundEffectPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.soundEffectPacketListeners.length > 0) {
            // Read packet data
            int[] rawDataBytes = this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID));

            SoundEffectPacket soundEffectPacket = new SoundEffectPacket(packetIndex, timeStamp, rawDataBytes);

            // Let listener(s) manipulate this packet. TODO: fully implement packet object
            for (SoundEffectPacketListener listener : this.soundEffectPacketListeners) {
                listener.onSoundEffectPacket(soundEffectPacket);
            }
            // Write out the full packet (if the packet should be written out)
            if (!soundEffectPacket.isWriteCanceled()) {
                this.writePacketFull(timeStamp, packetSize, packetID, rawDataBytes);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleSpawnEntityPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.spawnEntityPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            long uuidMostSignificantBits = this.reader.readLong();
            long uuidLeastSignificantBits = this.reader.readLong();
            int entityTypeID = this.reader.readVarInt();
            double x = this.reader.readDouble();
            double y = this.reader.readDouble();
            double z = this.reader.readDouble();
            int pitch = this.reader.readByte();
            int yaw = this.reader.readByte();

            // headYaw field is not present in protocol versions 758 (1.18.2) and older
            int headYaw = yaw;
            if (this.protocolVersion > Version.MC_1_18_2) {
                headYaw = this.reader.readByte();
            }
            int data = this.reader.readVarInt();
            short velocityX = this.reader.readShort();
            short velocityY = this.reader.readShort();
            short velocityZ = this.reader.readShort();

            EntityType entityType = this.protocol.getEntityType(entityTypeID);

            SpawnEntityPacket spawnEntityPacket = new SpawnEntityPacket(packetIndex, timeStamp, entityID, new UUID(uuidMostSignificantBits, uuidLeastSignificantBits), entityType, x, y, z, pitch, yaw, headYaw, data, velocityX, velocityY, velocityZ);

            // Let listener(s) cancel this packet.
            for (SpawnEntityPacketListener listener : this.spawnEntityPacketListeners) {
                listener.onSpawnEntityPacket(spawnEntityPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!spawnEntityPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeLong(uuidMostSignificantBits);
                this.writer.writeLong(uuidLeastSignificantBits);
                this.writer.writeVarInt(entityTypeID);
                this.writer.writeDouble(x);
                this.writer.writeDouble(y);
                this.writer.writeDouble(z);
                this.writer.writeByte(pitch);
                this.writer.writeByte(yaw);
                if (this.protocolVersion > Version.MC_1_18_2) {
                    this.writer.writeByte(headYaw);
                }
                this.writer.writeVarInt(data);
                this.writer.writeShort(velocityX);
                this.writer.writeShort(velocityY);
                this.writer.writeShort(velocityZ);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleSpawnExperienceOrbPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.spawnExperienceOrbPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            double x = this.reader.readDouble();
            double y = this.reader.readDouble();
            double z = this.reader.readDouble();
            short count = this.reader.readShort();

            SpawnExperienceOrbPacket spawnExperienceOrbPacket = new SpawnExperienceOrbPacket(packetIndex, timeStamp, entityID, x, y, z, count);

            // Let listener(s) cancel this packet.
            for (SpawnExperienceOrbPacketListener listener : this.spawnExperienceOrbPacketListeners) {
                listener.onSpawnExperienceOrbPacket(spawnExperienceOrbPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!spawnExperienceOrbPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeDouble(x);
                this.writer.writeDouble(y);
                this.writer.writeDouble(z);
                this.writer.writeShort(count);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    /// Note: Spawn Living Entity packet was removed and merged with Spawn Entity packet in protocol version 759+ (1.19+)
    private void handleSpawnLivingEntityPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.spawnLivingEntityPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            long uuidMostSignificantBits = this.reader.readLong();
            long uuidLeastSignificantBits = this.reader.readLong();
            int entityTypeID = this.reader.readVarInt();
            double x = this.reader.readDouble();
            double y = this.reader.readDouble();
            double z = this.reader.readDouble();
            // Read in the order of yaw, then pitch. (unlike Spawn Entity which is pitch, then yaw)
            int yaw = this.reader.readByte();
            int pitch = this.reader.readByte();
            int headYaw = this.reader.readByte();
            short velocityX = this.reader.readShort();
            short velocityY = this.reader.readShort();
            short velocityZ = this.reader.readShort();

            EntityType entityType = this.protocol.getEntityType(entityTypeID);

            SpawnLivingEntityPacket spawnLivingEntityPacket = new SpawnLivingEntityPacket(packetIndex, timeStamp, entityID, new UUID(uuidMostSignificantBits, uuidLeastSignificantBits), entityType, x, y, z, yaw, pitch, headYaw, velocityX, velocityY, velocityZ);

            // Let listener(s) cancel this packet.
            for (SpawnLivingEntityPacketListener listener : this.spawnLivingEntityPacketListeners) {
                listener.onSpawnLivingEntityPacket(spawnLivingEntityPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!spawnLivingEntityPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeLong(uuidMostSignificantBits);
                this.writer.writeLong(uuidLeastSignificantBits);
                this.writer.writeVarInt(entityTypeID);
                this.writer.writeDouble(x);
                this.writer.writeDouble(y);
                this.writer.writeDouble(z);
                this.writer.writeByte(yaw);
                this.writer.writeByte(pitch);
                this.writer.writeByte(headYaw);
                this.writer.writeShort(velocityX);
                this.writer.writeShort(velocityY);
                this.writer.writeShort(velocityZ);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    /// Note: Spawn Painting packet was removed and merged with Spawn Entity packet in protocol version 759+ (1.19+)
    private void handleSpawnPaintingPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.spawnPaintingPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            long uuidMostSignificantBits = this.reader.readLong();
            long uuidLeastSignificantBits = this.reader.readLong();
            int motive = this.reader.readVarInt();

            // Note: The position encoding has changed from 1.13 to 1.14. TODO: handle this difference when adding pre 1.14 protocol support.
            long position = this.reader.readLong();
            long x = position >> 38;
            long y = position << 52 >> 52;
            long z = position << 26 >> 38;

            int byteEnumDirection = this.reader.readByte();

            SpawnPaintingPacket spawnPaintingPacket = new SpawnPaintingPacket(packetIndex, timeStamp, entityID, new UUID(uuidMostSignificantBits, uuidLeastSignificantBits), motive, x, y, z, (byte) byteEnumDirection);

            // Let listener(s) cancel this packet.
            for (SpawnPaintingPacketListener listener : this.spawnPaintingPacketListeners) {
                listener.onSpawnPaintingPacket(spawnPaintingPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!spawnPaintingPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeLong(uuidMostSignificantBits);
                this.writer.writeLong(uuidLeastSignificantBits);
                this.writer.writeVarInt(motive);
                this.writer.writeLong(position);
                this.writer.writeByte(byteEnumDirection);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    /// Note: Spawn Player packet was removed and merged with Spawn Entity packet in protocol version 764+ (1.20.2+)
    private void handleSpawnPlayerPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.spawnPlayerPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            long uuidMostSignificantBits = this.reader.readLong();
            long uuidLeastSignificantBits = this.reader.readLong();
            double x = this.reader.readDouble();
            double y = this.reader.readDouble();
            double z = this.reader.readDouble();
            int yaw = this.reader.readByte();
            int pitch = this.reader.readByte();

            SpawnPlayerPacket spawnPlayerPacket = new SpawnPlayerPacket(packetIndex, timeStamp, entityID, new UUID(uuidMostSignificantBits, uuidLeastSignificantBits), x, y, z, yaw, pitch);

            // Let listener(s) cancel this packet.
            for (SpawnPlayerPacketListener listener : this.spawnPlayerPacketListeners) {
                listener.onSpawnPlayerPacket(spawnPlayerPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!spawnPlayerPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeLong(uuidMostSignificantBits);
                this.writer.writeLong(uuidLeastSignificantBits);
                this.writer.writeDouble(x);
                this.writer.writeDouble(y);
                this.writer.writeDouble(z);
                this.writer.writeByte(yaw);
                this.writer.writeByte(pitch);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleSynchronizeVehiclePositionPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.synchronizeVehiclePositionPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            double x = this.reader.readDouble();
            double y = this.reader.readDouble();
            double z = this.reader.readDouble();
            double velocityX = this.reader.readDouble();
            double velocityY = this.reader.readDouble();
            double velocityZ = this.reader.readDouble();
            float yaw = this.reader.readFloat();
            float pitch = this.reader.readFloat();
            int teleportFlags = this.reader.readInt();
            boolean onGround = this.reader.readBoolean();

            SynchronizeVehiclePositionPacket synchronizeVehiclePositionPacket = new SynchronizeVehiclePositionPacket(packetIndex, timeStamp, entityID, x, y, z, velocityX, velocityY, velocityZ, yaw, pitch, teleportFlags, onGround);

            // Let listener(s) cancel this packet.
            for (SynchronizeVehiclePositionPacketListener listener : this.synchronizeVehiclePositionPacketListeners) {
                listener.onSynchronizeVehiclePositionPacket(synchronizeVehiclePositionPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!synchronizeVehiclePositionPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeDouble(x);
                this.writer.writeDouble(y);
                this.writer.writeDouble(z);
                this.writer.writeDouble(velocityX);
                this.writer.writeDouble(velocityY);
                this.writer.writeDouble(velocityZ);
                this.writer.writeFloat(yaw);
                this.writer.writeFloat(pitch);
                this.writer.writeInt(teleportFlags);
                this.writer.writeBoolean(onGround);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleTeleportEntityPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.teleportEntityPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            double x = this.reader.readDouble();
            double y = this.reader.readDouble();
            double z = this.reader.readDouble();

            double velocityX = 0, velocityY = 0, velocityZ = 0;
            int yawByte = 0, pitchByte = 0;
            float yaw, pitch;

            boolean isProtocol_1_21_2_plus = this.protocolVersion >= Version.MC_1_21_2;
            if (isProtocol_1_21_2_plus) { // Packet structure changed in 1.21.2+ (protocol 768+)
                velocityX = this.reader.readDouble();
                velocityY = this.reader.readDouble();
                velocityZ = this.reader.readDouble();

                yaw = this.reader.readFloat();
                pitch = this.reader.readFloat();
            } else {
                yawByte = this.reader.readByte();
                pitchByte = this.reader.readByte();
                yaw = yawByte / (256.0F / 360.0F);
                pitch = pitchByte / (256.0F / 360.0F);
            }

            boolean onGround = this.reader.readBoolean();

            TeleportEntityPacket teleportEntityPacket = new TeleportEntityPacket(packetIndex, timeStamp, entityID, x, y, z, isProtocol_1_21_2_plus, velocityX, velocityY, velocityZ, yaw, pitch, onGround);

            // Let listener(s) cancel this packet.
            for (TeleportEntityPacketListener listener : this.teleportEntityPacketListeners) {
                listener.onTeleportEntityPacket(teleportEntityPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!teleportEntityPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeDouble(x);
                this.writer.writeDouble(y);
                this.writer.writeDouble(z);

                if (isProtocol_1_21_2_plus) {
                    this.writer.writeDouble(velocityX);
                    this.writer.writeDouble(velocityY);
                    this.writer.writeDouble(velocityZ);

                    this.writer.writeFloat(yaw);
                    this.writer.writeFloat(pitch);
                } else {
                    this.writer.writeByte(yawByte);
                    this.writer.writeByte(pitchByte);
                }

                this.writer.writeBoolean(onGround);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleUpdateAttributesPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.updateAttributesPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            int[] rawDataArrayBytes = this.reader.readByteArray((packetSize - ReplayWriter.sizeOfVarInt(packetID)) - ReplayWriter.sizeOfVarInt(entityID));

            UpdateAttributesPacket updateAttributesPacket = new UpdateAttributesPacket(packetIndex, timeStamp, entityID, rawDataArrayBytes);

            // Let listener(s) cancel this packet.
            for (UpdateAttributesPacketListener listener : this.updateAttributesPacketListeners) {
                listener.onUpdateAttributesPacket(updateAttributesPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!updateAttributesPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeByteArray(rawDataArrayBytes);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleUpdateEntityPositionPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws
            IOException {
        if (this.updateEntityPositionPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            short deltaX = this.reader.readShort();
            short deltaY = this.reader.readShort();
            short deltaZ = this.reader.readShort();
            boolean onGround = this.reader.readBoolean();

            UpdateEntityPositionPacket updateEntityPositionPacket = new UpdateEntityPositionPacket(packetIndex, timeStamp, entityID, deltaX, deltaY, deltaZ, onGround);

            // Let listener(s) cancel this packet.
            for (UpdateEntityPositionPacketListener listener : this.updateEntityPositionPacketListeners) {
                listener.onUpdateEntityPositionPacket(updateEntityPositionPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!updateEntityPositionPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeShort(deltaX);
                this.writer.writeShort(deltaY);
                this.writer.writeShort(deltaZ);
                this.writer.writeBoolean(onGround);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleUpdateEntityPositionAndRotationPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws
            IOException {
        if (this.updateEntityPositionAndRotationPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            short deltaX = this.reader.readShort();
            short deltaY = this.reader.readShort();
            short deltaZ = this.reader.readShort();
            int yawByte = this.reader.readByte();
            int pitchByte = this.reader.readByte();
            boolean onGround = this.reader.readBoolean();

            UpdateEntityPositionAndRotationPacket updateEntityPositionAndRotationPacket = new UpdateEntityPositionAndRotationPacket(packetIndex, timeStamp, entityID, deltaX, deltaY, deltaZ, yawByte, pitchByte, onGround);

            // Let listener(s) cancel this packet.
            for (UpdateEntityPositionAndRotationPacketListener listener : this.updateEntityPositionAndRotationPacketListeners) {
                listener.onUpdateEntityPositionAndRotationPacket(updateEntityPositionAndRotationPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!updateEntityPositionAndRotationPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeShort(deltaX);
                this.writer.writeShort(deltaY);
                this.writer.writeShort(deltaZ);
                this.writer.writeByte(yawByte);
                this.writer.writeByte(pitchByte);
                this.writer.writeBoolean(onGround);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleUpdateEntityRotationPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws
            IOException {
        if (this.updateEntityRotationPacketListeners.length > 0) {
            // Read packet data
            int entityID = this.reader.readVarInt();
            int yawByte = this.reader.readByte();
            int pitchByte = this.reader.readByte();
            boolean onGround = this.reader.readBoolean();

            UpdateEntityRotationPacket updateEntityRotationPacket = new UpdateEntityRotationPacket(packetIndex, timeStamp, entityID, yawByte, pitchByte, onGround);

            // Let listener(s) cancel this packet.
            for (UpdateEntityRotationPacketListener listener : this.updateEntityRotationPacketListeners) {
                listener.onUpdateEntityRotationPacket(updateEntityRotationPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!updateEntityRotationPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeVarInt(entityID);
                this.writer.writeByte(yawByte);
                this.writer.writeByte(pitchByte);
                this.writer.writeBoolean(onGround);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleUpdateTimePacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws
            IOException {
        if (this.updateTimePacketListeners.length > 0) {

            // Read packet data
            long worldAge = this.reader.readLong();
            long timeOfDay = this.reader.readLong();
            boolean timeAdvances = true;

            // Versions 1.21.2 and onward control whether time advances via a boolean value.
            if (this.protocolVersion >= Version.MC_1_21_2) {
                timeAdvances = this.reader.readBoolean();
            } else { // Versions before 1.21.2 control whether time advances by using a negative timeOfDay value.
                if (timeOfDay < 0) {
                    timeOfDay *= -1;
                    timeAdvances = false;
                }
            }
            UpdateTimePacket updateTimePacket = new UpdateTimePacket(packetIndex, timeStamp, worldAge, timeOfDay, timeAdvances);

            // Let listener(s) manipulate this packet.
            for (UpdateTimePacketListener listener : this.updateTimePacketListeners) {
                listener.onUpdateTimePacket(updateTimePacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!updateTimePacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);

                this.writer.writeLong(updateTimePacket.getWorldAge());

                timeOfDay = updateTimePacket.getTimeOfDay();
                if (protocolVersion >= Version.MC_1_21_2) {
                    this.writer.writeLong(timeOfDay);
                    this.writer.writeBoolean(updateTimePacket.doesTimeAdvance());
                } else {
                    if (!updateTimePacket.doesTimeAdvance()) {
                        timeOfDay *= -1;
                    }
                    this.writer.writeLong(timeOfDay);
                }
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }

    private void handleWorldEventPacket(long packetIndex, int timeStamp, int packetSize, int packetID) throws IOException {
        if (this.worldEventPacketListeners.length > 0) {
            // Read.
            int eventID = this.reader.readInt();

            // Note: The position encoding has changed from 1.13 to 1.14. TODO: handle this difference when adding pre 1.14 protocol support.
            long position = this.reader.readLong();
            long x = position >> 38;
            long y = position << 52 >> 52;
            long z = position << 26 >> 38;

            int data = this.reader.readInt();
            boolean relativeVolumeDisabled = this.reader.readBoolean();

            WorldEventPacket worldEventPacket = new WorldEventPacket(packetIndex, timeStamp, eventID, (int) x, (int) y, (int) z, data, relativeVolumeDisabled);

            // Let listener(s) cancel this packet.
            for (WorldEventPacketListener listener : this.worldEventPacketListeners) {
                listener.onWorldEventPacket(worldEventPacket);
            }

            // Write out the full packet (if the packet should be written out)
            if (!worldEventPacket.isWriteCanceled()) {
                this.writePacketHeader(timeStamp, packetSize, packetID);
                this.writer.writeInt(eventID);

                //    x = blockActionPacket.getPositionX();
                //    y = blockActionPacket.getPositionY();
                //    z = blockActionPacket.getPositionZ();
                //    position = ((x & 0x3FFFFFF) << 38) | ((z & 0x3FFFFFF) << 12) | (y & 0xFFF); // TODO: Test decoding and encoding position
                this.writer.writeLong(position);

                this.writer.writeInt(data);
                this.writer.writeBoolean(relativeVolumeDisabled);
            }
        } else {
            this.writePacketFull(timeStamp, packetSize, packetID, this.reader.readByteArray(packetSize - ReplayWriter.sizeOfVarInt(packetID)));
        }
    }


}
