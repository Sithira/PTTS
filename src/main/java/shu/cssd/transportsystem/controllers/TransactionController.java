package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.Payment;
import shu.cssd.transportsystem.models.SmartCard;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

public class TransactionController
{
	
	SetOfUsers setOfUsers = new SetOfUsers();
	
	SetOfTransactions setOfTransactions = new SetOfTransactions();
	
	public TransactionController(){}
	
	/**
	 * Make a new transaction is the user account
	 *
	 * @param user
	 * @param paymentType
	 * @param amount
	 * @return {@link Transaction}
	 */
	public Transaction makeTransaction(User user, PaymentType paymentType, float amount)
	{
		
		Transaction transaction = (new Transaction.Builder(user, paymentType, amount)).create();
		
		// check if the payment is a CASH
		if (paymentType.equals(PaymentType.CASH))
		{
			user.balance = (user.balance - amount);
			
			(new Payment.Builder(transaction, PaymentType.CASH, amount)).create();
		}
		
		// check if the payment is card
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
		
		this.setOfTransactions.create(transaction);
		
		return transaction;
	}

}
