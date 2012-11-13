package com.teamPhantomRunners.phantomrunner;

import android.content.Context;
import android.location.LocationManager;
import android.location.Location;

public class Tracking {
	private long currentLong;
	private long currentLat;
	private Route currentRoute;
	private LocationManager location;
	
	
	public Tracking(Location location)
	{
		currentRoute = new Route();
		//location = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
	}
	
	public void updateRoute(Location location)
	{
		currentRoute.updateRoute();
	}
	public int getCurrentLat()
	{
		return (int)currentLat;
	}
	public int getCurrentLong()
	{
		return (int)currentLong;
	}
	
	public String getCurrentLocation()
	{
		return currentLat + "," + currentLong;
	}
	

}
