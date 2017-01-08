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

        //System.out.println("CHECK THIS Out--------->  "+companyList[3]);
       try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
           System.out.println("JSON OBJ1 ---------------------->"+obj);
            JSONObject obj1 = obj.getJSONObject(""+stockName);
           System.out.println("JSON OBJ2 ---------------------->"+obj1);

           JSONArray m_jArry = obj1.getJSONArray("stock_url");
           //System.out.println("CHECK THIS Out--------->  ");
            //Toast.makeText(CompanyActivity.this,"-------------"+m_jArry,Toast.LENGTH_SHORT).show();
            int i=0;
            companyList = new String[m_jArry.length()];
           System.out.println("CHECK THIS Out--------->  "+companyList[3]);
            do
            {
                companyList[i] = m_jArry.getString(i);
                i++;
            }while(i<m_jArry.length());

            System.out.println("CHECK THIS Out--------->  "+companyList[3]);


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
                System.out.println(position);
                String selectedItem= companyList[+position];
                System.out.println(position);
                Intent i = new Intent(CompanyActivity.this,GraphActivity.class);
                i.putExtra("companyName",""+companyList[+position]);
                System.out.println(position);
                startActivity(i);
                //Toast.makeText(getApplicationContext(), selectedItem.replaceAll("_"," "), Toast.LENGTH_SHORT).show();

            }
        });
/*
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONObject obj1 = obj.getJSONObject(stockName);
            JSONArray m_jArry = obj1.getJSONArray("stock_url");

            System.out.println(m_jArry);
            // Toast.makeText(getApplicationContext(), , Toast.LENGTH_SHORT).show();

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        */


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