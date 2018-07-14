package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.collections.SetOfStops;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;

import java.util.ArrayList;

public class Token extends BaseModel
{
	
	public String originStopId;
	
	public String destinationStopId;
	
	public String transactionId;
	
	public Token(Transaction transaction, Stop originStopId, Stop destinationStopId)
	{
		this.transactionId = transaction.id;
		this.originStopId = originStopId.id;
		this.destinationStopId = destinationStopId.id;
	}
	
	/**
	 * Get the transaction of a token
	 *
	 * @return
	 */
	public Transaction getTransaction()
	{
		SetOfTransactions setOfTransactions = new SetOfTransactions();
		
		ArrayList<BaseModel> transactions = setOfTransactions.all();
		
		for (BaseModel model: transactions)
		{
			Transaction transaction = (Transaction) model;
			
			if (transaction.id.equals(this.transactionId))
			{
				return transaction;
			}
		}
		
		return null;
	}
	
	/**
	 * Get the Origin Stop
	 *
	 * @return Get the stop ${@link Stop}
	 */
	public Stop getOrginStop()
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
	 * @return Get the stop ${@link Stop}
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
