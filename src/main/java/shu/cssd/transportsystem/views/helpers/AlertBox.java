package shu.cssd.transportsystem.views.helpers;

import javafx.scene.control.Alert;

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
	
}
