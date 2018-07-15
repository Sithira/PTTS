package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.collections.SetOfGates;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;
import shu.cssd.transportsystem.models.collections.SetOfZones;

import java.util.ArrayList;

public class Stop extends BaseModel
{
    /**
     *
     */
    public String zoneId;

    public String routeId;

    public String name;

    public String latitude;

    public String longitude;


    /**
     * Create a new stop in the system
     * @param zoneId
     * @param routeId
     * @param name
     * @param latitude
     * @param longitude
     */
    public Stop(String zoneId, String routeId, String name, String latitude, String longitude)
    {
        this.routeId = routeId;
        this.zoneId = zoneId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * Get the Zone of a Stop
     *
     * @return
     */
    public Zone getZone()
    {
        try
        {
            return (Zone) (new SetOfZones()).findById(this.zoneId);
        }
        catch (ModelNotFoundException e)
        {
            e.printStackTrace();
        }


        return null;
    }


    /**
     * Get the Route of a Stop
     *
     * @return
     */
    public Route getRoute()
    {
        try
        {
            return (Route)(new SetOfRoutes()).findById(this.routeId);
        }
        catch (ModelNotFoundException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get all the gates of the stops
     * @return
     */
    public ArrayList<Gate> getGates()
    {
        ArrayList<Gate> gates = new ArrayList<Gate>();

        SetOfGates setOfGates = new SetOfGates();

        ArrayList<BaseModel> rows = setOfGates.all();

        for (BaseModel row: rows)
        {
            Gate gate = (Gate) row;

            if (gate.stopId.equals(this.id))
            {
                gates.add(gate);
            }
        }
        return gates;
    }
}
