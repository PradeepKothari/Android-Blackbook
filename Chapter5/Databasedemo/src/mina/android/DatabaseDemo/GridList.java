package mina.android.DatabaseDemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class GridList extends Activity {
	DatabaseHelper dbHelper;
	static public GridView grid;
	TextView txtTest;
	Spinner spinDept1;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.gridview);
        grid=(GridView)findViewById(R.id.grid);
        txtTest=(TextView)findViewById(R.id.txtTest);
        spinDept1=(Spinner)findViewById(R.id.spinDept1);
        
        Utilities.ManageDeptSpinner(this.getParent(),spinDept1);
        final DatabaseHelper db=new DatabaseHelper(this);
        try
        {
         
         spinDept1.setOnItemSelectedListener(new OnItemSelectedListener() {
        	 
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				LoadGrid();
	    		//sca.notifyDataSetChanged();
	    		
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
       
        }
        catch(Exception ex)
        {
        	txtTest.setText(ex.toString());
        }
        
        
       
        try
        {
        grid.setOnItemClickListener(new OnItemClickListener()
        {

        	@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				try
				{
			
				SQLiteCursor cr=(SQLiteCursor)parent.getItemAtPosition(position);
				String name=cr.getString(cr.getColumnIndex(DatabaseHelper.colName));
				int age=cr.getInt(cr.getColumnIndex(DatabaseHelper.colAge));
				String Dept=cr.getString(cr.getColumnIndex(DatabaseHelper.colDeptName));
				Employee emp=new Employee(name, age,db.GetDeptID(Dept));
				emp.SetID((int)id);
				AlertDialog diag= Alerts.ShowEditDialog(GridList.this,emp);
				diag.setOnDismissListener(new OnDismissListener() {
					
					@Override
					public void onDismiss(DialogInterface dialog) {
						// TODO Auto-generated method stub
						txtTest.setText("dismissed");
						//((SimpleCursorAdapter)grid.getAdapter()).notifyDataSetChanged();
						LoadGrid();
					}
				});
				diag.show();
				}
				catch(Exception ex)
				{
					Alerts.CatchError(GridList.this, ex.toString());
				}
			}

			
        }
        );
        }
        catch(Exception ex)
        {
        	
        }

    }
    
    @Override
    public void onStart()
    {
    	super.onStart();
    	//LoadGrid();
    }
    
    public void LoadGrid()
    {
    	dbHelper=new DatabaseHelper(this);
    	try
    	{
    		//Cursor c=dbHelper.getAllEmployees();
    		View v=spinDept1.getSelectedView();
			TextView txt=(TextView)v.findViewById(R.id.txtDeptName);
			String Dept=String.valueOf(txt.getText());
    		Cursor c=dbHelper.getEmpByDept(Dept);
    		startManagingCursor(c);
    		
    		String [] from=new String []{DatabaseHelper.colName,DatabaseHelper.colAge,DatabaseHelper.colDeptName};
    		int [] to=new int [] {R.id.colName,R.id.colAge,R.id.colDept};
    		SimpleCursorAdapter sca=new SimpleCursorAdapter(this,R.layout.gridrow,c,from,to);
    		grid.setAdapter(sca);
    		
    		
    		
    	}
    	catch(Exception ex)
    	{
    		AlertDialog.Builder b=new AlertDialog.Builder(this);
    		b.setMessage(ex.toString());
    		b.show();
    	}
    }
	
}
