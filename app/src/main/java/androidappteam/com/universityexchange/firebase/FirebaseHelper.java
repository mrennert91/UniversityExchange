package androidappteam.com.universityexchange.firebase;

import android.content.Context;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import androidappteam.com.universityexchange.R;
import androidappteam.com.universityexchange.common.University;

/**
 * Created by Matej on 21/03/2018.
 */

public class FirebaseHelper {

    private Iterator<DataSnapshot> getIterator(DataSnapshot dataSnapshot) {
        return dataSnapshot.getChildren().iterator();
    }

    public ArrayList<University> getUniversitiesFromDatabase(Context context, DataSnapshot dataSnapshot) {
        ArrayList<University> listOfUniversities = new ArrayList<>();
        Iterator<DataSnapshot> universitiesList = getIterator(dataSnapshot);
        HashMap<String, Object> fetchedUniversity;

        while (universitiesList.hasNext()) {
            DataSnapshot university = universitiesList.next();
            fetchedUniversity = (HashMap<String, Object>) university.getValue();

            listOfUniversities.add(new University(
                    fetchedUniversity.get(context.getResources().getString(R.string.university_column_name)).toString(),
                    fetchedUniversity.get(context.getResources().getString(R.string.university_column_city)).toString(),
                    fetchedUniversity.get(context.getResources().getString(R.string.university_column_country)).toString())
            );
        }

        return listOfUniversities;
    }
}
