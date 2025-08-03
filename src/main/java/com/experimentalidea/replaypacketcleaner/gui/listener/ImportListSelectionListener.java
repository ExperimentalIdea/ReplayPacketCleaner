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

import com.experimentalidea.replaypacketcleaner.gui.ReplayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This listener is purely for enabling and disabling buttons base on if the list has elements and/or those elements are currently selected.
 */
public class ImportListSelectionListener implements ListSelectionListener {

    public ImportListSelectionListener(ReplayList replayImportList) {
        this.replayImportList = replayImportList;
    }

    private final ReplayList replayImportList;


    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        // To prevent the button from flicking, only act when the value isn't being adjusted.
        if(!listSelectionEvent.getValueIsAdjusting()) {
            this.replayImportList.getUIUpdater().updateUI();
        }
    }

}
