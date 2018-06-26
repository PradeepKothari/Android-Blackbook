package com.kogent.android.nfc;

import java.nio.charset.Charset;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.CreateNdefMessageCallback;
import android.nfc.NfcAdapter.OnNdefPushCompleteCallback;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.provider.Settings;
import android.app.Activity;
import android.content.Intent;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements
		CreateNdefMessageCallback, OnNdefPushCompleteCallback {
	NfcAdapter adapter;
	TextView textView;
	private static final int MESSAGE_INFORMATION = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView1);
		adapter = NfcAdapter.getDefaultAdapter(this);
		if (adapter == null) {
			textView = (TextView) findViewById(R.id.textView1);
			textView.setText("NFC Device Not available ");
		}
		adapter.setNdefPushMessageCallback(this, this);
		adapter.setOnNdefPushCompleteCallback(this, this);
	}

	@Override
	public void onNdefPushComplete(NfcEvent event) {
		handler.obtainMessage(MESSAGE_INFORMATION).sendToTarget();
	}

	@Override
	public NdefMessage createNdefMessage(NfcEvent event) {
		String sendToDevice = ("This is a sample text send from device 1");
		NdefMessage msg = new NdefMessage(new NdefRecord[] { ndefRecord(
				"application/com.kogent.android.nfc", sendToDevice.getBytes()) });
		return msg;
	}

	private final Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MESSAGE_INFORMATION:
				Toast.makeText(getApplicationContext(), "Message sent!",Toast.LENGTH_LONG).show();
				break;
			}
		}
	};

	@Override
	public void onResume() {
		super.onResume();
		// Check to see that the Activity started due to an Android Beam
		if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
			processIntent(getIntent());
		}
	}

	@Override
	public void onNewIntent(Intent intent) {
		setIntent(intent);
	}

	void processIntent(Intent intent) {
		Parcelable[] message = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
		// only one message sent during the beam
		NdefMessage ndefMessage = (NdefMessage) message[0];
		// record 0 contains the MIME type, record 1 is the AAR, if present
		textView.setText(new String("Text Received from device 1: "+ndefMessage.getRecords()[0].getPayload()));
	}

	public NdefRecord ndefRecord(String mimeType, byte[] payload) {
		byte[] mimeBytes = mimeType.getBytes(Charset.forName("US-ASCII"));
		NdefRecord ndefRecord = new NdefRecord(NdefRecord.TNF_MIME_MEDIA,
				mimeBytes, new byte[0], payload);
		return ndefRecord;
	}
}
