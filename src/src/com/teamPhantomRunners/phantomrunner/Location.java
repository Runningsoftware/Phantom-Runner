package com.teamPhantomRunners.phantomrunner;

public class Location {
	private long latitude;
	private long longitude;
	
	public Location()
	{
		//Code for current location retrieval
	}
	public Location(long lat, long lon)
	{
		latitude = lat;
		longitude = lon;
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
