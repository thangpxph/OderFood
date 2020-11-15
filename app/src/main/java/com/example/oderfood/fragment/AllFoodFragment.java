package com.example.oderfood.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oderfood.R;
import com.example.oderfood.activity.CategoryManagerActivity;
import com.example.oderfood.adapter.CategoryManagerAdapter;
import com.example.oderfood.model.Food;
import com.example.oderfood.network.ApiClient;
import com.example.oderfood.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllFoodFragment extends Fragment {

    List<Food> foodList;
    RecyclerView recyclerView;
    CategoryManagerAdapter recyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_food, container, false);
        foodList = new ArrayList<Food>();
        recyclerView = view.findViewById(R.id.rcvDish);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new CategoryManagerAdapter(getContext(), (ArrayList<Food>) foodList);
        recyclerView.setAdapter(recyclerAdapter);


        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Food>> call = apiService.getFood();

        call.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {

            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {

            }
        });


        return view;
    }
}