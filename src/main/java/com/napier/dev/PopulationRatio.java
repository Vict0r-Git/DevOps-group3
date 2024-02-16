package com.napier.dev;

public class PopulationRatio {

    private long pplPopulation;

    private long popLivCT;

    private long popNotLivCT;

    private String specifer;

    private String livPercent;

    private String notLivPercent;

    public String getLivPercent() {
        return livPercent;
    }

    public void setLivPercent(String livPercent) {
        this.livPercent = livPercent;
    }

    public String getNotLivPercent() {
        return notLivPercent;
    }

    public void setNotLivPercent(String notLivPercent) {
        this.notLivPercent = notLivPercent;
    }

    public long getPplPopulation() {
        return pplPopulation;
    }

    public void setPplPopulation(long pplPopulation) {
        this.pplPopulation = pplPopulation;
    }

    public long getPopLivCT() {
        return popLivCT;
    }

    public void setPopLivCT(long popLivCT) {
        this.popLivCT = popLivCT;
    }

    public long getPopNotLivCT() {
        return popNotLivCT;
    }

    public void setPopNotLivCT(long popNotLivCT) {
        this.popNotLivCT = popNotLivCT;
    }

    public String getSpecifer() {
        return specifer;
    }

    public void setSpecifer(String specifer) {
        this.specifer = specifer;
    }
}
