package com.example.cooperator_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class event1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1);
    }
    public void directToHome(View v){
        Intent intent= new Intent(this, dashboard.class);
        startActivity(intent);
    }
}
