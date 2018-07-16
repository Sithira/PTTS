package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.util.ArrayList;

public class Permission extends BaseModel
{

	/**
	 * Name of the Permission
	 */
	public String name;

	/**
	 * Create a new Permission in the System
	 * @param name
	 */
	public Permission(String name)
	{
		this.name = name;
	}
	
	/**
	 * Get all users belong to the permission.
	 *
	 * @return
	 */
	public ArrayList<User> getUsers()
	{
		// get the all the users
		SetOfUsers setOfUsers = new SetOfUsers();
		
		ArrayList<User> users = new ArrayList<>();
		
		for (BaseModel model: setOfUsers.all())
		{
			User user = (User) model;
			
			if (user.permissionId.equals(this.id))
			{
				users.add(user);
			}
		}
		
		return users;
	}
}
