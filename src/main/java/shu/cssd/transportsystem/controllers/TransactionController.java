package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.core.TransactionOperation;
import shu.cssd.transportsystem.foundation.core.transaction.TransactionAddOperation;
import shu.cssd.transportsystem.foundation.core.transaction.TransactionSubtractOperation;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.foundation.types.TransactionType;
import shu.cssd.transportsystem.models.Payment;
import shu.cssd.transportsystem.models.SmartCard;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfSmartCards;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

public class TransactionController
{
	
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
	public Transaction makeTransaction(User user, PaymentType paymentType, TransactionType transactionType, float amount)
	{
		SmartCard card = user.getCard();

		Transaction transaction = (new Transaction.Builder(user, paymentType, amount)).create();

		// Add Operation
		if (transactionType.equals(TransactionType.ADD))
		{
			// Call the strategy class
			// this is an over-head operation
			TransactionOperation transactionOperation = new TransactionOperation(new TransactionAddOperation());
			
			// check if the payment is a CASH
			if (paymentType.equals(PaymentType.CASH))
			{
				user.balance = transactionOperation.executeOperation(user.balance, amount);;
				
				(new Payment.Builder(transaction, PaymentType.CASH, amount)).create();
			}
			
			// check if the payment is card
			if (paymentType.equals(PaymentType.CARD))
			{
				
				card.balance = transactionOperation.executeOperation(card.balance, amount);

			}
			
		}
		
		// Subtract Operation
		if (transactionType.equals(TransactionType.SUBSTRACT))
		{
			// Call the strategy class
			// this is an over-head operation
			TransactionOperation transactionOperation = new TransactionOperation(new TransactionSubtractOperation());
			
			// check if the payment is a CASH
			if (paymentType.equals(PaymentType.CASH))
			{
				user.balance = transactionOperation.executeOperation(user.balance, amount);
				
				(new Payment.Builder(transaction, PaymentType.CASH, amount)).create();
			}
			
			// check if the payment is card
			if (paymentType.equals(PaymentType.CARD))
			{
				card.balance = transactionOperation.executeOperation(card.balance, amount);
			}
		}

		this.setOfTransactions.create(transaction);

		try
		{
			(new SetOfUsers()).findByIdAndUpdate(user.id, user);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}

		try
		{
			(new SetOfSmartCards()).findByIdAndUpdate(card.id, card);
		}
		catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}

		return transaction;
	}

}
