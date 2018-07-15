package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
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
		try
		{
			return (User) (new SetOfUsers()).findById(this.userId);
		}
		catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}


		return null;
	}
	
}

