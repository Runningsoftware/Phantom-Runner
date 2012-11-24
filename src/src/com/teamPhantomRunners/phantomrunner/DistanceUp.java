package com.teamPhantomRunners.phantomrunner;

import java.lang.Math;

/**
 * This class keeps track of the total distance the user travels while running
 * 
 * @author Ian
 *
 */
public class DistanceUp {

	/**
	 * currentDistance represents how far the user has run and will be
	 * displayed on the map
	 */
	private double currentDistance;
	
	/**
	 * Class constructor initializes currentDistance to zero
	 */
	public DistanceUp(){
		currentDistance = 0;
	}
	
	/**
	 * Accessor for currentDistance
	 * @return currentDistance
	 */
	public double getDistance(){
		return currentDistance;
	}
	
	/**
	 * Calculates how far the user has run every time the GPS returns the users
	 * current coordinates.
	 * 
	 *  Uses the haversin formula
	 *  
	 *  @param Route locale
	 */
	public void addDistance(Route locale){
		
		int R = 6371; // km
		
		double lat1, lat2, lon1, lon2;
		
		lat1 = locale.getPreviousLat();
		lat2 = locale.getCurrentLat();
		lon1 = locale.getPreviousLong();
		lon2 = locale.getCurrentLong();
		
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
				   Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		double d = R*c;
		
		currentDistance = currentDistance + d;
	}
}
