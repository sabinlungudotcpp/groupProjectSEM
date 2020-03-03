import com.grouproject.sem.App;
import com.grouproject.sem.Country;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class MyTest {

    private App app = new App();


    @Test
    void testAllCountriesOrderByPopulation() {
        boolean isPassed = false; // False by default.

        Country country = new Country("AZE", "Azerbaijan", "Asia", "Middle East", (float) 86600.00, 1991, 7734000, (float) 62.9, (float) 4127.00, (float) 4100.00, "Azärbaycan", "Federal Republic", "Heydär Äliyev", 144, "AZ");

        for (Country theCountries : app.getAllCountriesOrderByPopulation()) {

            if (theCountries.equals(country)) {
                isPassed = true;
                break;
            }
        }

        assertTrue(isPassed);

    }
}