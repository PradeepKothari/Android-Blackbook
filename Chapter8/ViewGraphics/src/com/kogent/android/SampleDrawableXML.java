package com.kogent.android;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SampleDrawableXML extends Activity
{
	 public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout sampleLayout = new LinearLayout(this);
		TextView tred = new TextView(this);
		TextView tblue = new TextView(this);
		TextView tgreen = new TextView(this);
		tred.setText("This is red");
		tblue.setText("This is blue");
		tgreen.setText("This is green");
	tred.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 	LayoutParams.WRAP_CONTENT));
		tblue.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 	LayoutParams.WRAP_CONTENT));
		tgreen.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 	LayoutParams.WRAP_CONTENT));
		 
		ColorDrawable red = 	(ColorDrawable)getResources().getDrawable(R.drawable.red); 
		ColorDrawable green = 	(ColorDrawable)getResources().getDrawable(R.drawable.green);
		ColorDrawable blue = 	(ColorDrawable)getResources().getDrawable(R.drawable.blue);
		tred.setBackgroundDrawable(red);
		tblue.setBackgroundDrawable(blue);
		tgreen.setBackgroundDrawable(green);
		sampleLayout.addView(tred);
		sampleLayout.addView(tblue);
		sampleLayout.addView(tgreen);
		setContentView(sampleLayout);
	 }
}

