package com.example.laith.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView txvHello;
    private RequestQueue requestQueue;
    private TextView txvHello1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvHello1=(TextView) findViewById(R.id.txvHello1);
        txvHello = (TextView) findViewById(R.id.txvHello);
        requestQueue= Volley.newRequestQueue(this);
        laith();
    }
    public void laith(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://192.168.43.25:5000/signin",
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                txvHello.setText(response.optString("username"));
                txvHello1.setText(response.optString("password"));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txvHello.setText(error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
