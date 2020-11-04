package com.example.oderfood.activity.dangky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.oderfood.R;
import com.example.oderfood.model.User;
import com.example.oderfood.sql.UserSql;

public class DangKyActivity extends AppCompatActivity {

    private UserSql userSql;

    Button btnDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        userSql = new UserSql(DangKyActivity.this);

        btnDangKy =findViewById(R.id.btnDangKy);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setId("" + System.currentTimeMillis());
                user.setEmail("");
                user.setPhone("");
                long result = userSql.insertUser(user);
                if (result > 0){
                    Toast.makeText(DangKyActivity.this, "Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DangKyActivity.this, "Đăng Ký Không Thành Công", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}