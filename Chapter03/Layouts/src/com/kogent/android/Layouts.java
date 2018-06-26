package com.kogent.android;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class Layouts extends Activity implements OnClickListener {
	Button button_linearlayout, button_relativelayout, button_scrollview,
			button_tablelayout, button_framelayout;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Initializing the buttons declared as view components
		button_linearlayout = (Button) findViewById(R.id.linearlayout);
		button_relativelayout = (Button) findViewById(R.id.relativelayout);
		button_scrollview = (Button) findViewById(R.id.scrollingview);
		button_tablelayout = (Button) findViewById(R.id.tablelayout);
		button_framelayout = (Button) findViewById(R.id.framelayout);

		// Setting the click event for layout button
		button_linearlayout.setOnClickListener(this);
		button_relativelayout.setOnClickListener(this);
		button_scrollview.setOnClickListener(this);
		button_tablelayout.setOnClickListener(this);
		button_framelayout.setOnClickListener(this);
	}

	// Verifying which button has been clicked and accordingly the Activity is
	// being started
	public void onClick(View view) {
		if (view == findViewById(R.id.linearlayout)) {
			Intent i = new Intent(this, SampleLinearLayout.class);
			startActivity(i);
		}
		if (view == findViewById(R.id.relativelayout)) {
			Intent i = new Intent(this, SampleRelativeLayout.class);
			startActivity(i);
		}
		if (view == findViewById(R.id.scrollingview)) {
			Intent i = new Intent(this, SampleScrollingLayout.class);
			startActivity(i);
		}
		if (view == findViewById(R.id.tablelayout)) {
			Intent i = new Intent(this, SampleTableLayout.class);
			startActivity(i);
		}
		if (view == findViewById(R.id.framelayout)) {
			Intent i = new Intent(this, SampleFrameLayout.class);
			startActivity(i);
		}
	}
}
