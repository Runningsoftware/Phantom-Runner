package com.teamPhantomRunners.phantomrunner;

import java.util.LinkedList;

import android.location.Location;


public class Route {
	private LinkedList<LocationPR> route;
	private int lastLocationIndex;
	
	
	public Route(Location location)
	{
		route = new LinkedList<LocationPR>();
		route.add(new LocationPR(location));
		lastLocationIndex = 0;
		
	}
	
	public void updateRoute(Location location)
	{
		lastLocationIndex++;
		route.add(new LocationPR(location));
	}
		
	public double getCurrentLat()
	{
		return route.get(lastLocationIndex).getLatitude();
	}
	public double getCurrentLong()
	{
		return route.get(lastLocationIndex).getLongitude();
	}
	
	public double getPreviousLat()
	{
		if (lastLocationIndex > 0)
			return route.get(lastLocationIndex-1).getLatitude();
		else
			return getCurrentLat();
	}
	public double getPreviousLong()
	{
		if (lastLocationIndex > 0)
			return route.get(lastLocationIndex-1).getLongitude();
		else
			return getCurrentLong();
	}
	
	public double getStartLat()
	{
		if(this.route.isEmpty())
			return -1;
		
		return route.getFirst().getLatitude();
	}
	
	public double getStartLon()
	{
		if(this.route.isEmpty())
			return -1;
		
		return route.getFirst().getLongitude();
	}
	
	public String getRoute()
	{
		//code for the route as a string
		return "not ready";
	}
	
}
