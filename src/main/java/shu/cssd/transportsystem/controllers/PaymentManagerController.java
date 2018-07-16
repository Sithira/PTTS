package shu.cssd.transportsystem.controllers;

import org.apache.commons.lang.time.DateUtils;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.foundation.types.TransactionType;
import shu.cssd.transportsystem.models.*;
import shu.cssd.transportsystem.models.collections.SetOfJourney;

import java.util.ArrayList;
import java.util.Date;

public class PaymentManagerController
{
	
	private PaymentManager paymentManager;
	
	PaymentManagerController()
	{
		this.paymentManager = new PaymentManager();
	}
	
	/**
	 * Apply Discount for the journey.
	 *
	 * @param journey
	 */
	public void applyDiscount(Journey journey)
	{
		
		// get the user from the journey
		User user = journey.getUser();
		
		// get the eligible offers
		Offer offer = this.checkOffers(user);
		
		// if the offer is not null
		if (offer != null)
		{
			
			// apply the discount to the journey
			journey.cost = journey.cost - (journey.cost * offer.discount);
			
			new TransactionController().makeTransaction(user, PaymentType.CASH, TransactionType.SUBSTRACT, journey.cost);
			
			// get the set
			SetOfJourney setOfJourney = new SetOfJourney();
			
			try
			{
				
				// apply the discount.
				setOfJourney.findByIdAndUpdate(journey.id, journey);
				
			} catch (ModelNotFoundException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * Get the offer for user.
	 *
	 * @param user
	 * @return
	 */
	private Offer checkOffers(User user)
	{
		
		// get the number of transaction done by the user
		int numberOfTransactions = this.getValidTransactions(user.getTransactions());
		
		// loop for all the offers in the system
		for (BaseModel model: paymentManager.getSetOfOffers().all())
		{
			
			// get the offers into the correct model
			Offer offer = (Offer) model;
			
			// check for the criteria
			if (offer.criteria == numberOfTransactions)
			{
				
				// return the correct offer
				return offer;
			}
			
		}
		
		return null;
		
	}
	
	/**
	 * Get the number of transaction done by a user for a day.
	 *
	 * @param transactions
	 * @return
	 */
	private int getValidTransactions(ArrayList<Transaction> transactions)
	{

		// get a new date object
		Date now = new Date();
		
		// init the number of transaction
		int numberOfValidTransactions = 0;
		
		for (Transaction transaction: transactions)
		{
			
			if (DateUtils.isSameDay(transaction.created_at, now))
			{
				numberOfValidTransactions++;
			}
			
		}
		
		return numberOfValidTransactions;
	}
	
}
