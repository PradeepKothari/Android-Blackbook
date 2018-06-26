package com.kogent.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener
{

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button) findViewById(R.id.button1);
      btn.setOnClickListener(this);
        }
    @Override
	public void onClick(View v) {
		Intent i = new Intent(this, CustomerDetails.class);
			startActivity(i);
	}


}
