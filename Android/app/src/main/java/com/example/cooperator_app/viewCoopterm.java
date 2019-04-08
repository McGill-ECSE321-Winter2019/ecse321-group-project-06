package com.example.cooperator_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;
import static android.util.Log.e;

public class viewCoopterm extends AppCompatActivity {
    String json_string = "";
    private String error = "";
    JSONArray employerArray;
    CoopTermAdapter coopTermAdapter;
    ListView listview;
    String coopUserId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        coopUserId=this.getIntent().getStringExtra("coopUserId");
        HttpUtils.get("/coopTerm/employer/"+coopUserId, new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                json_string = response.toString();
                try {
                    employerArray = new JSONArray(json_string);
                    int count = 0;
                    String startDate, endDate, state;
                    while (count < employerArray.length()) {
                        JSONObject e = employerArray.getJSONObject(count);
                        startDate = e.getString("startDate");
                        endDate = e.getString("endDate");
                        state = e.getString("state");
                        CoopTerm coopTerm = new CoopTerm(startDate, endDate, state);
                        coopTermAdapter.add(coopTerm);
                        count++;
                    }
                } catch (JSONException e) {
                    e("MYAPP", "unexpected JSON exception", e);
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    error += errorResponse.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }
                refreshErrorMessage();
            }
        });
        setContentView(R.layout.activity_view_coopterm);
        listview = (ListView) findViewById(R.id.list_coopterms);
        coopTermAdapter = new CoopTermAdapter(this, R.layout.row_layout1);
        listview.setAdapter(coopTermAdapter);
    }

    public void directToHome(View v){
        Intent intent= new Intent(this, dashboard.class);
        intent.putExtra("coopUserId",coopUserId);
        startActivity(intent);
    }

    private void refreshErrorMessage() {
        // set the error message
        TextView tvError = findViewById(R.id.error);
        tvError.setText(error);

        if (error == null || error.length() == 0) {
            tvError.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.VISIBLE);
        }
    }
}