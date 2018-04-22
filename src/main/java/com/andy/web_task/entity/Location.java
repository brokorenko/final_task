package com.andy.web_task.entity;

import java.io.Serializable;

public class Location implements Serializable {
    private static final long serialVersionUID = -30186617539844222L;
    private int companyId;
    private String country;
    private String city;
    private String street;
    private int building;
    private String coordinate;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(this.getClass() == o.getClass())) return false;

        Location location = (Location) o;

        if (companyId != location.companyId) return false;
        if (building != location.building) return false;
        if (!country.equals(location.country)) return false;
        if (!city.equals(location.city)) return false;
        if (!street.equals(location.street)) return false;
        return coordinate.equals(location.coordinate);
    }

    @Override
    public int hashCode() {
        int result = companyId;
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + building;
        result = 31 * result + coordinate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "companyId=" + companyId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building=" + building +
                ", coordinate='" + coordinate + '\'' +
                '}';
    }
}
