package com.teamPhantomRunners.phantomrunner;

public class Tracking {
	private long currentLong;
	private long currentLat;
	private Route currentRoute;
	
	
	public Tracking()
	{
		currentRoute = new Route();
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
