package com.teamPhantomRunners.phantomrunner;

public class LocationPR {
	private long latitude;
	private long longitude;
	
	public LocationPR()
	{
		//Code for current location retrieval
	}
	public LocationPR(long lat, long lon)
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
