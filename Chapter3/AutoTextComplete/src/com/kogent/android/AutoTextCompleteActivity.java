package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoTextCompleteActivity extends Activity {
String[] books = {
"Java 7 in Simple Steps","AutoCAD 2011 in Simple Steps","Entrepreneurship","Advance 	.NET Technology",
"Sun Certified Programmer for Java 6 SCJP","WPF 4.0 in Simple Steps","SQL & PL/SQL 	for Oracle 11g Black Book",
"Advance Database Management System","Advance Computing Technology","Concepts of 	Programming and OOPs",
"Basic Computer Engineering","Spring 3.0 in Action","Java Server Programming Java EE 	6 (J2EE 1.6)",
"Excel 2010 in Simple Steps","Excel 2007 in Simple Steps","Access 2010 in Simple 	Steps"
};
	/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);
ArrayAdapter<String> array_adapter = new ArrayAdapter<String>(this, 	android.R.layout.simple_dropdown_item_1line, books);
AutoCompleteTextView auto_view = (AutoCompleteTextView) 	findViewById(R.id.bookSearch);
auto_view.setThreshold(3);
auto_view.setAdapter(array_adapter);
}
}
