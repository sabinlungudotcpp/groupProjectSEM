package com.grouproject.sem;

public class PopulationData {
    private String name;
    private double total_population;
    private double livingInCities;
    private float percentageCities;
    private double notLivingInCities;
    private float percentageNotInCities;

    public PopulationData(String name, double total_population, double livingInCities, float percentageCities, double notLivingInCities, float percentageNotInCities) {
        this.name = name;
        this.total_population = total_population;
        this.livingInCities = livingInCities;
        this.percentageCities = percentageCities;
        this.notLivingInCities = notLivingInCities;
        this.percentageNotInCities = percentageNotInCities;
    }

    public float getPercentageCities() {
        return percentageCities;
    }

    public void setPercentageCities(float percentageCities) {
        this.percentageCities = percentageCities;
    }

    public float getPercentageNotInCities() {
        return percentageNotInCities;
    }

    public void setPercentageNotInCities(float percentageNotInCities) {
        this.percentageNotInCities = percentageNotInCities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal_population() {
        return total_population;
    }

    public void setTotal_population(double total_population) {
        this.total_population = total_population;
    }

    public double getLivingInCities() {
        return livingInCities;
    }

    public void setLivingInCities(double livingInCities) {
        this.livingInCities = livingInCities;
    }

    public double getNotLivingInCities() {
        return notLivingInCities;
    }

    public void setNotLivingInCities(double notLivingInCities) {
        this.notLivingInCities = notLivingInCities;
    }
}
