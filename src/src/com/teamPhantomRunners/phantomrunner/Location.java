package com.teamPhantomRunners.phantomrunner;

public class Location {
	private long latitude;
	private long longitude;
	
	public Location()
	{
		//Code for initial location retrieval
	}
	
	public static void updateLocation()
	{
		//code to get new location from the GPS
	}
	
	public long getLatitude()
	{
		return latitude;
	}
	public long getLongitude()
	{
		return longitude;
	}
	public String toString()
	{
		//comma separated lat and long values as a string
		return "not ready";
	}

}
