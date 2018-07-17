package shu.cssd.transportsystem.views.helpers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertBox
{
	private static AlertBox ourInstance = new AlertBox();
	
	private Alert.AlertType alertType = Alert.AlertType.INFORMATION;
	
	public static AlertBox getInstance()
	{
		return ourInstance;
	}
	
	private AlertBox()
	{
	}
	
	public void alertDanger(String title, String message)
	{
		this.alertType = Alert.AlertType.ERROR;
		
		this.alertInfo(title, message);
	}
	
	public void alertSuccess(String title, String message)
	{
		this.alertType = Alert.AlertType.CONFIRMATION;
		
		this.alertInfo(title, message);
	}
	
	public void alertInfo(String title, String message)
	{
		Alert alert = new Alert(this.alertType);
		
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
