package androidappteam.com.universityexchange.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.preference.PreferenceManager;

/**
 * Created by Matej on 15/04/2018.
 */

public class PreferenceHelper {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public PreferenceHelper initialize(Context context) {
        this.context = context;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return this;
    }

    public PreferenceHelper edit() {
        this.editor = sharedPreferences.edit();
        return this;
    }

    public String getPreference(String preferenceKey, String defaulValue) {
        return sharedPreferences.getString(preferenceKey, defaulValue);
    }

    public int getPreference(String preferenceKey, int defaulValue) {
        return sharedPreferences.getInt(preferenceKey, defaulValue);
    }

    public PreferenceHelper setPreference(String preferenceKey, int preferenceValue) {
        editor.putInt(preferenceKey, preferenceValue);
        editor.commit();
        return this;
    }

    public PreferenceHelper setPreference(String preferenceKey, String preferenceValue) {
        editor.putString(preferenceKey, preferenceValue);
        editor.commit();
        return this;
    }


    public class Key {
        public final static String PREF_PICKED_UNIVERSITY = "pref_picked_university";
    }

}
