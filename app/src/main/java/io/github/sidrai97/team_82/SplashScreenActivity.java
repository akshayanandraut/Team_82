package io.github.sidrai97.team_82;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {
    private Intent intent;
    private long TIME_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //turn off title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //request fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);



         intent = new Intent(SplashScreenActivity.this,MainActivity.class);


        Timer buttonTimer = new Timer();
        buttonTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        //myButton.setEnabled(true);
                        startActivity(intent);
                    }
                });
            }
        }, TIME_DELAY);
    }
}
