package androidappteam.com.universityexchange.core;

import java.util.ArrayList;

import androidappteam.com.universityexchange.common.University;

/**
 * Created by Matej on 21/03/2018.
 */

public class CoreData {

    private static CoreData instance;

    private ArrayList<University> coreUniversityList;

    public CoreData() {
    }

    public static CoreData getInstance() {
        if (instance == null) {
            instance = new CoreData();
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
