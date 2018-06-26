package com.kogent.android;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
public class DynamicUIActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);
		LayoutParams layout_params = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		final LinearLayout layout = new LinearLayout(this);
		final DatePicker dt = new DatePicker(this);
		dt.setLayoutParams(layout_params);
		Button button1 = new Button(this);
		button1.setText("Click Me to display date");
		button1.setTextSize(10);
		button1.setLayoutParams(layout_params);
		layout.addView(button1);
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				layout.addView(dt);
			}
		});
		LinearLayout.LayoutParams layout_param = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		this.addContentView(layout, layout_param);
	}
}
