package shu.cssd.transportsystem.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.foundation.types.TransactionType;
import shu.cssd.transportsystem.helpers.JourneyCreator;
import shu.cssd.transportsystem.models.Journey;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfStops;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import static org.junit.jupiter.api.Assertions.*;

class PaymentManagerControllerTest
{
	
	private PaymentManagerController paymentManagerController;
	
	@BeforeEach
	void Before()
	{
		this.paymentManagerController = new PaymentManagerController();
	}
	
	@Test
	void applyDiscount()
	{
		
		User user = (User) (new SetOfUsers()).all().get(0);
		
		Stop origin = (Stop) (new SetOfStops()).all().get(0);
		
//		Stop destination = (Stop) (new SetOfStops()).all().get(3);
		
//		for (int i = 0; i < 3; i++)
//		{
//			Transaction transaction = new TransactionController()
//					.makeTransaction(user, PaymentType.CASH, TransactionType.SUBSTRACT, 10);
//
//			JourneyCreator.getInstance().createJourney(transaction, origin, destination);
//		}
		
		Transaction transaction = new TransactionController()
				.makeTransaction(user, PaymentType.CASH, TransactionType.SUBSTRACT,  10);
		
		Journey journey = JourneyCreator.getInstance().createJourney(transaction, origin, (Stop) (new SetOfStops()).all().get(4));
		
		assertEquals(10, journey.cost);
		
		this.paymentManagerController.applyDiscount(journey);
		
		assertEquals(8, journey.cost);
		
	}
}