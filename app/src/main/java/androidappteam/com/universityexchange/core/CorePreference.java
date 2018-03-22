package androidappteam.com.universityexchange.core;

import java.util.ArrayList;

import androidappteam.com.universityexchange.common.University;

/**
 * Created by Matej on 21/03/2018.
 */

public class CorePreference {

    private static CorePreference instance;

    private ArrayList<University> coreUniversityList;

    public CorePreference() {
    }

    public static CorePreference getInstance() {
        if (instance == null) {
            instance = new CorePreference();
        }
        return instance;
    }

    public ArrayList<University> getCoreUniversityList() {
        return coreUniversityList;
    }

    public void setCoreUniversityList(ArrayList<University> coreUniversityList) {
        this.coreUniversityList = coreUniversityList;
    }
}
