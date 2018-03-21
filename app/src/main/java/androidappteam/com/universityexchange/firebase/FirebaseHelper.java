package androidappteam.com.universityexchange.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Matej on 21/03/2018.
 */

public class FirebaseHelper {

    public void fetchTestDataFromDatabase(DataSnapshot dataSnapshot) {
        Iterator<DataSnapshot> testData = getIterator(dataSnapshot);
        HashMap<String, Object> test;

        while (testData.hasNext()) {
            DataSnapshot data = testData.next();
            test = (HashMap<String, Object>) data.getValue();
            Log.i("TestData", "name:" + test.get("name").toString() + " - type:" + test.get("type").toString());
        }
    }

    private Iterator<DataSnapshot> getIterator(DataSnapshot dataSnapshot){
        return dataSnapshot.getChildren().iterator();
    }
}
