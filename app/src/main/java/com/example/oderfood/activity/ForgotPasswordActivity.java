package com.example.oderfood.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.oderfood.R;

public class ForgotPasswordActivity extends AppCompatActivity {
    private ImageView ivBack;
    private EditText edSoDienThoai;
    private Button btnGuiMaOTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        edSoDienThoai = (EditText) findViewById(R.id.edSoDienThoai);
        btnGuiMaOTP = (Button) findViewById(R.id.btnGuiMaOTP);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgotPasswordActivity.this,LoginActivity.class));
            }
        });
        btnGuiMaOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgotPasswordActivity.this,OtpActivity.class));
            }
        });
    }
}