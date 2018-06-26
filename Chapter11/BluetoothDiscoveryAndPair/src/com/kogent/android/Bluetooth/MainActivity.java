package com.kogent.android.Bluetooth;

import java.util.Set;

import com.kogent.android.Bluetooth.R;

import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final int REQUEST_ENABLE_BT = 0;
	private static final int REQUEST_DISCOVERABLE_BT = 0;
	TextView textview1;
	BluetoothAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textview1 = (TextView) findViewById(R.id.textView1);
		mAdapter = BluetoothAdapter.getDefaultAdapter();
		if (mAdapter == null) {
			textview1.append("Device not supported \n");
		} else if (mAdapter.isEnabled()) {
			String Deviceaddress = mAdapter.getAddress();
			String Devicename = mAdapter.getName();
textview1.append("\n This Device Name : " + Devicename + "\n Address " + Deviceaddress + "\n");
		}
		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		this.registerReceiver(mBroadcastReceiver, filter);
	}

	public void turnOn(View view) {
		if (!mAdapter.isEnabled()) {
			Intent enableBluetooth = new Intent(
			BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBluetooth, REQUEST_ENABLE_BT);
		}
	}

	public void discoverable(View view) {
		if (!mAdapter.isDiscovering()) {
			Toast.makeText(getApplicationContext(), "Making your device discoverable", Toast.LENGTH_LONG);
			Intent enableBluetooth = new Intent(
			BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
			startActivityForResult(enableBluetooth, REQUEST_DISCOVERABLE_BT);
		}
	}

	public void TurnOf(View view) {
		mAdapter.disable();
		Toast.makeText(getApplicationContext(), "Turning Bluetooth Off", Toast.LENGTH_LONG);
	}

	public void paired(View view) {
		textview1.append("\nPaired Devices are: \n");
		GetBondedDevices();
	}

	public void newdevice(View view) {
		textview1.append("\n New Devices are: \n");
		mAdapter.startDiscovery();
}

	private void GetBondedDevices() {
		if (mAdapter == null) {
			textview1.append("\n Bluetooth NOT supported. Aborting.");
			return;
		} else {
			if (mAdapter.isEnabled()) {
				Set<BluetoothDevice> devices = mAdapter.getBondedDevices();
				for (BluetoothDevice device : devices) {
					textview1.append("\n  Found device:: " + device.getName()
							+ "Add: " + device.getAddress()+"\n");
				}
			} else {
				Intent enableBluetooth = new Intent(
				BluetoothAdapter.ACTION_REQUEST_ENABLE);
				startActivityForResult(enableBluetooth, REQUEST_ENABLE_BT);
			}
		}
	}
	
private final BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				BluetoothDevice bluetoothdevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				 if (bluetoothdevice.getBondState() != BluetoothDevice.BOND_BONDED) {
				textview1.append("\n Device Name :  " + bluetoothdevice.getName() + "\n"
						+ "Device Address " + bluetoothdevice.getAddress()+"\n");
				 }
			}
		}
	};

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// Unregister broadcast listeners
		this.unregisterReceiver(mBroadcastReceiver);
	}
}