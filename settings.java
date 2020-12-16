/*
 * Copyright (C) 2020 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.device;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SliderSettingsActivity extends PreferenceActivity implements onSharedPreferenceChangeListener {

    private static final String TAG_SLIDER = "slider";

    public SwitchPreference sliderPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.slider_settings);

        sliderPref = (SwitchPreference) findPreference("slider_enable"); //Preference Key


        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new SliderSettingsFragment(), TAG_SLIDER).commit();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("slider_enable")) {
            boolean slider = sharedPreferences.getBoolean("slider_enable", false);
            //Do whatever you want here. This is an example.
            if (slider) {
                sliderPref.setSummary("Enabled");
            } else {
                sliderPref.setSummary("Disabled");
            }
        }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(TestPrefActivity.this);
        boolean slider = preferences.getBoolean("slider_enable", false);

        if (slider) {
            sliderPref.setSummary("Enabled");
        } else {
            sliderPref.setSummary("Disabled");
        }
    }
}