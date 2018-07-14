package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.Vehicle;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;
import shu.cssd.transportsystem.models.collections.SetOfVehicles;

public class VehicleSeeder implements BaseSeeder {
    private SetOfVehicles setOfVehicles = new SetOfVehicles();

    private String [] routes = new String[4];

    @Override
    public void seed()
    {
        VehicleSeeder vehicleSeeder = new VehicleSeeder();

        Vehicle vehicle1 = new Vehicle(routes[0],false,50, 0f, "Maharagama", true );
        Vehicle vehicle2 = new Vehicle(routes[1],true,200,5f, "Kottawa", true );
        Vehicle vehicle3 = new Vehicle(routes[2],false,300, 0f, "Nugegoda", true );
        Vehicle vehicle4 = new Vehicle(routes[3],false,40, 0f, "Malabe", true );

        this.setOfVehicles.create(vehicle1);
        this.setOfVehicles.create(vehicle2);
        this.setOfVehicles.create(vehicle3);
        this.setOfVehicles.create(vehicle4);

        read();
    }

    @Override
    public void read()
    {
        for (BaseModel model: this.setOfVehicles.all())
        {
            Vehicle vehicle = (Vehicle) model;

            System.out.println("VehicleID: " + vehicle.id);

            System.out.println("VehicleRouteID: " + vehicle.routeId);
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
    }
}
