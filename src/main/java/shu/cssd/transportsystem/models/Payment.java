package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;

import java.io.Serializable;

public class Payment extends BaseModel
{
	public PaymentType paymentType;
	
	public String transactionId;
	
	public String cardId;
	
	public float value;
	
	public float change;
	
	private Payment(Transaction transaction, PaymentType type, float value)
	{
		this.transactionId = transaction.id;
		this.paymentType = type;
		this.value = value;
	}
	
	/**
	 * Get the transaction for the payment
	 *
	 * @return get the list of transactions
	 */
	public Transaction getTransaction()
	{
		SetOfTransactions setOfTransactions = new SetOfTransactions();
		
		for (BaseModel model: setOfTransactions.all())
		{
			
			Transaction transaction = (Transaction) model;
			
			if (transaction.paymentId.equals(this.id))
			{
				return transaction;
			}
			
		}
		
		return null;
	}
	
	public static class PaymentCreator implements Serializable
	{
		public PaymentType paymentType;
		
		public Transaction transaction;
		
		public String cardId;
		
		public float value;
		
		public float change;
		
		public PaymentCreator(Transaction transaction, PaymentType paymentType, float value)
		{
			this.transaction = transaction; // this later sets its id to the real object as a string (UUID)
			this.paymentType = paymentType;
			this.value = value;
		}
		
		/**
		 * Set the card for the payment
		 *
		 * @param card
		 * @return
		 */
		public PaymentCreator setCard(SmartCard card)
		{
			this.cardId = card.id;
			
			return this;
		}
		
		/**
		 * Set the change for the payment
		 *
		 * @param change
		 * @return
		 */
		public PaymentCreator setChange(float change)
		{
			this.change = change;
			
			return this;
		}
		
		/**
		 * Create the instance of the payment
		 *
		 * @return
		 */
		public Payment create()
		{
			return new Payment(transaction, paymentType, value);
		}
		
		
	}
}

