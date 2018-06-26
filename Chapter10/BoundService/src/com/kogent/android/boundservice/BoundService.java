package com.kogent.android.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class BoundService extends Service{
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}
	@Override
	public void onCreate() {
		super.onCreate();
	}	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}		
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		return Service.BIND_AUTO_CREATE;
	}		
	private final ISum.Stub mBinder = new ISum.Stub() {
		@Override
		public long add(long a, long b) throws RemoteException {
			// TODO Auto-generated method stub
			return (a + b);
		}
	};
}