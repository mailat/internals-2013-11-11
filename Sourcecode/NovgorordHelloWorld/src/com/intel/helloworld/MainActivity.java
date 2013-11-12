package com.intel.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        Log.d("Novgorord", "onCreate");
    }
    
    public void showSecondActivity (View v)
    {
        //jump in the second activity
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        
        //TODO pass some values
        
        startActivity(intent);	
    }

	@Override
	protected void onDestroy() {
        Log.d("Novgorord", "onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
        Log.d("Novgorord", "onPause");
		super.onPause();
	}

	@Override
	protected void onRestart() {
        Log.d("Novgorord", "onRestart");
		super.onRestart();
	}

	@Override
	protected void onResume() {
        Log.d("Novgorord", "onResume");
		super.onResume();
	}

	@Override
	protected void onStart() {
        Log.d("Novgorord", "onStart");
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
