package com.teamPhantomRunners.phantomrunner;

import java.util.Calendar;
import java.util.Date;

public class Run 
{
	private double average_speed;
	private String speed_units;
	private double distance;
	private String distance_units;
	private int time_hours;
	private int time_min;
	private int time_sec;
	private int calories;
	private int top_speed;
	private String run_date;
	
	public Run()
	{
		average_speed = 0.0;
		speed_units = "mph";
		distance = 0.0;
		distance_units = "m";
		time_hours = 0;
		time_min = 0;
		time_sec = 0;
		calories = 0;
		top_speed = 0;
		Calendar newDay = Calendar.getInstance();
		run_date = Integer.toString(newDay.get(Calendar.MONTH)) + "/" + 
				Integer.toString(newDay.get(Calendar.DATE)) + "/" + 
				Integer.toString(newDay.get(Calendar.YEAR));
	}
	public double getAverage_speed() {
		return average_speed;
	}
	public void setAverage_speed(double average_speed) {
		this.average_speed = average_speed;
	}
	public String getSpeed_units() {
		return speed_units;
	}
	public void setSpeed_units(String speed_units) {
		this.speed_units = speed_units;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getDistance_units() {
		return distance_units;
	}
	public void setDistance_units(String distance_units) {
		this.distance_units = distance_units;
	}
	public int getTime_hours() {
		return time_hours;
	}
	public void setTime_hours(int time_hours) {
		this.time_hours = time_hours;
	}
	public int getTime_min() {
		return time_min;
	}
	public void setTime_min(int time_min) {
		this.time_min = time_min;
	}
	public int getTime_sec() {
		return time_sec;
	}
	public void setTime_sec(int time_sec) {
		this.time_sec = time_sec;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getTop_speed() {
		return top_speed;
	}
	public void setTop_speed(int top_speed) {
		this.top_speed = top_speed;
	}
	public String getDate() {
		return run_date;
	}
	public void setDate(String date) {
		run_date = date;
	}

	
	
	
}