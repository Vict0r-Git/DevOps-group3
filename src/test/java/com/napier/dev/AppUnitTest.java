/**
 *  Description: This is the Unit Testing file for the world app
 *  which is tested for all classes and methods.
 *  Author: Paing Thet Kyaw and Yé Min Than
 */
package com.napier.dev;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/**
 * This class represents the unit tests for the App class.
 * It tests various methods related to displaying data
 */
public class AppUnitTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * Testing testPrintCyanMessage() method for print messages
     **/
    @Test
    void testPrintCyanMessage2()
    {
        // Test an example string
        App.printCyanMessage("Tested Cyan");
    }

    @Test
    void testPrintCyanMessageNull()
    {
        // If null it will output 'Nothing to print'
        App.printCyanMessage(null);
    }

    /**
     *  Test for the displayCountry method where corresponding countries are display
     */
    @Test
    void testDisplayCountryNull()
    {
        // test for null value
        app.displayCountry(null);
    }

    @Test
    void testDisplayCountryEmpty()
    {
        // Create an empty array list
        ArrayList<World> countries = new ArrayList<>();
        // Used the empty list to display
        app.displayCountry(countries);
    }

    @Test
    void testDisplayCountryContainsNull()
    {
        // Create an empty array list
        ArrayList<World> country = new ArrayList<>();
        // Add null value to the array list
        country.add(null);
        // Then used the null list to display
        app.displayCountry(country);
    }

    @Test
    void testDisplayCountry()
    {
        // Create an empty array list and set some values to test the behaviour of displayCountry method
        ArrayList<World> countries = new ArrayList<World>();
        World world = new World();
        world.setCode("MM");
        world.setCountryName("Myanmar");
        world.setContinent("Asia");
        world.setRegion("Yangon");
        world.setCountryPopulation(600000);
        world.setCapital(123);
        countries.add(world);
        app.displayCountry(countries);
    }


    /**
     *  Testing displayCity() method
     */
    @Test
    void testDisplayCitiesNull() {
        // Test the displayCities method with a null input
        app.displayCities(null);
    }

    @Test
    void testDisplayCitiesEmpty() {
        // Test the displayCities method with an empty list of cities
        ArrayList<World> cities = new ArrayList<>();
        app.displayCities(cities);
    }

    @Test
    void testDisplayCitiesContainsNull() {
        // Test the displayCities method with a list containing null elements
        ArrayList<World> cities = new ArrayList<>();
        cities.add(null);
        app.displayCities(cities);
    }

    @Test
    void testDisplayCities() {
        // Test the displayCities method with a list of cities
        ArrayList<World> cities = new ArrayList<>();
        World world = new World();
        world.setCityName("Yangon");
        world.setCountryName("Myanmar");
        world.setDistrict("Yangon");
        world.setCityPopulation(600000);
        cities.add(world);
        app.displayCities(cities);
    }

    /**
     * Testing displayCapitalCities() method
     */
    @Test
    void testDisplayCapitalCitiesNull() {
        // Test the displayCapitalCities method with a null input
        app.displayCapitalCities(null);
    }

    @Test
    void testDisplayCapitalCitiesEmpty() {
        // Test the displayCapitalCities method with an empty list of capital cities
        ArrayList<World> cities = new ArrayList<>();
        app.displayCapitalCities(cities);
    }

    @Test
    void testDisplayCapitalCitiesContainsNull() {
        // Test the displayCapitalCities method with a list containing null elements
        ArrayList<World> cities = new ArrayList<>();
        cities.add(null);
        app.displayCapitalCities(cities);
    }

    @Test
    void testDisplayCapitalCities() {
        // Test the displayCapitalCities method with a list of capital cities
        ArrayList<World> cities = new ArrayList<>();
        World world = new World();
        world.setCityName("Yangon");
        world.setCountryName("Myanmar");
        world.setCityPopulation(700000);
        cities.add(world);
        app.displayCities(cities);
    }
}