package com.teamPhantomRunners.phantomrunner;

import android.location.Location;

public class LocationPR {
	private double latitude;
	private double longitude;
	private long timeStamp;
	
	public LocationPR(Location location)
	{
		latitude = location.getLatitude();
		longitude = location.getLongitude();
		timeStamp = System.currentTimeMillis();
	}
	public LocationPR(long lat, long lon)
	{
		latitude = lat;
		longitude = lon;
	}
	
	public double getLatitude()
	{
		return latitude;
	}
	public double getLongitude()
	{
		return longitude;
	}
	public long getTimeStamp()
	{
		return timeStamp;
	}
	public String toString()
	{
		//comma separated lat and long values as a string
		return "not ready";
	}

}
