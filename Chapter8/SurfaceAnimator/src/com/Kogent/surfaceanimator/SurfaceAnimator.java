package com.Kogent.surfaceanimator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.app.Activity;
import android.view.Menu;

public class SurfaceAnimator extends Activity implements OnTouchListener {

	MineSurface ourSurfaceView;
    float x, y;
     
    protected void onCreate(Bundle b){
        super.onCreate(b);
        ourSurfaceView = new MineSurface(this);
        ourSurfaceView.setOnTouchListener(this);
        setContentView(ourSurfaceView);
         
    }
     
    protected void onPause(){
        super.onPause();
        ourSurfaceView.pause();
         
    }
    protected void onResume(){
        super.onResume();
        ourSurfaceView.resume();
    }
     
    public class MineSurface extends SurfaceView implements Runnable{
         
        SurfaceHolder ourHolder;
        Thread ourThread;
        boolean isRunning = false;
        Bitmap gball;
         
        public MineSurface(Context context){
            super(context);
             
            ourHolder = getHolder();
            gball = BitmapFactory.decodeResource(getResources(), R.drawable.round);
           
            x = 0;
            y = 0;
             
                     
        }
         
        public void run(){
            while(isRunning){
                if(!ourHolder.getSurface().isValid())
                    continue;
                Canvas canvas = ourHolder.lockCanvas();
                canvas.drawColor(Color.WHITE);
                if(x != 0 && y != 0)
                    canvas.drawBitmap(gball, x - gball.getWidth()/2, y - gball.getHeight()/2, null);
                ourHolder.unlockCanvasAndPost(canvas);
                 
            }
             
        }
        public void pause(){
            isRunning = false;
            while(true){
                try {
                    ourThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                 
                break;
            }
            ourThread = null;
             
        }
        public void resume(){
            isRunning = true;
            ourThread = new Thread(this);
            ourThread.start();
        }
    }
 
    public boolean onTouch(View view, MotionEvent event) {
         
            x = event.getX();
            y = event.getY();
             
        return true;
    }
 
}