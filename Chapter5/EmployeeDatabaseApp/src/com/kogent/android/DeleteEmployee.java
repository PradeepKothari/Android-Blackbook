package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteEmployee extends Activity 
{
	EditText empid;
	Button delete;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deleteemployee);
        final EmployeeDBHelper empdbhelper = new EmployeeDBHelper(this);
		empid = (EditText) findViewById(R.id.empid);   
        delete = (Button) findViewById(R.id.btn_delete);
        delete.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View v) {	
  	        int emp_id = Integer.parseInt(empid.getText().toString());
        if(empdbhelper.deleteEmployee(emp_id))
        	Toast.makeText(getBaseContext(), "Your record has been deleted", 
 		Toast.LENGTH_LONG).show();
        else
        	Toast.makeText(getBaseContext(), "Record does not exist", 
 		Toast.LENGTH_LONG).show();

	}
});
}
}

