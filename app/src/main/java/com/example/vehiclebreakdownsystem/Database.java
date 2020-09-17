package com.example.vehiclebreakdownsystem;





import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import java.util.*;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {

        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(FullName text, Phone text,Email text2,Password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");

    }
    public boolean insert (String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1) return false;
        else return true;
    }
    public Boolean chkemail(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0) return  false;
        else return true;
    }
    //checking the email and password;
    public Boolean emailpassword(String email,String password){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0) return  true;
        else  return false;

    }
}
