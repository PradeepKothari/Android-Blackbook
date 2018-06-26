package com.kogent.sharedpreferences;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.secondactivity);
	        TextView textView = (TextView) findViewById(R.id.text);
	        android.content.SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
	        String text = app_preferences.getString("key", "null");
	        textView.setText(text);
	    }

}
