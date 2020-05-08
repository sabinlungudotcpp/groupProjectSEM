package com.grouproject.sem;

// Business Logic City Class
// Purpose of Class: Stores data about the cities in world
// Date of Last Modification: 04/04/2020
// Modified by: Sabin Lungu
// Any Errors? No

public class City { // City class that represents data in the database
    public int id; // The City ID
    public String name; // The City Name
    
    public String countryCode; // The country code for the city
    public String district;
    public int population; // The city population

    public City() { // City default constructor

    }

    public City(int id, String name, String countryCode, String district, int population) { // City Constructor
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public int getId() { // Returns the City ID
        return this.id;
    }

    public void setId(int id) { // Sets the City ID
        this.id = id;
    }

    public String getName() { // Returns the City name
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() { // Returns the country code for the city
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() { // Returns the city population
        return this.population
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
       return " ID " + this.id + " Name " + this.name + " Country Code "  + this.countryCode + " District " + this.district + " Population " + this.population;
    }
}
