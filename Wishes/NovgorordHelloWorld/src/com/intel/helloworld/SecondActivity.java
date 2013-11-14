package com.intel.helloworld;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    String loadUrl ;
    String loadForecastUrl ;
    TextView textview;
    private String response ="";
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        Log.d("Novgorod", "second activity onCreate");
        
        //read the passed value
        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        
        //we hide the Button!
        Button button = (Button) findViewById(R.id.labelButton);
        button.setVisibility(View.INVISIBLE);
        
        //we change the text on the TextView with the city
        textview = (TextView) findViewById(R.id.labelText);
        textview.setText("City is:" + city);
        
        //prepare the JSON url for the weather
        city = city.replaceAll(" ", "%20");
        loadUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + ",ru&units=metric";
        
        //load the weather in WebView
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setVisibility(View.VISIBLE);
        webView.loadUrl(loadUrl);
        
        //the right way to get the weather
        new WeatherReaderUpdater().execute(loadUrl);
        
        //get the forecast of the next 5 days
        loadForecastUrl = "http://api.openweathermap.org/data/2.5/forecast?q=" + city 
        		+ "&ru&units=metric";
    }
    
    //new WeatherReaderUpdater().execute();  
    private class WeatherReaderUpdater extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {

                try {
                        // transporter for our in->out call
                        HttpClient client = new DefaultHttpClient();
                        HttpGet httpget = new HttpGet(loadUrl);

                        response = client.execute(httpget, new BasicResponseHandler());
                        Log.d("Novgorod", "response back: " + response);
                } catch (Throwable e) {
                        e.printStackTrace();
                        Log.d("Novgorod", "response back: " + e.getMessage());
                }

                return null;
        }

        @Override
        protected void onPostExecute(Void result) {
        try {
                StringBuffer buffer = new StringBuffer();
                JSONObject jObj = new JSONObject(response);
                        
                //get JSONObject - coord
                JSONObject jsonObj = jObj.getJSONObject("coord");
                
                //get string from coord - lat, lon
                buffer.append(jsonObj.getString("lat")).append(" - ");
                buffer.append(jsonObj.getString("lon")).append(" , temp: ");
                        
                //get JSONObject - main
                jsonObj = jObj.getJSONObject("main");
                //get temp
                buffer.append(jsonObj.getString("temp"));
                
                textview.setText(buffer.toString());
                        
                } catch (JSONException e) {
                        e.printStackTrace();
                }
        }
}   
}
