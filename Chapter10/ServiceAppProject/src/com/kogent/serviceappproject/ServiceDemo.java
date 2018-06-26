package com.kogent.serviceappproject;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceDemo extends Service {
	// This method can be invoked only once no other instance is created
	// After invoking this method, the service continues
	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "Service has been created", Toast.LENGTH_LONG).show();
	}
	// This method starts functioning after the onCreate method.
	// This method can be invoked multiple times to starts the service
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "Task is in progress", Toast.LENGTH_LONG).show();
		return super.onStartCommand(intent, flags, startId);
	}
	// Service is not binded with other component, so null is being returned
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	// To kill the service
	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "Service has been destroyed", Toast.LENGTH_LONG).show();
	}
}
