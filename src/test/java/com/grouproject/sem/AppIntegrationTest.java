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

    @AfterAll
    static void finalise()
    {
        app.disconnect();
    }
}
