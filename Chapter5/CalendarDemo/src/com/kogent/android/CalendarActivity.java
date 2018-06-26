package com.kogent.android;

import java.text.DateFormat;
import java.text.Format;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class CalendarActivity extends Activity implements OnClickListener {
	private Cursor myCursor = null;
	private static final String[] CALEVENTS = new String[] {
			CalendarContract.Events.TITLE, CalendarContract.Events.DTSTART };


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);myCursor = getContentResolver().query(CalendarContract.Events.CONTENT_URI, CALEVENTS, null, null,
				null);
		myCursor.moveToFirst();
		Button button = (Button) findViewById(R.id.forward);
		button.setOnClickListener(this);
		button = (Button) findViewById(R.id.back);
		button.setOnClickListener(this);
		onClick(findViewById(R.id.back));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
 	// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		TextView textView = (TextView) findViewById(R.id.stats);
		String title = "N/A";
		Long start = 0L;
		switch (v.getId()) {
		case R.id.forward:
			if (!myCursor.isLast())
				myCursor.moveToNext();
			break;
		case R.id.back:
			if (!myCursor.isFirst())
				myCursor.moveToPrevious();
			break;
		}
		Format dateFormat = DateFormat.getDateInstance();
		Format timeFormat = DateFormat.getTimeInstance();
		try {
			title = myCursor.getString(0);
			start = myCursor.getLong(1);
		} catch (Exception e) {
			// ignore
		}
 		textView.setText(title + " on " + dateFormat.format(start) + " at "
				+ timeFormat.format(start));

	}

}
