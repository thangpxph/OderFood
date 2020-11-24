package com.example.oderfood.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.oderfood.R;
import com.example.oderfood.model.request.LoginRequest;
import com.example.oderfood.model.request.SignUpRequest;
import com.example.oderfood.model.response.LoginResponse;
import com.example.oderfood.model.response.SignUpResponse;
import com.example.oderfood.network.ApiClient;
import com.example.oderfood.service.ApiService;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private ImageView ivBack;
    private EditText edHoVaTen;
    private EditText edSoDienThoai;
    private EditText edPassword;
    private SignUpRequest signUpRequest;
    private Button btnDangKy;
    private String msg;
    SignUpResponse signUpResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        edHoVaTen = (EditText) findViewById(R.id.edHoVaTen);
        edSoDienThoai = (EditText) findViewById(R.id.edSoDienThoai);
        edPassword = (EditText) findViewById(R.id.edPassword);
        signUpResponse = new SignUpResponse();
        btnDangKy = (Button) findViewById(R.id.btnDangKy);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codeSoDienThoai = edSoDienThoai.getText().toString();
                String edtFullName = edHoVaTen.getText().toString();
                String codePassword = edPassword.getText().toString();
                signUpRequest = new SignUpRequest(edtFullName,codeSoDienThoai, codePassword);
               msg = register(signUpRequest);
               Log.d("msg",""+msg);
            }
        });
    }

    private String register(SignUpRequest signUpRequest) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<SignUpResponse> call = apiService.register(signUpRequest);
        call.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
               signUpResponse = response.body();
                Toast.makeText(SignUpActivity.this, signUpResponse.getNotificationString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {

            }
        });

        return signUpResponse.getNotificationString();

    }
}