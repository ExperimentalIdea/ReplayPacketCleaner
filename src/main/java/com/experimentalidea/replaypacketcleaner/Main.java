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
package com.experimentalidea.replaypacketcleaner;

import com.experimentalidea.replaypacketcleaner.protocol.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    /// Show additional options in the GUI. For now, this shows options for to loading custom protocols and running the protocol file generation assistant.
    private static String FLAG_SHOW_HIDDEN_OPTIONS = "--showHiddenOptions"; // Show the options in the GUI to load custom protocols or run the protocol file generation assistant.

    /// Disables the use of a separate thread for reading in a replay file. Using this flag will likely result in worse performance.
    private static String FLAG_DISABLE_ASYNC_READS = "--disableAsyncReads";

    /// Disables the use of a separate thread for writing out a replay file. Using this flag will likely result in worse performance.
    private static String FLAG_DISABLE_ASYNC_WRITES = "--disableAsyncWrites";

    /// Write out all protocol enum type documentation to a directory. Intended to aid in development of RPC. Usage --outputTypeDocumentation="/path/to/the directory".
    private static String FLAG_OUTPUT_TYPE_DOCUMENTATION = "--outputTypeDocumentation";


    public static void main(String[] args) {

        try {

            System.out.println("Starting application...");

            long startTime = System.currentTimeMillis();

            boolean showHiddenOptions = false;
            boolean disableAsyncReads = false;
            boolean disableAsyncWrites = false;
            boolean outputTypeDocumentation = false;
            File outputTypeDocumentationTargetDir = null;

            Iterator<String> argsIter = Arrays.stream(args).iterator();
            while (argsIter.hasNext()) {
                String entry = argsIter.next();
                if (entry.equalsIgnoreCase(Main.FLAG_SHOW_HIDDEN_OPTIONS) && !showHiddenOptions) {
                    showHiddenOptions = true;
                    System.out.println("Detected flag: " + Main.FLAG_SHOW_HIDDEN_OPTIONS + "\n  Additional options will be shown in the GUI!");
                } else if (entry.equalsIgnoreCase(Main.FLAG_DISABLE_ASYNC_READS) && !disableAsyncReads) {
                    disableAsyncReads = true;
                    System.out.println("Detected flag: " + Main.FLAG_DISABLE_ASYNC_READS + "\n  A separate thread from the job thread won't be used for reading in data.");
                } else if (entry.equalsIgnoreCase(Main.FLAG_DISABLE_ASYNC_WRITES) && !disableAsyncWrites) {
                    disableAsyncWrites = true;
                    System.out.println("Detected flag: " + Main.FLAG_DISABLE_ASYNC_WRITES + "\n  A separate thread from the job thread won't be used for writing out data.");
                } else if (entry.toLowerCase().startsWith(Main.FLAG_OUTPUT_TYPE_DOCUMENTATION.toLowerCase()) && !outputTypeDocumentation) {
                    outputTypeDocumentation = true;
                    System.out.println("Detected flag: " + Main.FLAG_OUTPUT_TYPE_DOCUMENTATION + "\n  Will attempt to output documentation for updating all protocol enum types.");
                    int index = entry.indexOf('=');
                    if (index == -1) {
                        System.out.println("Error: Missing file path to write out documentation." + "\n  Expected " + Main.FLAG_OUTPUT_TYPE_DOCUMENTATION + "=\"" + File.separator + "path" + File.separator + "to" + File.separator + "dir\"");
                        outputTypeDocumentation = false;
                    } else {
                        outputTypeDocumentationTargetDir = new File(Main.parseMultiArgValue(entry.substring(index + 1), argsIter));
                        if (!outputTypeDocumentationTargetDir.exists()) {
                            System.out.println(Main.FLAG_OUTPUT_TYPE_DOCUMENTATION + ": Error: File path \"" + outputTypeDocumentationTargetDir.getPath() + "\" does not exist.");
                            outputTypeDocumentation = false;
                        } else if (!outputTypeDocumentationTargetDir.isDirectory()) {
                            System.out.println(Main.FLAG_OUTPUT_TYPE_DOCUMENTATION + ": Error: File path \"" + outputTypeDocumentationTargetDir.getPath() + "\" is not a directory.");
                        }
                    }
                }
            }

            ReplayPacketCleaner instance = ReplayPacketCleaner.createInstance(!disableAsyncReads, !disableAsyncWrites);

            // TODO: create and set logger

            if (outputTypeDocumentation) {
                File childDirectory = Main.saveTypeDocumentation(instance.getProtocolDirectory(), outputTypeDocumentationTargetDir);
                System.out.println(Main.FLAG_OUTPUT_TYPE_DOCUMENTATION + ": Documentation saved to " + childDirectory.getPath());
            }

            instance.createMainWindow(true, showHiddenOptions);

            System.out.println("Ready in " + (System.currentTimeMillis() - startTime) + "ms. Awaiting jobs...");

            instance.processJobsAndAwaitTermination(); // Returns when the application window has closed, and any in progress jobs have been cleaned up.

            System.out.println("Application has closed.");

        } catch (
                Exception exception) {
            // TODO: log exception & shutdown
            throw new RuntimeException(exception);
        }
    }


    /// Parse a multi arg value that starts and ends with quotation marks.
    private static String parseMultiArgValue(String firstArg, Iterator<String> argsIter) {
        // If the first character is not ", then this value is contained all within a single arg.
        if (!firstArg.startsWith("\"")) {
            return firstArg;
        }

        // If the first & last character is a ", then this value is contained all within a single arg.
        if (firstArg.endsWith("\"")) {
            return firstArg.substring(1, firstArg.length() - 1);
        }

        // Trim the first character (") from the firstArg.
        StringBuilder builder = new StringBuilder(firstArg.substring(1));
        while (argsIter.hasNext()) {
            String value = argsIter.next();
            builder.append(' ');

            // When we reach an arg ending in ", we know we've reached the end of this multi arg value.
            if (value.endsWith("\"")) {
                builder.append(value, 0, value.length() - 1);
                break;
            }

            builder.append(value);
        }
        return builder.toString();
    }

    /// Generate and write out all protocol enum type documentation to the given directory.
    /// Returns the child directory (within the target directory) that contains all saved text files.
    private static File saveTypeDocumentation(ProtocolDirectory protocolDirectory, File targetDir) throws IOException {
        List<Integer> protocolVersions = protocolDirectory.getSupportedProtocolVersions();
        int first = protocolVersions.getFirst();
        int last = protocolVersions.getLast();

        String childDirectoryName = "RPC_" + first + '_' + last;
        File childDirectory = new File(targetDir, childDirectoryName);
        int tries = 0;
        while (childDirectory.exists()) {
            tries++;
            childDirectory = new File(targetDir, childDirectoryName + "_(" + tries + ")");
        }
        childDirectory.mkdir();

        Files.writeString(new File(childDirectory, "PacketType-Login.txt").toPath(), DocumentationGenerator.generateTypeDocumentation(protocolDirectory, PacketType.Login.values()));
        Files.writeString(new File(childDirectory, "PacketType-Configuration.txt").toPath(), DocumentationGenerator.generateTypeDocumentation(protocolDirectory, PacketType.Configuration.values()));
        Files.writeString(new File(childDirectory, "PacketType-Play.txt").toPath(), DocumentationGenerator.generateTypeDocumentation(protocolDirectory, PacketType.Play.values()));
        Files.writeString(new File(childDirectory, "Block.txt").toPath(), DocumentationGenerator.generateTypeDocumentation(protocolDirectory, Block.values()));
        Files.writeString(new File(childDirectory, "BlockEntity.txt").toPath(), DocumentationGenerator.generateTypeDocumentation(protocolDirectory, BlockEntity.values()));
        Files.writeString(new File(childDirectory, "EntityType.txt").toPath(), DocumentationGenerator.generateTypeDocumentation(protocolDirectory, EntityType.values()));
        Files.writeString(new File(childDirectory, "Item.txt").toPath(), DocumentationGenerator.generateTypeDocumentation(protocolDirectory, EntityType.values()));

        return childDirectory;
    }


// System.getProperty("java.io.tmpdir"); // get the temp file directory
// System.getProperty("user.home"); // Get the user home folder (linux/unix only I think...)
// System.getenv("APPDATA"); // Get the Windows App data folder
// System.getProperty("os.name"); // Get the OS name

}

