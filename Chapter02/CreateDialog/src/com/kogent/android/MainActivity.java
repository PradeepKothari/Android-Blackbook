package com.kogent.android;

import java.util.Calendar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends Activity implements OnClickListener
{

	int mHour;
	int mMinute;
	     int mYear;
	     int mMonth;
	     int mDay;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);   
	    Button alertbtn = (Button) findViewById(R.id.alertbtn);
	    alertbtn.setOnClickListener(this);    
	    Button progressbtn = (Button) findViewById(R.id.progressbtn);
	    progressbtn.setOnClickListener(this);
	    Button custombtn = (Button) findViewById(R.id.custombtn);
	    custombtn.setOnClickListener(this);
	    Button datepickerbtn = (Button) findViewById(R.id.datepickerbtn);
	    datepickerbtn.setOnClickListener(this);    
	    Button timepickerbtn = (Button) findViewById(R.id.timepickerbtn);
	    timepickerbtn.setOnClickListener(this);
	}
	public void onClick(View v)
	{
		if(v== findViewById(R.id.alertbtn))
		{
			//Get the Builder to create the AlertDialog
			AlertDialog.Builder demoBuilder = new AlertDialog.Builder(this);
			//Set the properties of the AlertDialog 
		    demoBuilder.setMessage("Do you want to exit from the application?");
		    demoBuilder.setCancelable(false);
		    demoBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() 
		    {
			public void onClick(DialogInterface dialog, int id) 
			{
				MainActivity.this.finish();
				}
			});
		    demoBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() 
			{
			public void onClick(DialogInterface dialog, int id) 
			{
				dialog.cancel();    
			}
			});
		    //Create the AlertDialog
		    AlertDialog alert = demoBuilder.create();
		    //Display the AlertDialog
		    alert.show();
		}
		if(v== findViewById(R.id.progressbtn))
		{
			final ProgressDialog progressDialog;
			progressDialog = new ProgressDialog(MainActivity.this);
			progressDialog.setProgressStyle(ProgressDialog.THEME_TRADITIONAL);
			progressDialog.setMessage("Loading...");
			progressDialog.setCancelable(false);
			progressDialog.incrementProgressBy(50);
			progressDialog.setButton("Stop Progress", new DialogInterface.OnClickListener() 
			{
			public void onClick(DialogInterface dialog, int id) 
			{
				progressDialog.dismiss();  
			}
			});
			progressDialog.show();
			}
		if(v== findViewById(R.id.custombtn))
		{
			Dialog dialog = new Dialog(MainActivity.this);
			dialog.setContentView(R.layout.custom_dialog);
			dialog.setTitle("Custom Dialog");
			TextView text = (TextView) dialog.findViewById(R.id.text);
			text.setText("Here is your custom dialog");
			ImageView image = (ImageView) dialog.findViewById(R.id.image);
			image.setImageResource(R.drawable.ic_launcher);
			dialog.show();
		}
		if(v== findViewById(R.id.datepickerbtn))
		{
			final TextView mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
			final DatePickerDialog dateDialog;
			final Calendar c = Calendar.getInstance();
			mYear = c.get(Calendar.YEAR);
			mMonth = c.get(Calendar.MONTH);
			mDay = c.get(Calendar.DAY_OF_MONTH);
			DatePickerDialog.OnDateSetListener mDateSetListener =  new 
	 		DatePickerDialog.OnDateSetListener() {
			public void onDateSet(DatePicker view, int year, int monthOfYear, int 
	 		dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			mDateDisplay.setText(new StringBuilder().append(mMonth + 1).append("-").append(mDay).append("-").append(mYear).append(" "));
	        }};
	        dateDialog = new 
	 DatePickerDialog(MainActivity.this,mDateSetListener, mYear, mMonth, mDay);
	        dateDialog.show();
		}
		if(v== findViewById(R.id.timepickerbtn))
		{
			final TextView mTimeDisplay = (TextView) findViewById(R.id.timeDisplay);
			final TimePickerDialog timeDialog;
			final Calendar c = Calendar.getInstance();
			mHour = c.get(Calendar.HOUR_OF_DAY);
			mMinute = c.get(Calendar.MINUTE);	
			TimePickerDialog.OnTimeSetListener mTimeSetListener =  new 
	 		TimePickerDialog.OnTimeSetListener() {
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			mHour = hourOfDay;
			mMinute = minute;
			mTimeDisplay.setText(new 
	 		StringBuilder().append(mHour).append(":").append(mMinute));
	        }};
	        timeDialog = new 
	 	TimePickerDialog(MainActivity.this,mTimeSetListener, mHour, mMinute, 
		false);
	        timeDialog.show();
	     }
		}

}
