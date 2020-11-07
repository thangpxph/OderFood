package com.example.oderfood.activity.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.oderfood.R;
import com.example.oderfood.activity.dangky.DangKyActivity;
import com.example.oderfood.activity.menu.MenuActivity;
import com.example.oderfood.sql.UserSql;

public class DangNhapActivity extends AppCompatActivity {

    private  Button btnDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhapActivity.this, MenuActivity.class);
                startActivity(intent);

            }
        });
    }

    public void dangKy(View view) {
        Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
        startActivity(intent);
    }
}