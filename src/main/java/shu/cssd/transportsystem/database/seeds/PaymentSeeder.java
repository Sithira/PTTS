package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.Payment;
import shu.cssd.transportsystem.models.SmartCard;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfPayments;
import shu.cssd.transportsystem.models.collections.SetOfSmartCards;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentSeeder implements BaseSeeder
{
	
	public String[] order = {};
	
	private SetOfPayments setOfPayments = new SetOfPayments();
	private SetOfSmartCards setOfSmartCards = new SetOfSmartCards();
	private  String [] users = new String[4];

	@Override
	public void seed()
	{
		
		Date date1 = new Date();
		Date date2 = new Date();
		
		
		SmartCard smartCard1 = new SmartCard(users[0], 1111, 111, date1);
		SmartCard smartCard2 = new SmartCard(users[1], 2222, 222, date2);
		SmartCard smartCard3 = new SmartCard(users[2], 3333, 333, date2);
		SmartCard smartCard4 = new SmartCard(users[3], 4444, 444, date2);
		
		Payment payment1 = new Payment.PaymentCreator(PaymentType.CASH, 300).setChange(0).create();
		Payment payment2 = new Payment.PaymentCreator(PaymentType.CARD, 200).setCard(smartCard1).create();
		Payment payment3 = new Payment.PaymentCreator(PaymentType.CASH, 50).setChange(0).create();
		Payment payment4 = new Payment.PaymentCreator(PaymentType.CARD, 750).setCard(smartCard2).create();
		
		
		this.setOfSmartCards.create(smartCard1);
		this.setOfSmartCards.create(smartCard2);
		this.setOfSmartCards.create(smartCard3);
		this.setOfSmartCards.create(smartCard4);
		
		
		this.setOfPayments.create(payment1);
		this.setOfPayments.create(payment2);
		this.setOfPayments.create(payment3);
		this.setOfPayments.create(payment4);
		
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
	}
	
	@Override
	public void relationships()
	{
		SetOfUsers setOfUsers = new SetOfUsers();
		
		
		for (int i = 0; i < setOfUsers.all().size(); i++)
		{
			
			User user = (User) setOfUsers.all().get(i);

			this.users[i] = user.id;

			System.out.println("relationship: "+user.id);

			//user.cardId = setOfSmartCards.all().get(i).id;
			
		}
		
	}
	
}
