package shu.cssd.transportsystem.helpers;

import shu.cssd.transportsystem.models.Journey;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.User;

public class JourneyCreator
{
	private static JourneyCreator ourInstance = new JourneyCreator();
	
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
	 * @param transaction
	 * @param origin
	 * @param destination
	 * @return {@link Journey}
	 */
	public Journey createJourney(Transaction transaction, Stop origin, Stop destination)
	{
		return  new Journey.Builder(transaction.getUser(), origin)
				.setDestination(destination)
				.setCost(transaction.amount)
				.create();
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
		return new Journey.Builder(user, origin).create();
	}
}
