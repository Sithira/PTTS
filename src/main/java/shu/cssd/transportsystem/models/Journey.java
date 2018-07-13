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

	public Double cost;

	public Journey(String routeId, String originId, String destinationId, Double cost)
	{
		this.routeId = routeId;
		this.originId = originId;
		this.destinationId = destinationId;
		this.cost = cost;
	}


	/**
	 * Get the Origin
	 *
	 * @return
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
	 * @return
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
	 * Get the user of the dynamic journey
	 *
	 * @return
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
