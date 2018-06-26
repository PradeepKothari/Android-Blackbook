package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Gallery.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;
import android.view.Menu;

public class MainActivity extends Activity implements ViewFactory 
{

	private ImageSwitcher mSwitcher;
	private int position=0;
    Button btn_image;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
        mSwitcher.setFactory(this);
mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        mSwitcher.setImageResource(mImageIds[(position)]);
        btn_image = (Button) findViewById(R.id.btn_image);
        btn_image.setOnClickListener(new View.OnClickListener() {
		@Override
			public void onClick(View v) {
			position = position + 1;
				if (position < 8)
				{
					mSwitcher.setImageResource(mImageIds[(position)]);
				}
				else
				{
					position = 0;
					mSwitcher.setImageResource(mImageIds[(position)]);
					
				}
		}});
    }
	@Override
	public View makeView() 
	{
		ImageView i = new ImageView(this);
        i.setBackgroundColor(0xFF000000);
        i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        i.setLayoutParams(new  
 	ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
        return i;
	}
    private Integer[] mImageIds = {
            R.drawable.sample1, R.drawable.sample2, 
            R.drawable.sample3, R.drawable.sample4, 
            R.drawable.sample5, R.drawable.sample6,
            R.drawable.sample7, R.drawable.sample8
};


}
