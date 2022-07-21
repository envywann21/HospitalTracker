package com.example.hospitaltracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Server extends AppCompatActivity {
    EditText name, coordinate, location;

    RequestQueue queue;
    //ipaddr : 192.168.1.13
    final String URL = "http://192.168.1.13/hospitalfinder/api.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        queue = Volley.newRequestQueue(getApplicationContext());

        name = (EditText) findViewById(R.id.name);
        coordinate = (EditText) findViewById(R.id.coordinate);
        location = (EditText) findViewById(R.id.location);

        Button button = (Button) findViewById(R.id.loginbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //volley

                makeRequest();
            }

        });

    }

    public void makeRequest() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();

            }
        }, errorListener){
            @Override
            protected Map<String,String> getParams (){
                Map <String, String> params = new HashMap<>();

                params.put("name", name.getText().toString());
                params.put("coordinate", coordinate.getText().toString());
                params.put("location", location.getText().toString());

                return params;
            }
        };
        queue.add(stringRequest);

    }

    public Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

        }
    };


}