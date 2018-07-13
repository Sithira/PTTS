package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfPermissions;

import java.util.ArrayList;

public class Permission extends BaseModel
{

	public String name;
	
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
		
		// get the all permissions
		SetOfPermissions setOfPermissions = new SetOfPermissions();
		
		// make an empty array
		ArrayList<User> userList = new ArrayList<User>();
		
		// loop throgh array
		for (BaseModel model: setOfPermissions.all())
		{
			User user = (User) model;
			
			if (user.permission_id.equals(this.id))
			{
				// add to the empty array
				userList.add(user);
			}
		}
		
		// return the array
		return userList;
	}
}
