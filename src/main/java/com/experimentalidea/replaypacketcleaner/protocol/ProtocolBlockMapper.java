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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class ProtocolBlockMapper extends ProtocolMapper<Block> {

    public ProtocolBlockMapper(int protocolVersion, JSONObject jsonProtocolMappings) throws IllegalArgumentException, IllegalStateException {
        super(Block.UNDEFINED, protocolVersion, jsonProtocolMappings);


        Block[] enumConstants = Block.values();

        this.blockstateLookup = new Block[enumConstants.length];
        Arrays.fill(this.blockstateLookup, Block.UNDEFINED);

        // Set up the array that will be used to map to block type from blockstates
        for (Block block : enumConstants) {
            if(block == Block.UNDEFINED){
                continue;
            }

            TypeMetadata<Block> metadata = block.getMetadata();

            // Get the set of keys required to traverse the json object to the point where the packetID & ResourceName should be.
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
            // Skip to the next iteration if this packetType doesn't have a protocol mapping.
            if (currentNode == null) {
                continue;
            }

            JSONArray jsonArray = currentNode.optJSONArray(TypeMetadata.JSON_NODE_BLOCKSTATES, null);

            if (jsonArray == null || jsonArray.isEmpty()) {
                continue;
            }

            for (int i = 0; i < jsonArray.length(); i++) {
                int value = jsonArray.optInt(i, -1);

                if (value == -1) {
                    continue;
                }

                // Before mapping the blockstate to the block type,
                // check if the blockstate value would be out of bounds of the blockstateLookup array and expand said array if necessary.
                if (value >= this.blockstateLookup.length) {
                    Block[] expandedArray = new Block[value + 1];
                    System.arraycopy(this.blockstateLookup, 0, expandedArray, 0, this.blockstateLookup.length);
                    // Set default values for the extended portion of the array.
                    for (int expandedArrayIndex = this.blockstateLookup.length; expandedArrayIndex < expandedArray.length; expandedArrayIndex++) {
                        expandedArray[expandedArrayIndex] = Block.UNDEFINED;
                    }
                    this.blockstateLookup = expandedArray;
                }

                this.blockstateLookup[value] = block;
            }
        }
    }



    /// Where the index number is the blockstate and the Block corresponds to the blockstate. (undefined type for unsupported)
    private Block[] blockstateLookup;



    /// Get the type by state. An unsupported state will return the undefined type.
    public Block getBlockByState(int state) {
        /// Check if the provided id is within range and return the undefined type for a value of -1.
        if (state >= this.blockstateLookup.length || state < 0) {
            return Block.UNDEFINED;
        }
        return this.blockstateLookup[state];
    }


}
