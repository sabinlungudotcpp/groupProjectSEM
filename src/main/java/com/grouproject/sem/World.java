package com.grouproject.sem;

public class World {
    private int cityId;
    private int cityName;
    private int countryCode;
    private String district;
    private int population;

    public World(int cityId, int cityName, int countryCode, String district, int population) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCityName() {
        return cityName;
    }

    public void setCityName(int cityName) {
        this.cityName = cityName;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
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
        return "World{" +
                "cityId=" + cityId +
                ", cityName=" + cityName +
                ", countryCode=" + countryCode +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}
