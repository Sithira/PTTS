package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;

public class Offer extends BaseModel
{

	/**
	 * Name of the Offer
	 */
	public String name;

	/**
	 * Number of Journeys
	 */
	public int criteria;

	/**
	 * Discount Amount of the Offer
	 */
	public Float discount;

	/**
	 * Create new Offer in the system
	 *
	 * @param name
	 * @param criteria
	 * @param discount
	 */
	public Offer(String name, int criteria, Float discount)
	{
		this.name = name;
		this.criteria = criteria;
		this.discount = discount;
	}
	
}
