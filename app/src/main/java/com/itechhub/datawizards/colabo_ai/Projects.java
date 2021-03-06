package com.itechhub.datawizards.colabo_ai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Projects extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayAdapter<String> arrayAdapter;
    ArrayList<String> projectsAssigned = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projects);
        initialize();

    }
    void initialize(){
        listView = (ListView) findViewById(R.id.project_list_view);

        //TODO get data an generate String Array
        projectsAssigned.add("Technical support team are changing the company computers and they will be " +
                "upgrading the company network from next week. You are recommended to join the group");
        projectsAssigned.add("Data Wizards are starting a project on the the 18th of November, 2017." +
                "You are recommended to join the group");
        //
        arrayAdapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,projectsAssigned);
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
