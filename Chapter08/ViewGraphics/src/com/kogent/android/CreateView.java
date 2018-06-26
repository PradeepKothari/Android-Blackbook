package com.kogent.android;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;


public class CreateView extends View implements OnTouchListener
{
	private static final String TAG = "CreateView";
	List<Point> pts = new ArrayList<Point>();
	Paint p = new Paint();
	public CreateView(Context context) {
		super(context);
		setFocusable(true);
		setFocusableInTouchMode(true);
		this.setOnTouchListener(this);
		p.setColor(Color.RED);
		p.setAntiAlias(true);
		}
	@Override
	public void onDraw(Canvas c) {
		for (Point point : pts) {
			c.drawCircle(point.i, point.j, 5, p);
			}
		}
	public boolean onTouch(View view, MotionEvent event) {
		Point pt = new Point();
		pt.i = event.getX();
		pt.j = event.getY();
		pts.add(pt);
		invalidate();
		Log.d(TAG, "point: " + pt);
		return true;
		}
	}
class Point 
{
	float i, j;
	@Override
	public String toString() {
		return i + ", " + j;    
		}


}
