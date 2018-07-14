package shu.cssd.transportsystem.database.seeds;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Seed runner. Populates the data store
 */
public class SeedRunner
{
	
	/**
	 * Set the debug logs
	 */
	private static boolean DEBUG = false;
	
	/**
	 * Array of Classes that needs to be run while seeding
	 */
	private static Class[] seeders = {
			OfferSeeder.class,
			PermissionLevelSeeder.class,
			UserSeeder.class,
			ZoneSeeder.class,
			RouteSeeder.class,
			VehicleSeeder.class,
			StopSeeder.class,
			GateSeeder.class
            //TransactionSmardCardPaymentSeeder.class,

			//JourneySeeder.class,
			//TokenSeeder.class
	};
	
	/**
	 * Method names that should be ran for
	 */
	private static String methodNames[] = {"relationships", "seed", "read"};
	
	/**
	 * Run the SeedRunner to seed the data into the data base
	 *
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		// loop over all classes
		for (Class seeder : seeders)
		{
			
			Object classInstance = null;
			
			try
			{
				classInstance = Class.forName(seeder.getName()).newInstance();
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			} catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			
			// get method names
			Method[] methods = seeder.getMethods();
			
			// for all methods in the array
			for (String methodName : methodNames)
			{
				
				// loop over every method name
				for (Method method : methods)
				{
					
					// check for the method names
					if (methodName.equals(method.getName()))
					{
						
						try
						{
							
							// output debug information
							if (DEBUG)
							{
								System.out.println("Class name: "
										+ seeder.getSimpleName() +
										" Method name: "
										+ method.getName());
							}
							
							// invoke the method
							method.invoke(classInstance);
							
						} catch (IllegalAccessException e)
						{
							e.printStackTrace();
						} catch (InvocationTargetException e)
						{
							e.printStackTrace();
						}
					}
					
				}
			}
			
			
		}
	}
	
}
