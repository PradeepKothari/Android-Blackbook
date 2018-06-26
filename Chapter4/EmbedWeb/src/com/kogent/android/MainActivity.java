package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class MainActivity extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);      
        webView.loadUrl("https://www.google.co.in/?gfe_rd=cr&ei=6Jj8UuzgAq3M8gec1IHgAg");
    }
}
