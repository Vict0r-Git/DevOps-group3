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
        // Test the displayCities() method with a list containing null elements
        ArrayList<World> cities = new ArrayList<>();
        cities.add(null);
        app.displayCities(cities);
    }

    @Test
    void testDisplayCities() {
        // Test the displayCities() method with a list of cities
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
        // Test the displayCapitalCities() method with a null input
        app.displayCapitalCities(null);
    }

    @Test
    void testDisplayCapitalCitiesEmpty() {
        // Test the displayCapitalCities() method with an empty list of capital cities
        ArrayList<World> cities = new ArrayList<>();
        app.displayCapitalCities(cities);
    }

    @Test
    void testDisplayCapitalCitiesContainsNull() {
        // Test the displayCapitalCities() method with a list containing null elements
        ArrayList<World> cities = new ArrayList<>();
        cities.add(null);
        app.displayCapitalCities(cities);
    }

    @Test
    void testDisplayCapitalCities() {
        // Test the displayCapitalCities() method with a list of capital cities
        ArrayList<World> cities = new ArrayList<>();
        World world = new World();
        world.setCityName("Yangon");
        world.setCountryName("Myanmar");
        world.setCityPopulation(700000);
        cities.add(world);
        app.displayCapitalCities(cities);
    }

    /**
     * Testing displayPopulationRatio() method
     */
    @Test
    void testDisplayPopulationRatioNull(){
        // Test the displayCountryLanguage() method with a null input
        app.displayPopulationRatio(null, "String");
    }

    @Test
    void testDisplayPopulationRatioContainNull(){
        // Test the displayPopulationRatio() method with a null array list
        ArrayList<PopulationRatio> population = new ArrayList<>();
        population.add(null);
        app.displayPopulationRatio(population, "String");
    }

    @Test
    void testDisplayPopulationRatioEmpty(){
        // Test the displayPopulationRatio() method with an empty list of capital cities
        ArrayList<PopulationRatio> population = new ArrayList<>();
        app.displayPopulationRatio(population, null);
    }

    @Test
    void testDisplayPopulationRatio() {
        // Test the displayPopulationRatio() method non-null, whether the data passed as expected
        ArrayList<PopulationRatio> populationRatios = new ArrayList<>();
        PopulationRatio ratio = new PopulationRatio();
        ratio.setSpecifer("Asia");
        ratio.setPplPopulation(10000);
        ratio.setPopLivCT(8000);
        ratio.setPopNotLivCT(2000);
        populationRatios.add(ratio);
        app.displayPopulationRatio(populationRatios, "String");
    }


    /**
     * Testing displayCountryLanguage() method
     */
    @Test
    void testDisplayCountryLanguageContainNull(){
        // Test the displayCountryLanguage() method with a null array list
        ArrayList<World> country_language = new ArrayList<>();
        country_language.add(null);
        app.displayCountryLanguage(country_language);
    }

    @Test
    void testDisplayCountryLanguageEmpty(){
        // Test the displayCountryLanguage() method with an empty list of capital cities
        ArrayList<World> country_language = new ArrayList<>();
        app.displayCountryLanguage(country_language);
    }

    @Test
    void testDisplayCountryLanguageNull(){
        // Test the displayCountryLanguage() method with a null input
        app.displayCountryLanguage(null);
    }

    @Test
    void testDisplayCountryLanguage() {
        // Test the displayCountryLanguage() method non-null, whether the data passed as expected
        ArrayList<World> country_language = new ArrayList<>();
        World world = new World();
        world.setCountryLanguage("English");
        world.setCountryPopulation(10000000);
        world.setPercentage("40%");
        country_language.add(world);
        app.displayCountryLanguage(country_language);
    }

    /**
     * Testing displayTotalPopulation() method
     */
    @Test
    void testDisplayTotalPopulationContainNull(){
        // Test the displayTotalPopulation() method with a null array list
        ArrayList<World> population = new ArrayList<>();
        population.add(null);
        app.displayTotalPopulation(population);
    }
    @Test
    void testDisplayTotalPopulationEmpty(){
        // Test the displayTotalPopulation() method with an empty list of capital cities
        ArrayList<World> population = new ArrayList<>();
        app.displayTotalPopulation(population);
    }

    @Test
    void testDisplayTotalPopulationNull(){
        // Test the displayTotalPopulation() method with a null input
        app.displayTotalPopulation(null);
    }

    @Test
    void testTotalPopulation() {
        // Test the displayTotalPopulation() method non-null, whether the data passed as expected
        ArrayList<World> population = new ArrayList<>();
        World world = new World();
        world.setTotalPopulation(9000000);
        population.add(world);
        app.displayTotalPopulation(population);
    }

    /**
     * Testing displayContinentPopulation() method
     */
    @Test
    void testDisplayContinentPopulationContainNull(){
        // Test the displayContinentPopulation() method with a null array list
        ArrayList<World> population = new ArrayList<>();
        population.add(null);
        app.displayContinentPopulation(population);
    }
    @Test
    void testDisplayContinentPopulationEmpty(){
        // Test the displayContinentPopulation() method with an empty list of capital cities
        ArrayList<World> population = new ArrayList<>();
        app.displayContinentPopulation(population);
    }

    @Test
    void testDisplayContinentPopulationNull(){
        // Test the displayContinentPopulation() method with a null input
        app.displayContinentPopulation(null);
    }

    @Test
    void testDisplayContinentPopulation() {
        // Test the displayContinentPopulation() method non-null, whether the data passed as expected
        ArrayList<World> population = new ArrayList<>();
        World world = new World();
        world.setContinentPopulation(9000000);
        population.add(world);
        app.displayContinentPopulation(population);
    }

    /**
     * Testing displayCountryPop() method
     */
    @Test
    void testDisplayCountryPopContainNull(){
        // Test the displayContinentPopulation() method with a null array list
        ArrayList<World> population = new ArrayList<>();
        population.add(null);
        app.displayCountryPop(population);
    }
    @Test
    void testDisplayCountryPopEmpty(){
        // Test the displayContinentPopulation() method with an empty list of capital cities
        ArrayList<World> population = new ArrayList<>();
        app.displayCountryPop(population);
    }

    @Test
    void testDisplayCountryPopNull(){
        // Test the displayContinentPopulation() method with a null input
        app.displayCountryPop(null);
    }

    @Test
    void testDisplayCountryPop() {
        // Test the displayContinentPopulation method non-null, whether the data passed as expected
        ArrayList<World> population = new ArrayList<>();
        World world = new World();
        world.setCountryPop(9000000);
        population.add(world);
        app.displayCountryPop(population);
    }

    /**
     * Testing displayPopRegion() method
     */
    @Test
    void testDisplayPopRegionContainNull(){
        // Test the displayPopRegion() method with a null array list
        ArrayList<World> population = new ArrayList<>();
        population.add(null);
        app.displayPopRegion(population);
    }
    @Test
    void testDisplayPopRegionEmpty(){
        // Test the displayPopRegion() method with an empty list of capital cities
        ArrayList<World> population = new ArrayList<>();
        app.displayPopRegion(population);
    }

    @Test
    void testDisplayPopRegionNull(){
        // Test the displayPopRegion() method with a null input
        app.displayPopRegion(null);
    }

    @Test
    void testDisplayPopRegion() {
        // Test the displayPopRegion() method non-null, whether the data passed as expected
        ArrayList<World> population = new ArrayList<>();
        World world = new World();
        world.setRegionPop(900000000);
        population.add(world);
        app.displayPopRegion(population);
    }

    /**
     * Testing displayPopDistrict() method
     */
    @Test
    void testDisplayPopDistrictContainNull(){
        // Test the displayPopDistrict() method with a null array list
        ArrayList<World> population = new ArrayList<>();
        population.add(null);
        app.displayPopDistrict(population);
    }
    @Test
    void testDisplayPopDistrictEmpty(){
        // Test the displayPopDistrict() method with an empty list of capital cities
        ArrayList<World> population = new ArrayList<>();
        app.displayPopDistrict(population);
    }

    @Test
    void testDisplayPopDistrictNull(){
        // Test the displayPopDistrict() method with a null input
        app.displayPopDistrict(null);
    }

    @Test
    void testDisplayPopDistrict() {
        // Test the displayPopDistrict() method non-null, whether the data passed as expected
        ArrayList<World> population = new ArrayList<>();
        World world = new World();
        world.setDistrictPop(9000000);
        population.add(world);
        app.displayPopDistrict(population);
    }

    /**
     * Testing displayPopCity() method
     */
    @Test
    void testDisplayPopCityContainNull(){
        // Test the displayPopCity() method with a null array list
        ArrayList<World> population = new ArrayList<>();
        population.add(null);
        app.displayPopCity(population);
    }
    @Test
    void testDisplayPopCityEmpty(){
        // Test the displayPopCity() method with an empty list of capital cities
        ArrayList<World> population = new ArrayList<>();
        app.displayPopCity(population);
    }

    @Test
    void testDisplayPopCityNull(){
        // Test the displayPopCity() method with a null input
        app.displayPopCity(null);
    }

    @Test
    void testDisplayPopCity() {
        // Test the displayPopCity() method non-null, whether the data passed as expected
        ArrayList<World> population = new ArrayList<>();
        World world = new World();
        world.setCityPop(9000000);
        population.add(world);
        app.displayPopCity(population);
    }
}