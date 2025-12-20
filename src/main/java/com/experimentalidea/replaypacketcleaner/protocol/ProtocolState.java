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

/**
 * Representation of all protocol connection states relevant to Replay Packet Cleaner.
 *
 * @see ProtocolDirectory
 * @see Protocol
 * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Login
 * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Configuration
 * @see com.experimentalidea.replaypacketcleaner.protocol.PacketType.Play
 * */
public enum ProtocolState {

    /**
     * The Configuration connection state.
     * Replays recorded in protocol version 764 (1.20.2) and newer begin in this protocol state.
     * <br><br>
     * After hitting PacketType.Configuration.FINISH_CONFIGURATION, the protocol switches the state to PLAY.
     * */
    CONFIGURATION,

    /**
     * The Login connection state.
     * Replays recorded in protocol version 763 (1.20.1) and older begin in this protocol state.
     * <br><br>
     * After PacketType.Login.LOGIN_SUCCESS, the protocol switches the state to PLAY.
     * */
    LOGIN,

    /**
     * The Play connection state.
     * This is the phase where RPC will monitor, alter, and delete packets from a replay.
     * <br><br>
     * Replays recorded in protocol versions 764 (1.20.2) and newer can switch the protocol state
     * from PLAY to CONFIGURATION upon hitting PacketType.Play.START_CONFIGURATION.
     * */
    PLAY

}
