package com.kogent.android.soundpool;

import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private SoundPool mSoundPool;
	private int soundinfo;
	boolean loaded = false;
	Button PlayButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mSoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
		mSoundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
			@Override
			public void onLoadComplete(SoundPool soundPool, int sampleId,
					int status) {
				loaded = true;
			}
		});
		soundinfo = mSoundPool.load(this, R.raw.sample, 1);
		PlayButton = (Button) findViewById(R.id.Start_Play);
		PlayButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				startPlay();
			}
		});
	}

	protected void startPlay() {
		AudioManager audio_Manager = (AudioManager) getSystemService(AUDIO_SERVICE);
		float volume = ((float) (audio_Manager
				.getStreamVolume(AudioManager.STREAM_MUSIC)))
				/ ((float) (audio_Manager
						.getStreamMaxVolume(AudioManager.STREAM_MUSIC)));

		if (loaded) {
			mSoundPool.play(soundinfo, volume, volume, 1, 0, 1f);
			Log.e("Test", "Played sound");
		}

	}

}