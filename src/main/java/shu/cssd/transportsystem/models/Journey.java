package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.collections.SetOfStops;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

public class Journey extends BaseModel
{
	/**
	 * Id of the User of the Journey
	 */
	public String userId;

	/**
	 * Id of the Route of the Journey
	 */
	public String routeId;

	/**
	 * Id of the Origin Stop of the Journey
	 */
	public String originId;

	/**
	 * Id of the Destination Stop of the Journey
	 */
	public String destinationId;

	/**
	 * Cost amount of the Journey
	 */
	public float cost;
	
	/**
	 * Create a new journey
	 *
	 * @param builder {@link Builder}
	 */
	private Journey(Builder builder)
	{
		this.userId = builder.userId;
		this.originId = builder.originId;
		this.destinationId = builder.destinationId;
		this.routeId = builder.routeId;
		this.cost = builder.cost;
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
	
	/**
	 * Builder Class for the Journey
	 */
	public static class Builder
	{
		public String userId;
		
		public String routeId;
		
		public String originId;
		
		public String destinationId;
		
		public float cost;
		
		private User user;
		private Stop origin;
		
		/**
		 *
		 * @param user User of the journey
		 * @param origin Stop of the journey
		 */
		public Builder(User user, Stop origin)
		{
			this.userId = user.id;
			this.originId = origin.id;
			this.routeId = origin.getRoute().id;
			this.user = user;
			this.origin = origin;
		}
		
		/**
		 * Set the destination
		 *
		 * @param destination Destination of journey
		 * @return {@link Builder}
		 */
		public Builder setDestination(Stop destination)
		{
			this.destinationId = destination.id;
			
			return this;
		}
		
		/**
		 * Set the cost for the journey
		 *
		 * @param cost
		 * @return {@link Builder}
		 */
		public Builder setCost(float cost)
		{
			this.cost = cost;
			
			return this;
		}
		
		/**
		 * Create the actual journey object
		 *
		 * @return {@link Journey}
		 */
		public Journey create()
		{
			return new Journey(this);
		}
		
	}
	
}
