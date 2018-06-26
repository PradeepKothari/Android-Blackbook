package com.Kogent.alertdialogbox;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.widget.Toast;


public class AlertDialogBox extends Activity {
	  private  String gen;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 final CharSequence[] gender = {"Male","Female"};
		    AlertDialog.Builder alert = new AlertDialog.Builder(this);
		    alert.setTitle("Select Gender");
		    alert.setSingleChoiceItems(gender,-1, new DialogInterface.OnClickListener()
		    {
		        @Override
		        public void onClick(DialogInterface dialog, int which) 
		        {
					Toast.makeText(
							AlertDialogBox.this,
	                        gender[which]+"Select ",
	                        Toast.LENGTH_SHORT
	                        )
	                        .show();
		        }
		    });
		 //   AlertDialog alert = builder.create();
		    alert.show();
		
	}}
	
	