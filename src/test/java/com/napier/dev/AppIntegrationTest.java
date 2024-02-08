package com.napier.dev;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    private static final String DB_LOCATION = "localhost:33060";
    private static final int DB_DELAY = 30000;

    private static final String driver = "com.mysql.cj.jdbc.Driver";

    private static App app;

    @BeforeAll
    public static void setUpBeforeClass() {
        app = new App();
        app.connect(DB_LOCATION, DB_DELAY, driver);
    }

    @AfterAll
    public static void tearDownAfterClass() {
        if (app.con != null) {
            app.disconnect();
        }
    }

    @Test
    void testConnect() {
        // app.connect(DB_LOCATION, DB_DELAY);
        assertNotNull(app.con);
    }

    @Test
    void testGetCountryWorld() {
        // app.connect(DB_LOCATION, DB_DELAY);
        ArrayList<World> countries = app.getCountryWorld();
        assertNotNull(countries);
        Assertions.assertFalse(countries.isEmpty());
    }

//    @Test
//    void connectionException()
//    {
//        app.con = null;
//        // Testing for Country exception
//        assertNull(app.getCountryWorld());
//        assertNull(app.getCountryCont());
//        assertNull(app.getCountryRegion());
//
//        // Testing for Cities exception
//        assertNull(app.getCityWorld());
//        assertNull(app.getCitiesByCountry());
//        assertNull(app.getCitiesByRegion());
//        assertNull(app.getCitiesByCont());
//        assertNull(app.getCitiesByDistrict());
//
//        // Testing for Capital City exception
//        assertNull(app.getCapitalCityWorld());
//        assertNull(app.getCapitalCityCont());
//        assertNull(app.getCapitalCityRegion());
//        AppIntegrationTest.setUpBeforeClass();
//    }


    @Test
    void testConnectInterruptedException() {
        App app = new App();
        Thread.currentThread().interrupt(); // Simulate interruption
//        assertThrows(RuntimeException.class, () -> app.connect("localhost:3306", 1, driver));
        AppIntegrationTest.setUpBeforeClass();
    }

    @Test
    void testLoadDatabaseDriver_ClassNotFoundException() {
        App app = new App();
        app.con = null;
        // Simulate the nonexistent driver name to get exception error
        assertThrows(ClassNotFoundException.class, () -> {
            app.connect(DB_LOCATION, DB_DELAY, "com.nonexistent.jdbc.Driver");
        });

        // Reloaded the correct driver class to connect back to the database
        AppIntegrationTest.setUpBeforeClass();
    }


    @Test
    void testGetCountryCont() {
        // app.connect(DB_LOCATION, DB_DELAY);
        ArrayList<World> countries = app.getCountryCont();
        assertNotNull(countries);
        Assertions.assertFalse(countries.isEmpty());
    }

    @Test
    void testGetCountryContException()
    {
        app.con = null;
        assertNull(app.getCountryCont());
        AppIntegrationTest.setUpBeforeClass();
    }

    @Test
    void testGetCountryRegion() {
        // app.connect(DB_LOCATION, DB_DELAY);
        ArrayList<World> countries = app.getCountryRegion();
        assertNotNull(countries);
        Assertions.assertFalse(countries.isEmpty());
    }

    @Test
    void testGetCityWorld() {
        // app.connect(DB_LOCATION, DB_DELAY);
        ArrayList<World> cities = app.getCityWorld();
        assertNotNull(cities);
        Assertions.assertFalse(cities.isEmpty());
    }

    @Test
    void testGetCitiesByCont()  {
        // app.connect(DB_LOCATION, DB_DELAY);
        ArrayList<World> cities = app.getCitiesByCont();
        assertNotNull(cities);
        assertFalse(cities.isEmpty());
    }

    @Test
    void testGetCitiesByRegion()  {
        // app.connect(DB_LOCATION, DB_DELAY);
        ArrayList<World> cities = app.getCitiesByRegion();
        assertNotNull(cities);
        Assertions.assertFalse(cities.isEmpty());
    }

    @Test
    void testGetCitiesByCountry()  {
        // app.connect(DB_LOCATION, DB_DELAY);
        ArrayList<World> cities = app.getCitiesByCountry();
        assertNotNull(cities);
        Assertions.assertFalse(cities.isEmpty());
    }

    @Test
    void testGetCitiesByDistrict()  {
        // app.connect(DB_LOCATION, DB_DELAY);
        ArrayList<World> cities = app.getCitiesByDistrict();
        assertNotNull(cities);
        Assertions.assertFalse(cities.isEmpty());
    }

    @Test
    void testGetCapitalCityWorld()  {
        // app.connect(DB_LOCATION, DB_DELAY);
        ArrayList<World> capitals = app.getCapitalCityWorld();
        assertNotNull(capitals);
        Assertions.assertFalse(capitals.isEmpty());
    }

    @Test
    void testGetCapitalCityCont()  {
        // app.connect(DB_LOCATION, DB_DELAY);
        ArrayList<World> capitals = app.getCapitalCityCont();
        assertNotNull(capitals);
        Assertions.assertFalse(capitals.isEmpty());
    }

    @Test
    void testGetCapitalCityRegion()  {
        // app.connect(DB_LOCATION, DB_DELAY);
        ArrayList<World> capitals = app.getCapitalCityRegion();
        assertNotNull(capitals);
        Assertions.assertFalse(capitals.isEmpty());
    }

    @Test
    void testCR2ArrayListsAreNotNull()
    {
        // Call the CR2 method
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

    @Test
    void testCR3ArrayListsAreNotNull()
    {
        // Call the CR3 method
        app.CR3();

        assertNotNull(app.getCapitalCityWorld());
        assertNotNull(app.getCapitalCityCont());
        assertNotNull(app.getCapitalCityRegion());

    }
}
