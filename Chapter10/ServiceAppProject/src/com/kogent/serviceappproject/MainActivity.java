package com.kogent.serviceappproject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
public class MainActivity extends Activity implements OnClickListener {
Intent myItent;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.start).setOnClickListener(this);
		findViewById(R.id.stop).setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			myItent = new Intent(this, ServiceDemo.class);
			startService(myItent);
			break;
		case R.id.stop:
			myItent = new Intent(this, ServiceDemo.class);
			stopService(myItent);
			break;
		}
	}
}
