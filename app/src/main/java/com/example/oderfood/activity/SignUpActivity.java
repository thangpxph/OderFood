package com.example.oderfood.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.oderfood.R;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignUpActivity extends AppCompatActivity {
    private ImageView ivBack;
    private EditText edHoVaTen;
    private EditText edSoDienThoai;
    private EditText edPassword;
    private Button btnDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        edHoVaTen = (EditText) findViewById(R.id.edHoVaTen);
        edSoDienThoai = (EditText) findViewById(R.id.edSoDienThoai);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btnDangKy = (Button) findViewById(R.id.btnDangKy);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codeSoDienThoai=SignUpActivity.md5(edSoDienThoai.getText().toString());
                String codePassword=SignUpActivity.md5(edPassword.getText().toString());
                Toast.makeText(SignUpActivity.this, "dt"+codeSoDienThoai+"password"+codePassword, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static String md5(String str){
        String result="";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1,digest.digest());
            result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}