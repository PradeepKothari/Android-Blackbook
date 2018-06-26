package com.kogent.android;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.Toast;


public class MainActivity extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GridView gridview = (GridView) findViewById(R.id.gridview);
       gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, 
 		long id) {
                Toast.makeText(MainActivity.this, "" + position,Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(gridview);
    }
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }
        public int getCount() {
            return mThumbIds.length;
        }
        public Object getItem(int position) {
            return null;
        }
        public long getItemId(int position) {
            return 0;
        }
        // create a new ImageView 
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {  
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }
        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.sample2, R.drawable.sample3,
                R.drawable.sample4, R.drawable.sample5,
                R.drawable.sample6, R.drawable.sample7,
                R.drawable.sample8, R.drawable.sample1,
                R.drawable.sample2, R.drawable.sample3,
                R.drawable.sample4, R.drawable.sample5,
                R.drawable.sample6, R.drawable.sample7,
                R.drawable.sample8, R.drawable.sample1,
                R.drawable.sample2, R.drawable.sample3,
                R.drawable.sample4, R.drawable.sample5,
                R.drawable.sample6, R.drawable.sample7,
                R.drawable.sample8, R.drawable.sample1
        };
    }


}
