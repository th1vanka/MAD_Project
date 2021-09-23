package com.example.auto_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Customer_Add_Page extends AppCompatActivity {

    private EditText name,Uname,email,pno,password,rePassword;

    private Button add ,close;

    private DbHandler dbHandler;
    private Context context;

    private int count;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add_page);

        name=findViewById(R.id.cus_DName);
        Uname=findViewById(R.id.cus_uName);
        email=findViewById(R.id.cus_Email);
        pno=findViewById(R.id.cus_contact);
        password=findViewById(R.id.cus_repass);
        rePassword=findViewById(R.id.cus_passw);

        add=findViewById(R.id.cus_add_btn);
        close=findViewById(R.id.close);

        count=pno.length();


        context=this;
        dbHandler=new DbHandler(context);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String Cusname = name.getText().toString();
                    String CusUname = Uname.getText().toString();
                    String CusEmail = email.getText().toString();
                    String CusPhone = pno.getText().toString();
                    String Cuspass=password.getText().toString();
                    String CusRepass=rePassword.getText().toString();

                   //AddCustomers cus = new AddCustomers(Cusname, CusUname, CusEmail, CusPhone);
                   //dbHandler.addCustomer(cus);

                    //mDialog.setContentView(R.layout.phoneno_popup);
                    //mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    boolean result=validation(CusPhone,Cuspass,CusRepass);
                    if(result==true){

                        AddCustomers cus = new AddCustomers(Cusname, CusUname, CusEmail, CusPhone,Cuspass);
                        dbHandler.addCustomer(cus);
                        Toast.makeText(Customer_Add_Page.this,"Successfully added",Toast.LENGTH_LONG).show();

                    }
            }
        });

    }
    public boolean validation(String number,String pass,String repass){
        if(number.length()!=10){
             pno.requestFocus();
             pno.setError("Enter the valid phone number");
            return false;
        }
        else if(repass.length()!=pass.length()){
            password.requestFocus();
            password.setError("check the password");
            return false;
        }
        else{
            return true;
        }

    }

}