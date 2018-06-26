package com.kogent.android.ConsumingJsonWebService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.kogent.android.ConsumingJsonWebService.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 final Button GetData = (Button) findViewById(R.id.save);

	GetData.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View arg0) {
             // WebServer Request URL
             String serverURL ="http://techoreo.com/restful.php";
             // Use AsyncTask execute Method To Prevent ANR Problem
             new backgroundtask().execute(serverURL);
         }
    });   
 }
	
	private class backgroundtask  extends AsyncTask<String, Void, Void> {
        private String Content;
        private String Error = null;
        TextView jsonParsed = (TextView) findViewById(R.id.content);
        TextView actualjson = (TextView) findViewById(R.id.actualparsedcontent);
        protected void onPreExecute() {
        }

		protected Void doInBackground(String... urls) {
            BufferedReader reader=null;
                try {
                   // Defined URL  where to send data
                   URL url = new URL(urls[0]);
                  URLConnection conn = url.openConnection();
                  conn.setDoOutput(true);
                  reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                  StringBuilder sb = new StringBuilder();
                  String line = null;
                    // Read Server Response
                    while((line = reader.readLine()) != null) {
                               // Append server response in string
                               sb.append(line + "");
                        }
                    // Append Server Response To Content String
                   Content = sb.toString();
                }
                catch(Exception ex) {
                    Error = ex.getMessage();
                }
                finally {
                    try {
                        reader.close();
                    }
                    catch(Exception ex) {}
                }
            return null;
        }

		protected void onPostExecute(Void unused) {
           if (Error != null) {
            	jsonParsed.setText("Output : "+Error);
            } else {
            	actualjson.setText( Content );
                String OutputData = "";
                JSONObject jsonResponse;
                try {
                     jsonResponse = new JSONObject(Content);
                     JSONArray jsonMainNode = jsonResponse.optJSONArray("Android");
                     int lengthJsonArr = jsonMainNode.length(); 
                     for(int i=0; i <lengthJsonArr; i++){
                         JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                         String name       = jsonChildNode.optString("name").toString();
                         String classname     = jsonChildNode.optString("class").toString();
                         OutputData += " Name           : "+ name +"\n"
                                 + "class           : "+ classname +"\n"
                                 +"....................................    \n ";
                    }
                     jsonParsed.setText( OutputData );
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }
             }
        }
    }
}