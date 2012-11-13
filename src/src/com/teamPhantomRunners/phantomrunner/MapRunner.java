package com.teamPhantomRunners.phantomrunner;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class MapRunner extends MapActivity {
	LocationManager locationManager;
	LocationProvider locationProvider;
	LocationListener locationListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getActionBar().setDisplayHomeAsUpEnabled(true); 
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
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

}
