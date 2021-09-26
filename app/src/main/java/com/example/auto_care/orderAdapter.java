package com.example.auto_care;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class orderAdapter extends ArrayAdapter<Order> {
    private Context context;
    private int resource;
    List<Order> order;

    orderAdapter(Context context, int resource, List<Order> order){
        super(context,resource,order);
        this.context=context;
        this.resource=resource;
        this.order=order;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater=LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView iid=row.findViewById(R.id.oid);
        TextView nnamw=row.findViewById(R.id.cusname);
        TextView eemail=row.findViewById(R.id.cusEmail);
        TextView iitemid=row.findViewById(R.id.itemId);
        TextView iitemname=row.findViewById(R.id.itemname);
        TextView qqun=row.findViewById(R.id.qun);
        TextView ddate=row.findViewById(R.id.date);


        Order orders= order.get(position);

        iid.setText(orders.getOid());
        nnamw.setText(orders.getCusname());
        eemail.setText(orders.getCusEmail());
        iitemid.setText(orders.getItemId());
        iitemname.setText(orders.getItemname());
        qqun.setText(orders.getQun());
        ddate.setText(orders.getDates());

        return row;
    }



}
