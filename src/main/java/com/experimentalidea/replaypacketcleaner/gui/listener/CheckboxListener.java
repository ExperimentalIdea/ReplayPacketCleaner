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

import com.experimentalidea.replaypacketcleaner.config.Configuration;
import com.experimentalidea.replaypacketcleaner.config.Option;
import com.experimentalidea.replaypacketcleaner.config.ValueType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckboxListener implements ActionListener {

    /**
     * Updates a boolean value within the configuration profile to match checkbox.isSelected() whenever this listener triggers.
     */
    public CheckboxListener(Configuration<Option> profile, Option key, JCheckBox checkbox) {
        if (profile == null) {
            throw new IllegalArgumentException("profile cannot be null");
        }
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        if (checkbox == null) {
            throw new IllegalArgumentException("checkbox cannot be null");
        }
        if (key.getMetadata().getValueType() != ValueType.BOOLEAN) {
            throw new IllegalArgumentException("key is not applicable to value type boolean");
        }

        this.profile = profile;
        this.key = key;
        this.checkBox = checkbox;
    }

    private final Configuration<Option> profile;
    private final Option key;
    private final JCheckBox checkBox;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.profile.set(this.key, this.checkBox.isSelected());
    }

}
