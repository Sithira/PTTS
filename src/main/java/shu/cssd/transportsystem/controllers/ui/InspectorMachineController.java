package shu.cssd.transportsystem.controllers.ui;

import org.apache.commons.lang.time.DateUtils;
import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.foundation.exceptions.InvalidTokenDateException;
import shu.cssd.transportsystem.foundation.exceptions.InvalidTokenRouteException;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.Token;
import shu.cssd.transportsystem.models.User;

import java.util.Date;

public class InspectorMachineController
{
	
	private  User user;
	
	public Route route;
	
	public boolean login(String username, String password)
	{
		UserController userController = new UserController();
		
		boolean successLogin = userController.checkCredentials(username, password);
		
		this.user = userController.currentUser;
		
		return successLogin;
	}
	
	public boolean checkToken(Token token) throws InvalidTokenRouteException, InvalidTokenDateException
	{
	
		if (this.route.id.equals(token.getDestinationStop().routeId))
		{
			throw new InvalidTokenRouteException();
		}
		
		if (!DateUtils.isSameDay(token.created_at, new Date()))
		{
			throw new InvalidTokenDateException();
		}
		
		return true;
	
	}
	
	public Token createToken(Stop origin, Stop destination)
	{
//		return (new TokenCon)
		
		return null;
	}
}
