package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.Gate;
import shu.cssd.transportsystem.models.Token;
import shu.cssd.transportsystem.models.collections.SetOfGates;
import shu.cssd.transportsystem.models.collections.SetOfTokens;

import java.util.ArrayList;

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
    public void setCurrentGate(String gateId)
    {
        ArrayList<BaseModel> Gates = this.setOfGates .all();

        for (BaseModel model: Gates)
        {
            Gate gate = (Gate) model;

            if (gate.id.equals(gateId))
            {
                currentGate = gate;
            }
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

            if(token.source_stop_id.equals(this.currentGate.stopId))
            {
                return true;
            }
            else{
                System.out.println("Source stop is not valid");
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
     * Read Smart Card
     *
     *
     */

}
