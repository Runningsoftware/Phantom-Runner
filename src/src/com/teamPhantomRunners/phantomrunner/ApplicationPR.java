package com.teamPhantomRunners.phantomrunner;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;


public class ApplicationPR extends Application {

	private DatabaseWorker userDatabase;
	private User user;
	
	public ApplicationPR() {
		// TODO Auto-generated constructor stub
	}
	
	public void onCreate()
	{
		super.onCreate();
		user = new User();
		userDatabase = new DatabaseWorker(this.getBaseContext());
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

}
