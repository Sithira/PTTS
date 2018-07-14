package shu.cssd.transportsystem.helpers;

import org.junit.Test;

import static org.junit.Assert.*;

public class CostCalculatorTest
{
	
	@Test
	public void getInstance()
	{
		
		CostCalculator calculator = CostCalculator.getInstance();
		
		CostCalculator calculator1 = CostCalculator.getInstance();
		
		assertEquals("Should be the same object of the CostCalculator Class", calculator1, calculator);
		
	}
	
	@Test
	public void calculate()
	{
	}
}