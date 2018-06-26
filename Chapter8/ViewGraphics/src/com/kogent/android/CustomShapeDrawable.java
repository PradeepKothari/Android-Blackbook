package com.kogent.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;


public class CustomShapeDrawable extends View
{
	private ShapeDrawable sDrawable;
	public CustomShapeDrawable(Context ctx) {
		super(ctx);
		int i = 50;
		int j = 50;
		int width = 700;
		int height = 350;
		sDrawable = new ShapeDrawable(new OvalShape());
		sDrawable.getPaint().setColor(0xff0000ff);
		sDrawable.setBounds(i, j, i+width, j+height);	}
protected void onDraw(Canvas c)
{
	sDrawable.draw(c);}
}



