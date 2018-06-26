package com.kogent.blackbook.dialogfragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.DialogFragment;


public class MyDialogWIndow extends DialogFragment {
	  
	 @Override
	
	   
		 public View onCreateView(LayoutInflater inflater, ViewGroup container,
		            Bundle savedInstanceState) {
		        View view = inflater.inflate(R.layout.alertdialogfragment, container);
		        return view;
		    }
	 
	}