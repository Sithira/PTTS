package shu.cssd.transportsystem.foundation.database;

public interface BaseSeeder {
	
	/**
	 * Seed the data into the data storage
	 */
    void seed();
	
	/**
	 * Read the data from the data store
	 */
	void read();
	
	/**
	 * Run the relationships
	 */
	void relationships();
}
