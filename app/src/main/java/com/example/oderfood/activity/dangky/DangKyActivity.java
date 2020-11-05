package com.example.oderfood.activity.dangky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oderfood.R;
import com.example.oderfood.activity.dangnhap.DangNhapActivity;
import com.example.oderfood.model.User;
import com.example.oderfood.sql.UserSql;

public class DangKyActivity extends AppCompatActivity {

    private UserSql userSql;

    EditText edtHoTen,edtSoDienThoai,edtMatKhau;

    Button btnDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        edtHoTen = findViewById(R.id.edtHoTen);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        edtMatKhau = findViewById(R.id.edtMatKhau);


        userSql = new UserSql(DangKyActivity.this);

        btnDangKy =findViewById(R.id.btnDangKy);

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User();
                user.setName(""+ System.currentTimeMillis());
                user.setPhone("");
                user.setPassword("");

                long result = userSql.insertUser(user);

                if (result > 0){
                    Toast.makeText(DangKyActivity.this, "Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getBaseContext(), DangNhapActivity.class));

                } else {
                    Toast.makeText(DangKyActivity.this, "Đăng Ký Không Thành Công", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void btnDangKy(View view) {

        String name= edtHoTen.getText().toString();
        String sodienthoai = edtSoDienThoai.getText().toString();
        String pass = edtMatKhau.getText().toString();

        userSql = new UserSql(this);

        User user = new User();

    }
}