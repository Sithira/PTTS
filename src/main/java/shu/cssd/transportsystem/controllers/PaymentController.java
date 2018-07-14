package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.Payment;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfPayments;

import java.util.ArrayList;

public class PaymentController
{
	
	private SetOfPayments setOfPayments = new SetOfPayments();
	
	/**
	 * Get all the payments
	 *
	 * @return get all the payments in an arraylist format
	 */
	public ArrayList<BaseModel> payments()
	{
		return this.setOfPayments.all();
	}
	
	public Payment create(User user, PaymentType paymentType)
	{
		Payment payment = new Payment.PaymentCreator(paymentType, )
	}
	
}
