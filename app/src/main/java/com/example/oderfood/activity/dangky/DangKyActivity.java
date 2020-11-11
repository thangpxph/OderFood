package com.example.oderfood.activity.dangky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    private EditText edtHoTen, edtSoDienThoai, edtMatKhau;
    private Button btnDangKy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        edtMatKhau = findViewById(R.id.edtMatKhauDK);
        userSql = new UserSql(DangKyActivity.this);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = User.builder()
                        .name(edtHoTen.getText().toString())
                        .phone(edtSoDienThoai.getText().toString())
                        .password(edtMatKhau.getText().toString())
                        .build();
                insertMsg(user);
            }
        });
    }

    private void insertMsg(User user) {

        long result = userSql.insertUser(user);
        if (result > 0) {
            alertMsg("Đăng Ký Thành Công");
            startActivity(new Intent(getBaseContext(), DangNhapActivity.class));
            return;
        }
        alertMsg("Đăng Ký Không Thành Công");
    }

    private void alertMsg(String msg) {
        Toast.makeText(DangKyActivity.this, msg, Toast.LENGTH_SHORT).show();
    }


}