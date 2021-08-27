package com.example.medicaresapp;

public class Model {
    private String ShopName;
    private String Address;
    private String Area;
    private String Name;
    private String Number;
    private String Email;
    private String ShopOpenTime ;
    private String  ShopCloseTime;
    private String MedicalTypes;
    private String CityName;

    public Model() {
    }

    public Model(String shopName, String address, String area, String name, String number, String email, String shopOpenTime, String shopCloseTime, String medicalTypes, String cityName) {
        ShopName = shopName;
        Address = address;
        Area = area;
        Name = name;
        Number = number;
        Email = email;
        ShopOpenTime = shopOpenTime;
        ShopCloseTime = shopCloseTime;
        MedicalTypes = medicalTypes;
        CityName = cityName;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getShopOpenTime() {
        return ShopOpenTime;
    }

    public void setShopOpenTime(String shopOpenTime) {
        ShopOpenTime = shopOpenTime;
    }

    public String getShopCloseTime() {
        return ShopCloseTime;
    }

    public void setShopCloseTime(String shopCloseTime) {
        ShopCloseTime = shopCloseTime;
    }

    public String getMedicalTypes() {
        return MedicalTypes;
    }

    public void setMedicalTypes(String medicalTypes) {
        MedicalTypes = medicalTypes;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }
}
