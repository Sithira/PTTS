package shu.cssd.transportsystem.foundation.core.transaction;

import shu.cssd.transportsystem.foundation.interfaces.Stratergy;

public class TransactionSubtractOperation implements Stratergy
{
	@Override
	public float operation(float currentBalance, float amount)
	{
		return currentBalance - amount;
	}
}
