package com.kogent.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	Button button_editcontact, button_showBrowser, button_dialNumber;
	  int request_Code=1;
	  String selectedImagePath; 
		/** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        Button button_editcontact = (Button) 
	 		findViewById(R.id.button_editContact);
	        button_editcontact.setOnClickListener(new OnClickListener(){
	        	public void onClick(View v)
	        	{
	        		Intent i = new Intent(android.content.Intent.ACTION_EDIT, 
	 			Uri.parse("content://contacts/people/1"));
	        		startActivity(i);
	        	}
	        });
	    Button button_showBrowser = (Button) findViewById(R.id.button_showBrowser);
	    button_showBrowser.setOnClickListener(new OnClickListener(){
	    	public void onClick(View v)
	    	{
	    		Intent i = new Intent(android.content.Intent.ACTION_VIEW, 
	 		Uri.parse("http://www.dreamtechpress.com"));
	    		startActivity(i);
	    	}
	    });
	    Button button_dialNumber = (Button) findViewById(R.id.button_dialNumber);
	    button_dialNumber.setOnClickListener(new OnClickListener(){
	    	public void onClick(View v)
	    	{
	    		Intent i = new Intent(android.content.Intent.ACTION_DIAL, 
	 		Uri.parse("tel:+12345678"));
	    		startActivity(i);
	    	}
	    });
	  
	   }


}
