package com.example.auto_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class order_page extends AppCompatActivity {

    EditText oid,cusname,cusmail,itemid,itemname,qun,date;
    Button update,conplete;


    private DbHandler dbHandler;
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);


        context=this;
        dbHandler=new DbHandler(context);

        update=findViewById(R.id.orderdelete_btn);
        conplete=findViewById(R.id.confirm_btn);


        oid=findViewById(R.id.oid);
        cusname=findViewById(R.id.cusname);
        cusmail=findViewById(R.id.cusEmail);
        itemid=findViewById(R.id.itemId);
        itemname=findViewById(R.id.itemname);
        qun=findViewById(R.id.qun);
        date=findViewById(R.id.date);

        Intent i = getIntent();
        String id=i.getStringExtra("id");
        String cname=i.getStringExtra("name");
        String cmail=i.getStringExtra("mail");
        String iiid=i.getStringExtra("iid");
        String iname=i.getStringExtra("iname");
        String iqun=i.getStringExtra("qun");
        String datee=i.getStringExtra("date");

        oid.setText(id);
        cusname.setText(cname);
        cusmail.setText(cmail);
        itemid.setText(iiid);
        itemname.setText(iname);
        qun.setText(iqun);
        date.setText( datee);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


















//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) { String a="a";
//               String b="a";
//               String c="a";
//               String d="a";
//               String e="a";
//               String f="a";
//               String g="a";
//               Order order = new Order(a,b,c,d,e,f,g);
//               dbHandler.addorders(order);
//            }
//        });


    }
}