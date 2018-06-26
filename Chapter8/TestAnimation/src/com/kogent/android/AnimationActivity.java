package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class AnimationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ImageView testImage = (ImageView) findViewById(R.id.image);
		Animation animation = AnimationUtils.loadAnimation(this,
				R.anim.animationdef);
		testImage.startAnimation(animation);	

	}
	

}
