package com.example.myapp;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;


import androidx.appcompat.app.AppCompatActivity;

public class display extends AppCompatActivity {

   TextView Info1;
   EditText id;
   Button fetch;
   DBhelper DB;

   @SuppressLint("SetTextI18n")
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.disp);

       Info1=(TextView) findViewById(R.id.rch_text);
       id=(EditText) findViewById(R.id.rch_id_et);
       fetch=(Button) findViewById(R.id.fetchbtn);
       DB = new DBhelper(this);
       fetch.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Cursor res = DB.getdata(id.getText().toString());
               if(res.getCount()==0){
                   Toast.makeText(display.this, "No data exits", Toast.LENGTH_SHORT).show();
                   return;
               }
               StringBuffer buffer = new StringBuffer();
               while(res.moveToNext()){
                   buffer.append("Child rch id :"+res.getString(0)+"\n");
                   buffer.append("Child name :"+res.getString(1)+"\n");
                   buffer.append("Mother's rch id :"+res.getString(2)+"\n");
                   buffer.append("Mobile Number :"+res.getString(3)+"\n");
                   buffer.append("Enrollment Date :"+res.getString(4)+"\n");
                   buffer.append("Child's Sex :"+res.getString(5)+"\n");
                   buffer.append("Date of Birth :"+res.getString(6)+"\n");
                   buffer.append("Birth Weight :"+res.getString(7)+"\n");
                   buffer.append("Delivery Facility ID :"+res.getString(8)+"\n");
                   buffer.append("Residence Facility ID :"+res.getString(9)+"\n");

               }

               AlertDialog.Builder builder = new AlertDialog.Builder(display.this);
               builder.setCancelable(true);
               builder.setTitle("CHILD DETAILS");
               builder.setMessage(buffer.toString());
               builder.show();
           }        });
   }
}





