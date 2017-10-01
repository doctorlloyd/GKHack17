package com.itechhub.datawizards.colabo_ai;

import android.animation.Animator;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> scheduleMeeting = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView list;
    FloatingActionButton fab, fab1, fab2, fab3, fab4;
    LinearLayout fabLayout1, fabLayout2, fabLayout3, fabLayout4;
    View fabBGLayout;
    boolean isFABOpen = false;
    //URL to get JSON Array
    private static String url = "http://10.0.2.2/JSON/";

    //JSON Node Names
    private static final String TAG_USER = "user";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_EMAIL = "email";

    JSONArray user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initialize();
        // Creating new JSON Parser
//        JSONParser jParser = new JSONParser();
//
//        // Getting JSON from URL
//        JSONObject json = jParser.getJSONFromUrl(url);
//
//        try {
//            // Getting JSON Array
//            user = json.getJSONArray(TAG_USER);
//            JSONObject c = user.getJSONObject(0);
//
//            // Storing  JSON item in a Variable
//            String id = c.getString(TAG_ID);
//            String name = c.getString(TAG_NAME);
//            String email = c.getString(TAG_EMAIL);
//
//            //Importing TextView
////            final TextView uid = (TextView)findViewById(R.id.uid);
////            final TextView name1 = (TextView)findViewById(R.id.name);
////            final TextView email1 = (TextView)findViewById(R.id.email);
//
//            //Set JSON Data in TextView
////            uid.setText(id);
////            name1.setText(name);
////            email1.setText(email);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }
    void initialize(){
        fabLayout1 = (LinearLayout) findViewById(R.id.fabLayout1);
        fabLayout2 = (LinearLayout) findViewById(R.id.fabLayout2);
        fabLayout3 = (LinearLayout) findViewById(R.id.fabLayout3);
        fabLayout4 = (LinearLayout) findViewById(R.id.fabLayout4);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab4 = (FloatingActionButton) findViewById(R.id.fab4);
        fabBGLayout = findViewById(R.id.fabBGLayout);
        scheduleMeeting.add("Mr Johannes can you be able to meet me today");
        scheduleMeeting.add("Hello Lero, are we still having a meeting today?");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFABOpen) {
                    showFABMenu();

                } else {
                    closeFABMenu();
                }
            }
        });

        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        fab4.setOnClickListener(this);
        fabBGLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFABMenu();
            }
        });
        adapter = new ArrayAdapter<>(getBaseContext(),android.R.layout.simple_list_item_1,scheduleMeeting);
        list = (ListView) findViewById(R.id.list_view_main);
        list.setAdapter(adapter);
    }
    private void showFABMenu() {
        isFABOpen = true;
        fabLayout1.setVisibility(View.VISIBLE);
        fabLayout2.setVisibility(View.VISIBLE);
        fabLayout3.setVisibility(View.VISIBLE);
        fabLayout4.setVisibility(View.VISIBLE);
        fabBGLayout.setVisibility(View.VISIBLE);

        fab.animate().rotationBy(90);
        fabLayout1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fabLayout2.animate().translationY(-getResources().getDimension(R.dimen.standard_100));
        fabLayout3.animate().translationY(-getResources().getDimension(R.dimen.standard_145));
        fabLayout4.animate().translationY(-getResources().getDimension(R.dimen.standard_190));
    }

    private void closeFABMenu() {
        isFABOpen = false;
        fabBGLayout.setVisibility(View.GONE);
        fab.animate().rotationBy(-90);
        fabLayout1.animate().translationY(0);
        fabLayout2.animate().translationY(0);
        fabLayout3.animate().translationY(0);
        fabLayout4.animate().translationY(0).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (!isFABOpen) {
                    fabLayout1.setVisibility(View.GONE);
                    fabLayout2.setVisibility(View.GONE);
                    fabLayout3.setVisibility(View.GONE);
                    fabLayout4.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (isFABOpen) {
            closeFABMenu();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab1:
            //Profile
                startActivity(new Intent(getBaseContext(),Profile.class));
                finish();
                break;
            case R.id.fab2:
            //Projects
                startActivity(new Intent(getBaseContext(),Projects.class));
                finish();
                break;
            case R.id.fab3:
                //Meet Colleagues
                startActivity(new Intent(getBaseContext(),Recommended.class));
                finish();
                break;
            case R.id.fab4:
            //Colleagues Meeting
                startActivity(new Intent(getBaseContext(),ColleaguesMeeting.class));
                finish();
                break;
            default:
                break;
        }
    }
}
