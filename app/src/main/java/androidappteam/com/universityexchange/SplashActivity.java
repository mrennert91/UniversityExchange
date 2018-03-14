package androidappteam.com.universityexchange;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidappteam.com.universityexchange.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding splashBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        prepareNecessaryData();
    }

    private void prepareNecessaryData() {
        splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
    }
}
