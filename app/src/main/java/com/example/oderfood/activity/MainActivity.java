package com.example.oderfood.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.example.oderfood.R;
import com.example.oderfood.adapter.CategoryPagerAdapter;
import com.example.oderfood.model.Food;
import com.example.oderfood.network.ApiClient;
import com.example.oderfood.service.ApiService;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_Layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        viewPager.setAdapter(new CategoryPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);


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
    }
}