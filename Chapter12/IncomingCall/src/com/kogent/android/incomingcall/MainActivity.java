package com.kogent.android.incomingcall;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
	  TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
	  TelephonyMgr.listen(new TeleListener(),
	    PhoneStateListener.LISTEN_CALL_STATE);
	 }
	 class TeleListener extends PhoneStateListener {
	  public void onCallStateChanged(int state, String incomingNumber) {
	   super.onCallStateChanged(state, incomingNumber);
	   switch (state) {
	   case TelephonyManager.CALL_STATE_IDLE:
	    // CALL_STATE_IDLE;
	    Toast.makeText(getApplicationContext(), "CALL_STATE_IDLE",
	      Toast.LENGTH_LONG).show();
	    break;
	   case TelephonyManager.CALL_STATE_OFFHOOK:
	    // CALL_STATE_OFFHOOK;
	    Toast.makeText(getApplicationContext(), "CALL_STATE_OFFHOOK",
	      Toast.LENGTH_LONG).show();
	    break;
	   case TelephonyManager.CALL_STATE_RINGING:
	    // CALL_STATE_RINGING
	    Toast.makeText(getApplicationContext(), incomingNumber,
	      Toast.LENGTH_LONG).show();
	    Toast.makeText(getApplicationContext(), "CALL_STATE_RINGING",
	      Toast.LENGTH_LONG).show();
	    break;
	   default:
	    break;
	   }
	  }

	 }
	}