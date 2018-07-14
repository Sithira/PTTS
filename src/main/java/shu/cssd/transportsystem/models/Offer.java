package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;

public class Offer extends BaseModel
{

	public String name;
	
	public int criteria;
	
	public Float discount;

	public Offer(String name, int criteria, Float discount)
	{
		this.name = name;
		this.criteria = criteria;
		this.discount = discount;
	}
	
}
