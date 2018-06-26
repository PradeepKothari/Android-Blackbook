package mina.android.DatabaseDemo;

import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.List;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class EmployeesContentProvider extends ContentProvider {

	public static final Uri CONTENT_URI=Uri.parse("content://employees");
	DatabaseHelper db;
	//authority and paths
	public static final String AUTHORITY="employees";
	public static final String ALLPATH="All";
	public static final String ITPATH="IT";
	public static final String HRPATH="HR";
	public static final String SALESPATH="Sales";
	
	
	//URiMatcher to match client URis
	public static final int ALLEMPLOYEES=1;
	public static final int SINGLEEMPLOYEE=2;
	public static final int IT=3;
	public static final int HR=4;
	public static final int SALES=5;
	static final UriMatcher matcher=new UriMatcher(UriMatcher.NO_MATCH);
	static{
		matcher.addURI(AUTHORITY,null,ALLEMPLOYEES);
		matcher.addURI(AUTHORITY, ITPATH, IT);
		matcher.addURI(AUTHORITY, HRPATH, HR);
		matcher.addURI(AUTHORITY, SALESPATH, SALES);
		//you can use '*' as a wild card for any text
		matcher.addURI(AUTHORITY, "#", SINGLEEMPLOYEE);
	}
	
	@Override
	public int delete(Uri uri, String where, String[] args) {
		
		int match=matcher.match(uri);
		//expecting the URi to be in the form of content://
		if(match==1)
		{
			SQLiteDatabase dataBase=db.getWritableDatabase();
			return dataBase.delete(db.employeeTable, where, args);
		}
		else
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		int match=matcher.match(uri);
		// single employee
		if(match==2)
		{
			return "mina.android.Employee";
		}
		//collection of employees
		else
		{
			
			return "mina.android.Employees";
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		int match=matcher.match(uri);
		//not the Uri we're expecting
		long newID=0;
		if(match!=1)
			throw new IllegalArgumentException("Wrong URi "+uri.toString());
		if(values!=null)
		{
			newID=db.getWritableDatabase().insert(DatabaseHelper.employeeTable, DatabaseHelper.colName, values);
			return Uri.withAppendedPath(uri, String.valueOf(newID));
			
		}
		else
			return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		db=new DatabaseHelper(this.getContext());
		if(db==null)
			return false;
		else
			return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder builder=new SQLiteQueryBuilder();
		
		builder.setTables(DatabaseHelper.viewEmps);
		
		String order=null;
		Cursor result=null;
		if(sortOrder!=null)
			order=sortOrder;
		int match=matcher.match(uri);
		switch(match)
		{
		case ALLEMPLOYEES:
			
			result=builder.query(db.getWritableDatabase(), projection, selection, selectionArgs, null, null, sortOrder);
			break;
		case SINGLEEMPLOYEE:
			//content://employees//id
			List<String>segments=uri.getPathSegments();
			String empID=segments.get(0);
			result=db.getEmpByID(empID);

			break;
		case IT:
			//content://employees//IT
			result=db.getEmpByDept("IT");
			result=builder.query(db.getReadableDatabase(), projection, db.colDeptName+"=?", new String[]{"IT"}, null, null, sortOrder);
			break;
		case HR:
			//content://employees//HR
			result=db.getEmpByDept("HR");
			result=builder.query(db.getReadableDatabase(), projection, db.colDeptName+"=?", new String[]{"HR"}, null, null, sortOrder);
			break;
		case SALES:
			//content://employees//Sales
			result=db.getEmpByDept("Sales");
			result=builder.query(db.getReadableDatabase(), projection, db.colDeptName+"=?", new String[]{"Sales"}, null, null, sortOrder);
			
			break;
		
		}
		
		return result;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int match=matcher.match(uri);
		//not the Uri we're expecting
		int rows=0;
		//update single instance
		if(match==2)
		{
			if(values!=null)
			{
				List<String>segments=uri.getPathSegments();
				String empID=segments.get(0);
				rows=db.getWritableDatabase().update(DatabaseHelper.employeeTable, values,DatabaseHelper.colID+"=?", new String []{empID});
				
			}
			
		}
		//update all emps in a certain dept
		else if(match==3 ||match==4||match==5)
		{
			List<String>segments=uri.getPathSegments();
			String deptName=segments.get(0);
			int DeptID=db.GetDeptID(deptName);
			rows=db.getWritableDatabase().update(db.employeeTable, values,db.colDept+"=?", new String []{String.valueOf(DeptID)});
			
		}
			return rows;
	}

}
