package shu.cssd.transportsystem.foundation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest
{

	private Parser parser;
	
	@BeforeEach
	void Before()
	{
		parser = Parser.getInstance();
	}
	
	@Test
	@DisplayName("Parser has only one instance (singleton)")
	void getInstance()
	{
		
		assertEquals(parser, Parser.getInstance());
		
	}
	
	@Test
	@DisplayName("Parser can read objects")
	void readObject()
	{
		String path = Paths.get(".")
				.toAbsolutePath()
				.normalize()
				.toString() + "/database/SetOfUsers.ser";
		
		assertNotNull(parser.readObject(path));
	}
	
	@Test()
	@DisplayName("Parser cannot read objects in an invalid path")
	void readObjectOnAInvalidPath()
	{
		String path = Paths.get(".")
				.toAbsolutePath()
				.normalize()
				.toString() + "/database/fakePath.ser";
		
		assertNull(parser.readObject(path));
	}
	
	@Test
	@DisplayName("Parser can write objects")
	void writeObject()
	{
		
		String path = Paths.get(".")
				.toAbsolutePath()
				.normalize()
				.toString() + "/database/fakePath.ser";
		
		Object o = new Object();
		
		parser.writeObject(path, o);
		
	}
}