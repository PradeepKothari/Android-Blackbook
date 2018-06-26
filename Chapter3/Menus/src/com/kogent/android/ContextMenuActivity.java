package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;


public class ContextMenuActivity extends Activity
{
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) 
	 	{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        Button button1 = (Button) findViewById(R.id.button1);
	        button1.setOnCreateContextMenuListener(this);
	       }

	    @Override
	    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo 	menuInfo) 
	    {
	    	super.onCreateContextMenu(menu, v, menuInfo);
	    	MenuInflater inflater = getMenuInflater();
	    	inflater.inflate(R.menu.options_menu, menu);
	    	}

	    @Override
	    public boolean onContextItemSelected(MenuItem item) 
	    {
	    	AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	    	switch (item.getItemId()) {
	    	   case R.id.new_mail:     
	    		   Toast.makeText(this, "A new mail is composed!" + info.id, 
	 			Toast.LENGTH_LONG).show();
	           break;

	    	   case R.id.reply:    
	    		   	Toast.makeText(this, "Reply to the mail sender!"  + info.id, 
	 			Toast.LENGTH_LONG).show();
	           break;

	    	   case R.id.forward: 
	    		   	Toast.makeText(this, "Forward your mail!"  + info.id, 
	 			Toast.LENGTH_LONG).show();
	           break;

	    	}
	    	return true;
	    	}
	


}
