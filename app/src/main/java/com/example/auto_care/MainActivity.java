package com.example.auto_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView users,order;
    Button customers,orders,bookings;

    Context context;
    private DbHandler dbHandler;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        dbHandler = new DbHandler(context);

        users=findViewById(R.id.user);
        customers=findViewById(R.id.view_cus);
        orders=findViewById(R.id.view_orders);
        bookings=findViewById(R.id.view_bookings);

        int count=dbHandler.countCustomers();
        String c=String.valueOf(count);
        users.setText(c);

        customers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent( MainActivity.this, Customer_Add_Page.class );
                startActivity(send);

            }
        });
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent( MainActivity.this, Order_Details_Page.class );
                startActivity(send);
            }
        });
        bookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent( MainActivity.this, Booking_Details_Page.class );
                startActivity(send);
            }
        });




    }
}