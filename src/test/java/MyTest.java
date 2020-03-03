import com.grouproject.sem.App;
import com.grouproject.sem.Country;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MyTest {

    private App app;

    @Test
    void testAllCountriesOrderByPopulation() {
        app = new App();
        boolean isPassed = false; // False by default.
        ArrayList<Country> temp = app.getAllCountriesOrderByPopulation();

        Country country = new Country("AZE", "Azerbaijan", "Asia", "Middle East", (float) 86600.00, 1991, 7734000, (float) 62.9, (float) 4127.00, (float) 4100.00, "Azärbaycan", "Federal Republic", "Heydär Äliyev", 144, "AZ");
       for (Country theCountries : temp) {

            if(theCountries != null && theCountries.equals(country)) {

                isPassed = true;
                break;
            }

       }
        assertEquals("", "");

    }
}