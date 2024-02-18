package com.napier.dev;

/**
 * Represents a population ratio data structure.
 */
public class PopulationRatio {

    // Fields to store population data
    private long pplPopulation;
    private long popLivCT;
    private long popNotLivCT;

    // Fields to store ratio specifications
    private String specifer;
    private String livPercent;
    private String notLivPercent;

    // Getter and Setter methods for each field

    /**
     * Gets the percentage of people living.
     * @return The percentage of people living.
     */
    public String getLivPercent() {
        return livPercent;
    }

    /**
     * Sets the percentage of people living.
     * @param livPercent The percentage of people living to set.
     */
    public void setLivPercent(String livPercent) {
        this.livPercent = livPercent;
    }

    /**
     * Gets the percentage of people not living.
     * @return The percentage of people not living.
     */
    public String getNotLivPercent() {
        return notLivPercent;
    }

    /**
     * Sets the percentage of people not living.
     * @param notLivPercent The percentage of people not living to set.
     */
    public void setNotLivPercent(String notLivPercent) {
        this.notLivPercent = notLivPercent;
    }

    /**
     * Gets the total population.
     * @return The total population.
     */
    public long getPplPopulation() {
        return pplPopulation;
    }

    /**
     * Sets the total population.
     * @param pplPopulation The total population to set.
     */
    public void setPplPopulation(long pplPopulation) {
        this.pplPopulation = pplPopulation;
    }

    /**
     * Gets the population living in cities.
     * @return The population living in cities.
     */
    public long getPopLivCT() {
        return popLivCT;
    }

    /**
     * Sets the population living in cities.
     * @param popLivCT The population living in cities to set.
     */
    public void setPopLivCT(long popLivCT) {
        this.popLivCT = popLivCT;
    }

    /**
     * Gets the population not living in cities.
     * @return The population not living in cities.
     */
    public long getPopNotLivCT() {
        return popNotLivCT;
    }

    /**
     * Sets the population not living in cities.
     * @param popNotLivCT The population not living in cities to set.
     */
    public void setPopNotLivCT(long popNotLivCT) {
        this.popNotLivCT = popNotLivCT;
    }

    /**
     * Gets the specifier.
     * @return The specifier.
     */
    public String getSpecifer() {
        return specifer;
    }

    /**
     * Sets the specifier.
     * @param specifer The specifier to set.
     */
    public void setSpecifer(String specifer) {
        this.specifer = specifer;
    }
}
