package com.teamPhantomRunners.phantomrunner;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;


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
		//userDatabase = new DatabaseWorker();
	}
	
	public DatabaseWorker getDatabase()
	{
		return userDatabase;
	}
	public User getUserInfo()
	{
		return user;
	}
	
	public Run getCurrentRun()
	{
		return currentRun;
	}
	
	public void updateRun(Run newRun)
	{
		currentRun = newRun;
	}

}
