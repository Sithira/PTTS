package shu.cssd.transportsystem.helpers;

import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.Token;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfTokens;

public class TokenCreator
{
	private static TokenCreator ourInstance = new TokenCreator();
	
	private SetOfTokens setOfTokens = new SetOfTokens();
	
	/**
	 * Get an instance of the token creator
	 *
	 * @return {@link TokenCreator}
	 */
	public static TokenCreator getInstance()
	{
		if (ourInstance == null)
		{
			return new TokenCreator();
		}
		
		return ourInstance;
	}
	
	private TokenCreator() { }
	
	/**
	 * Create an token for the user
	 *
	 * @param user user of the token
	 * @param paymentType payment type
	 * @param origin origin of the user
	 * @param destination destination of the user
	 * @return {@link Token}
	 */
	public Token createToken(User user, PaymentType paymentType, Stop origin, Stop destination)
	{
		float amount = CostCalculator.getInstance().calculate(origin, destination, destination.getRoute());
		
		Transaction transaction = new Transaction.Builder(user, paymentType, amount).create();
		
		return new Token(transaction, origin, destination);
	}
}
