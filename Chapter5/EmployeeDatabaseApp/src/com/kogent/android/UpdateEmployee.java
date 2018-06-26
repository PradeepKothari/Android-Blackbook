package com.kogent.android;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateEmployee extends Activity
{
	EditText empid, empname, empsal; 
	Button update;
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.updateemployee);
    final EmployeeDBHelper empdb = new EmployeeDBHelper(this);
    empid = (EditText) findViewById(R.id.empid);
    empname = (EditText) findViewById(R.id.empname);
    empsal = (EditText) findViewById(R.id.empsal);
    update = (Button) findViewById(R.id.btn_update);
    update.setOnClickListener(new View.OnClickListener()
    {
    	@Override
    	public void onClick(View v) 
    	{	
    		int emp_id = Integer.parseInt(empid.getText().toString());
    		String empstr = empname.getText().toString();
    		int intsal = Integer.parseInt(empsal.getText().toString());
    		if (empdb.updateEmployee(emp_id, empstr, intsal))
    		{
    			Toast.makeText(getBaseContext(), "Record has been updated", 
 			Toast.LENGTH_LONG).show();
    		}
    		else
    		{
    			Toast.makeText(getBaseContext(), "Record has not been updated", 
 			Toast.LENGTH_LONG).show();
    		}
    			
    	}
    	
});
    empid.addTextChangedListener(new TextWatcher()
    {
    	@Override
    	public void afterTextChanged(Editable e){
    	}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,int 
 		after) {
			
		}
		@Override
		public void onTextChanged(CharSequence s, int start, int before,int count) 
 		{
				empid.setEnabled(false);
				int emp_id = Integer.parseInt(empid.getText().toString());
	    		Cursor c = empdb.retrieveEmployee(emp_id);
	    		if(c.moveToFirst())
	    		{
	    		    empname.setText(c.getString(1));
	        	    empsal.setText(c.getString(2));
	    		}
	    		else
	    		{
	    			Toast.makeText(getBaseContext(), "No Employee Record Found", Toast.LENGTH_LONG).show();
	    		}
				
			}
    });
}
}

