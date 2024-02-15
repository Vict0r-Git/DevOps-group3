package com.napier.dev;

/**
 * Represents the population ratio of people living in countries to the total population.
 */
public class PopulationRatio {

    // Fields to store population data
    private long pplPopulation;
    private long popLivCT;
    private long popNotLivCT;
    private String specifer;

    // Getter and Setter methods for each field

    /**
     * Gets the population of people living in the country.
     * @return The population of people living in the country.
     */
    public long getPplPopulation() {
        return pplPopulation;
    }

    /**
     * Sets the population of people living in the country.
     * @param pplPopulation The population of people living in the country.
     */
    public void setPplPopulation(long pplPopulation) {
        this.pplPopulation = pplPopulation;
    }

    /**
     * Gets the population of people living in cities within the country.
     * @return The population of people living in cities within the country.
     */
    public long getPopLivCT() {
        return popLivCT;
    }

    /**
     * Sets the population of people living in cities within the country.
     * @param popLivCT The population of people living in cities within the country.
     */
    public void setPopLivCT(long popLivCT) {
        this.popLivCT = popLivCT;
    }

    /**
     * Gets the population of people not living in cities within the country.
     * @return The population of people not living in cities within the country.
     */
    public long getPopNotLivCT() {
        return popNotLivCT;
    }

    /**
     * Sets the population of people not living in cities within the country.
     * @param popNotLivCT The population of people not living in cities within the country.
     */
    public void setPopNotLivCT(long popNotLivCT) {
        this.popNotLivCT = popNotLivCT;
    }

    /**
     * Gets the specifier for the population ratio (e.g., country name, continent).
     * @return The specifier for the population ratio.
     */
    public String getSpecifer() {
        return specifer;
    }

    /**
     * Sets the specifier for the population ratio (e.g., country name, continent).
     * @param specifer The specifier for the population ratio.
     */
    public void setSpecifer(String specifer) {
        this.specifer = specifer;
    }
}
