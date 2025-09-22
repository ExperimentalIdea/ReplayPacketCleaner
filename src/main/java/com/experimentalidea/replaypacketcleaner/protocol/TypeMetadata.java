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

public class TypeMetadata<E extends Enum<E> & ProtocolMetadata> {

    /**
     * Create a TypeMetadata object to be associated with an enum instance which implements {@link PacketType}.
     *
     * @param type          The enum instance which this TypeMetadata is for.
     * @param jsonNodePaths A string[] of jsonNodes for this Type.
     * @throws IllegalArgumentException If any parameter is null.
     */
    public TypeMetadata(E type, String[] jsonNodePaths) throws IllegalArgumentException {
        // Confirm none of the provided parameters are null.
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        if (jsonNodePaths == null) {
            throw new IllegalArgumentException("jsonNodePaths[] cannot be null");
        }
        if (jsonNodePaths.length == 0) {
            throw new IllegalArgumentException("jsonNodePaths[] cannot be empty");
        }
        for (String node : jsonNodePaths) {
            if (node == null) {
                throw new IllegalArgumentException("jsonNodePaths[] cannot contain a null");
            }
        }

        this.type = type;
        this.jsonNodePaths = jsonNodePaths;
    }

    public static final String JSON_NODE_PROTOCOL = "protocol";
    public static final String JSON_NODE_METADATA = "metadata";
    public static final String JSON_NODE_PROTOCOL_VERSION = "protocol_version";
    public static final String JSON_NODE_FILE_FORMAT_VERSION = "file_format_version";
    public static final String JSON_NODE_MC_VERSIONS = "mc_versions";

    public static final String JSON_NODE_PACKETS = "packets";
    public static final String JSON_NODE_STATE_CONFIGURATION = "configuration";
    public static final String JSON_NODE_STATE_LOGIN = "login";
    public static final String JSON_NODE_STATE_PLAY = "play";

    public static final String JSON_NODE_REGISTRIES = "registries";
    public static final String JSON_NODE_ENTITY_TYPE = "entity_type";
    public static final String JSON_NODE_BLOCK = "block";
    public static final String JSON_NODE_BLOCKSTATES = "blockstates";
    public static final String JSON_NODE_BLOCK_ENTITY = "block_entity";
    public static final String JSON_NODE_ITEM = "item";

    public static final String JSON_NODE_RESOURCE = "resource";
    public static final String JSON_NODE_ID = "id";


    private final E type;
    private final String[] jsonNodePaths;


    public E getType() {
        return this.type;
    }

    /// Returns the JSON node paths to the json object that contains the Protocol ID & Resource Name for this Type.
    public String[] getJSONNodePaths() {
        String[] copy = new String[this.jsonNodePaths.length];
        System.arraycopy(this.jsonNodePaths, 0, copy, 0, copy.length);
        return copy;
    }

    public String getJSONIDKey() {
        return TypeMetadata.JSON_NODE_ID;
    }

    public String getJSONResourceNameKey() {
        return TypeMetadata.JSON_NODE_RESOURCE;
    }

}
