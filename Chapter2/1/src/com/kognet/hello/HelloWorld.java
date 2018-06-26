package com.kognet.hello;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

public class HelloWorld extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final TextView message = new TextView(this);
        message.setText("");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.AlertBoxMessage);
        builder.setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	message.setText("Your Answer is Yes" );
               
            }
        });
         builder.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	message.setText("Your Answer is No");
                
            }
           
        });
         builder.setNeutralButton(R.string.CanNotSay, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	message.setText("Your Answer is Can Not Say");
                
            }
           
        });
        
         
        builder.show();
      setContentView(message);

    }
}
