package com.example.auto_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.SplittableRandom;

public class DbHandler extends SQLiteOpenHelper{

    private static final int VERSION=1;

    private static final String DB_NAME="AutoCare";


    // admin cus database table column names
    private static final String TABLE_NAME6="customer";

    private static final String NAME ="name";
    private static final String USERNAME ="username";
    private static final String EMAIL ="email";
    private static final String PHONE ="phoneNumber";
    private static final String PASSWORD="password";

    //admin bookings
    private static final String TABLE2_NAME7="booking";

    private static final String AID ="Vehicle_ID";
    private static final String ATYPE ="Vehicle_Type";
    private static final String AKM ="Km_per_day";
    private static final String ANAME ="UserName";
    private static final String AMAIL="Email";
    private static final String ADATE="Date";

    //admin complete bookings

    private static final String TABLE3_NAME8="complete_booking";

    private static final String CID ="Vehicle_ID";
    private static final String CTYPE ="Vehicle_Type";
    private static final String CKM ="Km_per_day";
    private static final String CNAME ="UserName";
    private static final String CMAIL="Email";
    private static final String CDATE="Date";


    //admin Order part

    private static final String TABLE4_NAME9="customer_order";

    private static final String OID ="order_Id";
    private static final String OCUSNAME ="customer_Name";
    private static final String OCUSEMAIL ="customer_Email";
    private static final String OITEMID ="item_Id";
    private static final String OITEMNAME ="item_Name";
    private static final String OQUN="Qun";
    private static final String ODATE="Date";



    public DbHandler(@Nullable Context context) {
        super(context,DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY6="CREATE TABLE "+TABLE_NAME6+" "+"("
                +NAME+" TEXT,"
                +USERNAME+" TEXT,"
                +EMAIL+" TEXT,"
                +PHONE+" TEXT,"
                +PASSWORD+" TEXT"+
                ");";

        db.execSQL(TABLE_CREATE_QUERY6);

        String TABLE2_CREATE_QUERY7="CREATE TABLE "+TABLE2_NAME7+" "+"("
                +AID+" TEXT,"
                +ATYPE+" TEXT,"
                +AKM+" TEXT,"
                +ANAME+" TEXT,"
                +AMAIL+" TEXT,"
                +ADATE+" TEXT"+
                ");";

        db.execSQL(TABLE2_CREATE_QUERY7);


        String TABLE3_CREATE_QUERY8="CREATE TABLE "+TABLE3_NAME8+" "+"("
                +CID+" TEXT,"
                +CTYPE+" TEXT,"
                +CKM+" TEXT,"
                +CNAME+" TEXT,"
                +CMAIL+" TEXT,"
                +CDATE+" TEXT"+
                ");";

        db.execSQL(TABLE3_CREATE_QUERY8);

        String TABLE4_CREATE_QUERY9="CREATE TABLE "+TABLE4_NAME9+" "+"("
                +OID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +OCUSNAME+" TEXT,"
                +OCUSEMAIL+" TEXT,"
                +OITEMID+" TEXT,"
                +OITEMNAME+" TEXT,"
                +OQUN+" TEXT,"
                +ODATE+" TEXT"+
                ");";

        db.execSQL(TABLE4_CREATE_QUERY9);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {
        String DROP_TABLE_QUERY6=" DROP TABLE IF EXISTS "+TABLE_NAME6;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY6);
        // create tables again
        onCreate(db);


        String DROP_TABLE_QUERY7=" DROP TABLE IF EXISTS "+TABLE2_NAME7;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY7);
        // create tables again
        onCreate(db);

        String DROP_TABLE_QUERY8=" DROP TABLE IF EXISTS "+TABLE3_NAME8;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY8);
        // create tables again
        onCreate(db);

        String DROP_TABLE_QUERY9=" DROP TABLE IF EXISTS "+TABLE4_NAME9;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY9);
        // create tables again
        onCreate(db);




    }

    //add customer details

    public void addCustomer(AddCustomers cus){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(NAME,cus.getCusName());
        contentValues.put(USERNAME,cus.getCusUserName());
        contentValues.put(EMAIL,cus.getCusEmail());
        contentValues.put(PHONE,cus.getPhone());
        contentValues.put(PASSWORD,cus.getPPassword());

        //save to table

        sqLiteDatabase.insert(TABLE_NAME6,null,contentValues);
        //if you want you can close the database
        sqLiteDatabase.close();

    }

    //get all cus details

    public List<AddCustomers> getAllDetails(){
        List<AddCustomers> cus =new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME6;

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                AddCustomers addCustomers = new AddCustomers();

                addCustomers.setCusName(cursor.getString(0));
                addCustomers.setCusUserName(cursor.getString(1));
                addCustomers.setCusEmail(cursor.getString(2));
                addCustomers.setPhone(cursor.getString(3));
                addCustomers.setPassword(cursor.getString(4));

                cus.add(addCustomers);
            }while (cursor.moveToNext());
        }
        return cus;
    }

    //item delete
    public void deleteCus(String mail){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME6,EMAIL +" =?", new String[]{String.valueOf(mail)});
        sqLiteDatabase.close();
    }

    //customer count
    public int countCustomers(){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String query= "SELECT * FROM " + TABLE_NAME6;

        Cursor cursor= sqLiteDatabase.rawQuery(query,null);
        return cursor.getCount();
    }






    //add booking details

    public void addBookings(booking booking){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(AID,booking.getVehicle_ID() );
        contentValues.put(ATYPE,booking.getVehicle_Type() );
        contentValues.put(AKM,booking.getKm_per_day() );
        contentValues.put(ANAME,booking.getUserName() );
        contentValues.put(AMAIL,booking.getEmail() );
        contentValues.put(ADATE,booking.getDate());

        //save to table

        sqLiteDatabase.insert(TABLE2_NAME7,null,contentValues);
        //if you want you can close the database
        sqLiteDatabase.close();

    }

    //get all BOOKING details

    public List<booking> getBookDetails(){
        List<booking> book =new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE2_NAME7;

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

    //booking delete
    public void deletebooking(String mail){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete(TABLE2_NAME7,EMAIL +" =?", new String[]{String.valueOf(mail)});
        sqLiteDatabase.close();
    }


    //add complete bookings

    public void CompleteBookings(booking book){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(CID,book.getVehicle_ID());
        contentValues.put(CTYPE,book.getVehicle_Type());
        contentValues.put(CKM,book.getKm_per_day());
        contentValues.put(CNAME,book.getUserName());
        contentValues.put(CMAIL,book.getEmail());
        contentValues.put(CDATE,book.getDate());

        //save to table

        sqLiteDatabase.insert(TABLE3_NAME8,null,contentValues);
        //if you want you can close the database
        sqLiteDatabase.close();

    }

    //get all Complete BOOKING details

    public List<booking> getCompleteBookDetails(){
        List<booking> book =new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE3_NAME8;

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


    //get all orders

    public List<Order> getorderDetails(){
        List<Order> orders =new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE4_NAME9;

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Order order = new Order();

                int i=Integer.parseInt(cursor.getString(0));

                order.setOid(i);
                order.setCusname(cursor.getString(1));
                order.setCusEmail(cursor.getString(2));
                order.setItemId(cursor.getString(3));
                order.setItemname(cursor.getString(4));
                order.setQun(cursor.getString(5));
                order.setDates(cursor.getString(6));

                orders.add(order);
            }while (cursor.moveToNext());
        }
        return orders;
    }


    //add orders details

//    public void addorders(Order order){
//        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//
//        contentValues.put(OID,order.getOid());
//        contentValues.put(OCUSNAME,order.getCusname());
//        contentValues.put(OCUSEMAIL,order.getCusEmail());
//        contentValues.put(OITEMID,order.getItemId());
//        contentValues.put(OITEMNAME,order.getItemname());
//        contentValues.put(OQUN,order.getQun());
//        contentValues.put(ODATE,order.getDates());
//
//        //save to table
//
//        sqLiteDatabase.insert(TABLE4_NAME9,null,contentValues);
//        //if you want you can close the database
//        sqLiteDatabase.close();
//
//    }
    //oreder update
    public int updateOrder(Order order){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();


        contentValues.put(OCUSNAME,order.getCusname());
        contentValues.put(OCUSEMAIL,order.getCusEmail());
        contentValues.put(OITEMID,order.getItemId());
        contentValues.put(OITEMNAME,order.getItemname());
        contentValues.put(OQUN,order.getQun());
        contentValues.put(ODATE,order.getDates());

        int status=sqLiteDatabase.update(TABLE4_NAME9,contentValues,OID +" =?",new String[]{String.valueOf(order.getOid())});
        sqLiteDatabase.close();

        return status;
    }

    //order delete
    public void deleteOrders(String id){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete(TABLE4_NAME9,OID +" =?", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }












}


