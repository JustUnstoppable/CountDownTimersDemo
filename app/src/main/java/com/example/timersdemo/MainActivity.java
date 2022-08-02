package com.example.timersdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisecondsUntilDone) {
                Toast toast = Toast.makeText(getApplicationContext(), "Seconds Left!"+String.valueOf(millisecondsUntilDone / 1000), Toast.LENGTH_SHORT);

                toast.show();  //show Toast

            }

            @Override
            public void onFinish() {
             Log.i("We are done","No more countDown");
            }
        }.start();
      Handler handler=new Handler();
        Runnable run=new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(getApplicationContext(), "A second passed by", Toast.LENGTH_SHORT);

                toast.show();
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);

    }
}