package com.kogent.android.outgoingcall;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class MainActivity extends Activity {

	final Context context = this;
	private Button button;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent diallerIntent = new Intent(Intent.ACTION_CALL);
				diallerIntent.setData(Uri.parse("tel:+919971101299"));
				startActivity(diallerIntent);

			}

		});

	}


}