package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.foundation.types.GateType;
import shu.cssd.transportsystem.helpers.CostCalculator;
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
        }
        catch (ModelNotFoundException e) {
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

            if(token.destinationStopId.equals(this.currentGate.stopId))
            {
                currentGate.state = OPEN;

                return true;
            }
            else{
                System.out.println("Origin stop is not valid");
                return false;
            }
        }
        catch (ModelNotFoundException e)
        {
            e.printStackTrace();

            return false;
        }
    }

    /**
     * Read Smart Card at the gate
     * @param smartCardId
     * @param gateId
     * @return
     */
    public boolean readSmartCard(String smartCardId, String gateId) {
        String originId;
        Journey currentjourney;
        SetOfStops setOfStops = new SetOfStops();
        Stop currentStop;

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
                    originId = this.currentGate.stopId;

                    JourneyController journeyController = new JourneyController();

                    journeyController.createJourney(smartCard.userId, null, originId, null, null);

                    currentGate.state = OPEN;

                    return true;
                }
                else
                {
                    SetOfJourney setOfJourney = new SetOfJourney();

                    ArrayList<BaseModel> journeys = setOfJourney.all();

                    for (BaseModel model: journeys) {
                        Journey journey = (Journey) model;
                        if (journey.routeId == null && journey.destinationId == null && journey.cost == null)
                        {
                            currentjourney = journey;

                            currentjourney.destinationId = currentGate.stopId;

                            currentStop = (Stop) setOfStops.findById(currentGate.stopId);

                            currentjourney.routeId = currentStop.getRoute().id;

                            currentjourney.cost = (double) CostCalculator.getInstance().calculate(currentjourney.originId, currentjourney.destinationId, currentjourney.routeId);

                            setOfJourney.create(currentjourney);

                            currentGate.state = OPEN;

                            return true;
                        }
                    }
                    return false;
                }
            }
            else
            {
                System.out.println("Smart card has expired");
                return false;
            }
        }
        catch (ModelNotFoundException e)
        {
            return false;
        }
    }
}
