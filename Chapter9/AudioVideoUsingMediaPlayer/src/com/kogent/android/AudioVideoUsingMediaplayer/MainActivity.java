package com.kogent.android.AudioVideoUsingMediaplayer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import com.kogent.android.AudioVideoUsingMediaplayer.R;

public class MainActivity extends Activity {
	private Button sdcardvideo;
    private Button resvideo;
    private Button httpvideo;
    private Button sdcardaudio;
    private Button resaudio;
    private Button httpaudio;
    
    private static final String MAINACTIVITY = "mainactivity";
    private static final int SDCARD_AUDIO = 1;
    private static final int HTTP_AUDIO = 2;
    private static final int RES_AUDIO = 3;
    private static final int SDCARD_VIDEO = 4;
    private static final int HTTP_VIDEO = 5;
    private static final int RES_VIDEO = 6;
    

    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sdcardaudio = (Button) findViewById(R.id.sdcardaudio);
		sdcardaudio.setOnClickListener(sdcardAudioListener);
        resaudio = (Button) findViewById(R.id.resaudio);
        resaudio.setOnClickListener(resAudioListener);
       httpaudio = (Button) findViewById(R.id.httpaudio);
        httpaudio.setOnClickListener(httpAudioListener);
        
        sdcardvideo = (Button) findViewById(R.id.sdcardvideo);
        sdcardvideo.setOnClickListener(sdcardVideoListener);
        resvideo = (Button) findViewById(R.id.resvideo);
        resvideo.setOnClickListener(resVideoListener);
        httpvideo = (Button) findViewById(R.id.httpvideo);
        httpvideo.setOnClickListener(httpVideoListener);
		
	}
	private OnClickListener sdcardAudioListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
            Intent intent =
                    new Intent(MainActivity.this.getApplication(),
                            audioplayer.class);
            intent.putExtra(MAINACTIVITY, SDCARD_AUDIO);
            startActivity(intent);
        }

    };
    
    private OnClickListener resAudioListener = new OnClickListener() {
        public void onClick(View v) {
            Intent intent =
                    new Intent(MainActivity.this.getApplication(),
                    		audioplayer.class);
            intent.putExtra(MAINACTIVITY, RES_AUDIO);
            startActivity(intent); 
        }
    };

    private OnClickListener httpAudioListener = new OnClickListener() {
        public void onClick(View v) {
            Intent intent =
                    new Intent(MainActivity.this,
                    		audioplayer.class);
            intent.putExtra(MAINACTIVITY, HTTP_AUDIO);
            startActivity(intent);
        }
    };
    
    private OnClickListener sdcardVideoListener = new OnClickListener() {
        public void onClick(View v) {
            Intent intent =
                    new Intent(MainActivity.this,
                    		videoplayer.class);
            intent.putExtra(MAINACTIVITY, SDCARD_VIDEO);
            startActivity(intent);
        }
    };
    
    private OnClickListener resVideoListener = new OnClickListener() {
        public void onClick(View v) {
            Intent intent =
                    new Intent(MainActivity.this.getApplication(),
                    		videoplayer.class);
            intent.putExtra(MAINACTIVITY, RES_VIDEO);
            startActivity(intent);
        }
    };
    
    private OnClickListener httpVideoListener = new OnClickListener() {
        public void onClick(View v) {
            Intent intent =
                    new Intent(MainActivity.this,
                    		videoplayer.class);
            intent.putExtra(MAINACTIVITY, HTTP_VIDEO);
            startActivity(intent);
        }
    };
}
