package com.example.cooperator_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import cz.msebera.android.httpclient.Header;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

public class dashboard extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String json_string;
    private String error = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void directToHome(View v){
        Intent intent= new Intent(this, dashboard.class);
        startActivity(intent);
    }
    public void viewCoopterms(View v){
        Intent intent= new Intent(this, viewCoopterm.class);
        startActivity(intent);
    }
    public void viewEvents(View v){
        Intent intent= new Intent(this, view_events.class);
        startActivity(intent);
    }
    private void refreshErrorMessage() {
        // set the error message
        TextView tvError =findViewById(R.id.error);
        tvError.setText(error);

        if (error == null || error.length() == 0) {
            tvError.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.VISIBLE);
        }
    }
}
