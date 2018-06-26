package com.kogent.android.asynctaskexample;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText username;
	  TextView content;
	  String ServeResponse = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		username= (EditText)findViewById(R.id.name);;
		  Button savetext=(Button)findViewById(R.id.save);
		  content   =  (TextView)findViewById(R.id.content);
		  savetext.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
	             // WebServer Request URL
	             String post ="http://techoreo.com/post.php";
	             // Use AsyncTask execute Method To Prevent ANR Problem
	             new backgroundtask().execute(post);
	         }
	     });   
	 }
		
private class backgroundtask  extends AsyncTask<String, Void, Void> {
	protected void onPreExecute() {
		// Things to be done before execution of running into background . 
	}
	
	@Override
	protected Void doInBackground(String... params) {
		// TODO Auto-generated method stub
		String name = username.getText().toString();
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(params[0]);
		List<NameValuePair> pairs = new ArrayList<NameValuePair>(1);
		pairs.add(new BasicNameValuePair("name", name));
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
		} catch (UnsupportedEncodingException e) {
			// writing error to Log
			e.printStackTrace();
		}

		// Making HTTP Request
		try {
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			ServeResponse = client.execute(post, responseHandler);
			Log.e("Test::::::::", ServeResponse);
			// writing response to log
		} catch (ClientProtocolException e) {
			// writing exception to log
			e.printStackTrace();
		} catch (IOException e) {
			// writing exception to log
			e.printStackTrace();
	}
		return null;
	}
	
	protected void onPostExecute(Void unused) {
		content.setText(ServeResponse);
	}
}}