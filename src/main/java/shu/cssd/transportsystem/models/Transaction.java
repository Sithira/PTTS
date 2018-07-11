package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfPayments;
import shu.cssd.transportsystem.models.collections.SetOfTokens;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.util.ArrayList;

public class Transaction extends BaseModel
{
	
	public String userId;
	
	public String paymentId;
	
	public String tokenId;
	
	public String transactionType;
	
	public String purchaseLocation;
	
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
	
}
