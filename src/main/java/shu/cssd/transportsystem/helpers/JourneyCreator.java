package shu.cssd.transportsystem.helpers;

import shu.cssd.transportsystem.models.Journey;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.Transaction;

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
	
	public Journey createJouney(Transaction transaction, Stop origin, Stop destination)
	{
		return (new Journey(transaction.getUser(), origin, destination, transaction.amount));
	}
}
