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

public class Main {


    public static void main(String[] args) {

        try {

            System.out.println("Starting application...");

            ReplayPacketCleaner instance = ReplayPacketCleaner.createInstance();

            // TODO: create and set logger

            instance.createMainWindow(true);

            System.out.println("Ready. Awaiting jobs...");

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

