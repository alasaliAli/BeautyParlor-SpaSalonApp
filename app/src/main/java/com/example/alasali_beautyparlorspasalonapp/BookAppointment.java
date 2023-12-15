package com.example.alasali_beautyparlorspasalonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class BookAppointment extends AppCompatActivity {
    TextView p_name, p_price;
    EditText p_cus_Name;
    Button booking_save, mDatebtn, mTimebtn;
    FirebaseAuth firebaseAuth;
    String timeTonotify;
    FirebaseUser user;
    String date ,time ,u_cus_name;
    String getName, getPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        p_name = findViewById(R.id.pic_name4);
        p_price = findViewById(R.id.pic_Price4);
        p_cus_Name= findViewById(R.id.t_cus_name);
        mDatebtn = (Button) findViewById(R.id.btnDate);                                             //assigned all the material reference to get and set data
        mTimebtn = (Button) findViewById(R.id.btnTime);
        booking_save= (Button) findViewById(R.id.booking_save);

        if (getIntent().hasExtra("name") && getIntent().hasExtra("price")) {
            getName = getIntent().getStringExtra("name");
            getPrice = getIntent().getStringExtra("price");

            p_name.setText(getName);
            p_price.setText(getPrice);
        }

        mTimebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTime();                                                                       //when we click on the choose time button it calls the select time method
            }
        });
        mDatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectDate();
            }
        });

        booking_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate1()){
                if (validate()) {
                    if (user != null) {
                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Bookings").child(user.getUid()).child("own");
                        UserBooking userBooking = new UserBooking(getName, getPrice, u_cus_name, time, date);
                        ref.child(ref.push().getKey()).setValue(userBooking);
                        Toast.makeText(BookAppointment.this, "Booking completed Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(BookAppointment.this, HomePage.class));
                        finish();
                    }

                }
            }
            }
        });

    }
    private Boolean validate(){
        boolean result= false;

        date = mDatebtn.getText().toString().trim();                                 //access the date from the choose date button
        time = mTimebtn.getText().toString().trim();
        if (time.equals("Select time") || date.equals("Select date")) {                                               //shows toast if date and time are not selected
            Toast.makeText(getApplicationContext(), "Please select date and time", Toast.LENGTH_SHORT).show();
        }else {
            result= true;
        }
        return result;
    }
    private Boolean validate1(){
        boolean result= false;

        u_cus_name= p_cus_Name.getText().toString();
        if (u_cus_name.isEmpty()) {                                               //shows toast if date and time are not selected
            Toast.makeText(getApplicationContext(), "Please enter Booking Holder name", Toast.LENGTH_SHORT).show();
        }else {
            result= true;
        }
        return result;
    }


    private void selectTime() {                                                                     //this method performs the time picker task
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeTonotify = i + ":" + i1;                                                        //temp variable to store the time to set alarm
                mTimebtn.setText(FormatTime(i, i1));                                                //sets the button text as selected time
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }
    private void selectDate() {                                                                     //this method performs the date picker task
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                mDatebtn.setText(day + "-" + (month + 1) + "-" + year);                             //sets the selected date as test for button
            }
        }, year, month, day);
        datePickerDialog.show();
    }
    public String FormatTime(int hour, int minute) {                                                //this method converts the time into 12hr format and assigns am or pm
        String time;
        time = "";
        String formattedMinute;
        if (minute / 10 == 0) {
            formattedMinute = "0" + minute;
        } else {
            formattedMinute = "" + minute;
        }
        if (hour == 0) {
            time = "12" + ":" + formattedMinute + " AM";
        } else if (hour < 12) {
            time = hour + ":" + formattedMinute + " AM";
        } else if (hour == 12) {
            time = "12" + ":" + formattedMinute + " PM";
        } else {
            int temp = hour - 12;
            time = temp + ":" + formattedMinute + " PM";
        }
        return time;
    }

    //date time code end

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BookAppointment.this, HomePage.class));
        finish();
    }
}