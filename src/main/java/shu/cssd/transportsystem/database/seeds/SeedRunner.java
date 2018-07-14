package shu.cssd.transportsystem.database.seeds;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Seed runner. Populates the data store
 */
public class SeedRunner {
	
	/**
	 * Array of Classes that needs to be run while seeding
	 */
    private static Class[] seeders = {
            PermissionLevelSeeder.class,
            UserSeeder.class,
    };
	
	/**
	 * Method names that should be ran for
	 */
	private static String methodNames[] = {"seed", "read", "relationships"};
    
    public static void main(String[] args)
    {
	
    	// get the string array to list of strings
	    List<String> list = Arrays.asList(methodNames);
	    
	    // sort the array
	    Collections.sort(list);
	    
	    // reverse the array
	    Collections.reverse(list);
	    
	    methodNames = (String[]) list.toArray();
	    
	    for (Class seeder : seeders)
	    {
		    Method[] methods = seeder.getMethods();
		    
		    for (String methodName: methodNames)
		    {
			    for (Method method : methods)
			    {
				
					if (methodName.equals(method.getName()))
					{
						try
						{
							
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
