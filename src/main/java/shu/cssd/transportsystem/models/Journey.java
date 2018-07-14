package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.collections.SetOfStops;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

public class Journey extends BaseModel
{
	
	public String userId;

	public String routeId;

	public String originId;
	
	public String destinationId;

	public float cost;

	public Journey(User user, Stop origin, Stop destination, float amount)
	{
		this.userId = user.id;
		this.routeId = destination.getRoute().id;
		this.originId = origin.id;
		this.destinationId = destination.id;
		this.cost = amount;
	}


	/**
	 * Get the Origin
	 *
	 * @return {@link Stop}
	 */
	public Stop getOrigin()
	{
		SetOfStops setOfStops = new SetOfStops();
		
		try
		{
			return (Stop) setOfStops.findById(this.originId);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Get Destination
	 *
	 * @return {@link Stop}
	 */
	public Stop getDestination()
	{
		
		SetOfStops setOfStops = new SetOfStops();
		
		try
		{
			return (Stop) setOfStops.findById(this.destinationId);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Get the user of the journey
	 *
	 * @return {@link User}
	 */
	public User getUser()
	{
		SetOfUsers setOfUsers = new SetOfUsers();
		
		try
		{
			return (User) setOfUsers.findById(this.userId);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
}
