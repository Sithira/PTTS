package shu.cssd.transportsystem.models;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;
import shu.cssd.transportsystem.models.collections.SetOfZones;

import java.util.ArrayList;

public class Stop extends BaseModel
{
    public String zoneId;

    public String routeId;

    public String name;

    public String latitude;

    public String longitude;


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
        SetOfZones setOfZones = new SetOfZones();

        for (BaseModel model: setOfZones.all())
        {

            Zone zone = (Zone) model;

            if (zone.id.equals(this.zoneId))
            {
                return zone;
            }

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
