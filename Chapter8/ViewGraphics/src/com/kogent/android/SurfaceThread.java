package com.kogent.android;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;


public class SurfaceThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private boolean running = true;
    int i = 0;
    public SurfaceThread(SurfaceHolder holder) {
        this.surfaceHolder = holder;    }
    @Override
    public void run() {
        while(running ) {
            Canvas canvas = null;
            try {
                canvas = surfaceHolder.lockCanvas();
                 synchronized (surfaceHolder) {
                    canvas.drawColor(Color.BLACK);
                    Paint paint = new Paint();
                    paint.setColor(Color.RED);
                    canvas.drawCircle(i++, 100, 50, paint);  }
            }
            finally {
                    if (canvas != null) {
                    	surfaceHolder.unlockCanvasAndPost(canvas);
                        }
            }
        }
    }

    public void setRunning(boolean b) {
        running = b;
    }

}
