package com.grouproject.sem;

import java.sql.*;
import java.util.ArrayList;

// Authors of Project: Sabin Constantin Lungu, Taylor Courtney, Jonathan Sung and Sadeem Rashid
// Date of Last Modified: 04/04/2020
// Purpose of Application: To write SQL queries embedded in Java code to retrieve the data required for the requirements.
// Bugs?: Currently none

public class App {

    public static Connection connection = null;
    private static ArrayList<String> listOfRegions = new ArrayList<String>(); // An Array List of regions

    public static void main(String[] args) {
        App app = new App(); // Creates a new instance of app

        connect(); // Connect to the database
        listOfRegions = app.extractRegions(); // Extracts the regions.

        app.printCountries(app.getAllCountriesOrderByPopulation("1")); // Method invoked to print the countries that are in order by population
        app.printCountries(app.getCountriesInContinentByLargestPopulation(com.grouproject.sem.Continent.NORTH_AMERICA));
        //3. app.getCountriesInRegionByLargestPopulation(listOfRegions.get(0)); // Gets the countries in a region by the largest population
        //4. app.printCountries(app.getTopNCountriesOrderByPopulation(3)); // Gets the Top N countries where N is a value specified by the user where they are ordered by the population
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
        //16. app.printCities(app.getAllCapitalCitiesInAContinent(Continent.AFRICA));
        //17. app.printCities(app.getAllCapitalCitiesInARegion("Middle East"));
        //18. app.printCities(app.getAllCapitalCities());
        //19. app.printCities(app.getTopNCapitalCitiesInWorld(10));
        //20. app.printCities(app.getTopNCapitalCitiesInAContinent(10, Continent.EUROPE));
        //21. app.printCities(app.getTopNCapitalCitiesInARegion(10, "Middle East"));
        //22. app.printPopulation(app.getCityPopulationContinents());
        //23. app.printPopulation(app.getCityPopulationRegion());
        //24. app.printPopulation(app.getCityPopulationCountry());

        disconnect(); // Disconnects from the database.
    }


    private void printCountries(ArrayList<Country> countries) { // Routine to print out the countries table, that returns nothing
        Object[][] countryTable = new String[countries.size()][]; // A 2-D array of objects to store the formatted output

        String[] header = new String[]{"Code", "Name", "Continent", "Region", "Capital", "Population"}; // Used to add headers to the output table

        for (int i = 0; i < countries.size(); i++) { // Loop over the country. Time Complexity: O(n)

            // Adds country data to the output array
            countryTable[i] = new String[]{String.valueOf(countries.get(i).getCode()), countries.get(i).getName(),
                    countries.get(i).getContinent(), countries.get(i).getRegion(), Integer.toString(countries.get(i).getCapital()),
                    Integer.toString(countries.get(i).getPopulation())};
        }

        System.out.format("%25s%25s%25s%25s%25s%25s\n", header); // Displays the table headers

        for (final Object[] row : countryTable) { // Loop over the object array which is a constant and can't be modified
            System.out.format("%25s%25s%25s%25s%25s%25s\n", row); // Displays the table rows
        }
    }

    private void printCities(ArrayList<City> cities) { // Routine to print cities
        Object[][] cityTable = new String[cities.size()][]; // 2-D array to store the city table data

        String[] header = new String[]{"ID", "Name", "CountryCode", "District", "Population"}; // Used to add headers to the output table

        for (int i = 0; i < cities.size(); i++) {

            // Adds city data to the output array
            cityTable[i] = new String[]{String.valueOf(cities.get(i).getId()), cities.get(i).getName(),
                    cities.get(i).getCountryCode(), cities.get(i).getDistrict(), Integer.toString(cities.get(i).getPopulation())};
        }
        System.out.println(cities.size());
        System.out.format("%25s%25s%25s%25s%25s\n", header); // Displays the table headers

        for (final Object[] row : cityTable) {
            System.out.format("%25s%25s%25s%25s%25s\n", row); // Displays the table rows
        }
    }

    private void printPopulation(ArrayList<PopulationData> populationData) {
        Object[][] populationTable = new String[populationData.size()][];

        String[] header = new String[]{"Name", "Total Population", "City Population", "%", "Rural Population", "%"};  // Used to add headers to the output table

        for (int i = 0; i < populationData.size(); i++) {

            // Adds population data to the output array
            populationTable[i] = new String[]{String.valueOf(populationData.get(i).getName()), Double.toString(populationData.get(i).getTotal_population()),
                    Double.toString(populationData.get(i).getLivingInCities()), Float.toString(populationData.get(i).getPercentageCities()), Double.toString(populationData.get(i).getNotLivingInCities()), Float.toString(populationData.get(i).getPercentageNotInCities())};
        }

        System.out.println(populationData.size());
        System.out.format("%25s%25s%25s%25s%25s%25s\n", header); // Displays the table headers

        for (final Object[] row : populationTable) {
            System.out.format("%25s%25s%25s%25s%25s%25s\n", row); // Displays the table rows
        }
    }

    public static void disconnect() { // Routine to disconnect from the DB
        if (connection != null) {
            try {
                connection.close();

            } catch (Exception e) {
                System.out.println("Error connecting to db");
            }
        }
    }

    public ArrayList<Country> getCountriesInContinentByLargestPopulation(Continent continent) {  // Routine that gets the SQL query results for the first Requirement
        String myQuery = "SELECT * FROM country "
                + " WHERE Continent = '" + continent.getContinent()
                + "' ORDER BY country.Population DESC ";
        return extractCountryData(myQuery);
    }

    public ArrayList<Country> getTopNCountriesOrderByPopulation(int n) { // Routine that gets the SQL query results for the first Requirement
        String myQuery = "SELECT * " // The SQL Query: Selects all the data from the country table and orders the population in descending order and limits the number by N
                + "FROM country "
                + "ORDER BY country.Population DESC "
                + "LIMIT " + n;
        return extractCountryData(myQuery); // Return the method call to extract the country data
    }

    public ArrayList<Country> getTopNCountriesInAContinent(int limit, Continent continent) { // Routine that gets the SQL query results for the first Requirement
        String myQuery = "SELECT * " // Query that selects the data from the country table where the continent is specified by the user.
                + "FROM country "
                + "WHERE continent = '" + continent
                + "' ORDER BY country.Population DESC "
                + "LIMIT " + limit; // Limit the number of data to a limit specified by the user
        return extractCountryData(myQuery);
    }

    public ArrayList<Country> getTopNCountriesInARegion(int limit, String region) { // Routine that gets the SQL query results for the first Requirement
        String myQuery = "SELECT * "
                + "FROM country "
                + "WHERE region = '" + region
                + "' ORDER BY country.Population DESC "
                + "LIMIT " + limit; // Limit the number of data to a limit specified by the user
        return extractCountryData(myQuery);
    }

    public ArrayList<Country> getCountriesInRegionByLargestPopulation(String region) { // Requirement 2 code
        String myQuery = "SELECT * FROM country " // Query that selects all the data from the country table where the region is specified by the user.
                + " WHERE Region = '" + region
                + "' ORDER BY country.Population DESC ";

        return extractCountryData(myQuery); // Returns an array list of countries
    }

    public ArrayList<City> getAllCitiesInWorld() { // Routine to get all cities in a world
        String query = "SELECT * FROM city ORDER BY city.population DESC;";
        return extractCityData(query);
    }

    public ArrayList<City> getAllCitiesInAContinent(Continent continent) { // Returns all cities in a continent
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

    public ArrayList<City> getAllCitiesInACountry(String theCountry) { // This routine gets all the cities in a region by passing in an input region from the user.
        String query = "SELECT * FROM city" +
                " JOIN country ON (city.CountryCode = country.code)" +
                " WHERE country.name = '" + theCountry +
                "' ORDER BY city.population DESC ";

        return extractCityData(query);
    }

    public ArrayList<City> getAllCitiesInADistrict(String theDistrict) { // This routine gets all the cities in a region by passing in an input region from the user.
        String query = "SELECT * FROM city" +
                " JOIN country ON (city.CountryCode = country.code)" +
                " WHERE city.District = '" + theDistrict +
                "' ORDER BY city.population DESC ";

        return extractCityData(query);
    }

    public ArrayList<City> getTopNCitiesInTheWorld(int theLimit) { // This routine gets all the cities in a region by passing in an input region from the user.
        String theQuery = "SELECT * FROM city " +
                "ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    public ArrayList<City> getTopNCitiesInContinent(int theLimit, Continent continent) { // This routine gets all the cities in a region by passing in an input region from the user.
        String theQuery = "SELECT * FROM city " +
                "INNER JOIN country ON (city.countryCode = country.code)" +
                "WHERE Continent = '" + continent +
                "' ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    public ArrayList<City> getTopNCitiesInRegion(int theLimit, String theRegion) { // This routine gets all the cities in a region by passing in an input region from the user.
        String theQuery = "SELECT * FROM city " +
                "INNER JOIN country ON (city.countryCode = country.code)" +
                "WHERE Region = '" + theRegion +
                "' ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    public ArrayList<City> getTopNCitiesInADistrict(int theLimit, String theDistrict) { // This routine gets all the cities in a region by passing in an input region from the user.
        String theQuery = "SELECT * FROM city " +
                "INNER JOIN country ON (city.countryCode = country.code)" +
                "WHERE District = '" + theDistrict +
                "' ORDER BY city.population DESC " +
                "LIMIT " + theLimit;

        return extractCityData(theQuery);
    }

    public ArrayList<City> getAllCapitalCities() { // This routine gets all the cities in a region by passing in an input region from the user.
        String query = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL " +
                "ORDER BY city.population DESC";

        return extractCityData(query);
    }

    public ArrayList<City> getAllCapitalCitiesInAContinent(Continent continent) { // This routine gets all the cities in a region by passing in an input region from the user.

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Continent = '" + continent +
                "' ORDER BY city.population DESC";

        return extractCityData(theQuery);
    }

    public ArrayList<City> getAllCapitalCitiesInARegion(String theRegion) { // This routine gets all the cities in a region by passing in an input region from the user.

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Region = '" + theRegion +
                "' ORDER BY city.population DESC";

        return extractCityData(theQuery);
    }


    public ArrayList<City> getTopNCapitalCitiesInWorld(int n) { // This routine gets all the cities in a region by passing in an input region from the user.
        String query = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL " +
                "ORDER BY city.population DESC" +
                " LIMIT " + n;

        return extractCityData(query);
    }

    public ArrayList<City> getTopNCapitalCitiesInAContinent(int n, Continent continent) { // This routine gets all the cities in a region by passing in an input region from the user.

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Continent = '" + continent +
                "' ORDER BY city.population DESC" +
                " LIMIT " + n;

        return extractCityData(theQuery);
    }

    public ArrayList<City> getTopNCapitalCitiesInARegion(int n, String theRegion) { // This routine gets all the cities in a region by passing in an input region from the user.

        String theQuery = "SELECT * FROM city " +
                "LEFT JOIN country ON (country.Capital = city.ID) " +
                "WHERE country.Code IS NOT NULL AND country.Region = '" + theRegion +
                "' ORDER BY city.population DESC" +
                " LIMIT " + n;

        return extractCityData(theQuery);
    }

    public ArrayList<PopulationData> getCityPopulationContinents() // This routine gets all the cities in a region by passing in an input region from the user.
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

    public ArrayList<PopulationData> getCityPopulationRegion() // This routine gets all the cities in a region by passing in an input region from the user.
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

    public ArrayList<PopulationData> getCityPopulationCountry() // This routine gets all the cities in a region by passing in an input region from the user.
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

    public ArrayList<PopulationData> extractPopulationData(String query) { // This returns the Population data
        try {
            ArrayList<PopulationData> temp_population = new ArrayList<PopulationData>();
            Statement stmt = connection.createStatement(); // Creates on object which we will use to query the database with a database
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

    public static void connect() { // Method to connect the docker container to the database
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
                Thread.sleep(30000);
                // Connect to database
                connection = DriverManager.getConnection("jdbc:mysql://dbb:3306/world?useSSL=false", "root", "example");
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

    private ArrayList<City> extractCityData(String query) { // Extracts the city data by using an SQL query
        try {
            ArrayList<City> tempCities = new ArrayList<City>();
            Statement statement = connection.createStatement(); // Creates on object which we will use to query the database with a database
            ResultSet set = statement.executeQuery(query);

            while (set.next()) {

                City city = new City(set.getInt("ID"), set.getString("Name"),
                        set.getString("CountryCode"),
                        set.getString("District"),
                        set.getInt("Population"));
                tempCities.add(city);
            }


            return tempCities;
        } catch (SQLException exc) { // Catch the exception
            exc.printStackTrace();
            System.out.println(exc.getMessage());
        }
        return null; // Otherwise return nothing
    }

    private ArrayList<String> extractRegions() { // Returns a list of regions
        try {

            ArrayList<String> temp_regions = new ArrayList<String>();

            String myQuery = "SELECT DISTINCT Region FROM country "; // Creates a list of regions for us to work with
            Statement stmt = connection.createStatement(); // Creates on object which we will use to query the database with a database
            ResultSet set = stmt.executeQuery(myQuery);

            if (set.next()) { // If there are any more result sets
                String region = set.getString("Region"); // Get the region
                temp_regions.add(region); // Add it to the array list
            }

            return temp_regions; // Return the regions from the array list
        } catch (SQLException exc) {
            System.out.println(exc.toString());
            return null;
        }
    }

    public ArrayList<Country> getAllCountriesOrderByPopulation(String ID) { // Routine that gets the SQL query results for the first Requirement
        String query = "SELECT * FROM country ORDER BY country.Population DESC"; // The query that selects all the data from the country table and order it by population
        return extractCountryData(query);
    }

    public ArrayList<Country> extractCountryData(String query) { // This returns the required country fields
        try {
            ArrayList<Country> temp_countries = new ArrayList<Country>();
            Statement stmt = connection.createStatement(); // Creates on object which we will use to query the database with a database
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {

                Country country = new Country(set.getString("Code"), set.getString("Name"), set.getString("Continent"),
                        set.getString("Region"), set.getFloat("SurfaceArea"), set.getInt("IndepYear"),
                        set.getInt("Population"), set.getFloat("LifeExpectancy"), set.getFloat("GNP"),
                        set.getFloat("GNPOld"), set.getString("LocalName"), set.getString("GovernmentForm"),
                        set.getString("HeadOfState"), set.getInt("Capital"), set.getString("Code2"));
                temp_countries.add(country);
            }

            return temp_countries;
        } catch (SQLException exc) { // Catch exception
            System.out.println(exc.toString());
            return null;
        }
    }
}