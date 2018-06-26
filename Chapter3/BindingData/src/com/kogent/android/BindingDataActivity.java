package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class BindingDataActivity extends Activity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_button);
        ArrayAdapter<CharSequence> array_adapter = ArrayAdapter.createFromResource(this, R.array.menu_items, 
 		android.R.layout.simple_spinner_item);
        
 	array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinner1.setAdapter(array_adapter);
         spinner1.setOnItemSelectedListener(new OnItemSelectedListener()
       {
 	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) 
       {
         Toast.makeText(parent.getContext(), "The food item selected by you is " 
 		+parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
       }
       public void onNothingSelected(AdapterView<?> parent) {  
           	 	// Do nothing.    
       }
       });

    }
}
