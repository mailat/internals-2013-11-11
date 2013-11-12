package com.intel.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        Log.d("Novgorord", "second activity onCreate");
        
        //we hide the Button!
        Button button = (Button) findViewById(R.id.labelButton);
        button.setVisibility(View.INVISIBLE);
        
        //we change the text on the TextView
        TextView textview = (TextView) findViewById(R.id.labelText);
        textview.setText("Second activity demo");
    }
}
