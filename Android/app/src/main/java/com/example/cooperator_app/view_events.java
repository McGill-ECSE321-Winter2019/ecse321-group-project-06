package com.example.cooperator_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class view_events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events);
    }
    public void viewEvent1(View v){
        Intent intent= new Intent(this, event1.class);
        startActivity(intent);
    }
    public void viewEvent2(View v){
        Intent intent= new Intent(this, event2.class);
        startActivity(intent);
    }
    public void directToHome(View v){
        Intent intent= new Intent(this, dashboard.class);
        startActivity(intent);
    }
}
