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
package com.experimentalidea.replaypacketcleaner.job.listener;

import com.experimentalidea.replaypacketcleaner.packet.*;
import com.experimentalidea.replaypacketcleaner.packet.listener.*;

/// Used for testing the reading and writing of all packet type that can be listened on. This listener doesn't take any actions itself.
public class TestListener implements BlockActionPacketListener, CustomSoundEffectPacketListener, DamageEventPacketListener,
        EntityAnimationPacketListener, EntityEffectPacketListener, EntityEventPacketListener, EntitySoundEffectPacketListener,
        HurtAnimationPacketListener, LinkEntitiesPacketListener, MoveMinecartAlongTrackPacketListener, ParticlePacketListener,
        PickupItemPacketListener, ProjectilePowerPacketListener, RemoveEntitiesPacketListener, RemoveEntityEffectPacketListener,
        SetEntityMetadataPacketListener, SetEntityVelocityPacketListener, SetEquipmentPacketListener, SetHeadRotationPacketListener,
        SetPassengersPacketListener, SoundEffectPacketListener, SpawnEntityPacketListener, SpawnExperienceOrbPacketListener,
        SpawnLivingEntityPacketListener, SpawnPaintingPacketListener, SpawnPlayerPacketListener, SynchronizeVehiclePositionPacketListener,
        TeleportEntityPacketListener, UpdateAttributesPacketListener, UpdateEntityPositionAndRotationPacketListener, UpdateEntityPositionPacketListener,
        UpdateEntityRotationPacketListener, UpdateTimePacketListener, WorldEventPacketListener {


    public TestListener() {

    }

    @Override
    public void onBlockActionPacket(BlockActionPacket blockActionPacket) {

    }

    @Override
    public void onCustomSoundEffectPacket(CustomSoundEffectPacket customSoundEffectPacket) {

    }

    @Override
    public void onDamageEventPacket(DamageEventPacket damageEventPacket) {

    }

    @Override
    public void onEntityAnimationPacket(EntityAnimationPacket entityAnimationPacket) {

    }

    @Override
    public void onEntityEffectPacket(EntityEffectPacket entityEffectPacket) {

    }

    @Override
    public void onEntityEvent(EntityEventPacket entityEventPacket) {

    }

    @Override
    public void onEntitySoundEffectPacket(EntitySoundEffectPacket entitySoundEffectPacket) {

    }

    @Override
    public void onHurtAnimationPacket(HurtAnimationPacket hurtAnimationPacket) {

    }

    @Override
    public void onLinkEntitiesPacket(LinkEntitiesPacket linkEntitiesPacket) {

    }

    @Override
    public void onMoveMinecartAlongTrackPacket(MoveMinecartAlongTrackPacket moveMinecartAlongTrackPacket) {

    }

    @Override
    public void onParticlePacket(ParticlePacket particlePacket) {

    }

    @Override
    public void onPickupItemPacket(PickupItemPacket pickupItemPacket) {

    }

    @Override
    public void onProjectilePowerPacket(ProjectilePowerPacket projectilePowerPacket) {

    }

    @Override
    public void onRemoveEntitiesPacket(RemoveEntitiesPacket removeEntitiesPacket) {

    }

    @Override
    public void onRemoveEntityEffectPacket(RemoveEntityEffectPacket removeEntityEffectPacket) {

    }

    @Override
    public void onSetEntityMetadataPacket(SetEntityMetadataPacket setEntityMetadataPacket) {

    }

    @Override
    public void onSetEntityVelocityPacket(SetEntityVelocityPacket setEntityVelocityPacket) {

    }

    @Override
    public void onSetEquipmentPacket(SetEquipmentPacket setEquipmentPacket) {

    }

    @Override
    public void onSetHeadRotationPacket(SetHeadRotationPacket setHeadRotationPacket) {

    }

    @Override
    public void onSetPassengersPacket(SetPassengersPacket setPassengersPacket) {

    }

    @Override
    public void onSoundEffectPacket(SoundEffectPacket soundEffectPacket) {

    }

    @Override
    public void onSpawnEntityPacket(SpawnEntityPacket spawnEntityPacket) {

    }

    @Override
    public void onSpawnExperienceOrbPacket(SpawnExperienceOrbPacket spawnExperienceOrbPacket) {

    }

    @Override
    public void onSpawnLivingEntityPacket(SpawnLivingEntityPacket spawnLivingEntityPacket) {

    }

    @Override
    public void onSpawnPaintingPacket(SpawnPaintingPacket spawnPaintingPacket) {

    }

    @Override
    public void onSpawnPlayerPacket(SpawnPlayerPacket spawnPlayerPacket) {

    }

    @Override
    public void onSynchronizeVehiclePositionPacket(SynchronizeVehiclePositionPacket synchronizeVehiclePositionPacket) {

    }

    @Override
    public void onTeleportEntityPacket(TeleportEntityPacket teleportEntityPacket) {

    }

    @Override
    public void onUpdateAttributesPacket(UpdateAttributesPacket updateAttributesPacket) {

    }

    @Override
    public void onUpdateEntityPositionAndRotationPacket(UpdateEntityPositionAndRotationPacket updateEntityPositionAndRotationPacket) {

    }

    @Override
    public void onUpdateEntityPositionPacket(UpdateEntityPositionPacket updateEntityPositionPacket) {

    }

    @Override
    public void onUpdateEntityRotationPacket(UpdateEntityRotationPacket updateEntityRotationPacket) {

    }

    @Override
    public void onUpdateTimePacket(UpdateTimePacket updateTimePacket) {

    }

    @Override
    public void onWorldEventPacket(WorldEventPacket worldEventPacket) {

    }

}
