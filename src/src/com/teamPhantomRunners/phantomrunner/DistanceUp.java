package com.teamPhantomRunners.phantomrunner;

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
	private int currentDistance;
	
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
	public int getDistance(){
		return currentDistance;
	}
	
	/**
	 * 
	 * @param location1
	 * @param location2
	 */
	public void addDistance(Route location1, Route location2){
		//currentDistance = currentDistance + ();
	}
}
