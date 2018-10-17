package com.safi.save_and_show_data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelperPerson extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="person.db";
    private static final int VERSION_NUMBER= 2;
    private static final String TABLE_NAME="person";
    private static final String NAME="name";
    private static final String EMAIL="email";
    private static final String MOBILE="mobile";
    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+NAME+" VARCHAR(20),"+EMAIL+" VARCHAR(20),"+MOBILE+" VARCHAR(20));";
    private static final String SHOW_DATA="SELECT * FROM "+TABLE_NAME;
    public DbHelperPerson(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.e("DATABASE OPERATION","Table Created Successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean saveData(String name,String email,String mobile){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(EMAIL,email);
        contentValues.put(MOBILE,mobile);
        database.insert(TABLE_NAME,null,contentValues);
        return true;
    }
    public Cursor getPersonDeatails(){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor result=database.rawQuery(SHOW_DATA,null);
        return result;
    }
}
