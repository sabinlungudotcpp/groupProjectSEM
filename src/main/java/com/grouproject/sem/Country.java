package com.grouproject.sem;

public class Country { // Country class
    public String code;
    public String name;
    public String region;
    public Continent continent;
    public int population;


    public String toString() { // Returns the code, name, region and population for that specific country
        return this.code + ", " + this.name + " , " + this.region + ", " + this.population;
    }
}
