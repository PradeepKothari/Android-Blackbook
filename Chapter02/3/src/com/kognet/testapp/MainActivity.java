package com.kognet.testapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText  Name  = (EditText) findViewById(R.id.TextBox);
		Button btnValidate = (Button)findViewById(R.id.Submit);
		btnValidate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(Name.getText().toString()));
				startActivity(viewIntent);  
				
			}
		});
		
	
	}

}
