package com.teamPhantomRunners.phantomrunner;

/**
 * This object is responsible for keeping track of the time the user takes to
 * complete a run
 * 
 * @author Ian
 *
 */
public class Stopwatch {

	/**
	 * currentHour, currentMinute and currentSecond represent how long the
	 * user has been running and will be displayed on the map
	 */
	private int currentHour;
	private int currentMinute;
	private int currentSecond;
	
	/**
	 * Class constructor initializes currentTime to zero
	 */
	public Stopwatch(){
		currentHour = 0;
		currentMinute = 0;
		currentSecond = 0;
	}
	
	/**
	 * Accessor for currentTime
	 * @return string representation of currentTime
	 */
	public String getCurrentTime(){
		String s = String.valueOf(currentHour).concat(":").concat
				(String.valueOf(currentMinute)).concat(":").concat
				(String.valueOf(currentSecond));
		return s;
	}
	
	/**
	 * 
	 */
	public void updateTime(){
		/*while(running = true){
			Thread.sleep(1000);
			currentSecond++;
			
			if(currentSecond > 59){
				currentSecond = 0;
				currentMinute++;
				
				if(currentMinute > 59){
					currentMinute = 0;
					currentHour++;
				}
			}
		}*/
	}
}
