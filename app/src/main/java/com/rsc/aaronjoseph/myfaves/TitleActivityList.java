package com.rsc.aaronjoseph.myfaves;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import com.rsc.aaronjoseph.myfaves.Adapters.dataAdapterTitle;


import java.util.ArrayList;

public class TitleActivityList extends Activity {


    private DatabaseHandler db;
    private String title;
    private ListView lv;
    private dataAdapterTitle data;
    private MyFaves dataModel;
    private String CategoryName;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.titlelistviewactivity);

        textView = (TextView) findViewById(R.id.TopDetails);
        //Instantiate database handler
        db=new DatabaseHandler(this);

        CategoryName = getIntent().getStringExtra("ListViewCLickValue");
        textView.setText(CategoryName);

        lv = (ListView) findViewById(R.id.list_2);

        ShowRecords();






    }

    //Retrieve data from the database and set to the list view
    private void ShowRecords(){
        final ArrayList<MyFaves> myFaves = new ArrayList<>(db.GetTitle(CategoryName));
        data=new dataAdapterTitle(this, myFaves);

        lv.setAdapter(data);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dataModel = myFaves.get(position);

                String text = String.valueOf(dataModel.get_id());
                String title = String.valueOf(dataModel.get_category());

                Intent intent = new Intent(TitleActivityList.this, DetailsViewActivity.class);

                intent.putExtra("ListViewCLickValues", text);
                intent.putExtra("Categorytitle", title);
                startActivity(intent);

            }
        });
    }
}
