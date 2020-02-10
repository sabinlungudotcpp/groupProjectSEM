package com.grouproject.sem;

public class Country {
    public String code;
    public String name;
    public Continent continent;
    public int population;


    public String toString() {
        return this.code + ", " + this.name + ", " + this.population;
    }
}
