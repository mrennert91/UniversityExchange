package androidappteam.com.universityexchange.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidappteam.com.universityexchange.R;
import androidappteam.com.universityexchange.helpers.BaseHelper;
import androidappteam.com.universityexchange.helpers.PreferenceHelper;

public class HomeActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        prepareNecessaryData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.uni_exchange_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_preferences) {
            BaseHelper.goToNextActivity(HomeActivity.this, PreferencesActivity.class);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String getUniversityFromPreference() {
        return preferenceHelper.getPreference(PreferenceHelper.Key.PREF_PICKED_UNIVERSITY, "");
    }

    private void prepareNecessaryData() {
        preferenceHelper = new PreferenceHelper().initialize(this);
        getSupportActionBar().setTitle(getUniversityFromPreference());
    }
}
