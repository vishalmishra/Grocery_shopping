package com.example.vishal.pannuskitchen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Kitchen1.db";
    public static final String TABLE_NAME="cart_table";

    public static final String COL_1="NAME";
    public static final String COL_2="MRP";
    public static final String COL_3="QUANTITY";
    public static final String TABLE_NAMEA="signup_table";
    public static final String EMAILID="EMAILID";
    public static final String PASSWORD="PASSWORD";
    public static final String RPASSWORD="RPASSWORD";

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(NAME TEXT,MRP TEXT,QUANTITY TEXT)");
        db.execSQL("create table " + TABLE_NAMEA + "(EMAILID TEXT PRIMARY KEY,PASSWORD TEXT,RPASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAMEA);
        onCreate(db);
    }
    public boolean insertData(String name,String mrp,String quantity){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,mrp);
        contentValues.put(COL_3, quantity);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean insertDataA(String emailid,String password,String rpassword){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(EMAILID,emailid);
        contentValues.put(PASSWORD,password);
        contentValues.put(RPASSWORD,rpassword);
        long result=db.insert(TABLE_NAMEA,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

  public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();

      Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.delete(TABLE_NAME,null,null);

    }
    public Cursor getSignupData(String x){
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor res=db.rawQuery("select " + PASSWORD + " from " + TABLE_NAMEA + " where " + EMAILID + " = ? " + ";" , new String[]{x});
        return res;
    }

}
