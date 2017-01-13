package io.github.sidrai97.team_82;

import android.graphics.Color;
import android.icu.util.RangeValueIterator;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;

public class GraphActivity extends AppCompatActivity {
String url;
    final static String QUANDL_BASE_URL = "https://www.quandl.com/api/v3/datasets/NSE/";
    final static String API_KEY="Q--br_sJjG98J4pM1R5M";
    final static String PARAM_API_KEY = "api_key";
    final static String PARAM_START_DATE = "start_date";
    final static String PARAM_END_DATE = "end_date";
    JSONObject obj;
    String open,high,low,date,close;
    ProgressBar progressBar;

    String data="";
    JSONObject jsonObject;
    DataPoint[] highdp,lowdp,opendp,closedp;

    boolean latch_shows_fetch_data_success=true;//false when success

    public class StockDataTask extends AsyncTask<URL,Void,String> {
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
            super.onPostExecute(s);
            data=s;
            try{
                jsonObject = new JSONObject(data);
            }catch (JSONException e){e.printStackTrace();}
            //Toast.makeText(getApplicationContext(),"got data:"+response,Toast.LENGTH_SHORT).show();
            System.out.println("response: ---------->>> "+jsonObject);
            try {
                JSONObject obj = jsonObject.getJSONObject("dataset");
                //System.out.println("response: ---------->>> "+obj.getString("name"));
                String sdate=obj.getString("start_date");
                String edate=obj.getString("end_date");

                JSONArray jsonArray = obj.getJSONArray("data");
                JSONArray jsonArray1 = jsonArray.getJSONArray(0);
                date= jsonArray1.getString(0);
                open= jsonArray1.getString(1);
                high= jsonArray1.getString(2);
                low= jsonArray1.getString(3);
                close= jsonArray1.getString(5);
                TextView comp_name = (TextView)findViewById(R.id.company_name);
                TextView high_rate = (TextView)findViewById(R.id.high_rate);
                TextView low_rate = (TextView)findViewById(R.id.low_rate);
                TextView open_rate = (TextView)findViewById(R.id.open_rate);
                TextView close_rate = (TextView)findViewById(R.id.close_rate);
                comp_name.setText(""+obj.getString("name")+"\n\nResults from: "+sdate+" - "+edate);
                high_rate.setText(high);
                low_rate.setText(low);
                open_rate.setText(open);
                close_rate.setText(close);

                highdp=new DataPoint[jsonArray.length()];
                lowdp=new DataPoint[jsonArray.length()];
                opendp=new DataPoint[jsonArray.length()];
                closedp=new DataPoint[jsonArray.length()];


//                System.out.println("----------->>>>"+jsonArray.getJSONArray(0).getString(0)+"\n ARRAY LENGTH :"+jsonArray.length());
     //           System.out.println("----------->>>>"+jsonArray.getJSONArray(43).getString(2));
                //date 0    //open 1     //high 2      //low 3     //close 5
                for(int i=jsonArray.length()-1;i>=0;i--)
                {
                    highdp[i]=new DataPoint(i,(int) Double.parseDouble(jsonArray.getJSONArray(i).getString(2)));
                    lowdp[i]=new DataPoint(i,(int) Double.parseDouble(jsonArray.getJSONArray(i).getString(3)));
                    opendp[i]=new DataPoint(i, (int)Double.parseDouble(jsonArray.getJSONArray(i).getString(1)));
                    closedp[i]=new DataPoint(i,(int) Double.parseDouble(jsonArray.getJSONArray(i).getString(5)));
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


            GraphView graph = (GraphView) findViewById(R.id.graph);





            LineGraphSeries<DataPoint> seriesHigh = new LineGraphSeries<>(highdp);
            LineGraphSeries<DataPoint> seriesLow = new LineGraphSeries<>(lowdp);
            LineGraphSeries<DataPoint> seriesOpen = new LineGraphSeries<>(opendp);
            LineGraphSeries<DataPoint> seriesClose = new LineGraphSeries<>(closedp);

            //graph1 config
            seriesHigh.setColor(Color.BLUE);
            seriesHigh.setDrawDataPoints(true);
            seriesHigh.setDataPointsRadius(12);
            seriesHigh.setThickness(8);
            seriesLow.setColor(Color.RED);
            seriesLow.setDrawDataPoints(true);
            seriesLow.setDataPointsRadius(12);
            seriesLow.setThickness(8);
            seriesOpen.setColor(Color.GREEN);
            seriesOpen.setDrawDataPoints(true);
            seriesOpen.setDataPointsRadius(12);
            seriesOpen.setThickness(8);
            seriesClose.setColor(Color.YELLOW);
            seriesClose.setDrawDataPoints(true);
            seriesClose.setDataPointsRadius(12);
            seriesClose.setThickness(8);


            // set manual X bounds
            graph.getViewport().setYAxisBoundsManual(true);
            graph.getViewport().setMinY(-150);
            graph.getViewport().setMaxY(150);

            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setMinX(4);
            graph.getViewport().setMaxX(80);

            // enable scaling and scrolling

            graph.getViewport().setScrollable(true); // enables horizontal scrolling
            graph.getViewport().setScrollableY(true); // enables vertical scrolling
            graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
            graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling

            graph.addSeries(seriesHigh);
            graph.addSeries(seriesLow);
            graph.addSeries(seriesOpen);
            graph.addSeries(seriesClose);

            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String companyName = getIntent().getExtras().getString("companyName");
        System.out.println("\n\n-----\n"+companyName+"\n\n-----\n\n");
        setContentView(R.layout.activity_graph);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        new StockDataTask().execute(NetworkUtils.buildUrl2(companyName));

        progressBar = (ProgressBar) findViewById(R.id.graph_progress);



    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }



}