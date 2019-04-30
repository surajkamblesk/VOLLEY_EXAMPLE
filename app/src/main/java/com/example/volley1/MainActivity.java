package com.example.volley1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editText);
     final   TextView textView = findViewById(R.id.textView);

     btn.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
             // Instantiate the RequestQueue.
             RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
             String url ="http://www.google.com";


// Request a string response from the provided URL.
             StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                     new Response.Listener<String>() {
                         @Override
                         public void onResponse(String response) {
                             // Display the first 500 characters of the response string.
                             textView.setText("Response is: "+ response.substring(0,500));
                         }
                     }, new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {
                     Toast.makeText(MainActivity.this ,"Something went wrong",Toast.LENGTH_SHORT).show();
                 }
             });

// Add the request to the RequestQueue.
             queue.add(stringRequest);
         }
     });
    }
}
