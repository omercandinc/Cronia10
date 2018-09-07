package com.app.cronia.cronia10;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView card_food,card_read;
    private Chronometer mChronometer;
    private long lastPause;

    private static final long START_TIME_IN_MILLIS = 600000;

    private TextView txtTimer_food;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;


    /*yorum*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTimer_food = (TextView) findViewById(R.id.txtTimer_food);


        //cardview nesnelerinin tanımları
        card_food= (CardView) findViewById(R.id.card_food);
        card_read = (CardView) findViewById(R.id.card_read);

        //click listener to the cards
        card_food.setOnClickListener(this);
        card_read.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        switch (view.getId())
        {
            case R.id.card_food :  if (mTimerRunning) {
                pauseTimer();
            } else {
                startTimer();
            }
        }



    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;

            }
        }.start();

        mTimerRunning = true;

    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;

    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();

    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        txtTimer_food.setText(timeLeftFormatted);
    }



}
