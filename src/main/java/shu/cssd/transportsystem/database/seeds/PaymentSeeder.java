package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.Payment;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;

public class PaymentSeeder implements BaseSeeder
{
	SetOfTransactions setOfTransactions = new SetOfTransactions();
	
	@Override
	public void seed()
	{
	
	}
	
	@Override
	public void read()
	{
	
	}
	
	@Override
	public void relationships()
	{
		
		for (int i = 0; i < this.setOfTransactions.all().size(); i++)
		{
			Transaction transaction = (Transaction) this.setOfTransactions.all().get(i);
			
			new Payment.Builder(transaction, PaymentType.CASH, (float) Math.random())
					.setChange((float) Math.random())
					.create();
		}
	
	}
}
