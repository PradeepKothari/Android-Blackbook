package com.kogent.blackbook.dialogfragment;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        FragmentManager fm = getFragmentManager();
        MyDialogWIndow testDialog = new MyDialogWIndow();
        testDialog.setRetainInstance(true);
        testDialog.show(fm, "fragment_name");
}
}