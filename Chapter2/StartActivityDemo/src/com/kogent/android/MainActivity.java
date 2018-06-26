package com.kogent.android;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;


public class MainActivity extends Activity {

	/** Called when the activity is first created. */
	 static final int PICK_CONTACT_REQUEST = 0;
	@Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
  }
  public boolean onKeyDown(int keyCode, KeyEvent event) 
  {
  	if (keyCode == KeyEvent.KEYCODE_5) 
  	{             
  		// When the user center presses the 5 numeric key, he is allowed to pick a contact. 
  		startActivityForResult(new Intent(Intent.ACTION_PICK,
  				ContactsContract.Contacts.CONTENT_URI),
  				PICK_CONTACT_REQUEST);
  		return true;
  		}
  	return false; 
  	}
protected void onActivityResult(int requestCode, int resultCode,Intent data)
{
	if (requestCode == PICK_CONTACT_REQUEST) 
	{
		if (resultCode == RESULT_OK) 
		{
			// The picked contact would be displayed to the user. 
			Uri uri = data.getData();
           Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(intent);
			}
		}
}

}
