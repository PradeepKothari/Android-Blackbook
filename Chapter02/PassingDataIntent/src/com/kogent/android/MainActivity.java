package com.kogent.android;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	 Button b1 = (Button) findViewById(R.id.btOk);
     
     b1.setOnClickListener(new View.OnClickListener() {
        
         @Override
         public void onClick(View v) {
             // TODO Auto-generated method stub
            
             EditText etName = (EditText) findViewById(R.id.etName);
            
             String Data = etName.getText().toString();
            
             Intent i = new Intent("com.kogent.android.layout2");
             Bundle extras = new Bundle();
             extras.putString("Name", Data);
             i.putExtras(extras);
             startActivityForResult(i, 1);
            
         }
     });
 }
}

