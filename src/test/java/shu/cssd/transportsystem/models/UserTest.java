package shu.cssd.transportsystem.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.collections.SetOfPermissions;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import static org.junit.jupiter.api.Assertions.*;

class UserTest
{

	private SetOfUsers setOfUsers;
	
	@BeforeEach
	void Before()
	{
		setOfUsers = new SetOfUsers();
	}
	
	@Test
	@DisplayName("Test the builder pattern of user")
	void createNewUser()
	{
		
		// get the permission from the Data store
		Permission permission = (Permission) (new SetOfPermissions()).all().get(0);
		
		// create a new user and assign the permission at the same time
		User user = new User.Builder("Test", "dfdsdfs", "fdsfsdfd", "fdsfdsf", "fsfsdf", "fsfsdf", "sfsdfd")
				.addAsEmployee(2000, permission)
				.create();
		
		// save the user into the database
		setOfUsers.create(user);
		
		try
		{
			
			// get the user by id
			User get = (User) this.setOfUsers.findById(user.id);
			
			// check if the user permission is equal to the actual permission id
			assertEquals(permission.id, get.permissionId);
			
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
}