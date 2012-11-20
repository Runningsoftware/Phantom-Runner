package com.teamPhantomRunners.phantomrunner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class Utilities 
{
	private static final String salt = "SALTYsalt";
	
   public static boolean Check_Password(String userpass, byte[] databasepass, String email)
   {
	   boolean iscorrect = false;
	   
	   iscorrect = Arrays.equals(databasepass, Generate_Password(userpass,email));
	   
	   return iscorrect;
   }
   
   public static byte[] Generate_Password(String password ,String email)
   {
	   String pass = email.substring(0, 3);
	   byte[] hashedpass;
	   pass =  pass + salt + password;
	   
	try
	{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		md.update(pass.getBytes());
		
		hashedpass = md.digest();
		
		return hashedpass;
		
	} catch (NoSuchAlgorithmException e) 
	{
		return null;
	}
   }
   
   public static double kmToMiles(double kilometers)
   {
	   return kilometers * 0.621371;
   }
   
   public static int timeInSeconds(int[] times)
   {
	   //3600 seconds in an hour 60 in a second.
	   return ((3600*times[0]) + (60*times[1]) + times[3]);
   }
   
   public static int[] parseTime(String time)
   {
	   int[] hrs_min_sec = new int[3];
	    
	   String[] s = time.split(":");
	   
	   try
	   {
	   
	       hrs_min_sec[0] = Integer.parseInt(s[0]);
	       hrs_min_sec[1] = Integer.parseInt(s[1]);
	       hrs_min_sec[2] = Integer.parseInt(s[2]);
	   
	       return hrs_min_sec;
	       
	   }catch(NumberFormatException e)
	   {
		   return null;
	   }
   }
	
}