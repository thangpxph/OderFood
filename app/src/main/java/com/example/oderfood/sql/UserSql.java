package com.example.oderfood.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.oderfood.model.User;

public class UserSql extends SQLiteOpenHelper {
    public UserSql(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }
    public static final String TABLE_NAME = "User";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_SOLANTOIAN = "solantoian";
    public static final String COLUMN_DANHGIA = "danhgia";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY," +
                ""+COLUMN_EMAIL+" VARCHAR,"+COLUMN_PASSWORD+" VARCHAR,"+COLUMN_PHONE+" VARCHAR,"+COLUMN_SOLANTOIAN+" VARCHAR,"+COLUMN_DANHGIA+" VARCHAR)";
        Log.e("SQL",CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

   public long insertUser(User user){
       SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put(COLUMN_ID,user.getId());
       contentValues.put(COLUMN_EMAIL,user.getEmail());
       contentValues.put(COLUMN_PASSWORD,user.getPassword());
       contentValues.put(COLUMN_PHONE,user.getPhone());
       contentValues.put(COLUMN_SOLANTOIAN,user.getSolantoian());
       contentValues.put(COLUMN_DANHGIA,user.getDanhgia());

      long result =  sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        return  result;
    }
    
}
