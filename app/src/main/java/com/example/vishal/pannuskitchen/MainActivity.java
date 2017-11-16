package com.example.vishal.pannuskitchen;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;


private static ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      //  OnClickButtonListener();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    /*   ActionBar ab=getSupportActionBar();
        ab.setLogo(R.drawable.icon3);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);*/
       /* viewFlipper = (ViewFlipper) this.findViewById(R.id.bckgrndViewFlipper1);
        fade_in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);
//sets auto flipping
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.startFlipping();*/

        viewFlipper = (ViewFlipper) this.findViewById(R.id.bckgrndViewFlipper1);
        fade_in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);
//sets auto flipping
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.startFlipping();


    }
/*public void OnClickButtonListener(){
     //btn=(ImageButton)findViewById(R.id.imageButton);
    btn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent("com.example.vishal.pannuskitchen.MyAccount");
                    startActivity(intent);
                }
            }
    );
    }*/
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Myaccount) {

                Intent intent=new Intent("com.example.vishal.pannuskitchen.MyAccount");
                startActivity(intent);


        }
else if(id == R.id.action_Myorders){
            Intent intent=new Intent("com.example.vishal.pannuskitchen.MyOrders");
            startActivity(intent);        }
        else if(id == R.id.action_Contact){
            Intent intent=new Intent("com.example.vishal.pannuskitchen.Contact");
            startActivity(intent);
        }
        else if(id == R.id.action_developer){
            Intent intent=new Intent("com.example.vishal.pannuskitchen.AboutD");
            startActivity(intent);        }
        else if(id == R.id.action_Manual){
            Intent intent=new Intent("com.example.vishal.pannuskitchen.email");
            startActivity(intent);        }
        else if(id == R.id.action_cart) {
            Intent intent=new Intent("com.example.vishal.pannuskitchen.Cart");
            startActivity(intent);
        }
            return super.onOptionsItemSelected(item);


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id=item.getItemId();


        if (id == R.id.nav_camera) {

            Intent intent=new Intent("com.example.vishal.pannuskitchen.Rice");
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {



        }else if (id == R.id.nav_slideshow) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
