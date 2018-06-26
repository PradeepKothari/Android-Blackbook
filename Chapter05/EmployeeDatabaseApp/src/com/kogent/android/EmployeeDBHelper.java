package com.kogent.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class EmployeeDBHelper {
	public static final String EmpId = "EmpId";
	public static final String EmpName = "EmpName";
	public static final String EmpSal = "EmpSal";

	private static final String databasename = "EmployeeDB";
	private static final String tablename = "Employee";
	private static final int databaseversion = 1;
	private static final String create_table = "create table Employee (EmpId integer 	primary key autoincrement, " + "EmpName text not null, EmpSal integer not 	null);";
	private final Context ct;
	private DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	public EmployeeDBHelper(Context context)
	{
		this.ct = context;
		dbHelper = new DatabaseHelper(ct);
	}
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context c)
		{
			super(c,databasename,null,databaseversion);
		}

		@Override
		public void onCreate(SQLiteDatabase database) {
			try
			{
				database.execSQL(create_table);
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase database, int arg1, int arg2) {
			database.execSQL("DROP TABLE IF EXISTS Employee");
			onCreate(database);
		}
	}
		//Declaring the connect() method to connect to the database
	public EmployeeDBHelper connect() throws SQLException
	{
		database = dbHelper.getWritableDatabase();
		return this;
	}
	//Declaring the disconnect() method to close the database
	public void disconnect()
	{
		dbHelper.close();
	}

	//Declaring the insertEmployee() method to add the employee details into the 	database

	public long insertEmployee(String empname, int empsal)
	{
		ContentValues cv = new ContentValues();
		cv.put(EmpName, empname);
		cv.put(EmpSal, empsal);
		this.connect();
		return database.insert(tablename, null, cv);
	}

	//Declaring the retrieveAllEmployees() method to retrieve the details of all the employees from the database

	public Cursor retrieveAllEmployees() 
	{
		this.connect();
		return database.query(tablename, new String[] { EmpId, EmpName, EmpSal}, null, 
	 		null, null, null, null);
	}

	//Declaring the retrieveEmployees() method to retrieve the details of an employee from the database
	public Cursor retrieveEmployee(long id) throws SQLException
	{
		this.connect();
		Cursor c = database.query(true, tablename, new String [] {EmpId, EmpName, 
	 		EmpSal}, EmpId + "=" + id, null, null, null, null, null);
		if (c != null)
		{
			c.moveToFirst();
		}
		return c;
	}

	//Declaring the deleteEmployee() method to delete the details of an Employee
	public boolean deleteEmployee(long id)
	{
		this.connect();
		return database.delete(tablename, EmpId + "=" + id, null) > 0;
	}

	//Declaring the updateEmployee() method to update the details of an Employee
	public boolean updateEmployee(long id, String empname, int empsal)
	{
		this.connect();
		ContentValues cvalues = new ContentValues();
		cvalues.put(EmpName, empname);
		cvalues.put(EmpSal, empsal);
		return database.update(tablename, cvalues, EmpId + "=" + id, null) > 0;
	}


}
