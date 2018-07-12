package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfSmartCards;
import shu.cssd.transportsystem.models.collections.SetOfJourney;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;

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
	
	public String dynamicJourneyId;
	
	/**
	 * Create a new employee in the system
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
	 */
	public User(String name, String email, String address, String city, String postalCode,
	            float salary, String permission_id, String username, String password)
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
	 * Create a new user in the system
	 *
	 * @param name
	 * @param email
	 * @param address
	 * @param city
	 * @param postalCode
	 * @param username
	 * @param password
	 */
	public User(String name, String email, String address, String city,
	            String postalCode, String username, String password)
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
	 * Get the Dynamic Journey of an User
	 *
	 * @return
	 */
	public Journey getDynamicJourney()
	{
		
		SetOfJourney setOfDynamicJourney = new SetOfJourney();
		
		try
		{
			return (Journey) setOfDynamicJourney.findById(this.dynamicJourneyId);
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
	
}
