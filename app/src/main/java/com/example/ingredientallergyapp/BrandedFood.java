package com.example.ingredientallergyapp;

public class BrandedFood {

    private int nbdNumber;
    private String foodName;
    private String manufacturer;
    private String ingredients;

    public BrandedFood (int nbdNumber, String foodName, String manufacturer, String ingredients) {
        this.nbdNumber = nbdNumber;
        this.foodName = foodName;
        this.manufacturer = manufacturer;
        this.ingredients = ingredients;
    }

    public int getNbdNumber() {
        return nbdNumber;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getIngredients() {
        return ingredients;
    }


}
