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

//    @Test
//    void testGetCountryWorldTopAndBottom()
//    {
//        ArrayList<World> country = app.getCountryWorld();
//        World topCoun = country.get(0);
//        if ("China".equals(topCoun.getCountryName())) {
//            // Only print the pass message if the assertion passes
//            System.out.println("Assertion passed: Expected country name is correct.");
//            if (country.size()>1){
//                World botCoun = country.get(country.size()-1);
//                if ("South Georgia and the South Sandwich Islands".equals(botCoun.getCountryName())){
//                    System.out.println("Expect Country: South Georgia and the South Sandwich Islands and top country: " + botCoun.getCountryName() + " does not match.");
//                }
//            }
//        }
//        else {
//            System.out.println("Expect Country: China and top country: " + topCoun.getCountryName() + " does not match.");
//        }
//    }

    @Test
    void testGetCountryWorldTop()
    {
        ArrayList<World> country = app.getCountryWorld();
        World topCoun = country.get(0);

        assertEquals(topCoun.getCountryName(), "China");
        assertEquals(topCoun.getContinent(), "Asia");
        assertEquals(topCoun.getCode(), "CHN");
        assertEquals(topCoun.getCapital(), 1891);
        assertEquals(topCoun.getRegion(), "Eastern Asia");
        assertEquals(topCoun.getCountryPopulation(), 1277558000);

    }

    @Test
    void testGetTopCountryWorldTop()
    {
        ArrayList<World> country = app.getTopCountryWorld(15);
        World topCoun = country.get(0);

        assertEquals(topCoun.getCountryName(), "China");
        assertEquals(topCoun.getContinent(), "Asia");
        assertEquals(topCoun.getCode(), "CHN");
        assertEquals(topCoun.getCapital(), 1891);
        assertEquals(topCoun.getRegion(), "Eastern Asia");
        assertEquals(topCoun.getCountryPopulation(), 1277558000);

    }

    @Test
    void testGetCountryContTop()
    {
        ArrayList<World> country = app.getCountryCont();
        World topCoun = country.get(0);

        assertEquals(topCoun.getCountryName(), "China");
        assertEquals(topCoun.getContinent(), "Asia");
        assertEquals(topCoun.getCode(), "CHN");
        assertEquals(topCoun.getCapital(), 1891);
        assertEquals(topCoun.getRegion(), "Eastern Asia");
        assertEquals(topCoun.getCountryPopulation(), 1277558000);

    }

    @Test
    void testGetTopCountryContTop()
    {
        ArrayList<World> country = app.getTopCountryByCont(15);
        World topCoun = country.get(0);

        assertEquals(topCoun.getCountryName(), "China");
        assertEquals(topCoun.getContinent(), "Asia");
        assertEquals(topCoun.getCode(), "CHN");
        assertEquals(topCoun.getCapital(), 1891);
        assertEquals(topCoun.getRegion(), "Eastern Asia");
        assertEquals(topCoun.getCountryPopulation(), 1277558000);

    }

    @Test
    void testGetCountryRegionTop()
    {
        ArrayList<World> country = app.getCountryRegion();
        World topCoun = country.get(0);

        assertEquals(topCoun.getCountryName(), "Indonesia");
        assertEquals(topCoun.getContinent(), "Asia");
        assertEquals(topCoun.getCode(), "IDN");
        assertEquals(topCoun.getCapital(), 939);
        assertEquals(topCoun.getRegion(), "Southeast Asia");
        assertEquals(topCoun.getCountryPopulation(), 212107000);

    }

    @Test
    void testGetTopCountryRegionTop()
    {
        ArrayList<World> country = app.getTopCountryByRegion(15);
        World topCoun = country.get(0);

        assertEquals(topCoun.getCountryName(), "Indonesia");
        assertEquals(topCoun.getContinent(), "Asia");
        assertEquals(topCoun.getCode(), "IDN");
        assertEquals(topCoun.getCapital(), 939);
        assertEquals(topCoun.getRegion(), "Southeast Asia");
        assertEquals(topCoun.getCountryPopulation(), 212107000);

    }

    @Test
    void testGetCityWorldTop()
    {
        ArrayList<World> country = app.getCityWorld();
        World topCT = country.get(0);

        assertEquals(topCT.getCityName(), "Mumbai");
        assertEquals(topCT.getCountryName(), "India");
        assertEquals(topCT.getDistrict(), "Maharashtra");
        assertEquals(topCT.getCityPopulation(), 10500000);

    }

    @Test
    void testTopGetCityWorldTop()
    {
        ArrayList<World> country = app.getTopCitiesWorld(15);
        World topCT = country.get(0);

        assertEquals(topCT.getCityName(), "Mumbai");
        assertEquals(topCT.getCountryName(), "India");
        assertEquals(topCT.getDistrict(), "Maharashtra");
        assertEquals(topCT.getCityPopulation(), 10500000);

    }
}
