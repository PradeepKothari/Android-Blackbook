package mina.android.DatabaseDemo;

import android.app.Activity;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Spannable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class AddEmployee extends Activity {
	EditText txtName;
	EditText txtAge;
	TextView txtEmps;
	DatabaseHelper dbHelper;
	Spinner spinDept;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addemployee);
        txtName=(EditText)findViewById(R.id.txtName);
        txtAge=(EditText)findViewById(R.id.txtAge);
        txtEmps=(TextView)findViewById(R.id.txtEmps);
        spinDept=(Spinner)findViewById(R.id.spinDept);
    }
	
	@Override
	public void onStart()
	{
		try
		{
		super.onStart();
		dbHelper=new DatabaseHelper(this);
		txtEmps.setText(String.valueOf(dbHelper.getEmployeeCount()));
		
		Cursor c=dbHelper.getAllDepts();
		startManagingCursor(c);
		
		
		
		//SimpleCursorAdapter ca=new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item, c, new String [] {DatabaseHelper.colDeptName}, new int []{android.R.id.text1});
		SimpleCursorAdapter ca=new SimpleCursorAdapter(this,R.layout.deptspinnerrow, c, new String [] {DatabaseHelper.colDeptName,"_id"}, new int []{R.id.txtDeptName});
		//ca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinDept.setAdapter(ca);
		spinDept.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View selectedView,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//never close cursor
		}
		catch(Exception ex)
		{
			CatchError(ex.toString());
		}
	}
	
	public void btnAddEmp_Click(View view)
	{
		boolean ok=true;
		try
		{
			Spannable spn=txtAge.getText();
			String name=txtName.getText().toString();
			int age=Integer.valueOf(spn.toString());
			int deptID=Integer.valueOf((int)spinDept.getSelectedItemId());
			Employee emp=new Employee(name,age,deptID);
			
			dbHelper.AddEmployee(emp);
			
		}
		catch(Exception ex)
		{
			ok=false;
			CatchError(ex.toString());
		}
		finally
		{
			if(ok)
			{
				//NotifyEmpAdded();
				Alerts.ShowEmpAddedAlert(this);
				txtEmps.setText("Number of employees "+String.valueOf(dbHelper.getEmployeeCount()));
			}
		}
	}
	
	void CatchError(String Exception)
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Add new Employee");
		TextView txt=new TextView(this);
		txt.setText(Exception);
		diag.setContentView(txt);
		diag.show();
	}
	
	void NotifyEmpAdded()
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Add new Employee");
		TextView txt=new TextView(this);
		txt.setText("Employee Added Successfully");
		diag.setContentView(txt);
		diag.show();
		try {
			diag.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			CatchError(e.toString());
		}
		diag.notify();
		diag.dismiss();
	}
	
}
