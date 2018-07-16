/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shu.cssd.transportsystem.foundation;

import java.io.*;

/**
 * @author sithira
 */
public class Parser implements Serializable
{
	
	private static Parser instance = null;
	
	private Parser() { }
	
	/**
	 * Get an instance of the parser
	 *
	 * @return {@link Parser}
	 */
	public static Parser getInstance()
	{
		if (instance == null)
		{
			instance = new Parser();
		}
		
		return instance;
	}
	
	/**
	 * Read Object when a correct file path is provided.
	 *
	 * @param filename filename
	 * @return {@link Object}
	 */
	public Object readObject(String filename)
	{
		try
		{
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(filename)));
			
			return objectInputStream.readObject();
			
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Write to file when a correct file name is provided
	 *
	 * @param filename Filename
	 * @param object   {@link Object}
	 * @return {@link Object}
	 */
	public void writeObject(String filename, Object object)
	{
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream(new File(filename));
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(object);
			
			objectOutputStream.flush();
		} catch (FileNotFoundException file)
		{
			file.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
