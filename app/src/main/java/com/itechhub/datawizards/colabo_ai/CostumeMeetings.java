package com.itechhub.datawizards.colabo_ai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CostumeMeetings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_meeting);
        initialize();
    }
    void initialize(){

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getBaseContext(),Recommended.class));
        finish();
    }
}
