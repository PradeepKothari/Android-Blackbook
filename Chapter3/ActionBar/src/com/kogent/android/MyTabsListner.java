package com.kogent.android;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.widget.Toast;

// This class is invoked when an action is performed on tabs

@SuppressLint("NewApi") public class MyTabsListner implements ActionBar.TabListener {
	public Fragment fragment;

	// Creating fragment for activity
	public MyTabsListner(Fragment fragment) {
		this.fragment = fragment;
	}
	// On successive tapping or clicking of tabs
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction transaction) {
		Toast.makeText(ActionBarActivity.myContext, "You have clicked again!",
				Toast.LENGTH_LONG).show();
	}
	// On first time tapping or clicking of tabs
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction transaction) {
		transaction.replace(R.id.actionbar, fragment);
	}
	// When tabs are not selected
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction transaction) {
		transaction.remove(fragment);
	}
}
