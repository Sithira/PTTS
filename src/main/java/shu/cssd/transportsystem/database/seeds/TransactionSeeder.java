package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

public class TransactionSeeder implements BaseSeeder
{
	
	SetOfUsers setOfUsers = new SetOfUsers();
	
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
		
		for (int i = 0; i < this.setOfUsers.all().size(); i++)
		{
			User user = (User) this.setOfUsers.all().get(i);
			
			new Transaction.Builder(user, PaymentType.CASH, (float) Math.random()).create();
		}
		
	}
}
