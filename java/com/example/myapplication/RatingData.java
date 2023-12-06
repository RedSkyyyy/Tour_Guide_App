package com.example.myapplication;

public class RatingData {

    private Float dataRate;
    private String dataComment,dataName;

    public Float getDataRate() {
        return dataRate;
    }

    public String getDataComment() {
        return dataComment;
    }

    public String getDataName() { return dataName; }

    public RatingData(Float dataRate, String dataComment) {
        this.dataRate = dataRate;
        this.dataComment = dataComment;
    }
}
