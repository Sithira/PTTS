package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.util.ArrayList;
import java.util.Date;

public class SmartCard extends BaseModel
{

	public String userId;
	
	public int pinCode;
	
	public int cvc;
	
	public float balance = 0;

	public Date expiryDate;
	
	public SmartCard(User user, int pinCode, int cvc, Date expiryDate)
	{
		this.userId = user.id;
		this.pinCode = pinCode;
		this.cvc = cvc;
		this.expiryDate = expiryDate;
	}
	
	/**
	 * Get the user from the card.
	 *
	 * @return
	 */
	public User getUser()
	{
		SetOfUsers setOfUsers = new SetOfUsers();
		
		ArrayList<BaseModel> rows = setOfUsers.all();
		
		for (BaseModel model: rows)
		{
			User user = (User) model;
			
//			if (user.cardId.equals(this.id))
//			{
//				return user;
//			}

			if(this.userId.equals(user.id))
			{
				return user;
			}
		}
		
		return null;
	}
	
}

