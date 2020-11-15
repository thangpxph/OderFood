package com.example.oderfood.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.oderfood.R;
import com.example.oderfood.adapter.CategoryManagerAdapter;
import com.example.oderfood.model.Category;
import com.example.oderfood.model.Food;

import java.util.ArrayList;
import java.util.List;

public class CategoryManagerActivity extends AppCompatActivity {
    Window window;
    ArrayList<Category> categoryList;
    RecyclerView rvCategory;
    CategoryManagerAdapter categoryManagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_manager);
        getById();
        if (Build.VERSION.SDK_INT>=21){
            window=this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        }
        init();
    }

    private void getById() {
        rvCategory = findViewById(R.id.rv_category);
    }

    private void init() {
        categoryList =new ArrayList<>();
        addCategory();
        categoryManagerAdapter = new CategoryManagerAdapter(this, categoryList);
        LinearLayoutManager manager = new LinearLayoutManager(CategoryManagerActivity.this,LinearLayoutManager.VERTICAL, false);
        rvCategory.setLayoutManager(manager);
        rvCategory.setAdapter(categoryManagerAdapter);
    }
    public void addCategory(){
        categoryList.add(new Category(R.drawable.orange, "Món khai vị"));
        categoryList.add(new Category(R.drawable.chili, "Món nướng"));
        categoryList.add(new Category(R.drawable.lau, "Món lẩu"));
        categoryList.add(new Category(R.drawable.orange, "Món khai vị"));
        categoryList.add(new Category(R.drawable.chili, "Món nướng"));
        categoryList.add(new Category(R.drawable.lau, "Món lẩu"));
}
}