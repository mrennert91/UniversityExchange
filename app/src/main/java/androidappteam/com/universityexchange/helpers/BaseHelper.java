package androidappteam.com.universityexchange.helpers;

import android.app.Activity;
import android.content.Intent;

import androidappteam.com.universityexchange.R;

/**
 * Created by Matej on 21/03/2018.
 */

public class BaseHelper {

    public static void goToNextActivity(Activity currentActivity, Class nextActivity) {
        Intent intent = new Intent(currentActivity, nextActivity);
        currentActivity.startActivity(intent);
        currentActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
