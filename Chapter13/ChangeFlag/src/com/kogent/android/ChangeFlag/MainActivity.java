package com.kogent.android.ChangeFlag;


import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private SensorManager sManager;
	private ShakeListen sListener;
	private int[] v = { R.drawable.afghanistan, R.drawable.albania,
			R.drawable.algeria, R.drawable.andorra, R.drawable.angola,
			R.drawable.antigua_and_barbuda, R.drawable.argentina,
			R.drawable.armenia, R.drawable.australia, R.drawable.austria };
	private String[] v2 = { "AFGHANISTAN", "ALBANIA", "ALGERIA", "ANDORRA",
			"ANGOLA", "ANTIGUA AND BARBUDA", "ARGENTINA", "ARMENIA",
			"AUSTRALIA", "AUSTRIA" };
	private ImageView imageView;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView) findViewById(R.id.image);
		textView = (TextView) findViewById(R.id.text);
		sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sListener = new ShakeListen();

		sListener.setOnShakeListener(new ShakeListen.CheckShake() {

			public void onShake() {
				try {
					Double random = Math.random();
					random = random * 10;
					Integer i = random.intValue();
					imageView.setBackgroundResource(v[i]);
					textView.setText(v2[i]);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		sManager.registerListener(sListener,
				sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_UI);
	}

	@Override
	protected void onPause() {
		sManager.unregisterListener(sListener);
		super.onPause();
	}

}
