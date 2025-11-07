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
package com.experimentalidea.replaypacketcleaner.protocol;

public enum BlockEntity implements ProtocolMetadata {

    UNDEFINED,


    BANNER,
    BARREL,
    BEACON,
    BED,
    BEEHIVE,
    BELL,
    BLAST_FURNACE,
    BREWING_STAND,
    BRUSHABLE_BLOCK,
    CALIBRATED_SCULK_SENSOR,
    CAMPFIRE,
    CHEST,
    CHISELED_BOOKSHELF,
    COMMAND_BLOCK,
    COMPARATOR,
    CONDUIT,
    COPPER_GOLEM_STATUE,
    CRAFTER,
    CREAKING_HEART,
    DAYLIGHT_DETECTOR,
    DECORATED_POT,
    DISPENSER,
    DROPPER,
    ENCHANTING_TABLE,
    END_GATEWAY,
    END_PORTAL,
    ENDER_CHEST,
    FURNACE,
    HANGING_SIGN,
    HOPPER,
    JIGSAW,
    JUKEBOX,
    LECTERN,
    MOB_SPAWNER,
    PISTON,
    SCULK_CATALYST,
    SCULK_SENSOR,
    SCULK_SHRIEKER,
    SHELF,
    SHULKER_BOX,
    SIGN,
    SKULL,
    SMOKER,
    STRUCTURE_BLOCK,
    TEST_BLOCK,
    TEST_INSTANCE_BLOCK,
    TRAPPED_CHEST,
    TRIAL_SPAWNER,
    VAULT;


    BlockEntity() {
        this.metadata = new TypeMetadata<BlockEntity>(this, new String[]{TypeMetadata.JSON_NODE_PROTOCOL, TypeMetadata.JSON_NODE_REGISTRIES, TypeMetadata.JSON_NODE_BLOCK_ENTITY, this.name().toLowerCase()});
    }

    private final TypeMetadata<BlockEntity> metadata;

    @Override
    public TypeMetadata<BlockEntity> getMetadata() {
        return this.metadata;
    }

}
