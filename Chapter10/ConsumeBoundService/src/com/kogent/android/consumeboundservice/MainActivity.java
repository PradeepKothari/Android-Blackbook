package com.kogent.android.consumeboundservice;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kogent.android.boundservice.ISum;

public class MainActivity extends Activity implements OnClickListener {
	EditText mFirst,mSecond;
	Button mAdd;
	TextView mResult;
	private ISum mService;
	/** Called when the activity is first created. */
	
	private ServiceConnection mServiceConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			mService = null;
			Log.d("IRemote", "Service disconnected");
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service)
		{
			// TODO Auto-generated method stub
			mService = ISum.Stub.asInterface((IBinder) service);
			Log.d("IRemote", "Service connected");
		}

		
	};
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mFirst = (EditText) findViewById(R.id.firstValue);
		mSecond = (EditText) findViewById(R.id.secondValue);
		mResult = (TextView) findViewById(R.id.resultText);

		mAdd = (Button) findViewById(R.id.add);
		mAdd.setOnClickListener(this);
	
		//Starting the service 
		if(mService == null)
		{
			Intent it = new Intent();
			it.setAction("com.kogent.android.boundservice.ISum");
			//binding to remote service
			bindService(it, mServiceConnection, Service.BIND_AUTO_CREATE);
		}
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.add:
		{
			long a = Long.parseLong(mFirst.getText().toString());
		long b = Long.parseLong(mSecond.getText().toString());

		try {
			mResult.setText("Result For addition    "+mService.add(a,b));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		break;
		
	}}
}