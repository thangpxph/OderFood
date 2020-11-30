package com.example.oderfood.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.oderfood.R;
import com.example.oderfood.model.Food;
import com.example.oderfood.model.request.LoginRequest;
import com.example.oderfood.model.response.LoginResponse;
import com.example.oderfood.network.ApiClient;
import com.example.oderfood.service.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText edtPhone;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView tvRegister;
    private TextView tvForgotPass;
    private LoginRequest loginRequest;
    LoginResponse loginResponse;
    private String phone;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        setContentView(R.layout.activity_login);
        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = edtPhone.getText().toString();
                password = edtPassword.getText().toString();
                loginRequest = new LoginRequest(phone, password);
                btnLoginOnTap(loginRequest);
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        tvForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });

    }

    private void init() {
        edtPhone = (EditText) findViewById(R.id.edt_phone);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        tvRegister = (TextView) findViewById(R.id.tv_register);
        tvForgotPass = (TextView) findViewById(R.id.tv_forgot_pass);
    }

    private void btnLoginOnTap(LoginRequest loginRequest) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<LoginResponse> call = apiService.postLogin(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginResponse = response.body();
                Log.d("login response", "res : " + loginResponse.getToken());
                SharedPreferences.Editor editor = getSharedPreferences("my_app", MODE_PRIVATE).edit();
                editor.putString("token", loginResponse.getToken());
                editor.apply();

                startActivity(new Intent(LoginActivity.this,BottomNavigation.class));
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("login response", "res fail");
            }
        });

    }
}