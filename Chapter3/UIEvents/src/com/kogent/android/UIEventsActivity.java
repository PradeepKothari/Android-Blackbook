package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class UIEventsActivity extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
 	{
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.main);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
    	switch(keyCode)
    	{
    	case KeyEvent.KEYCODE_1:
    	Toast.makeText(getBaseContext(), "The key 1 was clicked", 	Toast.LENGTH_LONG).show();
    	break;
    	case KeyEvent.KEYCODE_2:
        	Toast.makeText(getBaseContext(), "The key 2 was clicked", 
 			Toast.LENGTH_LONG).show();
        	break;
    	case KeyEvent.KEYCODE_3:
        	Toast.makeText(getBaseContext(), "The key 3 was clicked", 
 			Toast.LENGTH_LONG).show();
        	break;
    	case KeyEvent.KEYCODE_4:
        	Toast.makeText(getBaseContext(), "The key 4 was clicked", 
 			Toast.LENGTH_LONG).show();
        	break;
    	case KeyEvent.KEYCODE_5:
        	Toast.makeText(getBaseContext(), "The key 5 was clicked", 
 			Toast.LENGTH_LONG).show();
        	break;
    	}
    	return false;
    }
}
