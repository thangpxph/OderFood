package com.example.oderfood.service;

import com.example.oderfood.model.Category;
import com.example.oderfood.model.Food;
import com.example.oderfood.model.Table;
import com.example.oderfood.model.request.LoginRequest;
import com.example.oderfood.model.request.SignUpRequest;
import com.example.oderfood.model.response.LoginResponse;
import com.example.oderfood.model.response.SignUpResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("/api/getAllDish")
    Call<List<Food>> getFood();

    @GET("/api/getCategory")
    Call<ArrayList<Category>> getCategory();

    @GET("/api/getAllTable")
    Call<ArrayList<Table>> getTable();

    @POST("api/v1/login")
    Call<LoginResponse> postLogin(@Body LoginRequest loginRequest);

    @POST("api/v1/signin")
    Call<SignUpResponse> register(@Body SignUpRequest signUpRequest);
}
