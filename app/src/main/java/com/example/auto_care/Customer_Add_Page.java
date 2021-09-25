package com.example.auto_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Customer_Add_Page extends AppCompatActivity {

    private EditText name,Uname,email,pno,password,rePassword;

    private Button add ,close,show ;

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
        show=findViewById(R.id.cus_show);

        add=findViewById(R.id.cus_add_btn);
        close=findViewById(R.id.close);

        count=pno.length();

        context=this;
        dbHandler=new DbHandler(context);




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                    String Cusname = name.getText().toString();
                    String CusUname = Uname.getText().toString();
                    String CusEmail = email.getText().toString();
                    String CusPhone = pno.getText().toString();
                    String Cuspass=password.getText().toString();
                    String CusRepass=rePassword.getText().toString();

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                final Intent chooser;
                emailIntent.setData(Uri.parse("mailto:"));
                //emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{CusEmail});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Wellcome to the AutoCare vehicle service center.");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Use this password"+" "+ CusRepass+" "+"login to the system and change the password once use login.Thank you");
                emailIntent.setType("message/rfc822");
                chooser=emailIntent.createChooser(emailIntent,"send email test app");

                    boolean result=validation(CusPhone,Cuspass,CusRepass);

                    if(result==true){

                        AddCustomers cus = new AddCustomers(Cusname, CusUname, CusEmail, CusPhone,Cuspass);
                        dbHandler.addCustomer(cus);
                        Toast.makeText(Customer_Add_Page.this,"Successfully added",Toast.LENGTH_LONG).show();

                        Intent send = new Intent( Customer_Add_Page.this, Customer_View_Page.class );
                        startActivity(send);

                        startActivity(chooser);
                    }
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent( Customer_Add_Page.this, Customer_View_Page.class );
                startActivity(send);
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