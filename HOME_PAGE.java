package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HOME_PAGE extends AppCompatActivity implements View.OnClickListener {

   private Button btnReg;
   private Button btnUp;
   private Button btnView;
   private Button btnDel;



   @SuppressLint("SetTextI18n")
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_home_page);
       btnReg=(Button) findViewById(R.id.Registerbtn);
       btnReg.setOnClickListener(this); // calling onClick() method

       btnUp=(Button) findViewById(R.id.Updatebtn);
       btnUp.setOnClickListener(this); // calling onClick() method

       btnView=(Button) findViewById(R.id.Viewbtn);
       btnView.setOnClickListener(this); // calling onClick() method

       btnDel=(Button) findViewById(R.id.Deletebtn);
       btnDel.setOnClickListener(this); // calling onClick() method


   }

   @Override
   public void onClick(View v)
   {
       if(v.getId()==R.id.Registerbtn)
       {
           Intent intent=new Intent(HOME_PAGE.this,Registration.class);
           startActivity(intent);
       }

       else if (v.getId() == R.id.Updatebtn)
       {
           Intent intent2=new Intent(HOME_PAGE.this,display.class);
           startActivity(intent2);
       }

       else if (v.getId() == R.id.Deletebtn)
       {
           Intent intent3=new Intent(HOME_PAGE.this,del.class);
           startActivity(intent3);
       }

       else if (v.getId() == R.id.Viewbtn)
       {
           //Intent intent4=new Intent(HOME_PAGE.this,ViewAll.class);
           //startActivity(intent4);
           DBhelper DB = new DBhelper(this);
           btnView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Cursor res = DB.Viewdata();
                   if(res.getCount()==0){
                       Toast.makeText(HOME_PAGE.this, "No data exits", Toast.LENGTH_SHORT).show();
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
                       buffer.append("Residence Facility ID :"+res.getString(9)+"\n\n\n");

                   }

                   AlertDialog.Builder builder = new AlertDialog.Builder(HOME_PAGE.this);
                   builder.setCancelable(true);
                   builder.setTitle("CHILD DETAILS");
                   builder.setMessage(buffer.toString());
                   builder.show();
               }        });

       }

   }


}


