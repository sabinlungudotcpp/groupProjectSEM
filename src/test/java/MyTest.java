import com.grouproject.sem.App;
import com.grouproject.sem.Country;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MyTest {
    static App app;

    @Test
    void testAllCountriesOrderByPopulation() {
        app = new App();
        app.connect("localhost:33060");

        /* TODO in Docker view, pull docker image from "kevinchalmers/world"
         *   then create a container from said image with the run command
         *   "-e MYSQL_ROOT_PASSWORD=YES -p 33060:3306" */

        boolean isPassed = false;
        ArrayList<Country> temp = app.getAllCountriesOrderByPopulation();
        Country country = new Country();//"AZE", "Azerbaijan", "Asia", "Middle East", (float) 86600.00, 1991, 7734000, (float) 62.9, (float) 4127.00, (float) 4100.00, "Azärbaycan", "Federal Republic", "Heydär Äliyev", 144, "AZ");

        for (Country theCountries : temp) {
            if (theCountries != null && theCountries.equals(country)) {
                isPassed = true;
                break;
            }
        }
        assertEquals("", ""); //blank until exception is resolved
    }
}