package shu.cssd.transportsystem.foundation.core;

import shu.cssd.transportsystem.foundation.interfaces.Stratergy;

public class TransactionOperation
{
	
	private Stratergy stratergy;
	
	public TransactionOperation(Stratergy stratergy)
	{
		this.stratergy = stratergy;
	}
	
	public float executeOperation(float current, float amount)
	{
		return this.stratergy.operation(current, amount);
	}
	
}
