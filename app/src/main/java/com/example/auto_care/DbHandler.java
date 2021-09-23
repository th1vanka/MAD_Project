package com.example.auto_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION=2;
    private static final String DB_NAME="AutoCare";
    private static final String TABLE_NAME="customer";

    //database table column names

    private static final String NAME ="name";
    private static final String USERNAME ="username";
    private static final String EMAIL ="email";
    private static final String PHONE ="phoneNumber";
    private static final String PASSWORD="password";

    public DbHandler(@Nullable Context context) {
        super(context,DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY="CREATE TABLE "+TABLE_NAME+" "+"("
                +NAME+" TEXT,"
                +USERNAME+" TEXT,"
                +EMAIL+" TEXT,"
                +PHONE+" TEXT,"
                +PASSWORD+" TEXT"+
                ");";

        db.execSQL(TABLE_CREATE_QUERY);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {
        String DROP_TABLE_QUERY=" DROP TABLE IF EXISTS "+TABLE_NAME;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);
        // create tables again
        onCreate(db);
    }


    public void addCustomer(AddCustomers cus){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(NAME,cus.getCusName());
        contentValues.put(USERNAME,cus.getCusUserName());
        contentValues.put(EMAIL,cus.getCusEmail());
        contentValues.put(PHONE,cus.getPhone());
        contentValues.put(PASSWORD,cus.getPPassword());

        //save to table

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        //if you want you can close the database
        sqLiteDatabase.close();

    }



}


