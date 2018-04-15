package androidappteam.com.universityexchange.fragments;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import androidappteam.com.universityexchange.R;

/**
 * Created by Matej on 15/04/2018.
 */

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preference_screen);
    }
}
