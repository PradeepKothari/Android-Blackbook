package com.kogent.android;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SampleRelativeLayout extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relative_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sample_relative_layout, menu);
		return true;
	}

}
