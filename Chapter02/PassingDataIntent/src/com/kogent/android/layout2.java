package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class layout2 extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
       
        String myName = null;       
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            myName = extras.getString("Name");
        }
       
       
        TextView tvData = (TextView) findViewById(R.id.tvData);
        tvData.setText(myName);

    }

}
