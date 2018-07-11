package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;

public class Transaction extends BaseModel
{
	
	public String userId;
	
	public Payment payment;
	
	public Token token;
	
	public String transactionType;
	
	public String purchaseLocation;
	
}
