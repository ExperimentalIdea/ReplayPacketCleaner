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
package com.experimentalidea.replaypacketcleaner.job.listener;

import com.experimentalidea.replaypacketcleaner.packet.listener.UpdateTimePacketListener;
import com.experimentalidea.replaypacketcleaner.packet.UpdateTimePacket;

public class TimeChanger implements UpdateTimePacketListener {

    /**
     * Creates a {@link UpdateTimePacketListener} that fixes the daylight cycle to a desired time.
     * @param timeOfDay The time of day in ticks ranging from 0 to 24000. A value outside this range will be rounded to the top or bottom of this range.
     */
    public TimeChanger(long timeOfDay) {
        if (timeOfDay < 0) {
            timeOfDay = 0;
        }
        if (timeOfDay > 24000) {
            timeOfDay = 24000;
        }
        this.timeOfDay = timeOfDay;
    }

    private final long timeOfDay;


    @Override
    public void onUpdateTimePacket(UpdateTimePacket updateTimePacket) {
        updateTimePacket.setTimeOfDay(this.timeOfDay);
        updateTimePacket.setTimeAdvance(false);
    }

}
