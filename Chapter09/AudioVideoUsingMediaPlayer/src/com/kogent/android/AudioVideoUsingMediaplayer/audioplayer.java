package com.kogent.android.AudioVideoUsingMediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.kogent.android.AudioVideoUsingMediaplayer.R;

public class audioplayer extends Activity{	
	
    private MediaPlayer mPlayer;
    private static final String MAINACTIVITY = "mainactivity";
    private static final int SDCARD_AUDIO = 1;
    private static final int HTTP_AUDIO = 2;
    private static final int RES_AUDIO = 3;
    private String path;
    private TextView tx;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        tx = new TextView(this);
        setContentView(tx);
        Bundle extras = getIntent().getExtras();
        playAudio(extras.getInt(MAINACTIVITY));
    }

    private void playAudio(Integer media) {
        try {
            switch (media) {
                case SDCARD_AUDIO:
                    path = "/sdcard/sample.mp3";
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(path);
                    mPlayer.prepare();
                    mPlayer.start();
                    break;
                case HTTP_AUDIO:
                	tx.setText("Please Wait...");
                    path = "http://www.techoreo.com/sample.mp3";
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(path);
                    mPlayer.prepare();
                    mPlayer.start();
                    break;
                case RES_AUDIO:
                    mPlayer = MediaPlayer.create(this, R.raw.sampleaudio);
                    mPlayer.start();
                    break;
                
            }
            tx.setText("Playing audio...");

        } catch (Exception e) {
            Log.e( "Exception: " ,e.getMessage(), e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
    
    @Override
    protected void onPause() {
        super.onPause();
       
    }

    @Override
    protected void onStop() {
        super.onStop();       
       
    }

}
