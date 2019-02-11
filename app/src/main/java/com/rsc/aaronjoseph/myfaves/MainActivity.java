package com.rsc.aaronjoseph.myfaves;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.rsc.aaronjoseph.myfaves.Adapters.dataAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private DatabaseHandler db;
    private ListView lv;
    private dataAdapter data;
    private MyFaves dataModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorylistviewactivity);



        //Instantiate database handler
        db = new DatabaseHandler(this);

        lv = (ListView) findViewById(R.id.list_2);
        final String[] stringArray = getResources().getStringArray(R.array.MyFavesCategories);





        Button editMyFaves = (Button) findViewById(R.id.editMyFaves);

        editMyFaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, manageMyFaves.class);

                startActivity(intent);
            }
        });

        ShowRecords();
    }


    //Retrieve data from the database and set to the list view
    private void ShowRecords() {
        final ArrayList<MyFaves> myFaves = new ArrayList<>(db.getAllFaves());
        data = new dataAdapter(this, myFaves);

        lv.setAdapter(data);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dataModel = myFaves.get(position);

                String text = String.valueOf(dataModel.get_category());

                Intent intent = new Intent(MainActivity.this, TitleActivityList.class);

                intent.putExtra("ListViewCLickValue", text);
                startActivity(intent);

            }
        });
    }
}