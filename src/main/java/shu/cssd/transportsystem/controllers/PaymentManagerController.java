package shu.cssd.transportsystem.controllers;

import org.apache.commons.lang.time.DateUtils;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.*;
import shu.cssd.transportsystem.models.collections.SetOfTokens;

import shu.cssd.transportsystem.models.collections.SetOfOffers;

import java.util.ArrayList;
import java.util.Date;

public class PaymentManagerController
{
	
	private PaymentManager paymentManager;
	
	PaymentManagerController()
	{
		this.paymentManager = new PaymentManager();
	}
	
	public boolean buyToken()
	{
		return true;
	}
	
	/**
	 * Create a new token
	 *
	 * @param origin
	 * @param destination
	 * @return
	 */
	public boolean createToken(Stop origin, Stop destination)
	{
		
		SetOfTokens set = new SetOfTokens();
		
		Token token = new Token(origin.id, destination.id);
		
		return set.create(token);
		
	}
	
	/**
	 * Get the offer for user.
	 *
	 * @param user
	 * @return
	 */
	public Offer checkOffers(User user)
	{
		int numberOfTransactions = this.getValidTransactions(user.getTransactions());
	
		SetOfOffers setOfOffers = new SetOfOffers();
		
		for (BaseModel model: setOfOffers.all())
		{
			
			Offer offer = (Offer) model;
			
			if (offer.criteria == numberOfTransactions)
			{
				return offer;
			}
			
		}
		
		return null;
		
	}
	
	public void calculateJourney(Journey dynamicJourney)
	{
	
		User user = dynamicJourney.getUser();
		
		
	
	}
	
	/**
	 * Get all offers
	 *
	 * @return
	 */
	private SetOfOffers getSetOfOffers()
	{
		return this.paymentManager.getSetOfOffers();
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
