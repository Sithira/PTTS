package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfPayments;
import shu.cssd.transportsystem.models.collections.SetOfTokens;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.io.Serializable;
import java.util.ArrayList;

public class Transaction extends BaseModel
{
	
	public String userId;
	
	public String paymentId;
	
	public String tokenId;
	
	public String purchaseLocation;
	
	private Transaction(String userId, String paymentId)
	{
		this.userId = userId;
		this.paymentId = paymentId;
	}
	
	/**
	 * Get the user of the transaction
	 *
	 * @return
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
	 * @return
	 */
	public Token getToken()
	{
		SetOfTokens setOfTokens = new SetOfTokens();
		
		ArrayList<BaseModel> tokens = setOfTokens.all();
		
		for (BaseModel model: tokens)
		{
			
			Token token = (Token) model;
			
			if (this.tokenId.equals(token.id))
			{
				return token;
			}
			
		}
		
		return null;
	}
	
	/**
	 * Get Payment
	 *
	 * @return
	 */
	public Payment getPayment()
	{
		
		SetOfPayments setOfPayments = new SetOfPayments();
		
		ArrayList<BaseModel> payments = setOfPayments.all();
		
		for (BaseModel model: payments)
		{
			Payment payment = (Payment) model;
			
			if (payment.id.equals(paymentId))
			{
				return payment;
			}
		}
	
		return null;
	}
	
	/**
	 * Builder class for the transaction
	 */
	public static class TransactionCreator implements Serializable
	{
		public String userId;
		
		public String paymentId;
		
		public String tokenId;
		
		public String transactionType;
		
		public String purchaseLocation;
		
		/**
		 * Create an instance of the builder
		 *
		 * @param userId
		 * @param paymentId
		 */
		public TransactionCreator(String userId, String paymentId)
		{
			this.userId = userId;
			this.paymentId = paymentId;
		}
		
		/**
		 * Set the token for the transaction
		 *
		 * @param token
		 * @return
		 */
		public TransactionCreator setTokenId(Token token)
		{
			this.tokenId = token.id;
			
			return this;
		}
		
		/**
		 * Set the location for the transaction
		 *
		 * @param location
		 * @return
		 */
		public TransactionCreator setLocation(String location)
		{
			this.purchaseLocation = location;
			
			return this;
		}
		
		/**
		 * Return the transaction object
		 *
		 * @return {@link Transaction}
		 */
		public Transaction create()
		{
			return new Transaction(userId, paymentId);
		}
		
	}
	
}
