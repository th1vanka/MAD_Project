package com.example.auto_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class order_update_page extends AppCompatActivity {

    EditText oid,cusname,cusmail,itemid,itemname,qun,date;
    Button aupdate,odel;

    private DbHandler dbHandler;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_update_page);


        context=this;
        dbHandler=new DbHandler(context);

        aupdate=findViewById(R.id.uorderdelete_btn);
        odel=findViewById(R.id.uconfirm_btn);


        oid=findViewById(R.id.uoid);
        cusname=findViewById(R.id.ucusname);
        cusmail=findViewById(R.id.ucusEmail);
        itemid=findViewById(R.id.uitemId);
        itemname=findViewById(R.id.uitemname);
        qun=findViewById(R.id.uqun);
        date=findViewById(R.id.udate);

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

        String idd=oid.getText().toString();



        aupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cname=cusname.getText().toString();
                String cmail=cusmail.getText().toString();
                String iid=itemid.getText().toString();
                String iname=itemname.getText().toString();
                String iqun=qun.getText().toString();
                String idate=date.getText().toString();

                Order order=new Order(idd,cname,cmail,iid,iname,iqun,idate);

                int status= dbHandler.updateOrder(order);
                Intent send = new Intent( order_update_page.this, user_admin_home.class );
                startActivity(send);

                if(status==1){
                    Toast.makeText(order_update_page.this,"Successfully updated",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(order_update_page.this,"error",Toast.LENGTH_LONG).show();

                }



            }
        });

        odel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler.deleteOrders(idd);
                Toast.makeText(order_update_page.this,"Successfully deleted",Toast.LENGTH_LONG).show();
                Intent send = new Intent( order_update_page.this, user_admin_home.class );
                startActivity(send);
            }
        });





    }
}