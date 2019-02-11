package com.rsc.aaronjoseph.myfaves;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class manageMyFaves extends Activity {

    Spinner categorySpinner;
    EditText titleEditText;
    EditText detailsEditText;
    EditText urlEditText;
    TextView displayTextView;
    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managemyfaves);

        Button addButton = (Button) findViewById(R.id.buttonAdd);
        Button deleteButton = (Button) findViewById(R.id.buttonDelete);

        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        titleEditText = (EditText) findViewById(R.id.titleEditText);
        detailsEditText = (EditText) findViewById(R.id.detailsEditText);
        urlEditText = (EditText) findViewById(R.id.urlEditText);
        displayTextView = (TextView) findViewById(R.id.displayTextView);

        dbHandler = new DatabaseHandler(this);
        printDatabase();

    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        displayTextView.setText(dbString);
        titleEditText.setText("");
        detailsEditText.setText("");
        urlEditText.setText("");
    }


    public void addButtonClicked(View view) {
        String spinnername = categorySpinner.getSelectedItem().toString();
        MyFaves myfaves = new MyFaves(spinnername, ", " + titleEditText.getText().toString(), " " + detailsEditText.getText().toString(),
                " " + urlEditText.getText().toString());
        dbHandler.addMyFave(myfaves);
        printDatabase();
        finish();
    }

    public void deleteButtonClicked(View view) {
        String inputText = titleEditText.getText().toString();

        dbHandler.deleteRow(inputText);
        printDatabase();
    }
}
