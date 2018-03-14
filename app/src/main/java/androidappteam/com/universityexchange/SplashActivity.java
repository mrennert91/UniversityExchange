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
        prepareLayoutView();
    }

    private void prepareNecessaryData() {
        getSupportActionBar().hide();
        splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
    }

    private void prepareLayoutView() {
        splashBinding.uexLogoWrapper.setBackground(getDrawable(R.drawable.rounded_backgound));
        splashBinding.uexLogoImage.setImageResource(R.drawable.ic_university_logo);
    }

    //TODO: Add async task loader to fetch data from db
}
