package shu.cssd.transportsystem.helpers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.collections.SetOfStops;

import java.util.ArrayList;

public class CostCalculator {
    private static CostCalculator ourInstance = new CostCalculator();

    public static CostCalculator getInstance() {
        if (ourInstance == null)
        {
        	return new CostCalculator();
        }
        
        return ourInstance;
    }

    private CostCalculator(){}
	
	/**
	 * Get the fees for the selected origin and destination
	 *
	 * @param originId
	 * @param destinationId
	 * @param routeId
	 * @return
	 */
	public float calculate(String originId, String destinationId, String routeId)
    {
        SetOfStops setOfStops = new SetOfStops();

        ArrayList<BaseModel> routeStops = new ArrayList<BaseModel>() ;

        for (BaseModel model: setOfStops.all())
        {
            Stop stop = (Stop) model;

            if(stop.routeId.equals(routeId))
            {
                routeStops.add(stop);
            }
        }

        int originIdIndex = 0;
	
	    for (int i = 0; i < routeStops.size(); i++)
	    {
		    Stop stop = (Stop) routeStops.get(i);
		
		    if(stop.id.equals(originId))
		    {
				originIdIndex = i;
				
				break;
		    }
	    }
	    
	    int hops = 0;
	
	    for (int i = originIdIndex; i < routeStops.size(); i++)
	    {
		    Stop stop = (Stop) routeStops.get(i);
		
		    if(!stop.id.equals(destinationId))
		    {
				hops++;
		    }
	    }
     
	    if (hops == 1)
	    {
	    	return 12;
	    }
	    
	    return 12 + (hops * 3);

    }


}
