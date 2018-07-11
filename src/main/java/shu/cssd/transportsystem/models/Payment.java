package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;

import java.util.ArrayList;

public class Payment extends BaseModel
{
	public PaymentType paymentType;
	
	public String cardId;
	
	public String value;
	
	public String change;
	
	public Payment(PaymentType type, String cardId, String value, String change)
	{
		this.paymentType = type;
		this.cardId = cardId;
		this.value = value;
		this.change = change;
	}
	
	public Payment(PaymentType type, String value, String change)
	{
		this.paymentType = type;
		this.value = value;
		this.change = change;
	}
	
	/**
	 * Get the transaction for the payment
	 *
	 * @return
	 */
	public Transaction getTransaction()
	{
		SetOfTransactions setOfTransactions = new SetOfTransactions();
		
		ArrayList<BaseModel> transactions = setOfTransactions.all();
		
		for (BaseModel model: transactions)
		{
			
			Transaction transaction = (Transaction) model;
			
			if (transaction.paymentId.equals(this.id))
			{
				return transaction;
			}
			
		}
		
		return null;
	}
}

