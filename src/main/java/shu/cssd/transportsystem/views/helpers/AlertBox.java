package shu.cssd.transportsystem.views.helpers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertBox
{
	private static AlertBox ourInstance = new AlertBox();
	
	public static AlertBox getInstance()
	{
		return ourInstance;
	}
	
	private AlertBox()
	{
	}
	
	public void alertWithHeader(String title, String message)
	{
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		
		alert.setTitle(title);
		
		alert.setHeaderText(null);
		
		alert.setContentText(message);
		
		alert.showAndWait();
	}
	
	public boolean confirm(String message)
	{
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		
		alert.setTitle("Confirmation required");
		
		alert.setHeaderText(null);
		
		alert.setContentText(message);
		
		Optional<ButtonType> result = alert.showAndWait();
		
		return result.get() == ButtonType.OK;
	}
	
}
