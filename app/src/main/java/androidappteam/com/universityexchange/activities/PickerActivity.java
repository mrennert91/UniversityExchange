package androidappteam.com.universityexchange.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import androidappteam.com.universityexchange.R;
import androidappteam.com.universityexchange.core.CoreData;
import androidappteam.com.universityexchange.databinding.ActivityPickerBinding;
import androidappteam.com.universityexchange.recyclerview.adapters.UniversitiesAdapter;

public class PickerActivity extends AppCompatActivity {

    private CoreData coreData;
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
        pickerBinding = DataBindingUtil.setContentView(this, R.layout.activity_picker);
        coreData = CoreData.getInstance();
    }

    private void prepareLayoutView() {
        universitiesListPicker = pickerBinding.universitiesListPicker;
        universitiesListPicker.setBackground(getResources().getDrawable(R.drawable.background_rounded_shadow));
        pickerBinding.universitiesPickerTitle.setText(getResources().getString(R.string.picker_select_university));
        pickerBinding.universitiesPickerTitle.setTextColor(getResources().getColor(R.color.colorCategoryTitle));
        pickerBinding.universitiesPickerTitle.setTextSize(getResources().getDimension(R.dimen.text_size_xsmall));
    }

    private void setRecyclerView() {
        universitiesAdapter = new UniversitiesAdapter(coreData.getCoreUniversityList());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        universitiesListPicker.setLayoutManager(layoutManager);
        universitiesListPicker.setAdapter(universitiesAdapter);
    }
}
