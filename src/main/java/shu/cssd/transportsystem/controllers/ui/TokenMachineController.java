package shu.cssd.transportsystem.controllers.ui;

import shu.cssd.transportsystem.controllers.TransactionController;
import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.NotEnoughFundsException;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.helpers.CostCalculator;
import shu.cssd.transportsystem.helpers.TokenCreator;
import shu.cssd.transportsystem.models.*;
import shu.cssd.transportsystem.models.collections.SetOfPayments;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;
import shu.cssd.transportsystem.models.collections.SetOfStops;

import java.util.ArrayList;
import java.util.Random;

public class TokenMachineController
{

	public Stop origin, destination;
	
	public Route route;
	
	private SetOfStops setOfStops = new SetOfStops();
	
	private Stop currentStop;
	
	private User loggedInUser;
	private float fare;
	
	TokenMachineController()
	{
		
		// get the size of the stop list
		int size = setOfStops.all().size();
		
		// getting an random stop from the list of stops.
		this.currentStop = (Stop) this.setOfStops.all().get(new Random().nextInt((0 - size) + 1) + size);
		
	}
	
	/**
	 * Login the user into the token machine
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password)
	{
		
		UserController userController = new UserController();
		
		if (userController.checkCredentials(username, password))
		{
			this.loggedInUser = userController.currentUser;
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Create a token
	 *
	 * @param paymentType Payment type
	 * @param origin Origin of the user
	 * @param destination Destination of the user
	 * @return {@link Token}
	 */
	public Token createToken(PaymentType paymentType, Stop origin, Stop destination)
	{
		 this.fare = CostCalculator
				.getInstance()
				.calculate(origin, destination, this.route);
		
		return TokenCreator.getInstance().createToken(loggedInUser, paymentType, origin, destination);
	}
	
	/**
	 * Accept the payment by cash
	 *
	 * @param paymentType {@link PaymentType}
	 * @param amount
	 * @return {@link Payment}
	 * @throws NotEnoughFundsException
	 */
	public Payment acceptPayment(PaymentType paymentType, float amount) throws NotEnoughFundsException
	{
		
		float change = 0;
		
		if (amount < this.fare)
		{
			throw new NotEnoughFundsException();
		}
		
		if (amount > this.fare)
		{
			change = amount - this.fare;
		}
		
		SetOfPayments setOfPayments = new SetOfPayments();
		
		Transaction transaction = (new TransactionController()).makeTransaction(this.loggedInUser, paymentType, amount);
		
		Payment payment = new Payment.PaymentCreator(transaction, PaymentType.CASH, amount)
				.setChange(change)
				.create();
		
		setOfPayments.create(payment);
		
		return payment;
	}
	
	/**
	 * Get all the stops that belongs to a stop
	 *
	 * @param route
	 * @return
	 */
	public ArrayList<Stop> getStops(Route route)
	{
		return route.getStops();
	}
	
	/**
	 * Get all the routes in the system.
	 *
	 * @return
	 */
	public ArrayList<BaseModel> getRoutes()
	{
		return (new SetOfRoutes()).all();
	}
	
}
