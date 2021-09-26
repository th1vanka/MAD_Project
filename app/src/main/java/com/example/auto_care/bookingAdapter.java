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

public class bookingAdapter extends ArrayAdapter<booking> {

    private Context context;
    private int resource;
    List<booking>bookings;

    bookingAdapter(Context context, int resource, List<booking> bookings){
        super(context,resource,bookings);
        this.context=context;
        this.resource=resource;
        this.bookings=bookings;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater=LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView id=row.findViewById(R.id.Id);
        TextView type=row.findViewById(R.id.type);
        TextView km=row.findViewById(R.id.km);
        TextView uname=row.findViewById(R.id.uname);
        TextView mail=row.findViewById(R.id.email);
        TextView date=row.findViewById(R.id.date);


        booking book= bookings.get(position);

        id.setText(book.getVehicle_ID());
        type.setText(book.getVehicle_Type());
        km.setText(book.getKm_per_day());
        uname.setText(book.getUserName());
        mail.setText(book.getEmail());
        date.setText(book.getDate());

        return row;
    }



}
