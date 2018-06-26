package com.kogent.android.videorecording;

import java.io.IOException;


import android.os.Bundle;
import android.app.Activity;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements SurfaceHolder.Callback{

	Button mRecord,mStop,mCapture;
	MediaRecorder mediaRecorder;
	SurfaceHolder surfaceHolder;
	SurfaceView myVideoView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SetupView();

		mRecord = (Button)findViewById(R.id.record);
		mRecord.setEnabled(true);
		mStop = (Button)findViewById(R.id.stop);
		mStop.setEnabled(false);
    

	}

	private void SetupView(){
		SurfaceView myVideoView = (SurfaceView)findViewById(R.id.camera_preview);
		surfaceHolder = myVideoView.getHolder();
		surfaceHolder.addCallback(this);    	
	}

	public void record(View view) {
		try {
			mediaRecorder = new MediaRecorder();
			mediaRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
			mediaRecorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);
			CamcorderProfile camcorderProfile_HQ = CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH);
			mediaRecorder.setProfile(camcorderProfile_HQ);
			mediaRecorder.setOutputFile("/sdcard/myvideo.mp4");
			mediaRecorder.setMaxDuration(60000); // Set max duration 60 sec.
			mediaRecorder.setMaxFileSize(5000000); // Set max file size 5M
			mediaRecorder.setPreviewDisplay(surfaceHolder.getSurface());
			prepareMediaRecorder();
			mediaRecorder.start();
			mRecord.setEnabled(false);
			mStop.setEnabled(true);
			Toast.makeText(getApplicationContext(), "Recording started",
					Toast.LENGTH_LONG).show();
		} catch (IllegalStateException e) {
	
			e.printStackTrace();
		}


	}

	public void stop(View view) {
		mediaRecorder.stop();
		mediaRecorder.release();
		mRecord.setEnabled(true);
		mStop.setEnabled(false);
		Toast.makeText(getApplicationContext(), "Video recorded successfully",
				Toast.LENGTH_LONG).show();
	}	


	private void prepareMediaRecorder(){

		try {
			mediaRecorder.prepare();
		} catch (IllegalStateException e) {
	
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
	
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	
	}

}
