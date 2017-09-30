package com.itechhub.datawizards.colabo_ai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        initialize();
    }
    void initialize(){

    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getBaseContext(),Main.class));
        finish();
    }
}
