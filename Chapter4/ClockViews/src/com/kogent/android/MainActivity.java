package com.kogent.android;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity implements OnItemClickListener
{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView l = (ListView) findViewById(R.id.number_list);
		ArrayAdapter<String> numbers = new 
 ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,
		new String [] {"Analog View", "Digital View"});
		l.setAdapter(numbers);
		l.setOnItemClickListener(this);
		}
	    
	private void stackAFragment(int index) {
		Fragment f = new ClockFragment(index);
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.the_frag, f);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		ft.addToBackStack(null);
		ft.commit();
		}	
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
 	{
		stackAFragment(position + 1);
		}


}
