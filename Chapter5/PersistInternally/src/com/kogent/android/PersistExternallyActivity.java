package com.kogent.android;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PersistExternallyActivity extends Activity {
	EditText book_Name, pub_Name, book_Price; 
	Button btn_Save;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	book_Name = (EditText) findViewById(R.id.bookName);
	pub_Name = (EditText) findViewById(R.id.pubName);
	book_Price = (EditText) findViewById(R.id.bookPrice);
	btn_Save = (Button) findViewById(R.id.btnSave);
	btn_Save.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View v) {
	String b_name = book_Name.getText().toString();
	String p_name = pub_Name.getText().toString();
	String b_price = book_Price.getText().toString();
	String str = "Book Name:" + b_name + " Publisher Name:" + p_name + " Price of the 	book:" + b_price;
		try
		{
		File sdcard = getExternalFilesDir(null);
		File directory = new File (sdcard.getAbsolutePath() + "/MyFiles");
		directory.mkdirs();
		File file = new File(directory,"bookDetails.txt");
		FileOutputStream fOut = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fOut);
		osw.write(str);
		osw.flush();
		osw.close();
		Toast.makeText(getBaseContext(), "Book Details have been saved successfully",Toast.LENGTH_LONG).show();
		book_Name.setText("");
		pub_Name.setText("");
		book_Price.setText("");
		}
		catch(IOException e)
		{
		e.printStackTrace();
		}
		}
		});
		}

}
