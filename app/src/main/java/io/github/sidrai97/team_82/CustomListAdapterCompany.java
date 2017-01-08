package io.github.sidrai97.team_82;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

/**
 * Created by HP on 07-01-2017.
 */

public class CustomListAdapterCompany  extends ArrayAdapter<String> {

    private final AppCompatActivity context;
    private String[] companyList;


    public CustomListAdapterCompany(AppCompatActivity context, String[] companyList) {
        super(context, R.layout.activity_main, companyList);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.companyList = companyList;
        // this.stockRate=stockRate;



    }



    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.index_list_layout, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.nse_tag);

        int i=0;
        do {
            AsyncTaskRunner runner = new AsyncTaskRunner(context, companyList[i]);
            runner.execute(companyList[i]);
            i++;
        }while(i<companyList.length);


        txtTitle.setText(companyList[position]);


        System.out.print("here");
        return rowView;

    };
    public JSONObject getJSONObjectFromURL(String urlString) throws IOException, JSONException {
        System.out.print("here1");
        HttpURLConnection urlConnection = null;

        URL url = new URL(urlString);

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

    class AsyncTaskRunner extends AsyncTask<String, String, String[]> {

        private String[] resp;
        private Context context;
        private String companyName;

        AsyncTaskRunner(AppCompatActivity context1, String companyName) {
            context = context1;
            this.companyName = companyName;
        }

        @Override
        protected String[] doInBackground(String... params) {
            companyName = params[0];
            //perform operations here
            try {
                int i = 0;
                while(i<1)
                {
                    Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int date = c.get(Calendar.DATE);


                    JSONObject obj = getJSONObjectFromURL("https://www.quandl.com/api/v3/datasets/NSE/"+companyName+"?start_date="+year+"-"+month+"-"+date+"api_key=Q--br_sJjG98J4pM1R5M");
                    System.out.print(obj);

                    //JSONObject obj1 = obj.getJSONObject(stockName+"");
                    //JSONArray m_jArry = obj1.getJSONArray("stock_url");
                    i++;
                }



            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return resp;
        }


        @Override
        protected void onPostExecute(String... result) {

        }


        @Override
        protected void onPreExecute() {
            System.out.println("on pre execute--------------------------------------");
        }


        @Override
        protected void onProgressUpdate(String... text) {
        }


    }
}