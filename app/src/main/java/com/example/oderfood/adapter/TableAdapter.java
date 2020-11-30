package com.example.oderfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oderfood.R;
import com.example.oderfood.callback.TableCallback;
import com.example.oderfood.model.Food;
import com.example.oderfood.model.Table;

import java.util.ArrayList;
import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.Tableholder> {
    Context context;
    List<Table> listTable;
    private TableCallback tableCallback;


    public TableAdapter(Context context, List<Table> listTable) {
        this.context = context;
        this.listTable = listTable;
    }

//    public void setItemClickListener(TableCallback listener) {
//        this.tableCallback = listener;
//    }

    public void setTableList(ArrayList<Table> tables) {
        this.listTable = tables;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Tableholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_table, parent, false);
        return new Tableholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tableholder holder, int position) {
        Table table = listTable.get(position);
        holder.nameTable.setText(table.getNameTable());
        holder.tvStatus.setText(table.getStatus()+"");
//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listTable.size();
    }

    public class Tableholder extends RecyclerView.ViewHolder{
       TextView nameTable;
       TextView tvStatus;
       Button button;
        public Tableholder(@NonNull View itemView) {
            super(itemView);
            nameTable = (TextView) itemView.findViewById(R.id.name_table);
            tvStatus = (TextView) itemView.findViewById(R.id.tv_status);
            button = (Button) itemView.findViewById(R.id.button);

        }

    }
}
