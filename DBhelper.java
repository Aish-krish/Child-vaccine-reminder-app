package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

   public DBhelper(Context context ) {
       super(context, "ChildData.db", null, 1);
   }

   @Override
   public void onCreate(SQLiteDatabase DB) {
      DB.execSQL("create Table childDetails(rch_id_child TEXT primary key, child_name TEXT, rch_mother_id TEXT, mother_mobile TEXT, enrollment_date DATE, Child_sex TEXT, Child_DOB DATE, birth_weight REAL,delivery_facility_id TEXT,resident_facility_id TEXT)");
   }

   @Override
   public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
      DB.execSQL("drop Table if exists childDetails");
   }

   public Boolean insertChildData(String rch_id_child, String child_name, String rch_mother_id, String mother_mobile, String enrollment_date, String Child_sex, String Child_DOB, float birth_weight, String delivery_facility_id, String resident_facility_id)
   {
       SQLiteDatabase DB= this.getWritableDatabase();
       ContentValues contentValues= new ContentValues();
       contentValues.put("rch_id_child",rch_id_child);
       contentValues.put("child_name",child_name);
       contentValues.put("rch_mother_id",rch_mother_id);
       contentValues.put("mother_mobile",mother_mobile);

       contentValues.put("enrollment_date", String.valueOf(enrollment_date));
       contentValues.put("Child_sex",Child_sex);

       contentValues.put("Child_DOB", String.valueOf(Child_DOB));

       contentValues.put("birth_weight",birth_weight);
       contentValues.put("delivery_facility_id",delivery_facility_id);
       contentValues.put("resident_facility_id",resident_facility_id);
       long result=DB.insert("childDetails",null,contentValues);
       if(result==-1)
           return false;
       else
           return true;


   }

   public Cursor getdata (String id)
   {
       SQLiteDatabase DB = this.getWritableDatabase();
       String query="Select * from childDetails where rch_id_child =" +id;
       Cursor cursor = DB.rawQuery(query, null);
       return cursor;

   }

   public Cursor Viewdata ()
   {
       SQLiteDatabase DB = this.getWritableDatabase();
       //String query="Select * from childDetails where rch_id_child =" +id;
       Cursor cursor = DB.rawQuery("Select * from childDetails", null);
       return cursor;

   }
}

