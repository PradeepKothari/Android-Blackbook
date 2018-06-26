package com.kogent.android;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class UIEventsView extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
 	{
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        LayoutParams layout_params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        final LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);        
        Button button1 = new Button(this);
        button1.setText("Click Me");
        button1.setTextSize(30);
        button1.setLayoutParams(layout_params);
        layout.addView(button1);
        button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getBaseContext(), ((Button) v).getText() + " button was clicked", Toast.LENGTH_LONG).show();
			}
		});
		LinearLayout.LayoutParams layout_param = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		this.addContentView(layout, layout_param);
	}
}