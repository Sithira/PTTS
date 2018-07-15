package shu.cssd.transportsystem.controllers.ui;

import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;

import java.util.ArrayList;

public class MobileAppController
{
	
	private User user;
	
	/**
	 * Login the user
	 *
	 * @param username username of the user
	 * @param password password of the user
	 * @return boolean
	 */
	public boolean login(String username, String password)
	{
		
		UserController userController = UserController.getInstance();
		
		boolean login = userController.checkCredentials(username, password);
		
		this.user = userController.currentUser;
		
		return login;
	}
	
	/**
	 * Logout the user
	 *
	 * @return boolean
	 */
	public boolean logout()
	{
		this.user = null;
		
		return true;
	}
	
	/**
	 * Get the stops that belongs to a route
	 *
	 * @param route {@link Route}
	 * @return {@link Stop}
	 */
	public ArrayList<Stop> getStops(Route route)
	{
		return route.getStops();
	}
	
	/**
	 * Get all the routes in the system
	 *
	 * @return {@link BaseModel}
	 */
	public ArrayList<BaseModel> getRoutes()
	{
		return (new SetOfRoutes()).all();
	}
	
}
