package com.itechhub.datawizards.colabo_ai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CostumeMeetings extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private ArrayAdapter<String> arrayAdapter;
    ArrayList<String> mettings = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_meeting);
        initialize();

    }
    void initialize(){
        listView = (ListView) findViewById(R.id.project_list_view);

        //TODO get data an generate String Array

        //
        arrayAdapter = new ArrayAdapter<String>(getBaseContext(),R.layout.projects_recommended,mettings);
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
