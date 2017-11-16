package com.example.vishal.pannuskitchen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Rice extends AppCompatActivity {
    public static ImageButton btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
        OnClickButtonListener();
    }


    public void OnClickButtonListener(){
        btn=(ImageButton)findViewById(R.id.imageButton);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent("com.example.vishal.pannuskitchen.R1");
                        startActivity(intent);
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

