package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.models.Payment;
import shu.cssd.transportsystem.models.Transaction;
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
	
	/**
	 * Create a new payment object
	 *
	 * @param transaction A transaction object of a user
	 * @param paymentType A Payment type
	 * @param amount The actual amount
	 * @return {@link Payment}
	 */
	public Payment create(Transaction transaction, PaymentType paymentType, float amount)
	{
		return new Payment.PaymentCreator(transaction, paymentType, amount).create();
	}
	
}
