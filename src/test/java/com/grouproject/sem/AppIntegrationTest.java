package com.grouproject.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app = new App();
    ArrayList<Country> countries = new ArrayList<Country>();

    @BeforeAll
    static void init()
    {
        app.connect("localhost:33060");
        assertNotNull(app.connection);
    }

    @Test
    void testGetCountry()
    {
        countries = app.getAllCountriesOrderByPopulation();
        assertFalse(countries.isEmpty());
    }

    @Test
    void testGetCountryResult()
    {
        countries = app.getAllCountriesOrderByPopulation();
        Country country = new Country("CHN","China","Asia","Eastern Asia",(float) 9572900.00,-1523,1277558000,(float) 71.4,(float) 982268.00,(float) 917719.00,"Zhongquo","People\"sRepublic","Jiang Zemin",1891,"CN");
        assertEquals(country, countries.get(0));
    }

    @AfterAll
    static void finalise()
    {
        app.disconnect();
    }
}
