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
package com.experimentalidea.replaypacketcleaner.gui.listener;

import com.experimentalidea.replaypacketcleaner.ReplayPacketCleaner;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Objects;

public class CloseApplicationWindowListener implements WindowListener {

    public CloseApplicationWindowListener(ReplayPacketCleaner instance, Timer... timers) {
        Objects.requireNonNull(instance, "instance cannot be null");
        Objects.requireNonNull(timers, "timers cannot be null");

        this.replayPacketCleanerInstance = instance;
        this.timers = timers;
    }


    private final ReplayPacketCleaner replayPacketCleanerInstance;
    private final Timer[] timers;


    @Override
    public void windowOpened(WindowEvent windowEvent) {
        // do nothing
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        // do nothing
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
        // Interrupt the thread that waits on new jobs to be added to the job queue.
        // If this isn't done, the application would never terminate.
        this.replayPacketCleanerInstance.interruptMainThread();

        // The repeating task on the UI thread would also prevent the application from terminating. Stop it here.
        for (Timer timer : timers) {
            timer.stop();
        }
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {
        // do nothing
    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {
        // do nothing
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
        // do nothing
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
        // do nothing
    }

}
