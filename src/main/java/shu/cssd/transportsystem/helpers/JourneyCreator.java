package shu.cssd.transportsystem.helpers;

import shu.cssd.transportsystem.models.Journey;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfJourney;

public class JourneyCreator
{
	private static JourneyCreator ourInstance = new JourneyCreator();
	
	private SetOfJourney setOfJourney = new SetOfJourney();
	
	public static JourneyCreator getInstance()
	{
		if (ourInstance == null)
		{
			return new JourneyCreator();
		}
		
		return ourInstance;
	}
	
	private JourneyCreator() { }
	
	/**
	 * Create a journey
	 *
	 * @param transaction Transaction object
	 * @param origin Origin of the journey
	 * @param destination Destination of the journey
	 * @return {@link Journey}
	 */
	public Journey createJourney(Transaction transaction, Stop origin, Stop destination)
	{
		
		// create a journey object
		Journey journey = new Journey.Builder(transaction.getUser(), origin)
				.setDestination(destination)
				.setCost(transaction.amount)
				.create();
		
		// add to the data store
		this.setOfJourney.create(journey);
		
		// return the journey
		return journey;
	}
	
	/**
	 * Create the journey with out a destination
	 *
	 * @param user
	 * @param origin
	 * @return {@link Journey}
	 */
	public Journey createJourney(User user, Stop origin)
	{
		Journey journey = new Journey.Builder(user, origin).create();
		
		this.setOfJourney.create(journey);
		
		return journey;
	}
}
