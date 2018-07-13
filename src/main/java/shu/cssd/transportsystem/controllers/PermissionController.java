package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.Permission;
import shu.cssd.transportsystem.models.collections.SetOfPermissions;

public class PermissionController
{
	
	// set of permissions
	private SetOfPermissions setOfPermissions = new SetOfPermissions();
	
	/**
	 * Create a new permission in the system
	 *
	 * @param name
	 * @return
	 */
	public Permission create(String name)
	{
		Permission permission = new Permission(name);
		
		this.setOfPermissions.create(permission);
		
		return permission;
	}
	
	/**
	 * Get the permission given a permission id
	 *
	 * @param permissionId
	 * @return
	 */
	public Permission get(String permissionId)
	{
		try
		{
			return (Permission) setOfPermissions.findById(permissionId);
			
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Update a given permission
	 *
	 * @param permission
	 * @return
	 */
	public boolean update(Permission permission)
	{
		try
		{
			return this.setOfPermissions.findByIdAndUpdate(permission.id, permission);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Delete a given permission
	 *
	 * @param permission
	 */
	public void delete(Permission permission)
	{
		try
		{
			this.setOfPermissions.remove(permission.id);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
}
