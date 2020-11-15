package com.example.oderfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.oderfood.R;
import com.example.oderfood.model.Category;
import com.example.oderfood.model.Food;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.example.oderfood.network.ApiClient.BASE_URL;

public class CategoryManagerAdapter extends RecyclerView.Adapter<CategoryManagerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Food> foodList;

    public CategoryManagerAdapter(Context context, ArrayList<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryManagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryManagerAdapter.ViewHolder holder, int position) {
        Glide
                .with(context)
                .load(BASE_URL+foodList.get(position).getUrlImage())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgCategory);
        holder.tvNameCategory.setText(foodList.get(position).getNameDish());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategory;
        TextView tvNameCategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategory = itemView.findViewById(R.id.img_category);
            tvNameCategory = itemView.findViewById(R.id.tv_name_category);
        }
    }
}
