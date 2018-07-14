package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.SmartCard;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

public class TransactionController
{
	
	SetOfUsers setOfUsers = new SetOfUsers();
	
	/**
	 * Make a new transaction is the user account
	 *
	 * @param user
	 * @param paymentType
	 * @param amount
	 */
	public void makeTransaction(User user, PaymentType paymentType, float amount)
	{
		if (paymentType.equals(PaymentType.CASH))
		{
			user.balance = (user.balance - amount);
			
			//(new Transaction.TransactionCreator(user.id, ))
		}
		
		if (paymentType.equals(PaymentType.CARD))
		{
			SmartCard card = user.getCard();
			
			card.balance = (card.balance - amount);
		}
		
		try
		{
			setOfUsers.findByIdAndUpdate(user.id, user);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
