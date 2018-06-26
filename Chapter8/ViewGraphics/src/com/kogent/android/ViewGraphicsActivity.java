package com.kogent.android;

import android.os.Bundle;
import android.app.Activity;

import android.view.Window;
import android.view.WindowManager;


public class ViewGraphicsActivity extends Activity {

	//CreateView createView;
		//CreateSurfaceView createView; 
	CustomShapeDrawable createView;
		/** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	  super.onCreate(savedInstanceState);
	    	  // Set full screen view  //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    	  //requestWindowFeature(Window.FEATURE_NO_TITLE);
	    	  //createView = new CreateView(this);
	    	 
	    	  //createView = new CreateSurfaceView(this);
	    	 // setContentView(createView);
	    	  //createView.requestFocus();
	    	  
	    	//  setContentView(R.layout.main);

	    	  
	    	  createView = new CustomShapeDrawable(this);
	    	  setContentView(createView);
	    	  createView.requestFocus();

    }

}
