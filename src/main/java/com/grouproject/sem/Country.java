package com.grouproject.sem;

public class Country { // Country class
    public String code; // The country code
    public String name; // The country name
    
    public String continent; // Continent enum
    public String region;
    
    public float surfaceArea;
    public int indepYear;
    public int population;
    
    public float lifeExpectancy;
    public float GNP;
    public float GNPOld;
    
    public String localName;
    public String governmentForm;
    public String headOfState;
    public String countryCapital;
    public String code2;

    public Country() { // Default constructor
        System.out.println("Inside default constructor");
    }

    public Country(String code, String name, String continent, String region, float surfaceArea, int indepYear, int population, float lifeExpectancy, float GNP, float GNPOld, String localName, String governmentForm, String headOfState, String countryCapital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.countryCapital = countryCapital;
        this.code2 = code2;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() { // Returns the continent
        return this.continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() { // Returns the region
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public float getGNP() {
        return this.GNP;
    }

    public void setGNP(float GNP) {
        this.GNP = GNP;
    }

    public float getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(float GNPOld) {
        this.GNPOld = GNPOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public String getCapital() {
        return this.countryCapital;
    }

    public void setCapital(String capital) {
        this.countryCapital = countryCapital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }


    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent=" + continent +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", indepYear=" + indepYear +
                ", population=" + population +
                ", lifeExpectancy=" + lifeExpectancy +
                ", GNP=" + GNP +
                ", GNPOld=" + GNPOld +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", Capital=" + this.countryCapital +
                ", code2='" + code2 + '\'' +
                '}';
    }
}
