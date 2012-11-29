package com.teamPhantomRunners.phantomrunner;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.content.Intent;
import android.graphics.drawable.Drawable;
/**
 * Main map view for showing the current track and updating the navigation information
 * @author Andrew
 *
 */
public class MapRunner extends MapActivity {
	private LocationManager locationManager;		//GPS Manager for the location information
	private LocationProvider locationProvider;		//Unused currently
	private LocationListener locationListener;		//Listens for the GPS Location to change
	private Tracking tracker;						//Stores the GPS information
	private MapView mapView;						//The map view data for overlay items
	private MapController mapController;			//The required controller for the map
	private List<Overlay> mapOverlays;				//The list of Overlays for the Map View
	private MapOverlayItems itemizedOverlay;		//The items on the overlay
	private OverlayItem locationPoint;				//The loacation point
	private Location curLocation;					//Current Location information
	private boolean locationAvailable = true;		//Unused boolean depricated
	private boolean onPause = false;					//Flag for the location when the user presses pause
	private Run currentRun;				//Holder for the current run
	private DistanceUp currentDistCalc = new DistanceUp();		//Increments the distance on the fly
	private ApplicationPR appController; 			//Controller for global Application data
	private double avgSpeed = 0.0;					//Average Speed holder
	private long timeHolder = 0;					//Total time holder
	public final static String EXTRA_MESSAGE = "com.example.PhantomRunner.MESSAGE";
	@Override
    /**
     * The method that happens when the view first gets created. 
     */
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        
        
        getActionBar().setDisplayHomeAsUpEnabled(true); 
        
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(false);
        mapController = mapView.getController();
        mapController.setZoom(18);      
        appController = (ApplicationPR)getApplicationContext();
        currentRun = appController.getCurrentRun();
        registerLocationListeners();				//Start tracking processes
        
    }
    
    /**
     * Location Tracking start up method.
     */
    private void registerLocationListeners(){
    	
    	//Assign the location manager to a variable for use
    	locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
    	
    	//Set up the type of criteria needed. In this case GPS only
    	Criteria fine = new Criteria();
    	fine.setAccuracy(Criteria.ACCURACY_FINE);
    	
    	//Get the last known location in order to get started faster.
    	curLocation = locationManager.getLastKnownLocation(locationManager.getBestProvider(fine, true));
    	
        
    	if(locationListener == null)
    		createLocationListener();
    	
    	locationManager.requestLocationUpdates(locationManager.getBestProvider(fine, true),500,50,locationListener);
    	
    
	}
    private void createLocationListener() 
    {
    	//locationProvider = locationManager.getProvider(LocationManager.GPS_PROVIDER); 
        locationListener = new LocationListener()
        {
        	public void onLocationChanged(Location location) {
        		curLocation = location;
        		if(location.getAccuracy() > 1000 && location.hasAccuracy())
        			locationManager.removeUpdates(this);
                
        		if(!onPause)
        		{
        			//Update the navigation information for use by the metrics analysis classes
        			if(tracker != null)
        				tracker.updateRoute(curLocation);
        			else
        				tracker = new Tracking(curLocation);
                
        			GeoPoint place = new GeoPoint(tracker.getCurrentLat(), tracker.getCurrentLong());
          
        			locationPoint = new OverlayItem(place, null, null);
                
        			itemizedOverlay.addOverlay(locationPoint);
        			mapOverlays.add(itemizedOverlay);
                
        			mapController.animateTo(place);
        			
        			currentDistCalc.addDistance(tracker.getRoute());
        			//Update onscreen metrics
        			double dist = (Math.round(currentDistCalc.getDistance()*1000))/10.0;
        			((TextView)findViewById(R.id.distanceText)).setText(Double.toString(dist) + " m");
        			timeHolder = tracker.getRoute().getTime();
        			((TextView)findViewById(R.id.time_run)).setText(Long.toString(timeHolder) +" s");
        			avgSpeed = Math.round((dist/timeHolder)*1000.0)/1000.0;
        			((TextView)findViewById(R.id.avgSpeed_txt)).setText(Double.toString(avgSpeed)+ " m/s");
        		}else
        		{
        			//Navigate to the current location while paused without updating the route
        			GeoPoint place = new GeoPoint((int)(curLocation.getLatitude()*1E6),(int)(curLocation.getLongitude()*1E6));
        			
        			mapController.animateTo(place);
        		}
        		
        	}

        	public void onProviderDisabled(String provider) {
        		// TODO Auto-generated method stub
        		
        	}

        	public void onProviderEnabled(String provider) {
        		// TODO Auto-generated method stub
        		
        	}

        	public void onStatusChanged(String provider, int status,
        			Bundle extras) 
        	{
        		switch(status)
        		{
        		case LocationProvider.OUT_OF_SERVICE:
        		case LocationProvider.TEMPORARILY_UNAVAILABLE:
        			locationAvailable = false;
        			break;
        		case LocationProvider.AVAILABLE:
        			locationAvailable = true;
        		
        		}
        	}
        };
        
        if(curLocation == null)
        {
        	//locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 1, locationListener);
        	curLocation = new Location(LocationManager.GPS_PROVIDER);
        	
        }
        
	
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
    	//Code to enable the GPS if turned off. Not quite working right
    	if(!gpsEnabled)
    	{
    		AlertDialog.Builder dialog = new AlertDialog.Builder(getBaseContext());
    		dialog.setTitle("Enable GPS");
    		dialog.setMessage("Would you like to enable the GPS?");
    		dialog.show();
    		enableLocationSettings();
    		
    	}
    	//Initialize the Location Manager to update every half second and every meter at a minimum.
    	locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 1, locationListener);
    	
    	//Get the Last known good location to start tracking faster
    	Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        
    	if(lastLocation != null)
    		tracker = new Tracking(lastLocation);
    	else{
    		while(curLocation == null)
    			{
    			 
    			}
    		
    		tracker = new Tracking(curLocation);
    	}
    	//Initialize the ovrlay for drawing dots at gps locations
        mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.runner_blue_dot);
        
        itemizedOverlay = new MapOverlayItems(drawable,this);
    	
    	GeoPoint place = new GeoPoint(tracker.getCurrentLat(), tracker.getCurrentLong());
        locationPoint = new OverlayItem(place, null, null);
        
        itemizedOverlay.addOverlay(locationPoint);
        mapOverlays.add(itemizedOverlay);
        //Move the app to the current gps location
        mapController.animateTo(place);
    }
    
    //Enable the ability to query the GPS
    private void enableLocationSettings()
    {
    	Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    	startActivity(settingsIntent);
    }
    
    //Stop querying the GPS when the view is closed
    protected void onStop()
    {
    	super.onStop();
    	locationManager.removeUpdates(locationListener);
    }
    
    //Flag to stop updating route information
    public void onPauseSwitch(View view)
    {
    	onPause = !onPause;
    	
    }
    
    /*
     * Code for what happens when the Stop Button is pressed
     */
    public void onStopPressed(View view)
    {
    	//Code to stop updating and save the metrics and information from the current run
    	onPauseSwitch(view);
    	if(tracker != null)
    	{
    		LiveMetrics metrics = new LiveMetrics();									//Metric Calculations
    		User tempUser = hardUser();													//Static user for testing
    		int calories = metrics.getCurrentCalories(tracker.getRoute(), tempUser);	//Calculate the Calories burned
    		
    		//Finalize the current run data
    		currentRun.setDistance(currentDistCalc.getDistance());
    		currentRun.setAverage_speed(avgSpeed);
    		currentRun.setTime_hours(((int)timeHolder)/3600);
    		currentRun.setTime_min((((int)timeHolder)%3600)/60);
    		currentRun.setTime_sec(((int)timeHolder)%60);
    		currentRun.setCalories(calories);
    		
    		appController.updateRun(currentRun);
    		
    		//Launch the Metric display view
    		Intent intentUser = new Intent(MapRunner.this, RunLogActivity.class);
    		
    		intentUser.putExtra(EXTRA_MESSAGE, R.string.menu_run);

    		startActivity(intentUser);
    	}    	
    }
    /**
     * Hard coded User for testing without the complete database connections
     * @return User
     */
    private User hardUser()
    {
    	User temp = new User();
    	temp.set_age(35);
    	temp.set_email("andvan@knights.ucf.edu");
    	temp.set_height(6,0);
    	temp.set_name("Andrew VanDemark");
    	temp.set_password("andvan");
    	temp.set_Weight(205);
    	
    	return temp;
    }
    

}

