package com.teamPhantomRunners.phantomrunner;

import android.content.Context;
import android.location.LocationManager;
import android.location.Location;
/**
 * Class to handle the calculation of data in Route
 * @author Andrew
 *
 */
public class Tracking {
	private long currentLong;
	private long currentLat;
	private Route currentRoute;
	private LocationManager location;
	
	
	public Tracking(Location location)
	{
		currentRoute = new Route(location);
		currentRoute.updateRoute(location);
	}
	
	public void updateRoute(Location location)
	{
		currentRoute.updateRoute(location);
	}
	public int getCurrentLat()
	{
		return (int) (currentRoute.getCurrentLat() * 1E6);
	}
	public int getCurrentLong()
	{
		return (int) (currentRoute.getCurrentLong() * 1E6);
	}
	
	public Route getRoute()
	{
		return currentRoute;
	}
	
	public String getCurrentLocation()
	{
		return currentLat + "," + currentLong;
	}
	

}
