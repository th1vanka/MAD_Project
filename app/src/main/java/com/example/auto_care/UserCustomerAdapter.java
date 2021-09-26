package com.example.auto_care;

import android.content.Context;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserCustomerAdapter extends ArrayAdapter<AddCustomers> {

    private Context context;
    private int resource;
    List<AddCustomers> addCustomers;

     UserCustomerAdapter(Context context, int resource, List<AddCustomers> addCustomers){
        super(context,resource,addCustomers);
        this.context=context;
        this.resource=resource;
        this.addCustomers=addCustomers;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater=LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView name=row.findViewById(R.id.cusname);
        TextView username=row.findViewById(R.id.cusuname);
        TextView email=row.findViewById(R.id.cusemail);
        TextView phone=row.findViewById(R.id.cuscontact);


        AddCustomers cus= addCustomers.get(position);
        name.setText(cus.getCusName());
        username.setText(cus.getCusUserName());
        email.setText(cus.getCusEmail());
        phone.setText(cus.getPhone());




        return row;
    }
}
