package com.kogent.android.bluetoothserver;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.kogent.android.bluetoothserver.R;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	String dataReceived = null;
	BluetoothAdapter bluetoothAdapter = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void Connect(View view) {
		bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		Thread thread = new Thread() {
			@Override
			public void run() {
				BluetoothServerSocket bluetoothServerSocket;
				BluetoothSocket socket = null;
				try {
					bluetoothServerSocket = bluetoothAdapter
							.listenUsingRfcommWithServiceRecord(
									"helloService",
								UUID.fromString("00001101-0000-1000-8000-0080PRADEEPB"));

				socket = bluetoothServerSocket.accept(); // block for connect
				dataReceived = "Accept connection";

				DataInputStream inputStream = new DataInputStream( 
						socket.getInputStream());
				DataOutputStream outputStream = new DataOutputStream(
						socket.getOutputStream());

				dataReceived = inputStream.readUTF(); // Read from client
				outputStream.writeUTF("Echo " + dataReceived); // Send
																		// to
																		// client
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						TextView chat = (TextView) findViewById(R.id.Chat);
						Toast.makeText(getApplicationContext(),
								" Chat Received from Client ",
								Toast.LENGTH_LONG).show();
						chat.append("\n Chat Received from Client:   " + dataReceived+"\n");
					}
				});

				bluetoothServerSocket.close();
				socket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	// Don't forget to start the thread.
		thread.start();

	}
}