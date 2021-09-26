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

public class Order_Details_Page extends AppCompatActivity {

    Context context;
    private DbHandler dbHandler;
    private List<Order> orders;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details_page);

        context=this;
        dbHandler = new DbHandler(context);
        listView=findViewById(R.id.orderList);

        orders=new ArrayList<>();
        orders=dbHandler.getorderDetails();

        orderAdapter adapter=new orderAdapter(context,R.layout.single_order,orders);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>  parent, View view, int position, long l) {

                Order order=orders.get(position);

                  String oid=order.getOid();
                  String cusname=order.getCusname();
                  String cusEmail=order.getCusEmail();
                  String itemId=order.getItemId();
                  String itemname=order.getItemname();
                  String qun=order.getQun();
                  String date=order.getDates();

                Intent send = new Intent( Order_Details_Page.this, order_page.class );
                send.putExtra("id",oid);
                send.putExtra("name",cusname);
                send.putExtra("mail",cusEmail);
                send.putExtra("iid",itemId);
                send.putExtra("iname",itemname);
                send.putExtra("qun",qun);
                send.putExtra("date",date);

                startActivity(send);




            }
        });






    }
}