package com.example.vishal.pannuskitchen;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MyAccount extends AppCompatActivity {
    DatabaseHelper myDB;
Button btn,btn1;
    EditText emaill,passl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myaccount);
        myDB = new DatabaseHelper(this);
        emaill=(EditText)findViewById(R.id.editText);
        passl=(EditText)findViewById(R.id.editText2);
        OnClickButtonListener();
        onLoginClick();
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
    }
    public void OnClickButtonListener(){
        btn=(Button)findViewById(R.id.button4);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent("com.example.vishal.pannuskitchen.Signup");
                        startActivity(intent);
                    }
                }
        );
    }
   public void onLoginClick(){
        btn1=(Button)findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=myDB.getSignupData(emaill.getText().toString());
                if(res.getCount()==0){

                    showMessage("Invalid","Please fill valid information ");
                    return;
                }

                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()) {
                    //buffer.append("  PASSWORD : " + res.getString(0) + "\n");
                    if((res.getString(0).toString().equals(passl.getText().toString()))){
                        Toast.makeText(MyAccount.this,"Successfully Logined...!",Toast.LENGTH_SHORT).show();

                        //mainActivity.setGuest(editemailid.getText().toString());
                        String result=emaill.getText().toString();
                        Intent output=new Intent(MyAccount.this,MainActivity.class);

                        startActivity(output);


                    }
                    else
                        Toast.makeText(MyAccount.this,"Email id doesn't exist...!",Toast.LENGTH_SHORT).show();
                }
            }



        });
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
