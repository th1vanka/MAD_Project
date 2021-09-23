package com.example.auto_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Customer_View_Page extends AppCompatActivity {

    Context context;
    private DbHandler dbHandler;
    private List<AddCustomers> cus;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view_page);

        context = this;
        dbHandler = new DbHandler(context);

        listView=findViewById(R.id.customerList);

        cus=new ArrayList<>();

        cus=dbHandler.getAllDetails();


        customerAdapter adapter=new customerAdapter(context,R.layout.single_customer,cus);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

                AddCustomers addCustomers=cus.get(position);
                String name=addCustomers.getCusName();
                String uname=addCustomers.getCusUserName();
                String email=addCustomers.getCusEmail();
                String con=addCustomers.getPhone();


                Intent send = new Intent( Customer_View_Page.this, Customer_Delete_Page.class );
                send.putExtra("name",name);
                send.putExtra("uname",uname);
                send.putExtra("email",email);
                send.putExtra("cont",con);

                startActivity(send);
            }
        });

    }
}