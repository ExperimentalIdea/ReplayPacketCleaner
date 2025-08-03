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

import com.experimentalidea.replaypacketcleaner.config.Configuration;
import com.experimentalidea.replaypacketcleaner.config.Option;

import java.io.File;
import java.util.UUID;

/// Represents information about a given job.
public class Job {

    public Job(UUID uuid, Configuration<Option> profile, File sourceFile, File targetDirectory) {
        if (uuid == null) {
            throw new IllegalArgumentException("uuid cannot be null");
        }
        if (profile == null) {
            throw new IllegalArgumentException("profile cannot be null");
        }
        if (sourceFile == null) {
            throw new IllegalArgumentException("sourceFile cannot be null");
        }
        if (targetDirectory == null) {
            throw new IllegalArgumentException("targetDirectory cannot be null");
        }

        this.uuid = uuid;
        this.profile = profile;
        this.sourceFile = sourceFile;
        this.targetDirectory = targetDirectory;
    }


    private final UUID uuid;
    private final Configuration<Option> profile;
    private final File sourceFile;
    private final File targetDirectory;


    public UUID getUUID() {
        return uuid;
    }

    public Configuration<Option> getProfile() {
        return profile;
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public File getTargetDirectory() {
        return targetDirectory;
    }


}
