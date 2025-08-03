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

import org.json.JSONObject;

/**
 * Used in conjunction with an enum that implements {@link ConfigurationKey}.
 * Provides metadata for a {@link Configuration} object to map the enum keys to and from values in a {@link JSONObject}.
 * As well as a default value to be used by a {@link Configuration} when no value is found.
 */
public class KeyMetadata {

    /**
     * Create a KeyMetadata object to be associated with an enum instance which implements {@link ConfigurationKey}.
     *
     * @param key           The ConfigurationKey enum instance which this KeyMetadata is for.
     * @param jsonNodePaths An array of strings. Each string points to the next node in a JSONObject.
     * @param jsonNodeTypes An array of ValueType enums. Each value type defines the next type of node within an JSONObject.
     * @param defaultValue  A default value to be used by a {@link Configuration} when no value is found.
     * @throws IllegalArgumentException If any parameter is null.
     *                                  If jsonNodePaths.length and jsonNodeTypes.length is not equal to each other or not greater than 0.
     *                                  If any jsonNodeTypes has more values after a terminating node (anything != ValueType.JSON_OBJECT).
     *                                  If jsonNodeTypes[jsonNodeTypes.length - 1] is not a terminating node (equals ValueType.JSON_OBJECT).
     *                                  If the provided defaultValue is not applicable to the type jsonNodeTypes[jsonNodeTypes.length - 1].
     */
    public KeyMetadata(ConfigurationKey key, String[] jsonNodePaths, ValueType[] jsonNodeTypes, Object defaultValue) throws IllegalArgumentException {
        // Confirm none of the provided parameters are null.
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        if (jsonNodePaths == null) {
            throw new IllegalArgumentException("jsonNodePaths for key " + key.getClass().getName() + "." + key.toString() + " cannot be null");
        }
        if (jsonNodeTypes == null) {
            throw new IllegalArgumentException("jsonNodeTypes for key " + key.getClass().getName() + "." + key.toString() + " cannot be null");
        }
        if (defaultValue == null) {
            throw new IllegalArgumentException("defaultValue for key " + key.getClass().getName() + "." + key.toString() + " cannot be null");
        }
        for (int i = 0; i < jsonNodePaths.length; i++) {
            if (jsonNodePaths[i] == null) {
                throw new IllegalArgumentException("Entry jsonNodePaths[" + i + "] for key " + key.getClass().getName() + "." + key.toString() + " cannot be null");
            }
        }
        for (int i = 0; i < jsonNodeTypes.length; i++) {
            if (jsonNodeTypes[i] == null) {
                throw new IllegalArgumentException("Entry jsonNodeTypes[" + i + "] for key " + key.getClass().getName() + "." + key.toString() + " cannot be null");
            }
        }

        // Validate the arrays are sized correctly
        if (jsonNodePaths.length == 0) {
            throw new IllegalArgumentException("jsonNodePaths.length for key " + key.getClass().getName() + "." + key.toString() + " must be greater than 0");
        }
        if (jsonNodeTypes.length == 0) {
            throw new IllegalArgumentException("jsonNodeTypes.length for key " + key.getClass().getName() + "." + key.toString() + " must be greater than 0");
        }
        if (jsonNodePaths.length != jsonNodeTypes.length) {
            throw new IllegalArgumentException("jsonNodePaths must be equal the length of jsonNodeTypes for key " + key.getClass().getName() + "." + key.toString());
        }

        // Ensure the sequence of entries in the jsonNodeTypes array is valid.
        if (jsonNodeTypes.length >= 2) {
            for (int i = 0; i < jsonNodeTypes.length; i++) {
                if (jsonNodeTypes[i] != ValueType.JSON_OBJECT && i != (jsonNodeTypes.length - 1)) {
                    throw new IllegalArgumentException("There cannot be another node after the terminating node ValueType." + jsonNodeTypes[i].toString()
                            + " in jsonNodeTypes for key " + key.getClass().getName() + "." + key.toString() + ". Only ValueType.JSON_OBJECT should be used for each node except the last node.");
                }
            }
        }

        // Verify the provided defaultValue is valid.
        switch (jsonNodeTypes[jsonNodeTypes.length - 1]) {
            case JSON_OBJECT -> {
                throw new IllegalArgumentException("The last index of jsonNodeTypes cannot be ValueType.JSON_OBJECT for key " + key.getClass().getName() + "." + key.toString());
            }
            case ARRAY_STRING -> {
                if (!(defaultValue instanceof String[])) {
                    throw new IllegalArgumentException("The provided default value for " + key.getClass().getName() + "." + key.toString() + " is not an instance of String[].");
                }
            }
            case STRING -> {
                if (!(defaultValue instanceof String)) {
                    throw new IllegalArgumentException("The provided default value for " + key.getClass().getName() + "." + key.toString() + " is not an instance of String.");
                }
            }
            case BOOLEAN -> {
                if (!(defaultValue instanceof Boolean))
                    throw new IllegalArgumentException("The provided default value for " + key.getClass().getName() + "." + key.toString() + " is not an instance of Boolean.");
            }
            case INTEGER -> {
                if (defaultValue instanceof Number) {
                    defaultValue = Integer.valueOf(((Number) defaultValue).intValue());
                } else {
                    throw new IllegalArgumentException("The provided default value for " + key.getClass().getName() + "." + key.toString() + " is not an instance of Number. Integer expected.");
                }
            }
            case LONG -> {
                if (defaultValue instanceof Number) {
                    defaultValue = Long.valueOf(((Number) defaultValue).longValue());
                } else {
                    throw new IllegalArgumentException("The provided default value for " + key.getClass().getName() + "." + key.toString() + " is not an instance of Number. Long expected.");
                }
            }
            case FLOAT -> {
                if (defaultValue instanceof Number) {
                    defaultValue = Float.valueOf(((Number) defaultValue).floatValue());
                } else {
                    throw new IllegalArgumentException("The provided default value for " + key.getClass().getName() + "." + key.toString() + " is not an instance of Number. Float expected.");
                }
            }
            case DOUBLE -> {
                if (defaultValue instanceof Number) {
                    defaultValue = Double.valueOf(((Number) defaultValue).doubleValue());
                } else {
                    throw new IllegalArgumentException("The provided default value for " + key.getClass().getName() + "." + key.toString() + " is not an instance of Number. Double expected.");
                }
            }
        }

        this.key = key;

        this.jsonNodePaths = jsonNodePaths;
        this.jsonNodeTypes = jsonNodeTypes;
        this.defaultValue = defaultValue;
    }

    /// The key this metadata is associated with.
    public final ConfigurationKey key;

    private final String[] jsonNodePaths;
    private final ValueType[] jsonNodeTypes;
    private final Object defaultValue;

    /**
     * Get the json node paths associated with this key.
     * Each index corresponds with the same index in the json node types array.
     *
     * @return A copy of the underlying String[]. The length of this array matches the length of the json node types array.
     */
    public String[] getJsonNodePaths() {
        String[] copy = new String[this.jsonNodePaths.length];
        System.arraycopy(this.jsonNodePaths, 0, copy, 0, copy.length);
        return copy;
    }

    /**
     * Get the json node types associated with this key.
     * Each index corresponds with the same index in the json node paths array.
     *
     * @return A copy of the underlying ValueType[]. The length of this array matches the length of the json node paths array.
     */
    public ValueType[] getJsonNodeTypes() {
        ValueType[] copy = new ValueType[this.jsonNodeTypes.length];
        System.arraycopy(this.jsonNodeTypes, 0, copy, 0, copy.length);
        return copy;
    }

    /**
     * Get the value type associated with this key.
     * Equivalent to .getJsonNodeTypes()[.getJsonNodeTypes().length - 1].
     *
     * @return The value type corresponding with the associated key of this metadata.
     */
    public ValueType getValueType() {
        return this.jsonNodeTypes[this.jsonNodeTypes.length - 1];
    }

    /**
     * Get the default value to be used for the associated key.
     * Typically used when initializing a {@link Configuration} with default values to be used in the absents of values provided from a source.
     *
     * @return The value type corresponding with the associated key of this metadata.
     */
    public Object getDefaultValue() {
        if (this.jsonNodeTypes[this.jsonNodeTypes.length - 1] == ValueType.ARRAY_STRING) {
            String[] source = (String[]) this.defaultValue;
            String[] copy = new String[source.length];
            System.arraycopy(source, 0, copy, 0, copy.length);
            return copy;
        } else {
            return this.defaultValue;
        }
    }

}
