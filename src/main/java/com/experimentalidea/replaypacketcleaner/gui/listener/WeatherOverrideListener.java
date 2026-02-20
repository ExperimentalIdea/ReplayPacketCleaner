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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class WeatherOverrideListener implements ActionListener, ChangeListener {


    public WeatherOverrideListener(Configuration<Option> profile, JComboBox overrideWeatherDropdown, JCheckBox removeLightingStrikesCheckbox,
                                   JSlider rainLevelSlider, JLabel rainLevelSliderLabel, JLabel rainLevelSliderValueDisplay,
                                   JSlider thunderLevelSlider, JLabel thunderLevelSliderLabel, JLabel thunderLevelSliderValueDisplay) {
        Objects.requireNonNull(profile, "profile cannot be null");
        Objects.requireNonNull(overrideWeatherDropdown, "overrideWeatherDropdown cannot be null");
        Objects.requireNonNull(removeLightingStrikesCheckbox, "removeLightingStrikesCheckbox cannot be null");
        Objects.requireNonNull(rainLevelSlider, "rainLevelSlider cannot be null");
        Objects.requireNonNull(rainLevelSliderLabel, "rainLevelSliderLabel cannot be null");
        Objects.requireNonNull(rainLevelSliderValueDisplay, "rainLevelSliderValueDisplay cannot be null");
        Objects.requireNonNull(thunderLevelSlider, "thunderLevelSlider cannot be null");
        Objects.requireNonNull(thunderLevelSliderLabel, "thunderLevelSliderLabel cannot be null");
        Objects.requireNonNull(thunderLevelSliderValueDisplay, "thunderLevelSliderValueDisplay cannot be null");

        this.profile = profile;
        this.overrideWeatherDropdown = overrideWeatherDropdown;
        this.removeLightingStrikesCheckbox = removeLightingStrikesCheckbox;
        this.rainLevelSlider = rainLevelSlider;
        this.rainLevelSliderLabel = rainLevelSliderLabel;
        this.rainLevelSliderValueDisplay = rainLevelSliderValueDisplay;
        this.thunderLevelSlider = thunderLevelSlider;
        this.thunderLevelSliderLabel = thunderLevelSliderLabel;
        this.thunderLevelSliderValueDisplay = thunderLevelSliderValueDisplay;
    }

    private static final int DROPDOWN_DO_NOT_OVERRIDE = 0;
    private static final int DROPDOWN_CLEAR = 1;
    private static final int DROPDOWN_RAINY = 2;

    private final Configuration<Option> profile;
    private final JComboBox overrideWeatherDropdown;

    private final JCheckBox removeLightingStrikesCheckbox;

    private final JSlider rainLevelSlider;
    private final JLabel rainLevelSliderLabel;
    private final JLabel rainLevelSliderValueDisplay;

    private final JSlider thunderLevelSlider;
    private final JLabel thunderLevelSliderLabel;
    private final JLabel thunderLevelSliderValueDisplay;


    // Monitor the dropdown box and the checkbox
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int dropdownIndex = this.overrideWeatherDropdown.getSelectedIndex();
        switch (dropdownIndex) {
            case DROPDOWN_DO_NOT_OVERRIDE -> {
                // Update GUI
                this.removeLightingStrikesCheckbox.setEnabled(false);
                this.setSlidersEnabled(false);

                // Update Profile
                this.profile.set(Option.WEATHER_OVERRIDE, false);

                // Behind the scenes I want to check if options set differ from the default (or future saved) profile.
                // So restore the weather options in the configuration profile to default values to ensure easy comparison when 'Do not override' is selected.
                // (don't care about updating the UI to reflect the internal slider / remove lighting values in this case)
                this.profile.reset(Option.WEATHER_IS_RAINING);
                this.profile.reset(Option.WEATHER_RAIN_LEVEL);
                this.profile.reset(Option.WEATHER_THUNDER_LEVEL);
                this.profile.reset(Option.WEATHER_REMOVE_LIGHTING_STRIKES);
            }
            case DROPDOWN_CLEAR -> {
                // Update GUI
                this.removeLightingStrikesCheckbox.setEnabled(true);
                this.setSlidersEnabled(false);

                // Update Profile
                this.profile.set(Option.WEATHER_OVERRIDE, true);

                this.profile.set(Option.WEATHER_IS_RAINING, false);
                this.profile.reset(Option.WEATHER_RAIN_LEVEL);
                this.profile.reset(Option.WEATHER_THUNDER_LEVEL);
                this.profile.set(Option.WEATHER_REMOVE_LIGHTING_STRIKES, this.removeLightingStrikesCheckbox.isSelected());
            }
            case DROPDOWN_RAINY -> {
                // Update GUI
                this.removeLightingStrikesCheckbox.setEnabled(true);
                this.setSlidersEnabled(true);

                // Update Profile
                this.profile.set(Option.WEATHER_OVERRIDE, true);

                this.profile.set(Option.WEATHER_IS_RAINING, true);
                this.profile.set(Option.WEATHER_RAIN_LEVEL, this.calculateSliderValue(this.rainLevelSlider));
                this.profile.set(Option.WEATHER_THUNDER_LEVEL, this.calculateSliderValue(this.thunderLevelSlider));
                this.profile.set(Option.WEATHER_REMOVE_LIGHTING_STRIKES, this.removeLightingStrikesCheckbox.isSelected());
            }
            default -> {
                // should never happen.
                throw new IllegalStateException("Unexpected weather override dropdown index: " + dropdownIndex);
            }
        }


    }

    // Monitor sliders
    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        // This should always be true when this event triggers...
        if (this.overrideWeatherDropdown.getSelectedIndex() == WeatherOverrideListener.DROPDOWN_RAINY) {
            float rainLevel = this.calculateSliderValue(this.rainLevelSlider);
            float thunderLevel = this.calculateSliderValue(this.thunderLevelSlider);

            this.rainLevelSliderValueDisplay.setText(String.valueOf(rainLevel));
            this.thunderLevelSliderValueDisplay.setText(String.valueOf(thunderLevel));

            this.profile.set(Option.WEATHER_RAIN_LEVEL, rainLevel);
            this.profile.set(Option.WEATHER_THUNDER_LEVEL, thunderLevel);
        }
    }

    private void setSlidersEnabled(boolean enabled) {
        this.rainLevelSlider.setEnabled(enabled);
        this.rainLevelSliderLabel.setEnabled(enabled);
        this.rainLevelSliderValueDisplay.setEnabled(enabled);
        this.thunderLevelSlider.setEnabled(enabled);
        this.thunderLevelSliderLabel.setEnabled(enabled);
        this.thunderLevelSliderValueDisplay.setEnabled(enabled);
    }

    /// Returns a value from 0.0 to 1.0
    private float calculateSliderValue(JSlider slider) {
        return (float) slider.getValue() / (float) slider.getMaximum();
    }

}
