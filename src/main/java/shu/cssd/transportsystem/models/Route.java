package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfStops;

import java.util.ArrayList;

public class Route extends BaseModel {

    public String stopId;

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

//    /**
//     * Get Journeys for a Route
//     *
//     * @return
//     */
//    public Journey getJourney()
//    {
//        SetOfStops setOfStops = new SetOfStops();
//
//        ArrayList<BaseModel> stops = setOfStops.all();
//
//        for (BaseModel model: stops)
//        {
//            Stop stop = (Stop) model;
//
//            if (stop.id.equals(stopId))
//            {
//                return stop;
//            }
//        }
//
//        return null;
//    }
//
//
//    public Vehicle getVehicle()
//    {
//
//    }
}
