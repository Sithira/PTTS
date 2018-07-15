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
		
		Permission permission = (Permission) (new SetOfPermissions()).all().get(0);
		
		User user = new User.Builder("Test", "dfdsdfs", "fdsfsdfd", "fdsfdsf", "fsfsdf", "fsfsdf", "sfsdfd")
				.addAsEmployee(2000, permission)
				.create();
		
		setOfUsers.create(user);
		
		try
		{
			
			User get = (User) this.setOfUsers.findById(user.id);
			
			assertEquals(permission.id, get.permissionId);
			
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
}