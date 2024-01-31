package com.napier.dev;
import java.sql.*;
import java.util.ArrayList;

public class App {
    private Connection con = null;

    public void connect() {
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
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world", "root", "group3");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sql) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sql.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public ArrayList<World> getCountryWorld() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Continent, Code, Capital, Region, Population FROM country ORDER BY Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<World> country = new ArrayList<World>();
            while (rset.next()) {
                World wrld = new World();
                wrld.CountryName = rset.getString("country.Name");
                wrld.Continent = rset.getString("country.Continent");
                wrld.Region = rset.getString("country.Region");
                wrld.CountryPopulation = rset.getInt("country.Population");
                wrld.Capital = rset.getInt("country.Capital");
                wrld.Code = rset.getString("country.Code");
                country.add(wrld);

            }
            return country;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
            return null;
        }
    }

    // Print out the data
    public void printOutput(ArrayList<World> country) {
        // Print header
        System.out.println(String.format("%-5s %-49s %-14s %-25s %-13s %-10s",
                "Code", "Name", "Continent", "Region", "Population", "Capital"));

        // Loop over all countries in the list
        for (World wrld : country) {
            String wrld_str =
                    String.format("%-5s %-49s %-14s %-25s %-13s %-10s",
                            wrld.Code, wrld.CountryName, wrld.Continent, wrld.Region, wrld.CountryPopulation, wrld.Capital);
            System.out.println(wrld_str);
        }
    }

    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract world details from the database
        ArrayList<World> country = a.getCountryWorld();
        a.printOutput(country);

        // Disconnect from database
        a.disconnect();
    }
}