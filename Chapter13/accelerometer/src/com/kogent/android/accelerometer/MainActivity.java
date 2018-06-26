package com.kogent.android.accelerometer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {
	private SensorManager sensorManager;
    private Sensor accelerometer, gyroscope;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer , SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// can be safely ignored for this demo
		Log.d("tag","onAccuracyChanged: " + sensor.getName() + ", accuracy: " + accuracy);
	}

	@Override
	public void onSensorChanged(SensorEvent sensorevent) {
		TextView Xaxis= (TextView)findViewById(R.id.xaxis);
		TextView Yaxis= (TextView)findViewById(R.id.yaxis);
		TextView Zaxis= (TextView)findViewById(R.id.zaxis);
		
		float x = sensorevent.values[0];
		float y = sensorevent.values[1];
		float z = sensorevent.values[2];
	
		// display values using TextView
		Xaxis.setText("X_axis   " +Float.toString(x));
		Yaxis.setText("Y_axis   " +Float.toString(y));
		Zaxis.setText("Z a_xis  " +Float.toString(z));
	}
}