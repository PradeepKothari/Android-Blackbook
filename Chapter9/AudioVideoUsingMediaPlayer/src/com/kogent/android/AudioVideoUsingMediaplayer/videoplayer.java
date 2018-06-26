package com.kogent.android.AudioVideoUsingMediaplayer;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.kogent.android.AudioVideoUsingMediaplayer.R;

public class videoplayer extends Activity implements
OnCompletionListener,OnVideoSizeChangedListener,
OnPreparedListener,OnBufferingUpdateListener, SurfaceHolder.Callback {
	
    private int mWidth;
    private int mHeight;
    private MediaPlayer mPlayer;
    private SurfaceView mPreview;
    private SurfaceHolder surfaceholder;
    private String path;
    private Bundle extras;

    private static final String MAINACTIVITY = "mainactivity";
    
    private static final int SDCARD_VIDEO = 4;
    private static final int HTTP_VIDEO = 5;
    private static final int RESOURCES_VIDEO = 6;
    
    private boolean size = false;
    private boolean videoPlayed = false;

	@Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.mediaplayer);
        mPreview = (SurfaceView) findViewById(R.id.surface);
        surfaceholder = mPreview.getHolder();
        surfaceholder.addCallback(this);
        extras = getIntent().getExtras();
    }

    private void playVideo(Integer MAINACTIVITY) {
        reset();
        try {

            switch (MAINACTIVITY) {
                case SDCARD_VIDEO:
                	path = "/sdcard/sample.mp4";
                    // Create a new media player and set the listeners
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(path);
                    mPlayer.prepare();
                    mPlayer.setDisplay(surfaceholder);
                    mPlayer.setOnBufferingUpdateListener(this);
                    mPlayer.setOnCompletionListener(this);
                    mPlayer.setOnPreparedListener(this);
                    mPlayer.setOnVideoSizeChangedListener(this);
                    mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    break;
                case RESOURCES_VIDEO:
                    /* NOTE: Upload a video file to res/raw folder  */
                    mPlayer = MediaPlayer.create(this, R.raw.samplevideo);
                    mPlayer.start();
                    mPlayer.setDisplay(surfaceholder);
                    break;
                case HTTP_VIDEO:
                    path = "http://www.techoreo.com/sample.mp4";
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(path);
                    mPlayer.setDisplay(surfaceholder);
                    mPlayer.prepare();
                    mPlayer.setOnBufferingUpdateListener(this);
                    mPlayer.setOnCompletionListener(this);
                    mPlayer.setOnPreparedListener(this);
                    mPlayer.setOnVideoSizeChangedListener(this);
                    mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    break;
            }
        } catch (Exception error) {
            Log.e( "Exception ",  error.getMessage(), error);
        }
    }
    @Override
    public void onBufferingUpdate(MediaPlayer arg0, int percent) {
        Log.d("Buffering", "nBufferingUpdate" + percent);

    }

    public void onCompletion(MediaPlayer arg0) {
        Log.e("TAG", "onCompletion method");
        
    }

    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        mWidth = width;
        mHeight = height;
    }

    public void onPrepared(MediaPlayer mediaplayer) {
        Log.d("", "onPrepared called");
        videoPlayed = true;
        if (videoPlayed && size) {
            prepareVideoPlayback();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k) {
        Log.d("TAG", "surfaceChanged");

    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder) {
        Log.d("TAG", "surfaceDestroyed");
    }

    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("TAG", "surfaceCreated");
        playVideo(extras.getInt(MAINACTIVITY));
      //  mMediaPlayer.setDisplay(holder);
       
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
        reset();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
        reset();
    }

    private void releaseMediaPlayer() {
        if (mPlayer != null) {
        	mPlayer.release();
        	mPlayer = null;
        }
    }
 
    private void reset() {
    	mWidth = 0;
    	mHeight = 0;
        videoPlayed = false;
        size = false;
    }

    private void prepareVideoPlayback() {
        Log.v("TAG", "prepareVideoPlayback");
        surfaceholder.setFixedSize(mWidth, mHeight);
        mPlayer.start();
    }



}
