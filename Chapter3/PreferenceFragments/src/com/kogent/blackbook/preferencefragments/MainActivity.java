package com.kogent.blackbook.preferencefragments;

import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 PrefFragment prefFragment = new PrefFragment();
		  FragmentManager fragmentManager = getFragmentManager();
		  FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		  fragmentTransaction.replace(android.R.id.content, prefFragment);
		  fragmentTransaction.commit();
		  
		 } 
	}
