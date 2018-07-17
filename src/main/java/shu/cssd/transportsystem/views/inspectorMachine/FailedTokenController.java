package shu.cssd.transportsystem.views.inspectorMachine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FailedTokenController implements Initializable
{
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
	
	}
	
	@FXML
	public void issueToken(ActionEvent event) throws IOException
	{
		
		Parent homeParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/issueToken/issueToken.fxml"));
		Scene homeScene = new Scene(homeParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(homeScene);
		window.show();
		
	}
}
