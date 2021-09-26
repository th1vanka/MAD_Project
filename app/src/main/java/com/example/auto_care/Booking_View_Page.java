package com.example.auto_care;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Booking_View_Page extends AppCompatActivity {

    Button btn,confirm;
    EditText id,type,km,uname,mail,date;
    private DbHandler dbHandler;
    private Context context;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_view_page);

        btn=findViewById(R.id.booking_delete_btn);
        confirm=findViewById(R.id.booking_confirm_btn);


        context=this;
        dbHandler=new DbHandler(context);

        id=findViewById(R.id.id);
        type=findViewById(R.id.booking_cus_vtype);
        km=findViewById(R.id.booking_cus_meterReading);
        uname=findViewById(R.id.booking_cus_Name);
        mail=findViewById(R.id.booking_cus_mail);
        date=findViewById(R.id.booking_date);



        Intent i = getIntent();
        String idd=i.getStringExtra("id");
        String typee=i.getStringExtra("type");
        String kmm=i.getStringExtra("km");
        String unamee=i.getStringExtra("uname");
        String maill=i.getStringExtra("mail");
        String datee=i.getStringExtra("date");


        id.setText(idd);
        type.setText(typee);
        km.setText(kmm);
        uname.setText(unamee);
        mail.setText(maill);
        date.setText(datee);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbHandler.deletebooking(maill);
                Intent send = new Intent( Booking_View_Page.this, Booking_Details_Page.class );
                startActivity(send);

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                booking book = new booking( idd, typee,kmm,unamee ,maill, datee);
                dbHandler.CompleteBookings(book);

                Toast.makeText(Booking_View_Page.this,"Successfully added",Toast.LENGTH_LONG).show();

                dbHandler.deletebooking(maill);

                Intent send = new Intent( Booking_View_Page.this, Booking_Details_Page.class );
                startActivity(send);

            }
        });
//                String id="1";
//                String type="abc";
//                String km="def";
//                String uname="ghi";
//                String mail="gggs";
//                String date="m";
//                booking book = new booking(id, type, km, uname,mail,date);
//                dbHandler.addBookings(book);
//                Toast.makeText(Booking_View_Page.this,"Successfully added",Toast.LENGTH_LONG).show();

//                builder.setTitle("Alert")
//                        .setMessage("Do you want to delete this user")
//                        .setCancelable(true)
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {



//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                dialogInterface.cancel();
//                            }
//                        })
//                        .show();






    }
}