package com.teamPhantomRunners.phantomrunner;
/**
 * This object is responsible for keeping track of the time the user takes to
 * complete a run
 * 
 * @author Ian
 *
 */
public class Stopwatch {

	/** currentTime represents how long the user has been running and will be
	 * displayed on the map
	 */
	private int currentTime;
	
	/**
	 * Class constructor initializes currentTime to zero
	 */
	public Stopwatch(){
		currentTime = 0;
	}
	
	/**
	 * Accessor for currentTime
	 * @return currentTime
	 */
	public int getCurrentTime(){
		return currentTime;
	}
	
	/**
	 * 
	 */
	public void updateTime(){
		
	}
}
