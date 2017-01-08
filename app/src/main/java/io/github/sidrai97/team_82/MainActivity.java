package io.github.sidrai97.team_82;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int latch_delay=2000;
    private long refresh_delay=60000;
    private boolean app_latch=false;
    private JSONObject obj=null;
    ListView mindexList;
    ProgressBar mprogress;
    private long refreshTime = 120000;
    ArrayList<String> indexDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mindexList = (ListView) findViewById(R.id.indexList);
        mprogress = (ProgressBar) findViewById(R.id.progress);

        try {
            obj = new JSONObject(loadJSON());
        }catch(JSONException e){e.printStackTrace();}




        refresh_data();
        restartTimer();
    }

    public void restartTimer()
    {
        new CountDownTimer(refreshTime, refreshTime) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                refresh_data();
                restartTimer();
            }
        }.start();
    }
    private void makeQuandlSearchQuery() {
        String murl="";

        for(int i=0;i<14;i++)
        {
            try
            {
                murl = obj.getJSONObject(new Integer(i).toString()).getString("url");
            }catch(JSONException e){e.printStackTrace();}
            URL quandlSearchUrl = NetworkUtils.buildUrl(murl);
            new MyTask().execute(quandlSearchUrl);
        }

    }

    public class MyTask extends AsyncTask<URL,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mprogress.setVisibility(View.VISIBLE);
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
            //tv.setText(tv.getText()+"\n\n"+s);
            indexDataList.add(s);
            IndexListAdaptor indexListAdaptor = new IndexListAdaptor(MainActivity.this,indexDataList);
            mindexList.setAdapter(indexListAdaptor);
            mprogress.setVisibility(View.INVISIBLE);


           /* mindexList.setOnClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub
                    String selectedItem= stockName[+position];
                    //Toast.makeText(getApplicationContext(), selectedItem.replaceAll("_"," "), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,CompanyActivity.class);
                    intent.putExtra("stockName",stockName[+position]);
                    startActivity(intent);

                }
            });*/


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
            mprogress.setVisibility(View.INVISIBLE);
        }
        else{
            //fetch data from internet via asyntask and use asyc task to perform refresh instead of this func
            indexDataList = new ArrayList<String>();
            makeQuandlSearchQuery();
            //indexListAdaptor.notifyDataSetChanged();
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
            restartTimer();
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
