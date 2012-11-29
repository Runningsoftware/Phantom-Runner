package com.teamPhantomRunners.phantomrunner;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Extends Application class for variables and methods that need to be accessed across the multiple views
 * @author Andrew
 *
 */
public class ApplicationPR extends Application {

	private DatabaseWorker userDatabase;
	private User user;
	private Run currentRun;
	
	public ApplicationPR() {
		// TODO Auto-generated constructor stub
	}
	
	public void onCreate()
	{
		super.onCreate();
		userDatabase = new DatabaseWorker(this.getBaseContext());
		user = new User();
		currentRun = new Run();
	}
	
	/**
	 * Access to the database
	 * @return DatabaseWorker
	 */
	public DatabaseWorker getDatabase()
	{
		return userDatabase;
	}
	/**
	 * Hold the user information for the calories calculation
	 * @return User
	 */
	public User getUserInfo()
	{
		return user;
	}
	/**
	 * Holds the Current Run metrics 
	 * @return Run
	 */
	public Run getCurrentRun()
	{
		return currentRun;
	}
	/**
	 * Update the Run for passing to the log view
	 * @param newRun
	 */
	public void updateRun(Run newRun)
	{
		currentRun = newRun;
	}

}
