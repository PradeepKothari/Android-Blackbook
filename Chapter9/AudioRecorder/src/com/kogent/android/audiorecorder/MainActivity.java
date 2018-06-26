package com.kogent.android.audiorecorder;

import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private MediaRecorder mRecorder;
	private String outputFile = null;
	private Button start, stop, play, reset;
	MediaPlayer mPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start = (Button) findViewById(R.id.button1);
		stop = (Button) findViewById(R.id.button2);
		play = (Button) findViewById(R.id.button3);
		reset = (Button) findViewById(R.id.button4);
		stop.setEnabled(false);
		play.setEnabled(false);
		reset.setEnabled(false);

	}

	public void start(View view) {
		outputFile = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/recording.3gp";
		try {
			mRecorder = new MediaRecorder();
			mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
			mRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
			mRecorder.setOutputFile(outputFile);
			mRecorder.prepare();
			mRecorder.start();
		} catch (IllegalStateException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		start.setEnabled(false);
		stop.setEnabled(true);
		Toast.makeText(getApplicationContext(), "Recording started",
				Toast.LENGTH_LONG).show();

	}

	public void stop(View view) {
		try {
			mRecorder.stop();
			mRecorder.release();
			mRecorder = null;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		stop.setEnabled(false);
		play.setEnabled(true);
		reset.setEnabled(true);
		addToMediaLibrary();
		Toast.makeText(getApplicationContext(), "Audio recorded successfully",
				Toast.LENGTH_LONG).show();
	}

	public void play(View view) throws IllegalArgumentException,
			SecurityException, IllegalStateException, IOException {

		mPlayer = new MediaPlayer();
		mPlayer.setDataSource(outputFile);
		mPlayer.prepare();
		mPlayer.start();
		Toast.makeText(getApplicationContext(), "Playing audio",
				Toast.LENGTH_LONG).show();

	}

	public void reset(View view) {
		try {
			if (mPlayer != null) {
				mPlayer.stop();
				mPlayer.release();
				mPlayer = null;
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		start.setEnabled(true);
		stop.setEnabled(false);
		play.setEnabled(false);
		reset.setEnabled(false);
		Toast.makeText(getApplicationContext(), "record audio again",
				Toast.LENGTH_LONG).show();

	}
	
	
	protected void addToMediaLibrary() {
		ContentResolver contentResolver = getContentResolver();
		Uri base = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
	    ContentValues contentValues = new ContentValues(4);
	    long current = System.currentTimeMillis();
	    contentValues.put(MediaStore.Audio.Media.TITLE, "audio" + "sample.3gp");
	    contentValues.put(MediaStore.Audio.Media.DATE_ADDED, (int) (current / 1000));
	    contentValues.put(MediaStore.Audio.Media.MIME_TYPE, "audio/3gpp");
	    contentValues.put(MediaStore.Audio.Media.DATA, outputFile);
	    Uri newUri = contentResolver.insert(base, contentValues);
	    sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, newUri));
	    Toast.makeText(this, "New File " + newUri, Toast.LENGTH_LONG).show();
	  }

}