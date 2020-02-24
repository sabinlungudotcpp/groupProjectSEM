package main.java.com.grouproject.sem;
import com.grouproject.sem.Continent;

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

        app.connect();
        listOfRegions = new ArrayList<String>();
        listOfRegions = app.extractRegions();


        //app.printCountries(app.getAllCountriesOrderByPopulation());
        app.printCountries(app.getCountriesInContinentByLargestPopulation(com.grouproject.sem.Continent.NORTH_AMERICA));
        //app.getCountriesInRegionByLargestPopulation(listOfRegions.get(0));
        //app.getTopNCountriesOrderByPopulation(3);

        app.getAllCitiesInAContinent(Continent.NORTH_AMERICA);


        app.disconnect(); // Disconnect from DB
        System.out.println("End of Program");

    }

    private void printCountries(ArrayList<Country> countries) {
        for (Country theCountries : countries) {
            System.out.println(theCountries.toString());
        }
    }

    private ArrayList<Country> getAllCountriesOrderByPopulation() { // Routine that gets the SQL query results for the first Requirement
        String query = "SELECT * FROM country ORDER BY country.Population DESC";
        return extractCountryData(query);
    }

    private ArrayList<Country> getCountriesInContinentByLargestPopulation(com.grouproject.sem.Continent continent) { // Requirement 2 code
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

    private ArrayList<Country> getCountriesInRegionByLargestPopulation(String region) { // Requirement 2 code
        String myQuery = "SELECT * FROM country "
                + " WHERE Region = '" + region
                + "' ORDER BY country.Population DESC ";

        return extractCountryData(myQuery);
    }

    private ArrayList<City> getAllCitiesInAContinent(com.grouproject.sem.Continent continent) {

        return null;
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
            ArrayList<City> tempCities = new ArrayList<>();

            Statement statement = connection.createStatement();

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
                Thread.sleep(20000);
                connection = DriverManager.getConnection("jdbc:mysql://dbb:3306/world?useSSL=false", "root", "example");
                System.out.println("Connect Success");

                Thread.sleep(1000);
                break;

            } catch (SQLException exc) {

                System.out.println("Failed to connect to DB. Attempt : " + i);

            } catch (InterruptedException e) {

                System.out.println("Thread failed");
            }

        }
    }
}