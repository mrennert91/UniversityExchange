package androidappteam.com.universityexchange.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidappteam.com.universityexchange.R;

public class HomeActivity extends AppCompatActivity {

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
        if(id == R.id.action_preferences) {
            Intent intent = new Intent(this, PreferencesActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String getUniversityFromPreference() {
//THIS IS TEMPORARY SOLUTION UNTIL WE IMPLEMENT APP PREFERENCES
//WHEN USER CHOOSE FIRST TIME UNIVERSITY WE ARE GOING TO STORE IT IN PREFERENCES SO WHEN APP IS STARTED IT WILL
//JUMP TO THIS WINDOW AND THEN WE ARE GOING TO GET UNIVERSITY NAME FROM PREFERENCE
//IN ALL SOLUTIONS AT THIS POINT PREFERENCE MUST HAVE STORED UNIVERSITY NAME
// TODO HomeActivity(1): Fetch university name from preferences and return as String, when done delete above comment
        Intent intent = getIntent();
        String universityName = intent.getStringExtra("universityName");
        return universityName;
    }

    private void prepareNecessaryData() {
        getSupportActionBar().setTitle(getUniversityFromPreference());
    }
}
