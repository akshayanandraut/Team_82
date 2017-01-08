package io.github.sidrai97.team_82;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class IndexListAdaptor extends BaseAdapter {

    ArrayList<String> arrayList;
    Context context;
    LayoutInflater inflater;

    public IndexListAdaptor(Context context, ArrayList<String> arrayList){
        this.context=context;
        this.arrayList=arrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.index_list_layout,null);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        JSONObject obj=null;
        try {
            obj = new JSONObject((String) getItem(position));
           // Toast.makeText(context,"-------------------\n"+obj,Toast.LENGTH_SHORT).show();

            String fullname = obj.getJSONObject("dataset").getString("name");
            int pos = fullname.lastIndexOf("-");
            String name = fullname.substring(pos+1);
            myViewHolder.nse_tag.setText(name);
            //Log.d("JSON ME LAGE","BAMBOO");
            JSONArray all_data=obj.getJSONObject("dataset").getJSONArray("data");
            JSONArray latest_data=all_data.getJSONArray(0);

            String date=latest_data.getString(0);
            myViewHolder.nse_date.setText(date);

            String htl = latest_data.getDouble(2) + " - "+ latest_data.getDouble(3);
            myViewHolder.nse_high_to_low.setText(htl);

            float rf = new Float(latest_data.getDouble(4))-
                    new Float(latest_data.getDouble(1));
            String rf_set="";
            if(rf>0){
                rf_set=" +"+rf;
                myViewHolder.nse_rise_fall.setTextColor(ContextCompat.getColor(context,R.color.colorPrimaryDark));
            }else{
                rf_set=" "+rf;
                myViewHolder.nse_rise_fall.setTextColor(ContextCompat.getColor(context,R.color.danger));
            }
            myViewHolder.nse_rise_fall.setText(rf_set);
        }catch (JSONException e){e.printStackTrace();}
        return convertView;
    }

    private class MyViewHolder{
        TextView nse_tag,nse_date,nse_high_to_low,nse_rise_fall;

        public MyViewHolder(View item){
            nse_tag = (TextView)item.findViewById(R.id.nse_tag);
            nse_date = (TextView)item.findViewById(R.id.nse_date);
            nse_high_to_low = (TextView)item.findViewById(R.id.nse_high_to_low);
            nse_rise_fall = (TextView)item.findViewById(R.id.nse_rise_fall);
        }
    }
}
