//package shu.cssd.transportsystem.database.seeds;
//
//import shu.cssd.transportsystem.foundation.BaseModel;
//import shu.cssd.transportsystem.foundation.database.BaseSeeder;
//import shu.cssd.transportsystem.models.SmartCard;
//import shu.cssd.transportsystem.models.User;
//import shu.cssd.transportsystem.models.collections.SetOfSmartCards;
//import shu.cssd.transportsystem.models.collections.SetOfUsers;
//
//import java.util.Date;
//
//public class SmartCardSeeder implements BaseSeeder
//{
//	private SetOfSmartCards setOfSmartCards = new SetOfSmartCards();
//
//	@Override
//	public void seed()
//	{
//
//	}
//
//	@Override
//	public void read()
//	{
//
//		for (BaseModel model : this.setOfSmartCards.all())
//		{
//			SmartCard smartCard = (SmartCard) model;
//
//			System.out.println("SmartCardID: " + smartCard.id);
//		}
//
//	}
//
//	@Override
//	public void relationships()
//	{
//		Date date = new Date();
//		
//		SetOfUsers setOfUsers = new SetOfUsers();
//
//		for (int i = 0; i < setOfUsers.all().size(); i++)
//		{
//
//			User user = (User) setOfUsers.all().get(i);
//
//			new SmartCard(user, 1111, 2222, date);
//
//		}
//	}
//}
