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
package com.experimentalidea.replaypacketcleaner.job;

import com.experimentalidea.replaypacketcleaner.ReplayPacketCleaner;
import com.experimentalidea.replaypacketcleaner.config.Configuration;
import com.experimentalidea.replaypacketcleaner.config.Option;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

/**
 * Used to represent a source replay file that can be submitted for editing.
 */
public class Replay {

//    /**
//     * Represent a source replay file that can be submitted for editing.
//     *
//     * @param uuid       A unique identifier used to identify this unique instance. This UUID is also used when submitted as a job for creating a unique temporary working folder for the job itself.
//     * @param name       The name of this replay. (File name without the .mcpr extension)
//     * @param sourceFile The source replay .mcpr archive file.
//     * @throws NullPointerException     If any value is null.
//     * @throws IllegalArgumentException If sourceFile's name doesn't end with the .mcpr file extension.
//     */
//    public Replay(UUID uuid, String name, File sourceFile) {
//        Objects.requireNonNull(uuid, "uuid cannot be null");
//        Objects.requireNonNull(name, "name cannot be null");
//        Objects.requireNonNull(sourceFile, "sourceFile cannot be null");
//        if (!sourceFile.getName().toLowerCase().endsWith(ReplayPacketCleaner.DOT_MCPR_EXTENSION)) {
//            throw new IllegalArgumentException("sourceFile's name doesn't end with .mcpr file extension");
//        }
//
//        this.uuid = uuid;
//        this.sourceFile = sourceFile;
//        this.name = name;
//    }

    /**
     * Represent a source replay file that can be submitted for editing.
     * Before submitting this replay for editing, the Export Directory and Configuration must be set via the corresponding set methods.
     *
     * @param sourceFile The source replay .mcpr archive file.
     * @throws NullPointerException     If sourceFile is null.
     * @throws IllegalArgumentException If sourceFile's name doesn't end with the .mcpr file extension.
     */
    public Replay(File sourceFile) {
        Objects.requireNonNull(sourceFile, "sourceFile cannot be null");
        if (!sourceFile.getName().toLowerCase().endsWith(ReplayPacketCleaner.DOT_MCPR_EXTENSION)) {
            throw new IllegalArgumentException("sourceFile's name doesn't end with .mcpr file extension");
        }

        this.uuid = UUID.randomUUID();
        this.name = sourceFile.getName().replaceAll(ReplayPacketCleaner.DOT_MCPR_EXTENSION, "");
        this.sourceFile = sourceFile;

    }


    private final UUID uuid;
    private final File sourceFile;
    private final String name;

    private File exportDirectory = null;
    private Configuration<Option> configuration = null;

    /**
     * Get the UUID associated with this Replay object.
     * The UID used to identify this unique instance. This UUID is also used when submitted as a job for creating a unique temporary working folder for the job itself.
     *
     * @return The UUID.
     */
    public UUID getUUID() {
        return this.uuid;
    }

    /**
     * Get the Name associated with this Replay object.
     *
     * @return The name. (Source File name without the .mcpr extension)
     */
    public File getSourceFile() {
        return this.sourceFile;
    }

    /**
     * Get the Name associated with this Replay object.
     *
     * @return The name. (Source File name without the .mcpr extension)
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the Export Directory set for with this replay.
     *
     * @return The export directory. Or null if the export directory hasn't been set yet.
     */
    public File getExportDirectory() {
        return this.exportDirectory;
    }

    /**
     * Set the Export Directory set for with this replay.
     * Setting the export directory (and the configuration) is required before submitting this replay for editing.
     *
     * @param exportDirectory The directory where this edited version of this replay should be saved.
     */
    public void setExportDirectory(File exportDirectory) {
        this.exportDirectory = exportDirectory;
    }

    /**
     * Get the Configuration profile set for with this replay.
     *
     * @return The Configuration profile. Or null if the configuration profile hasn't been set yet.
     */
    public Configuration<Option> getConfiguration() {
        return this.configuration;
    }

    /**
     * Set the Configuration profile set for with this replay.
     * Setting the configuration profile (and the export directory) is required before submitting this replay for editing.
     *
     * @param configuration The configuration detailing how this replay should be edited.
     */
    public void setConfiguration(Configuration<Option> configuration) {
        this.configuration = configuration;
    }

}
