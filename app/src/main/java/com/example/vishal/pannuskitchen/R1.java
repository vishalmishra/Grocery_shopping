package com.example.vishal.pannuskitchen;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class R1 extends AppCompatActivity {

    DatabaseHelper myDB;

    TextView editName, editmrp;
    EditText quantity;
    ImageButton btnAddData;
   Button btnAllData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r1);

        myDB = new DatabaseHelper(this);

        editName = (TextView) findViewById(R.id.textView14);
        editmrp = (TextView) findViewById(R.id.textView15);
        quantity= (EditText) findViewById(R.id.editText3);

        btnAddData = (ImageButton) findViewById(R.id.imageButton8);

        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);

        AddData();
      //ViewData();

     //  OnClickButtonListener();

    }


   public void AddData() {
       btnAddData.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                           //  Toast.makeText(R1.this,editName.getText().toString()+" "+editmrp.getText().toString()+" "+quantity.getText().toString(),Toast.LENGTH_SHORT).show();
                                             boolean flag = myDB.insertData(editName.getText().toString(), editmrp.getText().toString(), quantity.getText().toString());

                                             if (flag)
                                                 Toast.makeText(R1.this, "Item added to the Cart", Toast.LENGTH_LONG).show();
                                             else
                                                 Toast.makeText(R1.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                                         }
                                     }
       );
   }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
 /*public void ViewData() {
        btnAllData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Cursor res=myDB.getAllData();
                if(res.getCount()==0){

                    showMessage("Error","Nothing Called");
                    return;
                }

                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                   // buffer.append(" SR NO. : "+res.getString(0)+"\n");
                    buffer.append("   NAME : "+res.getString(0)+"\n");
                    buffer.append("    MRP : "+res.getString(1)+"\n");
                    buffer.append("Quantity : "+res.getString(2)+"\n");
                    buffer.append("=============================\n");
                }

                showMessage("Your Cart",buffer.toString());
            }
        } );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }*/
}
