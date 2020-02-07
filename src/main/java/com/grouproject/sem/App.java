package com.grouproject.sem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    private Connection connection = null;

    public static void main(String[] args) {
        App app = new App();
        app.connect();
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
                connection = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
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
}
