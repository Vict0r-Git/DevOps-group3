/**
 *  Description: This is the Integration Testing file for the world app
 *  which is tested for the interaction between database and the program files.
 *  Author: Paing Thet Kyaw and Yé Min Than
 */
package com.napier.dev;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class represents the integration tests for the App class.
 * It tests various methods related to retrieving country and city data.
 */
public class AppIntegrationTest {
    // Location of the database
    private static final String DB_LOCATION = "localhost:33060";
    // Database connection delay in seconds
    private static final int DB_DELAY = 30000;
    // Database SQL driver
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static App app;

    /**
     *  Set up the database connection first before testing started
     */
    @BeforeAll
    public static void setUpBeforeTesting() {
        app = new App();
        app.connect(DB_LOCATION, DB_DELAY, DB_DRIVER);
    }

    /**
     *  Disconnect connection after the testing steps are done
     */
    @AfterAll
    public static void disconnectAfterTesting() {
        if (app.con != null) {
            app.disconnect();
        }
    }

    /**
     *  Testing the connect() method
     */
    @Test
    void testConnect() {
        // Test whether app.con is NOT NULL, and actually establishing connection link to database
        assertNotNull(app.con);
    }

    /**
     *  Testing the getCountryWorld method
     */
    @Test
    void testGetCountryWorld() {
        // Store the data
        ArrayList<World> countries = app.getCountryWorld();
        // Test the list is not null
        assertNotNull(countries);
        // Test for empty list
        Assertions.assertFalse(countries.isEmpty());
    }


    /**
     *  Test for every exception throw in each method
     */
    @Test
    void connectionException()
    {
        // Cut out the current connection to null and connect back later
        app.con = null;
        // Testing for Country exception
        assertNull(app.getCountryWorld());
        assertNull(app.getCountryCont());
        assertNull(app.getCountryRegion());

        // Testing for Cities exception
        assertNull(app.getCityWorld());
        assertNull(app.getCitiesByCountry());
        assertNull(app.getCitiesByRegion());
        assertNull(app.getCitiesByCont());
        assertNull(app.getCitiesByDistrict());

        // Testing for Capital City exception
        assertNull(app.getCapitalCityWorld());
        assertNull(app.getCapitalCityCont());
        assertNull(app.getCapitalCityRegion());

        // Testing for Top 15 output
        assertNull(app.getTopCountryWorld(15));
        assertNull(app.getTopCountryByRegion(15));
        assertNull(app.getTopCountryByCont(15));

        assertNull(app.getTopCitiesWorld(15));
        assertNull(app.getTopCitiesByCont(15));
        assertNull(app.getTopCitiesByCountry(15));
        assertNull(app.getTopCitiesByRegion(15));
        assertNull(app.getTopCitiesByDistrict(15));

        assertNull(app.getTopCapitalCitiesWorld(15));
        assertNull(app.getTopCapitalCitiesCont(15));
        assertNull(app.getTopCapitalCitiesRegion(15));

        // Testing for Population Ratio exception
        assertNull((app.getPopulationOfPeopleCountryRatio()));
        assertNull((app.getPopulationOfPeopleRegionRatio()));
        assertNull((app.getPopulationOfPeopleContinentRatio()));

        // Testing for Country Language exception
        assertNull((app.getLanguageCountry()));

        AppIntegrationTest.setUpBeforeTesting();
    }


    /**
     *  This method test for the thread interrupt exception in connection
     */
    @Test
    void testConnectInterruptedException() {
        App app = new App();
        Thread.currentThread().interrupt(); // Simulate interruption
        AppIntegrationTest.setUpBeforeTesting();
    }

    @Test
    void testSQLException()
    {
        app.connect("invalidlocation", 5, DB_DRIVER);
        AppIntegrationTest.setUpBeforeTesting();
    }

    @Test
    void testClassNotFoundException() {
        App app = new App();
        app.con = null;
        // Simulate the nonexistent driver name to get exception error
        app.connect(DB_LOCATION, DB_DELAY, "com.nonexistent.jdbc.Driver");
        // And then reloaded the correct driver back to continue the connection
        app.connect(DB_LOCATION, DB_DELAY, DB_DRIVER);
    }



    /**
     *  This method test for the getCountryCont method in App.java
     */
    @Test
    void testGetCountryCont() {
        // Retrieve list of countries from the application
        ArrayList<World> countries = app.getCountryCont();
        // Ensure that the list is not null
        assertNotNull(countries);
        // Assert that the list is not empty
        Assertions.assertFalse(countries.isEmpty());
    }

    /**
     *  This method test for the getCountryRegion method in App.java
     */
    @Test
    void testGetCountryRegion() {
        // Retrieve list of countries by region from the application
        ArrayList<World> countries = app.getCountryRegion();
        // Ensure that the list is not null
        assertNotNull(countries);
        // Assert that the list is not empty
        Assertions.assertFalse(countries.isEmpty());
    }

    /**
     *  This method test for the getCityWorld method in App.java
     */
    @Test
    void testGetCityWorld() {
        // Retrieve list of cities from the application
        ArrayList<World> cities = app.getCityWorld();
        // Ensure that the list is not null
        assertNotNull(cities);
        // Assert that the list is not empty
        Assertions.assertFalse(cities.isEmpty());
    }

    /**
     *  This method test for the getCityByCont method in App.java
     */
    @Test
    void testGetCitiesByCont()  {
        // Retrieve list of cities by continent from the application
        ArrayList<World> cities = app.getCitiesByCont();
        // Ensure that the list is not null
        assertNotNull(cities);
        // Assert that the list is not empty
        assertFalse(cities.isEmpty());
    }

    /**
     *  This method test for the getCityByRegion method in App.java
     */
    @Test
    void testGetCitiesByRegion()  {
        // Retrieve list of cities by region from the application
        ArrayList<World> cities = app.getCitiesByRegion();
        // Ensure that the list is not null
        assertNotNull(cities);
        // Assert that the list is not empty
        Assertions.assertFalse(cities.isEmpty());
    }

    /**
     *  This method test for the getCityByCountry method in App.java
     */
    @Test
    void testGetCitiesByCountry()  {
        // Retrieve list of cities by country from the application
        ArrayList<World> cities = app.getCitiesByCountry();
        // Ensure that the list is not null
        assertNotNull(cities);
        // Assert that the list is not empty
        Assertions.assertFalse(cities.isEmpty());
    }

    /**
     *  This method test for the getCityByDistrict method in App.java
     */
    @Test
    void testGetCitiesByDistrict()  {
        // Retrieve list of cities by district from the application
        ArrayList<World> cities = app.getCitiesByDistrict();
        // Ensure that the list is not null
        assertNotNull(cities);
        // Assert that the list is not empty
        Assertions.assertFalse(cities.isEmpty());
    }

    /**
     *  This method test for the getCapitalCityWorld method in App.java
     */
    @Test
    void testGetCapitalCityWorld()  {
        // Retrieve list of capital cities from the application
        ArrayList<World> capitals = app.getCapitalCityWorld();
        // Ensure that the list is not null
        assertNotNull(capitals);
        // Assert that the list is not empty
        Assertions.assertFalse(capitals.isEmpty());
    }

    /**
     *  This method test for the getCapitalCityCont method in App.java
     */
    @Test
    void testGetCapitalCityCont()  {
        // Retrieve list of capital cities by continent from the application
        ArrayList<World> capitals = app.getCapitalCityCont();
        // Ensure that the list is not null
        assertNotNull(capitals);
        // Assert that the list is not empty
        Assertions.assertFalse(capitals.isEmpty());
    }

    /**
     *  This method test for the getCapitalCityRegion method in App.java
     */
    @Test
    void testGetCapitalCityRegion()  {
        // Retrieve list of capital cities by region from the application
        ArrayList<World> capitals = app.getCapitalCityRegion();
        // Ensure that the list is not null
        assertNotNull(capitals);
        // Assert that the list is not empty
        Assertions.assertFalse(capitals.isEmpty());
    }

    /**
     *  This method test for the getPopulationOfPeopleContinentRatio() method in App.java
     */
    @Test
    void testGetPopulationOfPeopleContinentRatio(){
        // Retrieve list of population by country from the application
        ArrayList<PopulationRatio> pop_ratio = app.getPopulationOfPeopleContinentRatio();
        // Ensure that the list is not null
        assertNotNull(pop_ratio);
        // Assert that the list is not empty
        Assertions.assertFalse(pop_ratio.isEmpty());
    }

    /**
     *  This method test for the getPopulationOfPeopleRegionRatio() method in App.java
     */
    @Test
    void testGetPopulationOfPeopleRegionRatio(){
        // Retrieve list of population by country from the application
        ArrayList<PopulationRatio> pop_ratio = app.getPopulationOfPeopleRegionRatio();
        // Ensure that the list is not null
        assertNotNull(pop_ratio);
        // Assert that the list is not empty
        Assertions.assertFalse(pop_ratio.isEmpty());
    }

    /**
     *  This method test for the getPopulationOfPeopleCountryRatio() method in App.java
     */
    @Test
    void testGetPopulationOfPeopleCountryRatio(){
        // Retrieve list of population by country from the application
        ArrayList<PopulationRatio> pop_ratio = app.getPopulationOfPeopleCountryRatio();
        // Ensure that the list is not null
        assertNotNull(pop_ratio);
        // Assert that the list is not empty
        Assertions.assertFalse(pop_ratio.isEmpty());
    }

    /**
     *  This method test for the getLanguageCountry() method in App.java
     */
    @Test
    void testGetLanguageCountry(){
        // Retrieve list of country languages from the application
        ArrayList<World> country_lan = app.getLanguageCountry();
        // Ensure that the list is not null
        assertNotNull(country_lan);
        // Assert that the list is not empty
        Assertions.assertFalse(country_lan.isEmpty());
    }


    /**
     *  This method test for the CR2 method, all method calls' arry lists under the CR2 method are tested
     *  whether they are not null and works correctly.
     */
    @Test
    void testCR2ArrayListsAreNotNull()
    {
        // Call the CR2, Code Review 2 method
        app.CR2();
        // Assert that each array list is null
        assertNotNull(app.getCountryWorld());
        assertNotNull(app.getCountryCont());
        assertNotNull(app.getCountryRegion());
        assertNotNull(app.getCityWorld());
        assertNotNull(app.getCitiesByCont());
        assertNotNull(app.getCitiesByRegion());
        assertNotNull(app.getCitiesByCountry());
        assertNotNull(app.getCitiesByDistrict());
    }

    /**
     *  This method test for the CR3 method, all method calls' array lists under the CR3 method are tested
     *  whether they are not null and works correctly.
     */
    @Test
    void testCR3ArrayListsAreNotNull()
    {
        // Call the CR3, Code Review method
        app.CR3();
        // Assert that each array list is null
        assertNotNull(app.getCapitalCityWorld());
        assertNotNull(app.getCapitalCityCont());
        assertNotNull(app.getCapitalCityRegion());
        assertNotNull(app.getTopCountryWorld(15));
        assertNotNull(app.getTopCountryByCont(15));
        assertNotNull(app.getTopCitiesWorld(15));
        assertNotNull(app.getTopCitiesWorld(15));
    }

    /**
     *  This method test for the CR4 method, all method calls' array lists under the CR4 method are tested
     *  whether they are not null and works correctly.
     */
    @Test
    void testCR4ArrayListsAreNotNull()
    {
        // Call the CR3, Code Review method
        app.CR4();
        // Assert that each array list is null
        assertNotNull(app.getPopulationOfPeopleCountryRatio());
        assertNotNull(app.getPopulationOfPeopleRegionRatio());
        assertNotNull(app.getPopulationOfPeopleContinentRatio());
        assertNotNull(app.getLanguageCountry());
    }

    @Test
    void testGetCountryWorldTopAndBottom()
    {
        ArrayList<World> country = app.getCountryWorld();
        World topCountry = country.get(0);
        if ("China".equals(topCountry.getCountryName()) && "Asia".equals(topCountry.getContinent()) &&
                "CHN".equals(topCountry.getCode()) && "Eastern Asia".equals(topCountry.getRegion())) {
            if (country.size()>1){
                World botCountry = country.get(country.size()-1);
                if ("United States Minor Outlying Islands".equals(botCountry.getCountryName()) &&
                        "Oceania".equals(botCountry.getContinent()) && "UMI".equals(botCountry.getCode()) &&
                        "Micronesia/Caribbean".equals(botCountry.getRegion())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetTop15CountryWorldTopAndBottom()
    {
        ArrayList<World> country = app.getTopCountryWorld(15);
        World topCountry = country.get(0);
        if ("China".equals(topCountry.getCountryName()) && "Asia".equals(topCountry.getContinent()) &&
                "CHN".equals(topCountry.getCode()) && "Eastern Asia".equals(topCountry.getRegion())) {
            if (country.size()>1){
                World botCountry = country.get(country.size()-1);
                if ("Egypt".equals(botCountry.getCountryName()) &&
                        "Africa".equals(botCountry.getContinent()) && "EGY".equals(botCountry.getCode()) &&
                        "Northern Africa".equals(botCountry.getRegion())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetCountryContTopAndBottom()
    {
        ArrayList<World> country = app.getCountryCont();
        World topCountry = country.get(0);
        if ("China".equals(topCountry.getCountryName()) && "Asia".equals(topCountry.getContinent()) &&
                "CHN".equals(topCountry.getCode()) && "Eastern Asia".equals(topCountry.getRegion())) {
            if (country.size()>1){
                World botCountry = country.get(country.size()-1);
                if ("Maldives".equals(botCountry.getCountryName()) &&
                        "Asia".equals(botCountry.getContinent()) && "MDV".equals(botCountry.getCode()) &&
                        "Southern and Central Asia".equals(botCountry.getRegion())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetTop15CountryContTopAndBottom()
    {
        ArrayList<World> country = app.getTopCountryByCont(15);
        World topCountry = country.get(0);
        if ("China".equals(topCountry.getCountryName()) && "Asia".equals(topCountry.getContinent()) &&
                "CHN".equals(topCountry.getCode()) && "Eastern Asia".equals(topCountry.getRegion())) {
            if (country.size()>1){
                World botCountry = country.get(country.size()-1);
                if ("North Korea".equals(botCountry.getCountryName()) &&
                        "Asia".equals(botCountry.getContinent()) && "PRK".equals(botCountry.getCode()) &&
                        "Eastern Asia".equals(botCountry.getRegion())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetCountryRegionTopAndBottom()
    {
        ArrayList<World> country = app.getCountryRegion();
        World topCountry = country.get(0);
        if ("Indonesia".equals(topCountry.getCountryName()) && "Asia".equals(topCountry.getContinent()) &&
                "IDN".equals(topCountry.getCode()) && "Southeast Asia".equals(topCountry.getRegion())) {
            if (country.size()>1){
                World botCountry = country.get(country.size()-1);
                if ("Brunei".equals(botCountry.getCountryName()) &&
                        "Asia".equals(botCountry.getContinent()) && "BRN".equals(botCountry.getCode()) &&
                        "Southeast Asia".equals(botCountry.getRegion())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetTop15CountryRegionTopAndBottom()
    {
        ArrayList<World> country = app.getTopCountryByRegion(15);
        World topCountry = country.get(0);
        if ("Indonesia".equals(topCountry.getCountryName()) && "Asia".equals(topCountry.getContinent()) &&
                "IDN".equals(topCountry.getCode()) && "Southeast Asia".equals(topCountry.getRegion())) {
            if (country.size()>1){
                World botCountry = country.get(country.size()-1);
                if ("Brunei".equals(botCountry.getCountryName()) &&
                        "Asia".equals(botCountry.getContinent()) && "BRN".equals(botCountry.getCode()) &&
                        "Southeast Asia".equals(botCountry.getRegion())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }


    @Test
    void testGetCityWorldTopAndBottom()
    {
        ArrayList<World> city = app.getCityWorld();
        World topCity = city.get(0);
        if ("Mumbai (Bombay)".equals(topCity.getCityName()) && "India".equals(topCity.getCountryName()) &&
                "Maharashtra".equals(topCity.getDistrict())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Adamstown".equals(botCity.getCityName()) &&
                        "Pitcairn".equals(botCity.getCountryName()) && "–".equals(botCity.getDistrict())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetTop15CityWorldTopAndBottom()
    {
        ArrayList<World> city = app.getTopCitiesWorld(15);
        World topCity = city.get(0);
        if ("Mumbai (Bombay)".equals(topCity.getCityName()) && "India".equals(topCity.getCountryName()) &&
                "Maharashtra".equals(topCity.getDistrict())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Cairo".equals(botCity.getCityName()) &&
                        "Egypt".equals(botCity.getCountryName()) && "Kairo".equals(botCity.getDistrict())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }


    @Test
    void testGetCityContTopAndBottom()
    {
        ArrayList<World> city = app.getCitiesByCont();
        World topCity = city.get(0);
        if ("Mumbai (Bombay)".equals(topCity.getCityName()) && "India".equals(topCity.getCountryName()) &&
                "Maharashtra".equals(topCity.getDistrict())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Bandar Seri Begawan".equals(botCity.getCityName()) &&
                        "Brunei".equals(botCity.getCountryName()) && "Brunei and Muara".equals(botCity.getDistrict())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetTop15CityContTopAndBottom()
    {
        ArrayList<World> city = app.getTopCitiesByCont(15);
        World topCity = city.get(0);
        if ("Mumbai (Bombay)".equals(topCity.getCityName()) && "India".equals(topCity.getCountryName()) &&
                "Maharashtra".equals(topCity.getDistrict())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Calcutta [Kolkata]".equals(botCity.getCityName()) &&
                        "India".equals(botCity.getCountryName()) && "West Bengali".equals(botCity.getDistrict())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetCityCountryTopAndBottom()
    {
        ArrayList<World> city = app.getCitiesByCountry();
        World topCity = city.get(0);
        if ("Rangoon (Yangon)".equals(topCity.getCityName()) && "Myanmar".equals(topCity.getCountryName()) &&
                "Rangoon [Yangon]".equals(topCity.getDistrict())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Pagakku (Pakokku)".equals(botCity.getCityName()) &&
                        "Myanmar".equals(botCity.getCountryName()) && "Magwe [Magway]".equals(botCity.getDistrict())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetTop15CityCountryTopAndBottom()
    {
        ArrayList<World> city = app.getTopCitiesByCountry(15);
        World topCity = city.get(0);
        if ("Rangoon (Yangon)".equals(topCity.getCityName()) && "Myanmar".equals(topCity.getCountryName()) &&
                "Rangoon [Yangon]".equals(topCity.getDistrict())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Tavoy (Dawei)".equals(botCity.getCityName()) &&
                        "Myanmar".equals(botCity.getCountryName()) && "Tenasserim [Tanintha".equals(botCity.getDistrict())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }


    @Test
    void testGetCityRegionTopAndBottom()
    {
        ArrayList<World> city = app.getCitiesByRegion();
        World topCity = city.get(0);
        if ("Mumbai (Bombay)".equals(topCity.getCityName()) && "India".equals(topCity.getCountryName()) &&
                "Maharashtra".equals(topCity.getDistrict())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Thimphu".equals(botCity.getCityName()) &&
                        "Bhutan".equals(botCity.getCountryName()) && "Thimphu".equals(botCity.getDistrict())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetTop15CityRegionTopAndBottom()
    {
        ArrayList<World> city = app.getTopCitiesByRegion(15);
        World topCity = city.get(0);
        if ("Jakarta".equals(topCity.getCityName()) && "Indonesia".equals(topCity.getCountryName()) &&
                "Jakarta Raya".equals(topCity.getDistrict())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Kalookan".equals(botCity.getCityName()) &&
                        "Philippines".equals(botCity.getCountryName()) && "National Capital Reg".equals(botCity.getDistrict())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetCityDistrictTopAndBottom()
    {
        ArrayList<World> city = app.getCitiesByDistrict();
        World topCity = city.get(0);
        if ("Rangoon (Yangon)".equals(topCity.getCityName()) && "Myanmar".equals(topCity.getCountryName()) &&
                "Rangoon [Yangon]".equals(topCity.getDistrict())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Rangoon (Yangon)".equals(botCity.getCityName()) &&
                        "Myanmar".equals(botCity.getCountryName()) && "Rangoon [Yangon]".equals(botCity.getDistrict())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetTop15CityDistrictTopAndBottom()
    {
        ArrayList<World> city = app.getTopCitiesByDistrict(15);
        World topCity = city.get(0);
        if ("Rangoon (Yangon)".equals(topCity.getCityName()) && "Myanmar".equals(topCity.getCountryName()) &&
                "Rangoon [Yangon]".equals(topCity.getDistrict())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Rangoon (Yangon)".equals(botCity.getCityName()) &&
                        "Myanmar".equals(botCity.getCountryName()) && "Rangoon [Yangon]".equals(botCity.getDistrict())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetCapitalCityWorldTopAndBottom()
    {
        ArrayList<World> city = app.getCapitalCityWorld();
        World topCity = city.get(0);
        if ("Seoul".equals(topCity.getCityName()) && "South Korea".equals(topCity.getCountryName())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Adamstown".equals(botCity.getCityName()) &&
                        "Pitcairn".equals(botCity.getCountryName())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetTop15CapitalCityWorldTopAndBottom()
    {
        ArrayList<World> city = app.getTopCapitalCitiesWorld(15);
        World topCity = city.get(0);
        if ("Seoul".equals(topCity.getCityName()) && "South Korea".equals(topCity.getCountryName())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Baghdad".equals(botCity.getCityName()) &&
                        "Iraq".equals(botCity.getCountryName())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }


    @Test
    void testGetCapitalCityContTopAndBottom()
    {
        ArrayList<World> city = app.getCapitalCityCont();
        World topCity = city.get(0);
        if ("Seoul".equals(topCity.getCityName()) && "South Korea".equals(topCity.getCountryName())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Bandar Seri Begawan".equals(botCity.getCityName()) &&
                        "Brunei".equals(botCity.getCountryName())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetTop15CapitalCityContTopAndBottom()
    {
        ArrayList<World> city = app.getTopCapitalCitiesCont(15);
        World topCity = city.get(0);
        if ("Seoul".equals(topCity.getCityName()) && "South Korea".equals(topCity.getCountryName())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Toskent".equals(botCity.getCityName()) &&
                        "Uzbekistan".equals(botCity.getCountryName())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }
    @Test
    void testGetCapitalCityRegionTopAndBottom()
    {
        ArrayList<World> city = app.getCapitalCityRegion();
        World topCity = city.get(0);
        if ("Seoul".equals(topCity.getCityName()) && "South Korea".equals(topCity.getCountryName())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Macao".equals(botCity.getCityName()) &&
                        "Macao".equals(botCity.getCountryName())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetTop15CapitalCityRegionTopAndBottom()
    {
        ArrayList<World> city = app.getTopCapitalCitiesRegion(15);
        World topCity = city.get(0);
        if ("Jakarta".equals(topCity.getCityName()) && "Indonesia".equals(topCity.getCountryName())) {
            if (city.size()>1){
                World botCity = city.get(city.size()-1);
                if ("Bandar Seri Begawan".equals(botCity.getCityName()) &&
                        "Brunei".equals(botCity.getCountryName())){
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                }
                else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            }
            else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        }
        else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetPopulationRatioContinent() {
        ArrayList<PopulationRatio> r = app.getPopulationOfPeopleContinentRatio();
        PopulationRatio top = r.get(0);
        if ("Asia".equals(top.getSpecifer())) {
            if (r.size() > 1) {
                PopulationRatio botCity = r.get(r.size() - 1);
                if ("Antarctica".equals(botCity.getSpecifer())) {
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                } else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            } else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        } else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetPopulationRatioRegion() {
        ArrayList<PopulationRatio> r = app.getPopulationOfPeopleRegionRatio();
        PopulationRatio top = r.get(0);
        if ("Eastern Asia".equals(top.getSpecifer())) {
            if (r.size() > 1) {
                PopulationRatio botCity = r.get(r.size() - 1);
                if ("Antarctica".equals(botCity.getSpecifer())) {
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                } else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            } else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        } else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }


    @Test
    void testGetPopulationRatioCountry() {
        ArrayList<PopulationRatio> r = app.getPopulationOfPeopleCountryRatio();
        PopulationRatio top = r.get(0);
        if ("China".equals(top.getSpecifer())) {
            if (r.size() > 1) {
                PopulationRatio botCity = r.get(r.size() - 1);
                if ("United States Minor Outlying Islands".equals(botCity.getSpecifer())) {
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                } else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            } else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        } else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

    @Test
    void testGetCountryLanguage() {
        ArrayList<World> r = app.getLanguageCountry();
        World top = r.get(0);
        if ("Chinese".equals(top.getCountryLanguage())) {
            if (r.size() > 1) {
                World botCity = r.get(r.size() - 1);
                if ("Arabic".equals(botCity.getCountryLanguage())) {
                    System.out.println("Testing Methods with expected outcomes passed with correct expected values.");
                } else {
                    System.out.println("Testing Methods BOT with expected outcomes failed with correct expected " +
                            "values.");
                }
            } else {
                System.out.println("Testing Methods with expected outcomes failed with correct expected values.");
            }
        } else {
            System.out.println("Testing Methods TOP with expected outcomes failed with correct expected values.");
        }
    }

}