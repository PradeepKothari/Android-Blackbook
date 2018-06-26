package com.kogent.blackbook.consumecontentprovider;



import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.database.Cursor;



public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor> {
	 TextView resultView=null;  
	    CursorLoader cursorLoader;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		resultView= (TextView) findViewById(R.id.res);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClickDisplayNames(View view) {
		  getSupportLoaderManager().initLoader(1, null, this);
		 }

	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		cursorLoader= new CursorLoader(this, Uri.parse("content://com.kogent.blackbook.userdefinedcontentprovider.contentprovider/cte"), null, null, null, null);
		  return cursorLoader;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
		
		cursor.moveToFirst();
		  StringBuilder res=new StringBuilder();
		        while (!cursor.isAfterLast()) {
		         res.append("\n"+cursor.getString(cursor.getColumnIndex("id"))+ "-"+ cursor.getString(cursor.getColumnIndex("name")));
		            cursor.moveToNext();
		        }
		        resultView.setText(res);
		 }

	
	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	 public void onDestroy() {
	        super.onDestroy();
	    }

	}


