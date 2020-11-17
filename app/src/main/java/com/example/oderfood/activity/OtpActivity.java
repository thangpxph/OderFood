package com.example.oderfood.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.oderfood.R;

public class OtpActivity extends AppCompatActivity {
    private ImageView ivBack;
    private EditText edMaOTP;
    private Button btnXacNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        edMaOTP = (EditText) findViewById(R.id.edMaOTP);
        btnXacNhan = (Button) findViewById(R.id.btnXacNhan);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OtpActivity.this,ForgotPasswordActivity.class));
            }
        });
    }
}