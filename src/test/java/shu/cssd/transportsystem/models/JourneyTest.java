package shu.cssd.transportsystem.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shu.cssd.transportsystem.foundation.exceptions.ModelNotFoundException;
import shu.cssd.transportsystem.models.collections.SetOfJourney;
import shu.cssd.transportsystem.models.collections.SetOfStops;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class JourneyTest
{

	SetOfJourney setOfJourney;
	
	@BeforeEach
	void Before()
	{
		this.setOfJourney = new SetOfJourney();
	}
	
	@Test()
	@DisplayName("Can Create a new journey with Destination")
	void canCreateNewJourneyWithDestination()
	{
		
		User user = (User) (new SetOfUsers()).all().get(0);
		
		Stop origin = (Stop) (new SetOfStops()).all().get(0);
		Stop destination = (Stop) (new SetOfStops()).all().get(4);
		
		Journey journey = new Journey.Builder(user, origin)
				.setDestination(destination)
				.create();
		
		this.setOfJourney.create(journey);
		
		try
		{
			Journey byId = (Journey) this.setOfJourney.findById(journey.id);
			
			assertEquals(destination.id, byId.destinationId);
			
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test
	@DisplayName("A Journey Can be created without a destination")
	void canCreateANewJourneyWithOutDestination()
	{
		
		User user = (User) (new SetOfUsers()).all().get(0);
		
		Stop origin = (Stop) (new SetOfStops()).all().get(0);
		
		Journey journey = new Journey.Builder(user, origin)
				.create();
		
		this.setOfJourney.create(journey);
		
		try
		{
			Journey byId = (Journey) this.setOfJourney.findById(journey.id);
			
			assertNull(byId.destinationId);
			
		} catch (ModelNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
}