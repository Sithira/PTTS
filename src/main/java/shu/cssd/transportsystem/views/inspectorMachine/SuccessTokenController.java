package shu.cssd.transportsystem.views.inspectorMachine;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SuccessTokenController implements Initializable
{
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
	
	}
	
	public void goBack(MouseEvent event) throws IOException
	{
		
		Parent homeParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/home/home.fxml"));
		Scene homeScene = new Scene(homeParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(homeScene);
		window.show();
	}
}
