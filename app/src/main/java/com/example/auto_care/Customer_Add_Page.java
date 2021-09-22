package com.example.auto_care;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Customer_Add_Page extends AppCompatActivity {

    private EditText name,Uname,email,pno;
    private Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add_page);

        name=findViewById(R.id.cus_Name);
        Uname=findViewById(R.id.cus_uName);
        email=findViewById(R.id.cus_Email);
        pno=findViewById(R.id.cus_contact);

        add=findViewById(R.id.cus_add_btn);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Cusname=name.getText().toString();
                String CusUname=Uname.getText().toString();
                String CusEmail=email.getText().toString();
                String CusPhone=pno.getText().toString();

                AddCustomers cus=new AddCustomers(Cusname,CusUname,CusEmail,CusPhone);





            }
        });
    }

}