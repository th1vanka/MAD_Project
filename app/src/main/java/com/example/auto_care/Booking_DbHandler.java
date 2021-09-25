package com.example.auto_care;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Booking_DbHandler extends SQLiteOpenHelper {

    private static final int VERSION=1;
    private static final String DB_NAME="AutoCare";
    private static final String TABLE_NAME="booking";

    private static final String ID ="Vehicle_ID";
    private static final String TYPE ="Vehicle_Type";
    private static final String KM ="Km_per_day";
    private static final String NAME ="UserName";
    private static final String MAIL="Email";
    private static final String DATE="Date";


    public Booking_DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY="CREATE TABLE "+TABLE_NAME+" "+"("
                +ID+" TEXT,"
                +TYPE+" TEXT,"
                +KM+" TEXT,"
                +NAME+" TEXT,"
                +MAIL+" TEXT,"
                +DATE+" TEXT"+
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

    //add booking details

    public void addBookings(booking booking){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(ID,booking.getVehicle_ID() );
        contentValues.put(TYPE,booking.getVehicle_Type() );
        contentValues.put(KM,booking.getKm_per_day() );
        contentValues.put(NAME,booking.getUserName() );
        contentValues.put(MAIL,booking.getEmail() );
        contentValues.put(DATE,booking.getDate());

        //save to table

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        //if you want you can close the database
        sqLiteDatabase.close();

    }





    //get all BOOKING details

    public List<booking> getBookDetails(){
        List<booking> book =new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                booking booking = new booking();

                booking.setVehicle_ID(cursor.getString(0));
                booking.setVehicle_Type(cursor.getString(1));
                booking.setKm_per_day(cursor.getString(2));
                booking.setUserName(cursor.getString(3));
                booking.setEmail(cursor.getString(4));
                booking.setDate(cursor.getString(5));

                book.add(booking);
            }while (cursor.moveToNext());
        }
        return book;
    }

















}
