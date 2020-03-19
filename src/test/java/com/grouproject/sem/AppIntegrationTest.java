package com.grouproject.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppIntegrationTest
{
    static App app = new App();
    ArrayList<Country> countries = new ArrayList<Country>();

    @BeforeAll
    static void init()
    {
        //connect to the database
        App.connect("localhost:33060");
        assertNotNull(App.connection);
    }

    @AfterAll
    static void finalise() {
        App.disconnect();
    }

    @Test
    void testGetCountry()
    {
        //call query
        // countries = app.getAllCountriesOrderByPopulation();
        //assertFalse(countries.isEmpty());
    }

    @Test
    void testGetCountryResult()
    {
        //generate a country and compare the values to the query items
        // countries = app.getAllCountriesOrderByPopulation();
        Country country = new Country("CHN","China","Asia","Eastern Asia", (float) 9572900.0,-1523,1277558000,(float) 71.4,(float) 982268.0,(float) 917719.0,"Zhongquo","People\'sRepublic","Jiang Zemin",1891,"CN");
        //assertEquals(country.toString(), countries.get(0).toString());
        assertEquals(country.getCode(), countries.get(0).getCode());
        assertEquals(country.getName(), countries.get(0).getName());
        assertEquals(country.getContinent(), countries.get(0).getContinent());
        assertEquals(country.getRegion(), countries.get(0).getRegion());
        assertEquals(country.getSurfaceArea(), countries.get(0).getSurfaceArea());
        assertEquals(country.getIndepYear(), countries.get(0).getIndepYear());
        assertEquals(country.getPopulation(), countries.get(0).getPopulation());
        assertEquals(country.getLifeExpectancy(), countries.get(0).getLifeExpectancy());
        assertEquals(country.getGNP(), countries.get(0).getGNP());
        assertEquals(country.getGNPOld(), countries.get(0).getGNPOld());
        assertEquals(country.getLocalName(), countries.get(0).getLocalName());
        assertEquals(country.getGovernmentForm(), countries.get(0).getGovernmentForm());
        assertEquals(country.getHeadOfState(), countries.get(0).getHeadOfState());
        assertEquals(country.getCapital(), countries.get(0).getCapital());
        assertEquals(country.getCode2(), countries.get(0).getCode2());
    }
}
