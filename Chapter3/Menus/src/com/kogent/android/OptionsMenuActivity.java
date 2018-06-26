package com.kogent.android;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class OptionsMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
        
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_mail:Toast.makeText(this, "A new mail is composed!",Toast.LENGTH_LONG).show();
                                break;
            case R.id.reply:Toast.makeText(this, "Reply to the mail sender!",Toast.LENGTH_LONG).show();
                                break;
            case R.id.forward:Toast.makeText(this, "Forward your mail!",Toast.LENGTH_LONG).show();
                                break;
        }
        return true;
    }


}
