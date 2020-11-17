package com.example.oderfood.service;

import com.example.oderfood.model.Category;
import com.example.oderfood.model.Food;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/api/getAllDish")
    Call<List<Food>> getFood();

    @GET("/api/getCategory")
    Call<ArrayList<Category>> getCategory();
}
