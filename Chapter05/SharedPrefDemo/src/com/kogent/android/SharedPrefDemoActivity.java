package com.kogent.android;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;


public class SharedPrefDemoActivity extends Activity {
	public static final String User_Credentials = "User_Credentials";
	  public static final String User_name = "User_name";
	  public static final String User_pasword = "user_password";
	  
	  private EditText u_name;
	  private EditText u_pass;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		u_name = (EditText) findViewById(R.id.uname);
        u_pass = (EditText) findViewById(R.id.upass);
       SharedPreferences settings = getSharedPreferences(User_Credentials, 0);
    String name = settings.getString(User_name, "");
    String password = settings.getString(User_pasword, "");
    u_name.setText(name);
    u_pass.setText(password);

	}

	protected void onStop(){
        super.onStop();
    SharedPreferences settings = getSharedPreferences(User_Credentials, 0);
    settings.edit()
      .putString(User_name, u_name.getText().toString())
      .putString(User_pasword, u_pass.getText().toString())
      .commit();
    }


}
