package com.kogent.android;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.RelativeLayout;
public class ClockFragment extends Fragment {
	private int index;
	public ClockFragment() {		
	}
	public ClockFragment(int index) {
		this.index = index;    
	}
   	@Override
	public void onCreate(Bundle saved) {
		super.onCreate(saved);
		if (null != saved) {
			index = saved.getInt("index");
			}
		}   
	@Override
	public void onSaveInstanceState(Bundle toSave) {
		toSave.putInt("index", index);
		}    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle 	saved) {
		Context c = getActivity().getApplicationContext();
		RelativeLayout l = new RelativeLayout(c);
		if(index == 1)
		{
			AnalogClock ac = new AnalogClock(c);
			l.addView(ac);
		}
		else if (index == 2) 
		{
			DigitalClock dc = new DigitalClock(c);
			dc.setTextSize((float) 30d);
			l.addView(dc);
		}
		return l; 
	 }
}

