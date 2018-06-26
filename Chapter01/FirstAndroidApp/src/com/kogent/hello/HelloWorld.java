package com.kogent.hello;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HelloWorld extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)     {
        super.onCreate(savedInstanceState);
        TextView message = new TextView(this);
        message.setText("Welcome to the world of Android");
        setContentView(message);
    }
}