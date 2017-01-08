package io.github.sidrai97.team_82;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.SystemClock;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import static android.R.id.list;
import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by HP on 07-01-2017.
 */

public class CompanyActivity extends AppCompatActivity {
    ListView list;
    //get company names for selected type
    String[] companyList;
    private String stockName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        Bundle extras = getIntent().getExtras();
        stockName = extras.getString("stockName");
       try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONObject obj1 = obj.getJSONObject(""+stockName);
            JSONArray m_jArry = obj1.getJSONArray("stock_url");
            int i=0;
            companyList = new String[m_jArry.length()];
            do
            {
                companyList[i] = m_jArry.getString(i);
                i++;
            }while(i<m_jArry.length());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomListAdapterCompany adapter=new CustomListAdapterCompany(this, companyList);
        list=(ListView)findViewById(R.id.companyList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

                String selectedItem= companyList[+position];

                Intent i = new Intent(CompanyActivity.this,GraphActivity.class);
                i.putExtra("companyName",""+companyList[+position]);

                startActivity(i);
            }
        });
    }
    public String loadJSONFromAsset() {
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
}