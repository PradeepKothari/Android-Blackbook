package com.kogent.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ViewSwitcher.ViewFactory;


public class MainActivity extends Activity implements
OnItemSelectedListener, ViewFactory {
private ImageSwitcher mSwitcher;   
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
requestWindowFeature(Window.FEATURE_NO_TITLE);
setContentView(R.layout.main);
mSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
mSwitcher.setFactory(this);
mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
Gallery g = (Gallery) findViewById(R.id.gallery);
g.setAdapter(new ImageAdapter(this));
g.setOnItemSelectedListener(this);      
}
public void onItemSelected(AdapterView parent, View v, int position, long id) {
Toast.makeText(MainActivity.this, v +"  at location"+ position+1 , 
Toast.LENGTH_LONG).show();
mSwitcher.setImageResource(mImageIds[position]);
}
public void onNothingSelected(AdapterView parent) {
}
@Override
public View makeView() {
ImageView i = new ImageView(this);
i.setBackgroundColor(0xFF000000);
i.setScaleType(ImageView.ScaleType.FIT_CENTER);
i.setLayoutParams(new 
ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
return i;
}
public class ImageAdapter extends BaseAdapter {
public ImageAdapter(Context c) {
mContext = c;
}
public int getCount() {
return mImageIds.length;
}
public Object getItem(int position) {
return position;
}
public long getItemId(int position) {
return position;
}
public View getView(int position, View convertView, ViewGroup parent) {
ImageView i = new ImageView(mContext);
i.setImageResource(mImageIds[position]);
i.setAdjustViewBounds(true);
i.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, 
LayoutParams.WRAP_CONTENT));
i.setBackgroundResource(R.drawable.picture_frame);
return i;
}
private Context mContext;
}
private Integer[] mImageIds = {
R.drawable.sample1, R.drawable.sample2, 
R.drawable.sample3, R.drawable.sample4, 
R.drawable.sample5, R.drawable.sample6,
R.drawable.sample7, R.drawable.sample8};
}
