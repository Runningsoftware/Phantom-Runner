package com.teamPhantomRunners.phantomrunner;

public class LiveMetrics {
	private int currentSpeed;
	private int currentCalories;
	private int avgSpeed;
	
	
	public LiveMetrics()
	{
		currentSpeed = 0;
		currentCalories = 0;
		avgSpeed = 0;
	}
	
	public int getCurrentSpeed(Route curRoute)
	{
		double distance = getDistance(curRoute.getPreviousLat(), curRoute.getCurrentLat(), curRoute.getPreviousLong(), curRoute.getCurrentLong());
		int time = 0;
		
		this.currentSpeed = (int)(distance/time);
		
		return currentSpeed;
	}
	
	public int getAverageSpeed(Route curRoute)
	{
		//code to calculate average speed
		return avgSpeed;
	}
	
	public int getCurrentCalories(Route curRoute, User usr)
	{
		//code to calculate calories .73*weight*distance(miles)
		this.currentCalories = (int)(.73 * usr.get_Weight() * Utilities.kmToMiles(this.getTotalDistance(curRoute)));
		
		return currentCalories;
	}
	
	public double getTotalDistance(Route curRoute)
	{
		return getDistance(curRoute.getStartLat(), curRoute.getCurrentLat(), curRoute.getStartLon(), curRoute.getCurrentLong());
	}
	
	public double getDistance(double latitude1, double latitude2, double longitude1, double longitude2)
	{
		//In order to use trig functions everything has to be in Radians
				double lat1 = Math.toRadians(latitude1);
				double lat2 = Math.toRadians(latitude2);
				double long1 = Math.toRadians(longitude1);
				double long2 = Math.toRadians(longitude2);
				
				//Distance in KM
				return Math.acos(Math.sin(lat1) * Math.sin(lat2)
						+ Math.cos(lat1) * Math.cos(lat2)
						* Math.cos(long2-long1)) * 6371;
	}
	
	public double getLastDistance(Route curRoute)
	{
		return getDistance(curRoute.getPreviousLat(), curRoute.getCurrentLat(), curRoute.getPreviousLong(), curRoute.getCurrentLong());
	}
	
	
	

}
