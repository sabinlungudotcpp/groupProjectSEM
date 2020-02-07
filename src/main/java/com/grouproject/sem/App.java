package com.grouproject.sem;

import java.sql.*;

public class App {

    private Connection connection = null;

    public static void main(String[] args) {
        App app = new App();
        app.connect();

        City city = app.getAllCities(10);

        app.displayCityData(city);

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
            Statement stmt = connection.createStatement();

            String getCitiesString = "SELECT city.ID, city.Name "
                    + "FROM city "
                    + "WHERE city.ID = " + ID;

            ResultSet set = stmt.executeQuery(getCitiesString);

            if (set.next()) {
                City city = new City();
                city.cityId = set.getInt("ID");
                city.cityName = set.getString("Name");
                return city;

            } else
                return null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city data");
            return null;
        }
    }

    private void displayCityData(City city) {
        if (city != null) {
            System.out.println(city.cityId + " " + city.cityName);
        }
    }
}