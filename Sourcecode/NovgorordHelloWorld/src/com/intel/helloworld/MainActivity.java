package com.intel.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        Log.d("Novgorod", "onCreate");
    }
    
    public void showSecondActivity (View v)
    {
        //jump in the second activity
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        
        //we read the input city
        EditText cityInputText = (EditText) findViewById(R.id.cityInputText);
        String city = cityInputText.getText().toString();
        Log.d("Novgorod", "Our city is:" + city);
        
        //we add the city to the Intent and pass it to the second activity
        intent.putExtra("city", city);
        
        //I start the second activity
        startActivity(intent);	
    }

	@Override
	protected void onDestroy() {
        Log.d("Novgorod", "onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
        Log.d("Novgorod", "onPause");
		super.onPause();
	}

	@Override
	protected void onRestart() {
        Log.d("Novgorod", "onRestart");
		super.onRestart();
	}

	@Override
	protected void onResume() {
        Log.d("Novgorod", "onResume");
		super.onResume();
	}

	@Override
	protected void onStart() {
        Log.d("Novgorod", "onStart");
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

    

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    
}
