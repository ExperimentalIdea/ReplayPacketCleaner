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

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;

public class ProtocolMapper<E extends Enum<E> & ProtocolMetadata> {


    public ProtocolMapper(E undefinedType, int protocolVersion, JSONObject jsonProtocolMappings) throws IllegalArgumentException, IllegalStateException {
        if (undefinedType == null) {
            throw new IllegalArgumentException("undefinedType cannot be null");
        }
        if (jsonProtocolMappings == null) {
            throw new IllegalArgumentException("jsonProtocolMappings cannot be null");
        }

        this.undefinedType = undefinedType;
        this.protocolVersion = protocolVersion;

        E[] enumConstants = undefinedType.getDeclaringClass().getEnumConstants();

        this.resourceNameLookup = new EnumMap<E, String>(this.undefinedType.getDeclaringClass());
        this.reverseResourceNameLookup = new HashMap<String, E>(enumConstants.length);

        // Set up the arrays that will be used to map to/from packet type / packet id
        this.typeLookup = (E[]) Array.newInstance(this.undefinedType.getDeclaringClass(), enumConstants.length);
        Arrays.fill(this.typeLookup, this.undefinedType);

        this.idLookup = new int[enumConstants.length];
        Arrays.fill(this.idLookup, ProtocolMapper.UNDEFINED_ID);

        // Populate the protocol mapping arrays.
        for (E type : enumConstants) {
            if(type == this.undefinedType){
                continue;
            }

            TypeMetadata metadata = type.getMetadata();

            // Get the set of keys required to traverse the json object to the point where the ID & ResourceName should be.
            String[] jsonNodePaths = metadata.getJSONNodePaths();

            JSONObject currentNode = jsonProtocolMappings;
            for (int i = 0; i < jsonNodePaths.length; i++) {
                // Traverse the jsonObject to the next node.
                JSONObject nextNode = currentNode.optJSONObject(jsonNodePaths[i]);
                currentNode = nextNode;
                if (nextNode == null) {
                    break;
                }
            }

            // Skip to the next iteration if this Type doesn't have a protocol mapping.
            if (currentNode == null) {
                continue;
            }

            // Get the ID.
            int id = currentNode.optInt(metadata.getJSONIDKey(), ProtocolMapper.UNDEFINED_ID);

            // Map the ID/Type, so long it isn't undefined for this Type. (if undefined, it's likely due to it being unsupported for the given protocol)
            if (id != ProtocolMapper.UNDEFINED_ID) {

                if (this.idLookup[type.ordinal()] != ProtocolMapper.UNDEFINED_ID) {
                    throw new IllegalStateException("Type " + type.name() + " is assigned two or more times for " + this.undefinedType.getDeclaringClass().getName() + ".");
                }

                // Map the tType to the ID
                this.idLookup[type.ordinal()] = id;

                // Before mapping the ID to the Type,
                // check if the ID value would be out of bounds of the typeLookup array and expand said array if necessary.
                if (id >= this.typeLookup.length) {
                    E[] expandedArray = (E[]) Array.newInstance(this.undefinedType.getDeclaringClass(), id + 1);
                    System.arraycopy(this.typeLookup, 0, expandedArray, 0, this.typeLookup.length);
                    // Set default values for the extended portion of the array.
                    for (int expandedArrayIndex = this.typeLookup.length; expandedArrayIndex < expandedArray.length; expandedArrayIndex++) {
                        expandedArray[expandedArrayIndex] = this.undefinedType;
                    }
                    this.typeLookup = expandedArray;
                }

                if (this.typeLookup[id] != this.undefinedType) {
                    throw new IllegalStateException("Id " + id + " is assigned two or more times for " + this.undefinedType.getDeclaringClass().getName() + ".");
                }

                // Map the ID to the current Type.
                this.typeLookup[id] = type;

                // Lastly, map the resourceName (if available). For versions 1.12.x and below, there will be no resourceName.
                String resourceName = currentNode.optString(metadata.getJSONResourceNameKey(), null);
                if (resourceName != null) {
                    this.resourceNameLookup.put(type, resourceName);
                    this.reverseResourceNameLookup.put(resourceName, type);
                }
            }
        }
    }


    public static final String UNDEFINED_RESOURCE_NAME = "";
    public static final int UNDEFINED_ID = -1;

    private final E undefinedType;

    private final int protocolVersion;

    /// Where the index number is the ID and the Type corresponds to the ID. (undefined type for unsupported)
    private E[] typeLookup;

    /// Where the index is the Type.E ordinal value and the corresponding int value is the ID (-1 for unsupported)
    private int[] idLookup;

    private EnumMap<E, String> resourceNameLookup;
    private HashMap<String, E> reverseResourceNameLookup;


    public int getProtocolVersion() {
        return this.protocolVersion;
    }


    /// Get the type by id. An unsupported id will return the undefined type.
    public E getType(int id) {
        /// Check if the provided id is within range and return the undefined type for a value of -1.
        if (id >= this.idLookup.length || id < 0) {
            return this.undefinedType;
        }
        return this.typeLookup[id];
    }

    /// returns -1 if type is null or unsupported by the protocol.
    public int getID(E type) {
        if (type == null) {
            return ProtocolMapper.UNDEFINED_ID;
        }
        return this.idLookup[type.ordinal()];
    }

    /// Returns and empty string if the resource cannot be found or if a resource name doesn't exist.
    public String getResourceName(E type) {
        String resourceName = this.resourceNameLookup.get(type);
        if (resourceName == null) {
            resourceName = ProtocolMapper.UNDEFINED_RESOURCE_NAME;
        }
        return resourceName;
    }

    /// Get type by resource name. Returns the undefined type if the provided resource is unknown.
    public E getType(String resourceName) {
        E packetType = this.reverseResourceNameLookup.get(resourceName);
        if (packetType == null) {
            packetType = this.undefinedType;
        }
        return packetType;
    }

}
