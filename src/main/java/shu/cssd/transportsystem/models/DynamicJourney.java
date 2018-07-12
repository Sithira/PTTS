package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfStops;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.util.ArrayList;

public class DynamicJourney extends BaseModel
{

	public String userId;
	
	public String originId;
	
	public String destinationId;

	public Double cost;

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
	 *  Get Destination
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
