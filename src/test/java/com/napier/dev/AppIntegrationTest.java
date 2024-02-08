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

}
