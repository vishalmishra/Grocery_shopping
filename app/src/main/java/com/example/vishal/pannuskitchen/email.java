package com.example.vishal.pannuskitchen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class email extends AppCompatActivity {
public static Button btn;
    EditText order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        order=(EditText)findViewById(R.id.editText4);
        OnClickButtonListener();
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
    }
    public void OnClickButtonListener(){
        btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  Toast.makeText(getApplicationContext(),"Item added to cart Successfully",Toast.LENGTH_SHORT).show();

                        Log.i("Send email", "");

                        String[] TO = {"vishalmishra9442@gmail.com"};
                        String[] CC = {""};
                        Intent emailIntent = new Intent(Intent.ACTION_SEND);
                        emailIntent.setData(Uri.parse("mailto:"));
                        emailIntent.setType("text/plain");


                        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                        emailIntent.putExtra(Intent.EXTRA_CC, CC);
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My Orders");
                        emailIntent.putExtra(Intent.EXTRA_TEXT, order.getText());

                        try {
                            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                            finish();
                            Log.i("Finish sending email...", "");
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(email.this,
                                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
                        }

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
