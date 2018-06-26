package com.kogent.android.phoneinformation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import android.os.Bundle;  
import android.app.Activity;  
import android.content.Context;  
import android.telephony.TelephonyManager;  
import android.view.Menu;  
import android.widget.TextView;  
  
public class MainActivity extends Activity {  
	   TextView textView;  
	   String sPhoneTrasmitionType;
	    @Override  
	    protected void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.activity_main);  
	          
	        textView=(TextView)findViewById(R.id.textView);  
	          
	        TelephonyManager  telephonymanager=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);  
 
	        textView.append("\n DeviceId= "+telephonymanager.getDeviceId());  
	        textView.append("\n NetworkRoaming= "+telephonymanager.isNetworkRoaming()); 
	        textView.append("\n SimSerialNumber= "+telephonymanager.getSimSerialNumber());
	        textView.append("\n NetworkCountryIs= "+telephonymanager.getNetworkCountryIso());
	        textView.append("\n SimCountryIso= "+telephonymanager.getSimCountryIso());
	        textView.append("\n DeviceSoftwareVersion= "+telephonymanager.getDeviceSoftwareVersion());
	        textView.append("\n CellLocation= "+telephonymanager.getCellLocation());
	        int iPhoneTrasmitionType=telephonymanager.getPhoneType(); 
	        
			switch (iPhoneTrasmitionType)   
	        {  
	                case (TelephonyManager.PHONE_TYPE_CDMA):  
	                	sPhoneTrasmitionType="CDMA";  
	                               break;  
	                case (TelephonyManager.PHONE_TYPE_GSM):   
	                	sPhoneTrasmitionType="GSM";                
	                               break;  
	                case (TelephonyManager.PHONE_TYPE_NONE):  
	                	sPhoneTrasmitionType="NONE";                
	                                break;  
	         }  

			 textView.append("\n PhoneTrasmitionType= "+sPhoneTrasmitionType);
	   
	    }  
  
	     
	}  
