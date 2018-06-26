package com.kogent.tweenanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
 

public class TweenAnimation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tween_animation);
		final Animation a = AnimationUtils.loadAnimation(this, R.anim.rotate);
        a.reset();
        final TextView rText = (TextView) findViewById(R.id.animatedText);
 
        LinearLayout layout = (LinearLayout) findViewById(R.id.root);
        layout.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                rText.startAnimation(a);
 
            }
        });
 
    }
}