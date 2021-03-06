/*
 * Copyright (C) 2018 The LineageOS Project
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

 import android.content.Context;
 import android.content.SharedPreferences;
 import android.os.Bundle;
 import android.view.MenuItem;
 import androidx.preference.Preference;
 import androidx.preference.PreferenceFragment;
 import androidx.preference.PreferenceManager;
 import androidx.preference.SwitchPreference;

 import org.lineageos.settings.R;

 public class SliderSettingsFragment extends PreferenceFragment implements
         Preference.OnPreferenceChangeListener {

     private SwitchPreference mSliderPreference;

     @Override
     public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
         addPreferencesFromResource(R.xml.slider_settings);
         getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
         mSliderPreference = (SwitchPreference) findPreference("slider_enable");
         mSliderPreference.setEnabled(true);
         mSliderPreference.setOnPreferenceChangeListener(this);
     }

     @Override
     public boolean onPreferenceChange(Preference preference, Object newValue) {
         if ("slider_enable".equals(preference.getKey())) {
             SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SliderSettingsActivity.getAppContext());
             boolean slider = sharedPreferences.getBoolean("slider_enable", false);
             if (slider) {
                 mSliderPreference.setEnabled(true);
             } else {
                 mSliderPreference.setEnabled(false);
             }
         }
         return true;
     }
     
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().onBackPressed();
            return true;
        }
        return false;
    }
}