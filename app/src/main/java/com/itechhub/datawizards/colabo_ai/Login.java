package com.itechhub.datawizards.colabo_ai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initialize();
    }
    void initialize(){
        Button btnLogin = (Button) findViewById(R.id.login_Button);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.login_Button:
                startActivity(new Intent(getBaseContext(),Main.class));
                finish();
                break;
            default:
                break;
        }
    }
}
