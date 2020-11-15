package com.example.oderfood.model;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("_id")
    private String id;

    @SerializedName("nameCategory")
    private String nameCategory;

    public Category(String id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
