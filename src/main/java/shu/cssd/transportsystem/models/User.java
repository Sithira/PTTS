/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;

/**
 * @author sithira
 */
public class User extends BaseModel
{

	public String name;
	
	public String email;
	
	public String address;

	public String city;
	
	public String postalCode;
	
	// Model Relations
	public Account account;
	
	/**
	 * Creates a new User Object that can be saved in the collection.
	 *
	 * @param name
	 * @param email
	 * @param address
	 * @param city
	 * @param postalCode
	 */
	public User(String name, String email, String address, String city, String postalCode)
	{
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
	}
}
