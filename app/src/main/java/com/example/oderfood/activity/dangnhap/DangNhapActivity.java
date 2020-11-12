package com.example.oderfood.activity.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oderfood.R;
import com.example.oderfood.activity.MainActivity;
import com.example.oderfood.activity.dangky.DangKyActivity;
import com.example.oderfood.activity.gui.GuiActivity;
import com.example.oderfood.model.User;
import com.example.oderfood.sql.UserSql;

public class DangNhapActivity extends AppCompatActivity {

    private Button btnDangNhap;
    private EditText edtEmail, edtPassWord;
    UserSql userSql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        edtEmail = findViewById(R.id.edtEmailDN);
        edtPassWord = findViewById(R.id.edtMatKhauDN);
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

    public void checkLogin(View view) {
        Log.i("info", "check login");
        userSql = new UserSql(this);
        String email = edtEmail.getText().toString();
        String password = edtPassWord.getText().toString();
        Log.i("info",email+ " : " + password);
        User result = userSql.getUser(email);
        Log.i("info",result.toString());
        if (null != result && password.equals(result.getPassword())) {
            Toast.makeText(getBaseContext(), "Đăng Nhập thành công", Toast.LENGTH_SHORT).show();
            Log.i("info","Login thanh cong");
            transferView(MainActivity.class);
        } else {
            Toast.makeText(getBaseContext(), "Đăng nhập thất bại,vui lòng kiểm tra lại ", Toast.LENGTH_SHORT).show();
            Log.i("info","Login that bai");
        }
    }
}