package androidappteam.com.universityexchange;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.HashMap;

import androidappteam.com.universityexchange.databinding.ActivitySplashBinding;
import androidappteam.com.universityexchange.firebase.FirebaseHelper;
import androidappteam.com.universityexchange.firebase.FirebaseManager;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding splashBinding;
    private HashMap<String, Object> test;
    private FirebaseHelper firebaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        prepareNecessaryData();
        prepareLayoutView();

        new FirebaseManager()
                .initialize()
                .setDatabasePath("https://universityexchange-8075e.firebaseio.com/")
                .getReference()
                .setTableName("TestTable")
                .fetchData(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        firebaseHelper.fetchTestDataFromDatabase(dataSnapshot);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

    private void prepareNecessaryData() {
        getSupportActionBar().hide();
        splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        firebaseHelper = new FirebaseHelper();
    }

    private void prepareLayoutView() {
        splashBinding.uexLogoWrapper.setBackground(getDrawable(R.drawable.rounded_backgound));
        splashBinding.uexLogoImage.setImageResource(R.drawable.ic_university_logo);
    }

    //TODO: Add async task loader to fetch data from db
}
