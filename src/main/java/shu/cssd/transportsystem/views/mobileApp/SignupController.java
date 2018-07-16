package shu.cssd.transportsystem.views.mobileApp;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import shu.cssd.transportsystem.MainApp;
import shu.cssd.transportsystem.foundation.validation.Validator;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.views.helpers.AlertBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable
{
	
	private Validator validator = Validator.getInstance();
	
	@FXML
	AnchorPane anchorpane;
	
	@FXML
	JFXTextField name;
	
	@FXML
	JFXTextField username;
	
	@FXML
	JFXTextField email;
	
	@FXML
	JFXPasswordField password;
	
	@FXML
	JFXPasswordField password_confirm;
	
	@FXML
	JFXTextField address;
	
	@FXML
	JFXTextField city;
	
	@FXML
	JFXTextField postalCode;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
	
	}
	
	@FXML
	public void sign_up(ActionEvent event) throws IOException
	{
		
		// loop through all the properties
		for (Node node : anchorpane.getChildren())
		{
			
			// get the nodes
			if (node instanceof JFXTextField)
			{
				
				// for the email
				if (node.getId().equals("email"))
				{
					
					// add the special validation
					if (!this.validator.isEmail(((JFXTextField) node).getText()))
					{
						AlertBox.getInstance().alertWithHeader("Validation Error", "Email is not in the correct format");
						return;
					}
					
				}
				
				// validate for empty fields
				if (this.validator.isEmpty((JFXTextField) node))
				{
					
					AlertBox.getInstance().alertWithHeader("Validation Error", "Field " + node.getId() + " is empty");
					
					System.out.println("Failed on:" + node.getId());
					
					return;
				}
				
			}
		}
		
		// validate the password confirmation fields
		if (!this.validator.confirm(this.password, this.password_confirm))
		{
			AlertBox.getInstance().alertWithHeader("Validation Error", "Passwords doesn't match");
			
			return;
		}
		
		this.createUser();
		
		Parent dashboardParent = FXMLLoader.load(getClass().getResource("/dashboard/Dashboard.fxml"));
		
		Scene dashboardScene = new Scene(dashboardParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(dashboardScene);
		window.show();
	}
	
	private User createUser()
	{
		
		return new User.Builder(name.getText(), email.getText(), address.getText(),
				city.getText(), postalCode.getText(), username.getText(), password.getText())
				.create();
	}
	
	@FXML
	private void backClick(MouseEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("/login/Scene.fxml"));
		MainApp.stage.getScene().setRoot(root);
	}
}
