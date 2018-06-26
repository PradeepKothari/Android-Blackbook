package com.kognet.testapp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Activity2 extends Activity {
	
	protected void onCreate(Bundle savedInstanceState)
    {
          // TODO Auto-generated method stub
          super.onCreate(savedInstanceState);
          final TextView message = new TextView(this);
          message.setText("Welcome ,"+getIntent().getExtras().getString("Name"));
          setContentView(message);
    }
	
}
