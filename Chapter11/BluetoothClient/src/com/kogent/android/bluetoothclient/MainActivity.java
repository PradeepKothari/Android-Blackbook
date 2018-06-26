package com.kogent.android.bluetoothclient;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.UUID;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String returnAcknowledgement = null;
	BluetoothAdapter mBluetoothAdapter = null;
	EditText textToSend;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void Connect(View view) {
		textToSend = (EditText) findViewById(R.id.Text);
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		Thread thread = new Thread() {
			@Override
			public void run() {
				BluetoothSocket bluetoothSocket = null;
				// Client knows the server MAC address F0:08:F1:4E:60:FC
				BluetoothDevice bluetoothDevice = mBluetoothAdapter.getRemoteDevice("F0:08:F1:4E:60:FC");
				try {
					// UUID string name used by server
			bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(UUID
									.fromString("00001101-0000-1000-8000-0080PRADEEPB"));
					// Cancel, discovery slows connection
					mBluetoothAdapter.cancelDiscovery(); 
					bluetoothSocket.connect();
					DataInputStream inputstream = new DataInputStream(
							bluetoothSocket.getInputStream());
					DataOutputStream outputstream = new DataOutputStream(
							bluetoothSocket.getOutputStream());
					//Send to server
					outputstream.writeUTF(textToSend.getText().toString()); 
					//Read from server
					returnAcknowledgement = inputstream.readUTF(); 
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Toast.makeText(getApplicationContext(),
									"Executed after 10 seconds ",
									Toast.LENGTH_LONG).show();
							TextView chat = (TextView) findViewById(R.id.ReceivedFromServer);
							chat.append("\n ECHO Received from Client:   "
									+ returnAcknowledgement + "\n");
						}
					});
				} catch (Exception e) {
					Log.e("DEBUG_TAG", "" + e.getStackTrace());
				}
			}
		};
		// Don't forget to start the thread.
		thread.start();
	}
}