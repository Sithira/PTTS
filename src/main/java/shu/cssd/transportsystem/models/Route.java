package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfJourney;
import shu.cssd.transportsystem.models.collections.SetOfStops;
import shu.cssd.transportsystem.models.collections.SetOfVehicles;

import java.util.ArrayList;

public class Route extends BaseModel {

    public String stopId;

    public String journeyId;

    public String vehicleId;

    public String name;

    public String transportType;

    /**
     * Get all the stops for a route
     *
     * @return
     */
    public Stop getStop()
    {
        SetOfStops setOfStops = new SetOfStops();

        ArrayList<BaseModel> stops = setOfStops.all();

        for (BaseModel model: stops)
        {
            Stop stop = (Stop) model;

            if (stop.id.equals(stopId))
            {
                return stop;
            }
        }

        return null;
    }

    /**
     * Get Journeys for a Route
     *
     * @return
     */
    public Journey getJourney()
    {
        SetOfJourney setOfJourney = new SetOfJourney();

        ArrayList<BaseModel> journeys = setOfJourney.all();

        for (BaseModel model: journeys)
        {
            Journey journey = (Journey) model;

            if (journey.id.equals(journeyId))
            {
                return journey;
            }
        }

        return null;
    }


//    public Vehicle getVehicle()
//    {
//        SetOfVehicles setOfVehicles = new SetOfVehicles();
//
//        ArrayList<BaseModel> vehicles = setOfVehicles.all();
//
//        for (BaseModel model: vehicles)
//        {
//            Vehicle vehicle = (Vehicle) model;
//
//            if (Vehicle.id.equals(vehicleId))
//            {
//                return vehicle;
//            }
//        }
//
//        return null;
//    }
}
