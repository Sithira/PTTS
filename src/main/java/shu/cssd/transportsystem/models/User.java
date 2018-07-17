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
	/**
	 * Name of the User
	 */
	public String name;

	/**
	 * Email of the User
	 */
	public String email;

	/**
	 * Address of the User
	 */
	public String address;

	/**
	 * City of the User
	 */
	public String city;

	/**
	 * Postal code of the User
	 */
	public String postalCode;

	/**
	 * Balance of the User Account
	 */
	public float balance=0;
	
	// from employee
	/**
	 * Salary of the Employee
	 */
	public float salary;

	/**
	 * Id of the System Permissions of the Employee
	 */
	public String permissionId;
	
	// from account
	/**
	 * Username of the User's Account
	 */
	public String username;

	/**
	 * Password of the User's Account
	 */
	public String password;

	
	/**
	 * Creates a new user object
	 *
	 * @param builder {@link Builder}
	 */
	private User(Builder builder)
	{
		this.name = builder.name;
		this.email = builder.email;
		this.address = builder.address;
		this.city = builder.city;
		this.postalCode = builder.postalCode;
		this.salary = builder.salary;
		this.permissionId = builder.permissionId;
		this.username = builder.username;
		this.password = builder.password;
	}
	
	/**
	 * Get the card
	 *
	 * @return {@link SmartCard}
	 */
	public SmartCard getCard()
	{
		SetOfSmartCards setOfSmartCards = new SetOfSmartCards();

		ArrayList<BaseModel> rows = setOfSmartCards.all();

		for (BaseModel row: rows)
		{
			SmartCard smartCard = (SmartCard) row;

			if (smartCard.userId.equals(this.id))
			{
				return smartCard;
			}
		}
		
		return null;
	}
	
	/**
	 * Get the Journeys of an User
	 *
	 * @return {@link SmartCard}
	 */
	public ArrayList<Journey> getJourney()
	{
		ArrayList<Journey> journeys = new ArrayList<Journey>();
		
		SetOfJourney setOfJourney = new SetOfJourney();

		ArrayList<BaseModel> rows = setOfJourney.all();

		for (BaseModel row: rows)
		{
			Journey journey = (Journey) row;

			if (journey.userId.equals(this.id))
			{
				journeys.add(journey);
			}
		}
		return journeys;
	}
	
	/**
	 * Get the permission that might be belong to a user
	 *
	 * @return {@link Permission}
	 */
	public Permission getPermission()
	{
		SetOfPermissions setOfPermissions = new SetOfPermissions();
		
		if (this.permissionId == null)
		{
			return null;
		}
		
		try
		{
			return (Permission) setOfPermissions.findById(this.permissionId);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * Get transactions for the account.
	 *
	 * @return {@link ArrayList<Transaction>}
	 */
	public ArrayList<Transaction> getTransactions()
	{
		
		// build an array list
		ArrayList<Transaction> transactions = new ArrayList<>();
		
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
	public static class Builder implements Serializable
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
		
		/**
		 * Create the {@link Builder} object
		 *
		 * @param name
		 * @param email
		 * @param address
		 * @param city
		 * @param postalCode
		 * @param username
		 * @param password
		 */
		public Builder(String name, String email, String address, String city, String postalCode, String username, String password)
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
		 * @param permission {@link Permission}
		 * @return {@link Builder}
		 */
		public Builder addAsEmployee(float salary, Permission permission)
		{
			this.salary = salary;
			this.permissionId = permission.id;
			
			return this;
		}
		
		/**
		 * Add a smart card to the user
		 *
		 * @param card {@link SmartCard}
		 * @return
		 */
		public Builder addCard(SmartCard card)
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
		public Builder setBalance(float balance)
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
			return new User(this);
		}
		
	}
	
	/**
	 * Get a list of token that owns by the user.
	 *
	 * @return {@link ArrayList<Token>}
	 */
	public ArrayList<Token> getTokens()
	{
		ArrayList<Transaction> transactions = this.getTransactions();
		
		ArrayList<Token> tokens = new ArrayList<>();
		
		for (Transaction transaction: transactions)
		{
			if (transaction.getToken() != null)
			{
				tokens.add(transaction.getToken());
			}
		}
		return tokens;
	}
	
}
