package io.github.sidrai97.team_82;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HP on 07-01-2017.
 */

public class CustomListAdapterStock  extends ArrayAdapter<String> {

    private final AppCompatActivity context;
    private  String[] stockName = {"asdas"};


    public CustomListAdapterStock(AppCompatActivity context, String[] stockName) {
        super(context, R.layout.display_stocks, stockName);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.stockName=stockName;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.display_stocks, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.stock_name);


        txtTitle.setText(stockName[position]);

        return rowView;

    };
}
