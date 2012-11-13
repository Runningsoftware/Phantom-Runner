package com.teamPhantomRunners.phantomrunner;

import android.content.Context;
import android.location.LocationManager;

public class Tracking {
	private long currentLong;
	private long currentLat;
	private Route currentRoute;
	private LocationManager location;
	
	
	public Tracking()
	{
		currentRoute = new Route();
		//location = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
	}
	
	public void updateRoute()
	{
		currentRoute.updateRoute();
	}
	
	public String getCurrentLocation()
	{
		return currentLat + "," + currentLong;
	}
	

}
