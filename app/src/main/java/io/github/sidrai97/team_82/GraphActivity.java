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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String companyName = getIntent().getExtras().getString("companyName");
        setContentView(R.layout.activity_graph);

        try {
            String data = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl2(companyName));
        }
        catch(IOException e){e.printStackTrace();}
        System.out.print("===================="+obj);


        GraphView graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 6),
                new DataPoint(1, 5),
                new DataPoint(2, 2),
                new DataPoint(3, 3),
                new DataPoint(4, 9)
        });





        //graph1 config
        series1.setColor(Color.RED);
        series1.setDrawDataPoints(true);
        series1.setDataPointsRadius(12);
        series1.setThickness(8);
        series2.setColor(Color.CYAN);
        series2.setDrawDataPoints(true);
        series2.setDataPointsRadius(12);
        series2.setThickness(8);

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



//Listen on Tap
/*
        series1.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(GraphActivity.this, ""+dataPoint, Toast.LENGTH_SHORT).show();
            }
        });

*/






        graph.addSeries(series1);
        graph.addSeries(series2);


    }

    public  JSONObject getJSONObjectFromURL(URL urlString) throws IOException, JSONException {

        HttpURLConnection urlConnection = null;

        URL url = urlString;

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */);
        urlConnection.setConnectTimeout(15000 /* milliseconds */);

        urlConnection.setDoOutput(true);

        urlConnection.connect();

        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

        char[] buffer = new char[1024];

        String jsonString = new String();

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        jsonString = sb.toString();

        System.out.println("JSON: " + jsonString);

        return new JSONObject(jsonString);
    }

}