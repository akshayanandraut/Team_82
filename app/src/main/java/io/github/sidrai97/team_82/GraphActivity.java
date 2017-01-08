package io.github.sidrai97.team_82;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

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

public class GraphActivity extends AppCompatActivity {
String url;
    final static String QUANDL_BASE_URL = "https://www.quandl.com/api/v3/datasets/NSE/";
    final static String API_KEY="Q--br_sJjG98J4pM1R5M";
    final static String PARAM_API_KEY = "api_key";
    final static String PARAM_START_DATE = "start_date";
    final static String PARAM_END_DATE = "end_date";
    JSONObject obj;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String companyName = getIntent().getExtras().getString("companyName");
        setContentView(R.layout.activity_graph);

        try {
             data = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl2(companyName));
        }
        catch(IOException e){e.printStackTrace();}
        System.out.print("===================="+data);


        GraphView graph = (GraphView) findViewById(R.id.graph);
        DataPoint[] high,low,open,close;
        high=new DataPoint[31];
        low=new DataPoint[31];
        open=new DataPoint[31];
        close=new DataPoint[31];
        for(int i=0;i<31;i++)
        {
            high[i]=new DataPoint(i,1);
            low[i]=new DataPoint(i,1);
            open[i]=new DataPoint(i,1);
            close[i]=new DataPoint(i,1);
        }







        LineGraphSeries<DataPoint> seriesHigh = new LineGraphSeries<>(high);
        LineGraphSeries<DataPoint> seriesLow = new LineGraphSeries<>(low);
        LineGraphSeries<DataPoint> seriesOpen = new LineGraphSeries<>(open);
        LineGraphSeries<DataPoint> seriesClose = new LineGraphSeries<>(close);





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


    }



}