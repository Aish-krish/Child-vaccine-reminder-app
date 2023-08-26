package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

   //TextView Info1;
   EditText rch_child_id, child_name, rch_mother_id, mobile_no, child_sex, d_facility_id, r_facility_id, birth_weight, enrollment, child_dob;
   DBhelper DB;
   Button register;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.reg_page);

       //Info1=(TextView) findViewById(R.id.info);
       //Info1.setText("Registration page");
       rch_child_id = (EditText) findViewById(R.id.rchid);
       child_name = (EditText) findViewById(R.id.childname);
       rch_mother_id = (EditText) findViewById(R.id.rchmother);
       mobile_no = (EditText) findViewById(R.id.mobileet);
       child_sex = (EditText) findViewById(R.id.csexet);
       birth_weight = (EditText) findViewById(R.id.bweight);
       d_facility_id = (EditText) findViewById(R.id.dfacilityid);
       r_facility_id = (EditText) findViewById(R.id.rfacilityid);
       enrollment = (EditText) findViewById(R.id.enrolldate);
       child_dob = (EditText) findViewById(R.id.dob);
       register=(Button)findViewById(R.id.newid);
       DB = new DBhelper(this);
       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String rch_id = rch_child_id.getText().toString();
               String name = child_name.getText().toString();
               String rch_mother = rch_mother_id.getText().toString();
               String mb_no = mobile_no.getText().toString();
               String c_sex = child_sex.getText().toString();
               float bweight = Float.parseFloat(birth_weight.getText().toString());
               String delivery = d_facility_id.getText().toString();
               String resident = r_facility_id.getText().toString();
               String enroll = enrollment.getText().toString();
               String dob = child_dob.getText().toString();


               Boolean checkinsertdata = DB.insertChildData(rch_id, name, rch_mother, mb_no, enroll, c_sex, dob, bweight, delivery, resident);
               if (checkinsertdata == true)
                   Toast.makeText(Registration.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
               else
                   Toast.makeText(Registration.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
           }
       });

   }
}




