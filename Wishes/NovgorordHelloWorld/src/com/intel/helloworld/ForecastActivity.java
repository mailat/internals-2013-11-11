package com.intel.helloworld;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;

public class ForecastActivity extends ListActivity {

    String loadForecastUrl ;
    private String response ="";
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //setContentView(R.layout.activity_main);
        Log.d("Novgorod", "second activity onCreate");
        
        //read the passed value
        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        
        //prepare the JSON url for the weather
        city = city.replaceAll(" ", "%20");
        //get the forecast of the next 5 days
        loadForecastUrl = "http://api.openweathermap.org/data/2.5/forecast?q=" + city 
        		+ "&ru&units=metric";
        
        //TODOthis is a ListaActivity so create an ArrayAdapter and assign it to the activity
        
        //the right way to get the weather
        new WeatherReaderUpdater().execute(loadForecastUrl);
    }
    
    //new WeatherReaderUpdater().execute();  
    private class WeatherReaderUpdater extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {

            try {
                // transporter for our in->out call
                HttpClient client = new DefaultHttpClient();
                HttpGet httpget = new HttpGet(loadForecastUrl);

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
		    	//TODO parse data corectly
		    	// use tool: http://jsonprettyprint.com/ with the browser output from
		    	// http://api.openweathermap.org/data/2.5/forecast?q=Nizhniy%20Novgorod&ru&units=metric
		    	
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
		        
		        //TODO for, while ...
		        //TODO add this in an ArrayAdapter
		        
		        //textview.setText(buffer.toString());
		                
		    } catch (JSONException e) {
		            e.printStackTrace();
		    }
        }
    }   
}
