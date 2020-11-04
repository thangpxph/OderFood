package com.example.oderfood.activity.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.oderfood.R;
import com.example.oderfood.activity.dangky.DangKyActivity;

public class DangNhapActivity extends AppCompatActivity {

    Button btnDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
                startActivity(intent);
            }
        });
    }
}