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

public class ImageAdapterMakePayment extends FirebaseRecyclerAdapter<UserBooking, ImageAdapterMakePayment.ImageViewHolder> {
    private ImageAdapterCancelAppointment.OnItemClickListener mListener;

    public ImageAdapterMakePayment(@NonNull FirebaseRecyclerOptions<UserBooking> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull ImageAdapterMakePayment.ImageViewHolder holder, int position, @NonNull UserBooking model) {
        holder.textCName.setText("Booking Holder Name: "+model.getBookingName());
        holder.textSName.setText("Service Name: "+model.getBookingSerName());
        holder.textPrice.setText("Price: "+model.getBookingPrice());
        holder.textTime.setText("Appointment Time: "+model.getBookingTime());
        holder.textDate.setText("Appointment Date: "+model.getBookingDate());

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_make_payment, parent, false);
        return new ImageViewHolder(v);
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textCName;
        public TextView textSName;
        public TextView textDate;
        public TextView textPrice;
        public TextView textTime;
        public Button btn_del;



        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            textCName= itemView.findViewById(R.id.h_name2);
            textSName= itemView.findViewById(R.id.s_name2);
            textPrice= itemView.findViewById(R.id.s_price2);
            textDate= itemView.findViewById(R.id.s_date2);
            textTime= itemView.findViewById(R.id.s_time2);
            btn_del= itemView.findViewById(R.id.btn_del2);

            btn_del.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }

    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(ImageAdapterCancelAppointment.OnItemClickListener listener){
        mListener= listener;
    }


}
