package androidappteam.com.universityexchange.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import androidappteam.com.universityexchange.R;
import androidappteam.com.universityexchange.core.CorePreference;
import androidappteam.com.universityexchange.databinding.ActivityPickerBinding;
import androidappteam.com.universityexchange.recyclerview.ListItemClickListener;
import androidappteam.com.universityexchange.recyclerview.adapters.UniversitiesAdapter;

public class PickerActivity extends AppCompatActivity implements ListItemClickListener {

    private CorePreference corePreference;
    private ActivityPickerBinding pickerBinding;
    private RecyclerView universitiesListPicker;
    private UniversitiesAdapter universitiesAdapter;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);

        prepareNecessaryData();
        prepareLayoutView();
        setRecyclerView();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            this.finishAffinity();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getString(R.string.exit_press_back_twice), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void prepareNecessaryData() {
        getSupportActionBar().setTitle(getResources().getString(R.string.picker_select_university));
        pickerBinding = DataBindingUtil.setContentView(this, R.layout.activity_picker);
        corePreference = CorePreference.getInstance();
    }

    private void prepareLayoutView() {
        universitiesListPicker = pickerBinding.universitiesListPicker;
        universitiesListPicker.setBackground(getResources().getDrawable(R.drawable.background_rounded_shadow));
    }

    private void setRecyclerView() {
        universitiesAdapter = new UniversitiesAdapter(corePreference.getCoreUniversityList(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        universitiesListPicker.setLayoutManager(layoutManager);
        universitiesListPicker.setAdapter(universitiesAdapter);
    }

    @Override
    public void onListItemClickListener(int clickedItemPosition) {
//THIS IS TEMPORARY SOLUTION UNTIL WE IMPLEMENT APP PREFERENCES AND NEW START APP LOGIC
//TODO PickerActivity(1): Create logic to fetch all data for selected university and store selected university in preferences
        Intent intent = new Intent(PickerActivity.this, HomeActivity.class);
        String universityName = corePreference.getCoreUniversityList().get(clickedItemPosition).getName();
        intent.putExtra("universityName", universityName);
        startActivity(intent);
    }
}
