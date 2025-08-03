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
package com.experimentalidea.replaypacketcleaner.config;

import com.experimentalidea.replaypacketcleaner.ReplayPacketCleaner;
import com.experimentalidea.replaypacketcleaner.job.ReplayJob;

/**
 * This enum acts as keys for a {@link Configuration} which represents the profile of options to be used for a {@link ReplayJob}.
 */
public enum Option implements ConfigurationKey {


    BLOCK_ACTION_REMOVE(
            new String[]{"profile", "blockAction", "remove"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.BOOLEAN},
            Boolean.FALSE),

    ENTITIES_REMOVE_ALL(
            new String[]{"profile", "entities", "removeAll"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.BOOLEAN},
            Boolean.FALSE),

    PARTICLE_REMOVE_ALL(
            new String[]{"profile", "particle", "removeAll"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.BOOLEAN},
            Boolean.FALSE),

    PROFILE_METADATA_APP_VERSION(
            new String[]{"profile", "metaData", "appVersion"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.STRING},
            ReplayPacketCleaner.APP_VERSION),

    PROFILE_METADATA_DATA_VERSION(
            new String[]{"profile", "metaData", "dataVersion"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.INTEGER},
            Integer.valueOf(ReplayPacketCleaner.APP_PROFILE_JSON_VERSION)),

    PROFILE_METADATA_GEN_DATE(
            new String[]{"profile", "metaData", "genDate"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.LONG},
            Long.valueOf(System.currentTimeMillis())),

    PROFILE_METADATA_PROFILE_NAME(
            new String[]{"profile", "metaData", "profileName"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.STRING},
            "default"),

    SOUND_REMOVE_ALL(
            new String[]{"profile", "sound", "removeAll"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.BOOLEAN},
            Boolean.FALSE),

    TIME_OVERRIDE(
            new String[]{"profile", "time", "override"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.BOOLEAN},
            Boolean.FALSE),

    TIME_SET(
            new String[]{"profile", "time", "set"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.LONG},
            Long.valueOf(0L)),

    WEATHER_OVERRIDE(
            new String[]{"profile", "weather", "override"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.BOOLEAN},
            Boolean.FALSE),

    WEATHER_IS_RAINING(
            new String[]{"profile", "weather", "isRaining"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.BOOLEAN},
            Boolean.FALSE),

    WEATHER_RAIN_LEVEL(
            new String[]{"profile", "weather", "rainLevel"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.FLOAT},
            Float.valueOf(0.0F)),

    WEATHER_THUNDER_LEVEL(
            new String[]{"profile", "weather", "thunderLevel"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.FLOAT},
            Float.valueOf(0.0F)),

    WEATHER_REMOVE_LIGHTING_STRIKES(
            new String[]{"profile", "weather", "removeLightingStrikes"},
            new ValueType[]{ValueType.JSON_OBJECT, ValueType.JSON_OBJECT, ValueType.BOOLEAN},
            Boolean.FALSE),

    ;


    Option(String[] jsonNodePaths, ValueType[] jsonNodeTypes, Object defaultValue) {
        this.metadata =
                new KeyMetadata(
                        this,
                        jsonNodePaths,
                        jsonNodeTypes,
                        defaultValue);
    }

    private final KeyMetadata metadata;


    @Override
    public KeyMetadata getMetadata() {
        return this.metadata;
    }

}
