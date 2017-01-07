package io.github.sidrai97.team_82;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //turn off title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //request fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_graph);
        //setContentView(R.layout.display_list);
        // /*
        GraphView graph = (GraphView) findViewById(R.id.graph);
        //GraphView graph1 = (GraphView) findViewById(R.id.graph1);
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

        //graph2
     /*   BarGraphSeries<DataPoint> series3 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        BarGraphSeries<DataPoint> series4 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 6),
                new DataPoint(1, 5),
                new DataPoint(2, 2),
                new DataPoint(3, 3),
                new DataPoint(4, 9)
        });
*/


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

        //graph1 scroll config
        // set manual X bounds
/*        graph1.getViewport().setYAxisBoundsManual(true);
        graph1.getViewport().setMinY(-150);
        graph1.getViewport().setMaxY(150);

        graph1.getViewport().setXAxisBoundsManual(true);
        graph1.getViewport().setMinX(4);
        graph1.getViewport().setMaxX(80);

        // enable scaling and scrolling
        graph1.getViewport().setScalable(true);
        graph1.getViewport().setScalableY(true);
        graph1.getViewport().setScrollable(true); // enables horizontal scrolling
        graph1.getViewport().setScrollableY(true); // enables vertical scrolling
        graph1.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph1.getViewport().setScalableY(true); // enables vertical zooming and scrolling

        //graph2 series config
        series3.setSpacing(1);
        series4.setSpacing(10);
*/

        ///custom stroke
       /* Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(3);
        paint.setPathEffect(new DashPathEffect(new float[]{8, 50}, 0));
        series1.setCustomPaint(paint);*/

//Listen on Tap
/*
        series1.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(MainActivity.this, ""+dataPoint, Toast.LENGTH_SHORT).show();
            }
        });
*/


        //Labels
        // String[] time = {"jan","feb","march","april"};
        // String[] up_downs  = {"0","5","10","15","20","25","30","35","40","45","50","55","60","65","70","75","80","85","90","95","100"};
        // StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        // staticLabelsFormatter.setHorizontalLabels(time);
        // staticLabelsFormatter.setVerticalLabels(up_downs);
        //  graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);


        // series3.setColor(Color.RED);




        graph.addSeries(series1);
        graph.addSeries(series2);
        //  graph1.addSeries(series4);
        //graph1.addSeries(series3);


        //*/


        //IGNORE ALL THAT IS AFTER AND BEFORE THIS PATTERN ========================----====================





        // ========================----====================

    }


}

