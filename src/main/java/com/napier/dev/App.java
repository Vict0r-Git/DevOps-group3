package com.napier.dev;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

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
    public  ArrayList<World> getCitiesByCont(String continentName){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, " +
                            "city.Population " +
                            "FROM world.city " +
                            "JOIN world.country ON city.CountryCode = country.Code " +
                            "WHERE country.Continent = '" + continentName + "' " +
                            "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<World> citybycont = new ArrayList<World>();
            while (rset.next()) {
                World wrld = new World();
                wrld.CityName = rset.getString("Name");
                wrld.CountryName = rset.getString("Country");
                wrld.District = rset.getString("District");
                wrld.CityPopulation = rset.getInt("Population");
                citybycont.add(wrld);

            }
            return citybycont;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in world details");
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
    public void DisplayCities(ArrayList<World> city) {
        // Print header
        System.out.println(String.format("%-37s %-49s %-23s %-25s",
                "Name", "Country", "District", "Population"));

        // Loop over all cities in the list
        for (World wrld : city) {
            String wrld_str =
                    String.format("%-37s %-49s %-23s %-25s",
                            wrld.CityName, wrld.CountryName, wrld.District, wrld.CityPopulation);
            System.out.println(wrld_str);
        }
    }

    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Prompt user for choice
        // Prompt user for choice
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose a function:");
            System.out.println("1. Countries\n"
            + "2. Cities");

            // Read user input
            int choice = Integer.parseInt(reader.readLine());

            // Execute chosen function
            switch (choice) {
                case 1:
                    // Extract world details from the database
                    ArrayList<World> country = a.getCountryWorld();
                    a.printOutput(country);
                    break;
                case 2:
                    System.out.println("Choose a Continent");
                    String contChoice = reader.readLine();
                    ArrayList<World> CT = a.getCitiesByCont(contChoice);
                    a.DisplayCities(CT);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } catch (Exception e) {
            System.out.println("Error reading input: " + e.getMessage());
        }


        // Disconnect from database
        a.disconnect();
    }
}