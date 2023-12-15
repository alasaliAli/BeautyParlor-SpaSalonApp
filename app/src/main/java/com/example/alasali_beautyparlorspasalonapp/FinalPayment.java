package com.example.alasali_beautyparlorspasalonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FinalPayment extends AppCompatActivity {
    TextView b_c_name, b_s_name, b_s_price, b_s_date, b_s_time;
    EditText credit;
    Button confirm;

    String getKey;
    DatabaseReference ref;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    String u_credit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_payment);

        b_c_name= findViewById(R.id.b_c_name);
        b_s_name= findViewById(R.id.b_s_name);
        b_s_price= findViewById(R.id.b_s_price);
        b_s_date= findViewById(R.id.b_s_date);
        b_s_time= findViewById(R.id.b_s_time);
        credit= findViewById(R.id.credit);
        confirm= findViewById(R.id.confirm);

        if (getIntent().hasExtra("key")) {

            getKey= getIntent().getStringExtra("key");
        }

        firebaseAuth= FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();

        ref= FirebaseDatabase.getInstance().getReference("Bookings").child(user.getUid()).child("own").child(getKey);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserBooking userBooking= snapshot.getValue(UserBooking.class);
                b_c_name.setText("Booking holder Name: "+userBooking.getBookingName());
                b_s_name.setText("Service Name: "+userBooking.getBookingSerName());
                b_s_date.setText("Scheduled Date: "+userBooking.getBookingDate());
                b_s_time.setText("Scheduled Time: "+userBooking.getBookingTime());
                b_s_price.setText("Price: "+userBooking.getBookingPrice());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    Toast.makeText(FinalPayment.this, "Payment done Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FinalPayment.this, HomePage.class));
                    finish();
                }

            }
        });


    }

    private Boolean validate(){
        boolean result= false;

        u_credit = credit.getText().toString();
        if(u_credit.isEmpty()){
            Toast.makeText(this, "Please enter Credit Card number to pay", Toast.LENGTH_SHORT).show();
        }else {
            result= true;
        }
        return result;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(FinalPayment.this, HomePage.class));
        finish();
    }
}