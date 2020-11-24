package com.example.oderfood.model;

import com.google.gson.annotations.SerializedName;

public class Food {
    private String id;

    @SerializedName("nameDish")
    private String nameDish;

    @SerializedName("time")
    private String time;

    @SerializedName("category")
    private String category;

    @SerializedName("price")
    private int price;

    @SerializedName("urlImage")
    private String urlImage;

    @SerializedName("ingredient")
    private String ingredient;


    public Food(String id, String nameDish, String time, String category, int price, String urlImage, String ingredient) {
        this.id = id;
        this.nameDish = nameDish;
        this.time = time;
        this.category = category;
        this.price = price;
        this.urlImage = urlImage;
        this.ingredient = ingredient;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameDish() {
        return nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
