package com.napier.dev;

import java.sql.*;
import java.util.ArrayList;
public class App {
    public static Connection con = null;
    public void connect(String location, int delay, String driver) {
        try {
            // Load Database driver
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver :" + e.getMessage());
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "group3");
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

    /**
     * A method to output print messages with cyan color
     * @param message Get a string message to print
     */
    public static void printCyanMessage(String message) {
        // ANSI escape code for red text
        String redColor = "\u001B[36m";
        // ANSI escape code to reset text color to default
        String resetColor = "\u001B[0m";
        if (message == null)
        {
            System.out.println("Nothing to print");
        }
        // Print the message in red
        System.out.println("\n" + redColor + message + resetColor + "\n");
    }

    /**
     * All the countries in the world organised by largest population to smallest.
     * @return An array list of all the countries in the world
     * ordered by population in descending order.
     */
    public ArrayList<World> getCountryWorld() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Continent, Code, Capital, Region, Population " +
                            "FROM country " +
                            "ORDER BY Population DESC";

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> country = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCountryName(result.getString("country.Name"));
                world.setContinent(result.getString("country.Continent"));
                world.setRegion(result.getString("country.Region"));
                world.setCountryPopulation(result.getInt("country.Population"));
                world.setCapital(result.getInt("country.Capital"));
                world.setCode(result.getString("country.code"));
                country.add(world);

            }
            return country;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
            return null;
        }
    }

    public ArrayList<World> getTopCountryWorld(int countryCount){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Continent, Code, Capital, Region, Population FROM country ORDER BY Population DESC"
                            + " LIMIT " + countryCount;
            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> topCountries = new ArrayList<>();
            while (result.next()){
                World world = new World();
                world.setCountryName(result.getString("country.Name"));
                world.setContinent(result.getString("country.Continent"));
                world.setRegion(result.getString("country.Region"));
                world.setCountryPopulation(result.getInt("country.Population"));
                world.setCapital(result.getInt("country.Capital"));
                world.setCode(result.getString("country.Code"));
                topCountries.add(world);
            }
            return topCountries;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
            return null;
        }
    }


    /**
     * All the countries in a continent organised by largest population to smallest.
     * @return An array list of all the countries in a continent 'Asia'
     * ordered by population in descending order.
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

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> countryCont = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCountryName(result.getString("country.Name"));
                world.setContinent(result.getString("country.Continent"));
                world.setRegion(result.getString("country.Region"));
                world.setCountryPopulation(result.getInt("country.Population"));
                world.setCapital(result.getInt("country.Capital"));
                world.setCode(result.getString("country.Code"));
                countryCont.add(world);

            }
            return countryCont;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in world");
            return null;
        }
    }


    public ArrayList<World> getTopCountryByCont(int countryCount){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Continent, Code, Capital, Region, Population "
                            + "FROM country "
                            + "WHERE Continent = 'Asia'"
                            + " ORDER BY Population DESC "
                            + "LIMIT " + countryCount;

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> topCountryCont = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCountryName(result.getString("country.Name"));
                world.setContinent(result.getString("country.Continent"));
                world.setRegion(result.getString("country.Region"));
                world.setCountryPopulation(result.getInt("country.Population"));
                world.setCapital(result.getInt("country.Capital"));
                world.setCode(result.getString("country.Code"));
                topCountryCont.add(world);

            }
            return topCountryCont;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in world");
            return null;
        }
    }


    /**
     * All the countries in a region organised by largest population to smallest.
     * @return An array list of all the countries in a region 'Southeast Asia'
     * ordered by population in descending order.
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

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> countryRegion = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCountryName(result.getString("country.Name"));
                world.setContinent(result.getString("country.Continent"));
                world.setRegion(result.getString("country.Region"));
                world.setCountryPopulation(result.getInt("country.Population"));
                world.setCapital(result.getInt("country.Capital"));
                world.setCode(result.getString("country.Code"));
                countryRegion.add(world);

            }
            return countryRegion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region details in world");
            return null;
        }
    }

    public ArrayList<World> getTopCountryByRegion(int countryCount){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, Continent, Code, Capital, Region, Population "
                            + "FROM country "
                            + "WHERE Region = '"
                            + "Southeast Asia" +
                            "' ORDER BY Population DESC "
                            + "LIMIT " + countryCount;

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> topCountryRegion = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCountryName(result.getString("country.Name"));
                world.setContinent(result.getString("country.Continent"));
                world.setRegion(result.getString("country.Region"));
                world.setCountryPopulation(result.getInt("country.Population"));
                world.setCapital(result.getInt("country.Capital"));
                world.setCode(result.getString("country.Code"));
                topCountryRegion.add(world);

            }
            return topCountryRegion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in world");
            return null;
        }
    }


    /**
     * All the cities in the world organised by largest population to smallest.
     * @return An array list of all the cities the world
     * ordered by population in descending order.
     */
    public  ArrayList<World> getCityWorld(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.District, city.Population " +
                            "FROM country, city " +
                            "WHERE country.Code = city.CountryCode " +
                            "ORDER BY city.Population DESC";

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> city = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setDistrict(result.getString("District"));
                world.setCityPopulation(result.getInt("Population"));
                city.add(world);
            }
            return city;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities' details in world");
            return null;
        }
    }

    public ArrayList<World> getTopCitiesWorld(int countryCount){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.District, city.Population " +
                            "FROM city, country " +
                            "WHERE country.Code = city.CountryCode " +
                            "ORDER BY Population DESC " +
                            "LIMIT " + countryCount;
            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> topCityWorld = new ArrayList<>();
            while (result.next()){
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setDistrict(result.getString("District"));
                world.setCityPopulation(result.getInt("Population"));
                topCityWorld.add(world);
            }
            return topCityWorld;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
            return null;
        }
    }

    /**
     * All the cities in a continent organised by largest population to smallest
     * @return An array list of all the cities in a continent 'Asia'
     * ordered by population in descending order.
     */
    public  ArrayList<World> getCitiesByCont(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, " +
                            "city.Population " +
                            "FROM world.city " +
                            "JOIN world.country ON city.CountryCode = country.Code " +
                            "WHERE country.Continent = 'Asia' " +
                            "ORDER BY city.Population DESC";

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> cityByCont = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setDistrict(result.getString("District"));
                world.setCityPopulation(result.getInt("Population"));
                cityByCont.add(world);
            }
            return cityByCont;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities' details by continent");
            return null;
        }

    }

    public ArrayList<World> getTopCitiesByCont(int countryCount){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.District, city.Population " +
                            "FROM city, country " +
                            "WHERE country.Code = city.CountryCode " +
                            "AND country.Continent = 'Asia' " +
                            "ORDER BY Population DESC LIMIT " +
                            countryCount;

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> topCityByCont = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setDistrict(result.getString("District"));
                world.setCityPopulation(result.getInt("Population"));
                topCityByCont.add(world);
            }
            return topCityByCont;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in world");
            return null;
        }
    }


    /**
     * All the cities in a region organised by largest population to smallest.
     * @return An array list of all the cities in a region 'Southern and Central Asia'
     * ordered by population in descending order.
     */
    public  ArrayList<World> getCitiesByRegion(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, city.Population " +
                            "FROM world.city " +
                            "JOIN world.country ON city.CountryCode = country.Code " +
                            "WHERE country.Region = 'Southern and Central Asia' " +
                            "ORDER BY city.Population DESC";

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> cityByRegion = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setDistrict(result.getString("District"));
                world.setCityPopulation(result.getInt("Population"));
                cityByRegion.add(world);
            }
            return cityByRegion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities' details by region");
            return null;
        }

    }

    public ArrayList<World> getTopCitiesByRegion(int countryCount){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, " +
                            "city.Population " +
                            "FROM world.city " +
                            "JOIN world.country ON city.CountryCode = country.Code " +
                            "WHERE country.Region = 'Southeast Asia' " +
                            "ORDER BY city.Population DESC LIMIt " + countryCount;

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> topCityByRegion = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setDistrict(result.getString("District"));
                world.setCityPopulation(result.getInt("Population"));
                topCityByRegion.add(world);
            }
            return topCityByRegion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in world");
            return null;
        }
    }


    /**
     * All the cities in a country organised by largest population to smallest.
     * @return An array list of all the cities in a country 'Myanmar'
     * ordered by population in descending order.
     */
    public  ArrayList<World> getCitiesByCountry(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, city.Population " +
                            "FROM world.city " +
                            "JOIN world.country ON city.CountryCode = country.Code " +
                            "WHERE country.Name = 'Myanmar' " +
                            "ORDER BY city.Population DESC";

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> cityByCountry = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setDistrict(result.getString("District"));
                world.setCityPopulation(result.getInt("Population"));
                cityByCountry.add(world);

            }
            return cityByCountry;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities' details by country");
            return null;
        }

    }

    public ArrayList<World> getTopCitiesByCountry(int countryCount){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, city.Population " +
                            "FROM world.city " +
                            "JOIN world.country " +
                            "ON city.CountryCode = country.Code " +
                            "WHERE country.Name = 'Myanmar' " +
                            "ORDER BY city.Population " +
                            "DESC LIMIt " + countryCount;

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> topCityByCountry = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setDistrict(result.getString("District"));
                world.setCityPopulation(result.getInt("Population"));
                topCityByCountry.add(world);
            }
            return topCityByCountry;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in world");
            return null;
        }
    }


    /**
     * All the cities in a district organised by largest population to smallest.
     * @return An array list of all the cities in a district 'Rangoon [Yangon]'
     * ordered by population in descending order.
     */
    public  ArrayList<World> getCitiesByDistrict(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, city.Population " +
                            "FROM world.city " +
                            "JOIN world.country ON city.CountryCode = country.Code " +
                            "WHERE city.District = 'Rangoon [Yangon]' " +
                            "ORDER BY city.Population DESC";

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> cityByDistrict = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setDistrict(result.getString("District"));
                world.setCityPopulation(result.getInt("Population"));
                cityByDistrict.add(world);
            }
            return cityByDistrict;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities' details by district");
            return null;
        }

    }

    public ArrayList<World> getTopCitiesByDistrict(int countryCount){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name AS Name, country.Name AS Country, city.District, city.Population " +
                            "FROM world.city "+
                            "JOIN world.country ON city.CountryCode = country.Code " +
                            "WHERE city.District = 'Rangoon [Yangon]' " +
                            " ORDER BY city.Population DESC LIMIt " + countryCount;

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> topCityByDistrict = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setDistrict(result.getString("District"));
                world.setCityPopulation(result.getInt("Population"));
                topCityByDistrict.add(world);
            }
            return topCityByDistrict;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in world");
            return null;
        }
    }

    public ArrayList<World> getTopCapitalCitiesWorld(int countryCount){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.Population " +
                            "FROM city, country " +
                            "WHERE country.Capital = city.ID " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + countryCount;
            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> topCityWorld = new ArrayList<>();
            while (result.next()){
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setCityPopulation(result.getInt("Population"));
                topCityWorld.add(world);
            }
            return topCityWorld;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
            return null;
        }
    }

    public ArrayList<World> getTopCapitalCitiesCont(int countryCount){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.Population, country.Continent " +
                            "FROM city, country " +
                            "WHERE country.Capital = city.ID " +
                            "AND country.Continent = 'Asia' " +
                            "ORDER BY country.Continent, city.Population DESC " +
                            "LIMIT " + countryCount;

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> country = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setCityPopulation(result.getInt("Population"));
                country.add(world);
            }
            return country;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in world");
            return null;
        }
    }

    public ArrayList<World> getTopCapitalCitiesRegion(int countryCount){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.Population, country.Continent " +
                            "FROM city, country " +
                            "WHERE country.Capital = city.ID " +
                            "AND country.Region = 'Southeast Asia' " +
                            "ORDER BY country.Continent, city.Population DESC " +
                            "LIMIT " + countryCount;

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> country = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setCityPopulation(result.getInt("Population"));
                country.add(world);
            }
            return country;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details in world");
            return null;
        }
    }


    /**
     * All the capital cities in the world organised by largest population to smallest.
     * @return An array list of all capital cities in the world
     * ordered by population in descending order.
     */
    public  ArrayList<World> getCapitalCityWorld(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.Population " +
                            "FROM city, country " +
                            "WHERE country.Capital = city.ID " +
                            "ORDER BY city.Population DESC";

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> capitalCity = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setCityPopulation(result.getInt("population"));
                capitalCity.add(world);

            }
            return capitalCity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in world details");
            return null;
        }
    }

    /**
     * All the capital cities in a continent organised by largest population to smallest.
     * @return An array list of all capital cities in a continent
     * ordered by population in descending order.
     */
    public  ArrayList<World> getCapitalCityCont(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.Population, country.Continent " +
                            "FROM city, country " +
                            "WHERE country.Capital = city.ID " +
                            "AND country.Continent = 'Asia' " +
                            "ORDER BY country.Continent, city.Population DESC;";

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> capitalCityCont = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setCityPopulation(result.getInt("population"));
                capitalCityCont.add(world);

            }
            return capitalCityCont;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in world details");
            return null;
        }
    }

    /**
     * All the capital cities in a region organised by largest to smallest.
     * @return An array list of all capital cities in a region
     * ordered by population in descending order.
     */
    public  ArrayList<World> getCapitalCityRegion(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.Population, country.Region " +
                            "FROM city, country " +
                            "WHERE country.Capital = city.ID " +
                            "AND country.Region = 'Eastern Asia' " +
                            "ORDER BY country.Region, city.Population DESC;";

            ResultSet result = stmt.executeQuery(strSelect);
            ArrayList<World> capitalCityRegion = new ArrayList<>();
            while (result.next()) {
                World world = new World();
                world.setCityName(result.getString("Name"));
                world.setCountryName(result.getString("Country"));
                world.setCityPopulation(result.getInt("population"));
                capitalCityRegion.add(world);

            }
            return capitalCityRegion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in world details");
            return null;
        }
    }

    /*
        displayCountry() method gets parameter as an array list contains countries' data
        and output them under the following columns.
        Columns: "Code", "Name", "Continent", "Region", "Population", "Capital"
     */
    public void displayCountry(ArrayList<World> country) {
        if (country == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.printf("%-5s %-49s %-14s %-25s %-13s %10s%n",
                "Code", "Name", "Continent", "Region", "Population", "Capital");

        // Loop over all countries in the list
        for (World world : country)
        {
            if (world == null)
                continue;
            String world_str =
                    String.format("%-5s %-49s %-14s %-25s %-13s %10s",
                            world.getCode(), world.getCountryName(), world.getContinent(), world.getRegion(), world.getCountryPopulation(), world.getCapital());
            System.out.println(world_str);
        }
    }

    /*
        displayCities() method gets parameter as an array list contains cities' data
        and output them under the following columns.
        Columns: "Name", "Country", "District", "Population"
     */
    public void displayCities(ArrayList<World> city) {
        if (city == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-37s %-49s %-23s %25s%n",
                "Name", "Country", "District", "Population");

        // Loop over all cities in the list
        for (World world : city)
        {
            if (world == null)
            {
                System.out.println("Data is null in city.");
                continue;
            }
            String world_str = String.format("%-37s %-49s %-23s %25s", world.getCityName(), world.getCountryName(), world.getDistrict(), world.getCityPopulation());
            System.out.println(world_str);
        }
    }

    /*
        displayCapitalCities() method gets parameter as an array list contains capital cities' data
        and output them under the following columns.
        Columns: "Name", "Country", "Population"
     */
    public void displayCapitalCities(ArrayList<World> capital){
        if (capital == null)
        {
            System.out.println("No capital cities");
            return;
        }
        // Print header
        System.out.printf("%-37s %-49s %13s%n",
                "Name", "Country", "Population");

        // Loop over all cities in the list
        for (World world : capital) {
            if (world == null)
            {
                System.out.println("Data is null in capital.");
                continue;
            }
            System.out.println("Data is null in capital.");
            String world_str = String.format("%-37s %-49s %13s", world.getCityName(), world.getCountryName(), world.getCityPopulation());
            System.out.println(world_str);
        }
    }


    /*
        The method CR2() represent for the code review 2
        Grouped methods to output required tasks
     */
    public void CR2(){
        ArrayList<World> country;
        ArrayList<World> city;

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
        city = getCityWorld();
        displayCities(city);

        printCyanMessage("All the Cities in a continent organized by largest to smallest population");
        city = getCitiesByCont();
        displayCities(city);

        printCyanMessage("All the Cities in a region organized by largest to smallest population");
        city = getCitiesByRegion();
        displayCities(city);

        printCyanMessage("All the Cities in a Country organized by largest to smallest population");
        city = getCitiesByCountry();
        displayCities(city);

        printCyanMessage("All the Cities in a District organized by largest to smallest population");
        city = getCitiesByDistrict();
        displayCities(city);
    }

    /*
        The method CR3() represent for the code review 2
     */
    public void CR3(){
        // Create a CapitalCity array list
        ArrayList<World> CapitalCity;
        ArrayList<World> country;
        ArrayList<World> city;

        printCyanMessage("All the capital cities in the world organised by largest population to smallest.");
        CapitalCity = getCapitalCityWorld();
        displayCapitalCities(CapitalCity);

        printCyanMessage("All the capital cities in a continent organised by largest population to smallest.");
        CapitalCity = getCapitalCityCont();
        displayCapitalCities(CapitalCity);

        printCyanMessage("All the capital cities in a region organised by largest to smallest.");
        CapitalCity = getCapitalCityRegion();
        displayCapitalCities(CapitalCity);

        printCyanMessage("Top 15 countries in the world organised by largest population to smallest.");
        country = getTopCountryWorld(15);
        displayCountry(country);

        printCyanMessage("Top 15 countries in a Continent organised by largest population to smallest.");
        country = getTopCountryByCont(15);
        displayCountry(country);

        printCyanMessage("Top 15 countries in a Region organised by largest population to smallest.");
        country = getTopCountryByCont(15);
        displayCountry(country);

        printCyanMessage("Top 15 Cities in the World organised by largest population to smallest.");
        city = getTopCitiesWorld(15);
        displayCities(city);
    }

    /**
     * The main entry point for the application. It creates an instance of the App class,
     * connects to the database, performs code reviews, and then disconnects from the database.
     * @param args The command-line arguments passed to the application. But it is not used in here.
     */
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        String driver = "com.mysql.cj.jdbc.Driver";

        if(args.length < 2){
            a.connect("localhost:33060", 30000, driver);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]), driver);
        }

        // Code Review 2
        a.CR2();
        // Code Review 3
        a.CR3();

        // Disconnect from database
        a.disconnect();
    }
}