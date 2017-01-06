package io.github.sidrai97.team_82;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int latch_delay=2000;
    private int refresh_delay=10000;
    private boolean app_latch=false;

    Spinner categorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categorySpinner = (Spinner) findViewById(R.id.category_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
        refresh_data();
    }

    private void refresh_data(){
        if(!isNetworkAvailable()){
            Toast.makeText(getApplicationContext(),R.string.network_error,Toast.LENGTH_LONG).show();
        }
        else{
            //fetch data from internet via asyntask and use asyc task to perform refresh instead of this func
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.refresh_btn){
            Toast.makeText(getApplicationContext(),"Refreshing",Toast.LENGTH_SHORT).show();
            refresh_data();
        }
        else if(item.getItemId() == R.id.favourites_tab){
            Toast.makeText(getApplicationContext(),"show favourites",Toast.LENGTH_SHORT).show();
            //intent to go to favourites activity
        }
        return super.onOptionsItemSelected(item);
    }

    //Closing app on double tap of back button
    @Override
    public void onBackPressed() {
        if(app_latch){
            super.onBackPressed();
            return;
        }
        this.app_latch=true;
        Toast.makeText(getApplicationContext(),R.string.back_button_message,Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                app_latch=false;
            }
        },this.latch_delay);
    }
}
