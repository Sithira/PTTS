package shu.cssd.transportsystem.foundation.validation;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator
{
	private static Validator ourInstance = new Validator();
	
	public static Validator getInstance()
	{
		if (ourInstance == null)
		{
			return new Validator();
		}
		
		return ourInstance;
	}
	
	private Validator()
	{
	}
	
	/**
	 * Validates a given email address
	 *
	 * @param email
	 * @return boolean
	 */
	public boolean isEmail(String email)
	{
		
		String regex = "^[\\w-\\+]+(\\.[\\\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
	
	/**
	 * Check if the given text field is empty
	 *
	 * @param textField
	 * @return
	 */
	public boolean isEmpty(JFXTextField textField)
	{
		return textField.getText().isEmpty();
	}
	
	/**
	 * Check if the value is a numeric
	 *
	 * @param textField field to be validated
	 * @return boolean
	 */
	public boolean isNumeric(JFXTextField textField)
	{
		try
		{
			Float.parseFloat(textField.getText());
			
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}
	
	/**
	 * Validate the Two Fields
	 *
	 * @param textField field 1
	 * @param jfxTextField field 2
	 * @return boolean
	 */
	public boolean confirm(JFXPasswordField textField, JFXPasswordField jfxTextField)
	{
		return textField.getText().equals(jfxTextField.getText());
	}
}
