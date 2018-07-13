package shu.cssd.transportsystem.views;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable
{

	@FXML
	private TextField username;
	@FXML
	private PasswordField password;


	@FXML
	AnchorPane rootPane;
	
	@FXML
	private void login_buttonClick(ActionEvent event) throws IOException
	{
        if (username.getText().equals("admin") && password.getText().equals("admin")){
            Parent dashboardParent = FXMLLoader.load(getClass().getResource("/dashboard/Dashboard.fxml"));
            Scene dashboardScene = new Scene(dashboardParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(dashboardScene);
            window.show();
        }
        else{
            Parent dashboardParent = FXMLLoader.load(getClass().getResource("/login/Scene.fxml"));
            Scene dashboardScene = new Scene(dashboardParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(dashboardScene);
            window.show();
        }


	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{

	}
	

}
