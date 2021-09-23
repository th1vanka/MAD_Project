package com.example.auto_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Customer_Delete_Page extends AppCompatActivity {

    EditText name,uname,eemail,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_delete_page);

        name=findViewById(R.id.cus_DName);
        uname=findViewById(R.id.cus_uName);
        eemail=findViewById(R.id.cus_Email);
        contact=findViewById(R.id.cus_dcon);

        Intent i = getIntent();
        String namme=i.getStringExtra("name");
        String unamme=i.getStringExtra("uname");
        String email=i.getStringExtra("email");
        String con=i.getStringExtra("cont");

        name.setText(namme);
        uname.setText(unamme);
        eemail.setText(email);
        contact.setText(con);
    }
}