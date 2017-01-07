package io.github.sidrai97.team_82;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import io.github.sidrai97.team_82.*;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

import org.json.JSONArray;
import org.json.JSONObject;

import static android.R.id.list;
import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {
    private int backPressed = 0;

    ListView list;
    String[] stockName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        try {

            JSONArray jr = new JSONArray("Your json string");
            JSONObject jb = (JSONObject)jr.getJSONObject(0);
            JSONArray st = jb.getJSONArray("streets");
            for(int i=0;i<st.length();i++)
            {
                String street = st.getString(i);
                Log.i("..........",""+street);
                // loop and add it to array or arraylist
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        CustomListAdapterStock adapter=new CustomListAdapterStock(this, stockName);
        list=(ListView)findViewById(R.id.display_stocks_list);
        list.setAdapter(adapter);


      list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String selectedItem= stockName[+position];
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();

            }
        });


    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressed++;
        if(backPressed == 2) {
            super.onBackPressed();
            finishAffinity();

        }
        else
        {
            Toast.makeText(MainActivity.this,"Press back once again to exit from Investomaster", Toast.LENGTH_LONG).show();
        }

    }

}
