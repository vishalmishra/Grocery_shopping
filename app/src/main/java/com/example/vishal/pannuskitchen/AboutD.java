package com.example.vishal.pannuskitchen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_d);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
}
