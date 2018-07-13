package shu.cssd.transportsystem.helpers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.collections.SetOfStops;

import java.util.ArrayList;

public class CostCalculator {
    private static CostCalculator ourInstance = new CostCalculator();

    public static CostCalculator getInstance() {
        return ourInstance;
    }

    private CostCalculator(String originId, String destinationId, String routeId)
    {
        SetOfStops setOfStops = new SetOfStops();

        ArrayList<BaseModel> stops = setOfStops.all();

        ArrayList<BaseModel> routeStops = new ArrayList<BaseModel>() ;

        for (BaseModel model: stops)
        {
            Stop stop = (Stop) model;

            if(stop.routeId.equals(routeId))
            {
                routeStops.add(stop);
            }
        }

        for (BaseModel model: routeStops)
        {
            Stop stop = (Stop) model;

            if(stop.id.equals(originId))
            {

            }
        }
    }


}
