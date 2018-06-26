package com.kogent.android.captureimage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements SurfaceHolder.Callback{

	Camera devicecamera;
	SurfaceView mySurfaceView;
	SurfaceHolder holder;
	LayoutInflater layoutInflater = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        getWindow().setFormat(PixelFormat.UNKNOWN);
        mySurfaceView = (SurfaceView)findViewById(R.id.preview);
        holder = mySurfaceView.getHolder();
        holder.addCallback(this);
        layoutInflater = LayoutInflater.from(getBaseContext());
        View view = layoutInflater.inflate(R.layout.control, null);
        LayoutParams layoutparams 
        	= new LayoutParams(LayoutParams.MATCH_PARENT, 
        	LayoutParams.MATCH_PARENT);
        this.addContentView(view, layoutparams );
        
        Button buttonTakePicture = (Button)findViewById(R.id.clickimage);
        buttonTakePicture.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
	
				devicecamera.takePicture(mShutterCallback, 
						mPictureCallback, mPictureCallback_JPG);
			}});
    }
    
    ShutterCallback mShutterCallback = new ShutterCallback(){

		@Override
		public void onShutter() {
	
			
		}};
		
	PictureCallback mPictureCallback = new PictureCallback(){

		@Override
		public void onPictureTaken(byte[] arg0, Camera arg1) {
			
		}};
		
	PictureCallback mPictureCallback_JPG = new PictureCallback(){

		@Override
		public void onPictureTaken(byte[] arg0, Camera arg1) {			
			File sdDir =new File( Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"CaptureImage");
			 if (!sdDir.exists()) 
		            if (!sdDir.mkdirs()) {
		                Log.d("MyCameraApp", "failed to create directory");
		                return;	
		            }
			File Image=new File (sdDir.getPath()+"/newimage.png");
			 
			try {
                FileOutputStream fos = new FileOutputStream(Image);
                fos.write(arg0);
                fos.close();
                Toast.makeText(getApplicationContext(), "Image saved successfully",
        				Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {
            }
		}};

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		try {
			devicecamera.setPreviewDisplay(holder);
			devicecamera.startPreview();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		devicecamera = Camera.open();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		devicecamera.stopPreview();
		devicecamera.release();

	}
}