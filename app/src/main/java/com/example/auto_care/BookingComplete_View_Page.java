package com.example.auto_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookingComplete_View_Page extends AppCompatActivity {



    Context context;
    private DbHandler dbHandler;
    private List<booking> book;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_booking_complete_view_page);
        context=this;
        dbHandler = new DbHandler(context);
        listView=findViewById(R.id.CompletebookingList);

        book=new ArrayList<>();
        book=dbHandler.getCompleteBookDetails();

        completeBooking_Adapter  adapter=new completeBooking_Adapter(context,R.layout.single_booking,book);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                booking booking=book.get(position);

                String id=booking.getVehicle_ID();
                String type=booking.getVehicle_Type() ;
                String km=booking.getKm_per_day() ;
                String uname=booking.getUserName() ;
                String mail=booking.getEmail() ;
                String date=booking.getDate() ;
            }
        });




    }
}