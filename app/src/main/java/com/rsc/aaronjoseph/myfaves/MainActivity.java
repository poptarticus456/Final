package com.rsc.aaronjoseph.myfaves;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {


    private ListView listView;
    private MyDBHandler dbHandler;
    private MyFaves newCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorylistviewactivity);
        Button editMyFaves = (Button) findViewById(R.id.editMyFaves);


        final String[] stringArray = getResources().getStringArray(R.array.MyFavesCategories);
        final ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String text = stringArray[position].toString();

                Intent intent = new Intent(MainActivity.this, TitleActivityList.class);

                intent.putExtra("ListViewCLickValue", text);
                startActivity(intent);
            }
        });





        editMyFaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, manageMyFaves.class);

                startActivity(intent);
            }
        });


    }


}
