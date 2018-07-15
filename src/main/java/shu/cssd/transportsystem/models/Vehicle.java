package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;

import java.util.ArrayList;

public class Vehicle extends BaseModel
{

    /**
     * Id of the Route Vehicle travels
     */
    public String routeId;

    /**
     * Boolean value of the Vehicle is delayed or not
     */
    public boolean isDelayed;

    /**
     * Passenger capacity of the Vehicle
     */
    public Integer capacity;

    /**
     * Float value of the time that Vehicle delayed
     */
    public float timeDelayed;

    /**
     * Location of the Vehicle
     */
    public String location;

    /**
     * Boolean value of the Vehicle is in Use or not
     */
    public boolean inUse;


    /**
     * Create new Vehicle in the system
     *
     * @param routeId
     * @param isDelayed
     * @param capacity
     * @param timeDelayed
     * @param location
     * @param inUse
     */
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
     * @return {@link Route}
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
