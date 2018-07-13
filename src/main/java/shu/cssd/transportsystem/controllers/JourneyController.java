package shu.cssd.transportsystem.controllers;

import shu.cssd.transportsystem.models.Journey;
import shu.cssd.transportsystem.models.collections.SetOfJourney;

public class JourneyController
{
    private SetOfJourney setOfJourney = new SetOfJourney();

    private Journey currentJourney;

    /**
     * Creates a new journey in the system
     *
     * @param routeId
     * @param originId
     * @param destinationId
     * @param cost
     * @return Returns a boolean depending on the status of creation
     */
    public boolean createJourney(String routeId, String originId, String destinationId, Double cost)
    {
        Journey journey = new Journey(routeId, originId, destinationId, cost);

        this.currentJourney = journey;

        return setOfJourney.create(journey);
    }
}
