package shu.cssd.transportsystem.database.seeds;

import java.io.File;
import java.nio.file.Paths;

public class ClearSeeds
{
	
	static String databasePath = Paths.get(".")
			.toAbsolutePath()
			.normalize()
			.toString() + "/database/";
	
	public static void main(String[] args)
	{
		
		// get the file path (file)
		File path = new File(databasePath);
		
		// check if it's an directory
		if (path.isDirectory())
		{
			
			// get all the files into an array
			File[] files = path.listFiles();
			
			// check if we have any files
			if (files != null)
			{
				
				// loop over
				for (File file : files)
				{
					// give a message
					System.out.println("Database file " + file.getName() + " was deleted.");
					
					// delete the file
					file.delete();
				}
				
			}
			
		}
		
	}
	
}
