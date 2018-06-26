package com.kogent.android;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;


public class GetAllEmployees extends Activity
{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final EmployeeDBHelper emphelper = new EmployeeDBHelper(this);
        Cursor c = emphelper.retrieveAllEmployees();
        if(c.moveToFirst())
        {
        	do
        	{
        		Toast.makeText(this, "Employee Id:" + c.getString(0) + "\n" + 
 			"Employee Name:" + c.getString(1) + "\n" + "Employee Salary:" + 
 			c.getString(2), Toast.LENGTH_LONG).show();
        	}
        	while(c.moveToNext());
        }
        else
        {
        	Toast.makeText(this, "No Records in the database",Toast.LENGTH_LONG).show();
        }
	}	
}

