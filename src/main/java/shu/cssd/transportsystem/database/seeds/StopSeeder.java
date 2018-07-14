package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.Zone;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;
import shu.cssd.transportsystem.models.collections.SetOfStops;
import shu.cssd.transportsystem.models.collections.SetOfZones;

public class StopSeeder implements BaseSeeder {

    private SetOfStops setOfStops = new SetOfStops();

    private String [] routes = new String[4];

    private String [] zones = new String[4];

    @Override
    public void seed()
    {
        Stop stop1 = new Stop(zones[0], routes[0],"Maharagama", "6.927079", "79.861244");
        Stop stop2 = new Stop(zones[1], routes[1],"Makumbura", "6.937373", "80.262244");
        Stop stop3 = new Stop(zones[2], routes[2],"Galle", "6.917171", "79.761442");
        Stop stop4 = new Stop(zones[3], routes[3],"Peradeniya", "6.823019", "78.961314");
        Stop stop5 = new Stop(zones[0], routes[0],"Udahamulla", "6.770219", "79.831245");
        Stop stop6 = new Stop(zones[1], routes[1],"Jaffna", "6.827372", "79.131243");
        Stop stop7 = new Stop(zones[2], routes[2],"Mathara", "6.923049", "79.661645");
        Stop stop8 = new Stop(zones[3], routes[3],"Badulla", "6.931059", "79.364242");
        Stop stop9 = new Stop(zones[0], routes[0],"Maradana", "6.957372", "78.863549");
        Stop stop10 = new Stop(zones[1], routes[1],"Pettah", "6.977339", "79.465261");

        this.setOfStops.create(stop1);
        this.setOfStops.create(stop2);
        this.setOfStops.create(stop3);
        this.setOfStops.create(stop4);
        this.setOfStops.create(stop5);
        this.setOfStops.create(stop6);
        this.setOfStops.create(stop7);
        this.setOfStops.create(stop8);
        this.setOfStops.create(stop9);
        this.setOfStops.create(stop10);
    }

    @Override
    public void read()
    {
        for (BaseModel model : this.setOfStops.all())
        {
            Stop stop = (Stop) model;

            System.out.println("StopID: " + stop.id);
        }
    }

    @Override
    public void relationships()
    {
        SetOfRoutes setOfRoutes = new SetOfRoutes();

        for (int i = 0; i < setOfRoutes.all().size(); i++)
        {
            Route route = (Route) setOfRoutes.all().get(i);

            this.routes[i] = route.id;

            System.out.println("relationship: "+route.id);
        }

        SetOfZones setOfZones = new SetOfZones();

        for (int i = 0; i < setOfZones.all().size(); i++)
        {
            Zone zone = (Zone) setOfZones.all().get(i);

            this.zones[i] = zone.id;

            System.out.println("relationship: "+zone.id);
        }

    }
}
