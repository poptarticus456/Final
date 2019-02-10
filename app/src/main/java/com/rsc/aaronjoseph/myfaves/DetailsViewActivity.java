package com.rsc.aaronjoseph.myfaves;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsViewActivity extends Activity {

    TextView textview;
    TextView titledisplaytext;
    TextView detailsdisplaytext;
    TextView urlTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailslistviewactivity);


        textview = (TextView) findViewById(R.id.textView);
        titledisplaytext = (TextView) findViewById(R.id.TitleTextView);
        detailsdisplaytext = (TextView) findViewById(R.id.detailsdisplaytext);
        urlTextView = (TextView) findViewById(R.id.urlTextView);

        String title = getIntent().getStringExtra("ListViewCLickValue");

        textview.setText(title);



    }
}
