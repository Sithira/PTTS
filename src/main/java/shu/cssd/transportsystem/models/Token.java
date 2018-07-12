package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;

import java.util.ArrayList;

public class Token extends BaseModel
{
	
	public String origin_stop_id;
	
	public Token(String origin_stop_id, String source_stop_id)
	{
		this.origin_stop_id = origin_stop_id;
		this.source_stop_id = source_stop_id;
	}
	
	public String source_stop_id;
	
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
			
			if (transaction.tokenId.equals(this.id))
			{
				return transaction;
			}
		}
		
		return null;
	}

}
