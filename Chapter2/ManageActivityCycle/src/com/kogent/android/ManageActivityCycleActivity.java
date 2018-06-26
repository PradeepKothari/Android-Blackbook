package com.kogent.android;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
public class ManageActivityCycleActivity extends Activity 
{
    String message="Event being invoked";
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(message, "onCreate() Method");
    }
    public void onStart()
    {
    	super.onStart();
    	Log.d(message, "onStart() Method");
    }
    public void onRestart()
    {
    	super.onRestart();
    	Log.d(message, "onRestart() Method");
    }
    public void onResume()
    {
    	super.onResume();
    	Log.d(message, "onResume() Method");
    }
    public void onPause()
    {
    	super.onPause();
    	Log.d(message, "onPause() Method");
    }
    public void onStop()
    {
    	super.onStop();
    	Log.d(message, "onStop() Method");
    }
    public void onDestroy()
    {
    	super.onDestroy();
    	Log.d(message, "onDestroy() Method");
    }
}
