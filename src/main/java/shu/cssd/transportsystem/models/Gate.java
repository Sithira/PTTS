package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.foundation.types.GateType;
import shu.cssd.transportsystem.foundation.types.GateState;
import shu.cssd.transportsystem.models.collections.SetOfStops;

import java.util.ArrayList;

public class Gate extends BaseModel
{
    public GateState state;

    public GateType gateType;

    public String stopId;

    public Gate(GateState state, GateType gateType, String stopId)
    {
        this.state = state;
        this.gateType = gateType;
        this.stopId = stopId;
    }

    /**
     * Get the Stop of the Gate
     *
     * @return
     */
    public Stop getStop()
    {
        try
        {
            return (Stop) (new SetOfStops()).findById(this.stopId);
        }
        catch (ModelNotFoundException e)
        {
            e.printStackTrace();
        }

        return null;
    }

}
