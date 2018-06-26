package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {

	ImageView imageView;
    final static int EDIT_IMAGE=0,CHANGE_NAME=1, MOVE_IMAGE=2, SEND_IMAGE=3;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.sample1);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        registerForContextMenu(imageView);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo 	menuInfo) 
    {
    	super.onCreateContextMenu(menu, v, menuInfo);
    	menu.add(0, EDIT_IMAGE, 0, "Edit");
    	menu.add(0, CHANGE_NAME, 0, "Rename");
    	menu.add(0, MOVE_IMAGE, 0, "Move");
    	menu.add(0, SEND_IMAGE, 0, "Send");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) 
    {
    	switch(item.getItemId()) 
    	{
    	   case EDIT_IMAGE:     
    		   editimage();
    		   break;
    	   case CHANGE_NAME:    
    		   changename();
    		   break;
    	   case MOVE_IMAGE:    
   		   moveImage();
   		   break;
    	   case SEND_IMAGE:    
   		   sendImage();
   		   break;
	   	}
    	return true;
    }
	private void sendImage() {
		Toast.makeText(this, "You have clicked the Send option" , 
 			Toast.LENGTH_LONG).show();		
	}
	private void moveImage() {
		Toast.makeText(this, "You have clicked the Move option", 
 			Toast.LENGTH_LONG).show();		
	}
	private void changename() {
		Toast.makeText(this, "You have clicked the Rename option" , 
 			Toast.LENGTH_LONG).show();		
	}
	private void editimage() {
		Toast.makeText(this, "You have clicked the Edit option", 
 			Toast.LENGTH_LONG).show();
		
	}


}
