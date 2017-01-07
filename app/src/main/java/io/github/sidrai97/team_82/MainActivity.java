package io.github.sidrai97.team_82;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
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
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int latch_delay=2000;
    private int refresh_delay=10000;
    private boolean app_latch=false;
    private JSONObject obj=null;
    TextView tv,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.temp_text);
        tv2 = (TextView) findViewById(R.id.temp_text2);
        try {
            obj = new JSONObject(loadJSON());
        }catch(JSONException e){e.printStackTrace();}

        refresh_data();
    }

    private void makeQuandlSearchQuery() {
        String murl="";
        try {
            murl = obj.getJSONObject(new Integer(0).toString()).getString("url");
        }catch(JSONException e){e.printStackTrace();}
        URL quandlSearchUrl = NetworkUtils.buildUrl(murl);
        tv2.setText(quandlSearchUrl.toString());
        new MyTask().execute(quandlSearchUrl);
    }

    public class MyTask extends AsyncTask<URL,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(URL... params) {
            URL searchUrl = params[0];
            String quandlSearchResults = null;
            try {
                quandlSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return quandlSearchResults;
        }

        @Override
        protected void onPostExecute(String s) {
            tv.setText(s);
        }
    }

    public String loadJSON() {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("document.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void refresh_data(){
        if(!isNetworkAvailable()){
            Toast.makeText(getApplicationContext(),R.string.network_error,Toast.LENGTH_LONG).show();
        }
        else{
            //fetch data from internet via asyntask and use asyc task to perform refresh instead of this func
            makeQuandlSearchQuery();
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
