package shu.cssd.transportsystem.helpers;

import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.Token;
import shu.cssd.transportsystem.models.User;

public class TokenCreator
{
	private static TokenCreator ourInstance = new TokenCreator();
	
	public static TokenCreator getInstance()
	{
		if (ourInstance == null)
		{
			return new TokenCreator();
		}
		
		return ourInstance;
	}
	
	private TokenCreator() { }
	
	public Token createToken(User user, Stop origin, Stop destination)
	{
	    return null;
	}
}
