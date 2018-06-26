package com.kogent.android.SendSmsIntent;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.kogent.android.SendSmsIntent.R;

public class MainActivity extends Activity {

	   Button sendBtn;
	   EditText txtphoneNo;
	   EditText txtMessage;

	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_main);

	      sendBtn = (Button) findViewById(R.id.btnSendSMS);
	      txtphoneNo = (EditText) findViewById(R.id.editTextPhoneNo);
	      txtMessage = (EditText) findViewById(R.id.editTextSMS);

	      sendBtn.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View view) {
	            sendSMSMessage();
	         }
	      });

	   }
	   protected void sendSMSMessage() {
	      
		   Intent smsVIntent = new Intent(Intent.ACTION_VIEW);
			// prompts only sms-mms clients
			smsVIntent.setType("vnd.android-dir/mms-sms");
			
			// extra fields for number and message respectively
			smsVIntent.putExtra("address", txtphoneNo.getText().toString());
			smsVIntent.putExtra("sms_body", txtMessage.getText().toString());
			try{
				startActivity(smsVIntent);
			} catch (Exception ex) {
				Toast.makeText(MainActivity.this, "Your sms has failed...",
						Toast.LENGTH_LONG).show();
				ex.printStackTrace();
			}
	   }
	  
	}