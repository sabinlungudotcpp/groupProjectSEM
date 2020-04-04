package com.grouproject.sem;

public enum Continent { // Continent enum
    ASIA("Asia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARTICA("Antarctica"),
    SOUTH_AMERICA("South America");

    private String continent;


    Continent(String continent) {
        this.continent = continent;
    }

    public String getContinent() { // Retrieves the continent
        return this.continent;
    }
 }