package shu.cssd.transportsystem.views.inspectorMachine;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.views.helpers.AlertBox;

import javax.swing.*;
import java.io.IOException;

public class LoginController
{
	@FXML
	private JFXTextField username;
	
	@FXML
	private JFXPasswordField password;
	
	@FXML
	private void login_buttonClick(MouseEvent event) throws IOException
	{
		
		
		if (!UserController.getInstance().checkCredentials(username.getText(), password.getText()))
		{
			AlertBox.getInstance().alertDanger("Incorrect Credentials",
					"You have inserted incorrect conditionals, please check");

			return;
		}
		
		try
		{
			
			if (!UserController.currentUser.getPermission().name.equals("Employee"))
			{
				AlertBox.getInstance().alertDanger("Incorrect Credentials",
						"You don't have correct permission");
				
				return;
			}
		} catch (NullPointerException e)
		{
			AlertBox.getInstance().alertDanger("Whoops. You shouldn't be here",
					"You are missing permission");
			
			return;
		}
		
		Parent homeParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/home/home.fxml"));
		Scene homeScene = new Scene(homeParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(homeScene);
		window.show();
	}
}
