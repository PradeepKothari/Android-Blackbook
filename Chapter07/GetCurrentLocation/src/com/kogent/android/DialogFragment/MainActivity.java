package com.kogent.android.DialogFragment;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.kogent.android.GetCurrentLocation.R;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener {
	LocationClient mLocationClient;
	private TextView addressLabel;
	private TextView locationLabel;
	private Button getLocationBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		locationLabel = (TextView) findViewById(R.id.locationLabel);
		addressLabel = (TextView) findViewById(R.id.addressLabel);
		getLocationBtn = (Button) findViewById(R.id.getLocation);

		mLocationClient = new LocationClient(this, this, this);

		getLocationBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// mLocationClient.connect();
		Location currentLocation = mLocationClient.getLastLocation();
		String msg = "Current Location: "
				+ Double.toString(currentLocation.getLatitude()) + ","
				+ Double.toString(currentLocation.getLongitude());

		// Display the current location in the UI

		locationLabel.setText(msg);
		Geocoder geocoder = new Geocoder(getApplicationContext(),
				Locale.getDefault());
		List<Address> addresses = null;
		try {
			addresses = geocoder.getFromLocation(
					currentLocation.getLatitude(),
					currentLocation.getLongitude(), 1);
		} catch (IOException e1) {
			Log.e("LocationSampleActivity",
					"IO Exception in getFromLocation()");
			e1.printStackTrace();
		} catch (IllegalArgumentException e2) {
			// Error message to post in the log
			String errorString = "Illegal arguments "
					+ Double.toString(currentLocation.getLatitude())
					+ " , "
					+ Double.toString(currentLocation.getLongitude())
					+ " passed to address service";
			Log.e("LocationSampleActivity", errorString);
			e2.printStackTrace();
		}
		// If the reverse geocode returned an address
		if (addresses != null && addresses.size() > 0) {
			// Get the first address
			Address address = addresses.get(0);
			/*
			 * Format the first line of address (if available), city,
			 * and country name.
			 */
			String addressText = String.format(
					"%s, %s, %s",
					// If there's a street address, add it
					address.getMaxAddressLineIndex() > 0 ? address
							.getAddressLine(0) : "",
							// Locality is usually a city
							address.getLocality(),
							// The country of the address
							address.getCountryName());
			// Return the text
				addressLabel.setText(addressText);
			}
		}
	});

}// AsyncTask class

@Override
protected void onStart() {
	super.onStart();
	// Connect the client.
mLocationClient.connect();
locationLabel.setText("connected....");
}

@Override
public void onConnectionFailed(ConnectionResult arg0) {
	// TODO Auto-generated method stub
Toast.makeText(this, "Connection Failure :", Toast.LENGTH_SHORT).show();
}

@Override
public void onConnected(Bundle arg0) {
	// TODO Auto-generated method stub
Toast.makeText(this, "Connection Connected", Toast.LENGTH_SHORT).show();
}

@Override
public void onDisconnected() {
	// TODO Auto-generated method stub
Toast.makeText(this, "Connection Disconnecteded. Please re-connect.",
				Toast.LENGTH_SHORT).show();
	}
}