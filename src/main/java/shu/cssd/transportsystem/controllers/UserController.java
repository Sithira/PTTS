package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

public class UserController
{
	
	private SetOfUsers setOfUsers = new SetOfUsers();
	
	private User currentUser;
	
	UserController() {};
	
	UserController(User user)
	{
		this.currentUser = user;
	}
	
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
	
	public float getCardBalance()
	{
		return this.currentUser.getCard().balance;
	}

}
