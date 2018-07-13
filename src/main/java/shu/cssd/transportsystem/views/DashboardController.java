package shu.cssd.transportsystem.views;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable
{
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
	
	}
	
	public void loadDashBoard(ActionEvent event) throws IOException
	{
		Parent parent = FXMLLoader.load(getClass().getResource("dashboard/Dashboard.fxml"));
		
		Scene scene = new Scene(parent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		
		window.show();
		
	}
	
	public void sayHello()
	{
		System.out.println("Hello");
	}
}
