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

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

public class TimeOverrideListener implements ActionListener, DocumentListener, Runnable, FocusListener {

    public TimeOverrideListener(Configuration<Option> profile, JCheckBox overrideTimeCheckbox, JTextField setTimeTextField, JLabel setTimeTipText) {
        if (profile == null) {
            throw new IllegalArgumentException("profile cannot be null");
        }
        if (overrideTimeCheckbox == null) {
            throw new IllegalArgumentException("checkbox cannot be null");
        }
        if (setTimeTextField == null) {
            throw new IllegalArgumentException("setTimeTextField cannot be null");
        }
        if (setTimeTipText == null) {
            throw new IllegalArgumentException("setTimeTipText cannot be null");
        }


        this.profile = profile;
        this.overrideTimeCheckbox = overrideTimeCheckbox;
        this.setTimeTextField = setTimeTextField;
        this.setTimeTipText = setTimeTipText;
    }

    private final Configuration<Option> profile;
    private final JCheckBox overrideTimeCheckbox;
    private final JTextField setTimeTextField;
    private final JLabel setTimeTipText;

    private int lastGoodValue = 0;


    // This is called when the user toggles the override checkbox or presses enter on the text field.
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean isSelected = this.overrideTimeCheckbox.isSelected();

        this.profile.set(Option.TIME_OVERRIDE, isSelected);
        this.setTimeTextField.setEnabled(isSelected);
        this.setTimeTipText.setEnabled(isSelected);

        if (this.setTimeTextField.getText().isBlank()) {
            // If the user backspaces the entire text field and hits enter, we'll set the text field to "0"
            this.setTimeTextField.setText(String.valueOf(0));
        }

        this.update();
    }


    // Monitor Changes to the text field
    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        SwingUtilities.invokeLater(this);
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        SwingUtilities.invokeLater(this);
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        SwingUtilities.invokeLater(this);
    }

    // Cannot update within a DocumentEvent or else an IllegalStateException is thrown, so the update is done as a task instead.
    @Override
    public void run() {
        this.update();
    }


    @Override
    public void focusGained(FocusEvent focusEvent) {
        // do nothing
    }

    // Ensure the text field
    @Override
    public void focusLost(FocusEvent focusEvent) {
        if (this.setTimeTextField.getText().isBlank()) {
            // If the user backspaces the entire text field and loses focus on the text field, we'll set the text field to "0".
            this.setTimeTextField.setText(String.valueOf(0));
        }
    }


    /// Updates the time set value in the configuration profile and corrects the UI if an invalid value was typed.
    private void update() {
        if (this.overrideTimeCheckbox.isSelected()) {
            int setTime = 0;

            // A blank text field is treated as "0".
            if (!this.setTimeTextField.getText().isBlank()) {
                try {
                    String textField = this.setTimeTextField.getText();

                    setTime = Integer.parseInt(textField);

                    // In case the user tried typing something like "0200" or "00500", remove the leading zero(s)
                    if (textField.startsWith("0") && textField.length() > 1) {
                        this.setTimeTextField.setText(String.valueOf(setTime));
                    }
                } catch (NumberFormatException exception) {
                    // This should never happen, but just in case.
                    this.setTimeTextField.setText(String.valueOf(this.lastGoodValue));
                }
            }

            if (setTime > 24000) {
                setTime = 24000;
                this.setTimeTextField.setText(String.valueOf(setTime));
            } else if (setTime < 0) {
                setTime = 0;
                this.setTimeTextField.setText(String.valueOf(setTime));
            }

            this.profile.set(Option.TIME_SET, setTime);
            this.lastGoodValue = setTime;

        } else {
            // Behind the scenes I want to check if options set differ from the default (or future saved) profile.
            // So restore the time set in the configuration profile to the default value to ensure easy comparison when override is unchecked.
            // (don't care about updating the UI to reflect the internal time set value in this case)
            this.profile.reset(Option.TIME_SET);
        }
    }

}
