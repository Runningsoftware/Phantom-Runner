package com.teamPhantomRunners.phantomrunner;


/**
 * Holds all of the Users data outside of the database for easy access
 * @author Michael
 *
 */
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
	   this.email = email;
	   this.name = name;
	   this.age = age;
	   this.height_feet = height_feet;
	   this.height_inch = height_inch;
	   this.weight = weight;
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
   
   /**
    * Function takes a string and creates a password hash based on the users 
    * email, a salt, and the password the user selected.
    * @param password string representing users password
    */
   public void set_password(String password)
   {
	  this.password = Utilities.Generate_Password(password, this.email); 
   }
   /**
    * 
    * @param pass the byte array for the already created password
    */
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