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
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.index_list_layout_company, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.nse_tag);
        txtTitle.setText(companyList[position]);
        System.out.print("here");
        return rowView;

    };

}