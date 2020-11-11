package com.example.oderfood.activity.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.oderfood.R;
import com.example.oderfood.activity.dangky.DangKyActivity;
import com.example.oderfood.activity.gui.GuiActivity;

public class DangNhapActivity extends AppCompatActivity {

    private Button btnDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        btnDangNhap = findViewById(R.id.btnDangNhap);
    }

    public void dangKy(View view) {
        transferView(DangKyActivity.class);
    }

    public void quenMatKhau(View view) {
        transferView(GuiActivity.class);
    }

    private void transferView(Class<?> classz) {
        startActivity(new Intent(DangNhapActivity.this, classz));
    }
}