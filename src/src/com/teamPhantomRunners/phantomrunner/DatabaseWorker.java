package com.teamPhantomRunners.phantomrunner;

import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;
import android.content.Context;

public class DatabaseWorker extends SQLiteOpenHelper
{
	 //Database Name 
     private static final String DATABASE_NAME = "Runners.db";
     
     //Database Version
     private static final int DATABASE_VERSION = 1;
     
     //User table information
     private static final String CREATE_USER_TABLE = "CREATE TABLE Users ("
    		 + "Email TEXT PRIMARY KEY," + "Password BLOB NOT NULL," + "Name Text"
    		 + "Age INTEGER," + "Weight INTEGER," + "Height_feet INTEGER,"
    		 + "Height_inches INTEGER)";
     
     private static final String CREATE_RUN_TABLE = "CREATE TABLE Run ("
    		 + "Run_num INTEGER PRIMARY KEY," + "Date TEXT NOT NULL,"
    		 + "Average_Speed INTEGER NOT NULL," + "Speed_units INTEGER NOT NULL,"
    		 + "Distance REAL NOT NULL," + "Distance_units INTEGER,"
    		 + "Time_hours INTEGER NOT NULL," + "Time_min INTEGER NOT NULL,"
    		 + "Time_sec INTEGER NOT NULL," + "Calories INTEGER," + "Top_speed INTEGER)";
     
     
     public DatabaseWorker(Context context)
     {
    	 super(context, DATABASE_NAME, null, DATABASE_VERSION);
     }
     
     
     //Function to create the database if not present and create tables
     @Override
     
     public void onCreate(SQLiteDatabase db)
     {
    	 db.execSQL(CREATE_USER_TABLE);
    	 db.execSQL(CREATE_RUN_TABLE);
     }
     
     //Function to update the database on a new version
     @Override
     
     public void onUpgrade(SQLiteDatabase db, int oldDataBaseVersion, int newDatabaseVersion)
     {
    	 Log.w(DatabaseWorker.class.getName(), "Upgrading database from version "
    			 + oldDataBaseVersion + " to " + newDatabaseVersion 
    			 + "This will destroy all previous information");
    	 
    	 
    	 db.execSQL("DROP TABLE IF EXISTS Users");
    	 db.execSQL("DROP TABLE IF EXISTS Run");
    	 onCreate(db);
     }
     
     /**
      * 
      * @param email the users email used to pick who they are.
      * @return Returns a Cursor that contains the selected users data.
      */
     public User get_user_data(String email)
     {
    	 SQLiteDatabase db = this.getReadableDatabase();
    	 String query  = "SELECT * FROM Users WHERE Email = "
    			 + email;
    	 
    	 Cursor curs  = db.rawQuery(query,null);
    	 
    	 User use = new User();
    	 
    	 use.set_email(curs.getString(0));
    	 use.set_password(curs.getBlob(1));
    	 use.set_name(curs.getString(2));
    	 use.set_age(curs.getInt(3));
    	 use.set_Weight(curs.getInt(4));
    	 use.set_height(curs.getInt(5), curs.getInt(6));
    	 
    	 return use;
     }
     
}
