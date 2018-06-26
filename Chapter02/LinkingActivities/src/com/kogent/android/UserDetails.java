package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class UserDetails extends Activity
{
	EditText uname;
	EditText uaddress;
	EditText uphone;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
		  setContentView(R.layout.userdetails);
	      uname= (EditText) findViewById(R.id.uname);
	      uname.setText("Charu");
	      uaddress= (EditText) findViewById(R.id.uaddress);
	      uaddress.setText("Delhi");
	      uphone= (EditText) findViewById(R.id.uphone);
	      uphone.setText("123456789");
	    } 
}
