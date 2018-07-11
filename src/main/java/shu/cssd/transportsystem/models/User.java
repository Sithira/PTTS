package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfCards;
import shu.cssd.transportsystem.models.collections.SetOfDynamicJourney;
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
	
	// from employee
	public float salary;
	
	public String permission_id;
	
	// from account
	public String username;
	
	public String password;
	
	public String cardId;
	
	public String dynamicJourneyId;
	
	/**
	 * Get the card
	 *
	 * @return
	 */
	public Card getCard()
	{
		SetOfCards setOfCards = new SetOfCards();
		
		try
		{
			return (Card) setOfCards.findById(this.cardId);
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
	public DynamicJourney getDynamicJourney()
	{
		
		SetOfDynamicJourney setOfDynamicJourney = new SetOfDynamicJourney();
		
		try
		{
			return (DynamicJourney) setOfDynamicJourney.findById(this.dynamicJourneyId);
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
