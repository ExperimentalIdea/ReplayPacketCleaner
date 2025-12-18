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

import java.util.*;

/**
 * Used to automatically create basic documentation for all protocol enum types in
 * {@link PacketType.Login}, {@link PacketType.Configuration}, {@link PacketType.Play},
 * {@link EntityType}, {@link BlockEntity}, {@link Block}, & {@link Item}.
 */
public class DocumentationGenerator {


    /**
     * Creates formated text that can be used to replace the current protocol enum type documentation.
     * The supported enum's are {@link PacketType.Login}, {@link PacketType.Configuration},
     * {@link PacketType.Play}, {@link EntityType}, {@link BlockEntity}, {@link Block}, & {@link Item}.
     *
     * @param protocolDirectory The protocol directory with all the protocols supported by RPC loaded. Used as reference to create the documentation.
     * @param values            Array of all values for a supported enum.
     * @return A string containing all entries with basic documentation.
     */
    public static String generateTypeDocumentation(ProtocolDirectory protocolDirectory, Enum<?>[] values) {
        StringBuilder enumWithDocumentation = new StringBuilder(1024);

        List<Protocol> protocolList = protocolDirectory.getSupportedProtocols();

        // Ensure the array is sorted alphabetically.
        Arrays.sort(values, Comparator.comparing(Enum::name));

        // Handle the Undefined value first. (Always want it at the top)
        enumWithDocumentation.append("/**")
                .append("\n* Used to represent an undefined ").append(values[0].getDeclaringClass().getSimpleName()).append(" type.")
                .append("\n*/")
                .append("\nUNDEFINED,")
                .append("\n\n");

        for (Enum<?> type : values) {
            if (type.name().equals("UNDEFINED")) {
                continue;
            }

            // Begin Comment
            enumWithDocumentation.append("\n/**");
            enumWithDocumentation.append("\n* ").append(formatedName(type));
            enumWithDocumentation.append("\n* <br> ").append(getSupportedRangeFormated(protocolList, type, PrefixType.SUPPORTED_PROTOCOLS, false));
            String resources = getSupportedRangeFormated(protocolList, type, PrefixType.RESOURCE, true);
            if (resources != null) {
                enumWithDocumentation.append("\n* <br> ").append(resources);
            }
            String customComment = getCustomComment(type);
            if (customComment != null) {
                enumWithDocumentation.append("\n* <br>\n* <br> ").append(customComment.replaceAll("\n", "\n* "));
            }
            enumWithDocumentation.append("\n*/");
            // End of Comment

            // Add the enum Type under the comment.
            enumWithDocumentation.append("\n").append(type.name()).append(",");

            enumWithDocumentation.append("\n");
        }

        enumWithDocumentation.replace(enumWithDocumentation.length() - 2, enumWithDocumentation.length() - 1, ";");

        return enumWithDocumentation.toString();
    }


    /**
     * Create human-readable text showing the range of supported protocols or resources for this type.
     *
     * @param protocolList      The list of supported protocols to be used as reference.
     * @param type              The enum type.
     * @param prefixType        Type of prefix the returned string should have.
     * @param formatForResource Include resource name.
     * @return Returns the formated string, or null if there is no infomation.
     */
    private static String getSupportedRangeFormated(List<Protocol> protocolList, Enum<?> type, PrefixType prefixType, boolean formatForResource) {
        List<SupportedRangeToken> tokenList = getSupportedVersionRange(protocolList, type, formatForResource);

        StringBuilder builder = new StringBuilder(64);

        boolean pluralPrefix = false;
        for (SupportedRangeToken token : tokenList) {
            String resource = token.getResource();

            if (formatForResource && resource.equals(ProtocolMapper.UNDEFINED_RESOURCE_NAME)) {
                continue;
            }

            Protocol beginningProtocol = token.getBeginningProtocol();
            Protocol endingProtocol = token.getEndingProtocol();

            int lowerSupportedProtocol = beginningProtocol.getProtocolVersion();
            int upperSupportedProtocol = endingProtocol.getProtocolVersion();

            String lowerSupportedVersion = beginningProtocol.getMCVersions()[0];
            String upperSupportedVersion = endingProtocol.getMCVersions()[endingProtocol.getMCVersions().length - 1];

            if (!builder.isEmpty()) {
                builder.append(", ");
                pluralPrefix = true;
            }

            if (formatForResource) {
                builder.append(resource);
                if (tokenList.size() == 1) {
                    continue;
                } else {
                    builder.append(" (");
                }
            }

            builder.append(lowerSupportedProtocol);
            if (lowerSupportedProtocol != upperSupportedProtocol) {
                builder.append(" - ").append(upperSupportedProtocol);
                if (!formatForResource) {
                    pluralPrefix = true;
                }
            }

            builder.append(" (").append(lowerSupportedVersion);

            if (!lowerSupportedVersion.equals(upperSupportedVersion)) {
                builder.append(" - ").append(upperSupportedVersion);
            }

            builder.append(")");

            if (formatForResource) {
                builder.append(")");
            }
        }

        if (builder.isEmpty()) {
            return null;
        }

        return getPrefix(prefixType, pluralPrefix) + builder.toString();
    }

    private static String getPrefix(PrefixType prefixType, boolean pluralPrefix) {
        String prefix = "";
        switch (prefixType) {
            case SUPPORTED_PROTOCOLS -> {
                if (pluralPrefix) {
                    prefix = "Supported Protocols: ";
                } else {
                    prefix = "Supported Protocol: ";
                }
            }
            case RESOURCE -> {
                if (pluralPrefix) {
                    prefix = "Resources: ";
                } else {
                    prefix = "Resource: ";
                }
            }
        }
        return prefix;
    }


    /**
     * Creates a list of tokens that represent the range of supported protocol versions.
     *
     * @param protocolList      A list of all protocols supported by RPC.
     * @param type              The supported enum type
     * @param splitForResources If true, creates separate tokens for changes in resource names as well.
     * @return List of tokens, in the order of the provided protocol list.
     * Tokens can reference undefined resources (ProtocolMapper.UNDEFINED_RESOURCE_NAME) if the type is supported but doesn't have a resource name.
     */
    private static List<SupportedRangeToken> getSupportedVersionRange(List<Protocol> protocolList, Enum<?> type, boolean splitForResources) {
        List<SupportedRangeToken> tokenList = new ArrayList<>();

        Iterator<Protocol> iterator = protocolList.iterator();
        SupportedRangeToken currentToken = null;

        while (iterator.hasNext()) {
            Protocol protocol = iterator.next();
            String resource = getResource(protocol, type);

            // If unsupported and the current token isn't null, add the current token to the list and reset currentToken to null.
            if (!isSupported(protocol, type)) {
                if (currentToken != null) {
                    tokenList.add(currentToken);
                    currentToken = null;
                }
                continue;
            }

            // If the type is supported and the current token is null,
            // create a token with the current resource and jump to the next iteration of the loop.
            if (currentToken == null) {
                currentToken = new SupportedRangeToken(protocol, getResource(protocol, type));
                continue;
            }

            // If splitting tokens for protocols only and not protocols & resources,
            // update the current token's ending protocol and jump to the next iteration of the loop.
            if (!splitForResources) {
                currentToken.setEndingProtocol(protocol);
                continue;
            }

            // If supported and matching the current token's resource,
            // update the ending protocol and go to the next iteration of the loop.
            if (currentToken.matchesResource(resource)) {
                currentToken.setEndingProtocol(protocol);
                //continue;
            } else {
                // Else, finalize the current token and create a new token for the different resource.
                tokenList.add(currentToken);
                currentToken = new SupportedRangeToken(protocol, resource);
            }

        }

        // If a token exist, add it to the list before returning.
        if (currentToken != null) {
            tokenList.add(currentToken);
        }
        return tokenList;
    }


    /**
     * Get the custom comment for the type.
     *
     * @param type The enum type.
     * @return Returns the comment, or null if it doesn't exist.
     */
    private static String getCustomComment(Enum<?> type) {
        // Don't really have a better idea to handle extra documentation/notes.
        // For now, I'll write it all here.
        switch (type) {

            case PacketType.Login login -> {
                switch (login) {
                    case LOGIN_SUCCESS -> {
                        return "Switches the protocol state to PLAY in protocol versions 763 (1.20.1) and earlier."
                                + "\nFor protocol versions 764+ (1.20.2), see PacketType.Configuration.FINISH_CONFIGURATION.";
                    }

                }
            }

            case PacketType.Configuration configuration -> {
                switch (configuration) {
                    case FINISH_CONFIGURATION -> {
                        return "Switches the protocol state to PLAY in protocol versions 764 (1.20.2) and later."
                                + "\nFor protocol versions 763 (1.20.1) and earlier, see PacketType.Login.LOGIN_SUCCESS.";
                    }

                }
            }

            case PacketType.Play play -> {
                switch (play) {
                    case ACKNOWLEDGE_BLOCK_CHANGE -> {
                        return "Likely exists as a replacement for ACKNOWLEDGE_PLAYER_DIGGING, although the packet structure is completely different.";
                    }
                    case ACKNOWLEDGE_PLAYER_DIGGING -> {
                        return "Appears ACKNOWLEDGE_BLOCK_CHANGE serves as a replacement for this packet type in newer versions.";
                    }
                    case ADD_RESOURCE_PACK -> {
                        return "Also referred to as \"Resource Pack Send\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case AWARD_STATISTICS -> {
                        return "Also referred to as \"Statistics\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case BLOCK_ACTION -> {
                        return "NOTE: Packet structure changed from 1.13.x to 1.14.x." +
                                "\nThe position field is encoded as XYZ in 1.13.x and older, while it is encoded as XZY in 1.14.x+";
                    }
                    case BOSS_BAR -> {
                        return "TODO: note for implementing packet: The Enum fields Action, Color, & TypeOfDivision appear to be the same for all protocol versions. (when quickly comparing 1.12 to 1.21.8)";
                    }
                    case BLOCK_UPDATE -> {
                        return "Also referred to as \"Block Change\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case CHANGE_DIFFICULTY -> {
                        return "Also referred to as \"Server Difficulty\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case CHUNK_DATA -> {
                        return "Replaced by CHUNK_DATA_AND_UPDATE_LIGHT in newer versions";
                    }
                    case CHUNK_DATA_AND_UPDATE_LIGHT -> {
                        return "For older versions, see CHUNK_DATA instead.";
                    }
                    case CLOSE_CONTAINER -> {
                        return "Also referred to as \"Close Window (clientbound)\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case COMBAT_DEATH -> {
                        return "Also referred to as \"Death Combat Event\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case COMMANDS -> {
                        return "Also referred to as \"Declare Commands\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case COMMAND_SUGGESTIONS_RESPONSE -> {
                        return "Also referred to as \"Tab-Complete (clientbound)\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case CUSTOM_SOUND_EFFECT -> {
                        return "This packet's functionality was merged into SOUND_EFFECT in the next version." +
                                "\nlso referred to as \"Named Sound Effect\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case DELETE_MESSAGE -> {
                        return "Also known by the name \"Hide Message\" on the Minecraft wiki for 1.19.1/2 and prior.";
                    }
                    case DISPLAY_OBJECTIVE -> {
                        return "Related to the scoreboard." +
                                "\nAlso referred to as \"Display Scoreboard\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case END_COMBAT -> {
                        return "Also referred to as \"End Combat Event\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case ENTER_COMBAT -> {
                        return "Also referred to as \"Enter Combat Event\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case ENTITY_EFFECT -> {
                        return "For all potion/status effects." +
                                "\nSeems this is only for the client (player) to display effect durations, removing it has no effect on potion particles." +
                                "\nSet Entity Metadata packet might be responsible for those particles.";
                    }
                    case ENTITY_EVENT -> {
                        return "Also referred to as \"Entity Status\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case ENTITY_SOUND_EFFECT -> {
                        return "NOTE: Packet structure changed in protocol 761+ (1.19.3+) and again in protocol 767+ (1.21.0+)";
                    }
                    case EXPLOSION -> {
                        return "NOTE: Packet structure changed in protocol 773+ (1.21.9+).";
                    }
                    case FEATURE_FLAGS -> {
                        return "Replaced by Configuration.FEATURE_FLAGS in protocol version 764+ (1.20.2+)";
                    }
                    case LINK_ENTITIES -> {
                        return "Also referred to as \"Attach Entity\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case LOOK_AT -> {
                        return "Also referred to as \"Face\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case LOGIN -> {
                        return "Also referred to as \"Join Game\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case MERCHANT_OFFERS -> {
                        return "Also referred to as \"Trade List\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case OPEN_SCREEN -> {
                        return "Also referred to as \"Open Window\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case PARTICLE -> {
                        return "NOTE: Packet structure changed since protocol 769+ (1.21.4+). New field alwaysVisible." +
                                "\nNOTE: Packet structure changed since protocol 767+ (1.21.0+). Particle ID field moved to the end just before the Data field";
                    }
                    case PICKUP_ITEM -> {
                        return "Also referred to as \"Collect Item\" in versions before 1.19 on the Minecraft wiki." +
                                "\nThis packet is purely for the animation of an item being picked up by an entity.";
                    }
                    case PLAYER_INFO_UPDATE -> {
                        return "Also known by the name \"Player Info\" on the Minecraft wiki for 1.19.1/2 and prior.";
                    }
                    case PLAYER_ROTATION -> {
                        return "NOTE: Packet structure changed in protocol 773+ (1.21.9+).";
                    }
                    case PROJECTILE_POWER -> {
                        return "NOTE: Packet structure changed since protocol 767+ (1.21.0+). Power XYZ fields reduced to single Power field.";
                    }
                    case REMOVE_ENTITIES -> {
                        return "NOTE: Packet structure changed in protocol 756+ (1.17.1+)." +
                                "\nAlso referred to as \"Destroy Entities\" in versions 1.17.1 to 1.19 on the Minecraft wiki and \"Destroy Entity\" for 1.17 and prior.";
                    }
                    case REMOVE_ENTITY_EFFECT -> {
                        return "For all potion/status effects. Also see PacketType.Play.ENTITY_EFFECT";
                    }
                    case SERVER_DATA -> {
                        return "Used for server MOTD & Icon.";
                    }
                    case SET_ACTION_BAR_TEXT -> {
                        return "Also referred to as \"Action Bar\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_BLOCK_DESTROY_STAGE -> {
                        return "Also referred to as \"Block Break Animation\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_BORDER_CENTER -> {
                        return "Also referred to as \"World Border Center\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_BORDER_LERP_SIZE -> {
                        return "Also referred to as \"World Border Lerp Size\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_BORDER_SIZE -> {
                        return "Also referred to as \"World Border Size\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_BORDER_WARNING_DELAY -> {
                        return "Also referred to as \"World Border Warning Delay\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_BORDER_WARNING_DISTANCE -> {
                        return "Also referred to as \"World Border Warning Reach\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_CAMERA -> {
                        return "Also referred to as \"Camera\" in versions before 1.19 on the Minecraft wiki." +
                                "\nPacket used for setting the player to spectate an entity.";
                    }
                    case SET_CONTAINER_CONTENT -> {
                        return "Also referred to as \"Window Items\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_CONTAINER_PROPERTY -> {
                        return "Also referred to as \"Window Property\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_CONTAINER_SLOT -> {
                        return "Also referred to as \"Set Slot\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_DEFAULT_SPAWN_POSITION -> {
                        return "Also referred to as \"Spawn Position\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_ENTITY_METADATA -> {
                        return "Also referred to as \"Entity Metadata\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_ENTITY_VELOCITY -> {
                        return "Also referred to as \"Entity Velocity\" in versions before 1.19 on the Minecraft wiki." +
                                "NOTE: Packet structure changed in protocol 773+ (1.21.9+).";
                    }
                    case SET_EQUIPMENT -> {
                        return "Also referred to as \"Entity Equipment\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_HEAD_ROTATION -> {
                        return "Also referred to as \"Entity Head Look\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_HEALTH -> {
                        return "Also referred to as \"Update Health\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_HELD_ITEM -> {
                        return "Also referred to as \"Held Item Change (clientbound)\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_RENDER_DISTANCE -> {
                        return "Also referred to as \"Update View Distance\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_SIMULATION_DISTANCE -> {
                        return "Also referred to as \"Update Simulation Distance\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_SUBTITLE_TEXT -> {
                        return "Also referred to as \"Set Title SubTitle\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SET_TAB_LIST_HEADER_AND_FOOTER -> {
                        return "Also referred to as \"Player List Header And Footer\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case SOUND_EFFECT -> {
                        return "NOTE: Packet structure changed in protocol 761+ (1.19.3+)." +
                                "\nNOTE: Packet structure changed in protocol 767+ (1.21.0+).";
                    }
                    case SPAWN_ENTITY -> {
                        return "NOTE: Packet structure changed in protocol 759+ (1.19.0+)." +
                                "\nNOTE: Packet structure changed in protocol 773+ (1.21.9+).";
                    }
                    case START_CONFIGURATION -> {
                        return "Switches the protocol state to Configuration. Unsupported in protocol versions 763 (1.20.0/1) and older.";
                    }
                    case SYNCHRONIZE_PLAYER_POSITION -> {
                        return "Also referred to as \"Player Position And Look (clientbound)\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case TAG_QUERY_RESPONSE -> {
                        return "Also referred to as \"NBT Query Response\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case TELEPORT_ENTITY -> {
                        return "Also referred to as \"Entity Teleport\" in versions before 1.19 on the Minecraft wiki." +
                                "\nNOTE: Packet structure changed since protocol 768+ (1.21.2+). New fields for velocity and yaw/pitch.";
                    }
                    case UPDATE_ADVANCEMENTS -> {
                        return "Also referred to as \"Advancements\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case UPDATE_ATTRIBUTES -> {
                        return "Also referred to as \"Entity Properties\" in versions before 1.19 on the Minecraft wiki." +
                                "\nNOTE: A data field changed in 766+ (1.20.5).";
                    }
                    case UPDATE_ENTITY_POSITION -> {
                        return "Also referred to as \"Entity Position\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case UPDATE_ENTITY_POSITION_AND_ROTATION -> {
                        return "Also referred to as \"Entity Position and Rotation\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case UPDATE_ENTITY_ROTATION -> {
                        return "Also referred to as \"Entity Rotation\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case UPDATE_OBJECTIVES -> {
                        return "Related to the scoreboard." +
                                "\nAlso referred to as \"Scoreboard Objective\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case UPDATE_RECIPE_BOOK -> {
                        return "Also referred to as \"Unlock Recipes\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case UPDATE_RECIPES -> {
                        return "Also referred to as \"Declare Recipes\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case UPDATE_SECTION_BLOCKS -> {
                        return "Also referred to as \"Multi Block Change\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case UPDATE_SCORE -> {
                        return "Related to the scoreboard.";
                    }
                    case UPDATE_TAGS -> {
                        return "Also referred to as \"Tags\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case UPDATE_TEAMS -> {
                        return "Related to the scoreboard." +
                                "\nAlso referred to as \"Teams\" in versions before 1.19 on the Minecraft wiki.";
                    }
                    case UPDATE_TIME -> {
                        return "Also referred to as \"Time Update\" in versions before 1.19 on the Minecraft wiki." +
                                "\nNOTE: Packet structure changed since protocol 768+ (1.21.2+). New field timeAdvances (timeOfDayIncreasing)";
                    }
                    case WORLD_EVENT -> {
                        return "Also referred to as \"Effect\" in versions before 1.19 on the Minecraft wiki." +
                                "\nNOTE: Packet structure changed from 1.13.x to 1.14.x." +
                                "\nThe position field is encoded as XYZ in 1.13.x and older, while it is encoded as XZY in 1.14.x+";
                    }
                }
            }

            case EntityType entityType -> {
                switch (entityType) {
                    case ACACIA_BOAT,
                         BIRCH_BOAT,
                         CHERRY_BOAT,
                         DARK_OAK_BOAT,
                         JUNGLE_BOAT,
                         MANGROVE_BOAT,
                         OAK_BOAT,
                         PALE_OAK_BOAT,
                         SPRUCE_BOAT -> {
                        return "For older versions, see BOAT instead.";
                    }
                    case ACACIA_CHEST_BOAT,
                         CHERRY_CHEST_BOAT,
                         BIRCH_CHEST_BOAT,
                         DARK_OAK_CHEST_BOAT,
                         JUNGLE_CHEST_BOAT,
                         MANGROVE_CHEST_BOAT,
                         OAK_CHEST_BOAT,
                         PALE_OAK_CHEST_BOAT,
                         SPRUCE_CHEST_BOAT -> {
                        return "For older versions, see CHEST_BOAT instead.";
                    }
                    case BOAT -> {
                        return "Replaced by ACACIA_BOAT, BIRCH_BOAT, CHERRY_BOAT, DARK_OAK_BOAT, JUNGLE_BOAT, MANGROVE_BOAT, OAK_BOAT, PALE_OAK_BOAT, & SPRUCE_BOAT in newer versions";
                    }
                    case CHEST_BOAT -> {
                        return "Replaced by ACACIA_CHEST_BOAT, CHERRY_CHEST_BOAT, BIRCH_CHEST_BOAT, DARK_OAK_CHEST_BOAT, JUNGLE_CHEST_BOAT, MANGROVE_CHEST_BOAT, OAK_CHEST_BOAT, PALE_OAK_CHEST_BOAT, & SPRUCE_CHEST_BOAT in newer versions";
                    }

                    case LINGERING_POTION, SPLASH_POTION -> {
                        return "For older versions, see POTION instead.";
                    }
                    case POTION -> {
                        return "Replaced by LINGERING_POTION & SPLASH_POTION in newer versions";
                    }
                }
            }
            case BlockEntity blockEntity -> {
                return null;
            }
            case Block block -> {
                return null;
            }
            case Item item -> {
                return null;
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

        return null;
    }


    private static boolean isSupported(Protocol protocol, Enum<?> type) {
        switch (type) {
            case PacketType.Login login -> {
                return protocol.getLoginPacketID(login) != ProtocolMapper.UNDEFINED_ID;
            }
            case PacketType.Configuration configuration -> {
                return protocol.getConfigurationPacketID(configuration) != ProtocolMapper.UNDEFINED_ID;
            }
            case PacketType.Play play -> {
                return protocol.getPlayPacketID(play) != ProtocolMapper.UNDEFINED_ID;
            }
            case EntityType entityType -> {
                return protocol.getEntityTypeID(entityType) != ProtocolMapper.UNDEFINED_ID;
            }
            case BlockEntity blockEntity -> {
                return protocol.getBlockEntityID(blockEntity) != ProtocolMapper.UNDEFINED_ID;
            }
            case Block block -> {
                return protocol.getBlockID(block) != ProtocolMapper.UNDEFINED_ID;
            }
            case Item item -> {
                return protocol.getItemID(item) != ProtocolMapper.UNDEFINED_ID;
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    private static String getResource(Protocol protocol, Enum<?> type) {
        switch (type) {
            case PacketType.Login login -> {
                return protocol.getLoginResourceName(login);
            }
            case PacketType.Configuration configuration -> {
                return protocol.getConfigurationResourceName(configuration);
            }
            case PacketType.Play play -> {
                return protocol.getPlayResourceName(play);
            }
            case EntityType entityType -> {
                return protocol.getEntityTypeResourceName(entityType);
            }
            case BlockEntity blockEntity -> {
                return protocol.getBlockEntityResourceName(blockEntity);
            }
            case Block block -> {
                return protocol.getBlockResourceName(block);
            }
            case Item item -> {
                return protocol.getItemResourceName(item);
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    /**
     * Formats the enum type name.
     * Example: "PACKET_TYPE" would become "Packet Type"
     *
     * @param type The enum type.
     * @return Formated name string
     */
    private static String formatedName(Enum<?> type) {
        char[] characters = type.name().toCharArray();
        characters[0] = Character.toUpperCase(characters[0]);
        if (characters.length > 1) {
            boolean spacePreceding = false;
            for (int i = 1; i < characters.length; i++) {
                if (characters[i] == '_') {
                    characters[i] = ' ';
                    spacePreceding = true;
                    continue;
                }
                if (spacePreceding) {
                    characters[i] = Character.toUpperCase(characters[i]);
                    spacePreceding = false;
                } else {
                    characters[i] = Character.toLowerCase(characters[i]);
                }
            }
        }

        return new String(characters);
    }


    private static class SupportedRangeToken {

        public SupportedRangeToken(Protocol beginningProtocol, String resource) {
            this.beginningProtocol = beginningProtocol;
            this.endingProtocol = beginningProtocol;
            this.resource = resource;
        }

        private final Protocol beginningProtocol;
        private Protocol endingProtocol;
        private final String resource;

        public Protocol getBeginningProtocol() {
            return this.beginningProtocol;
        }

        public Protocol getEndingProtocol() {
            return this.endingProtocol;
        }

        public void setEndingProtocol(Protocol endingProtocol) {
            this.endingProtocol = endingProtocol;
        }

        public String getResource() {
            return this.resource;
        }

        public boolean matchesResource(String otherResource) {
            return this.resource.equals(otherResource);
        }
    }


    private static enum PrefixType {
        SUPPORTED_PROTOCOLS,
        RESOURCE;
    }

}
