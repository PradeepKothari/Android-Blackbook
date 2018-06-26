package com.kogent.sharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SharedPreferences extends Activity {
    
    private android.content.SharedPreferences score;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shared_preferences);
		Button button = (Button) findViewById(R.id.button);
        final EditText textbox = (EditText) findViewById(R.id.textbox);
        button.setOnClickListener(new OnClickListener(){
        	 
            public void onClick(View v) {
                android.content.SharedPreferences app_preferences =
                        PreferenceManager.getDefaultSharedPreferences(SharedPreferences.this);
                android.content.SharedPreferences.Editor editor = app_preferences.edit();
                String text = textbox.getText().toString();
                editor.putString("key", text);
                editor.commit();
                Intent myIntent = new Intent(SharedPreferences.this,SecondActivity.class);
                startActivity(myIntent);
            }
 
        });
 
		
	}
	
}
