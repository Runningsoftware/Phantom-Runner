package com.teamPhantomRunners.phantomrunner;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class MapRunner extends MapActivity {
	private LocationManager locationManager;
	private LocationProvider locationProvider;
	private LocationListener locationListener;
	private Tracking tracker;
	private MapView mapView;
	private List<Overlay> mapOverlays;
	private MapOverlayItems itemizedOverlay;
	private OverlayItem locationPoint;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getActionBar().setDisplayHomeAsUpEnabled(true); 
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationProvider = locationManager.getProvider(LocationManager.GPS_PROVIDER);
        tracker = new Tracking(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));
        mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        itemizedOverlay = new MapOverlayItems(drawable,this);   
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_map, menu);
        return true;
    }
 
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected boolean isRouteDisplayed() {
        return false;
        
    }
    
    @Override
    protected void onStart()
    {
    	super.onStart();
    	final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    	
    	if(!gpsEnabled)
    	{
    		//alert dialog to enable gps
    	}
    	
    	locationListener = new LocationListener()
    	{
			public void onLocationChanged(android.location.Location location) {
				
				
			}

			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}
    	};
    	
    	GeoPoint place = new GeoPoint(tracker.getCurrentLat(), tracker.getCurrentLong());
        locationPoint = new OverlayItem(place, null, null);
        
        itemizedOverlay.addOverlay(locationPoint);
        mapOverlays.add(itemizedOverlay);
    }
    private void enableLocationSettings()
    {
    	Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    	startActivity(settingsIntent);
    }
    
    protected void onStop()
    {
    	super.onStop();
    	locationManager.removeUpdates(locationListener);
    }

}
