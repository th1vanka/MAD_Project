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

public class Customer_Delete_Page extends AppCompatActivity {

    EditText name,uname,eemail,contact;
    Button dbtn,hbtn;
    AlertDialog.Builder builder;

    Context context;
    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_delete_page);

        context = this;
        dbHandler = new DbHandler(context);

        name=findViewById(R.id.cus_DName);
        uname=findViewById(R.id.cus_uName);
        eemail=findViewById(R.id.cus_Email);
        contact=findViewById(R.id.cus_dcon);

        dbtn=findViewById(R.id.cus_delete_btn);
        hbtn=findViewById(R.id.cus_history_btn);
        builder=new AlertDialog.Builder(this);

        Intent i = getIntent();
        String namme=i.getStringExtra("name");
        String unamme=i.getStringExtra("uname");
        String email=i.getStringExtra("email");
        String con=i.getStringExtra("cont");

        name.setText(namme);
        uname.setText(unamme);
        eemail.setText(email);
        contact.setText(con);

        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Alert")
                        .setMessage("Do you want to delete this user")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dbHandler.deleteCus(email);
                                Intent send = new Intent( Customer_Delete_Page.this, Customer_View_Page.class );
                                startActivity(send);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .show();

//
//                dbHandler.deleteCus(email);
//                Intent send = new Intent( Customer_Delete_Page.this, Customer_View_Page.class );
//                startActivity(send);

            }
        });


    }
}