package shu.cssd.transportsystem.foundation.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shu.cssd.transportsystem.foundation.core.transaction.TransactionAddOperation;
import shu.cssd.transportsystem.foundation.core.transaction.TransactionSubtractOperation;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionOperationTest
{
	
	private TransactionOperation transactionOperation;
	
	@Test
	@DisplayName("Strategy Add Test")
	void addExecuteOperation()
	{
		this.transactionOperation = new TransactionOperation(new TransactionAddOperation());
		
		assertEquals(10, this.transactionOperation.executeOperation(5, 5));
	}
	
	@Test
	@DisplayName("Strategy Subtract Test")
	void subtractExecuteOperation()
	{
		this.transactionOperation = new TransactionOperation(new TransactionSubtractOperation());
		
		assertEquals(0, this.transactionOperation.executeOperation(5, 5));
	}
}