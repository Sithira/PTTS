package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.foundation.types.GateType;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.foundation.types.TransactionType;
import shu.cssd.transportsystem.helpers.CostCalculator;
import shu.cssd.transportsystem.helpers.JourneyCreator;
import shu.cssd.transportsystem.models.*;
import shu.cssd.transportsystem.models.collections.*;

import java.util.ArrayList;
import java.util.Date;

import static shu.cssd.transportsystem.foundation.types.GateState.CLOSED;
import static shu.cssd.transportsystem.foundation.types.GateState.OPEN;

public class GateController
{
	
	private SetOfGates setOfGates = new SetOfGates();
	
	private Gate currentGate;
	
	public String REASON = "";
	
	public float amountCharged = 0;
	
	/**
	 * Set current Gate
	 *
	 * @return
	 */
	private void setCurrentGate(String gateId)
	{
		try
		{
			currentGate = (Gate) setOfGates.findById(gateId);
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Open Gate for the current instance
	 *
	 * @return
	 */
	public boolean OpenGate()
	{
		this.currentGate.state = OPEN;
		return true;
	}
	
	/**
	 * Close Gate for the currrent instance
	 *
	 * @return
	 */
	public boolean CloseGate()
	{
		this.currentGate.state = CLOSED;
		return true;
	}
	
	/**
	 * Validate Token
	 *
	 * @param tokenId
	 * @param gateId
	 * @return
	 */
	public boolean validateToken(String tokenId, String gateId)
	{
		try
		{
			SetOfTokens setOfTokens = new SetOfTokens();
			
			Token token = (Token) setOfTokens.findById(tokenId);
			
			setCurrentGate(gateId);
			
			if (token.destinationStopId.equals(this.currentGate.stopId))
			{
				currentGate.state = OPEN;
				
				return true;
			} else
			{
				System.out.println("Origin stop is not valid");
				return false;
			}
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
			
			return false;
		}
	}
	
	/**
	 * Read Smart Card at the gate
	 *
	 * @param smartCardId
	 * @param gateId
	 * @return
	 */
	public boolean readSmartCard(String smartCardId, String gateId)
	{
		String originId;
		Journey currentjourney;
		SetOfStops setOfStops = new SetOfStops();
		Stop currentStop;
		Stop originStop;
		Route currentRoute;
		
		try
		{
			SetOfSmartCards setOfSmartCards = new SetOfSmartCards();
			
			SmartCard smartCard = (SmartCard) setOfSmartCards.findById(smartCardId);
			
			Date currentDate = new Date();
			
			if (currentDate.compareTo(smartCard.expiryDate) < 0)
			{
				setCurrentGate(gateId);
				
				if (currentGate.gateType == GateType.ENTRY)
				{

					JourneyCreator.getInstance().createJourney(smartCard.getUser(), this.currentGate.getStop());
					
					currentGate.state = OPEN;
					
					return true;
				}
				else
				{

					ArrayList<Journey> journeys = smartCard.getUser().getJourney();
					
					for (Journey journey : journeys)
					{
						
						if (journey.destinationId == null && journey.cost == 0)
						{
							currentjourney = journey;
							
							currentStop = (Stop) setOfStops.findById(currentGate.stopId);
							
							originStop = (Stop) setOfStops.findById(currentjourney.originId);
							
							currentRoute = currentStop.getRoute();
							
							currentjourney.cost = CostCalculator.getInstance().calculate(originStop, currentStop, currentRoute);
							
							this.amountCharged = currentjourney.cost;
							
							Transaction smartCardTransaction = (new TransactionController())
									.makeTransaction(smartCard.getUser(), PaymentType.CARD, TransactionType.SUBSTRACT, currentjourney.cost);
							
							JourneyCreator.getInstance().createJourney(smartCardTransaction, originStop, currentStop);
							
							currentGate.state = OPEN;
							
							return true;
						}
					}
					
					this.REASON = "NO JOURNEYS FOUND";
					
					return false;
				}
			}
			else
			{
				System.out.println("Smart card has expired");
				
				this.REASON = "CARD HAS EXPIRED";
				
				return false;
			}
		} catch (ModelNotFoundException e)
		{
			return false;
		}
	}
}
