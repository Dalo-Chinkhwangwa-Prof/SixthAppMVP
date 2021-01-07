package com.americanairlines.mysixthappmvp.model;

public class Shoe {

    private int shoeSize;
    private String shoeModel;
    private double shoePrice;
    private int shoeID;

    public Shoe(int shoeSize, String shoeModel, double shoePrice) {
        this.shoeSize = shoeSize;
        this.shoeModel = shoeModel;
        this.shoePrice = shoePrice;
    }

    public Shoe(int shoeSize, String shoeModel, double shoePrice, int shoeID) {
        this.shoeSize = shoeSize;
        this.shoeModel = shoeModel;
        this.shoePrice = shoePrice;
        this.shoeID = shoeID;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    public String getShoeModel() {
        return shoeModel;
    }

    public void setShoeModel(String shoeModel) {
        this.shoeModel = shoeModel;
    }

    public int getShoeID() {
        return shoeID;
    }

    public double getShoePrice() {
        return shoePrice;
    }

    public void setShoePrice(double shoePrice) {
        this.shoePrice = shoePrice;
    }
}
