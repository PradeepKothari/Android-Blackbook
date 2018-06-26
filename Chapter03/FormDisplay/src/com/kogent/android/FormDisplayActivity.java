package com.kogent.android;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FormDisplayActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		   RatingBar rating_bar = (RatingBar) findViewById(R.id.ratingbar);
	        rating_bar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
	        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
	        Toast.makeText(FormDisplayActivity.this, "User Rating is:" + rating, Toast.LENGTH_LONG).show();
	        }});
	    }
				
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.form_display, menu);
        return true;
    }
    
}
