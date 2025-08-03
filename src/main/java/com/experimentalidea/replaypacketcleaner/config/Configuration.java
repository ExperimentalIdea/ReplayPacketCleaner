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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.EnumMap;
import java.util.Map;

/**
 * A general purpose object for getting and setting configuration options/settings.
 * All values stored within the configuration are immutable objects, with even string arrays being treated effectively as such. (copy on get/set)
 * <p>
 * An enum which implements {@link ConfigurationKey} acts as the keys to each value within a Configuration object.
 * Each enum ConfigurationKey instance defines the mapping of the value to/from a {@link JSONObject}, the type of value, and a default non-null value
 * to use in instances where the value doesn't exist in the source json or when creating a Configuration initialized with all default values.
 * <p>
 * Under no circumstance will the value corresponding to a given key will be null, nor is it possible to store null values.
 * When creating a new instance of the Configuration object, the underlying EnumMap will be populated with the default values provided by key.getMetaData().getDefaultValue() for each possible key.
 * <p>
 * This implementation is not inherently thread-safe.
 * While getting the contents of this configuration concurrently across multiple threads perfectly fine for read-only use cases.
 * Thread synchronization should be employed for all methods if one or more threads will be manipulating its contents.
 * <p>
 * Alternatively, usage of .copy() to create a shallow copy of a configuration instance before handing the copy off to another thread
 * may be desirable in scenarios where the other thread simply requires a 'snapshot' of the configuration's state at the time of invoking .copy().
 */
public class Configuration<K extends Enum<K> & ConfigurationKey> {


    /**
     * This constructor is only utilized by the .copy() method within this Configuration object.
     */
    private Configuration(Class<K> keyClass, EnumMap<K, Object> configurationMap) {
        this.keyClass = keyClass;
        this.configurationMap = configurationMap;
    }

    /**
     * Create a new Configuration object initialized with default values.
     *
     * @param keyClass The enum class that acts as keys for this configuration.
     */
    public Configuration(Class<K> keyClass) {
        if (keyClass == null) {
            throw new IllegalArgumentException("keyClass cannot be null");
        }
        this.keyClass = keyClass;

        this.configurationMap = new EnumMap<K, Object>(keyClass);

        for (K key : keyClass.getEnumConstants()) {
            this.configurationMap.put(key, key.getMetadata().getDefaultValue());
        }
    }

    /**
     * Create a new Configuration object initialized from a {@link JSONObject}.
     * <p>
     * In instances where the provided JSONObject doesn't contain a value for the associated key, the value from key.getDefaultValue() will be used.
     * Does not support JSONObjects nested within a JSONArrays. JSONArrays are just treated as string arrays.
     *
     * @param keyClass   The enum class that acts as keys for this configuration.
     * @param jsonObject The JSONObject containing the values for initializing this configuration.
     */
    public Configuration(Class<K> keyClass, JSONObject jsonObject) {
        this(keyClass);

        // For each possible key, get the value from the provided jsonObject and put it in the configurationMap.
        // If the provided jsonObject does not contain the value corresponding to the given key, the default value will be used instead.
        for (K key : keyClass.getEnumConstants()) {
            String[] nodePaths = key.getMetadata().getJsonNodePaths();
            ValueType[] valueTypes = key.getMetadata().getJsonNodeTypes();
            JSONObject currentNode = jsonObject;
            int lastNodeIndex = nodePaths.length - 1;
            for (int i = 0; i < nodePaths.length; i++) {

                // If this node points to another node, get that node as the next currentNode
                if (valueTypes[i] == ValueType.JSON_OBJECT) {
                    if (currentNode.has(nodePaths[i])) {
                        currentNode = currentNode.getJSONObject(nodePaths[i]);
                    } else {
                        // When the next node doesn't exist, just break.
                        // The map was already initialized with default values, so in this instance the default value will be used.
                        break;
                    }
                } else { // Else, this should be the last node. put in the value into the map.
                    if (i != lastNodeIndex) {
                        throw new IllegalStateException("Expected to be the last node, but is not. key=" + key.name() + ", i=" + i + ", nodePaths[i]=" + nodePaths[i] + ", valueTypes[i]=" + valueTypes[i]);
                    }

                    if (!currentNode.has(nodePaths[i])) {
                        // If the current node did not contain the path to the value, break.
                        // Again, the map was already initialized with default values, so in this instance the default value will be used.
                        break;
                    }

                    switch (valueTypes[i]) {
                        case JSON_OBJECT: {
                            throw new IllegalStateException("A JSONObject cannot be a value within the configuration map");
                        }
                        case ARRAY_STRING: {
                            JSONArray jsonArray = currentNode.getJSONArray(nodePaths[i]);
                            if (jsonArray != null) {
                                Object[] array = jsonArray.toList().toArray();
                                String[] stringArray = new String[array.length];
                                for (int arrayIndex = 0; arrayIndex < stringArray.length; arrayIndex++) {
                                    stringArray[arrayIndex] = array[arrayIndex].toString();
                                }
                                this.set(key, stringArray);
                            }
                            break;
                        }
                        case STRING: {
                            this.set(key, currentNode.getString(nodePaths[lastNodeIndex]));
                            break;
                        }
                        case BOOLEAN: {
                            this.set(key, currentNode.getBoolean(nodePaths[lastNodeIndex]));
                            break;
                        }
                        case INTEGER: {
                            this.set(key, currentNode.getInt(nodePaths[lastNodeIndex]));
                            break;
                        }
                        case LONG: {
                            this.set(key, currentNode.getLong(nodePaths[lastNodeIndex]));
                            break;
                        }
                        case FLOAT: {
                            this.set(key, currentNode.getFloat(nodePaths[lastNodeIndex]));
                            break;
                        }
                        case DOUBLE: {
                            this.set(key, currentNode.getDouble(nodePaths[lastNodeIndex]));
                            break;
                        }
                    }
                }

            }
        }

    }

    /**
     * Create a new Configuration object initialized from a json formated {@link String}.
     * <p>
     * In instances where the provided jsonString doesn't contain a value for the associated key, the value from key.getDefaultValue() will be used.
     *
     * @param keyClass   The enum class that acts as keys for this configuration.
     * @param jsonString The jsonString containing the values for initializing this configuration.
     * @throws JSONException If there is a syntax error in the source string or a duplicated key when creating the JSONObject used internally to initialize this Configuration.
     */
    public Configuration(Class<K> keyClass, String jsonString) throws JSONException {
        this(keyClass, new JSONObject(jsonString));
    }


    private final Class<K> keyClass;

    /**
     * A Map of {@link K}'s to Object's.
     */
    private final EnumMap<K, Object> configurationMap;


    /**
     * Create a {@link JSONObject} from this configuration.
     *
     * @return A {@link JSONObject} representing the current state of this configuration at the time of invoking this method.
     */
    public JSONObject toJSONObject() {
        JSONObject rootJSONObject = new JSONObject();

        for (Map.Entry<K, Object> entry : this.configurationMap.entrySet()) {
            K key = entry.getKey();
            Object value = entry.getValue();

            String[] nodePaths = key.getMetadata().getJsonNodePaths();
            ValueType[] valueTypes = key.getMetadata().getJsonNodeTypes();
            JSONObject currentNode = rootJSONObject;
            int lastNodeIndex = nodePaths.length - 1;
            for (int i = 0; i < nodePaths.length; i++) {

                // If this node points to another node, create or get that node as the next currentNode
                if (valueTypes[i] == ValueType.JSON_OBJECT) {
                    if (currentNode.has(nodePaths[i])) {
                        currentNode = currentNode.getJSONObject(nodePaths[i]);
                    } else {
                        JSONObject newNode = new JSONObject();
                        currentNode.put(nodePaths[i], newNode);
                        currentNode = newNode;
                    }
                } else {
                    // Else, this should be the last node. put in the value.
                    if (i != lastNodeIndex) {
                        // This should never occur as the key metadata could not be created
                        throw new IllegalStateException("Expected to be the last node, but is not. key=" + key.name() + ", i=" + i + ", nodePaths[i]=" + nodePaths[i] + ", valueTypes[i]=" + valueTypes[i]);
                    }
                    if (valueTypes[i] == ValueType.ARRAY_STRING) {
                        JSONArray jsonArray = new JSONArray();
                        for (Object arrayValue : (Object[]) value) {
                            jsonArray.put(arrayValue);
                        }
                        value = jsonArray;
                    }
                    currentNode.put(nodePaths[i], value);
                }

            }
        }

        return rootJSONObject;
    }


    /**
     * Creates a shallow copy of this configuration object, and it's underlying EnumMap.
     *
     * @return A new configuration object with contents copied from this configuration.
     */
    public Configuration<K> copy() {
        EnumMap<K, Object> newMap = new EnumMap<K, Object>(this.keyClass);
        for (K key : this.keyClass.getEnumConstants()) {
            newMap.put(key, this.configurationMap.get(key));
        }
        return new Configuration<K>(this.keyClass, newMap);
    }


    /**
     * Sets a value in the {@link Configuration}.
     *
     * @param key   The key corresponding to the value that will be set.
     * @param value The value itself. If the value is an instance of {@link Number}, but not the correct type
     *              (i.e. {@link Integer} provided when {@link Long} is expected) it will be converted to the correct type.
     *              If the value is a String[], it's contents will be copied into a new array and that copy will be stored within the configuration.
     * @throws IllegalArgumentException If key and/or value is null, or if the value type is not applicable for the provided key.
     */
    public void set(K key, Object value) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }

        KeyMetadata metadata = key.getMetadata();

        // Validate the value provided is the correct type for the given key by comparing it to the object type of the key's default value.
        if (!value.getClass().isInstance(metadata.getDefaultValue())) {

            // It's possible a valid value has been provided, but as the "wrong" type. (i.e. Integer provided when a Long is expected)
            if (metadata.getDefaultValue() instanceof Number && value instanceof Number) {
                switch (metadata.getValueType()) {
                    case INTEGER -> value = Integer.valueOf(((Number) value).intValue());
                    case LONG -> value = Long.valueOf(((Number) value).longValue());
                    case FLOAT -> value = Float.valueOf(((Number) value).floatValue());
                    case DOUBLE -> value = Double.valueOf(((Number) value).doubleValue());

                    // The default case should never happen here, but just in case...
                    default ->
                            throw new IllegalArgumentException("value type \"" + value.getClass().getName() + "\" (isArray=" + value.getClass().isArray() + ") is not applicable to key.getValueType()=" + key.name() + ".");
                }
            } else {
                throw new IllegalArgumentException("value type \"" + value.getClass().getName() + "\" (isArray=" + value.getClass().isArray() + ") is not applicable to key.getValueType()=" + key.name() + ".");
            }
        }

        // Special case if the value type is a String[]. Make a copy of the provided array.
        if (metadata.getValueType() == ValueType.ARRAY_STRING) {
            String[] source = (String[]) value;
            String[] copy = new String[source.length];
            System.arraycopy(source, 0, copy, 0, copy.length);
            value = copy;
        }

        this.configurationMap.put(key, value);
    }


    /**
     * Resets a value in the {@link Configuration} to the default value.
     *
     * @param key The key corresponding to the value that will be reset.
     * @throws IllegalArgumentException If key is null.
     */
    public void reset(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }

        this.configurationMap.put(key, key.getMetadata().getDefaultValue());
    }


    /**
     * Get an {@link Object} from the configuration.
     *
     * @param key The key corresponding to a value within this configuration.
     * @return The value.
     * @throws IllegalArgumentException If the provided key is null.
     */
    public Object get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        return this.configurationMap.get(key);
    }

    /**
     * Get an {@link String} from the configuration.
     *
     * @param key The key corresponding to a value within this configuration.
     * @return The String value.
     * @throws IllegalArgumentException If the provided key is null, or not applicable to type String.
     */
    public String getString(K key) throws IllegalArgumentException {
        if (key.getMetadata().getValueType() != ValueType.STRING) {
            throw new IllegalArgumentException("key " + key.name() + " is not applicable to type String");
        }
        return (String) this.get(key);
    }

    /**
     * Get an {@link String}[] from the configuration.
     *
     * @param key The key corresponding to a value within this configuration.
     * @return A copy of the String[] value.
     * @throws IllegalArgumentException If the provided key is null, or not applicable to type String[].
     */
    public String[] getStringArray(K key) throws IllegalArgumentException {
        if (key.getMetadata().getValueType() != ValueType.ARRAY_STRING) {
            throw new IllegalArgumentException("key " + key.name() + " is not applicable to type String[]");
        }
        String[] source = (String[]) this.get(key);
        String[] copy = new String[source.length];
        System.arraycopy(source, 0, copy, 0, copy.length);
        return copy;
    }

    /**
     * Get an {@link Boolean} from the configuration.
     *
     * @param key The key corresponding to a value within this configuration.
     * @return The Boolean value.
     * @throws IllegalArgumentException If the provided key is null, or not applicable to type Boolean.
     */
    public Boolean getBoolean(K key) throws IllegalArgumentException {
        if (key.getMetadata().getValueType() != ValueType.BOOLEAN) {
            throw new IllegalArgumentException("key " + key.name() + " is not applicable to type Boolean");
        }
        return (Boolean) this.get(key);
    }

    /**
     * Get an {@link Integer} from the configuration.
     *
     * @param key The key corresponding to a value within this configuration.
     * @return The Integer value.
     * @throws IllegalArgumentException If the provided key is null, or not applicable to type Integer.
     *                                  Unlike in the case with setting number values, where any instance of an {@link Number} is valid and will
     *                                  be converted to the correct type if incorrect (i.e. {@link Integer} provided when {@link Long} is expected).
     *                                  The usage of .getInteger(key) must exactly match the value type associated with the key, otherwise this exception is thrown.
     */
    public Integer getInteger(K key) throws IllegalArgumentException {
        if (key.getMetadata().getValueType() != ValueType.INTEGER) {
            throw new IllegalArgumentException("key " + key.name() + " is not applicable to type Integer");
        }
        return (Integer) this.get(key);
    }

    /**
     * Get an {@link Long} from the configuration.
     *
     * @param key The key corresponding to a value within this configuration.
     * @return The Long value.
     * @throws IllegalArgumentException If the provided key is null, or not applicable to type Long.
     *                                  Unlike in the case with setting number values, where any instance of an {@link Number} is valid and will
     *                                  be converted to the correct type if incorrect (i.e. {@link Integer} provided when {@link Long} is expected).
     *                                  The usage of .getLong(key) must exactly match the value type associated with the key, otherwise this exception is thrown.
     */
    public Long getLong(K key) throws IllegalArgumentException {
        if (key.getMetadata().getValueType() != ValueType.LONG) {
            throw new IllegalArgumentException("key " + key.name() + " is not applicable to type Long");
        }
        return (Long) this.get(key);
    }

    /**
     * Get an {@link Float} from the configuration.
     *
     * @param key The key corresponding to a value within this configuration.
     * @return The Float value.
     * @throws IllegalArgumentException If the provided key is null, or not applicable to type Float.
     *                                  Unlike in the case with setting number values, where any instance of an {@link Number} is valid and will
     *                                  be converted to the correct type if incorrect (i.e. {@link Integer} provided when {@link Long} is expected).
     *                                  The usage of .getFloat(key) must exactly match the value type associated with the key, otherwise this exception is thrown.
     */
    public Float getFloat(K key) throws IllegalArgumentException {
        if (key.getMetadata().getValueType() != ValueType.FLOAT) {
            throw new IllegalArgumentException("key " + key.name() + " is not applicable to type Float");
        }
        return (Float) this.get(key);
    }

    /**
     * Get an {@link Double} from the configuration.
     *
     * @param key The key corresponding to a value within this configuration.
     * @return The Float value.
     * @throws IllegalArgumentException If the provided key is null, or not applicable to type Double.
     *                                  Unlike in the case with setting number values, where any instance of an {@link Number} is valid and will
     *                                  be converted to the correct type if incorrect (i.e. {@link Integer} provided when {@link Long} is expected).
     *                                  The usage of .getDouble(key) must exactly match the value type associated with the key, otherwise this exception is thrown.
     */
    public Double getDouble(K key) throws IllegalArgumentException {
        if (key.getMetadata().getValueType() != ValueType.DOUBLE) {
            throw new IllegalArgumentException("key " + key.name() + " is not applicable to type Double");
        }
        return (Double) this.get(key);
    }


    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof Configuration<?>)) {
            return false;
        }
        if (((Configuration<?>) obj).keyClass != this.keyClass) {
            return false;
        }
        for (Map.Entry<K, Object> entry : this.configurationMap.entrySet()) {
            if (!((Configuration<?>) obj).configurationMap.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }


}
