package com.teamPhantomRunners.phantomrunner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User 
{
	private String email;
	private String name;
	private int age;
	private int height_feet;
	private int height_inch;
	private int weight;
	private byte[] password;
	
   public User()
   {
	   
   }
   
   public User(String email,String name, int age, int height_feet, int height_inch, int weight)
   {
	   
   }
   
   public void set_email(String email)
   {
	   this.email = email;
   }
   
   public String get_email()
   {
	   return this.email;
   }
   
   public void set_age(int age)
   {
	   this.age = age;
   }
   
   public int get_age()
   {
	   return this.age;
   }
   
   public void set_height(int feet,int inches)
   {
	   this.height_feet = feet;
	   this.height_inch = inches;
   }
   
   public int get_height_inches()
   {
	   return this.height_inch;
   }
   
   public int get_height_feet()
   {
	   return this.height_feet;
   }
   
   public void set_password(String password)
   {
	   
	try
	{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		md.update(password.getBytes());
		
		this.password = md.digest();
		
	} catch (NoSuchAlgorithmException e) 
	{
		return;
	}
	   
   }
   
   public void set_password(byte[] pass)
   {
	   this.password = pass;
   }
   
   public byte[] get_password()
   {
	   return this.password;
   }
   
   public void set_name(String name)
   {
	   this.name = name;
   }
   
   public String get_name()
   {
	   return this.name;
   }
   
   public int get_Weight() 
	{
		return weight;
	}

	public void set_Weight(int weight) 
	{
		this.weight = weight;
	}
   
   
   
   
}
