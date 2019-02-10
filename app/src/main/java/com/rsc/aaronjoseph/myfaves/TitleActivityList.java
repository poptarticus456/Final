package com.rsc.aaronjoseph.myfaves;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class TitleActivityList extends Activity {


    TextView textview;
    TextView textViews;


    MyDBHandler dbHandler;
    ListView listView;

    private static final int ENTER_DATA_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.titlelistviewactivity);





        final String[] stringArray = getResources().getStringArray(R.array.MyFavesCategories);
        listView = (ListView) findViewById(android.R.id.list);





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                textViews = (TextView) findViewById(R.id.textView);
                String text = stringArray[position].toString();

                Intent intent = new Intent(TitleActivityList.this, DetailsViewActivity.class);

                intent.putExtra("ListViewCLickValue", text);
                startActivity(intent);


            }
        });

        textview = (TextView) findViewById(R.id.textView);


        String title = getIntent().getStringExtra("ListViewCLickValue");

        textview.setText(title);

    }
}
