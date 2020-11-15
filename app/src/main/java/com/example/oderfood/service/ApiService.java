package com.example.oderfood.service;

import com.example.oderfood.model.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/api/getAllDish")
    Call<List<Food>> getFood();
}
