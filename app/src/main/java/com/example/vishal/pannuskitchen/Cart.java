package com.example.vishal.pannuskitchen;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Cart extends AppCompatActivity {
    DatabaseHelper myDB;
    ImageButton order,btnDelete,btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        myDB = new DatabaseHelper(this);
        order=(ImageButton)findViewById(R.id.imageButton10);
btnDelete=(ImageButton)findViewById(R.id.imageButton12);
        ViewData();
        deleteData();
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
        OnClickButtonListener();
    }
    public void OnClickButtonListener(){
        btn=(ImageButton)findViewById(R.id.imageButton11);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent("com.example.vishal.pannuskitchen.OrderCart");
                        startActivity(intent);
                    }
                }
        );
    }

    public void ViewData() {
        order.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Cursor res=myDB.getAllData();
                if(res.getCount()==0){

                    showMessage("Your Cart is Empty","");
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
    }
    public void deleteData(){
        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Integer deleteRow=myDB.deleteData(null);
                if(deleteRow>0)
                    Toast.makeText(Cart.this, "Data Deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Cart.this, "Data Not Deleted",Toast.LENGTH_SHORT).show();

            }
        });}
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
}
