package shu.cssd.transportsystem.foundation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
		
		assertEquals(Parser.getInstance(), parser);
		
	}
	
	@Test
	void readObject()
	{
	}
	
	@Test
	void writeObject()
	{
	}
}