package com.teamPhantomRunners.phantomrunner;

public class Tracking {
	private long currentLong;
	private long currentLat;
	private Route currentRoute;
	private LiveMetrics metrics;
	
	public Tracking()
	{
		//code to initialize gps
		currentRoute = new Route();
		metrics = new LiveMetrics();
	}

}
