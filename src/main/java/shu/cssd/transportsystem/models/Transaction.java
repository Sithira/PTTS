package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.collections.SetOfPayments;
import shu.cssd.transportsystem.models.collections.SetOfTokens;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.io.Serializable;
import java.util.ArrayList;

public class Transaction extends BaseModel
{
	/**
	 * Id of the User that performs the Transaction
	 */
	public String userId;

	/**
	 * Id of the Smart Card used to this Transaction
	 */
	public String smartCardId;

	/**
	 * Transaction Amount
	 */
	public float amount;

	/**
	 * Create new Transaction
	 *
	 * @param builder {@link Builder}
	 */
	private Transaction(Builder builder)
	{
		this.userId = builder.userId;
	}
	
	/**
	 * Get the user of the transaction
	 *
	 * @return {@link User}
	 */
	public User getUser()
	{
		SetOfUsers setOfUsers = new SetOfUsers();
		
		ArrayList<BaseModel> users = setOfUsers.all();
		
		for (BaseModel model: users)
		{
			User user = (User) model;
			
			if (this.userId.equals(user.id))
			{
				return user;
			}
		}
		
		return null;
	}
	
	/**
	 * Get the token of the transaction.
	 *
	 * @return {@link Token}
	 */
	public Token getToken()
	{
		SetOfTokens setOfTokens = new SetOfTokens();
		
		ArrayList<BaseModel> tokens = setOfTokens.all();
		
		for (BaseModel model: tokens)
		{
			Token token = (Token) model;
			
			if (token.transactionId.equals(this.id))
			{
				return token;
			}
		}
		return null;
	}
	
	/**
	 * Get Payment
	 *
	 * @return {@link Payment}
	 */
	public Payment getPayment()
	{
		SetOfPayments setOfPayments = new SetOfPayments();
		
		ArrayList<BaseModel> payments = setOfPayments.all();
		
		for (BaseModel model: payments)
		{
			Payment payment = (Payment) model;
			
			if (payment.transactionId.equals(id))
			{
				return payment;
			}
		}
		return null;
	}
	
	/**
	 * Builder class for the transaction
	 */
	public static class Builder implements Serializable
	{
		public User user;
		
		public String userId;
		
		public String smartCardId;
		
		public PaymentType paymentType;
		
		public float amount;

		/**
		 * Create an instance of the builder {@link Builder}
		 *
		 * @param user
		 * @param paymentType
		 * @param amount
		 */
		public Builder(User user, PaymentType paymentType, float amount)
		{
			this.user = user;
			this.userId = user.id;
			this.amount = amount;
			this.paymentType =  paymentType;
		}
		
		/**
		 * Set the SmartCard for the transaction
		 *
		 * @return {@link Builder}
		 */
		public Builder fromSmartCard()
		{
			this.smartCardId = this.user.getCard().id;
			
			return this;
		}
		
		/**
		 * Return the transaction object
		 *
		 * @return {@link Transaction}
		 */
		public Transaction create()
		{
			return new Transaction(this);
		}
	}
}
