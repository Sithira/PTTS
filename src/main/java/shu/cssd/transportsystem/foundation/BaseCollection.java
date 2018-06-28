/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shu.cssd.transportsystem.foundation;

import shu.cssd.transportsystem.models.exceptions.ModelNotFoundException;

import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author sithira
 */
public class BaseCollection implements Serializable
{
	
	// actual path for the serialized object
	private String collectionPath;
	
	// file manager to create / check for serialized objects
	private FileManager fileManager;
	
	// arraylist to keep the data in an array
	private ArrayList<BaseModel> rows;
	
	// parser to parse and get the object from the data store.
	private Parser parser = Parser.getInstance();
	
	/**
	 *  Build the Collection Instance in the memory.
	 */
	public BaseCollection()
	{
		// build the path for the file
		this.collectionPath = Paths.get(".")
				.toAbsolutePath()
				.normalize()
				.toString() + "/database/" + this.getClass().getSimpleName() + ".ser";
		
		// get the file manager
		fileManager = new FileManager(this.collectionPath);
		
		// check for the file existence
		if (fileManager.exists())
		{
			// get the arraylist from the class
			this.rows = ((BaseCollection) this.parser.readObject(collectionPath)).rows;
		} else
		{
			
			// create the new array list
			this.rows = new ArrayList<BaseModel>();
			
			// create the new file in the file system
			this.fileManager.create();
		}
		
	}
	
	/**
	 * Find the Model by the UUID
	 *
	 * @param id unique UUID
	 * @return BaseModel
	 * @throws ModelNotFoundException Model not found in the collection
	 */
	public BaseModel findById(String id) throws ModelNotFoundException
	{
		
		// loop through the arraylist
		for (BaseModel row : this.rows)
		{
			
			// get the Model by id (UUID)
			if (row.id.equals(id))
			{
				
				// return the BaseModel if found
				return row;
			}
		}
		
		// throw the exception if no model found
		throw new ModelNotFoundException(id);
	}
	
	/**
	 * Find by the model id and update
	 *
	 * @param id unique identification
	 * @param payload Object payload that's gonna get saved in the database
	 * @return boolean status of the update
	 * @throws ModelNotFoundException throws if model is not found
	 */
	public boolean findByIdAndUpdate(String id, BaseModel payload) throws ModelNotFoundException
	{
		
		// removes the current object from the memory
		this.remove(id);
		
		// create a new object
		return this.create(payload);
		
	}
	
	/**
	 * Adds a new element to the collection
	 *
	 * @param payload  New Object that is saving to the data store
	 * @return boolean
	 */
	public boolean create(BaseModel payload)
	{
		
		// add to the collection
		boolean write = this.rows.add(payload);
		
		// write the collection to the data store
		this.parser.writeObject(collectionPath, this);
		
		// return the bool
		return write;
	}
	
	/**
	 * Remove an Model instance from the collection
	 *
	 * @param id unique id (UUID)
	 * @throws ModelNotFoundException
	 */
	public void remove(String id) throws ModelNotFoundException
	{
		
		// get the object from the data store
		Object object = findById(id);
		
		// remove the object from the arraylist
		this.rows.remove(object);
		
		// save the changes into the data store
		this.save();
	}
	
	/**
	 * Serialize the object in the database
	 */
	public void save()
	{
		// write the current status of the data store
		this.parser.writeObject(collectionPath, this);
	}
	
	/**
	 * Get the data from the Collection (ArrayList)
	 *
	 * @return ArrayList
	 */
	public ArrayList<BaseModel> getRows()
	{
		return this.rows;
	}
	
}
