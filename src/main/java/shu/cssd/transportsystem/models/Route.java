package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfJourney;
import shu.cssd.transportsystem.models.collections.SetOfStops;
import shu.cssd.transportsystem.models.collections.SetOfVehicles;
import shu.cssd.transportsystem.foundation.types.TransportType;

import java.util.ArrayList;

public class Route extends BaseModel {

    public String name;

    TransportType transportType;

    public Route(String name, TransportType type)
    {
        this.name = name;
        this.transportType = type;
    }

    /**
     * Get all the stops for a route
     *
     * @return
     */
    public ArrayList<Stop> getStops()
    {
        ArrayList<Stop> stops = new ArrayList<Stop>();

        SetOfStops setOfStops = new SetOfStops();

        ArrayList<BaseModel> rows = setOfStops.all();

        for (BaseModel row: rows)
        {
            Stop stop = (Stop) row;

            if (stop.routeId.equals(this.id))
            {
                stops.add(stop);
            }
        }

        return stops;
    }

    /**
     * Get Journeys for a Route
     *
     * @return
     */
    public ArrayList<Journey> getJourney()
    {
        ArrayList<Journey> journeys = new ArrayList<Journey>();

        SetOfJourney setOfJourney = new SetOfJourney();

        ArrayList<BaseModel> rows = setOfJourney.all();

        for (BaseModel row: rows)
        {
            Journey journey = (Journey) row;

            if (journey.routeId.equals(this.id))
            {
                journeys.add(journey);
            }
        }

        return journeys;
    }


    /**
     * Get Vehicles for a Route
     *
     * @return
     */
    public ArrayList<Vehicle> getVehicles()
    {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        SetOfVehicles setOfVehicles = new SetOfVehicles();

        ArrayList<BaseModel> rows = setOfVehicles.all();

        for (BaseModel row: rows)
        {
            Vehicle vehicle = (Vehicle) row;

            if (vehicle.routeId.equals(this.id))
            {
                vehicles.add(vehicle);
            }
        }

        return vehicles;
    }
}
