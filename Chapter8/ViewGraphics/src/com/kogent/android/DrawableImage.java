package com.kogent.android;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;


public class DrawableImage extends Activity
{
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	  super.onCreate(savedInstanceState);
	    	  LinearLayout sampleLayout = new LinearLayout(this);
	    	  ImageView imgView = new ImageView(this);
	    	  imgView.setImageResource(R.drawable.sample1);
	    	  imgView.setAdjustViewBounds(true); 
	    	  imgView.setLayoutParams(new 	Gallery.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
	    	  sampleLayout.addView(imgView);  
	    	  setContentView(sampleLayout);  
	    	      	  
	    }
}

