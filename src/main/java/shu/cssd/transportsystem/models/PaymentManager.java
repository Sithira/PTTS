package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfOffers;

public class PaymentManager extends BaseModel
{
	
	
	/**
	 * Get an instance of set of offers
	 *
	 * @return
	 */
	public SetOfOffers getSetOfOffers()
	{
		return new SetOfOffers();
	}

}
