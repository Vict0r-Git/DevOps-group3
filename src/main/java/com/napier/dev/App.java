package com.napier.dev;
import java.sql.*;
import java.util.ArrayList;

public class App
{
    private Connection con = null;
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world", "root", "group3");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sql)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sql.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
    public ArrayList<World> getCountryWorld() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT * FROM country ORDER BY Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<World> country = new ArrayList<World>();
            while (rset.next()) {
                World wrld = new World();
                wrld.CountryName = rset.getString("Name");
                wrld.Continent = rset.getString("Continent");
                wrld.Region = rset.getString("Region");
                wrld.CountryPopulation = rset.getInt("Population");
                wrld.Capital = rset.getString("Capital");
                wrld.Code = rset.getString("Code");
                wrld.Code2 = rset.getString("Code2");
            }
            return country;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
            return null;
        }
    }
//    public void display(World wrld) {
//        if (wrld != null) {
//            System.out.println("Country: " + wrld.CountryName + "\n"
//                            + "Continent: " + wrld.Continent + "\n"
//                            + "Region: " + wrld.Region + "\n"
//                            + "Population: " + wrld.CountryPopulation + "\n"
//                            + "Capital: " + wrld.Capital + "\n"
//                            + "Country Code: " + wrld.Code + "\n"
//                            + "Country Code 2: " + wrld.Code2);
//        }
//    }

    public void printOutput(ArrayList<World> country)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp No", "First Name", "Last Name", "Salary"));
        // Loop over all employees in the list
        for (World wrld : country)
        {
            String wrld_str =
                    String.format("%-10s %-15s %-20s %-8s",
                            wrld.CountryName, wrld.Continent, wrld.Region, wrld.CountryPopulation, wrld.Capital, wrld.Code, wrld.Code2);
            System.out.println(wrld_str);
        }
    }
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        // Get Employee
        //Employee emp = a.getEmployee(255530);
        // Display results
        //a.displayEmployee(emp);

        ArrayList<World> wrld = a.getCountryWorld();
        a.printOutput(wrld);

        // Disconnect from database
        a.disconnect();
    }
//
//
//    public static void main(String[] args)
//    {
//        try
//        {
//            // Load Database driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        }
//        catch (ClassNotFoundException e)
//        {
//            System.out.println("Could not load SQL driver");
//            System.exit(-1);
//        }
//
//        // Connection to the database
//        Connection con = null;
//        int retries = 100;
//        for (int i = 0; i < retries; ++i)
//        {
//            System.out.println("Connecting to database...");
//            try
//            {
//                // Wait a bit for db to start
//                Thread.sleep(30000);
//                // Connect to database
//                con = DriverManager.getConnection("jdbc:mysql://db:3306/world", "root", "group3");
//                System.out.println("Successfully connected");
//                // Wait a bit
//                Thread.sleep(10000);
//                // Exit for loop
//                break;
//            }
//            catch (SQLException sql)
//            {
//                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
//                System.out.println(sqle.getMessage());
//            }
//            catch (InterruptedException ie)
//            {
//                System.out.println("Thread interrupted? Should not happen.");
//            }
//        }
//
//        if (con != null)
//        {
//            try
//            {
//                // Close connection
//                con.close();
//            }
//            catch (Exception e)
//            {
//                System.out.println("Error closing connection to database");
//            }
//        }
//    }
}