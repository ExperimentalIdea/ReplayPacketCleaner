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
import com.experimentalidea.replaypacketcleaner.protocol.EntityType;

import java.util.ArrayList;
import java.util.List;

/// Remove all entities, except players.
public class EntityRemover implements SpawnEntityPacketListener, SpawnExperienceOrbPacketListener, RemoveEntitiesPacketListener,
        DamageEventPacketListener, EntityAnimationPacketListener, EntityEffectPacketListener, EntityEventPacketListener, HurtAnimationPacketListener,
        LinkEntitiesPacketListener, MoveMinecartAlongTrackPacketListener, PickupItemPacketListener, ProjectilePowerPacketListener,
        RemoveEntityEffectPacketListener, SetEntityMetadataPacketListener, SetEntityVelocityPacketListener, SetEquipmentPacketListener,
        SetHeadRotationPacketListener, SetPassengersPacketListener, SynchronizeVehiclePositionPacketListener, TeleportEntityPacketListener,
        UpdateAttributesPacketListener, UpdateEntityPositionPacketListener, UpdateEntityPositionAndRotationPacketListener,
        UpdateEntityRotationPacketListener {

    public EntityRemover() {
        this.exemptEntities = new ArrayList<Integer>(8);
    }

    private final List<Integer> exemptEntities;


    // Track player entities ids and remove spawn packets for anything that is not a player.
    @Override
    public void onSpawnEntityPacket(SpawnEntityPacket spawnEntityPacket) {
        if (spawnEntityPacket.getEntityType() == EntityType.PLAYER) {
            this.exemptEntities.add(spawnEntityPacket.getEntityID());
        } else {
            spawnEntityPacket.setWriteCanceled(true);
        }
    }

    // Remove Experience Orbs. (Note: this packet type was removed in protocol 770+ / MC 1.21.5+)
    @Override
    public void onSpawnExperienceOrbPacket(SpawnExperienceOrbPacket spawnExperienceOrbPacket) {
        spawnExperienceOrbPacket.setWriteCanceled(true);
    }

    // Stop tracking a player's entity id when they are removed.
    @Override
    public void onRemoveEntitiesPacket(RemoveEntitiesPacket removeEntitiesPacket) {
        int[] entityIDs = removeEntitiesPacket.getEntityIDs();
        int[] updatedEntityIDs = null;
        for (int id : entityIDs) {
            if (this.exemptEntities.remove(Integer.valueOf(id))) {
                if (updatedEntityIDs == null) {
                    updatedEntityIDs = new int[]{id};
                } else {
                    int[] expandedCopy = new int[updatedEntityIDs.length + 1];
                    System.arraycopy(updatedEntityIDs, 0, expandedCopy, 0, updatedEntityIDs.length);
                    expandedCopy[expandedCopy.length - 1] = id;
                    updatedEntityIDs = expandedCopy;
                }
            }
        }
        if (updatedEntityIDs != null) {
            removeEntitiesPacket.setEntityIDs(updatedEntityIDs);
        } else {
            removeEntitiesPacket.setWriteCanceled(true);
        }
    }


    // If a packet involves an entity that is getting removed, cancel writing out all the associated packets for that entity.

    @Override
    public void onDamageEventPacket(DamageEventPacket damageEventPacket) {
        if (!this.exemptEntities.contains(damageEventPacket.getEntityID())) {
            damageEventPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onEntityAnimationPacket(EntityAnimationPacket entityAnimationPacket) {
        if (!this.exemptEntities.contains(entityAnimationPacket.getEntityID())) {
            entityAnimationPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onEntityEffectPacket(EntityEffectPacket entityEffectPacket) {
        if (!this.exemptEntities.contains(entityEffectPacket.getEntityID())) {
            entityEffectPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onEntityEvent(EntityEventPacket entityEventPacket) {
        if (!this.exemptEntities.contains(entityEventPacket.getEntityID())) {
            entityEventPacket.setWriteCanceled(true);
        }
    }

/*    @Override  // TODO: Add.  Have not implemented a means of getting an entity id from this packet yet.
    public void onEntitySoundEffectPacket(EntitySoundEffectPacket entitySoundEffectPacket) {
        if (!this.exemptEntities.contains(...)) {
            entitySoundEffectPacket.setWriteCanceled(true);
        }
    }*/

    @Override
    public void onHurtAnimationPacket(HurtAnimationPacket hurtAnimationPacket) {
        if (!this.exemptEntities.contains(hurtAnimationPacket.getEntityID())) {
            hurtAnimationPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onLinkEntitiesPacket(LinkEntitiesPacket linkEntitiesPacket) {
        linkEntitiesPacket.setWriteCanceled(true);
    }

    @Override
    public void onMoveMinecartAlongTrackPacket(MoveMinecartAlongTrackPacket moveMinecartAlongTrackPacket) {
        moveMinecartAlongTrackPacket.setWriteCanceled(true);
    }

    @Override
    public void onPickupItemPacket(PickupItemPacket pickupItemPacket) {
        pickupItemPacket.setWriteCanceled(true);
    }

    @Override
    public void onProjectilePowerPacket(ProjectilePowerPacket projectilePowerPacket) {
        if (!this.exemptEntities.contains(projectilePowerPacket.getEntityID())) {
            projectilePowerPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onRemoveEntityEffectPacket(RemoveEntityEffectPacket removeEntityEffectPacket) {
        if (!this.exemptEntities.contains(removeEntityEffectPacket.getEntityID())) {
            removeEntityEffectPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onSetEntityMetadataPacket(SetEntityMetadataPacket setEntityMetadataPacket) {
        if (!this.exemptEntities.contains(setEntityMetadataPacket.getEntityID())) {
            setEntityMetadataPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onSetEntityVelocityPacket(SetEntityVelocityPacket setEntityVelocityPacket) {
        if (!this.exemptEntities.contains(setEntityVelocityPacket.getEntityID())) {
            setEntityVelocityPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onSetEquipmentPacket(SetEquipmentPacket setEquipmentPacket) {
        if (!this.exemptEntities.contains(setEquipmentPacket.getEntityID())) {
            setEquipmentPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onSetHeadRotationPacket(SetHeadRotationPacket setHeadRotationPacket) {
        if (!this.exemptEntities.contains(setHeadRotationPacket.getEntityID())) {
            setHeadRotationPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onSetPassengersPacket(SetPassengersPacket setPassengersPacket) {
        setPassengersPacket.setWriteCanceled(true);
    }

    @Override
    public void onSynchronizeVehiclePositionPacket(SynchronizeVehiclePositionPacket synchronizeVehiclePositionPacket) {
        if (!this.exemptEntities.contains(synchronizeVehiclePositionPacket.getEntityID())) {
            synchronizeVehiclePositionPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onTeleportEntityPacket(TeleportEntityPacket teleportEntityPacket) {
        if (!this.exemptEntities.contains(teleportEntityPacket.getEntityID())) {
            teleportEntityPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onUpdateAttributesPacket(UpdateAttributesPacket updateAttributesPacket) {
        if (!this.exemptEntities.contains(updateAttributesPacket.getEntityID())) {
            updateAttributesPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onUpdateEntityPositionAndRotationPacket(UpdateEntityPositionAndRotationPacket updateEntityPositionAndRotationPacket) {
        if (!this.exemptEntities.contains(updateEntityPositionAndRotationPacket.getEntityID())) {
            updateEntityPositionAndRotationPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onUpdateEntityPositionPacket(UpdateEntityPositionPacket updateEntityPositionPacket) {
        if (!this.exemptEntities.contains(updateEntityPositionPacket.getEntityID())) {
            updateEntityPositionPacket.setWriteCanceled(true);
        }
    }

    @Override
    public void onUpdateEntityRotationPacket(UpdateEntityRotationPacket updateEntityRotationPacket) {
        if (!this.exemptEntities.contains(updateEntityRotationPacket.getEntityID())) {
            updateEntityRotationPacket.setWriteCanceled(true);
        }
    }

}
