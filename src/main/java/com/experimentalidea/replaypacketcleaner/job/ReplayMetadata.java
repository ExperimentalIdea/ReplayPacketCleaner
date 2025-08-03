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

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReplayMetadata {

    public ReplayMetadata(String jsonString) {
        this(new JSONObject(jsonString));
    }

    public ReplayMetadata(JSONObject jsonObject) {
        this.metadataJson = jsonObject;
        if (!this.metadataJson.keySet().contains(ReplayMetadata.KEY_FILE_FORMAT_VERSION)) {
            throw new IllegalStateException("The provided JSONObject is not a valid representation of a replay file's \"metaData.json\"");
        }
    }

    /**
     * The provided input stream is closed upon return of the ReplayMetadata object.
     */
    public static ReplayMetadata fromInputSteam(InputStream inputStream) throws IOException {
        StringBuilder builder = null;
        try (inputStream) { // note: try with resource will always call .close() at the end of the try block.
            builder = new StringBuilder(inputStream.available());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
        return new ReplayMetadata(builder.toString());
    }

    /**
     * The file name for the metadata json file inside the replay archive.
     */
    public static final String METADATA_FILE_NAME = "metaData.json";

    /**
     * Key corresponding to the entry "singleplayer" within the metaData.json file.
     * Value type Boolean.
     */
    public static final String KEY_SINGLEPLAYER = "singleplayer";

    /**
     * Key corresponding to the entry "serverName" within the metaData.json file.
     * Value type String.
     */
    public static final String KEY_SERVER_NAME = "serverName";

    /**
     * Key corresponding to the entry "customServerName" within the metaData.json file.
     * Value type String.
     */
    public static final String KEY_CUSTOM_SERVER_NAME = "customServerName";

    /**
     * Key corresponding to the entry "duration" within the metaData.json file.
     * Value type (assumed) Integer.
     * Value is for the duration of the replay in milliseconds.
     * <br><br>
     * According to a ReplayMod developer in <a href="https://www.replaymod.com/forum/thread/2781">2019</a>,
     * the theoretical limit for the duration of a replay file is around 31 days (~744hrs).
     * However, the 32-bit integer limit would place the maximum duration value at around 19 days (~596hrs),
     * beyond which it would overflow into the negatived.
     * <br><br>
     * Given the timestamp value for each packet within the replay is also stored as a 32-bit integer
     * representing time in milliseconds, I believe this is likely only ever treated as a 32-bit value as well.
     * As such, the true limit for a replay file is probably about 19 days (~596hrs) too.
     */
    public static final String KEY_DURATION = "duration";

    /**
     * Key corresponding to the entry "date" within the metaData.json file.
     * Value type Long.
     * Value represents the total number of milliseconds since January 1st, 1970.
     * As such, it can be divided by 1000 to give the unix timestamp of when the replay file was created.
     */
    public static final String KEY_DATE = "date";

    /**
     * Key corresponding to the entry "mcversion" within the metaData.json file.
     * Value type String.
     */
    public static final String KEY_MC_VERSION = "mcversion";

    /**
     * Key corresponding to the entry "fileFormat" within the metaData.json file.
     * Value type String.
     * Expected value should be "MCPR".
     */
    public static final String KEY_FILE_FORMAT = "fileFormat";

    /**
     * Key corresponding to the entry "fileFormatVersion" within the metaData.json file.
     * Value type Integer.
     */
    public static final String KEY_FILE_FORMAT_VERSION = "fileFormatVersion";

    /**
     * Key corresponding to the entry "protocol" within the metaData.json file.
     * Value type Integer.
     */
    public static final String KEY_PROTOCOL = "protocol";

    /**
     * Key corresponding to the entry "generator" within the metaData.json file.
     * Value type String.
     */
    public static final String KEY_GENERATOR = "generator";

    /**
     * Key corresponding to the entry ""selfId"" within the metaData.json file.
     * Value type (assumed) Integer.
     */
    public static final String KEY_SELF_ID = "selfId";

    /**
     * Key corresponding to the entry "players" within the metaData.json file.
     * Value type String[].
     * Each value in the array is a representation of a player's UUID.
     */
    public static final String KEY_PLAYERS = "players";


    private final JSONObject metadataJson;

    public JSONObject getMetadataJson() {
        return this.metadataJson;
    }


}
