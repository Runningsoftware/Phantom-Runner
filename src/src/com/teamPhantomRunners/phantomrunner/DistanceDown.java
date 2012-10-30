package com.teamPhantomRunners.phantomrunner;

/**
 * This class instance object is loaded with a preset distance and as the user
 * travels the distance is subtracted until it reaches zero and notifies the
 * system
 * 
 * @author Ian
 *
 */
public class DistanceDown {

	/**
	 * distanceLeft represents how far the user has run and will be
	 * displayed on the map
	 */
	private int distanceLeft;
	
	/**
	 * Class constructor initializes currentDistance according to the parameter
	 */
	public DistanceDown(int goal){
		distanceLeft = goal;
	}
	
	/**
	 * Accessor for distanceLeft
	 * @return currentDistance
	 */
	public int getDistance(){
		return distanceLeft;
	}
	
	/**
	 * 
	 * @param location1
	 * @param location2
	 */
	public void removeDistance(Route location1, Route location2){
		//distanceLeft = distanceLeft - ();
	}
}
