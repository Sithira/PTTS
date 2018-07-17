package shu.cssd.transportsystem.controllers.ui;

import shu.cssd.transportsystem.controllers.TransactionController;
import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.NotEnoughFundsException;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.foundation.types.TransactionType;
import shu.cssd.transportsystem.helpers.CostCalculator;
import shu.cssd.transportsystem.helpers.JourneyCreator;
import shu.cssd.transportsystem.helpers.TokenCreator;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.Token;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;
import shu.cssd.transportsystem.models.collections.SetOfTokens;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;
import shu.cssd.transportsystem.views.helpers.AlertBox;
import shu.cssd.transportsystem.views.tokenMachine.SmartCardController;

import java.util.ArrayList;

public class MobileAppController
{
	
	private UserController userController = UserController.getInstance();
	
	/**
	 * Login the user
	 *
	 * @param username username of the user
	 * @param password password of the user
	 * @return boolean
	 */
	public boolean login(String username, String password)
	{
		return userController.checkCredentials(username, password);
	}
	
	/**
	 * Logout the user
	 *
	 * @return boolean
	 */
	public boolean logout()
	{
		UserController.currentUser = null;
		
		return true;
	}
	
	/**
	 * Get the stops that belongs to a route
	 *
	 * @param route {@link Route}
	 * @return {@link Stop}
	 */
	public ArrayList<Stop> getStops(Route route)
	{
		return route.getStops();
	}
	
	/**
	 * Get all the routes in the system
	 *
	 * @return {@link BaseModel}
	 */
	public ArrayList<BaseModel> getRoutes()
	{
		return (new SetOfRoutes()).all();
	}
	
	/**
	 * Create a token for the provided Stop and Origin
	 *
	 * @param origin      Origin
	 * @param destination Destination
	 * @throws NotEnoughFundsException throws when not enough founds in the account.
	 */
	public void getToken(Stop origin, Stop destination) throws NotEnoughFundsException
	{
		float amount = CostCalculator.getInstance().calculate(origin, destination, destination.getRoute());
		
		if (UserController.currentUser.balance < amount)
		{
			throw new NotEnoughFundsException();
		}
		
		Token token = TokenCreator.getInstance()
				.createToken(UserController.currentUser, PaymentType.CASH, origin, destination);
		
		JourneyCreator.getInstance()
				.createJourney(token.getTransaction(), origin, destination);
		
		(new SetOfTokens()).create(token);
		if(!SmartCardController.from.equals("token")){
			AlertBox.getInstance()
					.alertWithHeader("Success", "Your token has been successfully added to the token list");
		}

	}
	
}
