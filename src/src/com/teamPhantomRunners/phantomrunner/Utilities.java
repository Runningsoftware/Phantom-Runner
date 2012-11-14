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
	
}
