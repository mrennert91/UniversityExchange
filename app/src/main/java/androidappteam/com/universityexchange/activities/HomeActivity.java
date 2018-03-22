package androidappteam.com.universityexchange.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import androidappteam.com.universityexchange.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        prepareNecessaryData();
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
