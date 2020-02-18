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
        listOfRegions = new ArrayList<String>();
        app.connect();
/*
        app.getRegions();

        for (String region : listOfRegions) {
            System.out.println(region);
        }

 */

        app.printCountries(app.getAllCountriesOrderByPopulation());
        //app.getCountriesInContinentByLargestPopulation(Continent.NORTH_AMERICA);
        //app.getCountriesInRegionByLargestPopulation(listOfRegions.get(0));
        //app.getTopNCountriesOrderByPopulation(3);


        app.disconnect(); // Disconnect from DB

    }

    private void printCountries(ArrayList<Country> countries){
        for (Country c : countries){
            System.out.println(c.toString());
        }
    }

    private ArrayList<Country> getAllCountriesOrderByPopulation() { // Routine that gets the SQL query results for the first Requirement
        try {
            // Test comment
            ArrayList<Country> temp_countries = new ArrayList<Country>();
            String myQuery = "SELECT * FROM country ORDER BY country.Population DESC";
            Statement stmt = connection.createStatement(); // Create a connection statement
            ResultSet set = stmt.executeQuery(myQuery);

            while (set.next()) {
                Country country = new Country(set.getString("Code"), set.getString("Name"), set.getString("Continent"),
                        set.getString("Region"),set.getFloat("SurfaceArea"), set.getInt("IndepYear"),
                        set.getInt("Population"), set.getFloat("LifeExpectancy"),set.getFloat("GNP"),
                        set.getFloat("GNPOld"),set.getString("LocalName"),set.getString("GovernmentForm"),
                        set.getString("HeadOfState"),set.getInt("Capital"),set.getString("Code2"));
                temp_countries.add(country);
                //System.out.println(country.toString()); // Print all the data out
            }
            return temp_countries;

        } catch (SQLException exc) { // Catch exception
            System.out.println(exc.toString());
            return null;
        }
    }

    public void extractCountryData(ResultSet set){


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

                Thread.sleep(10000);
                break;

            } catch (SQLException exc) {

                System.out.println("Failed to connect to DB. Attempt : " + i);

            } catch (InterruptedException e) {

                System.out.println("Thread failed");
            }

        }
    }

    private void getCountriesInContinentByLargestPopulation(Continent continent) { // Requirement 2 code

        try {

            String myQuery = "SELECT * FROM country "
                    + " WHERE Continent = '" + continent.getContinent()
                    + "' ORDER BY country.Population DESC ";

            Statement stmt = connection.createStatement(); // Create a connection statement
            ResultSet set = stmt.executeQuery(myQuery);

            while (set.next()) {
                Country country = new Country();
                country.code = set.getString("Code");
                country.name = set.getString("Name");
                country.region = set.getString("Region");
                country.population = set.getInt("Population"); // Get the population
                System.out.println(country.toString()); // Print all the data out
            }

        } catch (SQLException exc) { // Catch exception
            System.out.println(exc.toString());
        }
    }

    private void getCountriesInRegionByLargestPopulation(String region) { // Requirement 2 code

        try {

            String myQuery = "SELECT * FROM country "
                    + " WHERE Region = '" + region
                    + "' ORDER BY country.Population DESC ";

            Statement stmt = connection.createStatement(); // Create a connection statement
            ResultSet set = stmt.executeQuery(myQuery);

            while (set.next()) {
                Country country = new Country();
                country.code = set.getString("Code");
                country.name = set.getString("Name");
                country.region = set.getString("Region");
                country.population = set.getInt("Population"); // Get the population
                System.out.println(country.toString()); // Print all the data out
            }

        } catch (SQLException exc) { // Catch exception
            System.out.println(exc.toString());
        }
    }

    private void getRegions() {

        try {

            String myQuery = "SELECT DISTINCT Region FROM country ";

            Statement stmt = connection.createStatement(); // Create a connection statement
            ResultSet set = stmt.executeQuery(myQuery);

            while (set.next()) {
                String region = set.getString("Region");
                listOfRegions.add(region);
            }

        } catch (SQLException exc) { // Catch exception
            System.out.println(exc.toString());
        }
    }

    private void disconnect() {
        if (connection != null) {
            try {

                connection.close();
            }
            catch (Exception e) {
                System.out.println("Error connecting to db");
            }
        }
    }

    private City getAllCities(int ID) {
        try {
            Statement stmt = connection.createStatement(); // Create a connection statement

            // String to get the City ID and name
            String getCitiesString = "SELECT city.ID, city.Name "
                    + "FROM city "
                    + "WHERE city.ID = " + ID;


            ResultSet set = stmt.executeQuery(getCitiesString);

            if (set.next()) {

                City city = new City(); // Create new instance of City
                city.id = set.getInt("ID"); // Get the ID
                city.name = set.getString("Name"); // Get the Name
                return city; // Return the city

            } else
                return null;

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("Failed to get city data");
            return null;
        }
    }

    private void getTopNCountriesOrderByPopulation(int n) { // Routine that gets the SQL query results for the first Requirement
        try {

            String myQuery = "SELECT * "
                    + "FROM country "
                    + "ORDER BY country.Population DESC "
                    + "LIMIT " + n ;

            Statement stmt = connection.createStatement(); // Create a connection statement
            ResultSet set = stmt.executeQuery(myQuery);

            while (set.next()) {
                Country country = new Country();
                country.code = set.getString("Code");
                country.name = set.getString("Name");
                country.region = set.getString("Region");
                country.population = set.getInt("Population"); // Get the population

                System.out.println(country.toString()); // Print all the data out
            }

        } catch (SQLException exc) { // Catch exception
            System.out.println(exc.toString());
        }
    }
}