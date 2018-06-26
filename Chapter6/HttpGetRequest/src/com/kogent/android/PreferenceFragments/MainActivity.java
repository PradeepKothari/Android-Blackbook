package com.kogent.android.PreferenceFragments;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.kogent.android.HttpGetRequest.R;;

public class MainActivity extends Activity {
	EditText username;
	  TextView content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		  username= (EditText)findViewById(R.id.name);;
		  Button savetext=(Button)findViewById(R.id.save);
		  content   =  (TextView)findViewById(R.id.content);
		  savetext.setOnClickListener(new Button.OnClickListener(){
			  @Override
			  public void onClick(View v){
                try{
                       String name  = URLEncoder.encode(username.getText().toString(), "UTF-8");
                       HttpClient Client = new DefaultHttpClient();
                       String URL = "http://techoreo.com/get.php?name="+name;
                   try {
                                  String ServerData = "";
                                // Create Request to server and get response
                                 HttpGet httpget = new HttpGet(URL);
                                 ResponseHandler<String> responseHandler = new BasicResponseHandler();
                                 ServerData = Client.execute(httpget, responseHandler);
                                  // Show response on activity 
                                 content.setText(ServerData);
                     }
                   catch(Exception ex){
                             content.setText("Fail!"+ex.toString());
                       }
                }
              catch(UnsupportedEncodingException ex){
                       content.setText("Fail");
                }  
            }
        });  
	}
}