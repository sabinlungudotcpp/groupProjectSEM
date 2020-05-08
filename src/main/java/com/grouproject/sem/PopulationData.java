package com.grouproject.sem;

// Purpose of Class: To store the data about the population
// Date of Last Modification: 04/04/2020
// Author: Sabin Constantin Lungu
// Any Bugs: False

public class PopulationData { // Population Data Class
    private String name; // Population data name.
    private double total_population;
    
    private double livingInCities;
    private double notLivingInCities;
    
    private float percentageCities;
    private float percentageNotInCities;

    public PopulationData(String name, double total_population, double livingInCities, float percentageCities, double notLivingInCities, float percentageNotInCities) {
        this.name = name;
        this.total_population = total_population;
        this.livingInCities = livingInCities;
        this.percentageCities = percentageCities;
        this.notLivingInCities = notLivingInCities;
        this.percentageNotInCities = percentageNotInCities;
    }

    public float getPercentageCities() { // Returns the city percentages as a float
        return this.percentageCities;
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
        return this.name;
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

    @Override
    public boolean equals(Object theObject) { // Determines if the objects are equal
        if (this == theObject) { // If this current instance is equal to the object. If they are in the same memory location
            return true; // Return true.
        }

        if (!(theObject instanceof PopulationData)) { // If the object is not an instance of population data
            return false; // Return false
        }

        PopulationData populationData = (PopulationData) theObject;

        // Compares the objects routines
        return Double.compare(populationData.getTotal_population(), getTotal_population()) == 0 &&
                Double.compare(populationData.getLivingInCities(), getLivingInCities()) == 0 &&
                Float.compare(populationData.getPercentageCities(), getPercentageCities()) == 0 &&
                Double.compare(populationData.getNotLivingInCities(), getNotLivingInCities()) == 0 &&
                Float.compare(populationData.getPercentageNotInCities(), getPercentageNotInCities()) == 0;
    }

    @Override
    public String toString() { // To String method to print the data if required.
        return "PopulationData{" +
                "name='" + name + '\'' +
                ", total_population=" + total_population +
                ", livingInCities=" + livingInCities +
                ", percentageCities=" + percentageCities +
                ", notLivingInCities=" + notLivingInCities +
                ", percentageNotInCities=" + percentageNotInCities +
                '}';
    }
}
