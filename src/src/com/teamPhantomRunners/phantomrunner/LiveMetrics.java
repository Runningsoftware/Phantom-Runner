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
		//code to calculate current speed.
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
		return currentCalories;
	}
	
	
	

}
