package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.util.ArrayList;
import java.util.Date;

public class Card extends BaseModel
{

	public int pinCode;
	
	public int cvc;
	
	public String holderName;

	public Date expiryDate;
	
	public Card(int pinCode, int cvc, String holderName, Date expiryDate)
	{
		this.pinCode = pinCode;
		this.cvc = cvc;
		this.holderName = holderName;
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
			
			if (user.cardId.equals(this.id))
			{
				return user;
			}
		}
		
		return null;
	}
	
}

