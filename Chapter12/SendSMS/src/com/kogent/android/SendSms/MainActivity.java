package com.kogent.android.SendSms;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.kogent.android.SendSms.R;

public class MainActivity extends Activity {

	   Button sendButton;
	   EditText ReciverPhoneNumber;
	   EditText textMessage;

	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_main);
	      
	      ReciverPhoneNumber = (EditText) findViewById(R.id.PhoneNo);
	      textMessage = (EditText) findViewById(R.id.SMS);
	      sendButton = (Button) findViewById(R.id.SendSMS);
	      

	      sendButton.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View view) {
	            sendMessage();
	         }
	      });

	   }
	   protected void sendMessage() {
	      Log.i("Send SMS", "");

	      String phoneNuber = ReciverPhoneNumber.getText().toString();
	      String ReceipentMessage = textMessage.getText().toString();

	      try {
	         SmsManager smsOperation = SmsManager.getDefault();
	         smsOperation.sendTextMessage(phoneNuber, null, ReceipentMessage, null, null);
	     //    smsManager.sendDataMessage(destinationAddress, scAddress, destinationPort, data, sentIntent, deliveryIntent)
	         Toast.makeText(getApplicationContext(), "SMS Sent Sucessfully ",Toast.LENGTH_LONG).show();
	      } catch (Exception e) {
	    	  e.printStackTrace();
	         Toast.makeText(getApplicationContext(),"Message Not Devivered .",Toast.LENGTH_LONG).show();
	         
	      }
	   }
	 
	}