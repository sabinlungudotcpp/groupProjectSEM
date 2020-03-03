package com.grouproject.sem;

import java.sql.*;
import java.util.ArrayList;

// Authors of Project: Sabin Constantin Lungu, Taylor Courtney, Jonathan Sung and Sadeem Rashid
// Date of Last Modified: 7/02/2020
// Purpose of Application: To write SQL queries embedded in Java code to retrieve the data required for the requirements.
// Bugs?: Currently none

public class App {

    private Connection connection = null;
    private static ArrayList<String> listOfRegions = null; // Set to null initially

    public static void main(String[] args) {
        App app = new App();

        app.connect(); // Connect to the database
        listOfRegions = new ArrayList<String>();
        listOfRegions = app.extractRegions();

        app.printCountries(app.getAllCountriesOrderByPopulation());
        //2. app.printCountries(app.getCountriesInContinentByLargestPopulation(com.grouproject.sem.Continent.NORTH_AMERICA));
        //3. app.getCountriesInRegionByLargestPopulation(listOfRegions.get(0));
        //4. app.printCountries(app.getTopNCountriesOrderByPopulation(3));
        //5. app.printCountries(app.getTopNCountriesInAContinent(3, Continent.ASIA));
        //6. app.printCountries(app.getTopNCountriesInARegion(3, listOfRegions.get(0)));
        //7. app.printCities(app.getAllCitiesInWorld());
        //8. app.printCities(app.getAllCitiesInAContinent(Continent.NORTH_AMERICA));
        //9. app.printCities(app.getAllCitiesInARegion(listOfRegions.get(0)));
        //10. app.printCities(app.getAllCitiesInACountry("Germany"));
        //11. app.printCities(app.getAllCitiesInADistrict("Kabol"));
        //12. app.printCities(app.getTopNCitiesInTheWorld(5));
        //13. app.printCities(app.getTopNCitiesInContinent(5, Continent.EUROPE));
        //14. app.printCities(app.getTopNCitiesInRegion(5, "Middle East"));
        //15. app.printCities(app.getTopNCitiesInADistrict(5, "Kabol"));

        // app.printCities(app.getAllCapitalCitiesInAContinent(Continent.AFRICA));
        // app.printCities(app.getAllCapitalCitiesInARegion("Middle East"));
        //  app.printCities(app.getAllCapitalCities());

      //  app.printCities(app.getTopNCapitalCitiesInWorld(10));
        //tst
      //  app.printCities(app.getTopNCapitalCitiesInAContinent(10, Continent.EUROPE));
       // app.printCities(app.getTopNCapitalCitiesInARegion(10, "Middle East"));

        app.disconnect(); // Disconnect from DB
        System.out.println("End of program.");
    }


    private void printCountries(ArrayList<Country> countries) {
        Object[][] countryTable = new String[countries.size()][];

        String[] header = new String[]{"Code", "Name", "Continent", "Region", "Capital", "Population"};

        for (int i = 0; i < countries.size(); i++) {

            countryTable[i] = new String[]{String.valueOf(countries.get(i).getCode()), countries.get(i).getName(),
                    countries.get(i).getContinent(), countries.get(i).getRegion(), Integer.toString(countries.get(i).getCapital()),
                    Integer.toString(countries.get(i).getPopulation())};
        }

        System.out.format("%25s%25s%25s%25s%25s%25s\n", header);
        for (final Object[] row : countryTable) {
            System.out.format("%25s%25s%25s%25s%25s%25s\n", row);
        }
    }

    private void printCities(ArrayList<City> cities) {
        Object[][] cityTable = new String[cities.size()][];

        String[] header = new String[]{"ID", "Name", "CountryCode", "District", "Population"};

        for (int i = 0; i < cities.size(); i++) {

            cityTable[i] = new String[]{String.valueOf(cities.get(i).getId()), cities.get(i).getName(),
                    cities.get(i).getCountryCode(), cities.get(i).getDistrict(), Integer.toString(cities.get(i).getPopulation())};
        }
        System.out.println(cities.size());
        System.out.format("%25s%25s%25s%25s%25s\n", header);
        for (final Object[] row : cityTable) {
            System.out.format("%25s%25s%25s%25s%25s\n", row);
        }
    }

    public ArrayList<Country> getAllCountriesOrderByPopulation() { // Routine that gets the SQL query results for the first Requirement
        String query = "SELECT * FROM country ORDER BY country.Population DESC";
        return extractCountryData(query);
    }

    private ArrayList<Country> getCountriesInContinentByLargestPopulation(Continent continent) { // Requirement 2 code
        String myQuery = "SELECT * FROM country "
                + " WHERE Continent = '" + continent.getContinent()
                + "' ORDER BY country.Population DESC ";
        return extractCountryData(myQuery);
    }

    private ArrayList<Country> getTopNCountriesOrderByPopulation(int n) { // Routine that gets the SQL query results for the first Requirement
        String myQuery = "SELECT * "
                + "FROM country "
                + "ORDER BY country.Population DESC "
                + "LIMIT " + n;
        return extractCountryData(myQuery);
    }

    private ArrayList<Country> getTopNCountriesInAContinent(int limit, Continent continent) { // Routine that gets the SQL query results for the first Requirement
        String myQuery = "SELECT * "
                + "FROM country "
                + "WHERE continent = '" + continent
                + "' ORDER BY country.Population DESC "
                + "LIMIT " + limit;
        return extractCountryData(myQuery);
    }

    private ArrayList<Country> getTopNCountriesInARegion(int limit, String region) { // Routine that gets the SQL query results for the first Requirement
        String myQuery = "SELECT * "
                + "FROM country "
                + "WHERE region = '" + region
                + "' ORDER BY country.Population DESC "
                + "LIMIT " + limit;
        return extractCountryData(myQuery);
    }

    private ArrayList<Country> getCountriesInRegionByLargestPopulation(String region) { // Requirement 2 code
        String myQuery = "SELECT * FROM country "
                + " WHERE Region = '" + region
                + "' ORDER BY country.Population DESC ";

        return extractCountryData(myQuery);
    }

    private ArrayList<City> getAllCitiesInWorld() {
        String query = "SELECT * FROM city ORDER BY city.population DESC;";
        return extractCityData(query);
    }

    private ArrayList<City> getAllCitiesInAContinent(Continent continent) {
        String query = "SELECT * FROM city" +
                " INNER JOIN country ON (city.CountryCode = country.code)" +
                " WHERE Continent = '" + continent.getContinent() +
                "' ORDER BY city.population DESC ";
        return extractCityData(query);
    }

    private ArrayList<City> getAllCitiesInARegion(String theRegion) { // This routine gets all the cities in a region by passing in an input region from the user.
        String query = "SELECT * FROM city" +
                " INNER JOIN country ON (city.CountryCode = country.code)" +
                " WHERE region = '" + theRegion +
                "' ORDER BY city.population DESC "; // The query to get it.

        return extractCityData(query);
    }

    private ArrayList<City> getAllCitiesInACountry(String theCountry) {
        String query = "SELECT * FROM city" +
                " JOIN country ON (city.CountryCode = country.code)" +
                " WHERE country.name = '" + theCountry +
                "' ORDER BY city.population DESC ";

        return extractCityData(query);
    }

    private ArrayList<City> getAllCitiesInADistrict(String theDistrict) {
        String query = "SELECT * FROM city" +
                " JOIN country ON (city.CountryCode = country.code)" +
                " WHERE city.District = '" + theDistrict +
                "' ORDER BY city.population DESC ";

        return extractCityData(query);
    }

    private ArrayList<City> getTopNCitiesInTheWorld(int theLimit) {
        String theQuery = "SELECT * FROM city " +
                "ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    private ArrayList<City> getTopNCitiesInContinent(int theLimit, Continent continent) {
        String theQuery = "SELECT * FROM city " +
                "INNER JOIN country ON (city.countryCode = country.code)" +
                "WHERE Continent = '" + continent +
                "' ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    private ArrayList<City> getTopNCitiesInRegion(int theLimit, String theRegion) {
        String theQuery = "SELECT * FROM city " +
                "INNER JOIN country ON (city.countryCode = country.code)" +
                "WHERE Region = '" + theRegion +
                "' ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    private ArrayList<City> getTopNCitiesInADistrict(int theLimit, String theDistrict) {
        String theQuery = "SELECT * FROM city " +
                "INNER JOIN country ON (city.countryCode = country.code)" +
                "WHERE District = '" + theDistrict +
                "' ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    private ArrayList<City> getAllCapitalCities() {
        String query = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL " +
                "ORDER BY city.population DESC";

        return extractCityData(query);
    }

    private ArrayList<City> getAllCapitalCitiesInAContinent(Continent continent) {

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Continent = '" + continent +
                "' ORDER BY city.population DESC";

        return extractCityData(theQuery);
    }

    private ArrayList<City> getAllCapitalCitiesInARegion(String theRegion) {

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Region = '" + theRegion +
                "' ORDER BY city.population DESC";

        return extractCityData(theQuery);
    }






    private ArrayList<City> getTopNCapitalCitiesInWorld(int n) {
        String query = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL " +
                "ORDER BY city.population DESC" +
                " LIMIT " + n;

        return extractCityData(query);
    }

    private ArrayList<City> getTopNCapitalCitiesInAContinent(int n, Continent continent) {

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Continent = '" + continent +
                "' ORDER BY city.population DESC" +
                 " LIMIT " + n;

        return extractCityData(theQuery);
    }

    private ArrayList<City> getTopNCapitalCitiesInARegion(int n, String theRegion) {

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Region = '" + theRegion +
                "' ORDER BY city.population DESC" +
                " LIMIT " + n;

        return extractCityData(theQuery);
    }
















    private ArrayList<Country> extractCountryData(String query) {
        try {

            ArrayList<Country> temp_countries = new ArrayList<Country>();
            Statement stmt = connection.createStatement(); // Create a connection statement
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                Country country = new Country(set.getString("Code"), set.getString("Name"), set.getString("Continent"),
                        set.getString("Region"), set.getFloat("SurfaceArea"), set.getInt("IndepYear"),
                        set.getInt("Population"), set.getFloat("LifeExpectancy"), set.getFloat("GNP"),

                        set.getFloat("GNPOld"), set.getString("LocalName"), set.getString("GovernmentForm"),
                        set.getString("HeadOfState"), set.getInt("Capital"), set.getString("Code2"));
                temp_countries.add(country);

                //System.out.println(country.toString()); // Print all the data out
            }

            return temp_countries;

        } catch (SQLException exc) { // Catch exception
            System.out.println(exc.toString());
            return null;
        }
    }

    private ArrayList<City> extractCityData(String query) { // Extracts the city data by using an SQL query
        try {
            ArrayList<City> tempCities = new ArrayList<City>(); // A list of cities to get stored.

            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);

            while (set.next()) { // Loop over the next set
                 City city = new City(set.getInt("ID"), set.getString("Name"),
                         set.getString("CountryCode"),
                         set.getString("District"),
                         set.getInt("Population"));

                 tempCities.add(city);
             }

             return tempCities;

        } catch (SQLException exc) {

            exc.printStackTrace();

            System.out.println(exc.getMessage());

        }

        return null;
    }

    private ArrayList<String> extractRegions() { // Returns a list of regions
        ArrayList<String> temp_regions = new ArrayList<String>();

        try {

            String myQuery = "SELECT DISTINCT Region FROM country "; // SQL query to get the region
            Statement stmt = connection.createStatement(); // Create a connection statement
            ResultSet set = stmt.executeQuery(myQuery);

            while (set.next()) {
                String region = set.getString("Region");
                temp_regions.add(region);
            }

            return temp_regions;

        } catch (SQLException exc) { // Catch exception
            System.out.println(exc.toString());
            return null;
        }
    }

    private void disconnect() { // Routine to disconnect from the DB
        if (connection != null) {
            try {

                connection.close();
            } catch (Exception e) {
                System.out.println("Error connecting to db");
            }
        }
    }

    private void connect() { // Routine to connect to the DB
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Could not load SQL Driver");
            System.exit(-1);

        }

        int retries = 100;

        for (int i = 0; i < retries; i++) {
            System.out.println("Connecting to DB...");

            try {
                Thread.sleep(1000);
                connection = DriverManager.getConnection("jdbc:mysql://dbb:3306/world?useSSL=false", "root", "example");
                System.out.println("Connect Success");
                break;

            } catch (SQLException exc) {

                System.out.println("Failed to connect to DB. Attempt : " + i);

            } catch (InterruptedException e) {

                System.out.println("Thread failed");
            }

        }
    }
}