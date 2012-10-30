package com.teamPhantomRunners.phantomrunner;
/**
 * This object is preloaded with a given time and counts down while the user is
 * running and notifies the system when the timer runs out
 * 
 * @author Ian
 *
 */
public class Timer {

	/** timeLeft represents how much time the user has left to complete their
	 * run and will be displayed on the map
	 */
	private int timeLeft;
	
	/**
	 * Class constructor initializes timeLeft according to the parameter
	 * 
	 * @param timeLimit
	 */
	public Timer(int timeLimit){
		timeLeft = timeLimit;
	}
	
	/**
	 * Accessor for timeLeft
	 * @return timeLeft
	 */
	public int getTimeLeft(){
		return timeLeft;
	}
	
	/**
	 * 
	 */
	public void updateTime(){
		
	}
}
