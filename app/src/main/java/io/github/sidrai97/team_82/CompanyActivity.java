package io.github.sidrai97.team_82;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
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

import static android.R.attr.button;
import static android.R.id.list;
import static android.provider.ContactsContract.CommonDataKinds.Website.URL;
import static io.github.sidrai97.team_82.R.id.refresh_btn;

/**
 * Created by HP on 07-01-2017.
 */

public class CompanyActivity extends AppCompatActivity {
    ListView list;
    //get company names for selected type
    String[] companyList;
    ArrayList<String> arrayList=new ArrayList<String>();
    ArrayList<String> companyName=new ArrayList<String>();
    private String stockName;
    Menu mymenu;
    ProgressBar progressBar;

    public class MyTask extends AsyncTask<String[],Void,String>{
        @Override
        protected String doInBackground(String[]... params) {
            for (int i=0;i<params[0].length;i++) {
                String temp="";
                try {
                    temp=NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl(params[0][i]));
                }catch (IOException e){e.printStackTrace();}
                catch(Exception e){e.printStackTrace();continue;}
                if(temp!="" || temp != null){
                    arrayList.add(temp);
                    companyName.add(params[0][i]);
                }
            }
            /*System.out.println("\n\n-----------\n\n"+params[0][0]+"\n\n--------\n\n\n");
            try {
                arrayList.add(NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl(params[0][0])));
            }catch (IOException e){e.printStackTrace();}*/

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            IndexListAdaptor indexListAdaptor = new IndexListAdaptor(CompanyActivity.this,arrayList);
            list.setAdapter(indexListAdaptor);
            progressBar.setVisibility(View.INVISIBLE);

            list.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub

                    //String selectedItem= companyList[+position];
                    String selectedItem= arrayList.get(position);
                    Intent i = new Intent(CompanyActivity.this,GraphActivity.class);
                    i.putExtra("companyName",""+companyName.get(position));

                    startActivity(i);
                }
            });
            list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                               int pos, long id) {
                    // TODO Auto-generated method stub

                    // Log.v("long clicked","pos: " + pos);
                    // Toast.makeText(CompanyActivity.this,"pos:"+pos,Toast.LENGTH_SHORT).show();
                    //type your code here to diaplay add to favourite dialog


                    return true;
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list=(ListView)findViewById(R.id.companyList);
        progressBar=(ProgressBar)findViewById(R.id.company_progress);

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

        new MyTask().execute(companyList);
        /*CustomListAdapterCompany adapter=new CustomListAdapterCompany(this, companyList);
        list=(ListView)findViewById(R.id.companyList);
        list.setAdapter(adapter);
*/
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mymenu=menu;
        getMenuInflater().inflate(R.menu.app_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == refresh_btn){
            Toast.makeText(getApplicationContext(),"Refreshing",Toast.LENGTH_SHORT).show();
            refresh_data();
        }
        else if(item.getItemId() == R.id.favourites_tab){
            Toast.makeText(getApplicationContext(),"show favourites",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }*/

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