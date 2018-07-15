package shu.cssd.transportsystem.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shu.cssd.transportsystem.models.Permission;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfPermissions;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest
{
	
	private UserController userController  = UserController.getInstance();
	
	@Test
	@DisplayName("A User can be created with the user controller")
	void createEmployee()
	{
		Permission permission = (Permission) (new SetOfPermissions()).all().get(0);
		
		boolean result = userController.createEmployee("ewewwew", "rewrewrewr",
				"ewrewrwer", "ewrewrwe", "w34w3", 10000,
				permission, "rwrwrew", "fsefsd");
		
		assertTrue(result);
	}
	
	@Test
	void createUser()
	{
		boolean result = userController.createUser("ewewwew", "rewrewrewr",
				"ewrewrwer", "ewrewrwe", "w34w3","rwrwrew", "fsefsd");
		
		assertTrue(result);
	}
	
	@Test
	void checkCredentials()
	{
		boolean result = this.userController.checkCredentials("sithira", "admin");
		
		assertTrue(result);
		
		assertNotNull(this.userController.currentUser);
		
	}
	
	@Test
	void topUpBalance()
	{
		
		
		this.userController.checkCredentials("sithira", "admin");
		
		assertNotNull(this.userController.currentUser);
		
		this.userController.topUpBalance(1000f);
		
		assertEquals(1000f, this.userController.currentUser.balance);
	}
}