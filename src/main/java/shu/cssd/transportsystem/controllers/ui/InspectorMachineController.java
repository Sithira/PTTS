package shu.cssd.transportsystem.controllers.ui;

import org.apache.commons.lang.time.DateUtils;
import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.foundation.exceptions.InvalidTokenDateException;
import shu.cssd.transportsystem.foundation.exceptions.InvalidTokenRouteException;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.helpers.TokenCreator;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.Token;
import shu.cssd.transportsystem.models.User;

import java.util.Date;

public class InspectorMachineController
{
	
	/**
	 * Employee {@link User}
	 */
	private User user;
	
	/**
	 * Route {@link Route}
	 */
	public Route route;
	
	/**
	 * Login the employee
	 *
	 * @param username username
	 * @param password password
	 * @return boolean
	 */
	public boolean login(String username, String password)
	{
		UserController userController = new UserController();
		
		boolean successLogin = userController.checkCredentials(username, password);
		
		this.user = userController.currentUser;
		
		return successLogin;
	}
	
	/**
	 * Check if the token is a valid token
	 *
	 * @param token ${@link Token}
	 * @return boolean
	 * @throws InvalidTokenRouteException if the route is incorrect
	 * @throws InvalidTokenDateException  if the dates are incorrect
	 */
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
	
	/**
	 * Create a token for the user
	 *
	 * @param user        User that requires to make a new ticket
	 * @param origin      Origin of the user
	 * @param destination Destination of the user
	 * @return {@link Token}
	 */
	public Token createToken(User user, Stop origin, Stop destination)
	{
		return TokenCreator.getInstance().createToken(user, PaymentType.CASH, origin, destination);
	}
}
