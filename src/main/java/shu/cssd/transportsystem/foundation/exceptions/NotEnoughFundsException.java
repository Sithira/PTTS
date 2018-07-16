package shu.cssd.transportsystem.foundation.exceptions;

public class NotEnoughFundsException extends Exception
{
	
	@Override
	public String getMessage()
	{
		return "You don't have enough funds to do this operation.";
	}
}
