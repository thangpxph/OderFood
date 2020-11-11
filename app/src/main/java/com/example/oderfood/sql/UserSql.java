package com.example.oderfood.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.oderfood.model.User;

public class UserSql extends SQLiteOpenHelper {
    public UserSql(Context context) {
        super(context, "user.db", null, 1);
    }

    UserSql userSql;

    public static final String TABLE_NAME = "User";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_SOLANTOIAN = "solantoian";
    public static final String COLUMN_DANHGIA = "danhgia";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY," +
                "" + COLUMN_EMAIL + " VARCHAR," + COLUMN_PASSWORD + " VARCHAR," + COLUMN_NAME + " VARCHAR," + COLUMN_PHONE + " VARCHAR," + COLUMN_SOLANTOIAN + " VARCHAR," + COLUMN_DANHGIA + " VARCHAR)";
        Log.i("SQL", CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertUser(User user) {
        SQLiteDatabase sqLiteDatabase = null;
        Log.i("user input: {}",user.toString());
        try {
            sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_ID, user.getId());
            contentValues.put(COLUMN_EMAIL, user.getEmail());
            contentValues.put(COLUMN_PASSWORD, user.getPassword());
            contentValues.put(COLUMN_NAME, user.getName());
            contentValues.put(COLUMN_PHONE, user.getPhone());
            contentValues.put(COLUMN_SOLANTOIAN, user.getSolantoian());
            contentValues.put(COLUMN_DANHGIA, user.getDanhgia());
            return sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            Log.e("insertUser have ex: ", e.toString());
        } finally {
            if (null != sqLiteDatabase) {
                sqLiteDatabase.close();
            }
        }
        return 0;
    }

//    public boolean isLogin(User user){
//        String sqlSelect = "SELECT email, password from User WHERE email =? and password =?";
//        String email = user.getEmail();
//        String password = user.getPassword();
//    }

}