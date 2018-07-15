package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.*;
import shu.cssd.transportsystem.models.collections.*;

import java.util.Date;

public class UserTransactionPaymentSeeder implements BaseSeeder
{
	private SetOfUsers setOfUsers = new SetOfUsers();

    private SetOfPayments setOfPayments = new SetOfPayments();

    private SetOfSmartCards setOfSmartCards = new SetOfSmartCards();

    private SetOfTransactions setOfTransactions = new SetOfTransactions();

	private SetOfTokens setOfTokens = new SetOfTokens();

	private SetOfStops setOfStops = new SetOfStops();

	private SetOfJourney setOfJourney = new SetOfJourney();

	private SetOfPermissions setOfPermissions = new SetOfPermissions();

//	private  String [] permissions = new String[5];
//	private  String [] users = new String[5];
	private String [] routes = new String[4];
	private String [] zones = new String[4];

	@Override
	public void seed()
	{

		//Seed Permissions
		Permission permission1 = new Permission("Admin");
		Permission permission2 = new Permission("User");
		Permission permission3 = new Permission("Employee");


		//Seed Users
		User user1 = new User.Builder(
				"Sithira",
				"sithiraac@gmail.com",
				"Rukmalgama",
				"Kottawa",
				"10230",
				"sithira",
				"admin").create();

		User user2 = new User.Builder(
				"Sanura",
				"sanuwijay94@gmail.com",
				"Makumbura",
				"Kottawa",
				"10230",
				"sanura",
				"admin").create();

		User user3 = new User.Builder(
				"Dinusha",
				"dinusha.jayashan01@gmail.com",
				"Hokandara Road, Pannipitiya",
				"Pannipitiya",
				"10230",
				"dinusha",
				"admin").create();

		User user4 = new User.Builder(
				"Chathu",
				"chathu@gmail.com",
				"Bambalapiitya",
				"Colombo",
				"10230",
				"chathu",
				"admin").addAsEmployee(35000, permission3).create();
		
		User user5 = new User.Builder(
				"Vindula",
				"vindu@gmail.com",
				"Kotte",
				"Colombo",
				"10230",
				"vindula",
				"admin").create();


		//Seed SmardCards
		Date date = new Date();

		SmartCard smartCard1 = new SmartCard(user1, 1111, 111, date);
		SmartCard smartCard2 = new SmartCard(user2, 2222, 222, date);
		SmartCard smartCard3 = new SmartCard(user3, 3333, 333, date);
		SmartCard smartCard4 = new SmartCard(user4, 4444, 444, date);
		SmartCard smartCard5 = new SmartCard(user5, 5555, 555, date);

		//Create Permissions
		this.setOfPermissions.create(permission1);
		this.setOfPermissions.create(permission2);
		this.setOfPermissions.create(permission3);

		//Create Users
		this.setOfUsers.create(user1);
		this.setOfUsers.create(user2);
		this.setOfUsers.create(user3);
		this.setOfUsers.create(user4);
		this.setOfUsers.create(user5);

		//Create SmartCards
		this.setOfSmartCards.create(smartCard1);
		this.setOfSmartCards.create(smartCard2);
		this.setOfSmartCards.create(smartCard3);
		this.setOfSmartCards.create(smartCard4);
		this.setOfSmartCards.create(smartCard5);

		//Seed Transactions
		Transaction transaction1 = new Transaction.Builder(user1, PaymentType.CASH, 135).create();
		Transaction transaction2 = new Transaction.Builder(user2, PaymentType.CARD, 175f).fromSmartCard().create();
		Transaction transaction3 = new Transaction.Builder(user3, PaymentType.CASH, 50f).create();
		Transaction transaction4 = new Transaction.Builder(user5, PaymentType.CARD, 300f).fromSmartCard().create();
		Transaction transaction5 = new Transaction.Builder(user5, PaymentType.CARD, 250f).fromSmartCard().create();

		//Seed Payments
		Payment payment1 = new Payment.Builder( transaction1, PaymentType.CASH, 200).setChange(65).create();
		Payment payment2 = new Payment.Builder( transaction2, PaymentType.CARD, 175).create();
		Payment payment3 = new Payment.Builder( transaction3, PaymentType.CASH, 50).setChange(0).create();
		Payment payment4 = new Payment.Builder( transaction4, PaymentType.CARD, 300).create();
		Payment payment5 = new Payment.Builder( transaction5, PaymentType.CARD, 250).create();

		//Seed Stops
		Stop stop1 = new Stop(zones[0], routes[0],"Maharagama", "6.927079", "79.861244");
		Stop stop2 = new Stop(zones[1], routes[1],"Makumbura", "6.937373", "80.262244");
		Stop stop3 = new Stop(zones[2], routes[2],"Galle", "6.917171", "79.761442");
		Stop stop4 = new Stop(zones[3], routes[3],"Peradeniya", "6.823019", "78.961314");
		Stop stop5 = new Stop(zones[0], routes[0],"Udahamulla", "6.770219", "79.831245");
		Stop stop6 = new Stop(zones[1], routes[1],"Jaffna", "6.827372", "79.131243");
		Stop stop7 = new Stop(zones[2], routes[2],"Mathara", "6.923049", "79.661645");
		Stop stop8 = new Stop(zones[3], routes[3],"Badulla", "6.931059", "79.364242");
		Stop stop9 = new Stop(zones[0], routes[0],"Maradana", "6.957372", "78.863549");
		Stop stop10 = new Stop(zones[1], routes[1],"Pettah", "6.977339", "79.465261");

		//Seed Tokens
		Token token1 = new Token(transaction1, stop1, stop2);
		Token token2 = new Token(transaction3, stop10, stop9);

		//Seed Journey
		Journey journey1 = new Journey.Builder(user1, stop1).setDestination(stop5).setCost(135f).create();
		Journey journey2 = new Journey.Builder(user2, stop2).setDestination(stop10).setCost(175f).create();
		Journey journey3 = new Journey.Builder(user3, stop3).setDestination(stop7).setCost(50f).create();
		Journey journey4 = new Journey.Builder(user5, stop4).setDestination(stop8).setCost(300f).create();
		Journey journey5 = new Journey.Builder(user5, stop10).setDestination(stop6).setCost(250f).create();
		Journey journey6 = new Journey.Builder(user5, stop3).setDestination(stop10).setCost(250f).create();





		//Create Transactions
		this.setOfTransactions.create(transaction1);
		this.setOfTransactions.create(transaction2);
		this.setOfTransactions.create(transaction3);
		this.setOfTransactions.create(transaction4);
		this.setOfTransactions.create(transaction5);

		//Create Stops
		this.setOfStops.create(stop1);
		this.setOfStops.create(stop2);
		this.setOfStops.create(stop3);
		this.setOfStops.create(stop4);
		this.setOfStops.create(stop5);
		this.setOfStops.create(stop6);
		this.setOfStops.create(stop7);
		this.setOfStops.create(stop8);
		this.setOfStops.create(stop9);
		this.setOfStops.create(stop10);

		//Create Tokens
		this.setOfTokens.create(token1);
		this.setOfTokens.create(token2);

		//Create Payments
		this.setOfPayments.create(payment1);
		this.setOfPayments.create(payment2);
		this.setOfPayments.create(payment3);
		this.setOfPayments.create(payment4);
		this.setOfPayments.create(payment5);

		//Create Journey
		this.setOfJourney.create(journey1);
		this.setOfJourney.create(journey2);
		this.setOfJourney.create(journey3);
		this.setOfJourney.create(journey4);
		this.setOfJourney.create(journey5);
		this.setOfJourney.create(journey6);

	}
	
	@Override
	public void read()
	{

		for (BaseModel model: this.setOfPermissions.all())
		{
			Permission permission = (Permission) model;

			System.out.println("PermissionID: " + permission.id);

		}

		for (BaseModel model: this.setOfUsers.all())
		{
			User user = (User) model;

			System.out.println("UserID: " + user.id + " Name: " + user.name);
			System.out.println("Smart Card: " + user.getCard().id);
			System.out.println("EMP_PER " + user.permissionId);
			
			if (user.getPermission() != null)
			{
				System.out.println("Employee_Permission: " + user.getPermission().name);
			}
			

		}

		for (BaseModel model: this.setOfSmartCards.all())
		{
			SmartCard smartCard = (SmartCard) model;

			System.out.println("SmartCardUser: " + smartCard.getUser().name);

		}

		for (BaseModel model: this.setOfTransactions.all())
		{
			Transaction transaction = (Transaction) model;

			System.out.println("TransactionUser: " + transaction.getUser().name + " T_SmartCard: " + transaction.smartCardId);

		}

		for (BaseModel model: this.setOfStops.all())
		{
			Stop stop = (Stop) model;

			System.out.println("StopID: " + stop.id);

		}

		for (BaseModel model : this.setOfPayments.all())
		{
			Payment payment = (Payment) model;
			
			System.out.println("PayID: " + payment.id);
			
		}

		for (BaseModel model: this.setOfTokens.all())
		{
			Token token = (Token) model;

			System.out.println("TokenID: " + token.id + " TokenTransaction: " + token.getTransaction().id);

		}

		for (BaseModel model: this.setOfJourney.all())
		{
			Journey journey = (Journey) model;


			System.out.println("JourneyID: " + journey.id + " ,JourneyUser: "
					+ journey.getUser().name + " ,JourneyOrigin: "
					+ journey.getOrigin().name + " ,JourneyDestination: "
					+ journey.destinationId
			);

		}
	}
	
	@Override
	public void relationships()
	{
		SetOfRoutes setOfRoutes = new SetOfRoutes();
		SetOfZones setOfZones = new SetOfZones();


		for (int i = 0; i < setOfRoutes.all().size(); i++)
		{
			Route route = (Route) setOfRoutes.all().get(i);

			this.routes[i] = route.id;

		}


		for (int i = 0; i < setOfZones.all().size(); i++)
		{
			Zone zone = (Zone) setOfZones.all().get(i);

			this.zones[i] = zone.id;
		}
	}
	
}
