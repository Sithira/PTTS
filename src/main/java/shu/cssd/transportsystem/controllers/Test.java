package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

public class Test
{
	
	public static void main(String[] args)
	{
		SetOfUsers users = new SetOfUsers();
		
		for (BaseModel model: users.all())
		{
			User user = (User) model;
			
			System.out.println("U --> " + user.username + "  P --> " + user.password);
			System.out.println("PERM ---> " + user.permissionId);
		}
	}
	
}
