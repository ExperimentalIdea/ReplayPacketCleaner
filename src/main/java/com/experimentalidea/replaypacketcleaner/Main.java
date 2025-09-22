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

import com.experimentalidea.replaypacketcleaner.protocol.ProtocolDirectory;

import java.io.File;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReader;
import java.lang.module.ResolvedModule;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Main {

    /// Show additional options in the GUI. For now, this shows options for to loading custom protocols and running the protocol file generation assistant.
    private static String FLAG_SHOW_HIDDEN_OPTIONS = "--showHiddenOptions"; // Show the options in the GUI to load custom protocols or run the protocol file generation assistant.

    public static void main(String[] args) {

        try {

            System.out.println("Starting application...");

            long startTime = System.currentTimeMillis();

            boolean showHiddenOptions = false;
            for (String entry : args) {
                if (entry.equalsIgnoreCase(Main.FLAG_SHOW_HIDDEN_OPTIONS)) {
                    showHiddenOptions = true;
                    System.out.println("Detected flag: " + Main.FLAG_SHOW_HIDDEN_OPTIONS + "\nAdditional options will be shown in the GUI!");
                    break;
                }
            }

            ReplayPacketCleaner instance = ReplayPacketCleaner.createInstance();

            // TODO: create and set logger

            instance.createMainWindow(true, showHiddenOptions);

            System.out.println("Ready in " + (System.currentTimeMillis() - startTime) + "ms. Awaiting jobs...");

            instance.processJobsAndAwaitTermination(); // Returns when the application window has closed, and any in progress jobs have been cleaned up.

            System.out.println("Application has closed.");

        } catch (Exception exception) {
            // TODO: log exception & shutdown
            throw new RuntimeException(exception);
        }
    }


    // System.getProperty("java.io.tmpdir"); // get the temp file directory
    // System.getProperty("user.home"); // Get the user home folder (linux/unix only I think...)
    // System.getenv("APPDATA"); // Get the Windows App data folder
    // System.getProperty("os.name"); // Get the OS name

}

