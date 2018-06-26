package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddEmployee extends Activity
{
	Button add_emp;
	EditText empname, empsal; 
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addemployee);
        final EmployeeDBHelper empdbhelper = new EmployeeDBHelper(this);
       empname = (EditText) findViewById(R.id.empname);
		empsal = (EditText) findViewById(R.id.empsal);
        add_emp = (Button) findViewById(R.id.addEmp);
        add_emp.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View v) {	
 try{
 String name;
 int sal;
 name = empname.getText().toString();
 sal = (Integer.parseInt(empsal.getText().toString()));
 long id = empdbhelper.insertEmployee(name, sal);
	Toast.makeText(getBaseContext(), "Your record has been saved successfully" + id, 
 		Toast.LENGTH_LONG).show();
				}
        		catch(Exception e)
        		{
        			e.printStackTrace();
        		}
        }
        	
    });
}
}

