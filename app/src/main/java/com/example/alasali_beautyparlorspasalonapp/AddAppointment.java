package com.example.alasali_beautyparlorspasalonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AddAppointment extends AppCompatActivity {

    private ListView listSearch;
    private EditText editSearch;

    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    // ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);

        listSearch= (ListView)findViewById(R.id.listSearch);
        editSearch= (EditText)findViewById(R.id.editSearch);

        list= new ArrayList<>();

        // list= (ListView) findViewById(R.id.listSearch);
        //final List<String> mylist= new ArrayList<>();
        adapter= new ArrayAdapter<String>(this,R.layout.list_item, R.id.textView2, list);
        list.add("Makeup");
        list.add("Waxing");
        list.add("Facials");
        list.add("Hair Color");
        list.add("Hair Cutting");
        list.add("Hair Extension");
        list.add("Nails");
        list.add("Pedicure");
        list.add("Manicure");
        list.add("Spa Services");
        list.add("Massage");


        //adapter= new ArrayAdapter<String>(this,R.layout.list_item, R.id.textView2, mylist);
        listSearch.setAdapter(adapter);

        listSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String p1= "10 OMR"; String p2= "5 OMR"; String p3= "5 OMR";    String p4= "7 OMR";
                String p5= "4 OMR";    String p6= "10 OMR";    String p7= "5 OMR";    String p8= "8 OMR";
                String p9= "8 OMR";    String p10= "20 OMR";    String p11= "15 OMR";

                String v1= "Makeup";    String v2= "Waxing";    String v3="Facials";    String v4="Hair Color";
                String v5="Hair Cutting";   String v6="Hair Extension"; String v7="Nails";  String v8="Pedicure";
                String v9="Manicure";   String v10="Spa Services";  String v11= "Massage";

                String val =(String) parent.getItemAtPosition(position);
                if (val.equals(v1)){
                    Intent intent =new Intent(AddAppointment.this, BookAppointment.class);
                    intent.putExtra("name", val);
                    intent.putExtra("price", p1);
                    startActivity(intent);
                    finish();
                }
                if (val.equals(v2)){
                    Intent intent =new Intent(AddAppointment.this, BookAppointment.class);
                    intent.putExtra("name", val);
                    intent.putExtra("price", p2);
                    startActivity(intent);
                    finish();
                }
                if (val.equals(v3)){
                    Intent intent =new Intent(AddAppointment.this, BookAppointment.class);
                    intent.putExtra("name", val);
                    intent.putExtra("price", p3);
                    startActivity(intent);
                    finish();
                }
                if (val.equals(v4)){
                    Intent intent =new Intent(AddAppointment.this, BookAppointment.class);
                    intent.putExtra("name", val);
                    intent.putExtra("price", p4);
                    startActivity(intent);
                    finish();
                }
                if (val.equals(v5)){
                    Intent intent =new Intent(AddAppointment.this, BookAppointment.class);
                    intent.putExtra("name", val);
                    intent.putExtra("price", p5);
                    startActivity(intent);
                    finish();
                }
                if (val.equals(v6)){
                    Intent intent =new Intent(AddAppointment.this, BookAppointment.class);
                    intent.putExtra("name", val);
                    intent.putExtra("price", p6);
                    startActivity(intent);
                    finish();
                }
                if (val.equals(v7)){
                    Intent intent =new Intent(AddAppointment.this, BookAppointment.class);
                    intent.putExtra("name", val);
                    intent.putExtra("price", p7);
                    startActivity(intent);
                    finish();
                }
                if (val.equals(v8)){
                    Intent intent =new Intent(AddAppointment.this, BookAppointment.class);
                    intent.putExtra("name", val);
                    intent.putExtra("price", p8);
                    startActivity(intent);
                    finish();
                }
                if (val.equals(v9)){
                    Intent intent =new Intent(AddAppointment.this, BookAppointment.class);
                    intent.putExtra("name", val);
                    intent.putExtra("price", p9);
                    startActivity(intent);
                    finish();
                }
                if (val.equals(v10)){
                    Intent intent =new Intent(AddAppointment.this, BookAppointment.class);
                    intent.putExtra("name", val);
                    intent.putExtra("price", p10);
                    startActivity(intent);
                    finish();
                }
                if (val.equals(v11)){
                    Intent intent =new Intent(AddAppointment.this, BookAppointment.class);
                    intent.putExtra("name", val);
                    intent.putExtra("price", p11);
                    startActivity(intent);
                    finish();
                }
            }
        });


        //edit search option

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                AddAppointment.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        //Display alert message when back button has been pressed
        startActivity(new Intent(AddAppointment.this, HomePage.class));
        finish();
    }
}