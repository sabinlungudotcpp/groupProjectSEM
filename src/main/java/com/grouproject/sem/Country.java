package com.grouproject.sem;

public class Country { // Country class
    public String code;
    public String name;
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
    public int Capital;
    public String code2;

    public Country() { // Default constructor

    }

    public Country(String code, String name, String continent, String region, float surfaceArea, int indepYear, int population, float lifeExpectancy, float GNP, float GNPOld, String localName, String governmentForm, String headOfState, int capital, String code2) {
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
        this.Capital = capital;
        this.code2 = code2;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
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
        return GNP;
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

    public int getCapital() {
        return Capital;
    }

    public void setCapital(int capital) {
        Capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) {

            return true;
        }

        if (!(o instanceof Country)) {

            return false;
        }

        Country country = (Country) o;
        return Float.compare(country.getSurfaceArea(), getSurfaceArea()) == 0 &&
                getIndepYear() == country.getIndepYear() &&
                getPopulation() == country.getPopulation() &&
                Float.compare(country.getLifeExpectancy(), getLifeExpectancy()) == 0 &&
                Float.compare(country.getGNP(), getGNP()) == 0 &&
                Float.compare(country.getGNPOld(), getGNPOld()) == 0 &&

                getCapital() == country.getCapital() &&
                getCode().equals(country.getCode()) &&
                getName().equals(country.getName()) &&
                getContinent().equals(country.getContinent()) &&
                getRegion().equals( country.getRegion()) &&
                Objects.equals(getLocalName(), country.getLocalName()) &&
                Objects.equals(getGovernmentForm(), country.getGovernmentForm()) &&
                Objects.equals(getHeadOfState(), country.getHeadOfState()) &&
                Objects.equals(getCode2(), country.getCode2());
    }

     */

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
                ", Capital=" + Capital +
                ", code2='" + code2 + '\'' +
                '}';
    }
}
