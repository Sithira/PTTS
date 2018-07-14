package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.foundation.types.TransportType;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;

public class RouteSeeder implements BaseSeeder {
    private SetOfRoutes setOfRoutes = new SetOfRoutes();

    @Override
    public void seed()
    {
        Route route1 = new Route("138",TransportType.BUS);
        Route route2 = new Route("Ruhunu Kumari",TransportType.TRAIN);
        Route route3 = new Route("Udarata Manike",TransportType.TRAIN );
        Route route4 = new Route("336",TransportType.BUS);

        this.setOfRoutes.create(route1);
        this.setOfRoutes.create(route2);
        this.setOfRoutes.create(route3);
        this.setOfRoutes.create(route4);

        read();
    }

    @Override
    public void read()
    {
        for (BaseModel model: this.setOfRoutes.all())
        {
            Route route = (Route) model;

            System.out.println("RouteID: " + route.id);
        }
    }

    @Override
    public void relationships(){}

}
