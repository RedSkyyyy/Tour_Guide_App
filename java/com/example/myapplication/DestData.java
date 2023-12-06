package com.example.myapplication;

public class DestData {

    String placeName;
    String countryName;
    Integer imageUrl;

    public DestData(String placeName, String countryName, Integer imageUrl) {
        this.placeName = placeName;
        this.countryName = countryName;
        this.imageUrl = imageUrl;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
