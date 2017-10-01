package com.itechhub.datawizards.colabo_ai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColleaguesMeeting extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayAdapter<String> arrayAdapter;
    ArrayList<String> meetings = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colleques_meeting);
        initialize();
    }
    void initialize(){
        listView = (ListView) findViewById(R.id.meetings_list_view);

        //TODO get data an generate String Array
        meetings.add("Mabu, is having a meeting with Lero at 12:30 pm on the 21st of October");
        meetings.add("Asive and Msamiro they are having a meeting now...");
        //
        arrayAdapter = new ArrayAdapter<>(getBaseContext(),android.R.layout.simple_list_item_1,meetings);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> group, View view, int position, long _id) {
        //TODO decide what to do when the item is clicked

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getBaseContext(),Main.class));
        finish();
    }

}
