package com.kogent.android.ChangeFlag;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class ShakeListen implements SensorEventListener {

	private static final int min_value = 10;
	private static final int directions = 3;

	private static final int pause = 200;

	private static final int duration = 400;

	private long firstTime = 0;

	private long lastTime;

	private int directionCount = 0;

	private float xAxis = 0;

	private float yAxis = 0;

	private float zAxis = 0;

	private CheckShake shakeLister;

	public interface CheckShake {

		void onShake();
	}

	public void setOnShakeListener(CheckShake listener) {
		shakeLister = listener;
	}

	@Override
	public void onSensorChanged(SensorEvent sensor) {
		float x = sensor.values[SensorManager.DATA_X];
		float y = sensor.values[SensorManager.DATA_Y];
		float z = sensor.values[SensorManager.DATA_Z];

		float finalMove = Math.abs(x + y + z - xAxis - yAxis - zAxis);

		if (finalMove > min_value) {

			long currne = System.currentTimeMillis();

			if (firstTime == 0) {
				firstTime = currne;
				lastTime = currne;
			}

			long lastVal = currne - lastTime;
			if (lastVal < pause) {

				lastTime = currne;
				directionCount++;

				xAxis = x;
				yAxis = y;
				zAxis = z;

				if (directionCount >= directions) {

					long totalDur = currne - firstTime;
					if (totalDur < duration) {
						shakeLister.onShake();
						resetValues();
					}
				}

			} else {
				resetValues();
			}
		}
	}

	private void resetValues() {
		firstTime = 0;
		directionCount = 0;
		lastTime = 0;
		xAxis = 0;
		yAxis = 0;
		zAxis = 0;
	}

	@Override
	public void onAccuracyChanged(Sensor s, int acc) {
		
	}

}