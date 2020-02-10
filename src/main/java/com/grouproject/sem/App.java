package com.grouproject.sem;

import java.sql.*;

// Authors of Project: Sabin Constantin Lungu, Taylor Courtney, Jonathan Sung and Sadeem Rashid
// Date of Last Modified: 7/02/2020
// Purpose of Application: To write SQL queries embedded in Java code to retrieve the data required for the requirements.
// Bugs?: Currently none

public class App {

    private Connection connection = null;

    public static void main(String[] args) {
        App app = new App();
        app.connect();

        City city = app.getAllCities(14); // Create a City instance and get the ID 14

        app.displayCityData(city); // Display the data for ID 14

        app.disconnect();

    }

    private void connect() {
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

    private void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
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

            //Jonathan's test query
            String myquery ="SELECT * FROM country";

            ResultSet set = stmt.executeQuery(myquery);

            if (set.next()) {

                City city = new City(); // Create new instance of City
                city.cityId = set.getInt("ID"); // Get the ID
                city.cityName = set.getString("Name"); // Get the Name
                return city; // Return the city

            } else
                return null;

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("Failed to get city data");
            return null;
        }
    }

    private void displayCityData(City city) { // Routine to display the city data
        if (city != null) { // If there currently is no city

            System.out.println(city.cityId + " " + city.cityName); // Display the data
        }
    }
}