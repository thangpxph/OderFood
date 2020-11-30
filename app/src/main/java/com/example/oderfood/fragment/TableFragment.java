package com.example.oderfood.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oderfood.R;
import com.example.oderfood.adapter.CategoryManagerAdapter;
import com.example.oderfood.adapter.TableAdapter;
import com.example.oderfood.model.Food;
import com.example.oderfood.model.Table;
import com.example.oderfood.network.ApiClient;
import com.example.oderfood.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TableFragment extends Fragment {
    ArrayList<Table> tableLists;
    RecyclerView recyclerView;
    TableAdapter tableAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_table, container, false);
        tableLists = new ArrayList<Table>();
        recyclerView = view.findViewById(R.id.rcv_table);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        tableAdapter = new TableAdapter(getContext(),tableLists);
        recyclerView.setAdapter(tableAdapter);

        tableLists.add(new Table("1","ban 1",6,2));
        tableLists.add(new Table("1","ban 1",6,2));
        tableLists.add(new Table("1","ban 1",6,2));
        tableLists.add(new Table("1","ban 1",6,2));
        tableLists.add(new Table("1","ban 1",6,2));



        //Retrieve token wherever necessary
//        SharedPreferences preferences = getActivity().getSharedPreferences("my_app", Context.MODE_PRIVATE);
//        String getToken  = preferences.getString("token",null);
//
//        ApiService apiService = ApiClient.getClient().create(ApiService.class);
//        Call<List<Table>> call = apiService.getTables(getToken);
//
//        call.enqueue(new Callback<List<Table>>() {
//            @Override
//            public void onResponse(Call<List<Table>> call, Response<List<Table>> response) {
//                tableLists = (ArrayList<Table>) response.body();
//                Log.d("TAG","Response = "+tableLists);
//                tableAdapter.setTableList(tableLists);
//            }
//
//            @Override
//            public void onFailure(Call<List<Table>> call, Throwable t) {
//
//            }
//        });
        return view;
    }
}