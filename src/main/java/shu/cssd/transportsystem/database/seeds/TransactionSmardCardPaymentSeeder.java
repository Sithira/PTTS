package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.Payment;
import shu.cssd.transportsystem.models.SmartCard;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfPayments;
import shu.cssd.transportsystem.models.collections.SetOfSmartCards;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionSmardCardPaymentSeeder implements BaseSeeder
{
    private SetOfSmartCards setOfSmartCards = new SetOfSmartCards();

    private SetOfPayments setOfPayments = new SetOfPayments();

    private SetOfTransactions setOfTransactions = new SetOfTransactions();

	private  String [] users = new String[5];
	private  String [] payments = new String[5];

	@Override
	public void seed()
	{
		Date date1 = new Date();
		Date date2 = new Date();

		//Seed Transactions
		Transaction transaction1 = new Transaction.TransactionCreator(users[0], payments[0]).create();
		Transaction transaction2 = new Transaction.TransactionCreator(users[1], payments[1]).create();
		Transaction transaction3 = new Transaction.TransactionCreator(users[2], payments[2]).create();
		Transaction transaction4 = new Transaction.TransactionCreator(users[3], payments[3]).create();
		Transaction transaction5 = new Transaction.TransactionCreator(users[4], payments[4]).create();

		//Seed SmartCards
		SmartCard smartCard1 = new SmartCard(users[0], 1111, 111, date1);
		SmartCard smartCard2 = new SmartCard(users[1], 2222, 222, date2);
		SmartCard smartCard3 = new SmartCard(users[2], 3333, 333, date2);
		SmartCard smartCard4 = new SmartCard(users[3], 4444, 444, date2);
		SmartCard smartCard5 = new SmartCard(users[4], 5555, 555, date2);

		//Seed Paments
		Payment payment1 = new Payment.PaymentCreator( transaction1, PaymentType.CASH, 200).setChange(65).create();
		Payment payment2 = new Payment.PaymentCreator( transaction2, PaymentType.CARD, 175).setCard(smartCard1).create();
		Payment payment3 = new Payment.PaymentCreator( transaction3, PaymentType.CASH, 50).setChange(0).create();
		Payment payment4 = new Payment.PaymentCreator( transaction4, PaymentType.CARD, 300).setCard(smartCard2).create();
		Payment payment5 = new Payment.PaymentCreator( transaction5, PaymentType.CARD, 250).setCard(smartCard3).create();


		this.setOfTransactions.create(transaction1);
		this.setOfTransactions.create(transaction2);
		this.setOfTransactions.create(transaction3);
		this.setOfTransactions.create(transaction4);
		this.setOfTransactions.create(transaction5);
		
		this.setOfSmartCards.create(smartCard1);
		this.setOfSmartCards.create(smartCard2);
		this.setOfSmartCards.create(smartCard3);
		this.setOfSmartCards.create(smartCard4);
		this.setOfSmartCards.create(smartCard5);

		this.setOfPayments.create(payment1);
		this.setOfPayments.create(payment2);
		this.setOfPayments.create(payment3);
		this.setOfPayments.create(payment4);
		this.setOfPayments.create(payment5);

	}
	
	@Override
	public void read()
	{

		for (BaseModel model : this.setOfPayments.all())
		{
			Payment payment = (Payment) model;
			
			System.out.println("PayID: " + payment.id  );
			
		}
		
		for (BaseModel model : this.setOfSmartCards.all())
		{
			SmartCard smartCard = (SmartCard) model;
			
			System.out.println("Smart Card UserID: " + smartCard.userId);
		}

		for (BaseModel model: this.setOfTransactions.all())
		{
			Transaction transaction = (Transaction) model;

			System.out.println("TransactionID: " + transaction.id + " T_UserID: " + transaction.userId + " T_PaymentID: " + transaction.paymentId);

		}
	}
	
	@Override
	public void relationships()
	{
		SetOfUsers setOfUsers = new SetOfUsers();
		SetOfPayments setOfPayments = new SetOfPayments();

		for (int i = 0; i < setOfUsers.all().size(); i++)
		{
			
			User user = (User) setOfUsers.all().get(i);

			this.users[i] = user.id;

			System.out.println("relationship: "+user.id);

			//user.cardId = setOfSmartCards.all().get(i).id;
			
		}

		for (int i = 0; i < setOfPayments.all().size(); i++)
		{

			Payment payment = (Payment) setOfPayments.all().get(i);

			this.payments[i] = payment.id;

		}
	}
	
}
