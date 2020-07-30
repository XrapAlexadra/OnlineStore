package com.github.xrapalexandra.kr.model;

public class ShopAddress{

    private Integer id;
    private String city;
    private String street;
    private String building;


    public ShopAddress() {
    }

    public ShopAddress(String city, String street, String building) {
        this.city = city;
        this.street = street;
        this.building = building;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "г." + city + " ,ул." + street + " ,д." + building + ".";
    }
}
