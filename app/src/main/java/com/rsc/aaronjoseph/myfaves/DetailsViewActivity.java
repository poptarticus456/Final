package com.rsc.aaronjoseph.myfaves;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.rsc.aaronjoseph.myfaves.Adapters.dataAdapterTitle;
import com.rsc.aaronjoseph.myfaves.Adapters.dataAdapterUrl;

import java.util.ArrayList;

public class DetailsViewActivity extends Activity {

    private DatabaseHandler db;
    private int id;
    private MyFaves dataModel;
    private TextView titleDisplayText, detailDisplayText, urlDisplayText;
    private String dbString, dbStrings, dbStringss;
    private String title;
    private ListView lv;
    private dataAdapterUrl data;
    private String CategoryName;
    private TextView textView;

    DatabaseHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailslistviewactivity);


        titleDisplayText = (TextView) findViewById(R.id.titledisplaytext);
        detailDisplayText = (TextView) findViewById(R.id.detailsdisplaytext);
        urlDisplayText = (TextView) findViewById(R.id.urlTextView);

        //Instantiate database handler
        db=new DatabaseHandler(this);

        id = Integer.parseInt(getIntent().getStringExtra("ListViewCLickValues"));


        printDatabase();

        urlDisplayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyFaves contact = new MyFaves();

                String text = contact.get_url();

                Intent intent = new Intent(DetailsViewActivity.this, WebViewActivity.class);

                intent.putExtra("ListViewCLickValues", text);
                startActivity(intent);

            }
        });

    }

    private void printDatabase() {
        dbString = db.databaseToStrings(id);
        dbStrings = db.databaseToStringss(id);
        dbStringss = db.databaseToStringsss(id);
        titleDisplayText.setText(dbString);
        detailDisplayText.setText(dbStrings);
        urlDisplayText.setText(dbStringss);
        urlDisplayText.setPaintFlags(urlDisplayText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);



    }


}