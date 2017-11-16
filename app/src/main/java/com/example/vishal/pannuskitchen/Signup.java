package com.example.vishal.pannuskitchen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText email,pass,rpass;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        myDB = new DatabaseHelper(this);

        email = (EditText) findViewById(R.id.editText7);
        pass = (EditText) findViewById(R.id.editText8);
        rpass= (EditText) findViewById(R.id.editText9);

        btn = (Button) findViewById(R.id.button5);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
        AddData2();
    }


    public void AddData2() {
        btn.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              //  Toast.makeText(R1.this,editName.getText().toString()+" "+editmrp.getText().toString()+" "+quantity.getText().toString(),Toast.LENGTH_SHORT).show();
                                              boolean flag = myDB.insertDataA(email.getText().toString(), pass.getText().toString(), rpass.getText().toString());

                                              if (flag){
                                                  Toast.makeText(Signup.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                                              Intent intent=new Intent("com.example.vishal.pannuskitchen.MyAccount");
                                              startActivity(intent);}
                                              else
                                                  Toast.makeText(Signup.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                                          }
                                      }
        );
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
}
