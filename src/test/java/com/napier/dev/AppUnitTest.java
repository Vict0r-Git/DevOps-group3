package com.napier.dev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AppUnitTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /*
        Testing testPrintCyanMessage() method for print messages
     */
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
     *  Testing displayCountry() method
     */
    @Test
    void testDisplayCountryNull()
    {
        app.displayCountry(null);
    }

    @Test
    void testDisplayCountryEmpty()
    {
        ArrayList<World> countries = new ArrayList<>();
        app.displayCountry(countries);
    }

    @Test
    void testDisplayCountryContainsNull()
    {
        ArrayList<World> country = new ArrayList<>();
        country.add(null);
        app.displayCountry(country);
    }

    @Test
    void testDisplayCountry()
    {
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
    void testDisplayCitiesNull()
    {
        app.displayCities(null);
    }

    @Test
    void testDisplayCitiesEmpty()
    {
        ArrayList<World> cities = new ArrayList<>();
        app.displayCities(cities);
    }

    @Test
    void testDisplayCitiesContainsNull()
    {
        ArrayList<World> cities = new ArrayList<>();
        cities.add(null);
        app.displayCities(cities);
    }

    @Test
    void testDisplayCities()
    {
        ArrayList<World> cities = new ArrayList<>();
        World world = new World();
        world.setCityName("Yangon");
        world.setCountryName("Myanmar");
        world.setDistrict("Yangon");
        world.setCityPopulation(600000);
        app.displayCities(cities);
    }

    /**
     *  Testing displayCapitalCities() method
     */
    @Test
    void testDisplayCapitalCitiesNull()
    {
        app.displayCapitalCities(null);
    }

    @Test
    void testDisplayCapitalCitiesEmpty()
    {
        ArrayList<World> cities = new ArrayList<>();
        app.displayCapitalCities(cities);
    }

    @Test
    void testDisplayCapitalCitiesContainsNull()
    {
        ArrayList<World> cities = new ArrayList<>();
        cities.add(null);
        app.displayCapitalCities(cities);
    }

    @Test
    void testDisplayCapitalCities()
    {
        ArrayList<World> cities = new ArrayList<>();
        World world;
        world = new World();
        world.setCityName("Yangon");
        world.setCountryName("Myanmar");
        world.setCityPopulation(700000);
        app.displayCities(cities);
    }
}