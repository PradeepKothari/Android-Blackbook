package com.kogent.android;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class CreateSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder;
    private SurfaceThread surfaceThread;
    public CreateSurfaceView(Context ctx) {
        super(ctx);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }
    @Override
  public void surfaceChanged(SurfaceHolder sHolder, int format, int width, int height) {
    }
    @Override
    public void surfaceCreated(SurfaceHolder sHolder) {
    	surfaceThread = new SurfaceThread(sHolder);
    	surfaceThread.setRunning(true);
    	surfaceThread.start();
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder sHolder) {
        boolean retry = true;
        surfaceThread.setRunning(false);
        while (retry) {
            try {
            	surfaceThread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }

}
