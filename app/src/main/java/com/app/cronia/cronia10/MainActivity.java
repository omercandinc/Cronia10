package com.app.cronia.cronia10;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView main_cardvw_1_1,main_cardvw_1_2;
    private int Cardview_ID;
    private Chronometer mChronometer_food;
    private int durum= 0;
    private String deneme;
    private ImageButton footer_imgbtn_dashboard;
    private ImageButton footer_imgbtn_home;
    private ImageButton footer_imgbtn_profile;



    /*yorum*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // chronometers
        mChronometer_food = (Chronometer) findViewById(R.id.mChronometer_food);

        //cardview nesnelerinin tanımları
        main_cardvw_1_1= (CardView) findViewById(R.id.main_cardvw_1_1);
        main_cardvw_1_2 = (CardView) findViewById(R.id.main_cardvw_1_2);
        footer_imgbtn_dashboard = (ImageButton) findViewById(R.id.footer_imgbtn_dashboard);
        footer_imgbtn_home = (ImageButton) findViewById(R.id.footer_imgbtn_home);
        footer_imgbtn_profile = (ImageButton) findViewById(R.id.footer_imgbtn_profile);


        //click listener to the cards
        main_cardvw_1_1.setOnClickListener(this);
        main_cardvw_1_2.setOnClickListener(this);
        footer_imgbtn_dashboard .setOnClickListener(this);
        footer_imgbtn_home .setOnClickListener(this);
        footer_imgbtn_profile .setOnClickListener(this);

        //chronometers invisible
        mChronometer_food.setVisibility(View.INVISIBLE);




    }





    @Override
    public void onClick(View view) {


        switch (view.getId())
        {


            case R.id.main_cardvw_1_1 :

                if ( durum == 0)
                {
                    mChronometer_food.setBase(SystemClock.elapsedRealtime());
                    mChronometer_food.start();
                    mChronometer_food.setVisibility(View.VISIBLE);
                    durum = 1;
                }

                else
                {
                    mChronometer_food.setBase(SystemClock.elapsedRealtime());
                    mChronometer_food.stop();
                    mChronometer_food.setVisibility(View.INVISIBLE);
                    durum = 0;

                }

                break;


            case R.id.footer_imgbtn_dashboard :

                Intent i=new Intent();
                i.setClass(MainActivity.this,Dashboard.class);
                startActivity(i);
                footer_imgbtn_dashboard.setImageResource(R.drawable.main_dashboardbutton_on);
                footer_imgbtn_home.setImageResource(R.drawable.main_homebutton_off);



        }



    }





}
