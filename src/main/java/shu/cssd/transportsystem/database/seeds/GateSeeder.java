package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.foundation.types.GateState;
import shu.cssd.transportsystem.foundation.types.GateType;
import shu.cssd.transportsystem.models.Gate;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.collections.SetOfGates;
import shu.cssd.transportsystem.models.collections.SetOfStops;

public class GateSeeder implements BaseSeeder
{
    private SetOfGates setOfGates = new SetOfGates();

    private String [] stops = new String[10];

    @Override
    public void seed()
    {
        Gate gate1 = new Gate(GateState.CLOSED, GateType.ENTRY, stops[0]);
        Gate gate2 = new Gate(GateState.CLOSED, GateType.EXIT, stops[0]);
        Gate gate3 = new Gate(GateState.CLOSED, GateType.ENTRY, stops[1]);
        Gate gate4 = new Gate(GateState.CLOSED, GateType.EXIT, stops[1]);
        Gate gate5 = new Gate(GateState.CLOSED, GateType.ENTRY, stops[2]);
        Gate gate6 = new Gate(GateState.CLOSED, GateType.EXIT, stops[2]);
        Gate gate7 = new Gate(GateState.CLOSED, GateType.ENTRY, stops[3]);
        Gate gate8= new Gate(GateState.CLOSED, GateType.EXIT, stops[3]);
        Gate gate9 = new Gate(GateState.CLOSED, GateType.ENTRY, stops[4]);
        Gate gate10 = new Gate(GateState.CLOSED, GateType.EXIT, stops[4]);
        Gate gate11 = new Gate(GateState.CLOSED, GateType.ENTRY, stops[5]);
        Gate gate12 = new Gate(GateState.CLOSED, GateType.ENTRY, stops[6]);
        Gate gate13 = new Gate(GateState.CLOSED, GateType.ENTRY, stops[7]);
        Gate gate14 = new Gate(GateState.CLOSED, GateType.ENTRY, stops[8]);
        Gate gate15 = new Gate(GateState.CLOSED, GateType.ENTRY, stops[9]);

        this.setOfGates.create(gate1);
        this.setOfGates.create(gate2);
        this.setOfGates.create(gate3);
        this.setOfGates.create(gate4);
        this.setOfGates.create(gate5);
        this.setOfGates.create(gate6);
        this.setOfGates.create(gate7);
        this.setOfGates.create(gate8);
        this.setOfGates.create(gate9);
        this.setOfGates.create(gate10);
        this.setOfGates.create(gate11);
        this.setOfGates.create(gate12);
        this.setOfGates.create(gate13);
        this.setOfGates.create(gate14);
        this.setOfGates.create(gate15);
    }

    @Override
    public void read()
    {
        for (BaseModel model : this.setOfGates.all())
        {
            Gate gate = (Gate) model;

            System.out.println("GateID: " + gate.id + " GateStop: " + gate.getStop().id);
        }
    }

    @Override
    public void relationships()
    {
        SetOfStops setOfStops = new SetOfStops();

        for (int i = 0; i < setOfStops.all().size(); i++)
        {
            Stop stop = (Stop) setOfStops.all().get(i);

            this.stops[i] = stop.id;

            //System.out.println("relationship: "+stop.id);
        }
    }
}
