package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.types.PaymentType;

public class Payment extends BaseModel
{
	public PaymentType paymentType;
	
	public String cardId;
	
	public String value;
	
	public String change;
	
	public Payment(PaymentType type, String cardId, String value, String change)
	{
		this.paymentType = type;
		this.cardId = cardId;
		this.value = value;
		this.change = change;
	}
	
	public Payment(PaymentType type, String value, String change)
	{
		this.paymentType = type;
		this.value = value;
		this.change = change;
	}
}

