package com.kogent.android.ServerSideSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.widget.TextView;
import com.kogent.android.ServerSideSocket.R;

public class MainActivity extends Activity {
	private ServerSocket serverSocket;
	Handler updateConversationHandler;
	Thread serverThread = null;
	private TextView ServerData;

	public static final int SERVERPORT = 6000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ServerData = (TextView) findViewById(R.id.text2);
		updateConversationHandler = new Handler();
		this.serverThread = new Thread(new ServerThread());
		this.serverThread.start();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class ServerThread implements Runnable {
		public void run() {
			Socket socket = null;
			try {
				serverSocket = new ServerSocket(SERVERPORT);
			} catch (IOException e) {
				e.printStackTrace();
			}
			while (!Thread.currentThread().isInterrupted()) {
				try {
					socket = serverSocket.accept();
					BufferedReaderThread commThread = new BufferedReaderThread(socket);
					new Thread(commThread).start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class BufferedReaderThread implements Runnable {
		private Socket clientSocket;
		private BufferedReader input;
		public BufferedReaderThread(Socket clientSocket) {
			this.clientSocket = clientSocket;
			try {
				this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					String read = input.readLine();
					if(read !=null) {
					updateConversationHandler.post(new updateUIThread(read));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class updateUIThread implements Runnable {
		private String msg;
		public updateUIThread(String str) {
			this.msg = str;
		}

		@Override
		public void run() {
			ServerData.setText(ServerData.getText().toString()+"Client Says: "+ msg + "\n");
		}
	}
}