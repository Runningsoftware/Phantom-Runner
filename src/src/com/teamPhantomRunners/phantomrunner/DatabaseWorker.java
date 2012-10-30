package com.teamPhantomRunners.phantomrunner;

import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;
import android.content.ContentValues;
import android.content.Context;

public class DatabaseWorker extends SQLiteOpenHelper
{
	//--------- Begin Table and Column names ------------
	//Work damn you.
	//Run Table
	  private static final String Run_Table = "Run";
	  private static final String Run_num = "Run_num";
	  private static final String Date = "Date";
	  private static final String Average_Speed = "Average_Speed";
	  private static final String Speed_Units = "Speed_Units";
	  private static final String Distance = "Distance";
	  private static final String Distance_Units = "Distance_Units";
	  private static final String Time_Hours = "Time_Hours";
	  private static final String Time_Min = "Time_Min";
	  private static final String Time_Sec = "Time_Sec";
	  private static final String Calories = "Calories";
	  private static final String Top_Speed = "Top_Speed";
	
	//User Table
	  private static final String Users_Table = "Users";
	  private static final String Email = "Email";
	  private static final String Password = "Password";
	  private static final String Name = "Name";
	  private static final String Age = "Age";
	  private static final String Weight = "Weight";
	  private static final String Height_Feet = "Height_Feet";
	  private static final String Height_Inches = "Height_Inches";
	
	
	 //Database Name 
     private static final String DATABASE_NAME = "Runners.db";
     
     //Database Version
     private static final int DATABASE_VERSION = 1;
     
     //User table information
     private static final String CREATE_USER_TABLE = "CREATE TABLE" + Users_Table + "("
    		 + Email + "TEXT PRIMARY KEY," + Password + "BLOB NOT NULL," + Name + "Text"
    		 + Age + "INTEGER," + Weight + "INTEGER," + Height_Feet + "INTEGER,"
    		 + Height_Inches + "INTEGER)";
     
     //Run table information
     private static final String CREATE_RUN_TABLE = "CREATE TABLE" + Run_Table + "("
    		 + Run_num + "INTEGER PRIMARY KEY," + Date + "TEXT NOT NULL,"
    		 + Average_Speed + "INTEGER NOT NULL," + Speed_Units + "INTEGER NOT NULL,"
    		 + Distance + "REAL NOT NULL," + Distance_Units + "INTEGER,"
    		 + Time_Hours + "INTEGER NOT NULL," + Time_Min + "INTEGER NOT NULL,"
    		 + Time_Sec + "INTEGER NOT NULL," + Calories + "INTEGER," + Top_Speed + "INTEGER)";
     
     
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
    	 
    	 //This query tells the database to select all the users information 
    	 //for the users who email is email.
    	 String query  = "SELECT * FROM Users WHERE Email = "
    			 + email;
    	 
    	 //The cursor holds all the returned information 
    	 Cursor curs  = db.rawQuery(query,null);
    	 
    	 User use = new User();
    	 
    	 use.set_email(curs.getString(0));
    	 use.set_password(curs.getBlob(1));
    	 use.set_name(curs.getString(2));
    	 use.set_age(curs.getInt(3));
    	 use.set_Weight(curs.getInt(4));
    	 use.set_height(curs.getInt(5), curs.getInt(6));
    	 db.close();
    	 return use;
     }
     
     /**
      * Function to insert new user into database.
      * @param use the user to insert
      * @return returns a long anything other than -1 is OK.
      */
     public long put_user_data(User use)
     {
    	 long status = 0;
    	 
    	 SQLiteDatabase db = this.getWritableDatabase();
    	 
    	 ContentValues content = new ContentValues();
    	 
    	 content.put(Email, use.get_email());
    	 content.put(Password, use.get_password());
    	 content.put(Age, use.get_age());
    	 content.put(Weight,use.get_Weight());
    	 content.put(Height_Feet, use.get_height_feet());
    	 content.put(Height_Inches, use.get_height_inches());
    	 content.put(Name, use.get_name());
    	 status = db.insert(Users_Table, Email, content);
    	 db.close();
    	 return status;
     }
     
     //TODO Need run object to finish this 
     public int submit_Run()
     {
    	 //place holder
    	return 1; 
     }
     
}
