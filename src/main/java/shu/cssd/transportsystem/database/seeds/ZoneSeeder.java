package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.models.Zone;
import shu.cssd.transportsystem.models.collections.SetOfZones;

public class ZoneSeeder implements BaseSeeder {

    private SetOfZones setOfZones = new SetOfZones();

    @Override
    public void seed()
    {
        Zone zone1 = new Zone("Maharagama");
        Zone zone2 = new Zone("Maharagama");
        Zone zone3 = new Zone("Maharagama");
        Zone zone4 = new Zone("Maharagama");

        this.setOfZones.create(zone1);
        this.setOfZones.create(zone2);
        this.setOfZones.create(zone3);
        this.setOfZones.create(zone4);
    }

    @Override
    public void read()
    {
        for (BaseModel model : this.setOfZones.all())
        {
            Zone zone = (Zone) model;

            System.out.println("ZoneID: " + zone.id  );
        }
    }

    @Override
    public void relationships(){}
}
