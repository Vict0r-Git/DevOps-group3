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
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class represents the integration tests for the App class.
 * It tests various methods related to retrieving country and city data.
 */
public class AppIntegrationTest {

    private static final String DB_LOCATION = "localhost:33060";
    private static final int DB_DELAY = 30000;
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
     *  This method test for the CR3 method, all method calls' array lists under the CR2 method are tested
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
}
