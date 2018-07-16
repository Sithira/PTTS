package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

public class Test
{
	
	public static void main(String[] args)
	{
		
		SetOfUsers users = new SetOfUsers();
		
//		User u = (User) users.all().get(0);
//
//		System.out.println("U Na:" + u.name);
//
//		u.balance = 100;
//
//		try
//		{
//			users.findByIdAndUpdate(u.id, u);
//		} catch (ModelNotFoundException e)
//		{
//			e.printStackTrace();
//		}
		
		for(BaseModel model: users.all())
		{
			User user = (User) model;
			
			System.out.println("Name:" + user.name + "Balance:" + user.balance);
		}
	}
	
}
