package com.grouproject.sem;

// Business Logic City Class
// Purpose of Class: Stores data about the cities in world
// Date of Last Modification: 04/04/2020
// Modified by: Sabin Lungu
// Any Errors? No

public class City { // City class that represents data in the database
    public int id;
    public String name;
    public String countryCode;

    public String district;
    public int population;

    public City() {

    }

    public City(int id, String name, String countryCode, String district, int population) { // City Constructor
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
       return " ID " + this.id + " Name " + this.name + " Country Code "  + this.countryCode + " District " + this.district + " Population " + this.population;
    }
}
