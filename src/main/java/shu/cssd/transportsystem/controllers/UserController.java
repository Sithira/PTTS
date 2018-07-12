package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.util.ArrayList;
import java.util.UUID;

public class UserController
{
	
	private SetOfUsers setOfUsers = new SetOfUsers();
	
	private User currentUser;
	
	/**
	 * Create a new Employee in the system
	 *
	 * @param name
	 * @param email
	 * @param address
	 * @param city
	 * @param postalCode
	 * @param salary
	 * @param permission_id
	 * @param username
	 * @param password
	 * @return Returns a boolean depending on the status of creation
	 */
	public boolean createEmployee(String name, String email, String address, String city, String postalCode,
	                      float salary, String permission_id, String username, String password)
	{
		
		User user = new User(name, email, address, city, postalCode, salary, permission_id, username, password)		;
		
		return setOfUsers.create(user);
	}
	
	/**
	 * Creates a new user in the system
	 *
	 * @param name
	 * @param email
	 * @param address
	 * @param city
	 * @param postalCode
	 * @param username
	 * @param password
	 * @return Returns a boolean depending on the status of creation
	 */
	public boolean createUser(String name, String email, String address, String city,
	                          String postalCode, String username, String password)
	{
		User user = new User(name, email, address, city, postalCode, username, password);
		
		this.currentUser = user;
		
		return setOfUsers.create(user);
	}
	
	/**
	 * Get the balance of the user
	 *
	 * @return
	 */
	public float getBalanace()
	{
		return this.currentUser.balance;
	}
	
	/**
	 * Get the balance in the smart card
	 *
	 * @return
	 */
	public float getCardBalance()
	{
		return this.currentUser.getCard().balance;
	}
	
	/**
	 * Get an random set of strings
	 *
	 * @return
	 */
	public String generateVerificationCode()
	{
		return UUID.randomUUID().toString().substring(0, 4);
	}
	
	/**
	 * Check user creditials.
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean checkCredintials(String username, String password)
	{
		
		ArrayList<BaseModel> users = this.setOfUsers.all();
		
		for (BaseModel model: users)
		{
			User user = (User) model;
			
			if (user.username.equals(username) && user.password.equals(password))
			{
				this.currentUser = user;
				
				return true;
			}
		}
		
		return false;
	}
	
	

}
