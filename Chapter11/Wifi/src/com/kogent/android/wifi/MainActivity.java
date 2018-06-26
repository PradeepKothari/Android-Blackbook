package com.kogent.android.wifi;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	   WifiManager wifimanager;
	   WifiScanReceiver wifiscanReciever;
	   String wifilist[];
	   ListView listView;
	  
	   public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_main);
	      listView = (ListView)findViewById(R.id.listView1);
	      wifiscanReciever = new WifiScanReceiver();
	   }
	   
	   protected void onPause() {
	      unregisterReceiver(wifiscanReciever);
	      super.onPause();
	   }

	   protected void onResume() {
	      registerReceiver(wifiscanReciever, new IntentFilter(
	      WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
	      super.onResume();
	   }

	   public void enable(View view) {
		   wifimanager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		   wifimanager.setWifiEnabled(true);
		   Toast.makeText(getApplicationContext(), "Enabling Wifi", Toast.LENGTH_LONG).show();
		}	   
	   
	   public void disable(View view) {
		   wifimanager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		   wifimanager.setWifiEnabled(false);
		   Toast.makeText(getApplicationContext(), "Disabling Wifi", Toast.LENGTH_LONG).show();
		}	   
	   
	   
public void getlist(View view) {
	wifimanager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	wifimanager.startScan();
	Toast.makeText(getApplicationContext(), "Scanning  Wifi please wait ...", Toast.LENGTH_LONG).show();
}
	   class WifiScanReceiver extends BroadcastReceiver {
	      public void onReceive(Context c, Intent intent) {
	         List<ScanResult> wifiList = wifimanager.getScanResults();
	         wifilist = new String[wifiList.size()];
	         for(int i = 0; i < wifiList.size(); i++){
	        	 wifilist[i] = ((wifiList.get(i)).toString()+"\n");
	         }
	         listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
	         android.R.layout.simple_list_item_1,wifilist));
	      }
	   }
	}