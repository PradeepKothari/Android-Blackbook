package com.kogent.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class EmployeeDatabaseAppActivity extends Activity implements OnClickListener 
{
	Button add_emp, get_all_emp, get_emp, update_emp, delete_emp;
	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);add_emp = (Button) findViewById(R.id.addEmp);
        add_emp.setOnClickListener(this);
        get_all_emp = (Button) findViewById(R.id.selectAllEmp);
        get_all_emp.setOnClickListener(this);
        get_emp = (Button) findViewById(R.id.selectEmp);
        get_emp.setOnClickListener(this);
        update_emp = (Button) findViewById(R.id.updateEmp);
        update_emp.setOnClickListener(this);
        delete_emp = (Button) findViewById(R.id.deleteEmp);
        delete_emp.setOnClickListener(this);   

   }
	public void onClick(View v) {	
		if(v == findViewById(R.id.addEmp))
	   	{		
			Intent i = new Intent(this, AddEmployee.class);
			startActivity(i);
	   	}
		if (v == findViewById(R.id.selectAllEmp))
		{
			Intent i = new Intent(this, GetAllEmployees.class);
			startActivity(i);
		}
		if (v == findViewById(R.id.selectEmp))
		{
			Intent i = new Intent(this, GetEmployee.class);
			startActivity(i);
		}
		if (v == findViewById(R.id.updateEmp))
		{
			Intent i = new Intent(this, UpdateEmployee.class);
			startActivity(i);
		}
		if (v == findViewById(R.id.deleteEmp))
		{
			Intent i = new Intent(this, DeleteEmployee.class);
			startActivity(i);
		}
   }


}
