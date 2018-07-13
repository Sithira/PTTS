package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfPermissions;
import shu.cssd.transportsystem.models.collections.SetOfSmartCards;
import shu.cssd.transportsystem.models.collections.SetOfJourney;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;

public class User extends BaseModel
{
	
	// from user
	public String name;
	
	public String email;
	
	public String address;
	
	public String city;
	
	public String postalCode;
	
	public float balance;
	
	// from employee
	public float salary;
	
	public String permission_id;
	
	// from account
	public String username;
	
	public String password;
	
	public String cardId;
	
	public String journeyId;
	
	/**
	 * Create a new employee in the system
	 *
	 * @param name
	 * @param email
	 * @param address
	 * @param city
	 * @param postalCode
	 * @param username
	 * @param password
	 */
	private User(String name, String email, String address, String city, String postalCode, String username, String password)
	{
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.salary = salary;
		this.permission_id = permission_id;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Get the card
	 *
	 * @return
	 */
	public SmartCard getCard()
	{
		SetOfSmartCards setOfCards = new SetOfSmartCards();
		
		try
		{
			return (SmartCard) setOfCards.findById(this.cardId);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Get the Journey of an User
	 *
	 * @return
	 */
	public Journey getJourney()
	{
		
		SetOfJourney setOfDynamicJourney = new SetOfJourney();
		
		try
		{
			return (Journey) setOfDynamicJourney.findById(this.journeyId);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Get the permission that might be belong to a user
	 *
	 * @return
	 */
	public Permission getPermission()
	{
		SetOfPermissions setOfPermissions = new SetOfPermissions();
		
		try
		{
			return (Permission) setOfPermissions.findById(this.permission_id);
			
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Get transactions for the account.
	 *
	 * @return
	 */
	public ArrayList<Transaction> getTransactions()
	{
		
		// build an array list
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		// get the set of transactions
		SetOfTransactions setOfTransactions = new SetOfTransactions();
		
		// get all the rows in the collection
		ArrayList<BaseModel> rows = setOfTransactions.all();
		
		// loop through each row
		for (BaseModel row : rows)
		{
			Transaction transaction = (Transaction) row;
			
			// find the appropiate row
			if (transaction.userId.equals(this.id))
			{
				
				// add to the arraylist
				transactions.add(transaction);
			}
		}
		
		return transactions;
	}
	
	/**
	 * The Builder Class for the user
	 */
	public static class UserCreator implements Serializable
	{
		// from user
		private String name;
		
		private String email;
		
		private String address;
		
		private String city;
		
		private String postalCode;
		
		private float balance;
		
		// from employee
		private float salary;
		
		private String permissionId;
		
		// from account
		private String username;
		
		private String password;
		
		private String cardId;
		
		private String journeyId;
		
		/**
		 * Create the {@link UserCreator} object
		 *
		 * @param name
		 * @param email
		 * @param address
		 * @param city
		 * @param postalCode
		 * @param username
		 * @param password
		 */
		public UserCreator(String name, String email, String address, String city, String postalCode, String username, String password)
		{
			this.name = name;
			this.email = email;
			this.address = address;
			this.city = city;
			this.postalCode = postalCode;
			this.username = username;
			this.password = password;
		}
		
		/**
		 * Make the current user as an Employee
		 *
		 * @param salary
		 * @param permissionId
		 * @return
		 */
		public UserCreator addAsEmployee(float salary, String permissionId)
		{
			this.salary = salary;
			this.permissionId = permissionId;
			
			return this;
		}
		
		/**
		 * Add a smart card to the user
		 *
		 * @param card {@link SmartCard}
		 * @return
		 */
		public UserCreator addCard(SmartCard card)
		{
			this.cardId = card.id;
			
			return this;
		}
		
		/**
		 * Set the balance amount in the user
		 *
		 * @param balance
		 * @return
		 */
		public UserCreator setBalance(float balance)
		{
			this.balance = balance;
			
			return this;
		}
		
		/**
		 * Get the actual user object
		 *
		 * @return {@link User}
		 */
		public User create()
		{
			return new User(name, email, address, city, postalCode, username, password);
		}
		
	}
	
}
