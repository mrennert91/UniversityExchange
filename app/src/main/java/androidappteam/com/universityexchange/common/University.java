package androidappteam.com.universityexchange.common;

/**
 * Created by Matej on 21/03/2018.
 */

public class University {

    private String name;
    private String city;
    private String country;

    public University() {
    }

    public University(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
