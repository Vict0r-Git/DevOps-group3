package com.napier.dev;
import java.sql.*;
import java.util.ArrayList;
public class App {
    public Connection con = null;

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

    public static void printCyanMessage(String message) {
        // ANSI escape code for red text
        String redColor = "\u001B[36m";
        // ANSI escape code to reset text color to default
        String resetColor = "\u001B[0m";

        // Print the message in red
        System.out.println("\n" + redColor + message + resetColor + "\n");
    }

    /**
     * All the countries in the world organised by largest population to smallest.
     * @return
     */
    public ArrayList<World> getCountryWorld() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Continent, Code, Capital, Region, Population FROM country ORDER BY Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<World> country = new ArrayList<>();
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


    /**
     * All the countries in a continent organised by largest population to smallest.
     * @return
     */
    public ArrayList<World> getCountryCont() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Continent, Code, Capital, Region, Population "
                            + "FROM country "
                            + "WHERE Continent = '"
                            + "Asia" +
                            "' ORDER BY Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<World> country = new ArrayList<>();
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
            System.out.println("Failed to get country details in world");
            return null;
        }
    }


    /**
     * All the countries in a region organised by largest population to smallest.
     * @return
     */
    public ArrayList<World> getCountryRegion() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Continent, Code, Capital, Region, Population "
                            + "FROM country "
                            + "WHERE Region = '"
                            + "Southeast Asia" +
                            "' ORDER BY Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<World> country = new ArrayList<>();
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
            System.out.println("Failed to get region details in world");
            return null;
        }
    }


    /**
     * All the cities in the world organised by largest population to smallest.
     * @return
     */
    public  ArrayList<World> getCityWorld(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.District, city.Population " +
                            "FROM country, city " +
                            "WHERE country.Code = city.CountryCode " +
                            "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<World> city = new ArrayList<>();
            while (rset.next()) {
                World wrld = new World();
                wrld.CityName = rset.getString("Name");
                wrld.CountryName = rset.getString("Country");
                wrld.District = rset.getString("District");
                wrld.CityPopulation = rset.getInt("Population");
                city.add(wrld);
            }
            return city;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities' details in world");
            return null;
        }
    }

    /**
     * All the cities in a continent organised by largest population to smallest
     * @return
     */
    public  ArrayList<World> getCitiesByCont(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, " +
                            "city.Population " +
                            "FROM world.city " +
                            "JOIN world.country ON city.CountryCode = country.Code " +
                            "WHERE country.Continent = 'Asia'" +
                            "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<World> citybycont = new ArrayList<>();
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
            System.out.println("Failed to get cities' details by continent");
            return null;
        }

    }

    /**
     * All the cities in a region organised by largest population to smallest.
     * @return
     */
    public  ArrayList<World> getCitiesByRegion(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, city.Population " +
                            "FROM world.city " +
                            "JOIN world.country ON city.CountryCode = country.Code " +
                            "WHERE country.Region = 'Southern and Central Asia'" +
                            "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<World> citybyregion = new ArrayList<>();
            while (rset.next()) {
                World wrld = new World();
                wrld.CityName = rset.getString("Name");
                wrld.CountryName = rset.getString("Country");
                wrld.District = rset.getString("District");
                wrld.CityPopulation = rset.getInt("Population");
                citybyregion.add(wrld);
            }
            return citybyregion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities' details by region");
            return null;
        }

    }

    /**
     * All the cities in a country organised by largest population to smallest.
     * @return
     */
    public  ArrayList<World> getCitiesByCountry(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, city.Population " +
                            "FROM world.city " +
                            "JOIN world.country ON city.CountryCode = country.Code " +
                            "WHERE country.Name = 'Myanmar'" +
                            "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<World> citybyregion = new ArrayList<>();
            while (rset.next()) {
                World wrld = new World();
                wrld.CityName = rset.getString("Name");
                wrld.CountryName = rset.getString("Country");
                wrld.District = rset.getString("District");
                wrld.CityPopulation = rset.getInt("Population");
                citybyregion.add(wrld);

            }
            return citybyregion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities' details by country");
            return null;
        }

    }

    /**
     * All the cities in a district organised by largest population to smallest.
     * @return city by region
     */

    public  ArrayList<World> getCitiesByDistrict(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, city.Population " +
                            "FROM world.city " +
                            "JOIN world.country ON city.CountryCode = country.Code " +
                            "WHERE city.District = 'Rangoon [Yangon]'" +
                            "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<World> citybyregion = new ArrayList<>();
            while (rset.next()) {
                World wrld = new World();
                wrld.CityName = rset.getString("Name");
                wrld.CountryName = rset.getString("Country");
                wrld.District = rset.getString("District");
                wrld.CityPopulation = rset.getInt("Population");
                citybyregion.add(wrld);
            }
            return citybyregion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities' details by district");
            return null;
        }

    }

    // Print out the data
    public void displayCountry(ArrayList<World> country) {
        // Print header
        System.out.printf("%-5s %-49s %-14s %-25s %-13s %-10s%n",
                "Code", "Name", "Continent", "Region", "Population", "Capital");

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
        System.out.printf("%-37s %-49s %-23s %-25s%n",
                "Name", "Country", "District", "Population");

        // Loop over all cities in the list
        for (World wrld : city) {
            String wrld_str =
                    String.format("%-37s %-49s %-23s %-25s",
                            wrld.CityName, wrld.CountryName, wrld.District, wrld.CityPopulation);
            System.out.println(wrld_str);
        }
    }
    public void DisplayCapitalCity(ArrayList<World> capital){
        // Print header
        System.out.printf("%-37s %-49s %-13s%n",
                "Name", "Country", "Population");

        // Loop over all cities in the list
        for (World wrld : capital) {
            String wrld_str =
                    String.format("%-37s %-49s %-13s",
                            wrld.CityName, wrld.CountryName, wrld.CityPopulation);
            System.out.println(wrld_str);
        }
    }



    public void CR2(){
        ArrayList<World> country;
        ArrayList<World> CT;
        ArrayList<World> CapitalCity;

        printCyanMessage("All the countries in the world organized by largest to smallest population");
        country = getCountryWorld();
        displayCountry(country);

        printCyanMessage("All the countries in a continent organized by largest to smallest population");
        country = getCountryCont();
        displayCountry(country);

        printCyanMessage("All the countries in a region organized by largest to smallest population");
        country = getCountryRegion();
        displayCountry(country);

        printCyanMessage("All the Cities in the world organized by largest to smallest population");
        CT = getCityWorld();
        DisplayCities(CT);

        printCyanMessage("All the Cities in a continent organized by largest to smallest population");
        CT = getCitiesByCont();
        DisplayCities(CT);

        printCyanMessage("All the Cities in a region organized by largest to smallest population");
        CT = getCitiesByRegion();
        DisplayCities(CT);

        printCyanMessage("All the Cities in a Country organized by largest to smallest population");
        CT = getCitiesByCountry();
        DisplayCities(CT);

        printCyanMessage("All the Cities in a District organized by largest to smallest population");
        CT = getCitiesByDistrict();
        DisplayCities(CT);
    }


    /**
     * main class
     */
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Code Review 1
        a.CR2();

        // Disconnect from database
        a.disconnect();
    }
}