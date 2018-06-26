package com.kogent.android;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class ActionBarActivity extends Activity {

	public static Context myContext;
	/** Called on first time creation of of activity */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		myContext = getApplicationContext();
		try {
			/*
			 * ActionBar for the current navigation mode The tabs are 
 				navigating
			 * within the activity
			 */
			ActionBar actionbar = getActionBar();
			actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

			// Tab creation
			Tab tab1 = actionbar.newTab().setText("Tab 1");
			Tab tab2 = actionbar.newTab().setText("Tab 2");
			Tab tab3 = actionbar.newTab().setText("Tab 3");
			Tab tab4 = actionbar.newTab().setText("Tab 4");

			/*
			 * Fragment creation. A fragment is the space under the activity 
 				to
			 * display the tab contents
			 */
			Fragment fragment1 = new FirstFragment();
			Fragment fragment2 = new SecondFragment();
			Fragment fragment3 = new ThirdFragment();
			Fragment fragment4 = new FourthFragment();

			// listening for tapping on tabs
			tab1.setTabListener(new MyTabsListner(fragment1));
			tab2.setTabListener(new MyTabsListner(fragment2));
			tab3.setTabListener(new MyTabsListner(fragment3));
			tab4.setTabListener(new MyTabsListner(fragment4));

			// Addition of tabs to UI
			actionbar.addTab(tab1);
			actionbar.addTab(tab2);
			actionbar.addTab(tab3);
			actionbar.addTab(tab4);
		} catch (Exception ex) {
			Log.e("error from onCreate", ex.toString());
			Log.e("error from onCreate", ex.getStackTrace().toString());
			// TODO: handle exception
		}
	}
}
