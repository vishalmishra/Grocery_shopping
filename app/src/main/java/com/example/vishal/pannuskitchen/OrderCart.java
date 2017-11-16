package com.example.vishal.pannuskitchen;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class OrderCart extends AppCompatActivity {
Button btn;
    EditText con,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_cart);
        con=(EditText)findViewById(R.id.editText6);
        add=(EditText)findViewById(R.id.editText5);
        OnClickButtonListener();
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
    }
    public void OnClickButtonListener(){
        btn=(Button)findViewById(R.id.button3);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(con.getText().toString()==null || con.getText().toString().equals(""))
                            showMessage("","Please Enter Your Contact no.");
                        else if(add.getText().toString()==null || add.getText().toString().equals(""))
                            showMessage("","Please Enter Your Address");
                        else
                        showMessage("Your Order is Placed Sucessfully","Thank you for shopping..");
                    }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
}
