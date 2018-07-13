package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.types.TransportType;
import shu.cssd.transportsystem.models.Journey;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;

import java.util.ArrayList;

public class RouteController
{

    private SetOfRoutes setOfRoutes = new SetOfRoutes();

    private Route route;

    private Journey currentJourney;

    /**
     * Validate the Route
     *
     * @param routeId
     * @return
     */
    public boolean validateRoute(String routeId)
    {
        ArrayList<BaseModel> routes = this.setOfRoutes.all();

        for (BaseModel model: routes)
        {
            Route route = (Route) model;

            if (route.id.equals(routeId))
            {
                this.route = route;

                return true;
            }
        }

        return false;
    }


    /**
     * Get Routes for the Journey
     *
     * @param source
     * @param destination
     * @return
     */
    public String searchRouteForJourney(String source, String destination)
    {
        ArrayList<BaseModel> routes = this.setOfRoutes.all();

        for (BaseModel model: routes)
        {
            Journey journey = (Journey) model;

            if (journey.getOrigin().equals(source) &&  journey.getDestination().equals(destination))
            {
                this.currentJourney = journey;
            }
        }

        return route.name;
    }

//    /**
//     * Create a Route
//     *
//     * @param name
//     * @param transportType
//     * @return
//     */
//    public boolean createRoute(String name, TransportType transportType)
//    {
//        Route route = new Route(name, transportType).create();
//
//
//    }
}
