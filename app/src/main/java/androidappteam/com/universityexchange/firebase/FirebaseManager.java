package androidappteam.com.universityexchange.firebase;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Matej on 20/03/2018.
 */

public class FirebaseManager {

    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private StringBuffer dataPath;

    public FirebaseManager initialize() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        dataPath = new StringBuffer();
        return this;
    }

    public FirebaseManager setDatabasePath(String databasePath) {
        this.dataPath.append(databasePath);
        return this;
    }

    public FirebaseManager setTableName(String tableName) {
        databaseReference.child(tableName);
        return this;
    }

    public FirebaseManager getReference() {
        databaseReference = firebaseDatabase.getReferenceFromUrl(String.valueOf(dataPath));
        return this;
    }

    public FirebaseManager fetchData(ChildEventListener childEventListener) {
        databaseReference.addChildEventListener(childEventListener);
        return this;
    }

    public FirebaseManager fetchData(ValueEventListener valueEventListener) {
        databaseReference.addValueEventListener(valueEventListener);
        return this;
    }
}
