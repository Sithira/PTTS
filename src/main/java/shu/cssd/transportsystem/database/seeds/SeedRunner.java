package shu.cssd.transportsystem.database.seeds;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Seed runner. Populates the data store
 */
public class SeedRunner {
	
	/**
	 * Array of Classes that needs to be run while seeding
	 */
    private static Class[] seeders = {
            /*PermissionLevelSeeder.class,*/
            UserSeeder.class,
            PaymentSeeder.class
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
	    	
	    	// get method names
		    Method[] methods = seeder.getMethods();
		    
		    // for all methods in the array
		    for (String methodName: methodNames)
		    {
		    	
		    	// loop over every method name
			    for (Method method : methods)
			    {
				
			    	// check for the method names
					if (methodName.equals(method.getName()))
					{
						
						try
						{
							
							// invoke the method
							method.invoke(Class.forName(seeder.getName()).newInstance());
							
						} catch (IllegalAccessException e)
						{
							e.printStackTrace();
						} catch (InvocationTargetException e)
						{
							e.printStackTrace();
						} catch (ClassNotFoundException e)
						{
							e.printStackTrace();
						} catch (InstantiationException e)
						{
							e.printStackTrace();
						}
					}
				
			    }
		    }
		    
		
	    }
    }

}
