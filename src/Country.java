/**
 * Created by joe on 9/10/16.
 */
public class Country {
    private String abbreviation;
    private String name;

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Country(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }
}
