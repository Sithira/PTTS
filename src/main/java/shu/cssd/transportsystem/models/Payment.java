package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;

import java.io.Serializable;

public class Payment extends BaseModel
{
	public PaymentType paymentType;
	
	public String transactionId;
	
	public float value;
	
	public float change;
	
	private Payment(Builder builder)
	{
		this.transactionId = builder.transaction.id;
		this.paymentType = builder.paymentType;
		this.value = builder.value;
	}
	
	/**
	 * Get the transaction for the payment
	 *
	 * @return {@link Transaction}
	 */
	public Transaction getTransaction()
	{
		SetOfTransactions setOfTransactions = new SetOfTransactions();
		
		for (BaseModel model: setOfTransactions.all())
		{
			
			Transaction transaction = (Transaction) model;
			
			if (transaction.id.equals(this.transactionId))
			{
				return transaction;
			}
			
		}
		
		return null;
	}
	
	public static class Builder implements Serializable
	{
		public PaymentType paymentType;
		
		public Transaction transaction;
		
		public float value;
		
		public float change;
		
		/**
		 * Generates a new {@link Payment} object
		 *
		 * @param transaction {@link Transaction}
		 * @param paymentType {@link PaymentType}
		 * @param value value of the transaction
		 */
		public Builder(Transaction transaction, PaymentType paymentType, float value)
		{
			this.transaction = transaction; // this later sets its id to the real object as a string (UUID)
			this.paymentType = paymentType;
			this.value = value;
		}
		
		/**
		 * Set the change for the payment
		 *
		 * @param change Remaining value
		 * @return {@link Builder}
		 */
		public Builder setChange(float change)
		{
			this.change = change;
			
			return this;
		}
		
		/**
		 * Create the instance of the payment
		 *
		 * @return {@link Payment}
		 */
		public Payment create()
		{
			return new Payment(this);
		}
		
		
	}
}

