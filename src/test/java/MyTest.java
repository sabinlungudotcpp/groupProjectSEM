import com.grouproject.sem.App;
import com.grouproject.sem.City;
import com.grouproject.sem.Country;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MyTest {
    static App app = new App();

    /* TODO in Docker view, pull docker image from "kevinchalmers/world"
     *   then create a container from said image with the run command
     *   "-e MYSQL_ROOT_PASSWORD=example -p 33060:3306" */

    @Test
    void testAllCountriesOrderByPopulation() {
        app.connect("localhost:33060");

        ArrayList<Country> temp = app.getAllCountriesOrderByPopulation();
        Country country = new Country("AZE", "Azerbaijan", "Asia", "Middle East", (float) 86600.00, 1991, 7734000, (float) 62.9, (float) 4127.00, (float) 4100.00, "Azärbaycan", "Federal Republic", "Heydär Äliyev", 144, "AZ");

        for (Country theCountries : temp) {
            if (theCountries != null && theCountries.equals(country)) {
                assertEquals(country, theCountries);
                break;
            }
        }
        app.disconnect();
    }

    @Test
    void testTopPopulatedCity() { //Checks if the query returns the correct top populated country
        app.connect("localhost:33060");

        ArrayList<City> temp = app.getTopNCitiesInTheWorld(3);
        City city = new City(1024,"Mumbai (Bombay)","IND","Maharashtra",10500000);

        if (temp != null) {
            assertEquals(city.getId(), temp.get(0).getId());
        }

        app.disconnect();
    }
}
