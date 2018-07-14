package shu.cssd.transportsystem.controllers.ui;

import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.foundation.exceptions.NotEnoughFundsException;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.helpers.CostCalculator;
import shu.cssd.transportsystem.models.*;
import shu.cssd.transportsystem.models.collections.*;

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
	 * Create the token for the journey
	 *
	 * @return
	 */
	public Token createToken(Stop origin, Stop destination)
	{
		 this.fare = CostCalculator
				.getInstance()
				.calculate(origin.id, destination.id, this.route.id);
		
		return null;
	}
	
	/**
	 * Accept the payment by cash
	 *
	 * @param amount
	 * @return
	 * @throws NotEnoughFundsException
	 */
	public Payment acceptPayment(float amount) throws NotEnoughFundsException
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
		
		Payment payment = new Payment.PaymentCreator(PaymentType.CASH, amount)
				.setChange(change)
				.create();
		
		setOfPayments.create(payment);
		
		SetOfTransactions setOfTransactions = new SetOfTransactions();
		
		Transaction transaction = new Transaction.TransactionCreator(this.loggedInUser.id, payment.id)
				.create();
		
		setOfTransactions.create(transaction);
		
		return payment;
	}
	
	/**
	 * Accept the payment by card
	 *
	 * @param card
	 * @return
	 * @throws NotEnoughFundsException
	 */
	public Payment acceptPayment(SmartCard card) throws NotEnoughFundsException
	{
		
		
		// check if the balance is less than fare
		if (card.balance < this.fare)
		{
			
			// if it is throw an exception
			throw new NotEnoughFundsException();
		}
		
		SetOfPayments setOfPayments = new SetOfPayments();
		
		Payment payment = new Payment.PaymentCreator(PaymentType.CARD, fare)
				.setCard(card)
				.create();
		
		setOfPayments.create(payment);
		
		SetOfTransactions setOfTransactions = new SetOfTransactions();
		
		Transaction transaction = new Transaction.TransactionCreator(this.loggedInUser.id, payment.id)
				.create();
		
		setOfTransactions.create(transaction);
		
		card.balance = card.balance - fare;
		
		try
		{
			(new SetOfSmartCards()).findByIdAndUpdate(card.id, card);
			
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
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
