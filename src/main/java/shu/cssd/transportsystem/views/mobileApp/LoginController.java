package shu.cssd.transportsystem.views.mobileApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import shu.cssd.transportsystem.controllers.UserController;


public class LoginController implements Initializable
{
	
	private UserController user;
	
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	
	@FXML
	AnchorPane rootPane;
	AnchorPane secondPane;
	
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		user = UserController.getInstance();
	}
	
	// Goes to the Dashboard
	@FXML
	private void login_buttonClick(ActionEvent event) throws IOException
	{
		
		String currentUsername = username.getText();
		String currentPassword = password.getText();
		
		if (user.checkCredentials(currentUsername, currentPassword))
		{
			Parent dashboardParent = FXMLLoader.load(getClass().getResource("/mobileApp/dashboard/Dashboard.fxml"));
			Scene dashboardScene = new Scene(dashboardParent);
			
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			window.setScene(dashboardScene);
			window.show();
		}
		else
		{
			Parent dashboardParent = FXMLLoader.load(getClass().getResource("/mobileApp/login/Scene.fxml"));
			Scene dashboardScene = new Scene(dashboardParent);
			
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			window.setScene(dashboardScene);
			window.show();
		}
		
	}
	
	// Goes to the Sign Up Page
	
	@FXML
	private void signup_labelClick(javafx.scene.input.MouseEvent event) throws IOException
	{
		// This code opens up in the same Pane
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/mobileApp/signup/signup.fxml"));
		rootPane.getChildren().setAll(pane);
		
		// This code opens up in a new window

        /* Parent signupParent = FXMLLoader.load(getClass().getResource("/signup/signup.fxml"));
            Scene signupScene = new Scene(signupParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(signupScene);
            window.show(); */
		
	}
	
}
