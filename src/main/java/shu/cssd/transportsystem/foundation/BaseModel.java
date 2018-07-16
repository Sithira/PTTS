package shu.cssd.transportsystem.foundation;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * BaseModel
 *
 * @author sithira
 */
public class BaseModel implements Serializable
{
	
	public String id;
	
	public Date created_at, updated_at;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	
	/**
	 * Constructor of the base model
	 */
	public BaseModel()
	{
		this.id = UUID.randomUUID().toString();
		
		Date date = new Date();
		
		this.created_at = date;
		this.updated_at = date;
		
	}
}
