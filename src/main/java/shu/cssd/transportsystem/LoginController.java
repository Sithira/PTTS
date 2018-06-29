package shu.cssd.transportsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable
{
	
	@FXML
	private Label label;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	@FXML
	AnchorPane rootPane;
	
	@FXML
	private void handleButtonAction(ActionEvent event)
	{

	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		//username =
	}
	
	public void login() throws IOException
	{
		if (username.getText().equals("admin") && password.getText().equals("admin"))
		{
			
			AnchorPane root = FXMLLoader.load(getClass().getResource("/dashboard/Dashboard.fxml"));
			
			rootPane.getChildren().setAll(root);
			
		}
	}
	
	public void switchToMainDashboard(ActionEvent event)
	{
		//(new DashboardController()).loadDashBoard(event);
	}
}
