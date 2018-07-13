package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;

import java.util.ArrayList;

public class Vehicle extends BaseModel
{

    public String routeId;

    public boolean isDelayed;

    public Integer capacity;

    public float timeDelayed;

    public String location;

    public boolean inUse;

    public Vehicle(String routeId, boolean isDelayed, Integer capacity, Float timeDelayed, String location, Boolean inUse)
    {
        this.routeId = routeId;
        this.isDelayed = isDelayed;
        this.capacity = capacity;
        this.timeDelayed = timeDelayed;
        this.location = location;
        this.inUse = inUse;
    }


    /**
     * Get the Route of a Vehicle
     *
     * @return
     */
    public Route getRoute()
    {
        SetOfRoutes setOfRoutes = new SetOfRoutes();

        for (BaseModel model: setOfRoutes.all())
        {

            Route route = (Route) model;

            if (route.id.equals(this.routeId))
            {
                return route;
            }

        }

        return null;
    }
}
