package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.foundation.types.TransactionType;
import shu.cssd.transportsystem.models.Payment;
import shu.cssd.transportsystem.models.Permission;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfPayments;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.util.ArrayList;
import java.util.UUID;

public class UserController
{
	
	private SetOfUsers setOfUsers = new SetOfUsers();
	
	public static User currentUser;
	
	private static UserController userController;
	
	private UserController() { }
	
	public static UserController getInstance()
	{
		if (userController == null)
		{
			return new UserController();
		}
		
		return userController;
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
	 * @param permission {@link Permission}
	 * @param username
	 * @param password
	 * @return Returns a boolean depending on the status of creation
	 */
	public boolean createEmployee(String name, String email, String address, String city, String postalCode,
	                              float salary, Permission permission, String username, String password)
	{
		
		User user = new User.Builder(name, email, address, city, postalCode, username, password)
				.addAsEmployee(salary, permission)
				.create();
		
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
		User user = new User.Builder(name, email, address, city, postalCode, username, password)
				.setBalance(0)
				.create();
		
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
	public boolean checkCredentials(String username, String password)
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
	
	/**
	 * Update the account balance of the current user.
	 *
	 * @param amount
	 */
	public float topUpBalance(float amount)
	{
		
		Transaction transaction = (new TransactionController())
				.makeTransaction(this.currentUser, PaymentType.CASH, TransactionType.ADD, amount);
		
		new PaymentController().create(transaction, PaymentType.CASH, amount);
		
		return amount;
	}
	
	/**
	 * Remove the smart card from the user.
	 */
	public void removeCard()
	{
		// remove the smart card from controller class
		(new SmartCardController()).remove(this.currentUser.getCard());
	}
	

}
