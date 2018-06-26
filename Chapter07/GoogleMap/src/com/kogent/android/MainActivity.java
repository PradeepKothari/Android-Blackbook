package com.kogent.android;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GoogleMap map;
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
      UiSettings mapSettings;
    mapSettings = map.getUiSettings();
    mapSettings.setZoomControlsEnabled(true);
    map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        LatLng coordinates = new LatLng(28.6100, 77.2300);
        Marker delhi = map.addMarker(new MarkerOptions()
        		    .position(coordinates)
        		    .title("Delhi")
        		    .snippet("State of India: Delhi"));
       }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
