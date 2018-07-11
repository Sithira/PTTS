package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;

import java.util.ArrayList;

public class Token extends BaseModel
{
	
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
