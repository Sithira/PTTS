package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.util.ArrayList;
import java.util.Date;

public class SmartCard extends BaseModel
{

	/**
	 * Id of the User(Owner) of this Smart Card
	 */
	public String userId;

	/**
	 * Pin number of the Smart Card
	 */
	public int pinCode;

	/**
	 * CVC of th Smart Card
	 */
	public int cvc;

	/**
	 * Balance of the Smart Card
	 */
	public float balance = 0;

	/**
	 * Expiry date of the SmartCard
	 */
	public Date expiryDate;

	/**
	 * Create a new SmartCard in the system
	 * @param user
	 * @param pinCode
	 * @param cvc
	 * @param expiryDate
	 */
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

