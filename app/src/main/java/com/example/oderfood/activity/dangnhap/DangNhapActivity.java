package com.example.oderfood.activity.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.oderfood.R;
import com.example.oderfood.activity.MainActivity;
import com.example.oderfood.activity.dangky.DangKyActivity;
import com.example.oderfood.model.User;
import com.example.oderfood.sql.UserSql;

public class DangNhapActivity extends AppCompatActivity {

    private  Button btnDangNhap;
    private UserSql userSql;

     private EditText edtEmail,edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtMatKhau);

        btnDangNhap = findViewById(R.id.btnDangNhap);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("");
        if (bundle != null){
            edtEmail.setText(bundle.getString(""));

        }
    }
}