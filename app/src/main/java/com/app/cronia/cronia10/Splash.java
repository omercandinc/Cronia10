package com.app.cronia.cronia10;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread splashThread = new Thread() {

            public void run (){
                try {
                    sleep(2000);
                }
                catch (InterruptedException e) {

                    e.printStackTrace();
                }

                finally {

                    Intent intent = new Intent(Splash.this, Login.class);
                    startActivity(intent);


                }

            }
        };
        splashThread.start();
    }
}
