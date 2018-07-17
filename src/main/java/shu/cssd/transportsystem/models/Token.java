package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.collections.SetOfStops;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;

import java.util.ArrayList;

public class Token extends BaseModel
{
	/**
	 * Id of the Origin Stop of the Token
	 */
	public String originStopId;

	/**
	 * Id of the Destination Stop of the Token
	 */
	public String destinationStopId;

	/**
	 * Id of the Transaction that created the Token
	 */
	public String transactionId;
	
	/**
	 * Create new Token in the system
	 * @param transaction {@link Transaction}
	 * @param originStopId {@link Stop}
	 * @param destinationStopId {@link Stop}
	 */
	public Token(Transaction transaction, Stop originStopId, Stop destinationStopId)
	{
		this.transactionId = transaction.id;
		this.originStopId = originStopId.id;
		this.destinationStopId = destinationStopId.id;
	}
	
	/**
	 * Get the transaction of a token
	 *
	 * @return {@link Transaction}
	 */
	public Transaction getTransaction()
	{
		try {
			return (Transaction) (new SetOfTransactions()).findById(this.transactionId);
		} catch (ModelNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * Get the Origin Stop
	 *
	 * @return Get the stop {@link Stop}
	 */
	public Stop getOriginStop()
	{
		try
		{
			return (Stop) (new SetOfStops()).findById(this.originStopId);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Get the Destination Stop
	 *
	 * @return Get the stop {@link Stop}
	 */
	public Stop getDestinationStop()
	{
		try
		{
			return (Stop) (new SetOfStops()).findById(this.destinationStopId);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

}
