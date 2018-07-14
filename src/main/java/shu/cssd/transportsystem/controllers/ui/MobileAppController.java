package shu.cssd.transportsystem.controllers.ui;

import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.User;

import java.util.ArrayList;

public class MobileAppController
{
	
	private User user;
	
	public boolean login(String username, String password)
	{
		
		UserController userController = new UserController();
		
		boolean login = userController.checkCredentials(username, password);
		
		this.user = userController.currentUser;
		
		return login;
	}
	
	public boolean logout()
	{
		this.user = null;
		
		return true;
	}
	
	public ArrayList<Stop> getStops(Route route)
	{
		return route.getStops();
	}
	
}
