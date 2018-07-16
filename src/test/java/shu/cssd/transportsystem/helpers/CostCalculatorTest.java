package shu.cssd.transportsystem.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.collections.SetOfStops;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CostCalculatorTest
{
	
	private CostCalculator costCalculator;
	
	@BeforeEach
	void setUp()
	{
		costCalculator = CostCalculator.getInstance();
	}
	
	@Test
	@DisplayName("Check Singleton returns same instance")
	void getInstance()
	{
		
		assertEquals(costCalculator, CostCalculator.getInstance());
		
	}
	
	@Test
	@DisplayName("Check if the cost between two stops are minimum")
	void calculate()
	{
		
		ArrayList<BaseModel> stopes = new SetOfStops().all();
	
		assertNotEquals(stopes.size(), 0);
		
		Stop origin = (Stop) stopes.get(0);
		
		Stop destination = (Stop) stopes.get(1);
		
		assertEquals(costCalculator.calculate(origin, destination, destination.getRoute()), 18);
	
	}
}