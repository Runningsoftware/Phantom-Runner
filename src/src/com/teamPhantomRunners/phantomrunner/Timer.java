<<<<<<< HEAD
package com.teamPhantomRunners.phantomrunner;

/**
 * This object is preloaded with a given time and counts down while the user is
 * running and notifies the system when the timer runs out
 * 
 * @author Ian
 *
 */
public class Timer {

	/**
	 * hoursLeft, minutesLeft and secondsLeft represent how much time the user
	 * has left to complete their run and will be displayed on the map
	 * 
	 * negative indicates whether or not the user has run for longer than the
	 * time allotted by the challenge
	 */
	private int hoursLeft;
	private int minutesLeft;
	private int secondsLeft;
	private boolean negative;
	
	/**
	 * Class constructor initializes timeLeft according to the parameter
	 * 
	 * @param timeLimit
	 */
	public Timer(int hourLimit, int minuteLimit, int secondLimit){
		hoursLeft = hourLimit;
		minutesLeft = minuteLimit;
		secondsLeft = secondLimit;
		negative = false;
	}
	
	/**
	 * Accessor for timeLeft
	 * @return string representation of timeLeft
	 */
	public String getCurrentTime(){
		if(negative = false){
			String s = String.valueOf(hoursLeft).concat(":").concat
					(String.valueOf(minutesLeft)).concat(":").concat
					(String.valueOf(secondsLeft));
			
			return s;
		}
		else{
			String s = "-".concat(String.valueOf(hoursLeft).concat(":").concat
					(String.valueOf(minutesLeft)).concat(":").concat
					(String.valueOf(secondsLeft)));
			
			return s;
		}
	}
	
	/**
	 * 
	 */
	public void updateTime(){
		/*while(running = true){
			Thread.sleep(1000);
			secondsLeft--;
			
			if(secondsLeft < 0){
				secondsLeft = 59;
				minutesLeft--;
				
				if(minutesLeft < 0){
					minutesLeft = 59;
					hoursLeft--;
					
					if(hoursLeft < 0){
						this.updateTimeNegative();
						break;
					}
				}
			}
		}*/
	}
	
	public void updateTimeNegative(){
		negative = true;
		
		/*while(running = true){
			Thread.sleep(1000);
			secondsLeft++;
			
			if(secondsLeft > 59){
				secondsLeft = 0;
				minutesLeft++;
				
				if(minutesLeft > 59){
					minutesLeft = 0;
					hoursLeft++;
				}
			}
		}*/
	}
}
=======
package com.teamPhantomRunners.phantomrunner;

/**
 * This object is preloaded with a given time and counts down while the user is
 * running and notifies the system when the timer runs out
 * 
 * @author Ian
 *
 */
public class Timer {

	/**
	 * hoursLeft, minutesLeft and secondsLeft represent how much time the user
	 * has left to complete their run and will be displayed on the map
	 * 
	 * negative indicates whether or not the user has run for longer than the
	 * time allotted by the challenge
	 * 
	 * hoursTotal, minutesTotal and secondsTotal represent how long the user
	 * has been running.
	 */
	private int hoursLeft;
	private int minutesLeft;
	private int secondsLeft;
	private boolean negative;
	private int hoursTotal;
	private int minutesTotal;
	private int secondsTotal;
	
	/**
	 * Class constructor initializes timeLeft according to the parameter
	 * 
	 * @param hourLimit
	 * @param minuteLimit
	 * @param secondLimit
	 */
	public Timer(int hourLimit, int minuteLimit, int secondLimit){
		hoursLeft = hourLimit;
		minutesLeft = minuteLimit;
		secondsLeft = secondLimit;
		negative = false;
		hoursTotal = 0;
		minutesTotal = 0;
		secondsTotal = 0;
	}
	
	/**
	 * Accessor for timeTotal
	 * @return string representation of timeTotal
	 */
	public String getTimeTotal(){
		String s = String.valueOf(hoursTotal).concat(":").concat
				(String.valueOf(minutesTotal)).concat(":").concat
				(String.valueOf(secondsTotal));
		return s;
	}
	
	/**
	 * Accessor for timeLeft
	 * @return string representation of timeLeft
	 */
	public String getCurrentTime(){
		if(negative == false){
			String s = String.valueOf(hoursLeft).concat(":").concat
					(String.valueOf(minutesLeft)).concat(":").concat
					(String.valueOf(secondsLeft));
			
			return s;
		}
		else{
			String s = "-".concat(String.valueOf(hoursLeft).concat(":").concat
					(String.valueOf(minutesLeft)).concat(":").concat
					(String.valueOf(secondsLeft)));
			
			return s;
		}
	}
	
	/**
	 * 
	 */
	public void updateTime(){
		if(negative == false){
			secondsLeft--;
			
			if(secondsLeft < 0){
				secondsLeft = 59;
				minutesLeft--;
				
				if(minutesLeft < 0){
					minutesLeft = 59;
					hoursLeft--;
					
					if(hoursLeft < 0){
						negative = true;
						hoursLeft = 0;
						minutesLeft = 0;
						secondsLeft = 1;
					}
				}
			}
		}
		else{
			secondsLeft++;
			
			if(secondsLeft > 59){
				secondsLeft = 0;
				minutesLeft++;
				
				if(minutesLeft > 59){
					minutesLeft = 0;
					hoursLeft++;
				}
			}
		}
		
		secondsTotal++;
		
		if(secondsTotal > 59){
			secondsTotal = 0;
			minutesTotal++;
			
			if(minutesTotal > 59){
				minutesTotal = 0;
				hoursTotal++;
			}
		}
	}
}
>>>>>>> Here are my completed classes.
