package com.example.alasali_beautyparlorspasalonapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ImageAdapterViewAppointment extends FirebaseRecyclerAdapter<UserBooking, ImageAdapterViewAppointment.ImageViewHolder> {

    public ImageAdapterViewAppointment(@NonNull FirebaseRecyclerOptions<UserBooking> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull ImageAdapterViewAppointment.ImageViewHolder holder, int position, @NonNull UserBooking model) {
        holder.textCName.setText("Booking Holder Name: "+model.getBookingName());
        holder.textSName.setText("Service Name: "+model.getBookingSerName());
        holder.textPrice.setText("Price: "+model.getBookingPrice());
        holder.textTime.setText("Appointment Time: "+model.getBookingTime());
        holder.textDate.setText("Appointment Date: "+model.getBookingDate());

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_view_appointment, parent, false);
        return new ImageViewHolder(v);
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView textCName;
        public TextView textSName;
        public TextView textDate;
        public TextView textPrice;
        public TextView textTime;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            textCName= itemView.findViewById(R.id.h_name1);
            textSName= itemView.findViewById(R.id.s_name1);
            textPrice= itemView.findViewById(R.id.s_price1);
            textDate= itemView.findViewById(R.id.s_date1);
            textTime= itemView.findViewById(R.id.s_time1);

        }


    }



}
