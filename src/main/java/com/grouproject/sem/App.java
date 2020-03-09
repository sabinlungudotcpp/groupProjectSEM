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

        app.connect("localhost:33060"); // Connect to the database
        listOfRegions = new ArrayList<String>();
        listOfRegions = app.extractRegions();

        //1. app.printCountries(app.getAllCountriesOrderByPopulation());
        //2. app.printCountries(app.getCountriesInContinentByLargestPopulation(com.grouproject.sem.Continent.NORTH_AMERICA));
        //3. app.getCountriesInRegionByLargestPopulation(listOfRegions.get(0));
        //4. app.printCountries(app.getTopNCountriesOrderByPopulation(3));
        //5. app.printCountries(app.getTopNCountriesInAContinent(3, Continent.ASIA));
        //6. app.printCountries(app.getTopNCountriesInARegion(3, listOfRegions.get(0)));
        //7. app.printCities(app.getAllCitiesInWorld());
        //8. app.printCities(app.
        // (Continent.NORTH_AMERICA));
        //9. app.printCities(app.getAllCitiesInARegion(listOfRegions.get(0)));
        //10. app.printCities(app.getAllCitiesInACountry("Germany"));
        //11. app.printCities(app.getAllCitiesInADistrict("Kabol"));
        //12. app.printCities(app.getTopNCitiesInTheWorld(5));
        //13. app.printCities(app.getTopNCitiesInContinent(5, Continent.EUROPE));
        //14. app.printCities(app.getTopNCitiesInRegion(5, "Middle East"));
        //15. app.printCities(app.getTopNCitiesInADistrict(5, "Kabol"));

        // app.printCities(app.getAllCapitalCitiesInAContinent(Continent.AFRICA));
        // app.printCities(app.getAllCapitalCitiesInARegion("Middle East"));
        // app.printCities(app.getAllCapitalCities());

      //  app.printCities(app.getTopNCapitalCitiesInWorld(10));
      //  app.printCities(app.getTopNCapitalCitiesInAContinent(10, Continent.EUROPE));
       // app.printCities(app.getTopNCapitalCitiesInARegion(10, "Middle East"));

        app.printPopulation(app.getCityPopulationContinents());
        app.printPopulation(app.getCityPopulationRegion());
        app.printPopulation(app.getCityPopulationCountry());
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

    private void printPopulation(ArrayList<PopulationData> populationData) {
        Object[][] populationTable = new String[populationData.size()][];

        String[] header = new String[]{"Name", "Total Population", "City Population", "%", "Rural Population", "%"};

        for (int i = 0; i < populationData.size(); i++) {

            populationTable[i] = new String[]{String.valueOf(populationData.get(i).getName()), Double.toString(populationData.get(i).getTotal_population()),
                    Double.toString(populationData.get(i).getLivingInCities()), Float.toString(populationData.get(i).getPercentageCities()), Double.toString(populationData.get(i).getNotLivingInCities()), Float.toString(populationData.get(i).getPercentageNotInCities())};
        }
        System.out.println(populationData.size());
        System.out.format("%25s%25s%25s%25s%25s%25s\n", header);

        for (final Object[] row : populationTable) {
            System.out.format("%25s%25s%25s%25s%25s%25s\n", row);
        }
    }

    public ArrayList<Country> getAllCountriesOrderByPopulation() { // Routine that gets the SQL query results for the first Requirement
        String query = "SELECT * FROM country ORDER BY country.Population DESC";
        return extractCountryData(query);
    }

    public ArrayList<Country> getCountriesInContinentByLargestPopulation(Continent continent) { // Requirement 2 code
        String myQuery = "SELECT * FROM country "
                + " WHERE Continent = '" + continent.getContinent()
                + "' ORDER BY country.Population DESC ";
        return extractCountryData(myQuery);
    }

    public ArrayList<Country> getTopNCountriesOrderByPopulation(int n) { // Routine that gets the SQL query results for the first Requirement
        String myQuery = "SELECT * "
                + "FROM country "
                + "ORDER BY country.Population DESC "
                + "LIMIT " + n;
        return extractCountryData(myQuery);
    }

    public ArrayList<Country> getTopNCountriesInAContinent(int limit, Continent continent) { // Routine that gets the SQL query results for the first Requirement
        String myQuery = "SELECT * "
                + "FROM country "
                + "WHERE continent = '" + continent
                + "' ORDER BY country.Population DESC "
                + "LIMIT " + limit;
        return extractCountryData(myQuery);
    }

    public ArrayList<Country> getTopNCountriesInARegion(int limit, String region) { // Routine that gets the SQL query results for the first Requirement
        String myQuery = "SELECT * "
                + "FROM country "
                + "WHERE region = '" + region
                + "' ORDER BY country.Population DESC "
                + "LIMIT " + limit;
        return extractCountryData(myQuery);
    }

    public ArrayList<Country> getCountriesInRegionByLargestPopulation(String region) { // Requirement 2 code
        String myQuery = "SELECT * FROM country "
                + " WHERE Region = '" + region
                + "' ORDER BY country.Population DESC ";

        return extractCountryData(myQuery);
    }

    public ArrayList<City> getAllCitiesInWorld() {
        String query = "SELECT * FROM city ORDER BY city.population DESC;";
        return extractCityData(query);
    }

    public ArrayList<City> getAllCitiesInAContinent(Continent continent) {
        String query = "SELECT * FROM city" +
                " INNER JOIN country ON (city.CountryCode = country.code)" +
                " WHERE Continent = '" + continent.getContinent() +
                "' ORDER BY city.population DESC ";
        return extractCityData(query);
    }

    public ArrayList<City> getAllCitiesInARegion(String theRegion) { // This routine gets all the cities in a region by passing in an input region from the user.
        String query = "SELECT * FROM city" +
                " INNER JOIN country ON (city.CountryCode = country.code)" +
                " WHERE region = '" + theRegion +
                "' ORDER BY city.population DESC "; // The query to get it.

        return extractCityData(query);
    }

    public ArrayList<City> getAllCitiesInACountry(String theCountry) {
        String query = "SELECT * FROM city" +
                " JOIN country ON (city.CountryCode = country.code)" +
                " WHERE country.name = '" + theCountry +
                "' ORDER BY city.population DESC ";

        return extractCityData(query);
    }

    public ArrayList<City> getAllCitiesInADistrict(String theDistrict) {
        String query = "SELECT * FROM city" +
                " JOIN country ON (city.CountryCode = country.code)" +
                " WHERE city.District = '" + theDistrict +
                "' ORDER BY city.population DESC ";

        return extractCityData(query);
    }

    public ArrayList<City> getTopNCitiesInTheWorld(int theLimit) {
        String theQuery = "SELECT * FROM city " +
                "ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    public ArrayList<City> getTopNCitiesInContinent(int theLimit, Continent continent) {
        String theQuery = "SELECT * FROM city " +
                "INNER JOIN country ON (city.countryCode = country.code)" +
                "WHERE Continent = '" + continent +
                "' ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    public ArrayList<City> getTopNCitiesInRegion(int theLimit, String theRegion) {
        String theQuery = "SELECT * FROM city " +
                "INNER JOIN country ON (city.countryCode = country.code)" +
                "WHERE Region = '" + theRegion +
                "' ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    public ArrayList<City> getTopNCitiesInADistrict(int theLimit, String theDistrict) {
        String theQuery = "SELECT * FROM city " +
                "INNER JOIN country ON (city.countryCode = country.code)" +
                "WHERE District = '" + theDistrict +
                "' ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    public ArrayList<City> getAllCapitalCities() {
        String query = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL " +
                "ORDER BY city.population DESC";

        return extractCityData(query);
    }

    public ArrayList<City> getAllCapitalCitiesInAContinent(Continent continent) {

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Continent = '" + continent +
                "' ORDER BY city.population DESC";

        return extractCityData(theQuery);
    }

    public ArrayList<City> getAllCapitalCitiesInARegion(String theRegion) {

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Region = '" + theRegion +
                "' ORDER BY city.population DESC";

        return extractCityData(theQuery);
    }




    public ArrayList<City> getTopNCapitalCitiesInWorld(int n) {
        String query = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL " +
                "ORDER BY city.population DESC" +
                " LIMIT " + n;

        return extractCityData(query);
    }

    public ArrayList<City> getTopNCapitalCitiesInAContinent(int n, Continent continent) {

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Continent = '" + continent +
                "' ORDER BY city.population DESC" +
                 " LIMIT " + n;

        return extractCityData(theQuery);
    }

    public ArrayList<City> getTopNCapitalCitiesInARegion(int n, String theRegion) {

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Region = '" + theRegion +
                "' ORDER BY city.population DESC" +
                " LIMIT " + n;

        return extractCityData(theQuery);
    }

    public ArrayList<PopulationData> getCityPopulationContinents()
    {
        String query = "SELECT cityPopulation.Continent, Continent_Population, City_Population, ((City_Population/Continent_Population) * 100) AS '(City_Population %)', (Continent_Population - City_Population) AS Rural_Population, (((Continent_Population - City_Population)/Continent_Population) * 100) AS '(Rural_Population %)'\n" +
                "FROM\n" +
                "(SELECT SUM(city.Population) AS City_Population, country.Continent FROM city\n" +
                "INNER JOIN country ON (city.CountryCode = country.code)\n" +
                "GROUP BY country.Continent) AS cityPopulation\n" +
                "INNER JOIN\n" +
                "(SELECT SUM(country.Population) AS Continent_Population, country.Continent FROM country\n" +
                "GROUP BY country.Continent) AS continentPopulation\n" +
                "ON (cityPopulation.Continent = continentPopulation.Continent);";
        return extractPopulationData(query);
    }

    public ArrayList<PopulationData> getCityPopulationRegion()
    {
        String query = "SELECT cityPopulation.Region, Region_Population, City_Population, ((City_Population/Region_Population) * 100) AS '%', (Region_Population - City_Population) AS Rural_Population, (((Region_Population - City_Population)/Region_Population) * 100) AS '%'\n" +
                "FROM\n" +
                "(SELECT SUM(city.Population) AS City_Population, country.Region FROM city\n" +
                "INNER JOIN country ON (city.CountryCode = country.code)\n" +
                "GROUP BY country.Region) AS cityPopulation\n" +
                "INNER JOIN\n" +
                "(SELECT SUM(country.Population) AS Region_Population, country.Region FROM country\n" +
                "GROUP BY country.Region) AS RegionPopulation\n" +
                "ON (cityPopulation.Region = RegionPopulation.Region);";
        return extractPopulationData(query);
    }

    public ArrayList<PopulationData> getCityPopulationCountry()
    {
        String query = "SELECT cityPopulation.Country_Name, Country_Population, City_Population, ((City_Population/Country_Population) * 100) AS '%', (Country_Population - City_Population) AS Rural_Population, (((Country_Population - City_Population)/Country_Population) * 100) AS '%'\n" +
                "FROM\n" +
                "(SELECT SUM(city.Population) AS City_Population, country.Name AS Country_Name FROM city\n" +
                "INNER JOIN country ON (city.CountryCode = country.code)\n" +
                "GROUP BY country.Name) AS cityPopulation\n" +
                "INNER JOIN\n" +
                "(SELECT SUM(country.Population) AS Country_Population, country.Name AS Country_Name FROM country\n" +
                "GROUP BY country.Name) AS countryPopulation\n" +
                "ON (cityPopulation.Country_Name = countryPopulation.Country_Name);";
        return extractPopulationData(query);
    }

    public ArrayList<PopulationData> extractPopulationData(String query) {
        try {
            ArrayList<PopulationData> temp_population = new ArrayList<PopulationData>();
            Statement stmt = connection.createStatement(); // Create a connection statement
            ResultSet set = stmt.executeQuery(query);
            while (set.next()) {
                PopulationData populationData = new PopulationData(set.getString(1), set.getDouble(2),set.getDouble(3),set.getFloat(4),set.getDouble(5),set.getFloat(6));
                temp_population.add(populationData);
            }
            return temp_population;
        } catch (SQLException exc) { // Catch exception
            System.out.println(exc.toString());
            return null;
        }
    }


    public ArrayList<Country> extractCountryData(String query) {
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

    public void disconnect() { // Routine to disconnect from the DB
        if (connection != null) {
            try {

                connection.close();
            } catch (Exception e) {
                System.out.println("Error connecting to db");
            }
        }
    }

    public void connect(String location) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(1000);
                // Connect to database
                connection = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /*private void connect() { // Routine to connect to the DB
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
    }*/
}