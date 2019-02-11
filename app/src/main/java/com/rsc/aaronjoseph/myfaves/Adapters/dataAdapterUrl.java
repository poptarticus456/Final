package com.rsc.aaronjoseph.myfaves.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rsc.aaronjoseph.myfaves.MyFaves;
import com.rsc.aaronjoseph.myfaves.R;

import java.util.ArrayList;

public class dataAdapterUrl extends ArrayAdapter<MyFaves> {

    Context context;
    ArrayList<MyFaves> mfave;


    public dataAdapterUrl(Context context, ArrayList<MyFaves> myfaves){
        super(context, R.layout.listcontacts, myfaves);
        this.context=context;
        this.mfave=myfaves;
    }

    public  class  Holder{
        TextView Title;
        //TextView Detail;
        //TextView URL;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        MyFaves data = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        Holder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {


            viewHolder = new Holder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listcontacts, parent, false);

            viewHolder.Title = (TextView) convertView.findViewById(R.id.txtView1);
            //viewHolder.Detail = (TextView) convertView.findViewById(R.id.txtView2);
            //viewHolder.URL = (TextView) convertView.findViewById(R.id.txtView3);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Holder) convertView.getTag();
        }


        viewHolder.Title.setText(data.get_url());
        //viewHolder.nameSV.setText("Second Name: "+data.getSName());
        //viewHolder.phoneV.setText("Phone no: "+data.getPhoneNumber());

        // Return the completed view to render on screen
        return convertView;
    }

}